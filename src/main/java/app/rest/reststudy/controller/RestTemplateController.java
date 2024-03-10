package app.rest.reststudy.controller;

import app.rest.reststudy.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/server")
public class RestTemplateController {

    @GetMapping("/hello")
    public User hello(User user){
        System.out.println("name = " + user.getName());
        System.out.println("age = " + user.getAge());

        user = new User("김종순2", "30");
        System.out.println("name = " + user.getName());
        System.out.println("age = " + user.getAge());
        return user;
    }


}
