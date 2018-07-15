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

	
	/**
	 * 按照Id查询
	 * @param long
	 * @return Studnet;
	 * */
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

	
	/**
	 * 按照Id删除
	 * @param long
	 * @return String
	 * */
	
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
