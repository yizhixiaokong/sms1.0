package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Student;

public interface StudentMapper {
	//查询所有学生
	List<Student> findAll();
	//按照id查询
	Student findById(long id);
	//按照id删除
	void deleteById(long id);
	//更新学生信息
	void update(Student student);
	//添加学生
	void save(Student student);
}
