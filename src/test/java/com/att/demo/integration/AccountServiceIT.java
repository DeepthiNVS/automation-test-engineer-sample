package com.att.demo.integration;

import org.junit.Before;
import org.junit.Test;

import com.att.demo.model.Account;
import com.att.demo.model.Billing;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AccountServiceIT {
	
	private String uri ="/accounts";
	private String resource = "/Billing";
	Billing bill = new Billing();
		
	@Before
	public void setUp() throws Exception {
		String baseURI = System.getProperty("BASE_URL");
		RestAssured.baseURI = baseURI + "/api";
	}
	
	private RequestSpecification givenBaseSpec() {
		return 
				RestAssured.given()
					.accept(ContentType.JSON)
					.contentType(ContentType.JSON)
					;
	}
	
	@Test
	public void testfindAllAccount_success() {
		
		givenBaseSpec()
				.when()
				.get(uri)
				.then()
					.statusCode(200);
	}
	
	// display bill ampount of  particular amount
	
	@Test
	public void testbilling_success() {
		
		bill.setFirst_name("Deepthi");
		bill.setLast_name("Alamuru");
		bill.setBill_invoice_number(78945);
		bill.setBill_amt(789);
		
		
          Response resp =   givenBaseSpec().log().all()
			.body(bill)
			.when()
				.get(resource)
				.then()
					.statusCode(201)
					.extract().response();
          
                   
          
          String res = resp.asString();
          JsonPath js = new JsonPath(res);
          
          if(( js.getLong("Bill_invoice_number") != 0 ) && (js.getString("First_name")== "Deepthi"))
          {
        	  System.out.println("bILL_amount OF Customer "+js.getString("First_name")+"  is  "+js.getLong("billamt"));
          }
          else
          {
        	  System.out.println("Customer does not exist");
          }
          
	}
	
	// retrieve response with last name as null
          @Test
      	public void testbilling_with_null_lastname_success() {
      		
      		bill.setFirst_name("kaira");
      		bill.setLast_name(null);
      		bill.setBill_invoice_number(5457);
      		bill.setBill_amt(64);
      		
      		
                Response resp =   givenBaseSpec().log().all()
      			.body(bill)
      			.when()
      				.get(resource)
      				.then()
      					.statusCode(201)
      					.extract().response();
                
                         
                
                String res = resp.asString();
                JsonPath js = new JsonPath(res);
                
                if( js.getLong("Bill_invoice_number") != 0)
                {
              	  System.out.println("bILL_amount OF Customer "+js.getString("First_name")+"  is  "+js.getLong("billamt"));
                }
                else
                {
              	  System.out.println("Customer does not exist");
                }
}
	
	
	
	
	
}