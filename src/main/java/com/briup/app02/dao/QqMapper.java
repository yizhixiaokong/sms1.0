package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Qq;

public interface QqMapper {
	// 查询所有
	List<Qq> findAll();

	// 按照id查询
	Qq findById(long id);

	// 按照id删除
	void deleteById(long id);

	// 更新信息
	void update(Qq qq);

	// 添加
	void save(Qq qq);
}
