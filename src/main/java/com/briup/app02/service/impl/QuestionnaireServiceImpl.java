package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Questionnaire;
import com.briup.app02.dao.QuestionnaireMapper;
import com.briup.app02.dao.extend.QuestionnaireVMMapper;
import com.briup.app02.service.IQuestionnaireService;
import com.briup.app02.vm.QuestionnaireVM;

@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {
	@Autowired
	private QuestionnaireMapper questionnaireMapper;
	@Autowired
	private QuestionnaireVMMapper questionnaireVMMapper;

	@Override
	public List<Questionnaire> findAll() throws Exception {
		// hello
		// 调用questionnaireMapper查询所有
		List<Questionnaire> list = questionnaireMapper.findAll();
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new Exception("无数据");
		}
	}

	@Override
	public List<QuestionnaireVM> findAllQuestionnaireVM() throws Exception {
		// 调用questionMapper查询所有
		List<QuestionnaireVM> list = questionnaireVMMapper.findAllQuestionnaireVM();
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new Exception("无数据");
		}
	}

	@Override
	public Questionnaire findById(long id) throws Exception {
		// 调用questionnaireMapper按照id查询
		Questionnaire questionnaire = questionnaireMapper.findById(id);
		if (questionnaire != null) {
			return questionnaire;
		} else {
			throw new Exception("id不存在");
		}

	}

	@Override
	public QuestionnaireVM findQuestionnaireVMById(long id) throws Exception {
		// 调用questionMapper按照id查询
		QuestionnaireVM questionnaireVM = questionnaireVMMapper.findQuestionnaireVMById(id);
		if (questionnaireVM != null) {
			return questionnaireVM;
		} else {
			throw new Exception("id不存在");
		}

	}

	@Override
	public void deleteById(long id) throws Exception {

		Questionnaire questionnaire = questionnaireMapper.findById(id);
		if (questionnaire != null) {
			// 调用questionnaireMapper按照id删除
			questionnaireMapper.deleteById(id);
		} else {
			throw new Exception("删除的id不存在");
		}

	}

	@Override
	public void update(Questionnaire questionnaire) throws Exception {
		Questionnaire _questionnaire = questionnaireMapper.findById(questionnaire.getId());
		if (_questionnaire != null) {
			// 调用questionnaireMapper更新信息
			questionnaireMapper.update(questionnaire);
		} else {
			throw new Exception("更新的id不存在");
		}

	}

	@Override
	public void save(Questionnaire questionnaire) throws Exception {
		// 调用questionnaireMapper添加
		questionnaireMapper.save(questionnaire);
	}

}
