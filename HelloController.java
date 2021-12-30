package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") //web application에서 /hello로 들어오면 밑의 method 호출
    public String hello(Model model){
        model.addAttribute( "data",  "hello!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name" , name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http에서 header부와 body부 존재. 응답 body부에 이 내용을 직접 넣어주는 것.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }
}
