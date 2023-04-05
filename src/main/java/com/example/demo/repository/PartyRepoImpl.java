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

import com.example.demo.model.Party;

@Repository("partyrepo")
public class PartyRepoImpl implements PartyRepository {

	@Autowired
	JdbcTemplate temp;
	
	@Override
	public int saveParty(Party party) {
		// TODO Auto-generated method stub
		
		int res = temp.update("insert into tbl_party values('0',?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setString(1, party.getParty_name());
			}
		});
		return res;
	}

	@Override
	public List<Party> getAllParties() {
		// TODO Auto-generated method stub
		
		List<Party> plist = temp.query("select * from tbl_party", new RowMapper<Party>() {

			@Override
			public Party mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				Party party =new Party();
				
				party.setParty_id(rs.getLong(1));
				party.setParty_name(rs.getString(2));
				
				return party;
			}
		});
		return plist;
	}

	@Override
	public Party getPartyById(String id) {
		// TODO Auto-generated method stub
		
		Party party = temp.queryForObject("SELECT * FROM tbl_party where party_id='"+id+"'", new BeanPropertyRowMapper<Party>(Party.class));
		return party;
	}

	@Override
	public int updateParty(Party party) {
		// TODO Auto-generated method stub
		int res = temp.update("update tbl_party set party_name=? where party_id=?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setString(1, party.getParty_name());
				ps.setLong(2, party.getParty_id());
			}
		});
		return res;
	}

}
