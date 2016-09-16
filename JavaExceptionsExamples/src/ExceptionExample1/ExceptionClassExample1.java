package ExceptionExample1;

class MyCalc<T extends Number> {
	public double add(T a, T b) {
		return a.doubleValue() + b.doubleValue();
	}

	public double sub(T a, T b) {
		return a.doubleValue() - b.doubleValue();
	}

	public double mul(T a, T b) {
		return a.doubleValue() * b.doubleValue();
	}

	public double div(T a, T b) throws IllegalArgumentException {
		if (b.doubleValue() == 0) {
			throw new IllegalArgumentException();
		} else {
			return a.doubleValue() / b.doubleValue();
		}
	}
}

public class ExceptionClassExample1 {

	public static void main(String args[]) {
		MyCalc mc = new MyCalc();
		try {
			double result = mc.div(new Double(1.0), new Double(0.0));
			System.out.println("result = " + result);
		} catch (IllegalArgumentException ex) {
			System.out.println("Oops, got an illegal argument exception!");
		} finally {
			System.out.println("Got to the fist finally block");
		}
		try {
			double result = mc.div(new Double(4.0), new Double(2.0));
			System.out.println("result = " + result);
		} catch (IllegalArgumentException ex) {
			System.out.println("Oops, got an illegal argument exception!");
		} finally {
			System.out.println("Got to the second finally block");
		}
	}
}
