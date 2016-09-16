package JavaCollectionsHashMapExample;

import java.util.HashMap;

public class HashMapExample {
	public static void main(String argv[]) {

		HashMap<String, String> empRecord = new HashMap<>();

		empRecord.put("12345", "Braun Brelin");
		empRecord.put("23456", "Barack Obama");
		empRecord.put("23457", "Hillary Clinton");
		empRecord.put("23458", "Narendra Modi");
		System.out.println("For key 12345, value is " + empRecord.get("12345"));
	}

}
