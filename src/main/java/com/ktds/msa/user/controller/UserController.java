package com.ktds.msa.user.controller;

import java.net.URI;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.ktds.msa.user.common.exception.UserNotFoundException;
import com.ktds.msa.user.domain.User;
import com.ktds.msa.user.service.UserService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService service;



    @GetMapping("/{username}")
    public ResponseEntity<User> query1(@PathVariable String tenantId, @PathVariable String cpcd, @PathVariable String username) throws InterruptedException {

        logger.info("Sleuth Test");
        //sleuthService.doSomeWorkNewSpan();
      
        return service.queryById(username)
                .map(ResponseEntity::ok)
                .orElseThrow(()-> new UserNotFoundException(username));
    }

    @PostMapping()
    public ResponseEntity<User> save(@RequestBody User user) {
        User newUser = service.save(user);

        URI uri = MvcUriComponentsBuilder.fromController(getClass())
                .path("/{id}")
                .buildAndExpand(user.getUserName())
                .toUri();

        return ResponseEntity.created(uri).body(newUser);
    }

    @PutMapping("/{username}")
    public ResponseEntity<User> edit(@PathVariable String username, @RequestBody User user) {
        return service.queryById(username)
                .map(u->{
                    User newUser = service.save(new User(user.getUserName(),user.getUserName(), user.getUserPass()));

                    URI selfLink = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().toUriString());
                    return ResponseEntity.created(selfLink).body(newUser);
                }).orElseThrow(()->new UserNotFoundException(username));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<User> removeUser(@PathVariable  String username) {
        service.removeByUserId(username);
        return ResponseEntity.noContent().build();
    }




}
