package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Survey;
import com.briup.app02.dao.SurveyMapper;
import com.briup.app02.service.ISurveyService;

@Service
public class SurveyServiceImpl implements ISurveyService {
	@Autowired
	private SurveyMapper surveyMapper;

	@Override
	public List<Survey> findAll() throws Exception {
		//hello
		// 调用surveyMapper查询所有
		List<Survey> list = surveyMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}else {
			throw new Exception("无数据");
		}
	}

	@Override
	public Survey findById(long id) throws Exception {
		// 调用surveyMapper按照id查询
		Survey survey = surveyMapper.findById(id);
		if(survey!=null){
			return survey;
		}else {
			throw new Exception("id不存在");
		}
		

	}

	@Override
	public void deleteById(long id) throws Exception {
		
		Survey survey = surveyMapper.findById(id);
		if(survey!=null){
			// 调用surveyMapper按照id删除
			surveyMapper.deleteById(id);
		}
		else {
			throw new Exception("删除的id不存在");
		}

	}

	@Override
	public void update(Survey survey) throws Exception {
		Survey _survey = surveyMapper.findById(survey.getId());
		if(_survey!=null){
			// 调用surveyMapper更新信息
			surveyMapper.update(survey);
		}else{
			throw new Exception("更新的id不存在");
		}
		

	}

	@Override
	public void save(Survey survey) throws Exception {
		// 调用surveyMapper添加
		surveyMapper.save(survey);
	}

}
