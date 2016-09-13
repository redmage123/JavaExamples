package SecondExample;


//Here is an example of a simple class called 'Person'.  It has two attributes and four methods. 
//Note that the attributes are declared private so that they can only be accessed by the methods,
//not by anything outside the class.

// We are also showing the concept of chaining constructors. 

class Person {
   private String name;
   private int age;
   
   public Person () {
	   System.out.println("Default constructor in chain");
   }
   
   // This is the second constructor called in the chain.  Note that it calls the default constructor last
   // and then sets the name. 
   public Person(String n) {
	   this();
	   System.out.println("Setting the name");
	   this.name = n;
   }

   // This will be the first constructor called in the chain.  It then calls the second constructor with
   // only the name parameter and sets the age itself. 
   
   public Person (String n, int a) {
	   this("Barack Obama");
	   System.out.println("Setting the age");
	   this.age = a;
   }
   
   int getAge() {
	   return this.age;
   }
   
   String getName() {
	   return this.name;
   }
   
   void setAge(int a) {
	   this.age = a;
   }
   void setName(String n) {
	   this.name = n;
   }
}
