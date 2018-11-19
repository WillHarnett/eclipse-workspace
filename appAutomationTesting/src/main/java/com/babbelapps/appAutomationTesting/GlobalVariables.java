package com.babbelapps.appAutomationTesting;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class GlobalVariables {
	//Drivers
	public WebDriver webDriver;
	public AndroidDriver androidDriver;
	public IOSDriver iosDriver;
	
	//Actual list of capabilities to be used in testing
    public boolean isEmulator = true;
    
    public String platformName = "";
    public String automationName = "";
    public String deviceName = "";
    public String udid = "";
    public String bundleID = "";
    public String appLocation = "";
    public String teamID = "";
    public String signingID = "";
    public String appActivity = "";
    public String appPakcage = "";
    public String platformVersion = "";
	
	//Variables set by user
	public DesiredCapabilities capabilities = new DesiredCapabilities();
    
    public String[] platformNames = { "iOS", "Android" };
    public String[] automationNames = { "XCUITest", "UiAutomator2" };
    
	public String[] iOSEmulatorDeviceNames = {"iPhone SE"};
	public String[] androidEmulatorDeviceNames = {"Galaxy S6 edge"};
	
	public String[] iOSRealDeviceNames = {"Will’s iPhone"};
	public String[] androidRealDeviceNames = {"Will’s Galaxy"};
	
	public String[] emulatorUdids = {"F3B8EAE6-33D7-4850-93C5-7AC240949619"};
	public String[] realDeviceUdids = {"4958ddfbc1831b6cd046819a90890badf6716777"};
	
	public String[] bundleIDs = {"com.babelapps.my-recipes"};
	public String[] appLocations = {"Default"};///Users/will/Library/Developer/Xcode/DerivedData/my-recipes-crtvqzctkhijyjasxblostthzsjw/Build/Products/Release-iphonesimulator/my-recipes.app
	
	public String[] teamIDs = {"Enter team ID"};
	public String[] signingIDs = {"Enter signing ID"};
	
	public String[] appActivities = {"org.nebo.ui.activity.MainActivity"};
	public String[] appPackages = {"global.nebo"};
	
	public String[] iOSPlatformVersions = {"12.0"};
	public String[] androidPlatformVersions = {"7.0"};
	
	//Variables for Slenium/Appium
    public WebDriver driver;  

    public List<Integer> values; 
}
