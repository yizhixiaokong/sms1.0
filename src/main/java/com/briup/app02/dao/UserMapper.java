package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.User;

public interface UserMapper {
	// 查询所有
	List<User> findAll();

	// 按照id查询
	User findById(long id);

	// 按照id删除
	void deleteById(long id);

	// 更新信息
	void update(User user);

	// 添加
	void save(User user);
}
