package com.sparta.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class HelloController {
    // api 경로는 같을 수 있지만 메서드는 중복되면 안됨
    // @RequestMapping은 api로 요청되는 것들은 이 클래스로 바로 요청 됨(중복되는 경로에 사용)
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World!!!!!";
    }

    @GetMapping("/get")
    @ResponseBody
    public String get() {
        return "GET Method 요청";
    }

    @PostMapping("/post")
    @ResponseBody
    public String post() {
        return "POST Method 요청";
    }

    @PutMapping("/put")
    @ResponseBody
    public String put() {
        return "PUT Method 요청";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String delete() {
        return "DELETE Method 요청";
    }
}
