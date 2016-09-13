package JavaInnerClassesPackage;


// Here we declare our second implementation of the EmailMessage.  Note that we're now using
// the builder pattern to build the email message rather than the earlier, naive implementation. 

class EmailMessage1 {
	private String from;
	private String to;
	private String subject;
	private String content;
	private String mimeType;
	
	
	// The outer class constructor is private and contains no statements.  That's because we're never
	// going to call the outer class constructor directly and instead do all the work through the static 
	//nested class called Builder.  
	
	private EmailMessage1() {}
	
	public static class Builder {
		
		// Instantiate the outer class directly from the Builder class. 
		private EmailMessage1 emailInstance = new EmailMessage1();
	
	    public Builder from (String f) {
	    	// Add the from field to the emailInstance.  Then return the Builder again. 
	    	System.out.println("In the from method of the Builder");
	    	emailInstance.from = f;
		    return this;
	    }
	
	    public Builder to(String t) {
	    	// Now add the to field, and again return the Builder.
	    	System.out.println("In the to method of the Builder");
	    	emailInstance.to = t;
	    	return this;
	    }
	
	    public Builder subject(String s) {
	    	// Add the subject, return the builder. 
	    	System.out.println("In the subject method of the Builder");
	    	emailInstance.subject = s;
		    return this;
	    }
	
	    public Builder content (String c) {
	    	// Add the content, return the builder. 
	    	System.out.println("In the content method of the Builder");
	    	emailInstance.content = c;
	    	return this;
	    }
	
	    public Builder mimeType (String mt) {
	    	// Add the mimeType and return the builder.
	    	System.out.println("In the mimetype method of the Builder");
	    	emailInstance.mimeType = mt;
	    	return this;
	    }
	    
	    public EmailMessage1 build() {
	    	// Finally, return the completely built emailInstance to the client application.
	    	System.out.println("In the build method of the Builder");
			return emailInstance;
		}
	}
	
	public static Builder builder() {
		// Construct the email message by calling the static nested class Builder.
		System.out.println("In the builder method of the EmailMessage1 class");
		return new EmailMessage1.Builder();
    }   
	
	public String getFromField() {
		return this.from;
	}
	
	public String getToField() {
		return this.to;
	}
	
	public String getSubjectField() {
		return this.subject;
	}
	
	public String getContentField() {
		return this.content;
	}
	
	public String getMimeTypeField() {
		return this.mimeType;
	}
}


// This is the driver class for the example.
public class JavaEmailExample2 {
    public static void main(String args[]) {
    	String content = "Dummy email";
    	String mimeType = "None";
    	
    	// Here we see an example of using the builder design pattern when constructing our email.
    	EmailMessage1 em = EmailMessage1.builder()
    	.from("bbrelin@gmail.com")
    	.to("foo@bar.com")
    	.subject("Hi there")
    	.content(content)
    	.mimeType(mimeType)
    	.build();
    	
        System.out.println("From: " + em.getFromField());
        System.out.println("To: " + em.getToField());
        System.out.println("Subject: " + em.getSubjectField());
        System.out.println("Content: " + em.getContentField());
        System.out.println("MimeType: " + em.getMimeTypeField());
    }
}
