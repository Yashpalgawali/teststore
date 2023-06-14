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

import com.example.demo.model.Product;

@Repository("prodrepo")
public class ProdRepoImpl implements ProductRepository {

	@Autowired
	JdbcTemplate temp;
	
	@Override
	public boolean isSaveProduct(Product prod) {
		// TODO Auto-generated method stub
		
		int res = temp.update("insert into tbl_product values('0',?,?,?,?,?,?,?,?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				String  pname 	 = prod.getProd_name();
				Long  	phsn 	 = prod.getProd_hsn();
				String  pmodel   = prod.getProd_model_no();
				String  punit    = prod.getProd_unit();
				float   price    = prod.getProd_price();
				float   gsttax   = prod.getGsttax();
				float   cgstper  = prod.getCgst_per();
				float   sgstper  = prod.getSgst_per();
				float   igstper  = prod.getIgst_per();
				
				
				ps.setString(1, pname);
				ps.setLong(2, phsn);
				ps.setString(3, pmodel);
				ps.setString(4, punit);
				ps.setFloat(5, price);
				ps.setFloat(6, gsttax);
				ps.setFloat(7, cgstper);
				ps.setFloat(8, sgstper);
				ps.setFloat(9, igstper);
			}
		});
		if(res > 0){
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		
		List<Product> plist = temp.query("select * from tbl_product", new RowMapper<Product>(){

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				Product prod = new Product();
				
				prod.setProd_id(rs.getLong(1));
				prod.setProd_name(rs.getString(2));
				prod.setProd_hsn(rs.getLong(3));
				prod.setProd_model_no(rs.getString(4));
				prod.setProd_unit(rs.getString(5));
				prod.setProd_price(rs.getFloat(6));
				prod.setGsttax(rs.getFloat(7));
				prod.setCgst_per(rs.getFloat(8));
				prod.setSgst_per(rs.getFloat(9));
				prod.setIgst_per(rs.getFloat(10));
				
				return prod;
			}
		});
		return plist;
	}

	@Override
	public Product getProductById(String pid) {
		// TODO Auto-generated method stub
		
		Product prod = temp.queryForObject("select * from tbl_product where prod_id='"+pid+"'",new BeanPropertyRowMapper<Product>(Product.class));
		
		if(prod!=null)
		{
			return prod;
		}
		else {
			return null;
		}
	}

	@Override
	public int updateProduct(Product prod) {
		// TODO Auto-generated method stub
		
		int res = temp.update("update tbl_product set prod_name=?,prod_hsn=?,prod_model_no=?,prod_unit=?,prod_price=?,gsttax=?,cgst_per=?,sgst_per=?,igst_per=? where prod_id=?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				String  pname 	 = prod.getProd_name();
				Long  	phsn 	 = prod.getProd_hsn();
				String  pmodel   = prod.getProd_model_no();
				String  punit    = prod.getProd_unit();
				Float   price    = prod.getProd_price();
				Float   gsttax   = prod.getGsttax();
				Float   cgstper  = prod.getCgst_per();
				Float   sgstper  = prod.getSgst_per();
				Float   igstper  = prod.getIgst_per();
				Long 	pid 	 = prod.getProd_id();
				
				ps.setString(1, pname);
				ps.setLong(2, phsn);
				ps.setString(3, pmodel);
				ps.setString(4, punit);
				ps.setFloat(5, price);
				ps.setFloat(6, gsttax);
				ps.setFloat(7, cgstper);
				ps.setFloat(8, sgstper);
				ps.setFloat(9, igstper);
				ps.setLong(10, pid);
			}
		});
		return res;
	}

	@Override
	public List<Product> getproductsbyInvoiceId(Long invid) {
		// TODO Auto-generated method stub
		return temp.query("select tbl_product.* from tbl_invoice JOIN tbl_invoice_product ON tbl_invoice_product.order_id=tbl_invoice.order_id JOIN tbl_product ON tbl_product.prod_id=tbl_invoice_product.prod_id where tbl_invoice.invoice_id="+invid, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				Product prod = new Product();
				prod.setProd_id(rs.getLong(1));
				prod.setProd_name(rs.getString(2));
				prod.setProd_hsn(rs.getLong(3));
				prod.setProd_model_no(rs.getString(4));
				prod.setProd_unit(rs.getString(5));
				prod.setProd_price(rs.getFloat(6));
				prod.setGsttax(rs.getFloat(7));
				prod.setCgst_per(rs.getFloat(8));
				prod.setSgst_per(rs.getFloat(9));
				prod.setIgst_per(10);
				
				return prod;
			}
			
		});
	}

}
