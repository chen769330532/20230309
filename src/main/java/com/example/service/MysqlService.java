package com.example.service;

import com.example.pojo.Dept;
import com.example.pojo.Emp;
import com.example.pojo.Salgrade;

import java.util.List;

public interface MysqlService {

	List<Dept> dept();

	List<Emp> emp();

	List<Salgrade> salgrade();

    List<Emp> job(String job);
}
