package com.hzm.web;

import java.io.File;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hzm.domain.Red;
import com.hzm.service.RedPageService;

@Controller
@RequestMapping("/main")
public class RedWeb {
	@Resource(name = "redPageImpl2")
	private RedPageService rs;

	@RequestMapping("/get.action")
	public String get(String id) {

		Red r = new Red();
		r.setId(1);
		rs.getNumber(r, id);
		return "NewFile";

	}

	@RequestMapping("/main.action")
	public String main(HttpServletRequest request) {

		String realPath = request.getServletContext().getRealPath("/image/test.txt");
		File f = new File(realPath);
		return "NewFile";
	}
}
