package com.har.jourmey;

import static org.mockito.Mockito.when;

import java.util.Iterator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

//#02

@Tag(value = "QA")
class CalculatorTest {

	private Calculator calculator = new Calculator();
	
	// -------start-----------
	static int num =0;
	
	@AfterAll
	public static void close() {
		num =0;
	}

	@ParameterizedTest
	@ValueSource(ints = { 20, 50, 89 })
	public void valSourceTest(int input) {
		Assertions.assertNotNull(input);
	}

	@ParameterizedTest
	@CsvSource({ "1, 1, 2", "2, 3, 5" })
	public void testAdd(int a, int b, int expected) {
		System.out.println("a :" + a + " , b :" + b + " ,expected : " + expected);
		Assertions.assertEquals(expected, calculator.add(a, b));
	}

	@RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("RepeatingTest")
    public void customDisplayName(RepetitionInfo repInfo, TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() +  "-->" + repInfo.getCurrentRepetition());
        Assertions.assertEquals(repInfo.getCurrentRepetition(), ++num);
    }
	// -------end-----------

	//Mockito
	@Test
	public void mockTest_1() {
		Sample sample=Mockito.mock(Sample.class);
		System.out.println(sample.printMsg("Hello")); //null becoz no logic added in mock implementation
	}
	
	@Test
	public void mockTest_2() {
		Sample sample=Mockito.mock(Sample.class);
		when(sample.printMsg("Hello")).thenReturn("Hello");//Hello > becoz logic added in mock implementation
		System.out.println(sample.printMsg("Hello")); 
	}
	@Test
	public void mockTest_3() {
		Iterator<String> itr = Mockito.mock(Iterator.class);
		when(itr.next()).thenReturn("A").thenReturn("B").thenReturn("C");
		//when(itr.next()).thenReturn("A", "B","C","D");
		System.out.println(itr.next() +" - "+itr.next() +" - "+itr.next() ); 
	}
	
	public interface Sample {
		   String printMsg(String msg);
		}
	
}

