package com.cos.security1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @GetMapping({"","/"})
    public String index(){
        //머스테치 기본폴더 src/main/resource/
        //뷰리솔버 설정 : templates(prefix), .mustache(suffix)
        //생략가능 왜냐면 pom.xml에 의존성을 추가했기에 기본설정으로 바껴서
        return "index";
    }

    @GetMapping("/user")
    public @ResponseBody String user(){
        return "user";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin(){
        return "admin";
    }

    @GetMapping("/manager")
    public @ResponseBody String manager(){
        return "manager";
    }

    //스프링 시큐리티가 낚아채버림 - SecurityConfig파일 생성후 작동안함
    @GetMapping("/login")
    public @ResponseBody String login(){
        return "login";
    }

    @GetMapping("/join")
    public @ResponseBody String join(){
        return "join";
    }

    @GetMapping("/joinProc")
    public @ResponseBody String joinProc(){
        return "회원가입완료됨!";
    }
}
