package com.ssm.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.ssm.bean.Employee;
import com.ssm.dao.EmployeeDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public List<Employee> getAllEmployee(){
        List<Employee> emps = employeeDao.getEmps();
        return emps;
    }


}
