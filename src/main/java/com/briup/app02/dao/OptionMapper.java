package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Option;

public interface OptionMapper {
	// 查询所有
	List<Option> findAll();

	// 按照id查询
	Option findById(long id);

	// 按照id删除
	void deleteById(long id);

	// 更新信息
	void update(Option option);

	// 添加
	void save(Option option);
}
