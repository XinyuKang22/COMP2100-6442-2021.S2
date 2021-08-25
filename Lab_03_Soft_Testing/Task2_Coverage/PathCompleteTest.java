package Task2_Coverage;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * Task 2.3
 * You are given the java class called PathComplete, which has a method
 * 	called findSomething. Implement the minimum number of JUnit test cases to achieve
 * 	path complete to the findSomething method.Write your test case(s) in the test() method
 * 	in the PathCompleteTest.java file. All test cases should pass the JUnit test. You are not
 * 	allowed to alter the signatures of the given methods and the package
 * 	structures of the given classes.
 *
 */
public class PathCompleteTest {

	@Test(timeout = 1000)
	public void test() {
		// Implement your test cases
		// START YOUR CODE
		assertEquals(3,PathComplete.findSomething(3,2,1));
		assertEquals(3,PathComplete.findSomething(2,1,3));
		assertEquals(3,PathComplete.findSomething(2,3,1));
		assertEquals(3,PathComplete.findSomething(1,2,3));
		assertEquals(3,PathComplete.findSomething(3,2,-1));
		assertEquals(3,PathComplete.findSomething(-2,1,3));
		assertEquals(3,PathComplete.findSomething(2,-3,1));
		assertEquals(3,PathComplete.findSomething(-1,2,3));
		// END YOUR CODE
	}
}
