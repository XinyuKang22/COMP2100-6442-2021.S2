import org.junit.Assert;
import org.junit.Test;

public class BranchCompleteTest {

	@Test(timeout = 1000)
	public void test() {

		// TODO
		// START YOUR CODE
		// HINT: assertTrue(BranchComplete.findSomething(a, b, c));
		// OR assertFalse(BranchComplete.findSomething(a, b, c));
		Assert.assertTrue(BranchComplete.findSomething(1,2,3));
		Assert.assertTrue(BranchComplete.findSomething(-2,-1,0));
		Assert.assertFalse(BranchComplete.findSomething(-2,-1,-3));
		Assert.assertFalse(BranchComplete.findSomething(-1,-2,0));
		// END YOUR CODE
	}
}
