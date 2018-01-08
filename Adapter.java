package monitoring;

import org.mule.api.annotations.param.Payload;

import groovy.json.JsonParser;

import java.io.FileNotFoundException;

import org.json.JSONArray;
import org.json.JSONException;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PutMethod;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Adapter {
	
	private static String auth;
	private static String response;
	private static String ZABBIX_API_URL = "http://localhost/zabbix/api_jsonrpc.php"; // http://localhost/zabbix/api_jsonrpc.php URL
	private static HttpClient client;
	public static String GroupID = "18";
	
	private static String request;
	
	 
    public static String connect(@Payload String input){
    	
    	try {
    		
    		request = input;
	    	
    		// Parse the input json
    		String [] request_elements = parseRequest();
    		
    		System.out.println(Arrays.toString(request_elements));
	    	
	    	// Login user
	    	client = new HttpClient();
			login();
			
			// Create host
			createHost(request_elements[2]);
			
			// Find host ID
			String hostID = getHost(request_elements[2]);
	    	
			
	    	// Is this process for deploy or undeploy
			// create_dep for deploy, delete_dep for undeploy
	    	if(request_elements[0].equals("create_dep")){
	    		//create item
	    		System.out.println("create");
	    		createItems(request_elements[1], hostID);
	    		
	    		
	    	}
	    	else{
	    		// delete item

	    		delete_Item(hostID, request_elements[1]);
	    		System.out.println("delete" + hostID);
	    	}
	    	
	    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
    	return null;
        
    }
    
    public static String [] parseRequest(){
    	
    	String [] requestElements = new String[3];
    	
    	JSONObject requestJson = new JSONObject(request);
    	
    	requestElements[0] = (String) requestJson.get("method");
    	requestElements[1] = (String) requestJson.get("app_name");
    	requestElements[2] = (String) requestJson.get("public_ip");
    	
    	return requestElements;
    	
    }
    
    @SuppressWarnings("deprecation")
	public static void login() throws JSONException, FileNotFoundException, UnsupportedEncodingException, ParseException, HttpException, IOException{
    	
    	PutMethod  putmethod_login = new PutMethod(ZABBIX_API_URL);
    	putmethod_login.setRequestHeader("Content-Type", "application/json-rpc");
    	
    	
    	putmethod_login.setRequestBody(fromString(ZabbixApi.loginUser("Admin", "zabbix").toString())); 
    	
    	client.executeMethod(putmethod_login);
    	
    	// read the result of the response
    	String loginResponse = putmethod_login.getResponseBodyAsString(); 
    	
    	JSONObject jsonobj = new JSONObject(loginResponse);
		auth = (String) jsonobj.get("result");
    	
    }
    @SuppressWarnings("deprecation")
	public static String getHostInterfaceID(String hostID) throws JSONException, FileNotFoundException, UnsupportedEncodingException, ParseException, HttpException, IOException{
    	
    	PutMethod  putmethod_interface = new PutMethod(ZABBIX_API_URL);
    	putmethod_interface.setRequestHeader("Content-Type", "application/json-rpc");
    	
    	
    	putmethod_interface.setRequestBody(fromString(ZabbixApi.getHostInterfaceID(hostID, auth).toString())); 
    	
    	client.executeMethod(putmethod_interface);
    	
    	// read the result of the response
    	String interface_Response = putmethod_interface.getResponseBodyAsString(); 
    	//System.out.println(interface_Response);
    	
    	    	
    	JSONObject response_json = new JSONObject(interface_Response);
    	
    	JSONArray result = response_json.getJSONArray("result");
    	return (String)result.getJSONObject(0).get("interfaceid");
    }
    
    
    
    @SuppressWarnings("deprecation")
	public static void createGroup() throws JSONException, FileNotFoundException, UnsupportedEncodingException, ParseException, HttpException, IOException{
    	
    	PutMethod putMethod_creategroup = new PutMethod(ZABBIX_API_URL);
    	putMethod_creategroup.setRequestHeader("Content-Type", "application/json-rpc"); 
    	
    	
    	putMethod_creategroup.setRequestBody(fromString(ZabbixApi.createHostGroup("DevOpsPCs", auth).toString())); 
    	
    	
    	client.executeMethod(putMethod_creategroup);
    	
    	// read the result of the response
    	//String response = putMethod_creategroup.getResponseBodyAsString(); 
    	
    }
    

    @SuppressWarnings("deprecation")
	public static void createItems(String appName, String hostID) throws JSONException, FileNotFoundException, UnsupportedEncodingException, ParseException, HttpException, IOException{
    	
    	// Create 2 items for memory and CPU
    	PutMethod putMethod_item = new PutMethod(ZABBIX_API_URL);
    	putMethod_item.setRequestHeader("Content-Type", "application/json-rpc"); 
    	
		PutMethod putMethod_item2= new PutMethod(ZABBIX_API_URL);
		putMethod_item2.setRequestHeader("Content-Type", "application/json-rpc");
		
		PutMethod putMethod_item3= new PutMethod(ZABBIX_API_URL);
		putMethod_item3.setRequestHeader("Content-Type", "application/json-rpc");
    	
    	// Create 2 items memory and CPU
		
		String [] apps = new String[1];
		apps[0] = "15";
		
    	putMethod_item.setRequestBody(fromString(ZabbixApi.createItem(appName + " memory_usage", "proc.mem["+appName+"]",
    			hostID, "0", "3", getHostInterfaceID(hostID), apps, "30s", auth).toString())); 
    	
    	putMethod_item2.setRequestBody(fromString(ZabbixApi.createItem(appName + " CPU_usage", "proc.cpu.util["+appName+"]",
    			hostID, "0", "3", getHostInterfaceID(hostID), apps, "30s", auth).toString())); 
    	
    	putMethod_item3.setRequestBody(fromString(ZabbixApi.createItem(appName + " Number_of_processes", "proc.num["+appName+"]",
    			hostID, "0", "3", getHostInterfaceID(hostID), apps, "30s", auth).toString())); 
    	
    	// MEMORY USAGE
    	client.executeMethod(putMethod_item);
    	
    	// read the result of the response
    	String response = putMethod_item.getResponseBodyAsString(); 
    	//System.out.println("Result"+response);
    	
    	JSONObject response_json = new JSONObject(response);
    	
    	JSONObject itemid = (JSONObject) response_json.get("result");
    	
    	String item_id = itemid.get("itemids").toString();
    	
    	item_id= item_id.substring(2,item_id.length()-2 );
    	
    	//System.out.println("Item ID:   "+item_id);
    	createGraphs(appName + " Memory Usage", item_id);
    	
    	
    	// CPU USAGE 
    	client.executeMethod(putMethod_item2);
    	response = putMethod_item2.getResponseBodyAsString(); 
    	//System.out.println("Result"+response);
    	
    	response_json = new JSONObject(response);
    	
    	itemid = (JSONObject) response_json.get("result");
    	
    	item_id = itemid.get("itemids").toString();
    	
    	item_id= item_id.substring(2,item_id.length()-2 );
    	
    	//ystem.out.println("Item ID:   "+item_id);
    	createGraphs(appName + " CPU Usage", item_id);
    	
    	// NUMBER OF PROCESSES
    	client.executeMethod(putMethod_item3);
    	response = putMethod_item3.getResponseBodyAsString(); 
    	//System.out.println("Result"+response);
    	
    	response_json = new JSONObject(response);
    	
    	itemid = (JSONObject) response_json.get("result");
    	
    	item_id = itemid.get("itemids").toString();
    	
    	item_id= item_id.substring(2,item_id.length()-2 );
    	
    	//System.out.println("Item ID:   "+item_id);
    	createGraphs(appName + " Number of Processes", item_id);
    	
    	
    }
    
    public static void createGraphs(String graphName, String item) throws JSONException, FileNotFoundException, UnsupportedEncodingException, ParseException, HttpException, IOException{
    	
    	// Create 2 items for memory and CPU
    	PutMethod putMethod_graph = new PutMethod(ZABBIX_API_URL);
    	putMethod_graph.setRequestHeader("Content-Type", "application/json-rpc"); 
		
    	JSONArray gitems = new JSONArray();
		JSONObject cpu = new JSONObject();
		JSONObject memory = new JSONObject();
		
		
		// gitems.put(value)
		putMethod_graph.setRequestBody(fromString(ZabbixApi.createGraph(graphName, item, auth).toString())); 
    	
    	client.executeMethod(putMethod_graph);
    	
    	// read the result of the response
    	String response = putMethod_graph.getResponseBodyAsString(); 
    	System.out.println("Result"+response);
    	
    	
    	//client.executeMethod(putMethod_item);
    	
    }

    @SuppressWarnings("deprecation")
	public static void createHost(String IP) throws JSONException, FileNotFoundException, UnsupportedEncodingException, ParseException, HttpException, IOException{
    	
    	PutMethod putMethod_createhost = new PutMethod(ZABBIX_API_URL);
    	putMethod_createhost.setRequestHeader("Content-Type", "application/json-rpc");
    	
    	JSONObject element = new JSONObject();
		element.put("type", "1");
		element.put("main", "1");
		element.put("useip", "1");
		element.put("ip", IP);
		element.put("dns", "");
		element.put("port", "10050");
		JSONArray  interfaces = new JSONArray();
		interfaces.put(element);
		
		JSONObject element2 = new JSONObject();
		element2.put("groupid", GroupID);
		JSONArray group = new JSONArray();
		group.put(element2);
    	
    	putMethod_createhost.setRequestBody(fromString(ZabbixApi.createHost(IP,interfaces,group, auth).toString())); 
    	
    	
    	client.executeMethod(putMethod_createhost);
    	
    }
   
    public static InputStream fromString(String str) throws UnsupportedEncodingException {
		byte[] bytes = str.getBytes("UTF-8");
		return new ByteArrayInputStream(bytes);
	}

    public static String getHost(String hostName) throws JSONException, FileNotFoundException, UnsupportedEncodingException, ParseException, HttpException, IOException
    {
    	PutMethod putMethod_get_host = new PutMethod(ZABBIX_API_URL);
    	putMethod_get_host.setRequestHeader("Content-Type", "application/json-rpc"); 
    	
    	String [] hostnames = new String[1];
    	hostnames[0] = hostName;
    	
    	putMethod_get_host.setRequestBody(fromString(ZabbixApi.getHost(hostnames, auth).toString())); 
    	
    	client.executeMethod(putMethod_get_host);
    	
    	String response = putMethod_get_host.getResponseBodyAsString(); 
    	JSONObject response_json = new JSONObject(response);
    	
    	JSONArray result = response_json.getJSONArray("result");
    	String host_id = (String) result.getJSONObject(0).get("hostid");
    	//System.out.println("Result"+result+"host=>"+host_id);
    	
    	return host_id;
    }
    
    public static void delete_Item(String hostID, String appName) throws JSONException, FileNotFoundException, UnsupportedEncodingException, ParseException, HttpException, IOException
    {
    	PutMethod putMethod_delete_Item = new PutMethod(ZABBIX_API_URL);
    	putMethod_delete_Item.setRequestHeader("Content-Type", "application/json-rpc"); 
    
    	String[] itemIDs = get_Item(hostID, appName);	
    	
    	putMethod_delete_Item.setRequestBody(fromString(ZabbixApi.deleteItem(itemIDs, auth).toString())); 
    	
    	
    	client.executeMethod(putMethod_delete_Item);
    	
    }
    public static String[] get_Item(String hostID, String appName) throws JSONException, FileNotFoundException, UnsupportedEncodingException, ParseException, HttpException, IOException
    {
    	PutMethod putMethod_get_Item = new PutMethod(ZABBIX_API_URL);
    	putMethod_get_Item.setRequestHeader("Content-Type", "application/json-rpc"); 
    
    	
    	putMethod_get_Item.setRequestBody(fromString(ZabbixApi.getItem(hostID, appName, auth).toString()));
    	
    	client.executeMethod(putMethod_get_Item);
    	
    	String response = putMethod_get_Item.getResponseBodyAsString();
    	
    	JSONObject response_json = new JSONObject(response);
    	
    	JSONArray result = response_json.getJSONArray("result");
    	
    	String[] items = new String[3];
    	
    	items[0] = (String) result.getJSONObject(0).get("itemid");
    	items[1] = (String) result.getJSONObject(1).get("itemid");
    	items[2] = (String) result.getJSONObject(2).get("itemid");

    	return items;
    	
    }
    
    public static void testClient() throws JSONException, FileNotFoundException, UnsupportedEncodingException, ParseException {
    	
		HttpClient client = new HttpClient();
		
		String [] hostarr = new String[1];
		hostarr[0] = "Zabbix2";
		
		PutMethod putMethod = new PutMethod(ZABBIX_API_URL);
		PutMethod putMethod2 = new PutMethod(ZABBIX_API_URL);
		
		//putMethod.setRequestHeader("Content-Type", "application/json-rpc"); // content-type is controlled in api_jsonrpc.php, so set it like this
		putMethod2.setRequestHeader("Content-Type", "application/json-rpc"); 
		
		//putMethod.setRequestBody(fromString(ZabbixMethods.loginUser("Admin", "zabbix").toString())); 
		
		JSONObject element = new JSONObject();
		element.put("type", "1");
		element.put("main", "1");
		element.put("useip", "1");
		element.put("ip", "10.1.90.58");
		element.put("dns", "");
		element.put("port", "10050");
		JSONArray  interfaces = new JSONArray();
		interfaces.put(element);
		
		JSONObject element2 = new JSONObject();
		element2.put("groupid", "16");
		JSONArray group = new JSONArray();
		group.put(element2);
		String[] arr = new String[1];
		arr[0] = "16";
		putMethod2.setRequestBody(fromString(ZabbixApi.getHost(arr, "3c4a9b74964439fa8c5252df74b778df").toString())); 
		//putMethod2.setRequestBody(fromString(ZabbixMethods.createHost("DenemeHost2", interfaces, group, "3c4a9b74964439fa8c5252df74b778df").toString())); 
		//putMethod2.setRequestBody(fromString(ZabbixMethods.createHostGroup("denemeGroup", "3c4a9b74964439fa8c5252df74b778df").toString())); 
		String loginResponse = "";
		String GetResponse = "";
		
		try {
			//client.executeMethod(putMethod);
			client.executeMethod(putMethod2);// send to request to the zabbix api
			
			//loginResponse = putMethod.getResponseBodyAsString(); // read the result of the response
			GetResponse = putMethod2.getResponseBodyAsString();
			
			/*JSONObject jsonobj = new JSONObject(loginResponse);
			auth = (String) jsonobj.get("result");*/
			
			
			JSONObject deneme = new JSONObject(GetResponse);
			response = (String) deneme.get("jsonrpc");
			
			
			//System.out.println("Auth: "  + auth);
			System.out.println("KKKK: "  + response);
			//System.out.println("Zabbix server response: \n"+loginResponse); // print the result of the response
			System.out.println("Zabbix server response get_host: \n"+GetResponse); // print the result of the response
			
			
			
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
	
