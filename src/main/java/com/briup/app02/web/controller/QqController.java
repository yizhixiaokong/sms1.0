package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Qq;
import com.briup.app02.service.IQqService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.QqVM;

@RestController
@RequestMapping("/qq")
public class QqController {

	// 注入qqService的实例
	@Autowired
	private IQqService qqService;

	// http://127.0.0.1:8080/qq/findAllQq
	
	/**
	 * 查询全部
	 * @param 
	 * @return List<Qq>
	 * */
	@GetMapping("findAllQq")
	public MsgResponse findAllQq() {

		try {
			List<Qq> list = qqService.findAll();
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
	@GetMapping("findQqById")
	public MsgResponse findQqById(long id) {
		try {
			Qq qq = qqService.findById(id);
			return MsgResponse.success("查询成功", qq);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	
	@GetMapping("findQqVMByQuestionId")
	public MsgResponse findQqVMByQuestionId(long id) {
		try {
			List<QqVM> list = qqService.findQqVMByQuestionId(id);
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findQqVMByQuestionnaireId")
	public MsgResponse findQqVMByQuestionnaireId(long id) {
		try {
			List<QqVM> list = qqService.findQqVMByQuestionnaireId(id);
			return MsgResponse.success("查询成功", list);
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
	
	@GetMapping("deleteQqById")
	public MsgResponse deleteQqById(long id) {
		try {
			qqService.deleteById(id);
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
	@PostMapping("updateQq")
	public MsgResponse updateQq(Qq qq) {
		try {
			qqService.update(qq);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	
	/**
	 * 保存信息
	 * @param qq
	 * @return String
	 * */
	@PostMapping("saveQq")
	public MsgResponse saveQq(Qq qq) {
		try {	
			qqService.save(qq);
			return MsgResponse.success("添加成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
