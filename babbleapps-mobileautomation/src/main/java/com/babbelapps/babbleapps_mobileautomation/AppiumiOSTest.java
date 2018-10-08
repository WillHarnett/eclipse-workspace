package com.babbelapps.babbleapps_mobileautomation;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AppiumiOSTest {

    private WebDriver driver;  

    private List<Integer> values;  

    private static final int MINIMUM = 0;  
    private static final int MAXIMUM = 10;  

    @Before  
    public void setUp() throws Exception {  

        DesiredCapabilities capabilities = new DesiredCapabilities(); 
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName","iPhone SE");
        capabilities.setCapability("automationName","XCUITest");
        capabilities.setCapability("udid", "F3B8EAE6-33D7-4850-93C5-7AC240949619");
        capabilities.setCapability("bundleId", "com.babelapps.my-recipes");
        capabilities.setCapability("app", "/Users/will/Library/Developer/Xcode/DerivedData/my-recipes-crtvqzctkhijyjasxblostthzsjw/Build/Products/Release-iphonesimulator/my-recipes.app");


        driver = new RemoteWebDriver( new URL( "http://127.0.0.1:4723/wd/hub" ), capabilities );

        values = new ArrayList<Integer>();  
    }  

    @After  
    public void tearDown() throws Exception {  
       driver.quit();  
    }  


    @Test  
    public void testScriptGoesHere() throws Exception {  

        System.out.println("Test Output From Within the test");
    System.out.println("Here goes your test script");
    
    }
}