/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import junit.framework.Assert;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;



/**
 *
 * @author p.krupitsa
 */

public class authTests extends Assert {
   
    
    public static final String AUTH_URL = "http://localhost:8080/authentication-web/api/auth";
    Token TOKEN = new Token();
    
    
 /*   @BeforeClass
    public void issueTokenTest() throws ParseException{
        
        RequestSpecification request = RestAssured.given();
        request.header("accept", "application/json");
        request.header("Content-Type", "application/json");
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", 122);
        requestBody.put("password", 122);
        request.body(requestBody.toJSONString());
        
        Response response = request.post(AUTH_URL);
        
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
        System.out.println("The status code recieved: " + statusCode);
        
  
        String responseBody = response.getBody().asString();
        Object JSONResponseBody = new JSONParser().parse(responseBody);
        JSONObject jo = (JSONObject) JSONResponseBody;
        String token = (String) jo.get("token");
        assertNotNull(token);
        
        System.out.println("TOKEN " + token);
            
        
    }   */
    
   
    
    @Test 
    public void validateTokenTest() throws ParseException{
        
        RequestSpecification request = RestAssured.given();

        Response response = request.get("http://localhost:8080/authentication-web/api/auth/validate?token=" +TOKEN.getToken());
       
        int statusCode = response.getStatusCode();     
        assertEquals(202, statusCode);
        System.out.println("Test The status code recieved: " + statusCode);
        System.out.println("TOKEN" + TOKEN);
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
            
    }
    @Ignore
    @Test
    public void getCertTest(){
        
        RequestSpecification request = RestAssured.given();
        
        Response response = request.get("http://localhost:8080/authentication-web/api/auth/certificate");
        
        int statusCode = response.getStatusCode();
        
        assertEquals(200, statusCode);
        System.out.println("The status code recieved: " + statusCode);
        String responseBody = response.getBody().asString();
     //   writeUsingFileWriter(responseBody);
        
        
    }
  
   /*      private static void writeUsingFileWriter(String data) {
        File file = new File("C:\\test1\\FileWriter.cer");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
        } catch (IOException e) {
        }finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
}
    }*/
       @Ignore
       @Test
       public void logOffTest() throws ParseException{
           
        RequestSpecification request = RestAssured.given();
        request.header("authorization", "Bearer " + TOKEN);
        
        Response response = request.delete(AUTH_URL);
        
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
        System.out.println("The status code recieved: " + statusCode);
           
        Response secondResponse = request.get("http://localhost:8080/authentication-web/api/auth/validate?token=" +TOKEN.getToken());
        assertEquals(401, statusCode);
        
        
       }
}



    
    
    
    
     
   
    
    

