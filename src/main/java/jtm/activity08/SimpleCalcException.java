package jtm.activity08;

public class SimpleCalcException extends Exception {

	// If result is not in range:
	//     throw SimpleCalcException with message:
	//     "output value a oper b = result is above 10"
	//     "output value a oper b = result is below -10"
	//     where oper is +, -, *, /
	public SimpleCalcException(String string) {
		super(string);
	}

	// If division by zero is performed, catch original exception and create
	// new SimpleCalcException with message "division by zero" and add
	// original division exception as a cause for it.
	public SimpleCalcException(String string, Throwable cause) {
		super(string, cause);
	}

}
