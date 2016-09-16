package JavaInnerClassesPackage;

// This is a naive implementation of a class that builds an email message for an application. 
// What are the drawbacks to this implementation?

class EmailMessage {
	private String from;
	private String to;
	private String subject;
	private String content;
	private String mimeType;

	public EmailMessage(String f, String t, String s, String c, String mt) {
		this.from = f;
		this.to = t;
		this.subject = s;
		this.content = c;
		this.mimeType = mt;
	}
}

public class JavaEmailExample1 {
	public static void main(String args[]) {
		String content = "This is a dummy email message";
		String mimeType = "None";
		EmailMessage em = new EmailMessage("bbrelin@gmail.com", "foo@bar.com",
				"Hi there!", content, mimeType);
	}
}
