package adages;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "adage")
public class Adages {
	
	private String words;
	private int wordcount;
	
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
		wordcount = words.trim().split("\\s+").length;
	}
	public int getWordcount() {
		return wordcount;
	}
	public void setWordcount(int wordcount) {
		this.wordcount = wordcount;
	}
	
	public String toString(){
		return words + "--" + wordcount + " words";
	}
	
	
}
