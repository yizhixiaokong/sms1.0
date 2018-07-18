package com.briup.app02.vm;

import java.util.List;

import com.briup.app02.bean.Option;
import com.briup.app02.bean.Question;
import com.briup.app02.bean.Questionnaire;

public class QqVM {
	private List<QuestionVM> questionVMs;

	public List<QuestionVM> getQuestionVMs() {
		return questionVMs;
	}

	public void setQuestionVMs(List<QuestionVM> questionVMs) {
		this.questionVMs = questionVMs;
	}

}
