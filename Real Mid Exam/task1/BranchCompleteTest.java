import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BranchCompleteTest {

	@Test
	public void test() {

		// TODO
		// START YOUR CODE
		// HINT: assertEquals(result, BranchComplete.findSomething(a, b, c, d));
		assertEquals(2+2+3-1, BranchComplete.findSomething(2,3,1,-1));
		assertEquals(3*(1+2-3), BranchComplete.findSomething(1,2,3,-1));
		assertEquals(1, BranchComplete.findSomething(3,1,2,0));
		assertEquals(1, BranchComplete.findSomething(3,2,1,4));
		// END YOUR CODE
	}
}
