package com.example.demo.repository;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TaxRates;

@Repository("taxraterepo")
public class TaxRateRepoImpl implements TaxRateRepo {

	@Autowired
	JdbcTemplate temp;
	
	
	@Override
	public int saveTaxRates(TaxRates taxrate) {
		// TODO Auto-generated method stub
		return temp.update("insert into tbl_taxrates values('0',?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setFloat(1, taxrate.getTaxrate());
				ps.setString(2, taxrate.getType());
			}
		});
	}

	@Override
	public List<TaxRates> getAllTaxRates() {
		// TODO Auto-generated method stub
		return temp.query("SELECT * FROM tbl_taxrates", new RowMapper<TaxRates>() {

			@Override
			public TaxRates mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				TaxRates trate = new TaxRates();
				
				trate.setTaxrateid(rs.getLong(1));
				trate.setTaxrate(rs.getFloat(2));
				trate.setType(rs.getString(3));
				return trate;
			}
		});
	}

	@Override
	public TaxRates getTaxRateById(String id) {
		// TODO Auto-generated method stub
		
		
		List<TaxRates> tobj = temp.query("SELECT * FROM tbl_taxrates WHERE taxrateid='"+id+"'", new RowMapper<TaxRates>() {

			@Override
			public TaxRates mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				TaxRates trate = new TaxRates();
				
				trate.setTaxrateid(rs.getLong(1));
				trate.setTaxrate(rs.getFloat(2));
				trate.setType(rs.getString(3));
				return trate;
			}
		});
		
		TaxRates taxrate = null;
		
		for(int i=0;i<tobj.size();i++)
		{
			taxrate = tobj.get(i);
		}
		
		return taxrate;
	}

	@Override
	public int updateTaxRateById(TaxRates trate) {
		// TODO Auto-generated method stub
		
		Long taxid = trate.getTaxrateid(); 
		
		return temp.update("UPDATE tbl_taxrates SET taxrate=?,type=? where taxrateid='"+taxid+"'", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
			
				
				float rate = trate.getTaxrate();
				
				String type =  trate.getType();
				
				ps.setFloat(1, rate);
				ps.setString(2, type);
				
			}
		});
	}

}
