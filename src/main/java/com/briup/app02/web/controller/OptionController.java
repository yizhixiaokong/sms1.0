package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Option;
import com.briup.app02.service.IOptionService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/option")
public class OptionController {

	// 注入optionService的实例
	@Autowired
	private IOptionService optionService;

	// http://127.0.0.1:8080/option/findAllOption
	
	/**
	 * 查询全部
	 * @param 
	 * @return List<Option>
	 * */
	@GetMapping("findAllOption")
	public MsgResponse findAllOption() {

		try {
			List<Option> list = optionService.findAll();
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
	@GetMapping("findOptionById")
	public MsgResponse findOptionById(long id) {
		try {
			Option option = optionService.findById(id);
			return MsgResponse.success("查询成功", option);
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
	
	@GetMapping("deleteOptionById")
	public MsgResponse deleteOptionById(long id) {
		try {
			optionService.deleteById(id);
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
	@PostMapping("updateOption")
	public MsgResponse updateOption(Option option) {
		try {
			optionService.update(option);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	
	/**
	 * 保存信息
	 * @param option
	 * @return String
	 * */
	@PostMapping("saveOption")
	public MsgResponse saveOption(Option option) {
		try {	
			optionService.save(option);
			return MsgResponse.success("添加成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
