package JavaCollectionsIteratorExample1;

import java.util.*;

public class IteratorExample {
	public static void main(String argv[]) {

		ArrayList<Integer> l = new ArrayList<Integer>();

		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);

		// Here we're declaring an iterator of type ListIterator.
		ListIterator<Integer> itr = l.listIterator();

		System.out.println(itr.hasNext());

		while (itr.hasNext()) {
			// If we try and modify the arraylist while we're iterating over it,
			// we'll get a ConcurrentModificationException.
			// l.remove(2);
			System.out.println(itr.next());
		}

		while (itr.hasPrevious()) {
			System.out.println(itr.previous());
		}
	}
}
