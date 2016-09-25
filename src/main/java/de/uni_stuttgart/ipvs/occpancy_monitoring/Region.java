package de.uni_stuttgart.ipvs.occpancy_monitoring;
import java.util.List;
import java.util.Map;

public class Region {
 private int id;
 private String name;
 private String description;
 private Map<String, String> listofmobile;
 
private List<String> ap;

public Region(int id2) {
	// TODO Auto-generated constructor stub
	id=id2;
}
public List<String> getAp() {
	return ap;
}
public void setAp(List<String> ap) {
	this.ap = ap;
}
	
 public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Map<String, String> getListofmobile() {
	return listofmobile;
}
public void setListofmobile(Map<String, String> listofmobile) {
	this.listofmobile = listofmobile;
}

}
