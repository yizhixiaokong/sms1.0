package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.School;
import com.briup.app02.service.ISchoolService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/school")
public class SchoolController {

	// 注入schoolService的实例
	@Autowired
	private ISchoolService schoolService;

	// http://127.0.0.1:8080/school/findAllSchool
	
	/**
	 * 查询全部
	 * @param 
	 * @return List<School>
	 * */
	@GetMapping("findAllSchool")
	public MsgResponse findAllSchool() {

		try {
			List<School> list = schoolService.findAll();
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
	@GetMapping("findSchoolById")
	public MsgResponse findSchoolById(long id) {
		try {
			School school = schoolService.findById(id);
			return MsgResponse.success("查询成功", school);
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
	
	@GetMapping("deleteSchoolById")
	public MsgResponse deleteSchoolById(long id) {
		try {
			schoolService.deleteById(id);
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
	@PostMapping("updateSchool")
	public MsgResponse updateSchool(School school) {
		try {
			schoolService.update(school);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	
	/**
	 * 保存信息
	 * @param school
	 * @return String
	 * */
	@PostMapping("saveSchool")
	public MsgResponse saveSchool(School school) {
		try {	
			schoolService.save(school);
			return MsgResponse.success("添加成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
