package com.example.pkg;

import java.io.File;
import java.math.BigInteger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.schema.pkg.*;

public class marshallRNC {
	
	public static void xmlMarshaller(){
		IpnbT iub = new IpnbT();
		iub.setNBAPIPAddress("localhost");
		iub.setSCTPPortNumber(BigInteger.valueOf(52));
		iub.setWBTSid(BigInteger.valueOf(25));
		
		RNC rncV = new RNC();
		rncV.setRNCIPAddress("127.0.0.1");
		rncV.setRNCName("RNC-1");
		rncV.getIPNB().add(iub);
		
		try {
			JAXBContext jxb = JAXBContext.newInstance(RNC.class);
			Marshaller jxbmarshallar = jxb.createMarshaller();
			File fp = new File("RNCUpload.xml");
			jxbmarshallar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
			jxbmarshallar.marshal(rncV, fp);
			jxbmarshallar.marshal(rncV, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void xmlUnMarshaller(){
		
		RNC rncV = new RNC();
		
		try {
			JAXBContext jxb = JAXBContext.newInstance(RNC.class);
			Unmarshaller jxbmarshallar = jxb.createUnmarshaller();
			File fp = new File("RNCUpload.xml");			
			rncV = (RNC) jxbmarshallar.unmarshal(fp);
			
			if(rncV!=null){
				System.out.println("RNCName: "+rncV.getRNCName());
				System.out.println("IPNB count: "+rncV.getIPNB().size());
				System.out.println("IPNBIpAddress: "+rncV.getIPNB().get(0).getNBAPIPAddress());
			}
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]){
		xmlMarshaller();
		xmlUnMarshaller();
	}

}
