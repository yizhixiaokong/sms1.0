package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.School;
import com.briup.app02.dao.SchoolMapper;
import com.briup.app02.service.ISchoolService;

@Service
public class SchoolServiceImpl implements ISchoolService {
	@Autowired
	private SchoolMapper schoolMapper;

	@Override
	public List<School> findAll() throws Exception {
		//hello
		// 调用schoolMapper查询所有
		List<School> list = schoolMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}else {
			throw new Exception("无数据");
		}
	}

	@Override
	public School findById(long id) throws Exception {
		// 调用schoolMapper按照id查询
		School school = schoolMapper.findById(id);
		if(school!=null){
			return school;
		}else {
			throw new Exception("id不存在");
		}
		

	}

	@Override
	public void deleteById(long id) throws Exception {
		
		School school = schoolMapper.findById(id);
		if(school!=null){
			// 调用schoolMapper按照id删除
			schoolMapper.deleteById(id);
		}
		else {
			throw new Exception("删除的id不存在");
		}

	}

	@Override
	public void update(School school) throws Exception {
		School _school = schoolMapper.findById(school.getId());
		if(_school!=null){
			// 调用schoolMapper更新信息
			schoolMapper.update(school);
		}else{
			throw new Exception("更新的id不存在");
		}
		
	}

	@Override
	public void save(School school) throws Exception {
		// 调用schoolMapper添加
		schoolMapper.save(school);
	}

}
