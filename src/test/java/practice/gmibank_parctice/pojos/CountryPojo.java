package practice.gmibank_parctice.pojos;

import java.io.Serializable;
import java.util.List;

public class CountryPojo implements Serializable {
	private Object id;
	private String name;
	private List<StatePojo> states;

	public CountryPojo() {
	}

	public CountryPojo(Object id, String name, List<StatePojo> states) {
		this.id = id;
		this.name = name;
		this.states = states;
	}

	public void setId(Object id){
		this.id = id;
	}

	public Object getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setStates(List<StatePojo> states){
		this.states = states;
	}

	public List<StatePojo> getStates(){
		return states;
	}

	@Override
	public String toString() {
		return "CountryPojo{" +
				"id=" + id +
				", name='" + name + '\'' +
				", states=" + states +
				'}';
	}
}