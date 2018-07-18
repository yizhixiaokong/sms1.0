package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Course;
import com.briup.app02.service.ICourseService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;


@Api(description="课程相关接口")
@RestController
@RequestMapping("/course")
public class CourseController {

	// 注入courseService的实例
	@Autowired
	private ICourseService courseService;

	// http://127.0.0.1:8080/course/findAllCourse
	
	/**
	 * 查询全部
	 * @param 
	 * @return List<Course>
	 * */
	@GetMapping("findAllCourse")
	public MsgResponse findAllCourse() {

		try {
			List<Course> list = courseService.findAll();
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
	@GetMapping("findCourseById")
	public MsgResponse findCourseById(long id) {
		try {
			Course course = courseService.findById(id);
			return MsgResponse.success("查询成功", course);
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
	
	@GetMapping("deleteCourseById")
	public MsgResponse deleteCourseById(long id) {
		try {
			courseService.deleteById(id);
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
	@PostMapping("updateCourse")
	public MsgResponse updateCourse(Course course) {
		try {
			courseService.update(course);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	
	/**
	 * 保存信息
	 * @param course
	 * @return String
	 * */
	@PostMapping("saveCourse")
	public MsgResponse saveCourse(Course course) {
		try {	
			courseService.save(course);
			return MsgResponse.success("添加成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
