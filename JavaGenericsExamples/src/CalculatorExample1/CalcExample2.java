package CalculatorExample1;

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

	public double div(T a, T b) {
		if (b.doubleValue() == 0) {
			return -1;
		} else {
			return a.doubleValue() / b.doubleValue();
		}
	}
}

public class CalcExample2 {
	public static void main(String args[]) {
		MyCalc c = new MyCalc();
		Double result = c.add(new Integer(1), new Double(1.0));
		System.out.println("result = " + result);

	}
}
