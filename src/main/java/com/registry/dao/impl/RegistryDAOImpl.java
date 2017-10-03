package com.registry.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.registry.dao.RegistryDAO;
import com.registry.model.User;

@Repository
public class RegistryDAOImpl implements RegistryDAO {
	
	@Autowired
	DataSource dataSource;

	@Override
	public User validateUserDetails(int employeeId) {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sql ="select employee_id ,first_name, last_name from employees where employee_id = ?";
		
		User user = jdbcTemplate.queryForObject(sql, new Object[] {employeeId}, new RowMapper<User>(){
			
			User user = new User();

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				
				user.setEmployeeId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				
				return user;
			}
			
		});
		
		System.out.println("User " + user);
		
		return user;
	}
	
	

}
