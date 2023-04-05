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

import com.example.demo.model.Docket;

@Repository("dockreop")
public class DocketRepoImpl implements DocketRepo {

	@Autowired
	JdbcTemplate temp;
	
	@Override
	public int saveDocket(Docket dock) {
		// TODO Auto-generated method stub
		return temp.update("insert into tbl_docket values('0',?,?,?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setLong(1, dock.getDocket_num());
				ps.setLong(2, dock.getOrder_id());
				ps.setString(3, dock.getCust_name());
				ps.setLong(4, dock.getParty_id());
			}
		});
	}

	@Override
	public List<Docket> getAllDockets() {
		// TODO Auto-generated method stub
		return temp.query("select * from tbl_docket JOIN tbl_party ON tbl_party.party_id=tbl_docket.party_id", new RowMapper<Docket>() {

			@Override
			public Docket mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				Docket dock =new Docket();
				
				dock.setDocket_id(rs.getLong(1));
				dock.setDocket_num(rs.getLong(2));
				dock.setOrder_id(rs.getLong(3));
				dock.setCust_name(rs.getString(4));
				dock.setParty_id(rs.getLong(6));
				dock.setParty_name(rs.getString(7));
				
				return dock;
			}
			
		});
	}

	@Override
	public Docket getDocketById(String id) {
		// TODO Auto-generated method stub
		return temp.queryForObject("select * from tbl_docket JOIN tbl_party ON tbl_party.party_id=tbl_docket.party_id", new BeanPropertyRowMapper<Docket>(Docket.class));
	}

	@Override
	public int updateDocket(Docket dock) {
		// TODO Auto-generated method stub
			
		return temp.update("update tbl_docket set docket_num=?,order_id=?,cust_name=?,party_id=? where docket_id=?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setLong(1, dock.getDocket_num());
				ps.setLong(2, dock.getOrder_id());
				ps.setString(3, dock.getCust_name());
				ps.setLong(4, dock.getParty_id());
				ps.setLong(5, dock.getDocket_id());
			}
		});
	}

}
