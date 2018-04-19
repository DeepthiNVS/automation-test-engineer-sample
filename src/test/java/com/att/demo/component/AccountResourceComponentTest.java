package com.att.demo.component;

import java.net.InetAddress;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.att.demo.model.Account;
import com.att.demo.model.Billing;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountResourceComponentTest {
	@LocalServerPort
	protected int randomServerPort;
	
	private String uri ="/accounts";
	private String resource = "/Billing";
	Billing bill = new Billing();
	
	@Before
	public void setUp() throws Exception {
		RestAssured.baseURI = "http://" + InetAddress.getLocalHost().getHostName() + ":" + randomServerPort + "/api";
	}
	
	private  RequestSpecification givenBaseSpec() {
		return 
				RestAssured.given()
					.accept(ContentType.JSON)
					.contentType(ContentType.JSON);
	}
	
	@Test
	public void testfindAllAccount_success() {
		
		givenBaseSpec()
				.when()
				.get(uri)
				.then()
					.statusCode(200);
	}
	
	@Test
	public void testCreateAccount_success() {
		
			
		Account account = new Account();
		account.setId(54321);
		account.setName("test-create");
		
		givenBaseSpec()
			.body(account)
			.when()
				.post(uri)
				.then()
					.statusCode(201);
	}
	
	// create a customer data
	
	
	@Test
	public void testCreatebilling_success() {
		
		bill.setFirst_name("Deepthi");
		bill.setLast_name("Alamuru");
		bill.setBill_invoice_number(78945);
		bill.setBill_amt(789);
			
               givenBaseSpec()
			.body(bill)
			.when()
				.post(resource)
				.then()
					.statusCode(201);
	}
	
	// Create duplicate entry same bill_invoice
          
          
          
          @Test
          public void testCreatebilling__duplicate_invoice_numbersuccess() {
      		
      		bill.setFirst_name("mark");
      		bill.setLast_name("abc");
      		bill.setBill_invoice_number(78945);
      		bill.setBill_amt(64);
      			
                     givenBaseSpec()
      			.body(bill)
      			.when()
      				.post(resource)
      				.then()
      					.statusCode(400);
      	}
          
          // create billing information with null as last name
          
          
          @Test
          public void testCreatebilling__null_last_namesuccess() {
      		
      		bill.setFirst_name("kaira");
      		bill.setLast_name(null);
      		bill.setBill_invoice_number(5457);
      		bill.setBill_amt(64);
      			
                     givenBaseSpec()
      			.body(bill)
      			.when()
      				.post(resource)
      				.then()
      					.statusCode(201);
      	}
          
          
          
	}
	

