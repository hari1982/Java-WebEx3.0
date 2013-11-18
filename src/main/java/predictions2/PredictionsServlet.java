package predictions2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.concurrent.ConcurrentMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import org.json.JSONObject;
import org.json.XML;

@WebServlet(name = "prediction2", urlPatterns="/prediction2")
public class PredictionsServlet extends HttpServlet{
	private Predictions predictions;
	
	public void init(){
		predictions = new Predictions();
		predictions.setSctx(this.getServletContext());
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		String param = request.getParameter("id");
		Integer key = (param == null) ? null : new Integer(param);
		boolean json = false;
		String accept = request.getHeader("accept");
		if(accept !=null && accept.contains("json"))
			json = true;
		if(key !=null){
			Prediction pred = predictions.getMap().get(key);
			if(pred==null){
				String msg = key + "doesnt map to prediction";
				sendResponse(response,predictions.toXML(msg),json);
			}else{
				sendResponse(response,predictions.toXML(pred),json);
			}
		}else{
			  ConcurrentMap<Integer,Prediction> map = predictions.getMap(); 
			  Object[] arr = map.values().toArray();
			  Arrays.sort(arr);
			  String xml = predictions.toXML(arr);
			  sendResponse(response, xml, json);
		}
		
	
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		String who = request.getParameter("who");
		String what = request.getParameter("what");
		
		if(who==null || what == null){
			throw new HTTPException(HttpServletResponse.SC_BAD_REQUEST);
		}
		Prediction pred = new Prediction();
		pred.setWho(who);
		pred.setWhat(what);
		int id = predictions.addPrediction(pred);
		String msg = "Prediction" + id + " created. \n";
		sendResponse(response, predictions.toXML(msg), false);
	}
	
	public void doPut(HttpServletRequest request, HttpServletResponse response){
		String key = null;
		String rest = null;
		boolean who =false;
		
		try{
			InputStream in = request.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line = reader.readLine();
			String[] args = line.split("#");
			String[] parts = args[0].split("=");
			key = parts[1];
			String[] parts2 = args[1].split("=");
			if(parts2[0].contains("who")) who = true;
			rest = parts2[1];
			
 		}catch(Exception ex){
			throw new HTTPException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		
		if(key == null){
			throw new HTTPException(HttpServletResponse.SC_BAD_REQUEST);
		}
		Prediction pred = predictions.getMap().get(new Integer(key.trim()));
		if(pred == null){
			String msg = key + " doesnt map to a Prediction";
			sendResponse(response, predictions.toXML(msg),false);
		}else{
			if(rest == null){
				throw new HTTPException(HttpServletResponse.SC_BAD_REQUEST);
			}
			if(who)
				pred.setWho(rest);
			else{
				pred.setWhat(rest);
			}
			String msg = "Prediction "+ key + " has been edited \n";
			sendResponse(response, predictions.toXML(msg),false);
		}
		
	}
	
	public void doDelete(){
		
	}
	private void sendResponse(HttpServletResponse response, String payload, boolean json){
		try{
			if(json){
				JSONObject jobt = XML.toJSONObject(payload);
				payload = jobt.toString();
			}
			OutputStream out = response.getOutputStream();
			out.write(payload.getBytes());
			out.flush();
		}catch(Exception ex){
			throw new HTTPException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		
	}
	

}
