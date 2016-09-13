package FourthExample;

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
   
   // Because we're testing for equality, we need to override the equals method. 
   // Note we need to do this because trying to test that o1 == o2 won't return
   // the same value if we copy o1 to o2 using the copy constructor.  
   // Here we test the fields that we're comparing.  I.e. if the name and the age 
   // are equal in both objects, then we consider those objects to be equal.
   
   @Override
   public boolean equals(Object o) {
	   if (o == null) {
		   return false;
	   }
	   
	   final Person other = (Person) o;
	   if (this.name != other.name && this.age != other.age) {
		   return false;
	   }
	   return true;
	   
   }
   
   // The general principle is that if we override the equal method, then we also need to override
   // the default Object hashCode() method.  There are many algorithms that can be employed
   // but we're going with the suggestion by Joshua Bloch in his text book Effective Java. 
   // The idea is that we choose a prime number and repeatedly add that plus the field (or, if the
   // field is an object, it's hashCode, to the result and return that. 
   
   @Override
   public int hashCode() {
	   int prime=31;  // This is some randomly chosen prime number. 
	   int hash = 5;  // This is some randomly chosen start value
	   hash = prime + (this.name != null ? this.name.hashCode() :0); // Remember that it is possible that
	                                                                 // the object might be null, so we
	                                                                 // check that so that we don't get a
	                                                                 // NullPointerException thrown. 
	   hash += prime + this.age;
	   return hash;
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
