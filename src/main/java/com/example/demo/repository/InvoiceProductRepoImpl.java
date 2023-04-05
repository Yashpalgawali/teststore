package com.example.demo.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Invoice_Product;
import com.example.demo.model.Product;

@Repository("invprodrepo")
public class InvoiceProductRepoImpl implements InvoiceProductRepository {

	@Autowired
	JdbcTemplate temp;
	
	@Override
	public int saveInvoiceProduct(Invoice_Product prod) {
		// TODO Auto-generated method stub
		return temp.update("INSERT INTO tbl_invoice_product VALUES('0',?,?,?,?,?,?,?,?,?,?,?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
			
				
				ps.setInt(1, prod.getQty());
				ps.setFloat(2, prod.getPrice());
				ps.setFloat(3, prod.getSubtotal());
				ps.setFloat(4, prod.getTotal());
				ps.setFloat(5, prod.getCgst());
				ps.setFloat(6, prod.getSgst());
				ps.setFloat(7, prod.getIgst());
				ps.setInt(8, prod.getCgst_per());
				ps.setInt(9, prod.getSgst_per());
				ps.setInt(10, prod.getIgst_per());
				ps.setFloat(11, prod.getOrder_id());
				ps.setLong(12, prod.getProd_id());
				
			}
		});
	}

	@Override
	public List<Invoice_Product> getInvoiceProdListByOrderId(String order_id) {
		// TODO Auto-generated method stub
		return temp.query("SELECT * FROM tbl_invoice_product JOIN tbl_product ON tbl_product.prod_id=tbl_invoice_product.prod_id where tbl_invoice_product.order_id='"+order_id+"'", new RowMapper<Invoice_Product>() {

			@Override
			public Invoice_Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				Invoice_Product invprod = new Invoice_Product();
				
				invprod.setInv_prod_id(rs.getInt(1));
				invprod.setQty(rs.getInt(2));
				invprod.setPrice(rs.getFloat(3));
				invprod.setSubtotal(rs.getFloat(4));
				invprod.setTotal(rs.getFloat(5));
				invprod.setCgst(rs.getFloat(6));
				invprod.setSgst(rs.getFloat(7));
				invprod.setIgst(rs.getFloat(8));
				invprod.setCgst_per(rs.getInt(9));
				invprod.setSgst_per(rs.getInt(10));
				invprod.setIgst_per(rs.getInt(11));
				invprod.setOrder_id(rs.getLong(12));
				invprod.setProd_id(rs.getLong(13));
				
				Product prod = new Product();
				
				prod.setProd_name(rs.getString(15));
				prod.setProd_hsn(rs.getLong(16));
				prod.setProd_model_no(rs.getString(17));
				prod.setProd_unit(rs.getString(18));
				prod.setProd_price(rs.getFloat(19));
				prod.setGsttax(rs.getFloat(20));
				
				
				invprod.setProduct(prod);
				
				return invprod;
			}
			
		});
	}

}
