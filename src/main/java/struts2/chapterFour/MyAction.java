package struts2.chapterFour;

public class MyAction {
	
	private boolean status = false;
	private String result = "False";
	
	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public String execute(){
		this.setStatus(true);
		return "SUCCESS";
	}
}
