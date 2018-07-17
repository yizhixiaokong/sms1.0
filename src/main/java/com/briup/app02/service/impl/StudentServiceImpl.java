package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Student;
import com.briup.app02.dao.StudentMapper;
import com.briup.app02.service.IStudentService;




@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private StudentMapper studentMapper;

	@Override
	public List<Student> findAll() throws Exception {
		//hello
		// 调用studentMapper查询所有学生
		List<Student> list = studentMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}else {
			throw new Exception("无学生");
		}
	}

	@Override
	public Student findById(long id) throws Exception {
		// 调用studentMapper按照id查询学生
		Student student = studentMapper.findById(id);
		if(student!=null){
			return student;
		}else {
			throw new Exception("学生不存在");
		}
		

	}

	@Override
	public void deleteById(long id) throws Exception {
		
		Student student = studentMapper.findById(id);
		if(student!=null){
			// 调用studentMapper按照id删除学生
			studentMapper.deleteById(id);
		}
		else {
			throw new Exception("删除的学生不存在");
		}

	}

	@Override
	public void update(Student student) throws Exception {
		Student _student = studentMapper.findById(student.getId());
		if(_student!=null){
			// 调用studentMapper更新学生信息
			studentMapper.update(student);
		}else{
			throw new Exception("学生不存在");
		}
		

	}

	@Override
	public void save(Student student) throws Exception {
		// 调用studentMapper添加学生
		studentMapper.save(student);
	}

}
