package com.zit.catdemo1.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-datasource.xml"})
public class BaseDaoTest {
	
	@Test
	public void testIsPass() {
		
	}
}
