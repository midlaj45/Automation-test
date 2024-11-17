package com.example.autoamte;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;
 
import static org.junit.jupiter.api.Assertions.assertTrue;
 
public class LoginTest {
 
    static WebDriver driver;
 
    @BeforeAll
    public static void setUp() {
        // Set up WebDriverManager and initialize the ChromeDriver
    	WebDriverManager.chromedriver().driverVersion("130.0.6723.116").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize the browser window
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));
       

        // Add before trying to locate the element
        WebDriverWait wait = new WebDriverWait(driver, null);
        

       
    }
 
    @Test
    public void testPositiveLogin() {
        // Open the login page

    	driver.get("https://practicetestautomation.com/practice-test-login/");
        // Find the Username field and enter the username "student"
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("student");
 
        // Find the Password field and enter the password "Password123"
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Password123");
 
        // Find and click the Submit button
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
 
        // Verify that the URL contains "logged-in-successfully"
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("practicetestautomation.com/logged-in-successfully/"));
        try {
            Thread.sleep(3000); // Wait for 3 seconds after clicking
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement successMessage = driver.findElement(By.xpath("//strong[contains(text(),'Congratulations student. You successfully logged in!')]"));
        
        // Verify that the "Congratulations" message is displayed
        assertTrue(successMessage.isDisplayed());
       
        WebElement logoutButton = driver.findElement(By.linkText("Log out"));
        assertTrue(logoutButton.isDisplayed());
        
    }
    
    @Test
    public void testNegativeUsername() {
    	
    	driver.get("https://practicetestautomation.com/practice-test-login/");
        // Find the Username field and enter the invalid username "incorrectUser"
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("incorrectUser");
 
        // Find the Password field and enter the password "Password123"
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Password123");
 
        // Find and click the Submit button
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
 
        // Wait for the page to update and try to locate the error message
        try {
            Thread.sleep(2000); // Wait for 2 seconds to ensure error message is visible
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        // Locate the error message
        WebElement errorMessage = driver.findElement(By.id("error"));
 
        // Verify that the error message is displayed
        assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");
 
        String errorMessageText = errorMessage.getText().trim();
        assertTrue(errorMessageText.contains("Your username is invalid!"),
                "Expected error message: 'Your username is invalid!', but got: " + errorMessageText);
    }
    
    @Test
    public void testNegativepassword() {
    	
    	driver.get("https://practicetestautomation.com/practice-test-login/");
        // Find the Username field and enter the invalid username "incorrectUser"
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("student");
 
        // Find the Password field and enter the password "Password123"
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("incorrectpassword");
 
        // Find and click the Submit button
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        
        
 
        // Wait for the page to update and try to locate the error message
        try {
            Thread.sleep(2000); // Wait for 2 seconds to ensure error message is visible
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        // Locate the error message
        WebElement errorMessage = driver.findElement(By.id("error"));
 
        // Verify that the error message is displayed
        assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");
 
        String errorMessageText = errorMessage.getText().trim();
        assertTrue(errorMessageText.contains("Your password is invalid!"),
                "Expected error message: 'Your password is invalid!', but got: " + errorMessageText);
    }
 
 
    @AfterAll
    public static void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}