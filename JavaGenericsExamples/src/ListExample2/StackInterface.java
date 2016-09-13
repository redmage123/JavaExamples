package ListExample2;

import java.util.*;
public interface StackInterface<T> {
	public boolean push(T item);
    public T pop();
    public boolean isEmpty();
}
