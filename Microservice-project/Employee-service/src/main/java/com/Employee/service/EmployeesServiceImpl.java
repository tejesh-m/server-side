package com.Employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Employee.entity.Employee;

@Service
public class EmployeesServiceImpl implements IEmployeeService {
	
	List<Employee> list = List.of(
			new Employee(1310L, "Tejesh", "1234567890"),
			new Employee(1311L, "Tejesh1", "1234567890"),
			new Employee(1312L, "Tejesh2", "1234567890"),
			new Employee(1313L, "Tejesh3", "1234567890"),
			new Employee(1314L, "Tejesh4", "1234567890"),
			new Employee(1315L, "Tejesh5", "1234567890"),
			new Employee(1316L, "Tejesh6", "1234567890"),
			new Employee(1317L, "Tejesh7", "1234567890"),
			new Employee(1318L, "Tejesh8", "1234567890")
			
			);

	@Override
	public Employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		return list.stream().filter(employee-> employee.getEmpId().equals(id)).findAny().orElse(null);
	}

}
