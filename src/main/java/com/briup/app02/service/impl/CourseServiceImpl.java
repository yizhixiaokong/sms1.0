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
	private CourseMapper sourseMapper;

	@Override
	public List<Course> findAll() throws Exception {
		//hello
		// 调用sourseMapper查询所有
		List<Course> list = sourseMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}else {
			throw new Exception("无");
		}
	}

	@Override
	public Course findById(long id) throws Exception {
		// 调用sourseMapper按照id查询
		Course sourse = sourseMapper.findById(id);
		if(sourse!=null){
			return sourse;
		}else {
			throw new Exception("不存在");
		}
		

	}

	@Override
	public void deleteById(long id) throws Exception {
		
		Course sourse = sourseMapper.findById(id);
		if(sourse!=null){
			// 调用sourseMapper按照id删除
			sourseMapper.deleteById(id);
		}
		else {
			throw new Exception("删除的不存在");
		}

	}

	@Override
	public void update(Course sourse) throws Exception {
		Course _sourse = sourseMapper.findById(sourse.getId());
		if(_sourse!=null){
			// 调用sourseMapper更新信息
			sourseMapper.update(sourse);
		}else{
			throw new Exception("不存在");
		}
		

	}

	@Override
	public void save(Course sourse) throws Exception {
		// 调用sourseMapper添加
		sourseMapper.save(sourse);
	}

}
