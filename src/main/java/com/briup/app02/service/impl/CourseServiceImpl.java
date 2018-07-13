package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Course;
import com.briup.app02.dao.CourseMapper;
import com.briup.app02.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	private CourseMapper courseMapper;

	@Override
	public List<Course> findAll() throws Exception {
		// 调用courseMapper查询所有课程
		List<Course> list = courseMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}else {
			throw new Exception("无课程");
		}
	}

	@Override
	public Course findById(long id) throws Exception {
		// 调用courseMapper按照id查询学生
		Course course = courseMapper.findById(id);
		if(course!=null){
			return course;
		}else {
			throw new Exception("课程不存在");
		}
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		
		Course course = courseMapper.findById(id);
		if(course!=null){
			// 调用courseMapper按照id删除学生
			courseMapper.deleteById(id);
		}
		else {
			throw new Exception("删除的课程不存在");
		}
		

	}

	@Override
	public void update(Course course) throws Exception {
		Course _course = courseMapper.findById(course.getId());
		if(_course!=null){
			// 调用courseMapper更新学生信息
			courseMapper.update(course);
		}else{
			throw new Exception("课程不存在");
		}
		
	}

	@Override
	public void save(Course course) throws Exception {
		// 调用courseMapper添加学生
		courseMapper.save(course);
	}

}
