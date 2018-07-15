package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.School;

public interface SchoolMapper {
	// 查询所有
	List<School> findAll();

	// 按照id查询
	School findById(long id);

	// 按照id删除
	void deleteById(long id);

	// 更新信息
	void update(School school);

	// 添加
	void save(School school);
}
