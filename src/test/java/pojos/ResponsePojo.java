package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;


public class ResponsePojo implements Serializable {
	private DataPojo data;
	private SupportPojo support;

	public ResponsePojo() {
	}

	public ResponsePojo(DataPojo data, SupportPojo support) {
		this.data = data;
		this.support = support;
	}

	public void setData(DataPojo data){
		this.data = data;
	}

	public DataPojo getData(){
		return data;
	}

	public void setSupport(SupportPojo support){
		this.support = support;
	}

	public SupportPojo getSupport(){
		return support;
	}

	@Override
 	public String toString(){
		return 
			"ResponsePojo{" + 
			"data = '" + data + '\'' + 
			",support = '" + support + '\'' + 
			"}";
		}
}