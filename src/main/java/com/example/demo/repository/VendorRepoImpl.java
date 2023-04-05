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

import com.example.demo.model.Vendor;

@Repository("vendorrepo")
public class VendorRepoImpl implements VendorRepository {

	@Autowired
	JdbcTemplate temp;
	
	@Override
	public int saveVendor(Vendor vend) {
		// TODO Auto-generated method stub
		return temp.update("insert into tbl_vendor values('0',?,?,?,?,?,?,?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
		
				ps.setString(1, vend.getVendor_name());
				ps.setString(2, vend.getVendor_email());
				ps.setLong(3, vend.getVendor_contact());
				ps.setString(4, vend.getVendor_gst());
				ps.setString(5, vend.getVendor_address());
				ps.setString(6, vend.getCity_name());
				ps.setString(7, vend.getState_name());
				ps.setLong(8, vend.getPincode());
			}
		}) ;
	}

	@Override
	public List<Vendor> getAllVendors() {
		// TODO Auto-generated method stub
		return temp.query("select * from tbl_vendor", new RowMapper<Vendor>() {

			@Override
			public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				Vendor vend = new Vendor();
				
				vend.setVendor_id(rs.getLong(1));
				vend.setVendor_name(rs.getString(2));
				vend.setVendor_email(rs.getString(3));
				vend.setVendor_contact(rs.getLong(4));
				vend.setVendor_gst(rs.getString(5));
				vend.setVendor_address(rs.getString(6));
				vend.setCity_name(rs.getString(7));
				vend.setState_name(rs.getString(8));
				vend.setPincode(rs.getLong(9));
				
				return vend;
			}
		});
	}

	@Override
	public Vendor getVendorById(String vid) {
		// TODO Auto-generated method stub
		return temp.queryForObject("select * from tbl_vendor where vendor_id='"+vid+"'", new BeanPropertyRowMapper<Vendor>(Vendor.class));
	}

	@Override
	public int updateVendor(Vendor vend) {
		// TODO Auto-generated method stub
		return temp.update("update tbl_vendor set vendor_name=?,vendor_email=?,vendor_contact=?,vendor_gst=?,vendor_address=?,city_name=?,state_name=?,pincode=? where vendor_id=?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
		
				ps.setString(1, vend.getVendor_name());
				ps.setString(2, vend.getVendor_email());
				ps.setLong(3, vend.getVendor_contact());
				ps.setString(4, vend.getVendor_gst());
				ps.setString(5, vend.getVendor_address());
				ps.setString(6, vend.getCity_name());
				ps.setString(7, vend.getState_name());
				ps.setLong(8, vend.getPincode());
				ps.setLong(9, vend.getVendor_id());
			}
		}) ;
	}

}
