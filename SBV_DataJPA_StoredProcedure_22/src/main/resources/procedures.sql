---i) No IN and OUT Param
DROP PROCEDURE IF EXISTS springboot.getAllEmps;

DELIMITER $$
$$
CREATE PROCEDURE springboot.getAllEmps()
begin
	select * from emp_procedure_tab;

END$$
DELIMITER ;

---- call springboot.getAllEmps();

---ii) One IN and No OUT Param
DROP PROCEDURE IF EXISTS springboot.getEmpsByDept;

DELIMITER $$
$$
CREATE PROCEDURE springboot.getEmpsByDept(in edept varchar(50))
begin
	 select * from emp_procedure_tab ep where ep.dept_name=edept;
	
END$$
DELIMITER ;

----call springboot.getEmpsByDept('QA');


---iii) Both IN and OUT Param
DROP PROCEDURE IF EXISTS springboot.getEmpCountByDept;

DELIMITER $$
$$
CREATE PROCEDURE springboot.getEmpCountByDept(in edept varchar(50),out dcount int)
begin
	
	select count(*)  into dcount from emp_procedure_tab ep where ep.dept_name=edept;
	
END$$
DELIMITER ;


