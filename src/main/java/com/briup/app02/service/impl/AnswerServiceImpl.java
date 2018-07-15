package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Answer;
import com.briup.app02.dao.AnswerMapper;
import com.briup.app02.service.IAnswerService;

@Service
public class AnswerServiceImpl implements IAnswerService {
	@Autowired
	private AnswerMapper answerMapper;

	@Override
	public List<Answer> findAll() throws Exception {
		//hello
		// 调用answerMapper查询所有
		List<Answer> list = answerMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}else {
			throw new Exception("无");
		}
	}

	@Override
	public Answer findById(long id) throws Exception {
		// 调用answerMapper按照id查询
		Answer answer = answerMapper.findById(id);
		if(answer!=null){
			return answer;
		}else {
			throw new Exception("不存在");
		}
		

	}

	@Override
	public void deleteById(long id) throws Exception {
		
		Answer answer = answerMapper.findById(id);
		if(answer!=null){
			// 调用answerMapper按照id删除
			answerMapper.deleteById(id);
		}
		else {
			throw new Exception("删除的不存在");
		}

	}

	@Override
	public void update(Answer answer) throws Exception {
		Answer _answer = answerMapper.findById(answer.getId());
		if(_answer!=null){
			// 调用answerMapper更新信息
			answerMapper.update(answer);
		}else{
			throw new Exception("不存在");
		}
		

	}

	@Override
	public void save(Answer answer) throws Exception {
		// 调用answerMapper添加
		answerMapper.save(answer);
	}

}
