package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Grade;
import com.briup.app02.dao.GradeMapper;
import com.briup.app02.service.IGradeService;

@Service
public class GradeServiceImpl implements IGradeService {
	@Autowired
	private GradeMapper gradeMapper;

	@Override
	public List<Grade> findAll() throws Exception {
		//hello
		// 调用gradeMapper查询所有
		List<Grade> list = gradeMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}else {
			throw new Exception("无");
		}
	}

	@Override
	public Grade findById(long id) throws Exception {
		// 调用gradeMapper按照id查询
		Grade grade = gradeMapper.findById(id);
		if(grade!=null){
			return grade;
		}else {
			throw new Exception("不存在");
		}
		

	}

	@Override
	public void deleteById(long id) throws Exception {
		
		Grade grade = gradeMapper.findById(id);
		if(grade!=null){
			// 调用gradeMapper按照id删除
			gradeMapper.deleteById(id);
		}
		else {
			throw new Exception("删除的不存在");
		}

	}

	@Override
	public void update(Grade grade) throws Exception {
		Grade _grade = gradeMapper.findById(grade.getId());
		if(_grade!=null){
			// 调用gradeMapper更新信息
			gradeMapper.update(grade);
		}else{
			throw new Exception("不存在");
		}
		

	}

	@Override
	public void save(Grade grade) throws Exception {
		// 调用gradeMapper添加
		gradeMapper.save(grade);
	}

}
