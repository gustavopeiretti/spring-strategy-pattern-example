package com.gp.controllers;

import com.gp.model.User;
import com.gp.model.UserType;
import com.gp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<User> list() {
        List<User> users = userService.list();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<User> userById(@RequestParam(value = "id") long id) {
        User user = userService.get(id);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        User userCreated = userService.create(user);
        return new ResponseEntity(userCreated, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/change_type", method = RequestMethod.POST)
    public ResponseEntity<User> changeType(@RequestParam(value = "id") long id,
                                           @RequestParam(value = "type") UserType type) {
        User userCreated = userService.changeType(id, type);
        return new ResponseEntity(userCreated, HttpStatus.CREATED);
    }

}
