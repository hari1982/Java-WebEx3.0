package struts2.chapterThree;

import com.opensymphony.xwork2.ActionSupport;


public class Register extends ActionSupport{

	private String username="";
	private String password="";
	private String portfolioName="";
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	@Override
	public String execute() throws Exception {
		User user = new User();
		user.setPassword(password);
		user.setPortfolioName(portfolioName);
		user.setUsername(username);
		getPortfolioService().createUser(user);
		return SUCCESS;
		
	}
	
	private PortfolioService getPortfolioService(){
		return new PortfolioService();
	}
	
	@Override
	public void validate() {
		
		PortfolioService ps = getPortfolioService();
		if(username.length() == 0){
			addFieldError("username", "Username is required");
		}
		if(password.length() == 0){
			addFieldError("password", "Password is required");
		}
		
		if(getPortfolioName().length() == 0){
			addFieldError("portfolioName", "Portfolio name is required.");
		}
		
		if (ps.userExists(getUsername())){
			addFieldError("username", "User already exists.");
		}
	}

	
}
