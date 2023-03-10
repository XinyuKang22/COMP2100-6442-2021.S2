import org.junit.Assert;
import org.junit.Test;

/**
 *
 * You are given a java class called Something, which has a method called
 * someMethod. Please implement a minimum number of test cases for testing `someMethod`
 * that are branch complete within `someMethod`. Write your test case(s) in test() method in
 * `SomethingTest.java`. You are not allowed to alter the signatures of the given
 * methods and the package structures of the given classes. Please upload the
 * `SomethingTest.java` file to Wattle for marking.
 *
 *
 * @author nanwang
 *
 */
public class SomethingTest {

	@Test
	public void test() {
		// Implement your test cases
		// START YOUR CODE
		Assert.assertEquals(0, Something.someMethod(1,1,1,1));
		Assert.assertEquals(228, Something.someMethod(36,36,30,45));
		Assert.assertEquals(293, Something.someMethod(36,72,100,85));

		// END YOUR CODE
	}
}
