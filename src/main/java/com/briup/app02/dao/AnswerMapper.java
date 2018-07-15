package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Answer;

public interface AnswerMapper {
	// 查询所有
	List<Answer> findAll();

	// 按照id查询
	Answer findById(long id);

	// 按照id删除
	void deleteById(long id);

	// 更新信息
	void update(Answer answer);

	// 添加
	void save(Answer answer);
}
