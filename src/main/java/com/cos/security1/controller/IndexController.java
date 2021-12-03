package com.cos.security1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping({"","/"})
    public String index(){
        //머스테치 기본폴더 src/main/resource/
        //뷰리솔버 설정 : templates(prefix), .mustache(suffix)
        //생략가능 왜냐면 pom.xml에 의존성을 추가했기에 기본설정으로 바껴서
        return "index";
    }
}
