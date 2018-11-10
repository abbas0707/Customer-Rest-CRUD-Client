package com.customer.rest.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.ResourceUtils;

import com.customer.rest.domain.Customer;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileUtility {
	private static Log logger = LogFactory.getLog(JsonFileUtility.class);
		
	public  List<Customer>  readJSONData()  {
		try {
		ObjectMapper mapper = new ObjectMapper();				
		TypeReference<List<Customer>> typeReference = new TypeReference<List<Customer>>(){};
			InputStream inputStream = new FileInputStream( ResourceUtils.getFile("classpath:data/consumerCallRecord.json").getPath());
		List<Customer> custList  = mapper.readValue(inputStream,typeReference);
		custList.forEach(action  -> logger.info("First name : "+action.getFirstName()));	
		
		return custList; 
		}catch(Exception e) {
			
			logger.info("NO data found from backup file");
			return null;
		}
	}
	
public  void writeJSONData(List<Customer> customerListRemote) throws Exception {
	List<Customer> customerListFile = 	this.readJSONData();  
	
	if(customerListFile != null && customerListFile.size()>0) {
		logger.info(" Size of the file retrive from records : "+customerListFile.size());
		customerListRemote.addAll(customerListFile);
	}
	
	logger.info("Totla Size of the file is "+customerListRemote.size());
	 ObjectMapper mapper = new ObjectMapper();
	 try {
				mapper.writeValue(new File(ResourceUtils.getFile("classpath:data/consumerCallRecord.json").getPath()), customerListRemote);
		
		logger.info("File updated succesfully");
	} catch (JsonGenerationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
