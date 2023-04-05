package com.example.demo.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;
import com.example.demo.model.Invoice;
import com.example.demo.model.Invoice_Product;
import com.example.demo.model.Product;

@Repository("invrepo")
public class InvoiceRepoImpl implements InvoiceRepository {

	@Autowired
	JdbcTemplate temp;

	@Override
	public int saveInvoice(Invoice inv) {
		// TODO Auto-generated method stub
		return temp.update("insert into tbl_invoice values('0',?,?,?,?,?,?,?,?,?,?,?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setFloat(1, inv.getOrder_id());
				ps.setFloat(2, inv.getInvoice_no());
				ps.setString(3, inv.getPrefix());
				ps.setString(4, inv.getStore_name());
				ps.setString(5, inv.getStore_url());
				ps.setFloat(6, inv.getTotal_amount());
				
				ps.setDate(7, inv.getDate_added());
				ps.setDate(8, inv.getUpdated_date());
				ps.setString(9, inv.getVehicle());
				ps.setString(10, inv.getBatch_no());
				ps.setString(11, inv.getOrderponumber());
				ps.setLong(12, inv.getCustomer_id());
			}
		});
	}

	@Override
	public Integer getMaxInvoiceNumber() {
		// TODO Auto-generated method stub
		
		return temp.queryForObject("select MAX(invoice_no) FROM tbl_invoice", Integer.class);
	}

	@Override
	public List<Invoice> getAllInvoices() {
		// TODO Auto-generated method stub
		return temp.query("SELECT * FROM tbl_invoice JOIN tbl_customer ON tbl_customer.cust_id=tbl_invoice.cust_id", new RowMapper<Invoice>() {

			@Override
			public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				Invoice invoice = new Invoice();
				
				invoice.setInvoice_id(rs.getLong(1));
				invoice.setOrder_id(rs.getLong(2));
				invoice.setInvoice_no(rs.getLong(3));
				invoice.setPrefix(rs.getString(4));
				invoice.setStore_name(rs.getString(5));
				invoice.setStore_name(rs.getString(6));
				invoice.setTotal_amount(rs.getFloat(7));
				invoice.setDate_added(rs.getDate(8));
				invoice.setUpdated_date(rs.getDate(9));
				invoice.setVehicle(rs.getString(10));
				invoice.setBatch_no(rs.getString(11));
				invoice.setOrderponumber(rs.getString(12));
				
				Customer cust = new Customer();
				
				cust.setCust_id(rs.getLong(13));
				cust.setCust_first_name(rs.getString(15));
				cust.setCust_last_name(rs.getString(16));
				cust.setCust_email(rs.getString(17));
				
				cust.setCust_contact(rs.getLong(18));
				cust.setCust_address(rs.getString(19));
				cust.setState_name(rs.getString(20));
				cust.setCity_name(rs.getString(21));
				cust.setPincode(rs.getLong(22));
				cust.setCust_gst(rs.getString(23));
				cust.setCust_country(rs.getString(24));
				
				invoice.setCustomer(cust);
				
				return invoice;
			}
		});
	}

	@Override
	public Invoice getInvoiceByInvoiceId(String id) {
		// TODO Auto-generated method stub
		return temp.queryForObject("SELECT * FROM tbl_invoice JOIN tbl_customer ON tbl_customer.cust_id=tbl_invoice.cust_id where invoice_id='"+id+"'", new BeanPropertyRowMapper<Invoice>(Invoice.class));
	}

	@Override
	public  List<Invoice>  viewInvoiceByIdToPrint(String invid) {
		// TODO Auto-generated method stub
		
		
		return temp.query("SELECT * FROM tbl_invoice JOIN tbl_customer ON tbl_customer.cust_id=tbl_invoice.cust_id where tbl_invoice.invoice_id='"+invid+"'", new RowMapper<Invoice>() {

			@Override
			public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				Invoice invoice = new Invoice();
				
				invoice.setInvoice_id(rs.getLong(1));
				invoice.setOrder_id(rs.getLong(2));
				invoice.setInvoice_no(rs.getLong(3));
				invoice.setPrefix(rs.getString(4));
				invoice.setStore_name(rs.getString(5));
				invoice.setStore_name(rs.getString(6));
				invoice.setTotal_amount(rs.getFloat(7));
				invoice.setDate_added(rs.getDate(8));
				invoice.setUpdated_date(rs.getDate(9));
				invoice.setVehicle(rs.getString(10));
				invoice.setBatch_no(rs.getString(11));
				invoice.setOrderponumber(rs.getString(12));
				
				Customer cust = new Customer();
				
				cust.setCust_id(rs.getLong(13));
				cust.setCust_first_name(rs.getString(15));
				cust.setCust_last_name(rs.getString(16));
				cust.setCust_email(rs.getString(17));
				
				cust.setCust_contact(rs.getLong(18));
				cust.setCust_address(rs.getString(19));
				cust.setState_name(rs.getString(20));
				cust.setCity_name(rs.getString(21));
				cust.setPincode(rs.getLong(22));
				cust.setCust_gst(rs.getString(23));
				cust.setCust_country(rs.getString(24));
				
				
				invoice.setCustomer(cust);
				
				return invoice;
			}
		});
	}
	
}
