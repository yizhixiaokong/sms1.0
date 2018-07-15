package com.briup.app02.bean;

public class Option {
	private Long id;
	private String label;
	private String content;
	private Integer score;
	private Long qusetion_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Long getQusetion_id() {
		return qusetion_id;
	}
	public void setQusetion_id(Long qusetion_id) {
		this.qusetion_id = qusetion_id;
	}
}
