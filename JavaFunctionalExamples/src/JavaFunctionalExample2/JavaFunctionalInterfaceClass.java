package JavaFunctionalExample2;

//Test class to implement  FunctionalinterfaceTest 
public class JavaFunctionalInterfaceClass {
	public static void main(String[] args) {
		     // We used to have to define implementations of the interface using 
		     // anonymous inner classes like so.
		 FunctionalInterfaceTest fit = new FunctionalInterfaceTest(){
		     public void display(){
		         System.out.println("Display from old way");
		      }};
		 fit.display();//outputs: Display from old way
		 
		 
		 //Now, with functional interfaces, we can use lambdas to define
		 // the interface implementation like so.
		 FunctionalInterfaceTest newWay = () -> {
	   	     System.out.println("Display from new Lambda Expression");
		 };
		 newWay.display();//outputs : Display from new Lambda Expression
    }
}
