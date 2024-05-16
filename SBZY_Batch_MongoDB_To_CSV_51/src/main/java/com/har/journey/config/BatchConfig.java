package com.har.journey.config;

import java.util.HashMap;

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
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.har.journey.model.Product;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	private static final String DELIMITER = ",";

	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	// 1. Reader Object
	 @SuppressWarnings("serial")
	@Bean
	 public ItemReader<Product> reader(){
           //1. Create ItemReader Which points to MongoDB
		    MongoItemReader<Product> reader =new MongoItemReader<Product>();
		   //2. Set MongoTemplate which make con to DB
		    reader.setTemplate(mongoTemplate);
		    //3. Set Sorting Order
		    reader.setSort(new HashMap<String, Sort.Direction>() {{
		      put("_id", Direction.DESC);
		    }});
		    //4. set Target Type: collection class
		    reader.setTargetType(Product.class);
		    reader.setQuery("{}");
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
		  writer.setResource(new FileSystemResource("D:/SB_Raghu/Product_Mongo_DB.csv"));
		  
		 // 3. Set LineAggregator [ This will be used to translate the item into a line for output]
		  writer.setLineAggregator(new DelimitedLineAggregator<Product>() {{
			  //4. Set Delimiter
			  setDelimiter(DELIMITER);
			  //5. Reader Fields from Bean/Product class Obj
			  setFieldExtractor(new BeanWrapperFieldExtractor<Product>() {{
				  setNames(new String[]{"id","prodId","prodCode","prodCost","prodDisc","prodGst"});
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
