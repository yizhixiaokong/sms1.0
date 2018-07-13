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

//Rest服务架构
@RestController
// 路由的命名空间(根路由)
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private ICourseService courseService;

	// http://127.0.0.1:8080/student/findAllCourse
	@GetMapping("findAllCourse")
	public MsgResponse findAllStudent() {

		try {
			List<Course> list = courseService.findAll();
			return MsgResponse.success("查詢成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findCourseById")
	public MsgResponse findCourseById(long id) {
		try {
			Course course = courseService.findById(id);
			return MsgResponse.success("查詢成功", course);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("deleteCourseById")
	public MsgResponse deleteCourseById(long id) {
		try {
			courseService.deleteById(id);
			return MsgResponse.success("删除成功", null);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@PostMapping("updateCourse")
	public MsgResponse updateCourse(Course course) {
		try {
			courseService.update(course);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@PostMapping("saveCourse")
	public MsgResponse saveCourse(Course course) {
		try {
			courseService.save(course);
			return MsgResponse.success("插入成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
