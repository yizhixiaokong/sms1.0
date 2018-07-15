package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Course;

public interface CourseMapper {
	// 查询所有
	List<Course> findAll();

	// 按照id查询
	Course findById(long id);

	// 按照id删除
	void deleteById(long id);

	// 更新信息
	void update(Course course);

	// 添加
	void save(Course course);
}
