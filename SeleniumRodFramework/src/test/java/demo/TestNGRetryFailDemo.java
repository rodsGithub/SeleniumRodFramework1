package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import listeners.RetryAnalyzer;

public class TestNGRetryFailDemo {

	@Test
	public void test1() {
		System.out.println("I'm inside Test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("I'm inside Test 2");
		//int i=1/0;
	}
	
	@Test (retryAnalyzer = listeners.RetryAnalyzer.class)
	public void test3() {
		System.out.println("I'm inside Test 3");
		Assert.assertTrue(0>1);
	}

}
