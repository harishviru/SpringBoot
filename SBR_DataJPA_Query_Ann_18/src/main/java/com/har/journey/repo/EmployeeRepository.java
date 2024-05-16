package com.har.journey.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.har.journey.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	 //----------------i)Below @Query are written in two formats like HQL/JPQL ,SQL-----------------------
	
	  //@Query(value ="SELECT e from com.har.journey.model.Employee e")     //Writing package name for Model class is optional
	  //@Query(value ="SELECT * from emp_tab_one ",nativeQuery = true)    //Native Query
	  @Query(value ="SELECT e from Employee e")                         //HQL/JPQL 
	  List<Employee> getAllEmps();
	
	  
	  
	  //----------------ii)Below @Query are written in two formats like Positional Parameter(?<num>), Named Parameter(:<anyName>) -----------------------
	  /*        SYNTAX :
	   *                  i)Positional Parameter     : ?<number>
	   *                 ii)Named Parameter          : :<anyName>
	   *                    
	   * 
	   */
	  
	   @Query(value ="SELECT e from Employee e where deptName=:deptName")  // Named Parameter (:anyName--> must match with method parameter)
	 //@Query(value ="SELECT e from Employee e where deptName=?1")         // "Positional Parameter" ?1 is replaced by Spring container at runtime
	  List<Employee> getAllEmpsByDeptName(String deptName);
	  
	   
	 //----------------iii)Below @Query are written only in HQL> Positional Parameter
	   
	   @Query(value ="SELECT e from Employee e where empId>?1 and empId<?2")  
	   List<Employee> getAllEmpsBetweenIds(Integer empIdOne,Integer empIdTwo);	  

	   
	   
	//----------------iv)Below @Query are written only in HQL> Named Parameter
	  @Query(value ="SELECT e from Employee e where empId in(:empIds)")   // Named Parameter (:anyName--> must match with method parameter)
	 List<Employee> getAllEmpsByIdIn(List<Integer> empIds);	 
	   
	   
	  
	  //----------------v)Below @Query are written only Native SQL
	  @Query(value ="SELECT * from emp_tab_one where dept_name in(?)",nativeQuery = true)   
	  List<Employee> getAllEmpInfoByDeptName(String deptName);	 
	  
	  
	  //------------------------------PROJECTIONS-------------------------
	  //            @Query  with Projection:        Return Type   
	  /*              i)Fetching all columns         -> List<T>          Here T  : Model class
	  *             ii)Fetching one column          -> List<DT>         Here DT : DataType for respective Model class Variable          
	  *            iii)Fetching multiple columns    -> List<Object[]>   Here Object[] means one row in database   
	  *                               (not all)           
	  */
	   
	   
	//---------------Multiple rows output-------------------//
	  
	  @Query(value ="SELECT e from Employee e")
	  List<Employee> getAllEmpsList();
	   
	  @Query(value ="SELECT e.empName from Employee e")
	  List<String> getAllEmpsList_OneCol();
	  
	  @Query(value ="SELECT e.empName,e.deptName from Employee e")
	  List<Object[]> getAllEmpsList_TwoCol();
	  
	   
	   
	//---------------One row output-------------------//
	   
	  @Query(value ="SELECT e from Employee e where e.empId=?1")
	  Employee getAllEmpById(Integer empId);
	  
	  @Query(value ="SELECT e.empName from Employee e where e.empId=?1")
	  String getAllEmp_OneCol(Integer empId);
	
	  @Query(value ="SELECT e.empName,e.deptName from Employee e where e.empId=?1")
	  Object getAllEmp_TwoCol(Integer empId);
	
	   
	  //---------------------------Update -----------------------//
	  
	  @Transactional   // To work like do everything or nothing principle by using @Transactional annotation
	  @Modifying      //This annotation helps to execute INSERT, UPDATE, DELETE, and DDLstatements 
	  @Query(value ="Update Employee e SET e.empName=:empName where e.empId=:empId")
	  void udpateEmpName(@Param("empName")String empName,Integer empId);
	  
	   
}
