package com.har.journey.config;

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
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.har.journey.model.Product;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	private static final String DELIMITER = ",";

	// 1. Reader Object
	 @Bean
	 public ItemReader<Product> reader(){
            //1.Create Reader obj which point to File
		   FlatFileItemReader<Product> reader =new FlatFileItemReader<>();
		   //2. Set Location of File
		    reader.setResource(new ClassPathResource("Product_DB.csv"));
		   //3.Set LineMapper [Read the CSV Line/Record into One Line
		    reader.setLineMapper(new DefaultLineMapper<Product>() {{
		    	//4. Set LineTokenizer [To divide Line into small parts by using DELIMITER and mapping to Variables
		    	setLineTokenizer(new DelimitedLineTokenizer() {{
		    		setDelimiter(DELIMITER);
		    		setNames("prodId","prodCode","prodCost","prodDisc","prodGst");
		    	}});
		    	//5. Finally set the value to Product class obj by using FieldSetMapper
		    	 setFieldSetMapper(new BeanWrapperFieldSetMapper<Product>() {{
		    		 setTargetType(Product.class);
		    	 }});
		    	
		    }});
		 
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
	 
	 
	@Autowired
	private MongoTemplate mongoTemplate;
	 
	 //3. Writer Object 
	 @Bean
	 public ItemWriter<Product> writer(){
		  //1. Create Writer which points to MongoDB
		  MongoItemWriter<Product> writer =new MongoItemWriter<Product>();
 		 //2. Set MongoTemplate which points to MongoDB connection
		  writer.setTemplate(mongoTemplate);
		  //2. Set Collection
		  writer.setCollection("prod_col");
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
