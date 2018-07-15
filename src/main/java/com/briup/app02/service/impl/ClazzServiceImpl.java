package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Clazz;
import com.briup.app02.dao.ClazzMapper;
import com.briup.app02.service.IClazzService;

@Service
public class ClazzServiceImpl implements IClazzService {
	@Autowired
	private ClazzMapper clazzMapper;

	@Override
	public List<Clazz> findAll() throws Exception {
		//hello
		// 调用clazzMapper查询所有
		List<Clazz> list = clazzMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}else {
			throw new Exception("无");
		}
	}

	@Override
	public Clazz findById(long id) throws Exception {
		// 调用clazzMapper按照id查询
		Clazz clazz = clazzMapper.findById(id);
		if(clazz!=null){
			return clazz;
		}else {
			throw new Exception("不存在");
		}
		

	}

	@Override
	public void deleteById(long id) throws Exception {
		
		Clazz clazz = clazzMapper.findById(id);
		if(clazz!=null){
			// 调用clazzMapper按照id删除
			clazzMapper.deleteById(id);
		}
		else {
			throw new Exception("删除的不存在");
		}

	}

	@Override
	public void update(Clazz clazz) throws Exception {
		Clazz _clazz = clazzMapper.findById(clazz.getId());
		if(_clazz!=null){
			// 调用clazzMapper更新信息
			clazzMapper.update(clazz);
		}else{
			throw new Exception("不存在");
		}
		

	}

	@Override
	public void save(Clazz clazz) throws Exception {
		// 调用clazzMapper添加
		clazzMapper.save(clazz);
	}

}
