package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Qq;
import com.briup.app02.dao.QqMapper;
import com.briup.app02.service.IQqService;

@Service
public class QqServiceImpl implements IQqService {
	@Autowired
	private QqMapper qqMapper;

	@Override
	public List<Qq> findAll() throws Exception {
		//hello
		// 调用qqMapper查询所有
		List<Qq> list = qqMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}else {
			throw new Exception("无数据");
		}
	}

	@Override
	public Qq findById(long id) throws Exception {
		// 调用qqMapper按照id查询
		Qq qq = qqMapper.findById(id);
		if(qq!=null){
			return qq;
		}else {
			throw new Exception("id不存在");
		}
		

	}

	@Override
	public void deleteById(long id) throws Exception {
		
		Qq qq = qqMapper.findById(id);
		if(qq!=null){
			// 调用qqMapper按照id删除
			qqMapper.deleteById(id);
		}
		else {
			throw new Exception("删除的id不存在");
		}

	}

	@Override
	public void update(Qq qq) throws Exception {
		Qq _qq = qqMapper.findById(qq.getId());
		if(_qq!=null){
			// 调用qqMapper更新信息
			qqMapper.update(qq);
		}else{
			throw new Exception("更新的id不存在");
		}
		

	}

	@Override
	public void save(Qq qq) throws Exception {
		// 调用qqMapper添加
		qqMapper.save(qq);
	}

}
