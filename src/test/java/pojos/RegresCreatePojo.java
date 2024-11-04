package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegresCreatePojo implements Serializable {
	private String name;
	private String job;

	public RegresCreatePojo() {
	}

	public RegresCreatePojo(String name, String job) {
		this.name = name;
		this.job = job;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setJob(String job){
		this.job = job;
	}

	public String getJob(){
		return job;
	}

	@Override
 	public String toString(){
		return 
			"RegresCreatePojo{" + 
			"name = '" + name + '\'' + 
			",job = '" + job + '\'' + 
			"}";
		}
}