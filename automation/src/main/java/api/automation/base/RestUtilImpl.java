package api.automation.base;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;


public class RestUtilImpl {
	/*
	 * Rest assured base Implementation 
	 */
	public RequestSpecification restRequest;
	private Response restResponse;
	public String url;
	private RestAssuredConfig restAssuredConfig = null;
	public RestUtilImpl(String url){
		/*
		 * constructor for rest api 
		 */
		RestAssured.baseURI = url;
		restRequest = RestAssured.given();
	}
	
	public void setContent(){
		/*
		 * set the content-type application/json
		 */
	}
	
	public void setBasicAuth(String username,String password){
		/*
		 * set basic auth for rest  request
		 */
		restRequest.auth().basic(username, password);
	}
	
	public void setRequestParams(java.util.List<String> keys, java.util.List<String> values){
		/*
		 * To set params to get or post requests
		 */
		Map<String, String> params = new HashMap<String, String>();
		
		for(int keyIndex=0,valueIndex=0; keyIndex<keys.size() && valueIndex<values.size(); keyIndex++,valueIndex++){
			params.put(keys.get(keyIndex), values.get(valueIndex));
		}
		
		restRequest.formParams(params);
		
	}
	
	public Response makeGetRequest(String uri){
		/*
		 * RestAssured get request with uri or with out uri
		 */
		if(uri==""){
			restResponse = restRequest.when().get();
		}else{
			restResponse = restRequest.get("/"+uri);
		}
		return(restResponse);
		
	}
	
	
	public void connectionTimedOut(Integer timeout){
		/*
		 * Set the timeout for api
		 */
		if (timeout != null) { 
			restAssuredConfig = RestAssuredConfig.config().httpClient(HttpClientConfig.httpClientConfig().setParam("CONNECTION_MANAGER_TIMEOUT", 3000));
		}
		
	}
	
//	public static void main(String args[]){
//		/*
//		 * Sample get request with Uri 
//		 */
//		RestUtilImpl re= new RestUtilImpl("https://reqres.in/api/users");
//		Response resp = re.makeGetRequest("/3");
//		System.out.println(resp.asString());
//		
//	}



}


