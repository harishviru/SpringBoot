package com.har.jourmey;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//#01

@TestMethodOrder(value=OrderAnnotation.class)
@Tag(value = "Devtest")
public class SampleTest {

	@BeforeEach
	public void setup() {
		System.out.println("-----------BeforeEach-------------------- ");
	}
	@BeforeAll
	public static void setUpAll() {
		System.out.println("-----------BeforeAll-------------------- ");
	}
	
	@Test
	@DisplayName("sample test one")
	@Order(2)
	public void testOne() {
		System.out.println("++++++++ Sample Test One++++++++");
	    Assertions.assertEquals(10, 4+4+2);	
	}
	@Test
	@DisplayName("sample test two")
	@Order(1)
	public void testTwo() {
		System.out.println("++++++++ Sample Test two++++++++");
		Assertions.assertEquals("ABC", "A"+"B"+"C");	
	}
	
	@AfterEach
	public void closeUp() {
		System.out.println("-----------AfterEach-------------------- ");
	}
	
	@AfterAll
	public static void closeAll() {
		System.out.println("-----------AfterAll-------------------- ");
	}
	
}
