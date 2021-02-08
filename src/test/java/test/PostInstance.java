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
public class PostInstance {
    
    Token TOKEN = new Token();
    ConstantData constant = new ConstantData("sklad","SKLAD");
    ConstantData constantForUpdate = new ConstantData("sklad_meat","SKLAD_MEAT");
    
    @Before
    @Test
    public void createConstant() throws ParseException{
        
         given()
        .headers(
              "Authorization",
              "Bearer " + TOKEN.getToken(),
              "Content-Type",
              ContentType.JSON,
              "Accept",
              ContentType.JSON)
                 .body(constant).log().all()
                 .when()
                 .post("http://localhost:8080/rest/constant")
                 .then().log().all().statusCode(200).body(containsString("SKLAD"));
    }
    
    @Before
    @Test
    public void createConstantForUpdate() throws ParseException{
        
         given()
        .headers(
              "Authorization",
              "Bearer " + TOKEN.getToken(),
              "Content-Type",
              ContentType.JSON,
              "Accept",
              ContentType.JSON)
                 .body(constant).log().all()
                 .when()
                 .post("http://localhost:8080/rest/constant")
                 .then().log().all().statusCode(200).body(containsString("SKLAD_MEAT"));
    }
    
    

    
    
    
  /*  @Before
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
    }*/
    
    
}
