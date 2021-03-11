package com.jpa1.demo;

import com.jpa1.demo.entity.Employee;
import com.jpa1.demo.repo.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
class DemoApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate(){
		Employee emp = new Employee();
		emp.setId(1);
		emp.setAge(26);
		emp.setName("Nitin");
		emp.setLocation("India");
		employeeRepository.save(emp);
	}
	@Test
	public void testRead(){
		Employee emp = employeeRepository.findById(1).get();
		assertEquals("India",emp.getLocation());
	}
	@Test
	public void testUpdate(){
		Employee emp = employeeRepository.findById(1).get();
		emp.setAge(21);
		emp.setName("Mayank");
		employeeRepository.save(emp);
	}
	@Test
	public void testDelete(){
		employeeRepository.deleteById(1);
	}
	@Test
	public void testCount(){
		System.out.println("==================" + employeeRepository.count());
	}

	@Test
	public void testFindByName(){
		List<Employee> emp = employeeRepository.findByName("Nitin");
		emp.forEach(e -> System.out.println(e.getLocation()));
	}

	@Test
	public void testStartingWith(){
		List<Employee> emp = employeeRepository.findByNameStartingWith("N");
		emp.forEach(e -> System.out.println(e.getName()));
	}
	@Test
	public void testFindAgeBetween(){
		List<Employee> emp = employeeRepository.findByAgeBetween(28,32);
		emp.forEach(e -> System.out.println(e.getName()));
	}
	@Test
	public void testFindallPaginateAndSortOnAge(){
		PageRequest sortedByAge = PageRequest.of(0, 2, Sort.Direction.DESC ,"age");
		employeeRepository.findAll(sortedByAge).forEach(e-> System.out.println(e.getName() + " " +  e.getAge()));
	}

}
