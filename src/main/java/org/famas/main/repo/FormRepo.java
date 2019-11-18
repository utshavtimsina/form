package org.famas.main.repo;

import java.util.List;
import java.util.Optional;

import org.famas.main.model.Answer;
import org.famas.main.model.Question;
import org.famas.main.model.SubQuestion;
import org.famas.main.model.SurveyAnswer;
import org.famas.main.model.Surveys;
import org.famas.main.model.UserDto;
import org.famas.main.security.CustomUserDetails;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.config.RegisterColumnMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;



public interface FormRepo {
	@SqlQuery("SELECT * FROM question q")
	@RegisterBeanMapper(Question.class)
	public List<Question> getQuestionAnswer();
	
	@SqlQuery("SELECT MAX(q_id) q_id FROM question ")
	@RegisterBeanMapper(Integer.class)
	public int getMaxQuestionId();
	
	@SqlQuery("SELECT * FROM answer WHERE question_q_id = :qId")
	@RegisterBeanMapper(Answer.class)
	public List<Answer> getAnswerByQid(@Bind int qId );
	
	@SqlQuery("SELECT * FROM answer WHERE a_id = :aId")
	@RegisterBeanMapper(Answer.class)
	public Answer getAnswerById(@Bind int aId );
	
	@SqlUpdate("INSERT INTO question(q_id,q_description,q_name,q_remarks,a_type) VALUES (:qId,:qDescription,:qName,:qRemarks,:aType)")
	public void saveQuestion(@BindBean Question question);
	
	@SqlUpdate("INSERT INTO answer(a_description,a_name,question_q_id,sub_question_id) VALUES(:aDescription,:aName,:question_q_id,:subQuestionId)")
	public void saveAnswer(@BindBean Answer answer);
	
	@SqlQuery("SELECT * FROM surveys WHERE u_id = :id")
	@RegisterBeanMapper(Surveys.class)
	public Surveys findByuId(@Bind int id);
	
	@SqlUpdate("INSERT INTO survey_answer(survey_s_id,a_id,q_id,remarks,sub_question_id) VALUES (:ids,:aId,:qId,:remarks,:subQuestionId)")
	public void saveUserSurveyAnswer(@BindBean SurveyAnswer ans,@Bind int ids);
	
	@SqlQuery("SELECT * FROM survey_answer WHERE survey_s_id = :sId ")
	@RegisterBeanMapper(SurveyAnswer.class)
	public List<SurveyAnswer> getResultsByUserId(@Bind int sId);
	
	@SqlQuery("SELECT * FROM surveys")
	@RegisterBeanMapper(Surveys.class)
	public List<Surveys> getAllUsers();
	
	@SqlQuery("SELECT MAX(a.count),a.a_id FROM (SELECT a_id, COUNT(a_id) count FROM survey_answer WHERE q_id =:id GROUP BY a_id ORDER BY count DESC) a")
	@RegisterColumnMapper(ModeMapper.class)
	public Object getModeAnswerByQid(int id);

	@SqlQuery("SELECT *,r.id as rid FROM user u INNER JOIN role r ON r.id = u.role_id WHERE username = :username")
	@RegisterRowMapper(value = CustomUserMapper.class)
	public CustomUserDetails loadUserByUsername(@Bind("username") String username);
	
	@SqlUpdate("INSERT INTO surveys VALUES(:id,:id)")
	public void createNewUserSurvey(int id);
	
	@SqlQuery("SELECT * FROM user WHERE id =:id")
	@RegisterBeanMapper(UserDto.class)
	public UserDto getUserById(@Bind int id);
	
	@SqlQuery("SELECT * FROM sub_question WHERE qId = :getqId")
	@RegisterBeanMapper(SubQuestion.class)
	public List<SubQuestion> getSubQuestionByQid(@Bind int getqId);

	@SqlQuery("SELECT * FROM answer WHERE  sub_question_id = :SubQid AND question_q_id = :qId ")
	@RegisterBeanMapper(Answer.class)
	public List<Answer> getSubAnswerBySubQuestionId(int SubQid, int qId);
	
	@SqlQuery("SELECT * FROM answer WHERE  sub_question_id= :subAnswer AND a_id = :aId ")
	@RegisterBeanMapper(Answer.class)
	public List<Answer> getSubAnswerBySubAnswerId(@Bind int subAnswer, @Bind int aId);
	
	@SqlUpdate("INSERT INTO sub_question(qid,q_description) VALUES(:qId,:qDescription)")
	public void saveSubQuestion(@BindBean SubQuestion subQ);
	
	@SqlQuery("SELECT MAX(id) FROM sub_question")
	@RegisterBeanMapper(Integer.class)
	public int getMaxSubQId();
	
	@SqlUpdate("INSERT INTO comments(comment) VALUES(:comment)")
	public void saveUserComments(String comment);
	
	@SqlQuery("SELECT MAX(id) FROM comments")
	public int getMaxCommentId();
	
	@SqlUpdate("INSERT INTO survey_answer(survey_s_id,a_id,q_id,remarks,sub_question_id,comment_id) VALUES (:ids,:aId,:qId,:remarks,:subQuestionId,:maxCommentId)")
	public void saveUserSurveyAnswer(SurveyAnswer surveyAnswer, int maxCommentId, int id);
	
	@SqlQuery("SELECT comment FROM comments WHERE id = :commentId ")
	public String getCommentById(int commentId);
	
	@SqlUpdate("UPDATE survey_answer SET comment_id = :maxCommentId WHERE survey_s_id = :sId AND q_id = :qId ")
	public void updateCommentIntoDB(@Bind int maxCommentId,@Bind int sId,@Bind int qId);
	
	@SqlUpdate("INSERT INTO user (username,password,firstname,role_id) VALUES(:username,:password,:firstName,2)")
	public void saveNewUser(@BindBean UserDto st);
}
