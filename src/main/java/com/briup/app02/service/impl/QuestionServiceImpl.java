package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Option;
import com.briup.app02.bean.Question;
import com.briup.app02.dao.OptionMapper;
import com.briup.app02.dao.QuestionMapper;
import com.briup.app02.dao.extend.QuestionVMMapper;
import com.briup.app02.service.IQuestionService;
import com.briup.app02.vm.QuestionVM;

@Service
public class QuestionServiceImpl implements IQuestionService {
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private QuestionVMMapper questionVMMapper;
	@Autowired
	private OptionMapper optionMapper;

	@Override
	public List<Question> findAll() throws Exception {
		// hello
		// 调用questionMapper查询所有
		List<Question> list = questionMapper.findAll();
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new Exception("无数据");
		}
	}

	@Override
	public List<QuestionVM> findAllQuestionVM() throws Exception {
		// 调用questionMapper查询所有
		List<QuestionVM> list = questionVMMapper.findAllQuestionVM();
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new Exception("无数据");
		}
	}

	@Override
	public Question findById(long id) throws Exception {
		// 调用questionMapper按照id查询
		Question question = questionMapper.findById(id);
		if (question != null) {
			return question;
		} else {
			throw new Exception("id不存在");
		}

	}
	
	@Override
	public QuestionVM findQuestionVMById(long id) throws Exception {
		// 调用questionMapper按照id查询
		QuestionVM questionVM = questionVMMapper.findQuestionVMById(id);
		if (questionVM != null) {
			return questionVM;
		} else {
			throw new Exception("id不存在");
		}

	}

	@Override
	public void deleteById(long id) throws Exception {

		Question question = questionMapper.findById(id);
		if (question != null) {
			// 调用questionMapper按照id删除
			questionMapper.deleteById(id);
		} else {
			throw new Exception("删除的id不存在");
		}

	}

	@Override
	public void update(Question question) throws Exception {
		Question _question = questionMapper.findById(question.getId());
		if (_question != null) {
			// 调用questionMapper更新信息
			questionMapper.update(question);
		} else {
			throw new Exception("更新的id不存在");
		}

	}
	
/*
	@Override
	public void save(Question question) throws Exception {
		// 调用questionMapper添加
		questionMapper.save(question);
	}
*/
	@Override
	public void save(QuestionVM questionVM) throws Exception {
		
		//剥离question option
		Long questionId = questionVM.getId();
		String questionName = questionVM.getName();
		String questionType = questionVM.getQuestiontype();
		Question question = new Question(questionId, questionName, questionType);
		
		List<Option> options = questionVM.getOptions();
		
		//保存问题
		questionMapper.save(question);
		//获取保存的问题的id
		Long question_id=question.getId();
		System.out.println("============"+question_id);
		//保存选项
		for(Option option : options){
			option.setQuestion_id(question_id);
			optionMapper.save(option);
		}
		
		
	}

}
