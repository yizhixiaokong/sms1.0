package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.User;
import com.briup.app02.dao.UserMapper;
import com.briup.app02.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> findAll() throws Exception {
		//hello
		// 调用userMapper查询所有
		List<User> list = userMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}else {
			throw new Exception("无");
		}
	}

	@Override
	public User findById(long id) throws Exception {
		// 调用userMapper按照id查询
		User user = userMapper.findById(id);
		if(user!=null){
			return user;
		}else {
			throw new Exception("不存在");
		}
		

	}

	@Override
	public void deleteById(long id) throws Exception {
		
		User user = userMapper.findById(id);
		if(user!=null){
			// 调用userMapper按照id删除
			userMapper.deleteById(id);
		}
		else {
			throw new Exception("删除的不存在");
		}

	}

	@Override
	public void update(User user) throws Exception {
		User _user = userMapper.findById(user.getId());
		if(_user!=null){
			// 调用userMapper更新信息
			userMapper.update(user);
		}else{
			throw new Exception("不存在");
		}
		

	}

	@Override
	public void save(User user) throws Exception {
		// 调用userMapper添加
		userMapper.save(user);
	}

}
