package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Student;
import com.briup.app02.service.IStudentService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/student")
public class StudentController {

	// 注入studentService的实例
	@Autowired
	private IStudentService studentService;

	// http://127.0.0.1:8080/student/findAllStudent
	
	/**
	 * 查询全部学生
	 * @param 
	 * @return List<Student>
	 * */
	@GetMapping("findAllStudent")
	public MsgResponse findAllStudent() {

		try {
			List<Student> list = studentService.findAll();
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
	@GetMapping("findStudentById")
	public MsgResponse findStudentById(long id) {
		try {
			Student student = studentService.findById(id);
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
	
	@GetMapping("deleteStudentById")
	public MsgResponse deleteStudentById(long id) {
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
	 * 更新学生信息
	 * @param studeng
	 * @return String
	 * */
	@PostMapping("updateStudent")
	public MsgResponse updateStudent(Student student) {
		try {
			studentService.update(student);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	
	/**
	 * 保存学生信息
	 * @param student
	 * @return String
	 * */
	@PostMapping("saveStudent")
	public MsgResponse saveStudent(Student student) {
		try {	
			studentService.save(student);
			return MsgResponse.success("添加成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
