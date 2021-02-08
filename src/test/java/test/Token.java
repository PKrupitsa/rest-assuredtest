/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.BeforeClass;

/**
 *
 * @author p.krupitsa
 */
public class Token {
    
    private static final String AUTH_URL = "http://localhost:8080/authentication-web/api/auth";
  
    
    public static String getToken() throws ParseException{
        
        
        RequestSpecification request = RestAssured.given();
        request.header("accept", "application/json");
        request.header("Content-Type", "application/json");
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", 122);
        requestBody.put("password", 122);
        request.body(requestBody.toJSONString());
        
        Response response = request.post(AUTH_URL);
        
        String responseBody = response.getBody().asString();
        Object JSONResponseBody = new JSONParser().parse(responseBody);
        JSONObject jo = (JSONObject) JSONResponseBody;
        String token = (String) jo.get("token");
        
        return token;
    }
    
   
}
