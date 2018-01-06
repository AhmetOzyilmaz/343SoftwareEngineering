/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bilmuhlab
 */
public class ZabbixApiTest {
    
    public ZabbixApiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createHost method, of class ZabbixApi.
     */
    @Test
    public void testCreateHost() throws Exception {
        System.out.println("createHost");
        String hostName = "";
        JSONArray interfaces = null;
        JSONArray groups = null;
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.createHost(hostName, interfaces, groups, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteHost method, of class ZabbixApi.
     */
    @Test
    public void testDeleteHost() throws Exception {
        System.out.println("deleteHost");
        String[] ids = null;
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.deleteHost(ids, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existsHost method, of class ZabbixApi.
     */
    @Test
    public void testExistsHost() throws Exception {
        System.out.println("existsHost");
        String host = "";
        String[] nodeids = null;
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.existsHost(host, nodeids, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHost method, of class ZabbixApi.
     */
    @Test
    public void testGetHost() throws Exception {
        System.out.println("getHost");
        String[] hostnames = null;
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.getHost(hostnames, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHostInterfaceID method, of class ZabbixApi.
     */
    @Test
    public void testGetHostInterfaceID() throws Exception {
        System.out.println("getHostInterfaceID");
        String hostID = "";
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.getHostInterfaceID(hostID, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateHost method, of class ZabbixApi.
     */
    @Test
    public void testUpdateHost() throws Exception {
        System.out.println("updateHost");
        String hostid = "";
        int status = 0;
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.updateHost(hostid, status, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createHostGroup method, of class ZabbixApi.
     */
    @Test
    public void testCreateHostGroup() throws Exception {
        System.out.println("createHostGroup");
        String name = "";
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.createHostGroup(name, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteHostGroup method, of class ZabbixApi.
     */
    @Test
    public void testDeleteHostGroup() throws Exception {
        System.out.println("deleteHostGroup");
        String[] ids = null;
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.deleteHostGroup(ids, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existsHostGroup method, of class ZabbixApi.
     */
    @Test
    public void testExistsHostGroup() throws Exception {
        System.out.println("existsHostGroup");
        String host = "";
        String[] nodeids = null;
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.existsHostGroup(host, nodeids, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHostGroup method, of class ZabbixApi.
     */
    @Test
    public void testGetHostGroup() throws Exception {
        System.out.println("getHostGroup");
        String[] hostnames = null;
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.getHostGroup(hostnames, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateHostGroup method, of class ZabbixApi.
     */
    @Test
    public void testUpdateHostGroup() throws Exception {
        System.out.println("updateHostGroup");
        String groupid = "";
        String name = "";
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.updateHostGroup(groupid, name, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createGraph method, of class ZabbixApi.
     */
    @Test
    public void testCreateGraph() throws Exception {
        System.out.println("createGraph");
        String name = "";
        String item = "";
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.createGraph(name, item, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteGraph method, of class ZabbixApi.
     */
    @Test
    public void testDeleteGraph() throws Exception {
        System.out.println("deleteGraph");
        String[] graphids = null;
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.deleteGraph(graphids, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existsGraph method, of class ZabbixApi.
     */
    @Test
    public void testExistsGraph() throws Exception {
        System.out.println("existsGraph");
        String name = "";
        String host = "";
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.existsGraph(name, host, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateGraph method, of class ZabbixApi.
     */
    @Test
    public void testUpdateGraph() throws Exception {
        System.out.println("updateGraph");
        JSONObject[] gitems = null;
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.updateGraph(gitems, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createItem method, of class ZabbixApi.
     */
    @Test
    public void testCreateItem() throws Exception {
        System.out.println("createItem");
        String name = "";
        String key = "";
        String hostID = "";
        String type = "";
        String value_type = "";
        String interfaceid = "";
        String[] applications = null;
        String delay = "";
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.createItem(name, key, hostID, type, value_type, interfaceid, applications, delay, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class ZabbixApi.
     */
    @Test
    public void testGetItem() throws Exception {
        System.out.println("getItem");
        String hostids = "";
        String appName = "";
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.getItem(hostids, appName, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteItem method, of class ZabbixApi.
     */
    @Test
    public void testDeleteItem() throws Exception {
        System.out.println("deleteItem");
        String[] items = null;
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.deleteItem(items, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateItem method, of class ZabbixApi.
     */
    @Test
    public void testUpdateItem() throws Exception {
        System.out.println("updateItem");
        String itemid = "";
        String status = "";
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.updateItem(itemid, status, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createUser method, of class ZabbixApi.
     */
    @Test
    public void testCreateUser() throws Exception {
        System.out.println("createUser");
        String alias = "";
        String passwd = "";
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.createUser(alias, passwd, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class ZabbixApi.
     */
    @Test
    public void testDeleteUser() throws Exception {
        System.out.println("deleteUser");
        String[] userIds = null;
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.deleteUser(userIds, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginUser method, of class ZabbixApi.
     */
    @Test
    public void testLoginUser_String_String() throws Exception {
        System.out.println("loginUser");
        String user = "";
        String password = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.loginUser(user, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginUser method, of class ZabbixApi.
     */
    @Test
    public void testLoginUser_3args() throws Exception {
        System.out.println("loginUser");
        String user = "";
        String password = "";
        Boolean userData = null;
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.loginUser(user, password, userData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logoutUser method, of class ZabbixApi.
     */
    @Test
    public void testLogoutUser() throws Exception {
        System.out.println("logoutUser");
        String[] id = null;
        Boolean userData = null;
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.logoutUser(id, userData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class ZabbixApi.
     */
    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        String output = "";
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.getUser(output, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class ZabbixApi.
     */
    @Test
    public void testUpdateUser() throws Exception {
        System.out.println("updateUser");
        String userid = "";
        String name = "";
        String surname = "";
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.updateUser(userid, name, surname, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateprofileUser method, of class ZabbixApi.
     */
    @Test
    public void testUpdateprofileUser() throws Exception {
        System.out.println("updateprofileUser");
        String name = "";
        String lastname = "";
        String auth = "";
        JSONObject expResult = null;
        JSONObject result = ZabbixApi.updateprofileUser(name, lastname, auth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
