package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Grade;
import com.briup.app02.service.IGradeService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;


@Api(description="年级相关接口")
@RestController
@RequestMapping("/grade")
public class GradeController {

	// 注入gradeService的实例
	@Autowired
	private IGradeService gradeService;

	// http://127.0.0.1:8080/grade/findAllGrade
	
	/**
	 * 查询全部
	 * @param 
	 * @return List<Grade>
	 * */
	@GetMapping("findAllGrade")
	public MsgResponse findAllGrade() {

		try {
			List<Grade> list = gradeService.findAll();
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
	@GetMapping("findGradeById")
	public MsgResponse findGradeById(long id) {
		try {
			Grade grade = gradeService.findById(id);
			return MsgResponse.success("查询成功", grade);
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
	
	@GetMapping("deleteGradeById")
	public MsgResponse deleteGradeById(long id) {
		try {
			gradeService.deleteById(id);
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
	@PostMapping("updateGrade")
	public MsgResponse updateGrade(Grade grade) {
		try {
			gradeService.update(grade);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	
	/**
	 * 保存信息
	 * @param grade
	 * @return String
	 * */
	@PostMapping("saveGrade")
	public MsgResponse saveGrade(Grade grade) {
		try {	
			gradeService.save(grade);
			return MsgResponse.success("添加成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
