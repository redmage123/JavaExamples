package StringBuilderExample;

public class AStringBuilderExample {
	
	public static void main(String args[]) {
        String sArray[] = {"Fee ","Fi ","Fo ","Fum"};
    
        final int maxsize = 100;
        int i;
        StringBuilder sb = new StringBuilder(maxsize);
        for (i=0;i<sArray.length;i++) {
    	    sb.append(sArray[i]);
        }
        System.out.println(sb.toString());
	}
}
