package com.example.pkg;
/*Jaxb clases can be written himself without using xjc
compiler, you just need xml annotations*/
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Customer {
	String name;
	int id;

	public String getName(){
		return name;
	}
	@XmlElement
	public void setName(String name){
		this.name = name;
	}

	public int getId(){
		return id;
	}
	@XmlElement
	public void setId(int id){
		this.id = id;
	}
	
}
