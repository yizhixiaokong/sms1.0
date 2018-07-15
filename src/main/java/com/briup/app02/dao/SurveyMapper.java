package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Survey;

public interface SurveyMapper {
	// 查询所有
	List<Survey> findAll();

	// 按照id查询
	Survey findById(long id);

	// 按照id删除
	void deleteById(long id);

	// 更新信息
	void update(Survey survey);

	// 添加
	void save(Survey survey);
}
