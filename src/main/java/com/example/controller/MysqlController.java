package com.example.controller;

import com.example.common.Response;
import com.example.common.ServicesMsg;
import com.example.common.ServicesStatus;
import com.example.pojo.Dept;
import com.example.pojo.Emp;
import com.example.pojo.Salgrade;
import com.example.service.MysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/mysql")
public class MysqlController {

    @Autowired
    private MysqlService service;

    @PostMapping("/test1")
    public String test1() {
        System.out.println("测试MysqlController");
        return "测试MysqlController";
    }

    @PostMapping("/emp")
    public Response<List<Emp>> emp() {
        Response<List<Emp>> response = new Response<>();
        List<Emp> list = new ArrayList<>();
        try {
            list = service.emp();
        } catch (Exception e) {
            response.setData(list);
            response.setMsg(ServicesMsg.SELECT_FAILURE);
            response.setStatus(ServicesStatus.SERVCIE_CALL_FAILURE);
            return response;
        }
        response.setTotal(list.size());
        response.setData(list);
        response.setMsg(ServicesMsg.SELECT_SUCCESS);
        response.setStatus(ServicesStatus.SERVICE_CALL_SUCCESS);
        return response;
    }

    @PostMapping("/salgrade")
    public Response<List<Salgrade>> salgrade() {
        List<Salgrade> list = new ArrayList<Salgrade>();
        Response<List<Salgrade>> response = new Response<List<Salgrade>>();
        try {
            list = service.salgrade();
        } catch (Exception e) {
            response.setData(list);
            response.setMsg(ServicesMsg.SELECT_FAILURE);
            response.setStatus(ServicesStatus.SERVCIE_CALL_FAILURE);
            return response;
        }
        response.setTotal(list.size());
        response.setData(list);
        response.setMsg(ServicesMsg.SELECT_SUCCESS);
        response.setStatus(ServicesStatus.SERVICE_CALL_SUCCESS);
        return response;
    }

    @PostMapping("/dept")
    public Response<List<Dept>> dept() {
        List<Dept> list = new ArrayList<Dept>();
        Response<List<Dept>> response = new Response<List<Dept>>();
        try {
            list = service.dept();
        } catch (Exception e) {
            response.setData(list);
            response.setMsg(ServicesMsg.SELECT_FAILURE);
            response.setStatus(ServicesStatus.SERVCIE_CALL_FAILURE);
            return response;
        }
        response.setTotal(list.size());
        response.setData(list);
        response.setMsg(ServicesMsg.SELECT_SUCCESS);
        response.setStatus(ServicesStatus.SERVICE_CALL_SUCCESS);
        return response;
    }

    @GetMapping("/job/{job}")
    public Response<List<Emp>> job(@PathVariable String job) {
        List<Emp> list = new ArrayList<>();
        Response<List<Emp>> response = new Response<>();
        try {
            list = service.job(job);
        } catch (Exception e) {
            response.setMsg(ServicesMsg.SELECT_FAILURE);
            response.setStatus(ServicesStatus.SERVCIE_CALL_FAILURE);
            response.setData(list);
            return response;
        }
        response.setTotal(list.size());
        response.setStatus(ServicesStatus.SERVICE_CALL_SUCCESS);
        response.setMsg(ServicesMsg.SELECT_SUCCESS);
        response.setData(list);
        return response;
    }

    @GetMapping("/returnCookies")
    public String returnCookies(HttpServletResponse response,@RequestParam String name){
        Cookie cookie = new Cookie("abc","123");
        cookie.setMaxAge(-1);
        response.addCookie(cookie);
        System.out.println("名字:"+name);
        return "已经添加cookies";
    }

    @GetMapping("getCookies")
    public HashMap<String,String> getCookies(HttpServletRequest request, @RequestParam String name){
        Cookie[] cookies = request.getCookies();
        HashMap<String,String> hs = new HashMap<>();
        for (Cookie c:cookies){
            hs.put(c.getName(),c.getValue());
        }
        System.out.println(hs.toString());
        return hs;
    }

}
