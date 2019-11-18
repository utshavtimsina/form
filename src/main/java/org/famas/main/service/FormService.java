package org.famas.main.service;

import java.util.List;

import org.famas.main.model.Answer;
import org.famas.main.model.Comments;
import org.famas.main.model.Question;
import org.famas.main.model.SubQuestion;
import org.famas.main.model.SurveyAnswer;
import org.famas.main.model.Surveys;
import org.famas.main.model.UserDto;
import org.famas.main.repo.FormRepo;
import org.famas.main.security.CustomUserDetails;
import org.jdbi.v3.core.Jdbi;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class FormService {
	Jdbi jdbi;
	FormRepo repo;

	public FormService(Jdbi jdbi) {
		// super();
		this.jdbi = jdbi;
		repo = jdbi.onDemand(FormRepo.class);
	}

	public List<Question> getDefinedSql() {
		List<Question> questions = repo.getQuestionAnswer();
		for (Question question : questions) {
			if (question.getaType().equals("multiple")) {
				for (SubQuestion subquestion : repo.getSubQuestionByQid(question.getqId())) {
					subquestion.setAnswer(repo.getSubAnswerBySubQuestionId(subquestion.getId(), question.getqId()));
					question.getSubQuestion().add(subquestion);
				}
			} else {
				question.setAnswer(repo.getAnswerByQid(question.getqId()));
			}
		}
		return questions;
	}

	public Object saveQuestionAnswers(Question questionAnswer) {
		int q_id = repo.getMaxQuestionId() + 1;
		questionAnswer.setqId(q_id);
		repo.saveQuestion(questionAnswer);

		// answerRepo.save(questionAnswer.getAnswer());
		if(questionAnswer.getaType().equals("multiple")) {
			for(SubQuestion subQ : questionAnswer.getSubQuestion()) {
				subQ.setqId(q_id);
				repo.saveSubQuestion(subQ);
				int sub_q_id = repo.getMaxSubQId();
				for (Answer answer : subQ.getAnswer()) {
					answer.setQuestion_q_id(q_id);
					answer.setSubQuestionId(sub_q_id);
					repo.saveAnswer(answer);
					// answerRepo.save(answer);
				}
			}
		}else {
			for (Answer answer : questionAnswer.getAnswer()) {
				answer.setQuestion_q_id(q_id);
				answer.setSubQuestionId(0);
				repo.saveAnswer(answer);
				// answerRepo.save(answer);
			}
		}
		
		// return null;
		return "Save Success! !!";
	}

	public void saveUserSurveyAnswer(SurveyAnswer surveyAnswer) {
		SecurityContext authentication = SecurityContextHolder.getContext();
		CustomUserDetails currentPrincipalName = (CustomUserDetails) authentication.getAuthentication().getPrincipal();
		repo.saveUserSurveyAnswer(surveyAnswer, currentPrincipalName.getUser().getId());
	}

	public Object getResultsByUserId(int id) {
		Surveys survey = repo.findByuId(id);
		List<SurveyAnswer> surveyAnswers = repo.getResultsByUserId(survey.getsId());
		Comments comment;
		///*
		List<Question> questions = repo.getQuestionAnswer();
		
		for (Question question : questions) {
			if (question.getaType().equals("multiple")) {
				List<SubQuestion> subquestion = repo.getSubQuestionByQid(question.getqId());
				Comments comments =null;
				for (SubQuestion q : subquestion) {
					for (SurveyAnswer surveyResult : surveyAnswers) {
						if (surveyResult.getSubQuestionId() == q.getId() && surveyResult.getqId() == q.getqId()) {
							q.getAnswer().add(repo.getAnswerById(surveyResult.getaId()));
							if(comments == null && surveyResult.getCommentId() > 0 ) {
								comments = new Comments();
								comments.setComment(repo.getCommentById(surveyResult.getCommentId()));
								question.setComment(comments);
							}
						}
					}
				}
				question.setSubQuestion(subquestion);
			}else {
				for (SurveyAnswer surveyResult : surveyAnswers) {
					if (surveyResult.getqId() == question.getqId()) {
						 comment = new Comments();
						  if(surveyResult.getCommentId() != 0) { 
							 
							  comment.setComment(repo.getCommentById(surveyResult.getCommentId()));
							  question.setComment(comment);
						  }
						 						
						question.getAnswer().add(repo.getAnswerById(surveyResult.getaId()));
					}
				}
			}
		}

		return questions;
		// */
		// return surveyAnswers;

	}

	public Object getAllUsers() {
		return repo.getAllUsers();
	}

	public Object generateOverallResult() {
		List<Question> questions = repo.getQuestionAnswer();
		for (Question question : questions) {
			question.getAnswer().add(repo.getAnswerById((int) repo.getModeAnswerByQid(question.getqId())));
		}
		return questions;
	}

	public UserDto getUserById(int id) {
		return repo.getUserById(id);
	}

	public void saveUserSurveyAnswer(SurveyAnswer answerGiven, Comments comment) {
		repo.saveUserComments(comment.getComment());
		SecurityContext authentication = SecurityContextHolder.getContext();
		CustomUserDetails currentPrincipalName = (CustomUserDetails) authentication.getAuthentication().getPrincipal();
		repo.updateCommentIntoDB(repo.getMaxCommentId(),currentPrincipalName.getUser().getId(),answerGiven.getqId());
	}

	public boolean hasUserAlreadySubmittedForm(int id) {
		if(repo.findByuId(id) != null) {
			return true;
		}
		return false;
	}

	public void createNewUserSurvey(int uId) {
		repo.createNewUserSurvey(uId);
	}

	public void saveNewUser(UserDto st) {
		// TODO Auto-generated method stub
		repo.saveNewUser(st);
	}

}
