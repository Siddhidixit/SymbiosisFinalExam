package com.employeeDire.Emp.Services;

import java.util.List;

import com.employeeDire.Emp.Entity.Employee;



public interface EmployeeService {
	
    public Employee saveEmployee(Employee empp);
	
	public List<Employee> getAllEmployee();
		
	public void deleteEmployee(int id);
	
	public Employee findByID(int id);

	
	public Employee updateEmployee(Employee employee);

	



}
