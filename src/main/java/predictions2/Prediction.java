package predictions2;

import java.io.Serializable;

public class Prediction implements Serializable, Comparable<Prediction>{
	
	private String who;
	private String what;
	private int id;
	
	
	public String getWho() {
		return who;
	}


	public void setWho(String who) {
		this.who = who;
	}


	public String getWhat() {
		return what;
	}


	public void setWhat(String what) {
		this.what = what;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public int compareTo(Prediction other) {
		// TODO Auto-generated method stub
		return this.id - other.id;
	}

}
