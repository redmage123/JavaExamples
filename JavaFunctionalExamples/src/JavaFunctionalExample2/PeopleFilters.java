package JavaFunctionalExample2;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

 class PeopleFilters {
 
	 private PeopleFilters() { 
	 }
	 
	 public static boolean filterByAge(Integer age, Integer ageLimit ,BiPredicate<Integer,Integer> bp) {
		 System.out.println("in filterByAge age = " + age + " agelimit = " + ageLimit);
		 if (bp.test(age,ageLimit)) {
			 return true;
		 }
		 return false;
	 }
	 
	 public static boolean filterByName(String name, String s, BiPredicate<String,String> bp) {
		 if (bp.test(name,s)) {
			 return true;
		 }
		 return false;
	 }
 }