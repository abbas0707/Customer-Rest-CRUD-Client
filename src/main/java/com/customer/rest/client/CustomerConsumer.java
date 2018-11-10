package com.customer.rest.client;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.client.RestTemplate;

import com.customer.rest.domain.Customer;
import com.customer.rest.util.JsonFileUtility;
 
public class CustomerConsumer {
	private static Log logger = LogFactory.getLog(CustomerConsumer.class);
	private final String URI = "http://localhost:8080/listCustomers";
	public static void main(String[] args) {
		
		new CustomerConsumer().listCustomers();
	}
	public  void listCustomers() {
		// TODO Auto-generated method stub
		 try {
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> response =   restTemplate.getForObject(URI, List.class);		
		List<Customer> customerListRemote = new ArrayList();
		 if(response!=null){
			 
			 response.forEach(map ->{
				 Customer customer = new Customer();
				 customer.setFirstName(map.get("firstName")!= null?map.get("firstName").toString():"");
				 customer.setLastName(map.get("lastName")!= null?map.get("lastName").toString():"");
				 customer.setAddress(map.get("address")!= null?map.get("address").toString():"");
				 customerListRemote.add(customer); 
				 logger.info("Fname="+map.get("firstName")+", LName="+map.get("lastName")+", Address="+map.get("address"));

			 });
	            
	        }  
		
			new JsonFileUtility().writeJSONData(customerListRemote);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Server returned with error: "+e.getMessage());
		}
		
       
       // logger.info(customer.toString());
	}

}
