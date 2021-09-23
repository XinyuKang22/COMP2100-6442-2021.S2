import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Fill in the items below with your UID and name:
 * @author:
 * @UID:
 */
public class BSTBranchCompleteTest {
	@Test(timeout=1000)
	public void test() {
		
		BranchComplete bc = new BranchComplete();

		// START YOUR CODE
		//HINT: assertEquals(xx, bc.DNATreeCalc(xx, xx, xx));
		assertEquals(208+50, bc.DNATreeCalc(300, 400, 50));
		assertEquals(208+300, bc.DNATreeCalc(300, 100, 200));
		assertEquals(0, bc.DNATreeCalc(100, 200, 300));
		// END YOUR CODE
	}
}
