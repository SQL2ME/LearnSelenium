/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author m2e
 */
public class GoogleTest {
    
    public GoogleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    // Instance variable for storing driver
    WebDriver driver;
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Drivers\\SeleniumWebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

//Week 19 added to code:       
        //default time to 10 seconds.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testSearch() {
        //What site do you want to navigate to?
        driver.get("http://www.google.com");
        //Google search textbox name is Q
        WebElement e = driver.findElement(By.name("q"));
        e.sendKeys("selenium jobs");
        e.submit();
        
        //Take ans store a screenshot:
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        src.renameTo(new File("C:\\Users\\m2eic\\OneDrive\\Training\\IT Experts\\Java\\ScreenShots\\searchimage.png"));
        
        // Verification Step that right page is displayed by checking pagetitle:
        assertTrue(driver.getTitle().contains("selenium jobs"));
//        assertTrue(driver.getTitle().contains("java jobs"));
    }    
    
    @Test
    public void testNavigation(){
        // Goto site using navigation object
        driver.navigate().to("http://www.google.com");
        driver.navigate().to("http://www.ibm.com");

        // Load previous site
        driver.navigate().back();

        // Load next site
        driver.navigate().forward();

        //Refresh current page
        driver.navigate().refresh();
        
    }

    @Test
    public void testLocators() {
        //What site do you want to navigate to?
        driver.get("https://nlilaramani.github.io/");
        //Google search textbox name is Q
        driver.findElement(By.partialLinkText("User Registration")).click();
        driver.findElement(By.id("fname")).sendKeys("Mickey");
        driver.findElement(By.name("lname")).sendKeys("Mouse");
        driver.findElement(By.cssSelector("#username")).sendKeys("mmouse");
        driver.findElement(By.className("pwd")).sendKeys("minnie");
        
//Week 19 added to code
    //IF locator used by more than 1 element you can tell it which one
    // out of "g" get me second element (first is 0)
    
    //Method 1:
        driver.findElements(By.name("g")).get(1).click();
    
    //Method 2:    
        driver.findElements(By.xpath("//input[@name='g']")).get(1).click();
        
        
        //give me an element who's type value is submit:
    //   driver.findElement(By.xpath("//input[@type='submit']")).click();
        
        // Cause textbox to have MickeyMickeyMickey
        driver.findElement(By.id("fname")).sendKeys("Mickey");
        driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("Mickey"); 

        //Remove existing content this by clearing textbox first:
        driver.findElement(By.xpath("//input[@id='fname']")).clear();
        driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("Mickey"); 

        //Method 1:
        //driver.findElement(By.tagName("select")).sendKeys("Bachelors");

        //Method 2:
        WebElement e = driver.findElement(By.tagName("select"));
        Select dropdown = new Select(e);
        dropdown.selectByIndex(1);        
        
        if (!driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected()){
            driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        }
        
    }
    
    @Test
    public void testAlert() throws InterruptedException{
        driver.get("https://nlilaramani.github.io/frame.html");
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }
    
    @After
    public void tearDown() {
        // Close the browser
//        driver.quit();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

//Week 20 added to code
    @Test
    public void testUserprofileDataDriven() throws FileNotFoundException, IOException, InterruptedException{
//        FileInputStream fs=new FileInputStream(new File("c:\\qa\\testdata.xlsx"));
        String filename = "C:\\Users\\m2eic\\OneDrive\\Training\\IT Experts\\Java\\W20TestData.xlsx";
        FileInputStream fs=new FileInputStream(new File(filename));
        
        Workbook wb=new XSSFWorkbook(fs);
       
        Sheet sh=wb.getSheetAt(0);
        String fname=sh.getRow(1).getCell(0).getStringCellValue();
        String lname=sh.getRow(1).getCell(1).getStringCellValue();
        String uname=sh.getRow(1).getCell(2).getStringCellValue();
        String pwd=sh.getRow(1).getCell(3).getStringCellValue();
        String gender=sh.getRow(1).getCell(4).getStringCellValue();
        String qual=sh.getRow(1).getCell(5).getStringCellValue();
        driver.get("https://nlilaramani.github.io");
        driver.findElement(By.partialLinkText("User Registration")).click();
        driver.findElement(By.id("fname")).sendKeys(fname);
        driver.findElement(By.name("lname")).sendKeys(lname);
        //driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.cssSelector("#username")).sendKeys(uname);
        //driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.className("pwd")).sendKeys(pwd);
        if(gender.equalsIgnoreCase("M"))
            driver.findElements(By.name("g")).get(0).click();
        else
            driver.findElements(By.name("g")).get(1).click();
        driver.findElement(By.tagName("select")).sendKeys(qual);
       
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@type='submit']")).submit();
       
        fs.close();
    }
}
