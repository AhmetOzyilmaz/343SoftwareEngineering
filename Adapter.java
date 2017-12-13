package com.exp;

import org.mule.api.annotations.param.Payload;

import java.io.FileNotFoundException;

import org.json.JSONException;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PutMethod;
import org.json.JSONException;
import org.json.JSONObject;

public class Adapter {
	
	private static String ZABBIX_API_URL = "http://localhost/zabbix/api_jsonrpc.php"; // 1.2.3.4 is your zabbix_server_ip
    public static String deneme(@Payload String input) throws JSONException, FileNotFoundException, UnsupportedEncodingException{
    	System.out.println(input);
        Converter converter_obj = new Converter(input); 
        converter_obj.JSONtoXML();
        
        testClient();
        return converter_obj.getOutput();
    	
    }
    public static InputStream fromString(String str) throws UnsupportedEncodingException {
		byte[] bytes = str.getBytes("UTF-8");
		return new ByteArrayInputStream(bytes);
	}
    public static void testClient() throws JSONException, FileNotFoundException, UnsupportedEncodingException {
    	
    
		HttpClient client = new HttpClient();
		
		PutMethod putMethod = new PutMethod(ZABBIX_API_URL);
		putMethod.setRequestHeader("Content-Type", "application/json-rpc"); // content-type is controlled in api_jsonrpc.php, so set it like this
		JSONObject jsonMain=new JSONObject();
		jsonMain.put("jsonrpc", "2.0");
		jsonMain.put("method", "user.login");
		JSONObject jsonMain2=new JSONObject();
		jsonMain2.put("user", "Admin");
		jsonMain2.put("password", "zabbix");
		jsonMain.put("params", jsonMain2);
		jsonMain.put("id", "1");
		
		
		// create json object for apiinfo.version 
		//JSONObject jsonObj=new JSONObject("{\"jsonrpc\":\"2.0\",\"method\":\"user.login\",\"params\":{\"user\":\"Admin\",\"password\":\"zabbix\"},\"id\":1}");
		
		putMethod.setRequestBody(fromString(jsonMain.toString())); // put the json object as input stream into request body 
		
		System.out.println("jsonMainBizyaptık:\n"+jsonMain);
		
		String loginResponse = "";
		
		try {
			client.executeMethod(putMethod); // send to request to the zabbix api
			
			loginResponse = putMethod.getResponseBodyAsString(); // read the result of the response
			
			System.out.println("loginResponse: \n"+loginResponse); // print the result of the response
			
			/*// Work with the data using methods like...
			JSONObject obj = new JSONObject(loginResponse); 
			String id = obj.getString("id");
			String result = obj.getString("result");
			System.out.println("id:"+id);
			System.out.println("result:"+result);*/
			
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
}