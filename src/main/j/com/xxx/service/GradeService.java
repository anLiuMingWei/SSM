package com.xxx.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xxx.modal.Grades;

public interface GradeService {
	String doInsertPeople(HttpServletRequest request,String isubject,Integer iscore);
	
	List<Grades> getAllPeoples();
	
	String removegrades(HttpServletRequest request,Integer id);
	
	String getGradeByJson(HttpServletRequest request);
}
