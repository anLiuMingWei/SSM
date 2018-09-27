package com.xxx.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.xxx.mapper.GradesMapper;
import com.xxx.modal.Grades;
import com.xxx.service.GradeService;
@Service
public class GradeServiceImpl implements GradeService{
	
	@Autowired
	private GradesMapper pm;
	public String doInsertPeople(HttpServletRequest request,String isubject, Integer iscore) {
		// TODO Auto-generated method stub
		Grades gs=new Grades();
		gs.setSubject(isubject);
		gs.setScore(iscore);
		try {
			return pm.insert(gs)>0?"SUCCESS":"ERROR";
		} catch (Exception e) {
			return "ERROR";
		}
	}
	public List<Grades> getAllPeoples() {
		// TODO Auto-generated method stub
		return pm.selectAll();
	}
	public String removegrades(HttpServletRequest request,Integer id) {
		// TODO Auto-generated method stub
		try {
			
			return pm.deleteByPrimaryKey(id)>0?"SUCCESS":"ERROR";
		} catch (Exception e) {
			return "ERROR";
		}
	}
	public String getGradeByJson(HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<Grades> list = new ArrayList<Grades>();
		list = pm.selectAll();
		Gson g=new Gson();
		String json=g.toJson(list);
		
		return json;
	}

}
