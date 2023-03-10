package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Chenjl
 * @date 2020/10/19 11:07
 */

@RestController
@RequestMapping("/formData")
public class FormDataController {


    //form-data
    @PostMapping("/test")
    public String formDataTest(HttpServletRequest httpServletRequest) {
        System.out.println(123123123);
        httpServletRequest.getParameter("map");
        String test="测试成功";
        return test;
    }


}
