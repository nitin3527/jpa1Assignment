package com.jpa1.demo.repo;

import com.jpa1.demo.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
    List<Employee> findByName(String name);
    List<Employee> findByNameStartingWith(String ch);
    List<Employee> findByAgeBetween(int a, int b);
    List<Employee> findAll();
}
