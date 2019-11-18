package org.famas.main.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.famas.main.model.Answer;
import org.famas.main.model.Question;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class QuestionAnswerMapper implements RowMapper<Question> {

	@Override
	public Question map(ResultSet rs, StatementContext ctx) throws SQLException {
		// TODO Auto-generated method stub
		int q_id = rs.getInt("q_id");
		Question question = new Question();
		question.setqId(rs.getInt("q_id"));
		question.setqDescription(rs.getString("q_description"));
		question.setqName(rs.getString("q_name"));
		question.setaType(rs.getString("a_type"));
		/*Answer answer =new Answer();
		//rs.
		answer.setaId(rs.getInt("a_id"));
		answer.setaDescription(rs.getString("a_description"));
		answer.setaName(rs.getString("a_name"));
		question.setAnswer(answer);*/
		return question;
	}

}
