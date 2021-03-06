package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Answer;
import com.briup.app02.service.IAnswerService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="答案相关接口")
@RestController
@RequestMapping("/answer")
public class AnswerController {

	// 注入answerService的实例
	@Autowired
	private IAnswerService answerService;

	// http://127.0.0.1:8080/answer/findAllAnswer
	
	/**
	 * 查询全部
	 * @param 
	 * @return List<Answer>
	 * */
	@ApiOperation(value="查询所有回答",notes="查询回答")
	@GetMapping("findAllAnswer")
	public MsgResponse findAllAnswer() {

		try {
			List<Answer> list = answerService.findAll();
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
	@ApiOperation(value="通过ID查询回答",notes="查询回答")
	@GetMapping("findAnswerById")
	public MsgResponse findAnswerById(long id) {
		try {
			Answer answer = answerService.findById(id);
			return MsgResponse.success("查询成功", answer);
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
	@ApiOperation(value="通过ID删除回答",notes="删除单个回答")
	@GetMapping("deleteAnswerById")
	public MsgResponse deleteAnswerById(long id) {
		try {
			answerService.deleteById(id);
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
	@ApiOperation(value="更新回答",notes="更新单个回答")
	@PostMapping("updateAnswer")
	public MsgResponse updateAnswer(Answer answer) {
		try {
			answerService.update(answer);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	
	/**
	 * 保存信息
	 * @param answer
	 * @return String
	 * */
	@ApiOperation(value="添加回答",notes="添加单个回答")
	@PostMapping("saveAnswer")
	public MsgResponse saveAnswer(Answer answer) {
		try {	
			answerService.save(answer);
			return MsgResponse.success("添加成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
