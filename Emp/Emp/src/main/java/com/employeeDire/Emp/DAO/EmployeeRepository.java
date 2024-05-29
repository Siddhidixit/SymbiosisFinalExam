package com.employeeDire.Emp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeDire.Emp.Entity.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
