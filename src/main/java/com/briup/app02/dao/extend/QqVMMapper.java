package com.briup.app02.dao.extend;

import java.util.List;

import com.briup.app02.vm.QuestionVM;
import com.briup.app02.vm.QuestionnaireVM;

public interface QqVMMapper {

	// 按照Question_Id查询全部结果
	List<QuestionnaireVM> findQuestionnaireVMByQuestionId(long id);

	// 按照Questionnaire_Id查询全部结果
	List<QuestionVM> findQuestionVMByQuestionnaireId(long id);

}
