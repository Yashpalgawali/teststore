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

@Repository("custrepo")
public class CustomerRepoImpl implements CustomerRepo {

	@Autowired
	JdbcTemplate temp;
	
	@Override
	public int saveCustomer(Customer cust) {
		// TODO Auto-generated method stub
		return temp.update("insert into tbl_customer values('0',?,?,?,?,?,?,?,?,?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setString(1, cust.getCust_first_name());
				ps.setString(2, cust.getCust_last_name());
				ps.setString(3, cust.getCust_email());
				ps.setLong(4, cust.getCust_contact());
				ps.setString(5, cust.getCust_address());
				ps.setString(6, cust.getState_name());
				ps.setString(7, cust.getCity_name());
				ps.setLong(8, cust.getPincode());
				ps.setString(9, cust.getCust_gst());
				ps.setString(10, cust.getCust_country());
				
			}
		});
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return temp.query("SELECT * FROM tbl_customer", new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				Customer cust =new Customer();
				
				cust.setCust_id(rs.getLong(1));
				cust.setCust_first_name(rs.getString(2));
				cust.setCust_last_name(rs.getString(3));
				cust.setCust_email(rs.getString(4));
				cust.setCust_contact(rs.getLong(5));
				cust.setCust_address(rs.getString(6));
				
				cust.setState_name(rs.getString(7));
				cust.setCity_name(rs.getString(8));
				cust.setPincode(rs.getLong(9));
				cust.setCust_gst(rs.getString(10));
				cust.setCust_country(rs.getString(11));
				
				return cust;
			}
		});
	}

	@Override
	public Customer getCustomerById(String cid) {
		// TODO Auto-generated method stub
		return temp.queryForObject("select * from tbl_customer", new BeanPropertyRowMapper<Customer>(Customer.class));
	}

	@Override
	public int updateCustomer(Customer cust) {
		// TODO Auto-generated method stub
		return temp.update("update tbl_customer set cust_first_name=?,cust_last_name=?,cust_email=?,cust_contact=?,cust_address=?,state_name=?,city_name=?,pincode=?,cust_gst=?,cust_country=? where cust_id=?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setString(1, cust.getCust_first_name());
				ps.setString(2, cust.getCust_last_name());
				ps.setString(3, cust.getCust_email());
				ps.setLong(4, cust.getCust_contact());
				ps.setString(5, cust.getCust_address());
				ps.setString(6, cust.getState_name());
				ps.setString(7, cust.getCity_name());
				ps.setLong(8, cust.getPincode());
				ps.setString(9, cust.getCust_gst());
				ps.setString(10, cust.getCust_country());
				ps.setLong(11, cust.getCust_id());
				
			}
		});
	}

}
