package com.example.controller;

import com.example.pojo.TokenEntity;
import com.example.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Chenjl
 * @date 2020/11/20 9:55
 */
@RestController
@RequestMapping("/test")
public class TokenController {

    @Autowired
    TokenService tokenService;

    @PostMapping("/createToken")
    public String createToken(@RequestBody TokenEntity tokenEntity, HttpServletRequest httpServletRequest,
                              HttpServletResponse httpServletResponse) {
        String s = tokenService.createToken(tokenEntity, httpServletRequest);
        return s;
    }

    @PostMapping("/booleanToken")
    public boolean booleanToken(@RequestBody TokenEntity tokenEntity, HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse) {
        return tokenService.booleanToken(tokenEntity,httpServletRequest);
    }
}
