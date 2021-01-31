/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
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
public class appServiceTest {
    
    public final String MNEMO = "app.TA";
    public final String VERSION = "1.1.1";
    Token TOKEN = new Token();
    
   
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
    }
    
    @Ignore
    @Test
    public void getAppDependenceTest() throws ParseException{
        
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
    }
    
    @Test
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
    }
    
}
