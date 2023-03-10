package com.example.service;

import com.example.pojo.TokenEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Chenjl
 */
public interface TokenService {

    String createToken(TokenEntity tokenEntity, HttpServletRequest httpServletRequest);

    boolean booleanToken(TokenEntity tokenEntity, HttpServletRequest httpServletRequest);
}
