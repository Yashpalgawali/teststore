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

import com.example.demo.model.UserModel;

@Repository("userrepo")
public class UserRepositoryImpl implements UserModelRepository {

	
	@Autowired
	JdbcTemplate temp;
	
	@Override
	public int saveUser(UserModel model) {
		// TODO Auto-generated method stub
		
		System.err.println("inside saveuser repo");
		
		return temp.update("INSERT INTO tbl_users values('0',?,?,?,?,?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setString(1, model.getUsername());
				ps.setString(2, model.getPassword());
				ps.setString(3, model.getEmail());
				ps.setString(4, model.getUsertype());
				ps.setString(5, model.getUser_position());
				ps.setInt(6, model.getStatus());
				
			}
		});
	}

	@Override
	public List<UserModel> getAllUsers() {
		// TODO Auto-generated method stub
		return temp.query("SELECT * FROM tbl_users ", new RowMapper<UserModel>() {

			@Override
			public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				UserModel umodel = new UserModel();
				
				umodel.setUser_id(rs.getLong(1));
				umodel.setUsername(rs.getString(2));
				umodel.setPassword(rs.getString(3));
				umodel.setEmail(rs.getString(4));
				umodel.setUsertype(rs.getString(5));
				umodel.setUser_position(rs.getString(6));
				umodel.setStatus(rs.getInt(7));
				
				return umodel;
			}
		});
	}

	@Override
	public UserModel getUserById(String id) {
		// TODO Auto-generated method stub
		
		List<UserModel> ulist = temp.query("SELECT * FROM tbl_users WHERE userid='"+id+"'", new RowMapper<UserModel>() {

			@Override
			public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				UserModel umodel = new UserModel();
				
				umodel.setUser_id(rs.getLong(1));
				umodel.setUsername(rs.getString(2));
				umodel.setPassword(rs.getString(3));
				umodel.setEmail(rs.getString(4));
				umodel.setUsertype(rs.getString(5));
				umodel.setUser_position(rs.getString(6));
				umodel.setStatus(rs.getInt(7));
				
				return umodel;
			}
		});
		
		UserModel user = null;
		
		for(int i=0;i<ulist.size();i++)
		{
			user = ulist.get(i);
		}
		return user;
	}

	@Override
	public int updateUser(UserModel model) {
		// TODO Auto-generated method stub
		
		Long id = model.getUser_id();
		
		return temp.update("UPDATE tbl_users SET username=?,password=?,email=?,usertype=?,user_position=?,status=? WHERE userid='"+id+"'", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setString(1, model.getUsername());
				ps.setString(2, model.getPassword());
				ps.setString(3, model.getEmail());
				ps.setString(4, model.getUsertype());
				ps.setString(5, model.getUser_position());
				ps.setInt(6, model.getStatus());
				
			}
		});
	}

}
