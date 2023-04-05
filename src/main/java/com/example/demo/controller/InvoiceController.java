package com.example.demo.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Customer;
import com.example.demo.model.Invoice;
import com.example.demo.model.Invoice_Product;
import com.example.demo.model.Product;

import com.example.demo.model.Temp_invoice;
import com.example.demo.service.CustomerService;
import com.example.demo.service.InvoiceProductService;
import com.example.demo.service.InvoiceService;
import com.example.demo.service.ProductService;
import com.example.demo.service.TempInvoiceService;


@Controller
public class InvoiceController {

	@Autowired
	ProductService prodserv;
	
	@Autowired
	TempInvoiceService tempinvserv;
	
	@Autowired
	CustomerService custserv; 
	
	@GetMapping("/addinvoice")
	public String addInvoice(Model model,HttpSession sess)
	{
		List<Temp_invoice> tilist = null;
		
		List<Product> plist= prodserv.getAllProducts();
		
		List<Customer> clist= custserv.getAllCustomers();
		
		Object tmpid = sess.getAttribute("temp_id");
		
		if(tmpid!=null)
		{
			Integer newtmpid = Integer.parseInt(tmpid.toString());
			
			if(newtmpid > 0)
			{
				tilist = tempinvserv.getAllTempInvoicesByTempInvoiceId(newtmpid);
				
				model.addAttribute("plist", plist);
				model.addAttribute("clist", clist);
				model.addAttribute("tilist", tilist);
				
				return "AddInvoice";
			}
			else {
				model.addAttribute("plist", plist);
				model.addAttribute("clist", clist);
				model.addAttribute("tilist", null);
				
				System.out.println("Temp id NULL");
				
				return "AddInvoice";
			}
	  }
	  else {
			model.addAttribute("plist", plist);
			model.addAttribute("clist", clist);
			model.addAttribute("tilist", null);
			
			System.out.println("Temp id NULL");
			
			return "AddInvoice";
		}
	}
	
	
	@RequestMapping("/savetempinvoice")
	public String saveTempInvoice(@ModelAttribute("Temp_Invoice")Temp_invoice teinv,BindingResult br , HttpSession sess,RedirectAttributes attr)
	{
		Integer chk_tmp_id=0;
				
		String sessid = (String) sess.getAttribute("temp_id");
		
		if(sessid!=null) {
			sess.setAttribute("temp_id", sessid);
		}
		else 
		{
			chk_tmp_id  = tempinvserv.getMaxTempInvoiceId();
			
			if(chk_tmp_id==0){
				chk_tmp_id=1;
				sess.setAttribute("temp_id", ""+chk_tmp_id);
			}
			else {
				chk_tmp_id  = chk_tmp_id +1;
				sess.setAttribute("temp_id", ""+chk_tmp_id);
			}
		}
			
		Integer	prod_id 	= teinv.getProd_id();
		
		Float   unit_price=0.0f;
		
		float sub_tot,cgst,sgst,igst,total;
		
		Product tem = prodserv.getProductById((String.valueOf(prod_id)));
	
		if(teinv.getUnit_price() > 0){
			unit_price = teinv.getUnit_price();
		}
		else{
			unit_price = tem.getProd_price();
		}
		
		sub_tot = unit_price * teinv.getQty();
		
		teinv.getStoption().equals("mh");
		
		if(teinv.getStoption().equals("mh"))
		{
			teinv.setCgst_per(tem.getCgst_per());
			teinv.setSgst_per( tem.getSgst_per());
			teinv.setIgst(0);
			
			cgst = Math.round((sub_tot/100) * tem.getCgst_per());
			sgst = Math.round((sub_tot/100) * tem.getSgst_per());
			igst = Math.round((sub_tot/100) * teinv.getIgst_per());
		
		}
		else
		{	
			teinv.setIgst_per(tem.getIgst_per());
			teinv.setCgst_per(0);
			teinv.setSgst_per(0);
			
			cgst = Math.round((sub_tot/100) * teinv.getCgst_per());
			sgst = Math.round((sub_tot/100) * teinv.getSgst_per());
			igst = Math.round((sub_tot/100) * tem.getIgst_per());
		}
		
		String sid = (String) sess.getAttribute("temp_id");
		
		Integer tid = Integer.parseInt(sid);
		
		teinv.setTemp_invoice_id(tid);
		teinv.setCgst(cgst);
		teinv.setSgst(sgst);
		teinv.setIgst(igst);
		
		teinv.setUnit(tem.getProd_unit());
		
		teinv.setTotal(sub_tot+cgst+sgst+igst);
		
		System.err.println("Temp_invoice_id -> "+teinv.getTemp_invoice_id()+"\nProduct Id->"+teinv.getProd_id());
		
		tempinvserv.saveTempInvoice(teinv);
		
		return "redirect:/addinvoice";
	}	
	
	
	@RequestMapping("/removeitem/{id}")@ResponseBody
	public boolean removeTemp_invoice(@PathVariable("id") String id)
	{
		int res = tempinvserv.deleteTempInvoiceByTempId(id);
		 
		if(res >0){
			//System.err.println("Temp INvoice deleted Successfully");
			return true;
		}
		else {
			return false;
		}
	}
	
