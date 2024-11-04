package pojos;

import java.io.Serializable;


public class RegresResponsePojo implements Serializable {
	private RegresDataPojo data;
	private RegresSupportPojo support;

	public RegresResponsePojo() {
	}

	public RegresResponsePojo(RegresDataPojo data, RegresSupportPojo support) {
		this.data = data;
		this.support = support;
	}

	public void setData(RegresDataPojo data){
		this.data = data;
	}

	public RegresDataPojo getData(){
		return data;
	}

	public void setSupport(RegresSupportPojo support){
		this.support = support;
	}

	public RegresSupportPojo getSupport(){
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