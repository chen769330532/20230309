package com.example.serviceImpl;

import com.example.pojo.TokenEntity;
import com.example.service.TokenService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Chenjl
 * @date 2020/11/20 10:39
 */
@Service
public class TokenServiceImpl implements TokenService {


    /**
     * 传递参数-->获取数据库账户密码并匹配-->生成uuid令牌-->保存到服务器session,并设置session生命-->返回uuid令牌
     * @param tokenEntity
     * @param httpServletRequest
     * @return
     */
    @Override
    public String createToken(TokenEntity tokenEntity, HttpServletRequest httpServletRequest) {
        //map 暂代数据库账户密码
        if (checkDatabsse(tokenEntity)) return "账户或密码错误";

        String uuid = UUID.randomUUID().toString();
        HttpSession session = httpServletRequest.getSession();
        String tokenName = tokenEntity.getUserName() + "Session";
        session.setAttribute(tokenName, uuid);
        //设置session会话超时时间
        session.setMaxInactiveInterval(3600);
        return uuid;
    }

    @Override
    public boolean booleanToken(TokenEntity tokenEntity, HttpServletRequest httpServletRequest) {
        if (checkDatabsse(tokenEntity)) return false;
        String tokenName = tokenEntity.getUserName() + "Session";
        HttpSession session = httpServletRequest.getSession();
        String tokenValue = (String)session.getAttribute(tokenName);
        return tokenValue.equals(tokenEntity.getToken());
    }

    private boolean checkDatabsse(TokenEntity tokenEntity) {
        Map<String, String> map = new HashMap<>(16);
        map.put("cjl", "cjl");
        if (!map.containsKey(tokenEntity.getUserName()) && !map.get(tokenEntity.getUserName()).equals(tokenEntity.getPassword())) {
            return true;
        }
        return false;
    }
}
