package com.har.journey.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.har.journey.listener.MyJobExecutionListener;
import com.har.journey.model.Product;
import com.har.journey.processor.MyProductItemProcessor;

@EnableBatchProcessing
@Configuration
public class BatchConfig {

	public static final String DELIMITER_COMMA = ",";

	

	// 1.Reader Object
	@Bean
	public ItemReader<Product> reader() {
		// 1. create reader Obj
		FlatFileItemReader<Product> reader = new FlatFileItemReader<Product>();
		// 2. Set Path of Resource File
		reader.setResource(new ClassPathResource("Product.csv"));
//		    reader.setResource(new FileSystemResource("D:/Files/Product.csv"));
//		    reader.setResource(new FileUrlResource("http:www.abc.com/Product.csv") );

		// 3. Reader Line by Line from CSV File by Using LineMapper
		reader.setLineMapper(new DefaultLineMapper<Product>() {{
				// 4. Split Line by LineTokenizer using Delimiter
				setLineTokenizer(new DelimitedLineTokenizer() {{
						setDelimiter(DELIMITER_COMMA);
						setNames("prodId", "prodCode", "prodCost"); // Set Names to values which was read by LineTokenizer
					}
				});
				// 5. Wrap the values into Product class obj BeanWrapperFieldSetMapper
				setFieldSetMapper(new BeanWrapperFieldSetMapper<Product>() {{
						setTargetType(Product.class);
					}});
			}
		});
		return reader;
	}

	// 2.Processor Object
	@Bean
	public ItemProcessor<Product, Product> processor() {
		return new MyProductItemProcessor();
	}

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	// 3.Writer Object
	@Bean
	public ItemWriter<Product> writer() {
		// 1.create ItemWriter which points to DB
		JpaItemWriter<Product> writer =new JpaItemWriter<>();
		// 2. Set entityManagerFactory for DB Communication
		writer.setEntityManagerFactory(entityManagerFactory);
		return writer;
	}

	// 4.StepBuilderFactory Object
	@Autowired
	private StepBuilderFactory sbf;

	// 5.Step Object
	@Bean
	public Step stepA() {
		return sbf.get("stepA").
				<Product, Product>chunk(2)
				.reader(reader()).
				processor(processor())
				.writer(writer())
				.build();
	}

	// 6.JobExecutionListener Object
	@Bean
	public JobExecutionListener listener() {
		return new MyJobExecutionListener();
	}

	// 7.JobBuilderFactory Object
	@Autowired
	private JobBuilderFactory jbf;

	// 8.Job Object
	@Bean
	public Job jobA() {
		return jbf.get("JobA").listener(listener()).start(stepA()).build();
	}

}
