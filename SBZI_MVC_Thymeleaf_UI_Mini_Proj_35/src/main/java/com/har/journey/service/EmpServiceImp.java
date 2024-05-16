package com.har.journey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.har.journey.exception.EmployeeNotFoundException;
import com.har.journey.model.Employee;
import com.har.journey.repo.EmployeeRepository;

@Service
public class EmpServiceImp implements IEmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public Long saveEmployee(Employee employee) {
		
		Double empSal =	employee.getEmpSal();
		Double empHr  = (empSal/100)*20;
		Double empDa  = (empSal/100)*10;
		employee.setEmpHr(empHr);
		employee.setEmpDa(empDa);
		return empRepo.save(employee).getEmpId();
	}
	
	
	@Override
	public List<Employee> getAllEmpList() {
		return empRepo.findAll();
	}
	
	@Override
	public Page<Employee> getAllEmpList(Pageable pageable) {
		return empRepo.findAll(pageable);
	}
	
	@Override
	public void deleteEmp(Long empId) {
		if(empRepo.existsById(empId)) {
			empRepo.deleteById(empId);
		}else {
			throw new EmployeeNotFoundException("Employee Not exist with "+empId);
		}
	}
	@Override
	public Employee getEmployeeId(Long empId) {
		return empRepo.findById(empId).orElseThrow(()->new EmployeeNotFoundException("Employee Not exist with "+empId));
	}
	
	@Override
	public void updateEmp(Employee employee,Long empId) {
		if(empRepo.existsById(empId)) {
			Double empSal =	employee.getEmpSal();
			Double empHr  = (empSal/100)*20;
			Double empDa  = (empSal/100)*10;
			employee.setEmpHr(empHr);
			employee.setEmpDa(empDa);
			empRepo.save(employee);
		}else {
			throw new EmployeeNotFoundException("Employee Not exist with "+empId);
		}
	}
	
	@Override
	public boolean isEmailExist(String email) {
		    // boolean falg =empRepo.getEmailCount(email)>0?true:false;
		return empRepo.getEmailCount(email)>0;
	}
	
	
}
