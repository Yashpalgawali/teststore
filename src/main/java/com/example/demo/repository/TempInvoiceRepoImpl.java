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


import com.example.demo.model.Temp_invoice;

@Repository("tempinvrepo")
public class TempInvoiceRepoImpl implements TempInvoiceRepository {

	@Autowired
	JdbcTemplate temp;
	
	@Override
	public int saveTempInvoice(Temp_invoice teinv) {
		// TODO Auto-generated method stub
		return temp.update("insert into tbl_temp_invoice values('0',?,?,?,?,?,?,?,?,?,?,?,?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				
				ps.setFloat(1, teinv.getCgst());
				ps.setFloat(2, teinv.getCgst_per());
				ps.setFloat(3, teinv.getSgst());
				ps.setFloat(4, teinv.getSgst_per());
				ps.setFloat(5, teinv.getIgst());
				ps.setFloat(6, teinv.getIgst_per());
				ps.setInt(7, teinv.getQty());
				ps.setInt(8, teinv.getTemp_invoice_id());
				ps.setFloat(9, teinv.getTotal());
				ps.setString(10, teinv.getUnit());
				ps.setFloat(11,teinv.getVat_per());
				ps.setLong(12,  teinv.getProd_id());
				ps.setFloat(13, teinv.getUnit_price());
				
				
			}
		});
	}

	@Override
	public List<Temp_invoice> getAllTempInvoicesByTempInvoiceId(int temp_inv_id) {
		// TODO Auto-generated method stub
		
		return temp.query("SELECT * FROM tbl_temp_invoice JOIN tbl_product ON tbl_product.prod_id=tbl_temp_invoice.prod_id where temp_invoice_id='"+temp_inv_id+"'", new RowMapper<Temp_invoice>() {
			
			@Override
			public Temp_invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				
				Temp_invoice temp = new Temp_invoice();
				
				temp.setTemp_id(rs.getInt(1));
				temp.setCgst(rs.getFloat(2));
				temp.setCgst_per(rs.getFloat(3));
				temp.setSgst(rs.getFloat(4));
				temp.setSgst_per(rs.getFloat(5));
				temp.setIgst(rs.getFloat(6));
				temp.setIgst_per(rs.getFloat(7));
				temp.setQty(rs.getInt(8));
				temp.setTemp_invoice_id(rs.getInt(9));
				temp.setTotal(rs.getFloat(10));
				temp.setUnit(rs.getString(11));
				temp.setVat_per(rs.getFloat(12));
				temp.setProd_id(rs.getInt(13));
				temp.setUnit_price(rs.getFloat(14));
								
				temp.setProd_id(rs.getInt(15));
				temp.setProd_name(rs.getString(16));
				temp.setProd_hsn(rs.getLong(17));
				temp.setProd_model_no(rs.getString(18));
				temp.setProd_unit(rs.getString(19));
				temp.setProd_price(rs.getFloat(20));
				temp.setGsttax(rs.getFloat(21));
//				temp.setCgst(rs.getFloat(22));
//				temp.setSgst(rs.getFloat(23));
//				temp.setIgst(rs.getFloat(24));
				
				
				return temp;
			}
		});
	}

	@Override
	public int updateTempInvoice(Temp_invoice teinv) {
		// TODO Auto-generated method stub
		
		return temp.update("update tbl_temp_invoice set cgst=?,cgst_per=?,sgst=?,sgst_per=?,igst=?,igst_per=?,qty=?,temp_invoice_id=?,total=?,unit=?,vat_per=?,prod_id=?,unit_price=? where temp_id=?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				
				ps.setFloat(1, teinv.getCgst());
				ps.setFloat(2, teinv.getCgst_per());
				ps.setFloat(3, teinv.getSgst());
				ps.setFloat(4, teinv.getSgst_per());
				ps.setFloat(5, teinv.getIgst());
				ps.setFloat(6, teinv.getIgst_per());
				ps.setInt(7, teinv.getQty());
				ps.setInt(8, teinv.getTemp_invoice_id());
				ps.setFloat(9, teinv.getTotal());
				ps.setString(10, teinv.getUnit());
				ps.setFloat(11,teinv.getVat_per());
				ps.setLong(12,  teinv.getProd_id());
				ps.setFloat(13, teinv.getUnit_price());
				ps.setInt(14, teinv.getTemp_id());
			}
		});
	}

	@Override
	public int getMaxTempInvoiceId() {
		// TODO Auto-generated method stub
		String res =  temp.queryForObject("select MAX(temp_invoice_id) from tbl_temp_invoice", String.class);
		
		
		if(res==null){
			return 0;
		}
		else {
			Integer result =Integer.parseInt(res);
			return result;
		}
	}

	@Override
	public int deleteTempInvoiceByTempId(String tid) {
		// TODO Auto-generated method stub
		
		int res = temp.update("DELETE FROM tbl_temp_invoice where temp_id=?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
		
				ps.setString(1, tid);
				
			}
		});
		
		return res;
	}

}
