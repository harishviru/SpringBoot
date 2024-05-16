package com.har.journey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/** This application is used to explain  Custom Queries
 *                 i)findBy     (Only SELECT)
 *                 ii)@Query     (SELECT and NON-SELECT)
 *                 
 *                 
 *        # i)findBy  
 *        ---------------------#1. Basic -----------------------------------------------
	      >Equal,GreaterThan,GreaterThanEqual,LessThan,LessThanEqual,Between,is Null,is Not Null
	     
	      ---------------------#2. Like Operator -----------------------------------------------
	      >Like ,Not Like,StartingWith,EndingWith,Containing
	     
	      ----------------#3. And ,Or,In Operators -----------------------------------------------
	                         
	      --------------------#4. Order by  -----------------------------------------------
	         
	      --------------------#5. IgnoreCase  -----------------------------------------------

  // #6 Projection
	/* Steps to define Projections
	 * 
	 * i)Define one Interface with any Name inside repository
	 *   
	 *   interface MyView{
	 *   }
	 *   
	 * ii)Define abstract methods (looks like get_() methdo syntax ) using varaibles
	 *      <DataType> get<Variable>();
	 *      
	 * iii) Use this interface as ReturnType for findBy method    
	
	 *
 * 
 * 
 * 
 */
@SpringBootApplication
public class SbqDataJpaFindBy17Application {

	public static void main(String[] args) {
		SpringApplication.run(SbqDataJpaFindBy17Application.class, args);
	}

}