	@Autowired
	InvoiceProductService invprodserv;
	
	@Autowired
	InvoiceService invserv;
	
	
	@RequestMapping("/saveinvoice")
	public String saveFinalInvoice(@ModelAttribute("Invoice")Invoice invoice, HttpSession sess, RedirectAttributes attr,Model model)
	{
		String tmp_id = (String) sess.getAttribute("temp_id");
		
		Integer temp_id = Integer.parseInt(tmp_id);
		
		List<Temp_invoice> tmplist = tempinvserv.getAllTempInvoicesByTempInvoiceId(temp_id);

		Float last_total=0.0f,sub_total=0.0f;
	 	
	 	int tid = tempinvserv.getMaxTempInvoiceId();
	 			
	 	for(int i=0;i<tmplist.size();i++)
	 	{
	 		String pid = String.valueOf(tmplist.get(i).getProd_id());
	 		Product product = prodserv.getProductById(pid);
	 		
	 		Invoice_Product invprod = new Invoice_Product();
	 		
	 		invprod.setCgst(tmplist.get(i).getCgst());
	 		invprod.setSgst(tmplist.get(i).getSgst());
	 		invprod.setIgst(tmplist.get(i).getIgst());
	 		invprod.setCgst_per((int) tmplist.get(i).getCgst_per());
	 		invprod.setSgst_per((int) tmplist.get(i).getSgst_per());
	 		invprod.setIgst_per((int) tmplist.get(i).getIgst_per());
	 		invprod.setPrice(tmplist.get(i).getUnit_price());
	 		invprod.setQty(tmplist.get(i).getQty());
	 		
	 		invprod.setSubtotal(tmplist.get(i).getQty() * tmplist.get(i).getUnit_price());
	 		invprod.setTotal(tmplist.get(i).getTotal());
	 		
	 		//invprod.setInv_prod_id(tmplist.get(i).getProd_id());
	 		
	 		Integer cint = tmplist.get(i).getProd_id();
	 		
	 		Long newpid = Long.valueOf(cint);
	 		
	 		invprod.setProd_id(newpid);
	 		
	 		Integer order_id =  tmplist.get(i).getTemp_invoice_id();
	 		String ord_id  = String.valueOf(order_id);
	 		
	 		invprod.setOrder_id((long) Integer.parseInt(ord_id));
	 		
	 		last_total = last_total + tmplist.get(i).getTotal();
	 		
	 		invprodserv.saveInvoiceProduct(invprod);
	 		
	 	}
	
	 	Integer max_inv_no =0; 
	 	
	 	max_inv_no = invserv.getMaxInvoiceNumber();
	 	
	 	if(max_inv_no!= null)
	 	{
	 		max_inv_no += 1;
	 	}	
	 	else {
	 		max_inv_no= 1;
	 	}
	 	
	 	Long maxno = Long.valueOf(max_inv_no);
	 	
	 	Date today = Date.valueOf(LocalDate.now());
	 	
	 	invoice.setDate_added(today);
	 	invoice.setTotal_amount(last_total);
	 	invoice.setInvoice_no(maxno);
	 	
	 	Long tmpid = Long.valueOf(temp_id);
	 	
	 	invoice.setOrder_id(tmpid);
	 	
	 	int final_invoice = invserv.saveInvoice(invoice);
	 	
	 	if(final_invoice> 0)
	 	{
	 		sess.removeAttribute("temp_id");
	 		return "redirect:/viewinvoices";
	 	}
	 	return "redirect:/viewinvoices";
	}
	
