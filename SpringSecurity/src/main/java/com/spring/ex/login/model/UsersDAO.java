package com.spring.ex.login.model;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("UsersDAO")
public class UsersDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UsersDAO.class);
	
	@Autowired
	private SqlSession sqlSession;

	public UsersBean getInfo(String userId) {
		UsersBean loginInfo = new UsersBean();
		loginInfo.setUserId(userId);
		loginInfo = sqlSession.selectOne("login.getInfo", loginInfo);
		
		return loginInfo;
	}

}
