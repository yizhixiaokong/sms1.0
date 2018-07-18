package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.Qq;
import com.briup.app02.vm.QuestionVM;
import com.briup.app02.vm.QuestionnaireVM;

public interface IQqService {

	List<Qq> findAll() throws Exception;

	Qq findById(long id) throws Exception;

	List<QuestionnaireVM> findQuestionnaireVMByQuestionId(long id) throws Exception;

	List<QuestionVM> findQuestionVMByQuestionnaireId(long id) throws Exception ;

	void deleteById(long id) throws Exception;

	void update(Qq qq) throws Exception;

	void save(Qq qq) throws Exception;
}
