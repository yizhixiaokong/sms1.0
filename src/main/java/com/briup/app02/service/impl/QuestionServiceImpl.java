package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Question;
import com.briup.app02.dao.QuestionMapper;
import com.briup.app02.service.IQuestionService;

@Service
public class QuestionServiceImpl implements IQuestionService {
	@Autowired
	private QuestionMapper questionMapper;

	@Override
	public List<Question> findAll() throws Exception {
		//hello
		// 调用questionMapper查询所有
		List<Question> list = questionMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}else {
			throw new Exception("无");
		}
	}

	@Override
	public Question findById(long id) throws Exception {
		// 调用questionMapper按照id查询
		Question question = questionMapper.findById(id);
		if(question!=null){
			return question;
		}else {
			throw new Exception("不存在");
		}
		

	}

	@Override
	public void deleteById(long id) throws Exception {
		
		Question question = questionMapper.findById(id);
		if(question!=null){
			// 调用questionMapper按照id删除
			questionMapper.deleteById(id);
		}
		else {
			throw new Exception("删除的不存在");
		}

	}

	@Override
	public void update(Question question) throws Exception {
		Question _question = questionMapper.findById(question.getId());
		if(_question!=null){
			// 调用questionMapper更新信息
			questionMapper.update(question);
		}else{
			throw new Exception("不存在");
		}
		

	}

	@Override
	public void save(Question question) throws Exception {
		// 调用questionMapper添加
		questionMapper.save(question);
	}

}
