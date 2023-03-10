package com.example.serviceImpl;

import com.example.dao.MysqlMapper;
import com.example.pojo.Dept;
import com.example.pojo.Emp;
import com.example.pojo.Salgrade;
import com.example.service.MysqlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MysqlServiceImpl implements MysqlService {

	@Autowired
	private MysqlMapper mapper;

	@Override
	public List<Dept> dept() {
		List<Dept> list = mapper.dept();

		return list;
	}

	@Override
	public List<Emp> emp() {
		List<Emp> list = mapper.emp();
		return list;
	}

	@Override
	public List<Salgrade> salgrade() {
		List<Salgrade> list = mapper.salgrade();
		return list;
	}

	@Override
	public List<Emp> job(String job) {
		List<Emp> list = null;
		log.info("job  info的值:"+job);
		log.debug("job  debug的值:"+job);
		try {
			list = mapper.job(job);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
