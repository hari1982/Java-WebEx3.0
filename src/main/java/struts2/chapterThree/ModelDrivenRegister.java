package struts2.chapterThree;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ModelDrivenRegister extends ActionSupport implements ModelDriven{

	public Object getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	private User user = new User();    
	   
	
	@Override
	public String execute() throws Exception {
		
		getPortfolioService().createUser(user);
		return SUCCESS;
		
	}
	
	private PortfolioService getPortfolioService(){
		return new PortfolioService();
	}
	
	@Override
	public void validate() {
		
		PortfolioService ps = getPortfolioService();
		if(user.getUsername().length() == 0){
			addFieldError("username", "Username is required");
		}
		if(user.getPassword().length() == 0){
			addFieldError("password", "Password is required");
		}
		
		if(user.getPortfolioName().length() == 0){
			addFieldError("portfolioName", "Portfolio name is required.");
		}
		
		if (ps.userExists(user.getUsername())){
			addFieldError("username", "User already exists.");
		}
	}
}
