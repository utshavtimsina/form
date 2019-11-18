package org.famas.main.repo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.ColumnMapper;
import org.jdbi.v3.core.mapper.ColumnMappers;
import org.jdbi.v3.core.statement.StatementContext;

public class ModeMapper implements ColumnMapper<Object> {

	@Override
	public Object map(ResultSet r, int columnNumber, StatementContext ctx) throws SQLException {
		// TODO Auto-generated method stub
		return r.getInt("a_id");
	}

}
