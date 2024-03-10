package app.rest.reststudy.controller;

import app.rest.reststudy.vo.SimpleVO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestBasicController {

    @GetMapping("/getText")
    public String getText(){
        System.out.println("Hello World");
        return "Hello World";
    }

    @GetMapping(value="/getObject", produces = "application/json")
    public SimpleVO getObject(){
        SimpleVO vo = new SimpleVO(123456, "홍길동", "1");

        System.out.println("vo = " + vo);

        return vo;
    }

    @GetMapping("/getObject2")
    public Map<String, Object> getObject2(){
        Map<String, Object> map = new HashMap<>();
        SimpleVO vo = new SimpleVO(123456,"홍길동", "1");

        map.put("total",100);
        map.put("data",vo);

        System.out.println("map = " + map);

        return map;
    }

    @GetMapping("/getObject3")
    public List<SimpleVO> getObject3(){

        List<SimpleVO> list = new ArrayList<>();

        for (int i=1; i<=10; i++){
            list.add(new SimpleVO(1235+i, "홍순자"+i, "1"));

        }
        System.out.println("list = " + list);
        return list;
    }

    @GetMapping("/getKey")
    public String getKey(@RequestParam("id") String id,
                         @RequestParam("name") String name) throws UnsupportedEncodingException {
        System.out.println("id = " + id + ", name = " + name);

        return "success";
    }

    @GetMapping("/getPath/{sort}/{apiKey}")
    public String getPath(@PathVariable("sort") String sort,
                          @PathVariable("apiKey") String key){
        System.out.println("sort = " + sort + ", key = " + key);

        return "success";
    }

    @PostMapping("/getJson")
    public String getJson(@RequestBody SimpleVO vo){
        System.out.println("vo = " + vo);
        return "success";
    }

    @PostMapping("/getForm")
    public String getForm(SimpleVO vo){
        System.out.println("vo = " + vo);
        return "success";
    }

    @PostMapping("/getMap")
    public String getMap(@RequestBody Map<String, Object> map){
        System.out.println("map = " + map);
        return "success";
    }

    @PostMapping(value="/getResult", consumes = "text/plain")
    public String getResult(@RequestBody String data){
        System.out.println("data = " + data);
        return "success";
    }

    @PostMapping("/createRes")
    public ResponseEntity createRes(){

        SimpleVO vo = new SimpleVO(1234, "황길순", "1");
        System.out.println("SimpleVO 1= " + vo);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authroization", "token");

        HttpStatus httpStatus = HttpStatus.ACCEPTED; //상태코드 (성공 or 실패)

        //제네릭은 데이터를 따라 간다.
//        new ResponseEntity<>(vo, httpHeaders, httpStatus);
        ResponseEntity<SimpleVO> entity = new ResponseEntity<>(vo, httpHeaders, httpStatus);

        System.out.println("SimpleVO 2= " + entity);

        return entity;
    }
}
