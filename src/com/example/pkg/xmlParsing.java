package com.example.pkg;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class xmlParsing {

	public static void main(String[] args) {
		Customer cs = new Customer();
		cs.setId(12);
		cs.setName("Anjan");
		
		File fp = new File("Customer.xml");
		
		try {
			JAXBContext jxbCntxt = JAXBContext.newInstance(Customer.class);
			Marshaller mr = jxbCntxt.createMarshaller();
			
			mr.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			mr.marshal(cs, fp);
			mr.marshal(cs, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
