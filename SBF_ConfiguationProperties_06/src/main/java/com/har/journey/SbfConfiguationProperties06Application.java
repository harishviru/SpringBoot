package com.har.journey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbfConfiguationProperties06Application {

	public static void main(String[] args) {
		SpringApplication.run(SbfConfiguationProperties06Application.class, args);
	}

}

/*
 * @Value  : 
 *           This annotation is used to read ONE key data into one variable
 *  syntax :  @Value("${key}")
 *        
 * 
 * @ConfiguationProperties(prefix="-") :
 *           This annotation is used to read/load MUTIPLES Keys into code (variables)
 *           i)Define key-value in application.properties file using one common prefix
 *                  #application.properties
 *                  myapp.db.driver=Oracle
                    myapp.db.url=Jdbc:thin
                    myapp.db.username=system
                    myapp.db.password=manager
                    Note : common prefix is myapp.db
 *           
 *           ii)Provide common prefix at class level by using @ConfigurationProperties(prefix ="myapp.db")
 *           iii)No.of keys =No.of.Variables must match
 *           iv)Provide Setter & getter methods
 *           
 *          @ConfigurationProperties(prefix="commonWord")
 *                i)Primitives
 *                ii)List/Set/Array       [1D Collection]
 *                iii)Map/Properties      [2D Collection]
 *                iv)Association Mapping  [HAS-A Relationship in a class] 
 *           
 *            i)Primitives           
 *                  myapp.db.driver=Oracle
                    myapp.db.url=Jdbc:thin
                    myapp.db.username=system
                    myapp.db.password=manager
                    Note : common prefix is myapp.db
 *           
 *           
 *            ii)List/Set/Array       [1D Collection]
 *             # Below one's are used for @ConfigurationProperties annotation :i) List/Set/Array [ID Collection]
               > Syntax : 
                             prefix.variable[index]=value
                             (Or)
                             prefix.variable=val1,val2,val3    [Shortcut]
                            
                            my.app.colors[0]=RED
                            my.app.colors[1]=WHITE
                            my.app.colors[2]=GREEN
                            my.app.colors[3]=BLUE
                            my.app.colors[4]=YELLOW
                            
                            #prefix.variable=val1,val2,val3    [Shortcut] [High Priority than above]
                            my.app.colors=R,W,G,B,Y  
                            
                    Note : common prefix is my.app

 *           iii)Map/Properties      [2D Collection]
 *           # Below one's are used for @ConfigurationProperties annotation :iii) Map/Properties [2D Collection]
               > Syntax : 
                           prefix.variable.mapKey=mapValue
                           
                           my.result.edata.English=80
                           my.result.edata.Maths=98
                           my.result.edata.Social=95
                           
                           Note : common prefix is my.result
                           
                           
              iv)Association Mapping  [HAS-A Relationship in a class]                            
               # Below one's are used for @ConfigurationProperties annotation :iv)Association Mapping [HAS-A]
               > Syntax : 
                             prefix.hasVariable.variable=value
                     
                           my.hasApp.con.driver=Mysql
                           my.hasApp.con.url=Jdbc:Mysql
                           my.hasApp.con.username=root
                           my.hasApp.con.password=root 
                           
                          Note : common prefix is my.hasApp

 * 
 */


/**  #@ConfigurationProperties:
 *     Below dependency used to load properties :
 *                  @ConfigurationProperties class variables --loaded into->application.properties 
 * 
 *    <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-configuration-processor</artifactId>
			<optional>true</optional>
		</dependency>
 * 
 * 
 * 
 */




