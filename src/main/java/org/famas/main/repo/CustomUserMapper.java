
package org.famas.main.repo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.famas.main.model.Role;
import org.famas.main.model.UserDto;
import org.famas.main.security.CustomUserDetails;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;


public class CustomUserMapper implements RowMapper<CustomUserDetails>{

	@Override
	public CustomUserDetails map(ResultSet rs, StatementContext ctx) throws SQLException {
		UserDto user = new UserDto();
		Role role = new Role();
		role.setRole(rs.getString("role"));
		role.setId(rs.getInt("rid"));
		user.setId(rs.getInt("id"));
		user.setRoleId(rs.getInt("role_id"));
		user.setFirstName(rs.getString("firstname"));
		user.setPassword(rs.getString("password"));
		user.setUsername(rs.getString("username"));
		user.setRole(role);
		CustomUserDetails loggedInUserDetail = new CustomUserDetails(user);
		return loggedInUserDetail;
	}

}
