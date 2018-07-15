package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Clazz;

public interface ClazzMapper {
	// 查询所有
	List<Clazz> findAll();

	// 按照id查询
	Clazz findById(long id);

	// 按照id删除
	void deleteById(long id);

	// 更新信息
	void update(Clazz clazz);

	// 添加
	void save(Clazz clazz);
}
