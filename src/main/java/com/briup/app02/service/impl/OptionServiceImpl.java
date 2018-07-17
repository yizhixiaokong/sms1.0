package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Option;
import com.briup.app02.dao.OptionMapper;
import com.briup.app02.dao.extend.OptionVMMapper;
import com.briup.app02.service.IOptionService;
import com.briup.app02.vm.OptionVM;

@Service
public class OptionServiceImpl implements IOptionService {
	@Autowired
	private OptionMapper optionMapper;
	@Autowired
	private OptionVMMapper optionVMMapper;

	@Override
	public List<Option> findAll() throws Exception {
		//hello
		// 调用optionMapper查询所有
		List<Option> list = optionMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}else {
			throw new Exception("无数据");
		}
	}

	@Override
	public Option findById(long id) throws Exception {
		// 调用optionMapper按照id查询
		Option option = optionMapper.findById(id);
		if(option!=null){
			return option;
		}else {
			throw new Exception("id不存在");
		}
	}
	
	@Override
	public OptionVM findOptionVMById(long id) throws Exception {
		// TODO Auto-generated method stub
		OptionVM optionVM = optionVMMapper.findOptionVMById(id);
		if (optionVM != null) {
			return optionVM;
		} else {
			throw new Exception("id不存在");
		}
	}
	
	@Override
	public List<Option> findByQuestionId(long id) throws Exception {
		List<Option> list = optionMapper.findByQuestionId(id);
		if(!list.isEmpty()){
			return list;
		}else {
			throw new Exception("无数据");
		}
	}
	
	

	@Override
	public void deleteById(long id) throws Exception {
		
		Option option = optionMapper.findById(id);
		if(option!=null){
			// 调用optionMapper按照id删除
			optionMapper.deleteById(id);
		}
		else {
			throw new Exception("删除的id不存在");
		}

	}

	@Override
	public void update(Option option) throws Exception {
		Option _option = optionMapper.findById(option.getId());
		if(_option!=null){
			// 调用optionMapper更新信息
			optionMapper.update(option);
		}else{
			throw new Exception("更新的id不存在");
		}
		

	}

	@Override
	public void save(Option option) throws Exception {
		// 调用optionMapper添加
		optionMapper.save(option);
	}

	

}
