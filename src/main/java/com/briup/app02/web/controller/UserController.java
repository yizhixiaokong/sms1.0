package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.User;
import com.briup.app02.service.IUserService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/student")
public class UserController {

	// 注入studentService的实例
	@Autowired
	private IUserService studentService;

	// http://127.0.0.1:8080/student/findAllUser
	
	/**
	 * 查询全部
	 * @param 
	 * @return List<User>
	 * */
	@GetMapping("findAllUser")
	public MsgResponse findAllUser() {

		try {
			List<User> list = studentService.findAll();
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
	@GetMapping("findUserById")
	public MsgResponse findUserById(long id) {
		try {
			User student = studentService.findById(id);
			return MsgResponse.success("查询成功", student);
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
	
	@GetMapping("deleteUserById")
	public MsgResponse deleteUserById(long id) {
		try {
			studentService.deleteById(id);
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
	@PostMapping("updateUser")
	public MsgResponse updateUser(User student) {
		try {
			studentService.update(student);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	
	/**
	 * 保存信息
	 * @param student
	 * @return String
	 * */
	@PostMapping("saveUser")
	public MsgResponse saveUser(User student) {
		try {	
			studentService.save(student);
			return MsgResponse.success("添加成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
