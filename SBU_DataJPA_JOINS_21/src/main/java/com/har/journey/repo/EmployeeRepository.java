package com.har.journey.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.har.journey.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("SELECT e.ename,e.addr,p.pcode FROM Employee as e INNER JOIN e.prjs as p where p.pcode=:pcode")
	List<Object[]> findDataByCode(String pcode);
	
	@Query("SELECT e.ename,e.addr,p.pcode FROM Employee as e RIGHT JOIN e.prjs as p where p.client=:pclient")
	List<Object[]> findDataByClientRJ(String pclient);
	
	 @Query("SELECT e.ename,e.addr,p.pcode FROM Employee as e LEFT JOIN e.prjs as p where e.addr=:addrs")
	//@Query("SELECT e.ename,e.addr,p.pcode FROM Employee as e  JOIN e.prjs as p where e.addr=:addrs")
	//@Query("SELECT e.ename,e.addr,p.pcode FROM Employee as e  FULL JOIN e.prjs as p where e.addr=:addrs")  //Caused by: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'full join project p1_0 on e1_0.eid=p1_0.eid_fk where e1_0.addr='VZG'' at line 1
	List<Object[]> findDataByAddrs(String addrs);
}
