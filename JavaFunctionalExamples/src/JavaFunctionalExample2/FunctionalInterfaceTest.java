package JavaFunctionalExample2;

// This is a single abstract method (SAM) interface.  It only defines one abstract method. 
// The annotation is used to detect compiler errors, such as declaring a second abstract method.
// Note that we can override the default Object methods such as toString and equals without errors. 

@FunctionalInterface
public interface FunctionalInterfaceTest {
		void display();
}
