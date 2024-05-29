package com.employeeDire.Emp.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeDire.Emp.DAO.EmployeeRepository;
import com.employeeDire.Emp.Entity.Employee;



@Service
public class EmployeeServiceIMP implements EmployeeService {

	
	private EmployeeRepository employeeRepo;
	
	@Autowired
	public EmployeeServiceIMP(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	
	
	
	@Override
	public Employee saveEmployee(Employee empp) {
		// TODO Auto-generated method stub
		return employeeRepo.save(empp);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee> findAll=employeeRepo.findAll();
		return findAll;
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeRepo.deleteById(id);
	}

	@Override
	public Employee findByID(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> findByid=employeeRepo.findById(id);
		Employee empp=findByid.get();
		return empp;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}
	

	

}
