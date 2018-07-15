package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Question;

public interface QuestionMapper {
	// 查询所有
	List<Question> findAll();

	// 按照id查询
	Question findById(long id);

	// 按照id删除
	void deleteById(long id);

	// 更新信息
	void update(Question question);

	// 添加
	void save(Question question);
}
