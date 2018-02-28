package com.ktds.msa.user.service;

import java.util.Optional;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.msa.user.domain.User;
import com.ktds.msa.user.repository.UserRepository2;

@Service
public class UserService1 {
    
	@Autowired
	@Resource(name="sqlSession")
	SqlSession sql_session;      

    public Optional<User> queryByEmailId(String tenantId, String cpcd, String username) {
    	UserRepository2 repository = sql_session.getMapper(UserRepository2.class);
    	Optional<User> user = repository.userInfo(tenantId, cpcd, username);
    	return user;
    }    
}
