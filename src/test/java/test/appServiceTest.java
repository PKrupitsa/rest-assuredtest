/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author p.krupitsa
 */
public class AppServiceTest {
    
    public final String MNEMO = "app.TA";
    public final String VERSION = "1.1.1";
    Token TOKEN = new Token();
    

/*   @Ignore
    @Test
    public void getListAppTest() throws ParseException{
        
        RequestSpecification request = RestAssured.given();
        request.header("accept", "application/json");
        request.header("Content-Type", "application/json");
        request.header("authorization", "Bearer " + TOKEN.getToken());
        
        Response response = request.get("http://localhost:8080/rest/app/list");
        
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
        System.out.println("The status code recieved: " + statusCode);
        
        String responseBody = response.getBody().asString();
        assertNotNull(responseBody);
        System.out.println(responseBody);
    }*/
    
     @Test
    public void getListAppTest() throws ParseException{
        
        given()
        .headers(
              "Authorization",
              "Bearer " + TOKEN.getToken(),
              "Content-Type",
              ContentType.JSON,
              "Accept",
              ContentType.JSON)
                 .when()
                 .get("http://localhost:8080/rest/app/list")
                   .then().log().all().statusCode(200);
        
 //добавить проверку боди               
    
    } 
    
    
 /*   @Ignore
    @Test
    public void getAppVersionTest() throws ParseException{
        
        RequestSpecification request = RestAssured.given();
        request.header("accept", "application/json");
        request.header("Content-Type", "application/json");
        request.header("authorization", "Bearer " + TOKEN.getToken());
        
        Response response = request.get("http://localhost:8080//rest/app/version?mnemo=" + MNEMO);
        
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
        System.out.println("The status code recieved: " + statusCode);
        
        String responseBody = response.getBody().asString();
        Object JSONResponseBody = new JSONParser().parse(responseBody);
        JSONObject jo = (JSONObject) JSONResponseBody;
        String version = (String) jo.get("version");
        assertEquals(VERSION, version);
    }*/
    
       
    @Ignore
    @Test
    public void getAppVersionTest() throws ParseException{
        
      given()
        .headers(
              "Authorization",
              "Bearer " + TOKEN.getToken(),
              "Content-Type",
              ContentType.JSON,
              "Accept",
              ContentType.JSON)
                 .when()
                 .get("http://localhost:8080/rest/app/version?mnemo=" + MNEMO)
                   .then().log().all().statusCode(200).body(containsString("-1.-1.-1"));
    }
    
    
 /*   @Test
    public void getAppWithDependenceTest() throws ParseException{
        
        RequestSpecification request = RestAssured.given();
        request.header("accept", "application/json");
        request.header("Content-Type", "application/json");
        request.header("authorization", "Bearer " + TOKEN.getToken());
        
        Response response = request.get("http://localhost:8080/rest/app/version?mnemo=" + MNEMO + "/" + VERSION);
        
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
        System.out.println("The status code recieved: " + statusCode);
        
        
        String responseBody = response.getBody().asString();
        assertNotNull(responseBody);
        System.out.println(responseBody);
    }*/
    
      
  /*  @Test
    public void getAppWithDependenceTest() throws ParseException{
        
        RequestSpecification request = RestAssured.given();
        request.header("accept", "application/json");
        request.header("Content-Type", "application/json");
        request.header("authorization", "Bearer " + TOKEN.getToken());
        
        Response response = request.get("http://localhost:8080/rest/app/version?mnemo=" + MNEMO + "/" + VERSION);
        
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
        System.out.println("The status code recieved: " + statusCode);
        
        
        String responseBody = response.getBody().asString();
        assertNotNull(responseBody);
        System.out.println(responseBody);
    }*/
    
       
    @Test
    public void getAppWithDependenceTest() throws ParseException{
        
        given()
        .headers(
              "Authorization",
              "Bearer " + TOKEN.getToken(),
              "Content-Type",
              ContentType.JSON,
              "Accept",
              ContentType.JSON)
                 .when()
                 .get("http://localhost:8080/rest/app/version?mnemo=" + MNEMO + "/" + VERSION)
                 .then().log().all().statusCode(200).body(containsString("\"name\": \"app.TA/1.1.1\""));

        
    }
    
    
}
