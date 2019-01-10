package com.ssm.contoller;

import com.ssm.bean.Employee;
import com.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EmpController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value="emps")
    public String emps(HttpServletRequest request){
        List<Employee> allEmployee = employeeService.getAllEmployee();
        request.setAttribute("lists",allEmployee);
        return "success";
    }

}
