package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Questionnaire;
import com.briup.app02.service.IQuestionnaireService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.QuestionnaireVM;

import io.swagger.annotations.Api;


@Api(description="问卷相关接口")
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {

	// 注入questionnaireService的实例
	@Autowired
	private IQuestionnaireService questionnaireService;

	// http://127.0.0.1:8080/questionnaire/findAllQuestionnaire
	
	/**
	 * 查询全部
	 * @param 
	 * @return List<Questionnaire>
	 * */
	@GetMapping("findAllQuestionnaire")
	public MsgResponse findAllQuestionnaire() {

		try {
			List<Questionnaire> list = questionnaireService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 查询全部
	 * @param 
	 * @return List<QuestionnaireVM>
	 * */
	@GetMapping("findAllQuestionnaireVM")
	public MsgResponse findAllQuestionnaireVM() {

		try {
			List<QuestionnaireVM> list = questionnaireService.findAllQuestionnaireVM();
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
	@GetMapping("findQuestionnaireById")
	public MsgResponse findQuestionnaireById(long id) {
		try {
			Questionnaire questionnaire = questionnaireService.findById(id);
			return MsgResponse.success("查询成功", questionnaire);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findQuestionnaireVMById")
	public MsgResponse findQuestionnaireVMById(long id) {
		try {
			QuestionnaireVM questionnaireVM = questionnaireService.findQuestionnaireVMById(id);
			return MsgResponse.success("查询成功", questionnaireVM);
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
	
	@GetMapping("deleteQuestionnaireById")
	public MsgResponse deleteQuestionnaireById(long id) {
		try {
			questionnaireService.deleteById(id);
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
	@PostMapping("updateQuestionnaire")
	public MsgResponse updateQuestionnaire(Questionnaire questionnaire) {
		try {
			questionnaireService.update(questionnaire);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	
	/**
	 * 保存信息
	 * @param questionnaire
	 * @return String
	 * */
	@PostMapping("saveQuestionnaire")
	public MsgResponse saveQuestionnaire(Questionnaire questionnaire) {
		try {	
			questionnaireService.save(questionnaire);
			return MsgResponse.success("添加成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
