package com.har.journey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**This application explains :
 *              i)How to work External Database(MySQL)
 *              ii)JPARepository
 *                  a)findAll(Example)
 *              iii)@Temporal (TemporalType : DATE,TIME,TIMESTAMP)
 *              iv)@Lob      (byte[] + @Lob : Blob ,char[] +@Lob : Clob)
 *
 */

@SpringBootApplication
public class SbpDataJpaMySqlJpaRepository16Application {

	public static void main(String[] args) {
		SpringApplication.run(SbpDataJpaMySqlJpaRepository16Application.class, args);
	}

}
