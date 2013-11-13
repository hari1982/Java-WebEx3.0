package struts2.chapterTwo;

public class HelloWorld {
	private static String GREETING = "Hello ";
	private String name;
	private String customGreeting;
	
	public String execute(){
		System.out.println("Execute Function Called.");
		this.setCustomGreeting(GREETING+getName());
		return "SUCCESS";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomGreeting() {
		return customGreeting;
	}

	public void setCustomGreeting(String customGreeting) {
		this.customGreeting = customGreeting;
	}
}