	@GetMapping("/viewinvoices")
	public String viewInvoices(Model model)
	{
		List<Invoice> invlist = invserv.getAllInvoices();
	
		model.addAttribute("invlist", invlist);
		return "ViewInvoices";
	}
	
	@RequestMapping("/viewinvoicetoprint/{id}")
	public String viewInvoiceById(@PathVariable("id") String id, Model model)
	{
	 	List<Invoice> invlist = invserv.viewInvoiceByIdToPrint(id);
	  		
	 	Invoice invoice = null;
	 	
	 	for(int i=0;i<invlist.size();i++){
	 		
	 		invoice = invlist.get(i);
	 	}
	 	
	 	String ordid = String.valueOf(invoice.getOrder_id());
	 	
	 	List<Invoice_Product> invprodlist = invprodserv.getInvoiceProdListByOrderId(ordid);

		Integer qtysum =0;
		Float   totsum = 0f,totstgst=0.0f,totctgst=0.0f,subtotalsum=0.0f,finaltotal=0.0f,tcgst=0.0f,tsgst=0.0f;
		
		for(int i=0;i<invprodlist.size();i++)
		{
			qtysum = qtysum + invprodlist.get(i).getQty();
			totsum = totsum + invprodlist.get(i).getTotal();
			
			subtotalsum = subtotalsum + invprodlist.get(i).getSubtotal();
			
			if(invprodlist.get(i).getCgst()!=0 || invprodlist.get(i).getCgst()!=0.0){
				
				tcgst = tcgst + invprodlist.get(i).getCgst();
				tsgst = tsgst + invprodlist.get(i).getSgst();
				
				totstgst = totstgst + invprodlist.get(i).getCgst() + invprodlist.get(i).getSgst();
			}
			else{
				totctgst = totctgst + invprodlist.get(i).getIgst() ;
			}
		}
		
		finaltotal = subtotalsum+totstgst+totctgst;
		
		System.out.println("State gst ->> "+totstgst+"\n Central Cgst->> "+totctgst);
		
	 	model.addAttribute("invoice", invoice);
	 	model.addAttribute("invprodlist", invprodlist);
	 	model.addAttribute("qtysum", qtysum);
	 	model.addAttribute("totsum", totsum);
	 	model.addAttribute("totstgst", totstgst);
	 	model.addAttribute("totctgst", totctgst);
	 	model.addAttribute("sbutotalsum", subtotalsum);
	 	model.addAttribute("finaltotal", finaltotal);
	 	model.addAttribute("tsgst", tsgst);
	 	model.addAttribute("tcgst", tcgst);
	 	
	 	return "PrintInvoice";
	}
	
	
	@RequestMapping("/editinvoicebyid/{id}")
	public String editInvoiceById(@PathVariable("id") String id, HttpSession sess ,Model model,RedirectAttributes attr)
	{
		List<Temp_invoice> tilist = null;
		List<Product> plist= prodserv.getAllProducts();
		List<Customer> clist= custserv.getAllCustomers();
		
		Invoice invoice = invserv.getInvoiceByInvoiceId(id);
		
		sess.setAttribute("temp_invoice_id", invoice.getOrder_id());
		sess.setAttribute("temp_id", id);
		
		Object tmpid = sess.getAttribute("temp_invoice_id");
		
		if(tmpid!=null)
		{
			Integer newtmpid = Integer.parseInt(tmpid.toString());
			
			if(newtmpid > 0)
			{
				tilist = tempinvserv.getAllTempInvoicesByTempInvoiceId(newtmpid); 

				model.addAttribute("plist",   plist);
				model.addAttribute("clist",   clist);
				model.addAttribute("tilist",  tilist);
				model.addAttribute("invoice", invoice);
				
				return "EditInvoice";
			}
			else
			{
				model.addAttribute("plist", plist);
				model.addAttribute("clist", clist);
				model.addAttribute("tilist", null);
				model.addAttribute("invoice", invoice);
				return "EditInvoice";
			}
	  }
		else {
			model.addAttribute("plist", plist);
			model.addAttribute("clist", clist);
			model.addAttribute("tilist", null);
			model.addAttribute("invoice", invoice);
			
			return "EditInvoice";
		}
	}
	
//	@RequestMapping("/updatetempinvoice")
//	public String updateTempInvoice(@ModelAttribute("Temp_Invoice")Temp_Invoice teinv,HttpSession sess ,RedirectAttributes attr)
//	{
//		String sessid = (String) sess.getAttribute("temp_id");
//		sess.getAttribute("temp_invoice_id");
//		
//		
//		Long 	prod_id 	= teinv.getProduct().getPid();
//		
//		Float   unit_price=0.0f;
//		
//		float sub_tot,cgst,sgst,igst;
//		
//		Product tem = prodserv.getProductById((String.valueOf(prod_id)));
//		
//		
//		if(teinv.getUnit_price() > 0){
//			unit_price = teinv.getUnit_price();
//		}
//		else{
//			unit_price = Float.parseFloat(tem.getProd_price());
//		}
//		
//		sub_tot = unit_price * teinv.getQty();
//		
//		if(teinv.getStoption().equals("mh"))
//		{
//			teinv.setCgst_per(tem.getCgst_per());
//			teinv.setSgst_per(tem.getSgst_per());
//			teinv.setIgst(0);
//		
//			cgst = Math.round((sub_tot/100) * tem.getCgst_per());
//			sgst = Math.round((sub_tot/100) * tem.getSgst_per());
//			igst = Math.round((sub_tot/100) * teinv.getIgst_per());
//		
//			System.out.println("Maharashtra state is selected \n Product PRICE=>> "+unit_price+"Product ID is---> "+teinv.getProduct().getPid()+"\n CGST-->> "+cgst+"\nSGST-->> "+sgst+"\nIGST--"+ ">> "+igst);
//		
//		}
//		else
//		{	
//			teinv.setIgst_per(tem.getIgst_per());
//			teinv.setCgst_per(0);
//			teinv.setSgst_per(0);
//			
//			cgst = Math.round((sub_tot/100) * teinv.getCgst_per());
//			sgst = Math.round((sub_tot/100) * teinv.getSgst_per());
//			igst = Math.round((sub_tot/100) * tem.getIgst_per());
//			
//			System.out.println("Other state is selected \n Product PRICE=>> "+teinv.getUnit_price() +"Product ID is---> "+teinv.getProduct().getPid()+"\n CGST-->> "+cgst+"\nSGST-->> "+sgst+"\nIGST--"
//					+ ">> "+igst);
//		}
//		
//		String sid = (String) sess.getAttribute("temp_invoice_id");
//		
//		Integer tid = Integer.parseInt(sid);
//		
//		teinv.setTemp_invoice_id(tid);
//		teinv.setCgst(cgst);
//		teinv.setSgst(sgst);
//		teinv.setIgst(igst);
//		
//		Long phsn = tem.getProd_hsn();
//		String nhsn = String.valueOf(phsn);
//		teinv.setHsn(nhsn);
//		teinv.setUnit(tem.getProd_unit());
//		
//		teinv.setTotal(sub_tot+cgst+sgst+igst);
//		
//		tempinserv.saveTempInvoice(teinv);
//		
//		return "redirect:/addinvoice";
//	}
	
}
