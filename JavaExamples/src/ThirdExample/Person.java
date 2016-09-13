package ThirdExample;

//Here is an example of a simple class called 'Person'.  It has two attributes and four methods. 
//Note that the attributes are declared private so that they can only be accessed by the methods,
//not by anything outside the class.

//We are also showing the concept of chaining constructors. 
// Finally, we're showing an example of a copy constructor where the argument passed to the constructor
// is another Person object of which we then do a copy of the attributes of the original. 

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
	   this.name = n;
   }
   
   // This will be the first constructor called in the chain.  It then calls the second constructor with
   // only the name parameter and sets the age itself. 
   public Person (String n, int a) {
	   this("Barack Obama");
	   this.age = a;
   }

   // This is the copy constructor, notice that we expect another Person object and then we copy the 
   // attributes over. 
   
   public Person(Person p) {
	   this.name = p.name;
	   this.age = p.age;
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
