package ListExample2;

import java.util.*;

class GenericsWildcards {
	
	List<? super Number> mysquares;
	public GenericsWildcards(List<? extends Number> l) {
		mysquares = new ArrayList<>();
		for (Number o : l) {
			mysquares.add((Double) o.doubleValue() * (Double) o.doubleValue());
		}
	}
	public List<?> getList() {
		return this.mysquares;
	}
}

public class ListExampleClass2 {
	public static void main(String args[]) {
		
		List<Integer> l = new ArrayList<>(10);
		List<Double> d = new ArrayList<>(10);
		
		
		l.add(new Integer(10));
		l.add (new Integer(4));
		l.add (new Integer(2));
		GenericsWildcards g = new GenericsWildcards(l);
		for (Number o : (List<Double>) g.getList()) {
			System.out.println(o);
		}
		
		d.add(new Double(10.0));
		d.add(new Double(5.0));
		d.add(new Double(2.0));
		GenericsWildcards g1 = new GenericsWildcards(d);
		
		for (Number o : (List<Double>) g1.getList()) {
			System.out.println(o);
		}
		
	}
}