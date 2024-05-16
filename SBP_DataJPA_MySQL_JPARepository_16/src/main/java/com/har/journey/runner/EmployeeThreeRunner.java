package com.har.journey.runner;

import java.io.FileInputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.har.journey.model.EmployeeThree;
import com.har.journey.repo.EmployeeThreeRepository;

@Component
@Order(3)
public class EmployeeThreeRunner implements CommandLineRunner {

	@Autowired
	private EmployeeThreeRepository empRepo;

	@Override
	public void run(String... args) throws Exception {

		String imgLoc = "D:\\SB_Raghu\\budha.jpeg";

		FileInputStream fis = new FileInputStream(imgLoc);

		byte[] byteArray = new byte[fis.available()];
		fis.read(byteArray);

		String str = "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH";
		char[] empDesc = str.toCharArray();

		EmployeeThree emp = new EmployeeThree(2001, "Harish", "DEV", empDesc, byteArray);
		empRepo.save(emp);

	}

}
