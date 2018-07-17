package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Question;
import com.briup.app02.service.IQuestionService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.QuestionVM;

@RestController
@RequestMapping("/question")
public class QuestionController {

	// 注入questionService的实例
	@Autowired
	private IQuestionService questionService;

	// http://127.0.0.1:8080/question/findAllQuestion

	/**
	 * 查询全部
	 * 
	 * @param
	 * @return List<Question>
	 */
	@GetMapping("findAllQuestion")
	public MsgResponse findAllQuestion() {

		try {
			List<Question> list = questionService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findAllQuestionVM")
	public MsgResponse findAllQuestionVM() {

		try {
			List<QuestionVM> list = questionService.findAllQuestionVM();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 按照Id查询
	 * 
	 * @param long
	 * @return Studnet;
	 */
	@GetMapping("findQuestionById")
	public MsgResponse findQuestionById(long id) {
		try {
			Question question = questionService.findById(id);
			return MsgResponse.success("查询成功", question);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 按照Id删除
	 * 
	 * @param long
	 * @return String
	 */

	@GetMapping("deleteQuestionById")
	public MsgResponse deleteQuestionById(long id) {
		try {
			questionService.deleteById(id);
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 更新信息
	 * 
	 * @param studeng
	 * @return String
	 */
	@PostMapping("updateQuestion")
	public MsgResponse updateQuestion(Question question) {
		try {
			questionService.update(question);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	/**
	 * 保存信息
	 * 
	 * @param question
	 * @return String
	 */
	@PostMapping("saveQuestion")
	public MsgResponse saveQuestion(Question question) {
		try {
			questionService.save(question);
			return MsgResponse.success("添加成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
