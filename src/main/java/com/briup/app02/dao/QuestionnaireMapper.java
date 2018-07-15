package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Questionnaire;

public interface QuestionnaireMapper {
	// 查询所有
	List<Questionnaire> findAll();

	// 按照id查询
	Questionnaire findById(long id);

	// 按照id删除
	void deleteById(long id);

	// 更新信息
	void update(Questionnaire questionnaire);

	// 添加
	void save(Questionnaire questionnaire);
}
