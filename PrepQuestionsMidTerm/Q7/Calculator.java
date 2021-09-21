public class Calculator {

	public double add(double a, double b) {

		//START YOUR CODE
		Operation operation = new Addition(a, b);
		return  operation.evaluate();

		//END YOUR CODE
	}

	public double subtract(double a, double b) {

		//START YOUR CODE
		Operation operation = new Subtraction(a, b);
		return operation.evaluate();

		//END YOUR CODE
	}

	public double multiply(double a, double b) {

		//START YOUR CODE
		Operation operation = new Multiplication(a, b);
		return operation.evaluate();

		//END YOUR CODE
	}

	public double divide(double a, double b) {

		//START YOUR CODE
		Operation operation = new Division(a, b);
		return operation.evaluate();

		//END YOUR CODE
	}
}
