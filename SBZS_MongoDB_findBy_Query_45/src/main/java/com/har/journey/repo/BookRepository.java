package com.har.journey.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.transaction.annotation.Transactional;

import com.har.journey.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer> {

	// Syntax (Base):  RT  findBy<Condition/Variable>(<DataType> <paramName>);
	
	//---------------------#1. Basic -----------------------------------------------
	//(Equal,GreaterThan,GreaterThanEqual,LessThan,LessThanEqual,Between,is Null,is Not Null)-----
	
	//SQL     : SELECT * FROM Book WHERE title=?
	//MongoDB : db.find({"title":"Core Java"})
	 List<Book>  findByTitle(String title);
	
	 //SQL      : SELECT * FROM Book WHERE author=?
	 //MongoDB  : db.book.find({"author":"ABC"}).
	 List<Book>  findByAuthorIs(String author);
	 
	 //SQL      : SELECT * FROM Book WHERE noOfPages>?
	 //MongoDB  : db.book.find({noOfPages :{$gt:<value>}}).
	 List<Book>  findByNoOfPagesGreaterThan(Integer noOfPages);
	 
	 
	 //SQL      : SELECT * FROM Book WHERE noOfPages<=?
	 //MongoDB  : db.book.find({noOfPages :{$lte:<value>}}).
	 List<Book>  findByNoOfPagesLessThanEqual(Integer noOfPages);
	 
	 
	 
	 //SQL      : SELECT * FROM Book WHERE noOfPages>? and <?
	 //MongoDB  : db.book.find({ "noOfPages" : { "$gt" : 300, "$lt" : 450}}).
	 List<Book>  findByNoOfPagesBetween(Integer noOfPages,Integer noOfPages1);
	 
	 //SQL      : SELECT * FROM Book WHERE author is null
	 //MongoDB  : db.book.find({ "author" : null}).
	 List<Book> findByAuthorIsNull();

	 //SQL      : SELECT * FROM Book WHERE author is not null
	 //MongoDB  : db.book.find({ "author" : { "$ne" : null}}).
	 List<Book> findByAuthorIsNotNull();
	 
	 
	//---------------------#2. Like Operator -----------------------------------------------
		//(Like ,Not Like,StartingWith,EndingWith,Containing)
		  
	 //SQL      : SELECT * FROM Book WHERE author LIKE ?
	 //MongoDB  :{ "author" : { "$regularExpression" : { "pattern" : "^A", "options" : ""}}}
	 List<Book> findByAuthorStartingWith(String author);
   
	//SQL      : SELECT * FROM Book WHERE author LIKE ?
	 //MongoDB  : { "author" : { "$regularExpression" : { "pattern" : ".*A.*", "options" : ""}}}
	 List<Book> findByAuthorContaining(String author);
	 
	 //SQL      : SELECT * FROM Book WHERE btype not LIKE ?
	 // { "btype" : { "$not" : { "$regularExpression" : { "pattern" : "A", "options" : ""}}}}
	 List<Book> findByBtypeNotLike(String btype);
	 
	 
	//---------------------#3. And ,Or,In Operators -----------------------------------------------
	//Syntax : findBy<VariableWithConditions>And/Or<VariableWithConditions>(<Params>);
	 
	 //SQL      : SELECT * FROM Book WHERE author=? and title=?
	 //query: { "author" : "ABC", "title" : "Core Java"}
	 List<Book> findByAuthorAndTitle(String author,String title);
	 
	 
	 //SQL      : SELECT * FROM Book WHERE author=? or title=?
	 //query:{ "$or" : [{ "author" : "ABC"}, { "title" : "Core Java"}]}
	 List<Book> findByAuthorOrTitle(String author,String title);
	 
	 //SQL      : SELECT * FROM Book WHERE title in(?)
	 //query: { "btype" : { "$in" : ["BackEnd"]}} 
	 List<Book> findByBtypeIn(String title);
	 
	 
	 
	//---------------------#4. Order by  -----------------------------------------------
	//Syntax : findBy<VariableWithConditions>OrderBy<Variable>Asc/Desc(<Params>);
		
	 //SQL      : SELECT * FROM Book WHERE author =? orderby btype
	 //query: { "author" : "ABC"} sort: { "author" : "ABC"}
	 List<Book> findByAuthorOrderByBtype(String author);
	 
	 //SQL      : SELECT * FROM Book WHERE author =? orderby btype desc
	 //query: { "author" : "ABC"} sort: { "title" : "ABC"}
	 List<Book> findByAuthorOrderByBtypeDesc(String author);  //OrderBy Not working ?
	 
	 
	 // Single Record 
	 Book findByIdAndAuthor(Integer id,String author);
	 
	 
	// # Projection
		/** Steps to define Projections
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
		
		 */
		
		interface MyView{
			String getAuthor();
			String getTitle();
			
		}
		//SQL : SELECT author,title from Book where author=?
		//MongoDB :query: { "author" : "ABC"} fields: Document{{author=1, title=1}}
		List<MyView> findByAuthor(String author);
		
		//Please refer findBy.jpg image for more information
	 
	 //----------------------------------------------------------@Query-------------------------------------------------
		
		/*      @Query      : Restriction (Where condition) and Projection (Select Condition)  

                Restriction   : It is nothing but applying condition (Where in SQL)

                Projection   : Selecting variables/fields instead of  FULL JSON Documet


                   Syntax :
                  ---------
                    i)Only Restriction  (protecting all variables)
                        @Query("{conditions}")

                   ii)Restriction with Projections (1 : enable ,0: disable in fields attribute value)

                     @Query(value ="{conditions}",fields="{display variables}") 
		 * 
		 * 
		 */

		/*  { <field>: { $eq: <value> } }
		    { field:   { $ne: value   } }
		    { field:   { $gt: value   } }
		    { field:   { $gte: value  } }
            { field:   { $lt: value   } }
            { field:   { $lte: value  } }
            { field:   { $in: [<value1>, <value2>, ... <valueN> ] } }
            { field:   { $nin: [ <value1>, <value2> ... <valueN> ] } }
            
            
            { $and: [ { <expression1> }, { <expression2> } , ... , { <expressionN> } ] }
            { $or: [ { <expression1> }, { <expression2> } , ... , { <expressionN> } ] }
            { field: { $not: { <operator-expression> } } }
		 */
		
		
		//*@Query**************query/value: { "author" : "ABC"} fields: Document{{}} sort: { "author" : "ABC"}*****************
		// i)Only Restriction  (protecting all variables)
		
		//SQL : SELECT * FROM BOOK Where author =?
		@Query("{author:?0}")
		List<Book> getBooksByAuthor(String author);
		
		//SQL : SELECT * FROM BOOK Where author =? and title=?
		@Query("{author:?0,title:?1}")
		List<Book> getBooksByAuthorAndTitle(String author,String title);
		
		
		@Query("{noOfPages:{$gte:?0}}")
//		@Query("{noOfPages:{$lte:?0}}")
//		@Query("{noOfPages:{$gt:?0}}")
//		@Query("{noOfPages:{$lt:?0}}")
		List<Book> getBooksByNOofPagesCond(Integer noOfPages);
		
		@Query("{noOfPages:{$gte:?0 ,$lt:?1}}")
		List<Book> getBooksByNOofPagesConds(Integer noOfPages,Integer noOfPages1);
		
		@Query("{author:{$in:?0}}") // Converted Into { "author" : { "$in" : ["ABC", "PQR"]}}
		List<Book> getAuthorsIn(List<String> author);
		
		
		@Query("{btype:{$ne:?0}}")
		List<Book> getBooksByType(String btype);
		
	
		@Query("{btype:{$eq:?0, $ne:null}}")
		List<Book> getBooksByTypeAndNotNull(String btype);
		
		
		@Query("{btype:{$eq:?0} ,noOfPages :{$gte:?1}}")
		List<Book> getBooksByTypeAndGtNoOfPage(String btype,Integer noOfPages);
		
		
		@Query("{$and :[{author :?0},{btype:?1}]}")
		List<Book> getBooksByAuthorAndType(String author,String btype);
		
		
		@Query("{$or :[{author :?0},{btype:?1}]}")
		List<Book> getBooksByAuthorOrType(String author,String btype);
		
		@Query("{author: {$not:{ $in: [?0] },$ne :null}}") 
		List<Book> getBooksByAuthorNotVal(String author);
		
		
		//--  ii)Restriction with Projections (1 : enable ,0: disable in fields attribute value)    
		
		@Query(value="{title:{$eq:?0}}",fields = "{author:1,title:1}")
		List<Book> getBooksByTitle(String title);
		
		@Query(value="{title:{$eq:?0}}",fields = "{author:1,title:1}")
		List<String> getBooksByTitleStr(String title);
		
		@Query(value="{title:{$eq:?0}}",fields = "{author:1,title:1,_id:0}") //By default _id :1
		List<String> getBooksByTitleStrDisableId(String title);
		
		@Query(value="{author:{$eq:?0}}",fields = "{author:1,title:1}")
		List<MyView> getBookObjByAuthor(String author); //It is not required to List<MyView> becoz It can able converted JSON to Book Obj
		
		//Sorting
		//@Query(value="{btype:{$eq:?0}}",fields = "{author:1,title:1}",sort ="{author:1}" )   // 1 : ASC 
		@Query(value="{btype:{$eq:?0}}",fields = "{author:1,title:1}",sort ="{author:-1}" )  //-1 : DESC
		List<Book> getBooksInfoByType(String btype);
		
		// Count
		@Query(value="{btype:{$in:?0}}",count = true) // Converted Into { "btype" : { "$in" : ["v1", "v2"]}}
		Long getBtypeInCount(List<String> btype);
		
		//--------------------------------Update--------------------------------
		/*                    ++++++++++++++++++++++
                              Field Update Operators:
                              +++++++++++++++++++++++
                
                $currentDate           : Sets the value of a field to current date, either as a Date or a Timestamp. (Default is date)

                $inc                   : Increments the value of the field by the specified amount. 

                $min                   : Only updates the field if the specified value is less than the existing field value.

                $max                   : Only updates the field if the specified value is greater than the existing field value.

                $mul                   : Multiplies the value of the field by the specified amount.

                $rename                : Renames a field.

                $set                   : Sets/updates the value of a field in a document.

                $unset                 : Removes the specified field from a document.
		 * 
		 */
		@Query("{title:{$eq:?0}}")
		@Update("{$set:{title:?1}}")
		@Transactional
		void updateTitle(String title,String newTitle); //Update value : { "_id" : 109, "title" : "NEW_HK" }
		
		@Query(value="{author:{$eq:?0}}",delete = true) //provide : PK
		Long deleteAuthorByName(String author);
		
		
		
	
}
