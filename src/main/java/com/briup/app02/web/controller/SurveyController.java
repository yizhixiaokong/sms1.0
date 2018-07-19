package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Survey;
import com.briup.app02.service.ISurveyService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.SurveyVM;

import io.swagger.annotations.Api;


@Api(description="课调相关接口")
@RestController
@RequestMapping("/survey")
public class SurveyController {

	// 注入surveyService的实例
	@Autowired
	private ISurveyService surveyService;

	// http://127.0.0.1:8080/survey/findAllSurvey
	
	/**
	 * 查询全部
	 * @param 
	 * @return List<Survey>
	 * */
	@GetMapping("findAllSurvey")
	public MsgResponse findAllSurvey() {

		try {
			List<Survey> list = surveyService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findAllSurveyVM")
	public MsgResponse findAllSurveyVM() {

		try {
			List<SurveyVM> list = surveyService.findAllSurveyVM();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	/**
	 * 按照Id查询
	 * @param long
	 * @return Studnet;
	 * */
	@GetMapping("findSurveyById")
	public MsgResponse findSurveyById(long id) {
		try {
			Survey survey = surveyService.findById(id);
			return MsgResponse.success("查询成功", survey);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findSurveyVMById")
	public MsgResponse findSurveyVMById(long id) {
		try {
			SurveyVM surveyVM = surveyService.findSurveyVMById(id);
			return MsgResponse.success("查询成功", surveyVM);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	/**
	 * 按照Id删除
	 * @param long
	 * @return String
	 * */
	
	@GetMapping("deleteSurveyById")
	public MsgResponse deleteSurveyById(long id) {
		try {
			surveyService.deleteById(id);
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	
	/**
	 * 更新信息
	 * @param studeng
	 * @return String
	 * */
	@PostMapping("updateSurvey")
	public MsgResponse updateSurvey(Survey survey) {
		try {
			surveyService.update(survey);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	
	/**
	 * 保存信息
	 * @param survey
	 * @return String
	 * */
	@PostMapping("saveSurvey")
	public MsgResponse saveSurvey(Survey survey) {
		try {	
			surveyService.save(survey);
			return MsgResponse.success("添加成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
