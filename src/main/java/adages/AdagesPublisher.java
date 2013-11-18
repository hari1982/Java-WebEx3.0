package adages;

import java.net.InetSocketAddress;

import javax.ws.rs.ext.RuntimeDelegate;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class AdagesPublisher {

	private static final int PORT = 9876;
	private static final String uri = "/resourcesA";
	private static final String url = "http://localhost:"+ PORT + uri;
	
	public static void main(String args[]){
		AdagesPublisher publisher = new AdagesPublisher();
		publisher.publish();
	}
	
	private void publish(){
		HttpServer server = this.getServer();
		HttpHandler httpHandler = RuntimeDelegate.getInstance().
				createEndpoint(new RestfulAdges(), HttpHandler.class);
		server.createContext(uri, httpHandler);
		server.start();
		this.msg(server);
		
	}
	
	private HttpServer getServer(){
		HttpServer server = null;
		int backlog = 8;
		try{
			server = HttpServer.create(new InetSocketAddress("localhost",PORT), backlog);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return server;
	}
	
	private void msg(HttpServer server){
		String out = "Publishing Adges API at url " + url + ". Hit any key to stop.";
		System.out.println(out);
		try{
			System.in.read();
		}catch(Exception ex){
			
		}
		server.stop(0);
	}
	
}
