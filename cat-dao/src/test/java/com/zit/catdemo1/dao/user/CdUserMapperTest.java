package com.zit.catdemo1.dao.user;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.zit.catdemo1.dao.BaseDaoTest;
import com.zit.catdemo1.dao.domain.user.CdUser;
import com.zit.catdemo1.dao.mapper.user.CdUserMapper;

public class CdUserMapperTest extends BaseDaoTest{
	
	private static final Logger _LOG = LoggerFactory.getLogger(CdUserMapperTest.class);
	
	@Autowired
	private CdUserMapper cdUserMapper;
	
	@Test
	public void testInsert() {
		CdUser record = new CdUser();
		record.setUserAddress("上海");
		record.setUserAge(12);
		record.setUserDesc("desc描述");
		record.setUserGender(1);
		record.setUserId("458");
		record.setUserName("zhou");
		record.setUserPhone("123456789");
		int result = cdUserMapper.insert(record);
		_LOG.info("### resul={}", result);
	}
	
	@Test
	public void testQuery() {
		long start = System.currentTimeMillis();
		_LOG.info("### start={}", start);
		CdUser user = cdUserMapper.selectByPrimaryKey("456");
		long end = System.currentTimeMillis();
		_LOG.info("### end={}", end);
		long cost = (end - start);
		_LOG.info("### costtime={}", cost);
		_LOG.info("### resul={}", JSONObject.toJSONString(user));
	}
	
	@Test
	public void testUpdate() {
		
	}
	
	@Test
	public void testDelete() {
		
	}
}
