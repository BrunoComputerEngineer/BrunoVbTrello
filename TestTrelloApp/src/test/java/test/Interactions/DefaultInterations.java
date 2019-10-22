package test.Interactions;

import static com.jayway.restassured.RestAssured.given;
import gherkin.deps.com.google.gson.Gson;

public class DefaultInterations {

	public String GetResponseCreateABord(String myJson, int statusCode, String key, String baseUrl) {
		
		String path = given()
				  .header("Accept", "application/json")
				  .contentType("application/json")
				  .queryParam("key", key)
				  .body(myJson)
				  .expect()
	                .statusCode(statusCode)
	             .when()
	                 .post(baseUrl)
				  .andReturn()
				  .getBody()
				  .asString();
		
		return path;
		
	}
	
public String GetResponseCreateACard(String myJson, int statusCode, String key, String baseUrl) {
		
		String path = given()
				  .header("Accept", "application/json")
				  .contentType("application/json")
				  .queryParam("key", key)
				  .body(myJson)
				  .expect()
	                .statusCode(statusCode)
	             .when()
	                 .post(baseUrl)
				  .andReturn()
				  .asString();
		
		return path;
		
	}

public String GetResponseUpdateACard(String myJson, int statusCode, String idCard, String key, String token,
		String baseUrl) {

	String path = given()
			  .header("Accept", "application/json")
			  .contentType("application/json")
			  .queryParam("key", key)
			  .queryParam("token", token)
			  .body(myJson)
			  .expect()
              .statusCode(statusCode)
           .when()
               .put(baseUrl + idCard)
			  .andReturn()
			  .asString();
	
	return path;
	
}
	
	

	public String GetResponseCreateAList(String myJson, int statusCode, String key, String baseUrl) {
		
		String path = given()
				  .header("Accept", "application/json")
				  .contentType("application/json")
				  .queryParam("key", key)
				  .body(myJson)
				  .expect()
	                .statusCode(statusCode)
	             .when()
	                 .post(baseUrl)
				  .andReturn()
				  .getBody()
				  .asString();
		
		return path;
		
	}
	
	public String GetResponseFindABoard(String idBoard,int statusCode,String key,  String token, String baseUrl) {
		
		String path = given()
				  .header("Accept", "application/json")
				  .contentType("application/json")
				  .queryParam("key", key)
				  .queryParam("token", token)
				  .expect()
	                .statusCode(statusCode)
	             .when()
	                 .get(baseUrl + idBoard)
				  .andReturn()
				  .asString();
		
		return path;
		
	}
	
public String DeleteResponseABoard(String idBoard,int statusCode,String key,  String token, String baseUrl) {
		
		String path = given()
				  .header("Accept", "application/json")
				  .contentType("application/json")
				  .queryParam("key", key)
				  .queryParam("token", token)
				  .expect()
	                .statusCode(statusCode)
	             .when()
	                 .delete(baseUrl + idBoard)
				  .andReturn()
				  .asString();
		
		return path;
		
	}

public String DeleteResponseABoardCards(String idBoard,int statusCode,String key,  String token, String baseUrl) {
	
	String path = given()
			  .header("Accept", "application/json")
			  .contentType("application/json")
			  .queryParam("key", key)
			  .queryParam("token", token)
			  .expect()
                .statusCode(statusCode)
             .when()
                 .delete(baseUrl + idBoard)
			  .andReturn()
			  .asString();
	
	return path;
	
}
	
	
	public  <T> Object ConvertJsonToObject(String ResponseCreate, Class<T> obj){
		
		 Gson g = new Gson();
		  
		 Object resposta = g.fromJson(ResponseCreate, obj);
		 
		 return resposta;
		 
	}



	
	
}
