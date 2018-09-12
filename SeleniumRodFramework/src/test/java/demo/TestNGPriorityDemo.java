package demo;

import org.testng.annotations.Test;

public class TestNGPriorityDemo {
	
	// When priority is the same for several test cases, then it runs in alphabetical order.
	// When priority  is NOT set for some tests, those are run first, and then according to priority.
	// If priority is NOT set for any test, then they are run  in alphabetical order.
	
	@Test (priority =  1)
	public void test1 () {
		System.out.println("I'm inside Test 1");
	}

	@Test (priority =  2)
	public void test2 () {
		System.out.println("I'm inside Test 2");
	}

	@Test (priority =  3)
	public void test3 () {
		System.out.println("I'm inside Test 3");
	}
	
}
