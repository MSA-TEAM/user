package com.ktds.msa.user.service;

import com.ktds.msa.user.domain.User;
import com.ktds.msa.user.repository.UserRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @HystrixCommand(commandKey = "사용자조회",fallbackMethod = "queryByDefault"
            ,threadPoolKey = "Query User", threadPoolProperties = {
            @HystrixProperty(name="coreSize", value="30"),
            @HystrixProperty(name="maxQueueSize", value="30")
    })
    public Optional<User> queryById(String userId) {
        return repository.findByUserName(userId);
    }


    @HystrixCommand(commandKey = "사용자조회2", fallbackMethod = "queryByDefault2",
            threadPoolKey = "Query User2", threadPoolProperties = {
            @HystrixProperty(name="coreSize", value="30"),
            @HystrixProperty(name="maxQueueSize", value="30")
    })
    public Optional<User> queryById2(String userId) {
        return repository.findByUserName(userId);
    }

    public Optional<User> queryByDefault(String userId) {
        return null;
    }

    public Optional<User> queryByDefault2(String userId) {
        return null;
    }


    public User save(User user) {
        return repository.save(user);
    }

    public void removeByUserId(String userId){

    }
}
