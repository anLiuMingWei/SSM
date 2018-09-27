package com.xxx.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.service.GradeService;

@Controller
public class IndexController {
	@Autowired
	private GradeService gss;
	
	@RequestMapping("/insertPeople.do")
	public String insertPeople(HttpServletRequest request,String isubject,Integer iscore) {
		request.setAttribute("result", gss.doInsertPeople(request,isubject, iscore));
		return "/showIndex.do";
	}
	
	@RequestMapping("/showIndex.do")
	public String showIndex(HttpServletRequest request) {
		request.setAttribute("grades", gss.getAllPeoples());
		return "/index.jsp";
	}
	
	@RequestMapping("/removeIndex.do")
	public String removeIndex(HttpServletRequest request,Integer id) {
		request.setAttribute("result", gss.removegrades(request, id));
		return "/showIndex.do";
	}
	
	//使用Ajax添加
	@RequestMapping(value="/indexAjax.ajax",produces="text/html; charset=UTF-8")
	public @ResponseBody String fatieByAjax(HttpServletRequest request,String isubject,Integer iscore) {
		return gss.doInsertPeople(request,isubject, iscore);
		
	}
	
	//使用Ajax显示
	@RequestMapping(value="/showGradeByAjax.ajax",produces="text/html; charset=UTF-8")
	public @ResponseBody String showIndexPageByAjax(HttpServletRequest request) {
		return gss.getGradeByJson(request);
	}
	
	//使用Ajax删除
	@RequestMapping(value="/removeIndexByAjax.ajax",produces="text/html; charset=UTF-8")
	public @ResponseBody String removeIndexByAjax(HttpServletRequest request,Integer id) {
		return gss.removegrades(request,id);
		
	}
	
	public GradeService getGss() {
		return gss;
	}

	public void setGss(GradeService gss) {
		this.gss = gss;
	}
	
}
