package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Clazz;
import com.briup.app02.service.IClazzService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.ClazzVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(description="班级相关接口")
@RestController
@RequestMapping("/clazz")
public class ClazzController {

	// 注入clazzService的实例
	@Autowired
	private IClazzService clazzService;

	// http://127.0.0.1:8080/clazz/findAllClazz
	
	/**
	 * 查询全部
	 * @param 
	 * @return List<Clazz>
	 * */
	@ApiOperation(value="查询所有班级",notes="查询班级基本信息，不能查到班级和班主任")
	@GetMapping("findAllClazz")
	public MsgResponse findAllClazz() {
		try {
			List<Clazz> list = clazzService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所有班级",notes="查询班级基本信息，能查到班级和班主任")
	@GetMapping("findAllClazzVM")
	public MsgResponse findAllClazzVM() {

		try {
			List<ClazzVM> list = clazzService.findAllClazzVM();
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
	@ApiOperation(value="按ID查询班级",notes="查询班级基本信息，不能查到班级和班主任")
	@GetMapping("findClazzById")
	public MsgResponse findClazzById(long id) {
		try {
			Clazz clazz = clazzService.findById(id);
			return MsgResponse.success("查询成功", clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value="按ID查询班级",notes="查询班级基本信息，能查到班级和班主任")
	@GetMapping("findClazzVMById")
	public MsgResponse findClazzVMById(long id) {
		try {
			ClazzVM clazzVM = clazzService.findClazzVMById(id);
			return MsgResponse.success("查询成功", clazzVM);
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
	@ApiOperation(value="按ID删除班级",notes="删除班级")
	@GetMapping("deleteClazzById")
	public MsgResponse deleteClazzById(long id) {
		try {
			clazzService.deleteById(id);
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
	@ApiOperation(value="更新班级",notes="更新班级基本信息")
	@PostMapping("updateClazz")
	public MsgResponse updateClazz(Clazz clazz) {
		try {
			clazzService.update(clazz);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	
	/**
	 * 保存信息
	 * @param clazz
	 * @return String
	 * */
	@ApiOperation(value="添加班级",notes="添加一个新的班级")
	@PostMapping("saveClazz")
	public MsgResponse saveClazz(Clazz clazz) {
		try {	
			clazzService.save(clazz);
			return MsgResponse.success("添加成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
