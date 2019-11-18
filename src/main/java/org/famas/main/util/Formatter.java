package org.famas.main.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import org.famas.main.model.Comments;
import org.famas.main.model.SurveyAnswer;
import org.famas.main.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Formatter {
	@Autowired
	FormService answerService;

	public Formatter() {
	}

	public Object formatter(String formData) {
		SurveyAnswer answerGiven = new SurveyAnswer();
		Comments comment;
		if (formData.contains("&")) {
			String[] data = formData.split("&");
			for (int i = 0; i < data.length; i++) {
				String[] Values = data[i].split("=");
				if(Values[0].contains("comment")) {
					if(Values.length == 1) {
						continue;
					}else {
						comment = new Comments();
						try {
							comment.setComment(URLDecoder.decode(Values[1], StandardCharsets.UTF_8.toString()));
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
						String[] commentIds = Values[0].split("C");
						answerGiven.setqId(Integer.parseInt(commentIds[1]));
						answerService.saveUserSurveyAnswer(answerGiven,comment);
					}
				}else {
					answerGiven.setqId(Integer.parseInt(Values[0]));
					if (Values[1].contains("C")) {
						String[] datass = Values[1].split("C");
						answerGiven.setaId(Integer.parseInt(datass[1]));
						answerGiven.setSubQuestionId(Integer.parseInt(datass[0]));
					} else {
						answerGiven.setaId(Integer.parseInt(Values[1]));
					}
					answerService.saveUserSurveyAnswer(answerGiven);
				}
			}
		} 
		return "Save Success!!!";

	}

}
