package com.babbelapps.babbleapps_mobileautomation;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GlobalVariables {
	//Variables set by user
	public DesiredCapabilities capabilities = new DesiredCapabilities();
	
    public boolean isEmulator = true;
    public String[] platformNames = { "iOS", "Android" };
    public String[] automationNames = { "XCUITest" };
    public String platformName = "iOS";
    public String automationName = "XCUITest";
	public String emulatorDeviceName = "iPhone SE";
	public String connectedDeviceDeviceName = "Will’s iPhone";
	public String emulatorUdid = "F3B8EAE6-33D7-4850-93C5-7AC240949619";
	public String connectedDeviceUdid = "4958ddfbc1831b6cd046819a90890badf6716777";
	public String bubndleID = "com.babelapps.my-recipes";
	public String appLocation = "/Users/will/Library/Developer/Xcode/DerivedData/my-recipes-crtvqzctkhijyjasxblostthzsjw/Build/Products/Release-iphonesimulator/my-recipes.app";
	public String teamID = "Enter team ID";
	public String signingID = "Enter signing ID";
	
	//Variables for Slenium/Appium
    public WebDriver driver;  

    public List<Integer> values; 
    public TouchActions action;
}