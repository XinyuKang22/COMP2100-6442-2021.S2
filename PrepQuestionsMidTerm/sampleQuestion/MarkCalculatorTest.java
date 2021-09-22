import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MarkCalculatorTest {
	/**
	 * Return a list of parameters which are different implementation of 
	 * interface {@linkplain MarkCalculator}. 
	 * Do NOT Modify this part
	*/
	@Parameters
    public static Iterable<? extends Object> getImplementations() {
        return Arrays.asList(
                new MarkCalculator0(),
                new MarkCalculator1(),
                new MarkCalculator2(),
                new MarkCalculator3(),
                new MarkCalculator4(),
                new MarkCalculator5(),
                new MarkCalculator6(),
                new MarkCalculator7(),
                new MarkCalculator8(),
                new MarkCalculator9(),
				new MarkCalculator10(),
				new MarkCalculator11(),
				new MarkCalculator12(),
				new MarkCalculator13(),
				new MarkCalculator14(),
				new MarkCalculator15()
        );
    }

	@Parameter
	public MarkCalculator calculator;

	/*
	 * Hint: Many students get stuck in this lab. Ensure you create out-of-bounds,
	 * 	tests which expect an exception. Furthermore, note that if the first,
	 * 	statement in such a test results in an exception, then later statements
	 * 	will not be executed.
	 */
	// ########## YOUR CODE STARTS HERE ##########
	
	/* EXAMPLE Test case 1 */
	@Test(timeout = 1000, expected = ComponentOutOfRangeException.class)
	public void testException() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(-1, 0, 0, 0, true, false);
	}

	/* EXAMPLE Test case 2 */
	@Test(timeout = 1000)
	public void testGradeN() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(0, Grade.N), this.calculator.calculateMark(0, 0, 0, 0, true, false));
	}

	//TODO: write other test cases

	// ########## YOUR CODE ENDS HERE ##########
}
