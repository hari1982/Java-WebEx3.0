package struts2.chapterThree;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ImageUpload extends ActionSupport implements ModelDriven{
	
	/*public Picture getPic() {
		return pic;
	}

	public void setPic(Picture pic) {
		this.pic = pic;
	}
*/
	public Object getModel() {
		// TODO Auto-generated method stub
		return pic;
	}


	Picture pic = new Picture();
	
	
	public String execute(){
		System.out.println(pic.getPicContentType());
		getPortfolioService().addImage(pic);
		return SUCCESS;
	}
	
	public PortfolioService getPortfolioService(){
		return new PortfolioService();
	}
}
