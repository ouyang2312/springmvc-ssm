package com.ssm.dao;

import com.ssm.bean.Employee;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao {

    public List<Employee> getEmps();

}
