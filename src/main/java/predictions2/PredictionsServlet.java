package predictions2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "prediction2", urlPatterns="/prediction2")
public class PredictionsServlet extends HttpServlet{
	private Predictions predictions;
	
	public void init(){
		predictions = new Predictions();
		predictions.setSctx(this.getServletContext());
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		
	}
	

}
