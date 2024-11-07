package practice.gmibank_parctice.pojos;

import java.io.Serializable;

public class StatePojo implements Serializable {
	private int id;
	private String name;
	private Object tpcountry;

	public StatePojo() {
	}

	public StatePojo(int id, String name, Object tpcountry) {
		this.id = id;
		this.name = name;
		this.tpcountry = tpcountry;
	}


	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setTpcountry(Object tpcountry){
		this.tpcountry = tpcountry;
	}

	public Object getTpcountry(){
		return tpcountry;
	}

	@Override
 	public String toString(){
		return 
			"StatePojo{" + 
			"id = '" + id + '\'' + 
			",name = '" + name + '\'' + 
			",tpcountry = '" + tpcountry + '\'' + 
			"}";
		}
}