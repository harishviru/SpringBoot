package com.har.journey.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.har.journey.model.Product;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	private static final String GET_PRODUCTS="SELECT * FROM Product";
	private static final String DELIMITER = ",";

	
	
	// Define Datasource Object
	@Bean
	 public DataSource ds() {
		 DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost:3306/batchdb");
			ds.setUsername("root");
			ds.setPassword("root");
		 return ds;
	 }
	
	
	
	
	// 1. Reader Object
	 @Bean
	 public ItemReader<Product> reader(){
		 //1. Create ItemReader which points to Database 
		 JdbcCursorItemReader<Product> reader =new JdbcCursorItemReader<>();
		 // 2. Set Datasource Object which create connection obj
		 reader.setDataSource(ds());
		 // 3. Set Sql to read data from Database
		 reader.setSql(GET_PRODUCTS);
		 // 4. Set RowMapper [To create Product obj and set values to obj by using RowMapper]
		  reader.setRowMapper((rs, rowNum) ->{
			  return new Product(rs.getInt("prodId"), rs.getString("prodCode"), rs.getDouble("prodCost"), rs.getDouble("prodDisc"), rs.getDouble("prodGst"));
		  } );
		 return reader;
	 }
	 
	 //2. Processor Object
	 @Bean
	 public ItemProcessor<Product, Product> processor(){
		 return (prodItem) -> {
			   var prodCost  =prodItem.getProdCost();
				var prodDisc =(prodCost*25)/100;
				var prodGst  =(prodCost*12)/100;

				prodItem.setProdDisc(prodDisc);
				prodItem.setProdGst(prodGst);
				return prodItem;
			};
	 }
	
	 //3. Writer Object 
	 @Bean
	 public ItemWriter<Product> writer(){
		 // 1. Create ItemWriter which points to FileSystem
		  FlatFileItemWriter<Product> writer =new FlatFileItemWriter<>();
		  //2. Set Resource [Location]
		  //writer.setResource(new ClassPathResource("Product_DB.csv"));
		  writer.setResource(new FileSystemResource("D:/SB_Raghu/Product_DB.csv"));
		  
		 // 3. Set LineAggregator [ This will be used to translate the item into a line for output]
		  writer.setLineAggregator(new DelimitedLineAggregator<Product>() {{
			  //4. Set Delimiter
			  setDelimiter(DELIMITER);
			  //5. Reader Fields from Bean/Product class Obj
			  setFieldExtractor(new BeanWrapperFieldExtractor<Product>() {{
				  setNames(new String[]{"prodId","prodCode","prodCost","prodDisc","prodGst"});
			  }});
		  }});
		 
		return writer;
	 }
	 
	 //4. StepBuilderFactory Object
	 @Autowired
	 private StepBuilderFactory sbf;
	 
	 //5.Step Object
	 @Bean
	 public Step stepA() {
		 return sbf.get("stepA")
				 .<Product,Product>chunk(5)
				 .reader(reader())
				 .processor(processor())
				 .writer(writer())
				 .build();
	 }
	 
	 //6.JobExecutionListener Object
	 @Bean
	 public JobExecutionListener listener() {
		 return new JobExecutionListener() {
			    private long startTime;
				@Override
				public void beforeJob(JobExecution je) {
					System.out.println("Before starting Job :"+je.getStatus());
					startTime = System.currentTimeMillis();
				}
				@Override
				public void afterJob(JobExecution je) {
				      System.out.println("After Finishing Job :"+je.getStatus());
				      long endTime = System.currentTimeMillis();
				      System.out.println("Total time taken to finish "+je.getJobInstance().getJobName() +" is :"+(endTime-startTime));
				}
		};
	 }
	 
	 
	 //7. JobBuilderFactory Object
	 @Autowired
	 private JobBuilderFactory jbf;
	 
	 //8. Job object
	 @Bean
	 public Job jobA() {
		 return jbf.get("JobA")
				 .listener(listener())
				 .start(stepA())
				 .build();
	 }
	 
	 
}
