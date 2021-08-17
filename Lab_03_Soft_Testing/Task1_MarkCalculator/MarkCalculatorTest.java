package Task1_MarkCalculator;

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
	@Test(timeout = 1000, expected = ComponentOutOfRangeException.class)
	public void testException2() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(11, 0, 0, 0, true, false);
	}

	@Test(timeout = 1000, expected = ComponentOutOfRangeException.class)
	public void testException3() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(0, -1, 0, 0, true, false);
	}

	@Test(timeout = 1000, expected = ComponentOutOfRangeException.class)
	public void testException4() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(0, 15, 0, 0, true, false);
	}

	@Test(timeout = 1000, expected = ComponentOutOfRangeException.class)
	public void testException5() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(0, 0, -1, 0, true, false);
	}

	@Test(timeout = 1000, expected = ComponentOutOfRangeException.class)
	public void testException6() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(0, 0, 11, 0, true, false);
	}

	@Test(timeout = 1000, expected = ComponentOutOfRangeException.class)
	public void testException7() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(0, 0, 0, -1, true, false);
	}

	@Test(timeout = 1000, expected = ComponentOutOfRangeException.class)
	public void testException8() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(0, 0, 0, 120, true, false);
	}

	/* EXAMPLE Test case 2 */
	@Test(timeout = 1000)
	public void testGradeN() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(0, Grade.N), this.calculator.calculateMark(0, 0, 0, 0, true, false));
	}

	//TODO: write other test cases


	@Test(timeout = 1000)
	public void testGradePX() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(47, Grade.PX), this.calculator.calculateMark(2, 5, 5, 50, true, false));
	}

	@Test(timeout = 1000)
	public void testGradeP() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(51, Grade.P), this.calculator.calculateMark(6, 5, 5, 50, true, false));
	}

	@Test(timeout = 1000)
	public void testGradeC() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(65, Grade.C), this.calculator.calculateMark(5, 5, 5, 75, true, false));
	}

	@Test(timeout = 1000)
	public void testGradeD() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(70, Grade.D), this.calculator.calculateMark(10, 5, 5, 75, true, false));
	}

	@Test(timeout = 1000)
	public void testGradeHD() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(100, Grade.HD), this.calculator.calculateMark(10, 10, 10, 100, true, false));
	}

	@Test(timeout = 1000)
	public void testGradeNCN() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(null, Grade.NCN), this.calculator.calculateMark(10, 10, 10, 0, false, false));
	}

	@Test(timeout = 1000)
	public void testGradeRedeemable() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(75, Grade.D), this.calculator.calculateMark(5, 5, 5, 75, true, true));
	}

	@Test(timeout = 1000)
	public void testGradeNonInt() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(78, Grade.D), this.calculator.calculateMark(8, 7, 8, 79, true, false));
		assertEquals(new MarkGrade(62, Grade.C), this.calculator.calculateMark(8, 7, 8, 53, true, false));
		assertEquals(new MarkGrade(99, Grade.HD), this.calculator.calculateMark(10, 10, 10, 99, true, false));
		assertEquals(new MarkGrade(99, Grade.HD), this.calculator.calculateMark(10, 10, 10, 98, true, false));
		assertEquals(new MarkGrade(2, Grade.N), this.calculator.calculateMark(0, 1, 0, 0, true, false));
		assertEquals(new MarkGrade(93, Grade.HD), this.calculator.calculateMark(10, 10, 7, 95, true, false));
	}

	// ########## YOUR CODE ENDS HERE ##########
}
