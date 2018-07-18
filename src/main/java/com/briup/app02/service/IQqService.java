package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.Qq;
import com.briup.app02.vm.QqVM;

public interface IQqService {

	List<Qq> findAll() throws Exception;

	Qq findById(long id) throws Exception;

	List<QqVM> findQqVMByQuestionId(long id) throws Exception;

	List<QqVM> findQqVMByQuestionnaireId(long id) throws Exception;

	void deleteById(long id) throws Exception;

	void update(Qq qq) throws Exception;

	void save(Qq qq) throws Exception;
}
