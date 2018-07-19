package com.briup.app02.vm;

import com.briup.app02.bean.Clazz;
import com.briup.app02.bean.Course;
import com.briup.app02.bean.User;

public class SurveyVM {
	private Long id;
	private String state;
	private Double average;
	private String surveydate;
	private QuestionnaireVM questionnaireVMs;
	private User user;
	private Clazz clazz;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}

	public String getSurveydate() {
		return surveydate;
	}

	public void setSurveydate(String surveydate) {
		this.surveydate = surveydate;
	}

	public QuestionnaireVM getQuestionnaireVM() {
		return questionnaireVMs;
	}

	public void setQuestionnaireVM(QuestionnaireVM questionnaireVM) {
		this.questionnaireVMs = questionnaireVM;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	private Course course;
}
