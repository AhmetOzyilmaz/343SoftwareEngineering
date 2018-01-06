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
        String input = "123";
        String expResult = "expRes";
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
        String hostID = "1234";
        String expResult = "result";
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
        String appName = "app1";
        String hostID = "123";
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
        String graphName = "grap1";
        String item = "itemm1";
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
        String IP = "123456";
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
        String str = "stringtest";
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
        String hostName = "hostFirst";
        String expResult = "expResult";
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
        String hostID = "12345";
        String appName = "chessGame";
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
        String hostID = "1234";
        String appName = "chessName";
        String expResult = "expRes";
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
