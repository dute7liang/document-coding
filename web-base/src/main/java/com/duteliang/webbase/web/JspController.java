package com.duteliang.webbase.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: zl
 * @Date: 2019/12/10 00:41
 */
@Controller
public class JspController {

	@GetMapping("jsp")
	public String jsp(){
		return "hello";
	}

}
