package org.famas.main.controller;

import java.util.List;

import org.famas.main.mapper.QuestionAnswerSaveMapper;
import org.famas.main.model.Answer;
import org.famas.main.model.Question;
import org.famas.main.model.SubQuestion;
import org.famas.main.model.UserDto;
import org.famas.main.security.CustomUserDetails;
import org.famas.main.service.FormService;
import org.famas.main.util.Formatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping
@Controller
public class FormController {

	@Autowired
	FormService formService;
	BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String surveyPage() {
		return "Surveys";
	}

	@GetMapping("/getAll")
	@ResponseBody
	public Object getMyResult() {

		return formService.getDefinedSql();
	}
	
	@GetMapping("/getAuthenticatedFname")
	@ResponseBody
	public String getAuthenticatedUserName() {
		CustomUserDetails authenticationToken = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return authenticationToken.getUser().getFirstName();
	}
	
	@GetMapping("/questionSavePage")
	public String questionAnswersSavePage() {
		return "addData";
	}
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/register")
	public String registerNewUserPage() {
		return "register";
	}
	@PostMapping("/registerNewUser")
	@ResponseBody
	public void registerNewUserWithDetails(@RequestBody UserDto st) {
		formService.saveNewUser(st);
		//return "hp";
	}
	
	@Autowired
	Formatter format;

	@PostMapping("/survey")
	@ResponseBody
	public Object saveUserSurveyAnswer(@RequestBody String surveyAnswers) {
		//return surveyAnswers;
		CustomUserDetails authen = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(!formService.hasUserAlreadySubmittedForm(authen.getUser().getId()) ) {
			formService.createNewUserSurvey(authen.getUser().getId());
			return format.formatter(surveyAnswers);
		}else {
			return "Form already submitted!!!";
		}
		

	}

	@PostMapping("/saveQuestionAnswers")
	@ResponseBody
	public Object saveQuestionAnswers(@RequestBody QuestionAnswerSaveMapper questionAnswers) {
		// Question question=(Question) format.questionAnswerFormatter(questionAnswers);
		// return formService.saveQuestionAnswers(question);
		// return question.getqDescription();
		Question question = new Question();
		question.setqDescription(questionAnswers.getQuestion());
		question.setaType(questionAnswers.getRadio());

		if (questionAnswers.getRadio().equals("multiple")) {
			/*
			 * if (questionAnswers.getAnswers() != null) { for (String ans :
			 * questionAnswers.getAnswers()) { Answer answer = new Answer();
			 * answer.setADescription(ans); question.getAnswer().add(answer); } }
			 */
			if (questionAnswers.getQuestions() != null && questionAnswers.getAnswers() != null) {
				for (String questions : questionAnswers.getQuestions()) {
					SubQuestion Subq = new SubQuestion();
					Subq.setqDescription(questions);
					for (String ans : questionAnswers.getAnswers()) {
						Answer answer = new Answer();
						answer.setaDescription(ans);
						Subq.getAnswer().add(answer);
					}
					question.getSubQuestion().add(Subq);
				}
			}
		} else {
			if (questionAnswers.getAnswers() != null) {

				for (String ans : questionAnswers.getAnswers()) {
					Answer answer = new Answer();
					answer.setaDescription(ans);
					question.getAnswer().add(answer);
				}
			}
		}
		 formService.saveQuestionAnswers(question);
		// return format.questionAnswerFormatter(questionAnswers);
		/// *
		 return question;
	}

	@GetMapping("/getUserById/{id}")
	@ResponseBody
	public Object getUserById(@PathVariable int id) {
		return formService.getUserById(id);
	}

	@GetMapping("/admin")
	public String generateSurveyAnalysis() {
		return "infograph";
	}

	@GetMapping("/adminIndividualResults/{id}")
	@ResponseBody
	public Object generateIndividualSurveyAnalysis(@PathVariable int id) {
		if(formService.hasUserAlreadySubmittedForm(id)) {
			return formService.getResultsByUserId(id);
		}
		return "User has not submitted anything!!!!!";
	}

	@GetMapping("/getAllUsers")
	@ResponseBody
	public Object getAllUsers() {
		return formService.getAllUsers();
	}

	@GetMapping("/overall")
	@ResponseBody
	public Object generateOverallResult() {
		return formService.generateOverallResult();
	}
}
