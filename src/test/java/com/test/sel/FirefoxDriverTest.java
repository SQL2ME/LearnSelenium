/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.GeckoDriverService;

/**
 *
 * @author m2e
 */
public class FirefoxDriverTest {
    
    public FirefoxDriverTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    WebDriver driver;
     
    @Before
    public void setUp() {
        System.setProperty("webdrive.gecko.driver","C:\\Drivers\\SeleniumWebDriver\\geckodriver.exe");
    }

   @Test
    public void testDriver() {
         driver = new FirefoxDriver();
         assertNotNull(driver);
     }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
