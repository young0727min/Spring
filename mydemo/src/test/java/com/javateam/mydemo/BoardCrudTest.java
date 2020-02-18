package com.javateam.mydemo;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.javateam.dao.MemberDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@WebAppConfiguration
public class BoardCrudTest {
	
	
	private static final Logger log = LoggerFactory.getLogger(BoardCrudTest.class);
	
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void select(int no) throws Exception{
		log.info(memberDAO.select(1).toString());
	}
	
	
}
