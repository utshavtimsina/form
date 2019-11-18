package org.famas.main.mapper;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswerSaveMapper {
	private String question;
	private String radio;
	private List<String> answers;
	private List<String> questions;
	
}
