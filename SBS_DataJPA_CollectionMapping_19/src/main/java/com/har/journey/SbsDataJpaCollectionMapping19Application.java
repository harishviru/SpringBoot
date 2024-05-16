package com.har.journey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**                    Working with Collections:-(3) List, Set, Map
				     -------------------------------------------------------------
Every Collection is taken as one child table in Database, by data JPA,
if we define a collection variable in model class.
*)We have 3 Collections support in Data JPA, those are again divided into 2 types
____________________________________________________________________________
Index Based Collection               Non-Index Based Collections
____________________________________________________________________________
List                                 Set
Map
_____________________________________________________________________________
=> For every collection variable one table gets created with 
                      min 2 columns  and 
		      max 3 columns. ( key Column, Index Column, Element Column)
They are :
------------
key column == (FK)link column to parent table Primary Key | Join Column
index column == position of data in collection
element column == collection actual data

-JPA Annotations for Element Collections---
------------------------------------------------------------
a) @ElementCollection: This annotation must apply at Collection variable level.
It will create one DB table for Collection variable.

b) @CollectionTable(name="",joinColumns = @JoinColumn(name=""))
It is optional, this is used to provide child_table name and Key Column(Join column)
name.
--Default, if no annotation is applied---
parentModelclassName_CollectionVariableName --> child table name
parentModelClassName_PKColumNname ---> child table Join Column(key column)
c) @Column(name="") : It is used to provide element column name. (optional)

d) @OrderColumn(name=""): It is applied for index only for List Type
e) @MapKeyColumn(name="") : It is applied for index only for Map Type
 * 
 * 
 * 
 */
@SpringBootApplication
public class SbsDataJpaCollectionMapping19Application {

	public static void main(String[] args) {
		SpringApplication.run(SbsDataJpaCollectionMapping19Application.class, args);
	}

}
