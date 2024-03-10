package app.rest.reststudy.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class User {

    private String name;
    private String age;

    public User(String name, String age){
        this.name = name;
        this.age = age;
    }
}
