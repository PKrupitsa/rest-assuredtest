/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.containsString;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author p.krupitsa
 */
public class ConstanTest {
    
    Token TOKEN = new Token();
 /*   public String mnemo = "sklad";
    public String value = "SKLAD";
    public String mnemo_period = "sklad_period";
    public String date = "02.01.2021T13:14:45";
    public String value_period = "SKLAD_period"; */
    
   
    
    
    
    
    
    ConstantData constant2 = new ConstantData("sklad","SKLAD", "");
    
 /*   @Before
    @Test
    public void createPeriodConstantTest() throws ParseException{
        
        JSONObject requestBody = new JSONObject();
        requestBody.put("mnemo", mnemo_period);
        requestBody.put("periodicalDate", date);
        requestBody.put("value", value_period);
        
        RequestSpecification request = RestAssured.given();
        request.header("accept", "application/json");
        request.header("Content-Type", "application/json");
        request.header("authorization", "Bearer " + TOKEN.getToken());
        request.body(requestBody.toString());
        
        
        Response response = request.post("http://localhost:8080/rest/constant");
       
        
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
        System.out.println("The status code recieved: " + statusCode);
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        assertNotNull(responseBody);
    }
    
    @Test
    public void getListConstantTest() throws ParseException{
        
        RequestSpecification request = RestAssured.given();
        request.header("accept", "application/json");
        request.header("authorization", "Bearer " + TOKEN.getToken());
        
        Response response = request.get("http://localhost:8080/rest/constant/list");
        
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
        System.out.println("The status code recieved: " + statusCode);
        
        String responseBody = response.getBody().asString();
        assertNotNull(responseBody);
        System.out.println(responseBody);
    }
    
    @Test
    public void readConstantTest() throws ParseException{
        
        RequestSpecification request = RestAssured.given();
        request.header("accept", "application/json");
        request.header("authorization", "Bearer " + TOKEN.getToken());
        
        Response response = request.get("http://localhost:8080/rest/constant/" + mnemo);
        
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
        System.out.println("The status code recieved: " + statusCode);
        
        String responseBody = response.getBody().asString();
        assertNotNull(responseBody);
        System.out.println(responseBody);
    }
    
    @Test
    public void readPeriodConstantTest() throws ParseException{
        
        RequestSpecification request = RestAssured.given();
        request.header("accept", "application/json");
        request.header("authorization", "Bearer " + TOKEN.getToken());
        
        Response response = request.get("http://localhost:8080/rest/constant/" + mnemo + "?periodicalDate=" + date);
        
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
        System.out.println("The status code recieved: " + statusCode);
        
        String responseBody = response.getBody().asString();
        assertNotNull(responseBody);
        System.out.println(responseBody);
    }
    
     @Test
    public void updateConstantTest() throws ParseException{
        
        JSONObject requestBody = new JSONObject();
        requestBody.put("mnemo","update_" + mnemo);
        requestBody.put("value","update_" + value);
        
        RequestSpecification request = RestAssured.given();
        request.header("accept", "application/json");
        request.header("Content-Type", "application/json");
        request.header("authorization", "Bearer " + Token.getToken());
        request.body(requestBody.toString());
        
        
        Response response = request.put("http://localhost:8080/rest/constant");
        
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
        System.out.println("The status code recieved: " + statusCode);

    }
    @Test
    public void deleteConstantTest() throws ParseException{
        
        RequestSpecification request = RestAssured.given();
        request.header("authorization", "Bearer " + TOKEN.getToken());
        
        Response response = request.delete("http://localhost:8080/rest/constant/" + "update_" + mnemo);
        
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
        System.out.println("The status code recieved: " + statusCode);
        
       
    }*/
    
    
}
