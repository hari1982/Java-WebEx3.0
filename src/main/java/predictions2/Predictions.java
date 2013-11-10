package predictions2;

import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;

public class Predictions {

	

	private ConcurrentMap<Integer, Prediction> predictions;
	private ServletContext sctx;
	private AtomicInteger mapKey;
	
	public Predictions(){
		predictions = new ConcurrentHashMap<Integer, Prediction>();
		mapKey = new AtomicInteger();
	}
	
	public ConcurrentMap<Integer, Prediction> getMap() {
		return predictions;
	}

	public void setMap(ConcurrentMap<Integer, Prediction> predictions) {
		this.predictions = predictions;
	}

	public ServletContext getSctx() {
		return sctx;
	}

	public void setSctx(ServletContext sctx) {
		this.sctx = sctx;
	}

	public AtomicInteger getMapKey() {
		return mapKey;
	}

	public void setMapKey(AtomicInteger mapKey) {
		this.mapKey = mapKey;
	}
	
	public String toXML(Object obj){
		String xml = null;
		try{
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			XMLEncoder encoder = new XMLEncoder(out);
			encoder.writeObject(obj);
			encoder.close();
			xml = out.toString();
		}catch(Exception ex){
			
		}
		return xml;
		
	}
	
	public int addPrediction(Prediction prediction){
		int id = mapKey.getAndIncrement();
		prediction.setId(id);
		predictions.put(id, prediction);
		return id;
	}
	
	private void populate(){
		String filename = "/WEB-INF/data/predictons.db";
		InputStream in = sctx.getResourceAsStream(filename);
		if(in!= null){
			try{
                 InputStreamReader reader = new InputStreamReader(in);
                 BufferedReader buffer = new BufferedReader(reader);
                 String record = null;
                 while((record = buffer.readLine())!=null){
                	 String[] parts = record.split("!");
                	 Prediction p = new Prediction();
                	 p.setWho(parts[0]);
                	 p.setWhat(parts[1]);
                	 addPrediction(p);
                 }
			}catch(Exception ex){
				
			}
		}
	}
}
