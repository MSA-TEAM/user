package com.ktds.msa.user.controller;

import com.ktds.msa.user.common.Const;
import com.ktds.msa.user.common.exception.UserNotFoundException;
import com.ktds.msa.user.domain.User;
import com.ktds.msa.user.service.SleuthService;
import com.ktds.msa.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService service;


    @GetMapping("/{username}")
    public ResponseEntity<User> query1(@PathVariable String username) throws InterruptedException {

        logger.info("Sleuth Test");
        //sleuthService.doSomeWorkNewSpan();

        return service.queryById(username)
                .map(ResponseEntity::ok)
                .orElseThrow(()-> new UserNotFoundException(username));
    }

    @PostMapping()
    public ResponseEntity<User> save(@RequestBody User user) {
        User newUser = service.save(user);

        //URI uri = MvcUriComponentsBuilder.fromController(getClass())
        //        .path("/{id}").buildAndExpand((user.getUserName()).toUri();

        return ResponseEntity.created(uri).body(newUser);
    }

    @PutMapping("/{username}")
    public ResponseEntity<User> edit(@PathVariable String username, @RequestBody User user) {
        return service.queryById(username)
                .map(u->{
                    User newUser = service.save(new User(user.getUserName(), user.getRealName(), user.getUserPass()));

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
