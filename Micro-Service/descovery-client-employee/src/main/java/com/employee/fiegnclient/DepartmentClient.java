package com.employee.fiegnclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department-service", url = "http://localhost:8080/department-api") // Replace with Department Service host
public interface DepartmentClient 
{
    @GetMapping("/exist/{did}")
    Boolean isDepartmentExist(@PathVariable int did);
    
    @GetMapping("/increase_total_employees/{did}")
    void increaseEmployees(@PathVariable int did);
    
    @GetMapping("/decrease_total_employees/{did}")
    void decreaseEmployees(@PathVariable int did);
}