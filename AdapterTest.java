/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.InputStream;
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
public class AdapterTest {
    
    public AdapterTest() {
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
     * Test of connect method, of class Adapter.
     */
    @Test
    public void testConnect() {
        System.out.println("connect");
        String input = "";
        String expResult = "";
        String result = Adapter.connect(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseRequest method, of class Adapter.
     */
    @Test
    public void testParseRequest() throws Exception {
        System.out.println("parseRequest");
        String[] expResult = null;
        String[] result = Adapter.parseRequest();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class Adapter.
     */
    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        Adapter.login();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHostInterfaceID method, of class Adapter.
     */
    @Test
    public void testGetHostInterfaceID() throws Exception {
        System.out.println("getHostInterfaceID");
        String hostID = "";
        String expResult = "";
        String result = Adapter.getHostInterfaceID(hostID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createGroup method, of class Adapter.
     */
    @Test
    public void testCreateGroup() throws Exception {
        System.out.println("createGroup");
        Adapter.createGroup();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createItems method, of class Adapter.
     */
    @Test
    public void testCreateItems() throws Exception {
        System.out.println("createItems");
        String appName = "";
        String hostID = "";
        Adapter.createItems(appName, hostID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createGraphs method, of class Adapter.
     */
    @Test
    public void testCreateGraphs() throws Exception {
        System.out.println("createGraphs");
        String graphName = "";
        String item = "";
        Adapter.createGraphs(graphName, item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createHost method, of class Adapter.
     */
    @Test
    public void testCreateHost() throws Exception {
        System.out.println("createHost");
        String IP = "";
        Adapter.createHost(IP);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fromString method, of class Adapter.
     */
    @Test
    public void testFromString() throws Exception {
        System.out.println("fromString");
        String str = "";
        InputStream expResult = null;
        InputStream result = Adapter.fromString(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHost method, of class Adapter.
     */
    @Test
    public void testGetHost() throws Exception {
        System.out.println("getHost");
        String hostName = "";
        String expResult = "";
        String result = Adapter.getHost(hostName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete_Item method, of class Adapter.
     */
    @Test
    public void testDelete_Item() throws Exception {
        System.out.println("delete_Item");
        String hostID = "";
        String appName = "";
        Adapter.delete_Item(hostID, appName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get_Item method, of class Adapter.
     */
    @Test
    public void testGet_Item() throws Exception {
        System.out.println("get_Item");
        String hostID = "";
        String appName = "";
        String expResult = "";
        String result = Adapter.get_Item(hostID, appName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testClient method, of class Adapter.
     */
    @Test
    public void testTestClient() throws Exception {
        System.out.println("testClient");
        Adapter.testClient();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
