package pojos;

import java.io.Serializable;

public class SupportPojo implements Serializable {
	private String url;
	private String text;

	public SupportPojo() {
	}

	public SupportPojo(String url, String text) {
		this.url = url;
		this.text = text;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"SupportPojo{" + 
			"url = '" + url + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}