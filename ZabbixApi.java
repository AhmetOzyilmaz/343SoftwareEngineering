import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class ZabbixApi {

    //
    // HOST FUNCTIONS
    //

    //This method allows to create new hosts.
    public static JSONObject createHost(String hostName, JSONObject interfaces,  JSONObject groups, String auth) throws JSONException {

        JSONObject jo = new JSONObject();
        jo.put("host", hostName);
        jo.put("interfaces", interfaces);
        jo.put("groups", groups);

       return method("host.create", jo, null, auth);
    }

    //This method allows to delete hosts.
    public static JSONObject deleteHost(String[] ids, String auth) throws JSONException {

        JSONObject jo = new JSONObject(ids);

        return method("host.delete", jo, null, auth);
    }


    //This method checks if at least one host that matches the given filter criteria exists.
    public static JSONObject existsHost(String host, String[] nodeids, String auth) throws JSONException {

        JSONObject jo = new JSONObject();
        jo.put("host", host);
        jo.put("nodeids", nodeids);

         return method("host.exists", jo, null, auth);
    }

    //The method allows to retrieve hosts according to the given parameters.
    public static JSONObject getHost(String[] hostnames, String auth) throws JSONException {

        JSONObject jo = new JSONObject();
        JSONObject jo2 = new JSONObject();
        jo2.put("host", hostnames);
        jo.put("filter", jo2);

        return method("host.get", jo, null, auth);
    }

    //This method allows to update existing hosts.
    public static JSONObject updateHost(String hostid, int status, String auth) throws JSONException {

        JSONObject jo = new JSONObject();
        jo.put("hostid", hostid);
        jo.put("status", status);

        return method("host.update", jo, null, auth);
    }
    
    //
    // HOST GROUP FUNCTIONS
    //
    
    //This method allows to create new host groups.
    public static JSONObject createHostGroup(String name, String auth) throws JSONException {

        JSONObject jo = new JSONObject();
        jo.put("name", name);

       return method("hostgroup.update", jo, null, auth);
    }

    //This method allows to delete host groups.
    public static JSONObject deleteHostGroup(String[] ids, String auth) throws JSONException {

        JSONObject jo = new JSONObject(ids);

        return method("hostgroup.delete", jo, null, auth);
    }

    //This method checks if at least one host group that matches the given filter criteria exists.
    public static JSONObject existsHostGroup(String host, String[] nodeids, String auth) throws JSONException {

        JSONObject jo = new JSONObject();
        jo.put("name", host);
        jo.put("nodeids", nodeids);

        return method("hostgroup.exists", jo, null, auth);;
    }

    //The method allows to retrieve host groups according to the given parameters.
    public static JSONObject getHostGroup(String[] hostnames, String auth) throws JSONException {

        JSONObject jo = new JSONObject();
        JSONObject jo2 = new JSONObject();
        jo.put("output", "extend");
        jo2.put("name", hostnames);
        jo.put("filter", jo2);

        return method("hostgroup.get", jo, null, auth);
    }

    //This method allows to update existing hosts.
    public static JSONObject updateHostGroup(String groupid, String name, String auth) throws JSONException {

        JSONObject jo = new JSONObject();
        jo.put("groupid", groupid);
        jo.put("name", name);

        return method("hostgroup.update", jo, null, auth);
    }

    //
    // GRAPH FUNCTIONS
    //
    
    //This method allows to create new graphs.
    public static JSONObject createGraph(String name, int width, int height, JSONObject[] gitems, String auth) throws JSONException {

        JSONObject jo = new JSONObject();
        jo.put("name", name);
        jo.put("width", width);
        jo.put("height", height);
        jo.put("gitems", gitems);

        return method("graph.create", jo, null, auth);
    }

    public static JSONObject deleteGraph(String[] graphids, String auth) throws JSONException {

        JSONObject jo = new JSONObject(graphids);

        return method("graph.delete", jo, null, auth);
    }

    //This method checks if at least one graph that matches the given filter criteria exists.
    public static JSONObject existsGraph(String name, String host, String auth) throws JSONException {

        JSONObject jo = new JSONObject();
        jo.put("name", name);
        jo.put("host", host);

        return method("graph.exists", jo, null, auth);
    }

    //This method allows to update existing graphs.
    public static JSONObject updateGraph(JSONObject[] gitems, String auth) throws JSONException {

        JSONObject jo = new JSONObject(gitems);

        return method("graph.update", jo, null, auth);
    }


    public static JSONObject createItem(String name, String key, String hostID, String type, String value_type, String interfaceid, 
                                        String[] applications, String delay, String auth) throws JSONException {

    JSONObject jo = new JSONObject();
    jo.put("name", name);
    jo.put("hostid", hostID);
    jo.put("type", type);
    jo.put("value_type", value_type);
    jo.put("interfaceid", interfaceid);
    jo.put("applications", applications);
    jo.put("delay", delay);


    return method("item.create", jo, null, auth);

    }

    public static JSONObject getItem(String output, String hostids, String search, String sortfield,
    String auth) throws JSONException {

    JSONObject jo = new JSONObject();
    jo.put("output", output);
    jo.put("hostids", hostids);
    jo.put("search", search);
    jo.put("sortfield", sortfield);

    return method("item.get", jo, null, auth);

    }

    public static JSONObject deleteItem(String [] items, String auth) throws JSONException {

    return method("item.delete", null, items, auth);

    }

    public static JSONObject updateItem(String itemid, String status, String auth) throws JSONException {

    JSONObject jo = new JSONObject();
    jo.put("itemid", itemid);
    jo.put("status", status);

    return method("item.update", jo, null, auth);

    }
    
    //
    // USER FUNCTIONS
    //

    /* public static JSONObject authenticateUser(String alias, String passwd, String auth) throws JSONException {

        JSONObject jo = new JSONObject();
        jo.put("alias", alias);
        jo.put("passwd", passwd);

        return method("user.create", jo,  auth);
    } */

    public static JSONObject createUser(String alias, String passwd, String auth) throws JSONException {

        JSONObject jo = new JSONObject();
        jo.put("alias", alias);
        jo.put("passwd", passwd);

        return method("user.create", jo, null, auth);
    }

    public static JSONObject deleteUser(String[] userIds, String auth) throws JSONException {

        JSONObject jo = new JSONObject();

        for (int i = 0; i < userIds.length; i++){

        }

        return method("user.create", jo, null, auth);
    }

    //When using this method, you also need to do user.logout to
    // prevent the generation of a large number of open session records.
    public static JSONObject loginUser(String user, String password) throws JSONException {

        JSONObject jo = new JSONObject();
        jo.put("user", user);
        jo.put("password", password);

        return method("user.login", jo, null, null);
    }

    public static JSONObject loginUser(String user, String password, Boolean userData) throws JSONException {

        JSONObject jo = new JSONObject();
        jo.put("user", user);
        jo.put("password", password);
        jo.put("userData", userData);

        return method("user.login", jo, null, null);
    }

    public static JSONObject logoutUser(String[] id, Boolean userData) throws JSONException {

        JSONObject jo = new JSONObject();

        return method("user.logout", jo, null, null);
    }


    public static JSONObject getUser(String output, String auth) throws JSONException {

        JSONObject jo = new JSONObject();
        jo.put("output", output);

        return method("user.get", jo, null, auth);
    }

    public static JSONObject updateUser(String userid, String name, String surname, String auth) throws JSONException {

        JSONObject jo = new JSONObject();
        jo.put("userid", userid);
        jo.put("name", name);
        jo.put("surname", surname);

        return method("user.update", jo, null, auth);
    }

    //This method allows to update the currently logged in user.
    public static JSONObject updateprofileUser(String name, String lastname, String auth) throws JSONException {

        JSONObject jo = new JSONObject();
        jo.put("name", name);
        jo.put("lastname", lastname);

        return method("user.updateprofile", jo, null, auth);
    }
    
    
    // method(String methodName, JSONOBject json_param, String[] str_param, String auth)
    private static JSONObject method(String methodName, JSONObject json_param, String[] str_param, String auth) throws JSONException {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("jsonrpc", "2.0");
        jsonObject.put("method", methodName);

        // Params
        if (json_param == null)
            jsonObject.put("params", str_param);
        else
            jsonObject.put("params", json_param);

        if (auth != null)
            jsonObject.put("auth", auth);

        // id
        jsonObject.put("id", "1");

        return jsonObject;
    }
    
    public static void main(String args[]) throws IOException, JSONException {

        JSONObject jsonParam = new JSONObject();
        String[] strings = new String[5];
        jsonParam = deleteHost( strings, "auyt");

        System.out.println(jsonParam.toString());

    }


}
