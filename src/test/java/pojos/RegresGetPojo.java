package pojos;

import java.io.Serializable;

public class RegresGetPojo implements Serializable {
	private String name;
	private String job;
	private String id;
	private String createdAt;

	public RegresGetPojo() {
	}

	public RegresGetPojo(String name, String job, String id, String createdAt) {
		this.name = name;
		this.job = job;
		this.id = id;
		this.createdAt = createdAt;
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

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	@Override
 	public String toString(){
		return 
			"RegresGetPojo{" + 
			"name = '" + name + '\'' + 
			",job = '" + job + '\'' + 
			",id = '" + id + '\'' + 
			",createdAt = '" + createdAt + '\'' + 
			"}";
		}
}