/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author m2e
 */
public class CalculatorTest {
   
    public CalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("setUpClass Method Executed: ");       
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("tearDownClass Method Executed: ");       
    }
    
    static Calculator c;
    @Before
    public void setUp() {
        System.out.println("setUp Method Executed: ");    
        c = new Calculator();
    }
    
    @After
    public void tearDown() {
         System.out.println("tearDown Method Executed: ");       
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    // Annotation for devlaring method as a unit test method
    @Test
    public void testAdd_01(){
//        Calculator c = new Calculator();
        assertNotNull(c);
        double result = c.add(10,20);
        assertTrue(result>0);
        assertEquals(30,result, 0.0);
    }

    @Test
    public void testAdd_02(){
//        Calculator c = new Calculator();
        assertNotNull(c);
        double result = c.add(-20,10);
        assertEquals(-10,result, 0.0);
    }
    
    @Test
    public void testSub_01(){
        System.out.println("testSub_01 20 - 10 = 10");
//        Calculator c = new Calculator();
        assertNotNull(c);
        double result = c.sub(20,10);
        assertTrue(result > 0);
        assertEquals(10, result, 0.0);
    }

    @Test
    public void testSub_02(){
        System.out.println("testSub_02 -5 - (-10) = 5");
//        Calculator c = new Calculator();
        assertNotNull(c);
        double result = c.sub(-5,-10);
        assertEquals(5, result, 0.0);
    }
    
    @Ignore
    @Test
    public void testSub_03(){
//        Calculator c = new Calculator();
        assertNotNull(c);
        double result = c.sub(5,-10);
        assertEquals(15,result, 0.0);
    }
    
//    @Ignore
    @Test(expected=NullPointerException.class)
    public void testException_01(){
//        Calculator c = new Calculator();
        Calculator c1;
        c1 = new Calculator();
        c1 = null ;
        double result = c1.add(-20,10);
        assertEquals(-10,result, 0.0);
    }
}
