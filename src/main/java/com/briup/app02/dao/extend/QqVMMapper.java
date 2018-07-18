package com.briup.app02.dao.extend;

import java.util.List;

import com.briup.app02.vm.QqVM;

public interface QqVMMapper {

	// 按照Question_Id查询全部结果
	List<QqVM> findQqVMByQuestionId(long id);

	// 按照Questionnaire_Id查询全部结果
	List<QqVM> findQqVMByQuestionnaireId(long id);

}
