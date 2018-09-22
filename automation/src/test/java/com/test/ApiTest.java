package com.test;

import io.restassured.response.Response;

import java.io.FileNotFoundException;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import api.automation.base.RestUtilImpl;
import api.automation.base.util.FileUtilities;


public class ApiTest {
public List<String> requetsList ;
public List<String> requetsList2 ;
  @Test(dataProvider = "requestProvider")
  public void apiTest(Integer in, String request1,String request2) {
	  System.out.println(in);
	  System.out.println("safsdf");
	  System.out.println(request1);
	  RestUtilImpl apiTest = new RestUtilImpl(request1);
	  Response apiResponse = apiTest.makeGetRequest("");
	  System.out.println(apiResponse.asString());
	  
	  System.out.println(request2);
	  RestUtilImpl apiTest2 = new RestUtilImpl(request2);
	  Response apiResponse2 = apiTest2.makeGetRequest("");
	  System.out.println(apiResponse2.asString());
	  
	  
  }
  


  @DataProvider
  public Object[][] requestProvider() throws FileNotFoundException,ArrayIndexOutOfBoundsException {
	  FileUtilities utility = new FileUtilities(System.getProperty("user.dir") + "/src/test/java/requests.txt");
	  requetsList = utility.getRequests();
	  
	  FileUtilities utility2 = new FileUtilities(System.getProperty("user.dir") + "/src/test/java/requests2.txt");
	  requetsList2 = utility2.getRequests();

	  
	  Object[][] obj = new Object[requetsList.size()][3];
	  for(int index=0; index< requetsList.size() && index< requetsList2.size(); index++){
		  obj[index][0]= index;
		  obj[index][1]= requetsList.get(index);
		  obj[index][2]= requetsList2.get(index);
		 
	  }
	  return(obj);
	  
    
  }
}
