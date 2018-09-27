package com.xxx.text;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xxx.mapper.GradesMapper;
import com.xxx.service.GradeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class GradeText {
	@Autowired
	private GradeService gs;
	
	@Autowired
	private GradesMapper pm;
	
	@Test
	public void ServiceText(){
		System.out.println(gs.getGradeByJson(null));
	}

	public GradeService getGs() {
		return gs;
	}

	public void setGs(GradeService gs) {
		this.gs = gs;
	}

	public GradesMapper getPm() {
		return pm;
	}

	public void setPm(GradesMapper pm) {
		this.pm = pm;
	}
	
	
	
}
