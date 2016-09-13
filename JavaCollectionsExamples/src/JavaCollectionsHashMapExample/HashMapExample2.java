import java.util.HashMap;
public class HashMapExample2 {

    public static void main(String argv[]) {

        HashMap <Number,String> h = new HashMap<> ();

        Integer i = new Integer(2);
        Float f = new Float (2);
        h.put(i,"Integer");
        h.put (f,"Float");
        System.out.println("2.0 is a " + h.get(i));

        HashMap <Object,String> h2 = new HashMap<> ();
        String s = new String("12345");
        Integer i1 = new Integer(2); 
        h2.put(s,"String");
        h2.put(i1,"Integer");
 
        System.out.println(s + " is a " + h2.get(s));

    }
}

