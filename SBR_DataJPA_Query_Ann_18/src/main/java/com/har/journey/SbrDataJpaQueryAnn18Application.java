package com.har.journey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
/** This application is used to explain  Custom Queries
 *                 i)findBy     (Only SELECT)        //Refer Before Application
 *                 ii)@Query     (SELECT and NON-SELECT)
 *                 
 *         #ii)@Query :
 *             >a)Supports SELECT ,NON-SELECT,JOINS,PROCEDURES,FUNCTIONS..etc Operation
 *             >b)Supports 
 *                           i)Positional Parameter (?<number>)
 *                          ii)Named Parameter (?<anyName>)       Named Parameter (:anyName--> must match with method parameter)
 *         
 *             >c)Supports  Projections
 * 
 *       syntax :
 *       --------
 *           @Query(value="...query...here..",nativeQuery = true/false)
 *           <ReturnType> <anyMethodName>(<params>.....);
 *
 *
 *            d)@Query  with Projection:        Return Type   
 *              i)Fetching all columns         -> List<T>          Here T  : Model class
 *             ii)Fetching one column          -> List<DT>         Here DT : DataType for respective Model class Variable          
 *            iii)Fetching multiple columns    -> List<Object[]>   Here Object[] means one row in database   
 *                               (not all)           
 *              
 *      ------------UPDATION----------------------------------
	  @Modifying          ->This annotation helps to execute INSERT, UPDATE, DELETE, and DDLstatements 
 *    @Transactional      ->To work like do everything or nothing principle by using @Transactional annotation

     @Param               ->Annotation to bind method parameters to a query via a named parameter.

 *
 */
@SpringBootApplication
public class SbrDataJpaQueryAnn18Application {

	public static void main(String[] args) {
		SpringApplication.run(SbrDataJpaQueryAnn18Application.class, args);
	}

}
