package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Grade;

public interface GradeMapper {
	// 查询所有
	List<Grade> findAll();

	// 按照id查询
	Grade findById(long id);

	// 按照id删除
	void deleteById(long id);

	// 更新信息
	void update(Grade grade);

	// 添加
	void save(Grade grade);
}
