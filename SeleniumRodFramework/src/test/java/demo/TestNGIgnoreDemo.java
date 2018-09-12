package demo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

//@Ignore // Ignores this particular Class (all the test suite)
public class TestNGIgnoreDemo {

//	@Ignore // Ignores this particular test
	@Test
	public void test1() {
		System.out.println(" I am inside Test 1");
	}

	@Test
	public void test2() {
		System.out.println(" I am inside Test 2");
	}

}
