package app.rest.reststudy.controller;

import app.rest.reststudy.dto.Req;
import app.rest.reststudy.dto.User;
import org.springframework.http.HttpEntity;
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

    @PostMapping("/user-test/{userId}/name/{userName}")
    public User post(@RequestBody User user,
                     @PathVariable(value="userId") String userId,
                     @PathVariable(value = "userName") String userName
    ){
        System.out.println("user.getAge() = " + user.getAge());
        System.out.println("user.getName() = " + user.getName());
        System.out.println("userId = " + userId + ", userName = " + userName);

        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public Req<User> postMain(
            //클라이언트가 나한테 뭘보냈는지 모르겠다 싶으면 아래 타입으로 받아 본다.
            HttpEntity<String> entity,
            @RequestBody Req<User> user,
            @PathVariable(value="userId") String userId,
            @PathVariable(value="userName") String userName,
            @RequestHeader("x-authorization") String authorization,
            @RequestHeader("ucstom-header") String customHeader
    ){
        System.out.println("entity = " + entity);
        System.out.println("user = " + user);
        System.out.println("userId = " + userId);
        System.out.println("userName = " + userName);
        System.out.println("authorization = " + authorization);
        System.out.println("customHeader = " + customHeader);

        Req<User> response = new Req<>();
        response.setHeader(new Req.Header());
        response.setResBody(user.getResBody());

        return response;
    }

    @PostMapping("/user2/{userId}/name/{userName}")
    public Req<User> exchangePost(
            //클라이언트가 나한테 뭘보냈는지 모르겠다 싶으면 아래 타입으로 받아 본다.
            HttpEntity<String> entity,
            @RequestBody Req<User> user,
            @PathVariable(value="userId") String userId,
            @PathVariable(value="userName") String userName,
            @RequestHeader("x-authorization") String authorization,
            @RequestHeader("ucstom-header") String customHeader
    ){
        System.out.println("entity = " + entity);
        System.out.println("user = " + user);
        System.out.println("userId = " + userId);
        System.out.println("userName = " + userName);
        System.out.println("authorization = " + authorization);
        System.out.println("customHeader = " + customHeader);

//        Req<User> response = new Req<>();
//        response.setHeader(new Req.Header());
//        response.setResBody(user.getResBody());

        return user;
    }
}
