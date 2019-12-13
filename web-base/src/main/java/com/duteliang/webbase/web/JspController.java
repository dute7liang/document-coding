package com.duteliang.webbase.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zl
 * @Date: 2019/12/10 00:41
 */
@Controller
@RestController
public class JspController {

	@GetMapping("jsp")
	public String jsp(){
		return "hello";
	}




}
