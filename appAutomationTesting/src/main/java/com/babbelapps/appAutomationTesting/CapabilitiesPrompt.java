package com.babbelapps.appAutomationTesting;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class CapabilitiesPrompt {

	/*
	 * This class's only purpose is to get input from the user to populate all of
	 * the capabilities definitions required to run Appium for ios/Android
	 */

	GlobalVariables globalVariables = new GlobalVariables();

	boolean carryOutTests = true;

	JPanel panel = new JPanel(new GridLayout(0, 4));

	JComboBox platformNamesCombo = new JComboBox(globalVariables.platformNames);
	JCheckBox useCustomPlatformNameCheckBox = new JCheckBox("Use Custom Input", false);
	JTextField platformNameTextField = new JTextField("Enter Custom Platform Name");

	JComboBox automationNamesCombo = new JComboBox(globalVariables.automationNames);
	JCheckBox useCustomAutomationNameCheckBox = new JCheckBox("Use Custom Input", false);
	JTextField automationNameTextField = new JTextField("Enter Custom Automation");

	JCheckBox useDefaultsCheckBox = new JCheckBox("Use Default Values", true);

	JCheckBox emulatorCheckBox = new JCheckBox("Emulator", true);

	JComboBox iOSEmulatorDeviceNamesCombo = new JComboBox(globalVariables.iOSEmulatorDeviceNames);
	JComboBox androidEmulatorDeviceNamesCombo = new JComboBox(globalVariables.androidEmulatorDeviceNames);
	JComboBox iOSRealDeviceNamesCombo = new JComboBox(globalVariables.iOSRealDeviceNames);
	JComboBox androidRealDeviceNamesCombo = new JComboBox(globalVariables.androidRealDeviceNames);
	JCheckBox useCustomDeviceNameCheckBox = new JCheckBox("Use Custom Input", false);
	JTextField deviceNameTextField = new JTextField("Enter Custom Device Name");

	// iOS
	JComboBox emulatorUdidsCombo = new JComboBox(globalVariables.emulatorUdids);
	JComboBox realDeviceUdidsCombo = new JComboBox(globalVariables.realDeviceUdids);
	JCheckBox useCustomUdidCheckBox = new JCheckBox("Use Custom Input", false);
	JTextField udidTextField = new JTextField("Enter Custom UDID");

	JComboBox bundleIDsCombo = new JComboBox(globalVariables.bundleIDs);
	JCheckBox useCustomBundleIDCheckBox = new JCheckBox("Use Custom Input", false);
	JTextField bundleIDTextField = new JTextField("Enter Custom bundle ID");

	JComboBox appLocationsCombo = new JComboBox(globalVariables.appLocations);
	JCheckBox useCustomAppLocationCheckBox = new JCheckBox("Use Custom Input", false);
	JTextField appLocationTextField = new JTextField("Enter Custom App Location");

	JComboBox teamIDsCombo = new JComboBox(globalVariables.teamIDs);
	JCheckBox useCustomTeamIDCheckBox = new JCheckBox("Use Custom Input", false);
	JTextField teamIDTextField = new JTextField("Enter Custom Team ID");

	JComboBox signingIDsCombo = new JComboBox(globalVariables.signingIDs);
	JCheckBox useCustomSigningIDCheckBox = new JCheckBox("Use Custom Input", false);
	JTextField signingIDTextField = new JTextField("Enter Custom Signing ID");

	// Android
	JComboBox appActivitiesCombo = new JComboBox(globalVariables.appActivities);
	JCheckBox useCustomActivityCheckBox = new JCheckBox("Use Custom Input", false);
	JTextField appActivityTextField = new JTextField("Enter Custom Activity");

	JComboBox appPackagesCombo = new JComboBox(globalVariables.appPackages);
	JCheckBox useCustomAppPackageCheckBox = new JCheckBox("Use Custom Input", false);
	JTextField appPackageTextField = new JTextField("Enter Custom Package");

	// Optional
	JComboBox iOSPlatformVersionsCombo = new JComboBox(globalVariables.iOSPlatformVersions);
	JComboBox androidPlatformVersionsCombo = new JComboBox(globalVariables.androidPlatformVersions);
	JCheckBox useCustomPlatformVersionCheckBox = new JCheckBox("Use Custom Input", false);
	JTextField platformVersionTextField = new JTextField("Enter Custom Platform Version");

	JButton resetDefaults = new JButton("Reset Defaults");

	public boolean capabilitiesPrompt() {
		createCapabilitiesPrompt();

		int result = JOptionPane.showConfirmDialog(null, panel, "Test", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (result == JOptionPane.OK_OPTION) {
			updateGlobalVariablesAndSetCapabilities();
		}
		return carryOutTests;
	}

	public void createCapabilitiesPrompt() {
		// platformNamesCombo.setSelectedItem("iOS");

		EmulatorCheckBoxActionHandler emulatorCheckBoxActionListener = new EmulatorCheckBoxActionHandler();
		UseDefaultsCheckBoxActionHandler useDefaultsCheckBoxActionListener = new UseDefaultsCheckBoxActionHandler();
		ResetDefaultsButtonActionHandler resetDefaultsButtonActionHandler = new ResetDefaultsButtonActionHandler();

		emulatorCheckBox.addActionListener(emulatorCheckBoxActionListener);
		useDefaultsCheckBox.addActionListener(useDefaultsCheckBoxActionListener);
		resetDefaults.addActionListener(resetDefaultsButtonActionHandler);

		// automationNamesTypeCombo.setSelectedItem("XCUITest");
		panel.add(new JLabel("Platform type"));
		panel.add(platformNamesCombo);
		panel.add(new JLabel("Platform type"));
		panel.add(useCustomPlatformNameCheckBox);
		panel.add(new JLabel("Platform type"));
		panel.add(platformNameTextField);

		panel.add(new JLabel("Platform type"));
		panel.add(automationNamesCombo);	
		panel.add(new JLabel("Platform type"));
		panel.add(useCustomAutomationNameCheckBox);	
		panel.add(new JLabel("Platform type"));
		panel.add(automationNameTextField);

		panel.add(new JLabel("Platform type"));
		panel.add(useDefaultsCheckBox);
		
		panel.add(new JLabel("Platform type"));
		panel.add(emulatorCheckBox);

		panel.add(new JLabel("Platform type"));
		panel.add(iOSEmulatorDeviceNamesCombo);
		panel.add(new JLabel("Platform type"));
		panel.add(androidEmulatorDeviceNamesCombo);
		panel.add(new JLabel("Platform type"));
		panel.add(iOSRealDeviceNamesCombo);
		panel.add(new JLabel("Platform type"));
		panel.add(androidRealDeviceNamesCombo);
		panel.add(new JLabel("Platform type"));
		panel.add(useCustomDeviceNameCheckBox);
		panel.add(new JLabel("Platform type"));
		panel.add(deviceNameTextField);

		// iOS
		panel.add(new JLabel("Platform type"));
		panel.add(emulatorUdidsCombo);
		panel.add(new JLabel("Platform type"));
		panel.add(realDeviceUdidsCombo);
		panel.add(new JLabel("Platform type"));
		panel.add(useCustomUdidCheckBox);
		panel.add(new JLabel("Platform type"));
		panel.add(udidTextField);

		panel.add(new JLabel("Platform type"));
		panel.add(bundleIDsCombo);
		panel.add(new JLabel("Platform type"));
		panel.add(useCustomBundleIDCheckBox);
		panel.add(new JLabel("Platform type"));
		panel.add(bundleIDTextField);

		panel.add(new JLabel("Platform type"));
		panel.add(appLocationsCombo);
		panel.add(new JLabel("Platform type"));
		panel.add(useCustomAppLocationCheckBox);
		panel.add(new JLabel("Platform type"));
		panel.add(appLocationTextField);

		panel.add(new JLabel("Platform type"));
		panel.add(teamIDsCombo);
		panel.add(new JLabel("Platform type"));
		panel.add(useCustomTeamIDCheckBox);
		panel.add(new JLabel("Platform type"));
		panel.add(teamIDTextField);

		panel.add(new JLabel("Platform type"));
		panel.add(signingIDsCombo);
		panel.add(new JLabel("Platform type"));
		panel.add(useCustomSigningIDCheckBox);
		panel.add(new JLabel("Platform type"));
		panel.add(signingIDTextField);

		// Android
		panel.add(new JLabel("Platform type"));
		panel.add(appActivitiesCombo);
		panel.add(new JLabel("Platform type"));
		panel.add(useCustomActivityCheckBox);
		panel.add(new JLabel("Platform type"));
		panel.add(appActivityTextField);

		panel.add(new JLabel("Platform type"));
		panel.add(appPackagesCombo);
		panel.add(new JLabel("Platform type"));
		panel.add(useCustomAppPackageCheckBox);
		panel.add(new JLabel("Platform type"));
		panel.add(appPackageTextField);

		// Optional
		panel.add(new JLabel("Platform type"));
		panel.add(iOSPlatformVersionsCombo);
		panel.add(new JLabel("Platform type"));
		panel.add(androidPlatformVersionsCombo);
		panel.add(new JLabel("Platform type"));
		panel.add(useCustomPlatformVersionCheckBox);
		panel.add(new JLabel("Enter Custom Platform Version"));
		panel.add(platformVersionTextField);

		panel.add(resetDefaults);

		setDefaults();
		enableDisableOptions();
	}

	public void updateGlobalVariablesAndSetCapabilities() {
		globalVariables.isEmulator = emulatorCheckBox.isSelected();
		DesiredCapabilities capabilities = new DesiredCapabilities();

		if (useCustomPlatformNameCheckBox.isSelected()) {
			globalVariables.platformName = platformNameTextField.getText();
		} else {
			globalVariables.platformName = (String) platformNamesCombo.getSelectedItem();
		}

		if (useCustomAutomationNameCheckBox.isSelected()) {
			globalVariables.automationName = automationNameTextField.getText();
		} else {
			globalVariables.automationName = (String) automationNamesCombo.getSelectedItem();
		}

		if (appLocationTextField.getText() == "Enter App Location") {
			appLocationTextField.setText("AAAA");
		}

		if ((String) platformNamesCombo.getSelectedItem() == "iOS") {
			if (useCustomBundleIDCheckBox.isSelected()) {
				globalVariables.bundleID = bundleIDTextField.getText();
			} else {
				globalVariables.bundleID = (String) bundleIDsCombo.getSelectedItem();
			}

			if (useCustomTeamIDCheckBox.isSelected()) {
				globalVariables.teamID = teamIDTextField.getText();
			} else {
				globalVariables.teamID = (String) teamIDsCombo.getSelectedItem();
			}

			if (useCustomSigningIDCheckBox.isSelected()) {
				globalVariables.signingID = signingIDTextField.getText();
			} else {
				globalVariables.signingID = (String) signingIDsCombo.getSelectedItem();
			}

			capabilities.setCapability("bundleId", globalVariables.bundleID);
			try {
				globalVariables.iosDriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (emulatorCheckBox.isSelected()) {
				if (useCustomAutomationNameCheckBox.isSelected()) {
					globalVariables.deviceName = deviceNameTextField.getText();
				} else {
					globalVariables.deviceName = (String) iOSEmulatorDeviceNamesCombo.getSelectedItem();
				}
				if (useCustomUdidCheckBox.isSelected()) {
					globalVariables.udid = udidTextField.getText();
				} else {
					globalVariables.udid = (String) emulatorUdidsCombo.getSelectedItem();
				}
				if (useCustomAppLocationCheckBox.isSelected()) {

					globalVariables.appLocation = appLocationTextField.getText();
				} else {
					globalVariables.appLocation = (String) appLocationsCombo.getSelectedItem();
				}
				capabilities.setCapability("udid", globalVariables.udid);
				capabilities.setCapability("app", globalVariables.appLocation);
			} else {
				if (useCustomAutomationNameCheckBox.isSelected()) {
					globalVariables.deviceName = deviceNameTextField.getText();
				} else {
					globalVariables.deviceName = (String) iOSRealDeviceNamesCombo.getSelectedItem();
				}
				if (useCustomUdidCheckBox.isSelected()) {
					globalVariables.udid = udidTextField.getText();
				} else {
					globalVariables.udid = (String) realDeviceUdidsCombo.getSelectedItem();
				}
				capabilities.setCapability("udid", globalVariables.udid);
			}
			// Optional
			if (useCustomPlatformVersionCheckBox.isSelected()) {
				globalVariables.platformVersion = platformVersionTextField.getText();
			} else {
				globalVariables.platformVersion = (String) iOSPlatformVersionsCombo.getSelectedItem();
			}
		} else {

			try {
				globalVariables.androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
						capabilities);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (useCustomActivityCheckBox.isSelected()) {
				globalVariables.appActivity = appActivityTextField.getText();
			} else {
				globalVariables.appActivity = (String) appActivitiesCombo.getSelectedItem();
			}

			if (useCustomAppPackageCheckBox.isSelected()) {
				globalVariables.appPakcage = appPackageTextField.getText();
			} else {
				globalVariables.appPakcage = (String) appPackagesCombo.getSelectedItem();
			}

			if (emulatorCheckBox.isSelected()) {
				if (useCustomAutomationNameCheckBox.isSelected()) {
					globalVariables.deviceName = deviceNameTextField.getText();
				} else {
					globalVariables.deviceName = (String) androidEmulatorDeviceNamesCombo.getSelectedItem();
				}
			} else {
				if (useCustomAutomationNameCheckBox.isSelected()) {
					globalVariables.deviceName = deviceNameTextField.getText();
				} else {
					globalVariables.deviceName = (String) androidRealDeviceNamesCombo.getSelectedItem();
				}
			}
			// Optional
			if (useCustomPlatformVersionCheckBox.isSelected()) {
				globalVariables.platformVersion = platformVersionTextField.getText();
			} else {
				globalVariables.platformVersion = (String) androidPlatformVersionsCombo.getSelectedItem();
			}
		}
		capabilities.setCapability("platformName", globalVariables.platformName); // Required
		capabilities.setCapability("automationName", globalVariables.automationName); // Required
		capabilities.setCapability("deviceName", globalVariables.deviceName); // Required

		System.out.println("Finished Setup");
	}

	class SetAutomationPlatformAndChangeDefaults implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JComboBox jComboBox = (JComboBox) event.getSource();
			setDefaults();
			enableDisableOptions();
		}
	}

	class EmulatorCheckBoxActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JCheckBox checkbox = (JCheckBox) event.getSource();
			enableDisableOptions();
		}
	}

	class UseDefaultsCheckBoxActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JCheckBox checkbox = (JCheckBox) event.getSource();
			enableDisableOptions();
		}
	}

	class ResetDefaultsButtonActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JCheckBox checkbox = (JCheckBox) event.getSource();
			setDefaults();
		}
	}

	public void setDefaults() {
		useDefaultsCheckBox.setSelected(true);
		platformNamesCombo.setSelectedItem(globalVariables.platformNames[0]);
		useCustomPlatformNameCheckBox.setSelected(false);
		platformNameTextField.setText("");
		platformNameTextField.setVisible(false);
		
		automationNamesCombo.setSelectedItem(globalVariables.automationNames[0]);
		useCustomAutomationNameCheckBox.setSelected(false);
		automationNameTextField.setText("");
		automationNameTextField.setVisible(false);
		
		emulatorCheckBox.setSelected(true);
		
		bundleIDsCombo.setSelectedItem(globalVariables.bundleIDs[0]);
		useCustomBundleIDCheckBox.setSelected(false);
		bundleIDTextField.setText("");

		teamIDsCombo.setSelectedItem(globalVariables.teamIDs[0]);
		useCustomTeamIDCheckBox.setSelected(false);
		teamIDTextField.setText("");

		signingIDsCombo.setSelectedItem(globalVariables.signingIDs[0]);
		useCustomSigningIDCheckBox.setSelected(false);
		signingIDTextField.setText("");

		// Android
		appActivitiesCombo.setSelectedItem(globalVariables.appActivities[0]);
		useCustomActivityCheckBox.setSelected(false);
		appActivityTextField.setText("");

		appPackagesCombo.setSelectedItem(globalVariables.appPackages[0]);
		useCustomAppPackageCheckBox.setSelected(false);
		appPackageTextField.setText("");

		iOSEmulatorDeviceNamesCombo.setSelectedItem(globalVariables.iOSEmulatorDeviceNames[0]);
		androidEmulatorDeviceNamesCombo.setSelectedItem(globalVariables.androidEmulatorDeviceNames[0]);
		iOSRealDeviceNamesCombo.setSelectedItem(globalVariables.iOSRealDeviceNames[0]);
		androidRealDeviceNamesCombo.setSelectedItem(globalVariables.androidRealDeviceNames[0]);
		useCustomDeviceNameCheckBox.setSelected(false);
		deviceNameTextField.setText("");

		// iOS
		emulatorUdidsCombo.setSelectedItem(globalVariables.emulatorUdids[0]);
		realDeviceUdidsCombo.setSelectedItem(globalVariables.realDeviceUdids[0]);
		useCustomUdidCheckBox.setSelected(false);
		udidTextField.setText("");

		appLocationsCombo.setSelectedItem(globalVariables.appLocations[0]);
		useCustomAppLocationCheckBox.setSelected(false);
		appLocationTextField.setText("");

		// Optional
		iOSPlatformVersionsCombo.setSelectedItem(globalVariables.iOSPlatformVersions[0]);
		androidPlatformVersionsCombo.setSelectedItem(globalVariables.androidPlatformVersions[0]);
		useCustomPlatformVersionCheckBox.setSelected(false);
		platformVersionTextField.setText("");
	}

	public void enableDisableOptions() {
		if (useDefaultsCheckBox.isSelected()) {
			if (platformNamesCombo.getSelectedItem() == "iOS") {

				// iOS
				bundleIDsCombo.setVisible(true);
				useCustomBundleIDCheckBox.setVisible(true);
				bundleIDTextField.setVisible(false);

				teamIDsCombo.setVisible(true);
				useCustomTeamIDCheckBox.setVisible(true);
				teamIDTextField.setVisible(false);

				signingIDsCombo.setVisible(true);
				useCustomSigningIDCheckBox.setVisible(true);
				signingIDTextField.setVisible(false);

				// Android
				appActivitiesCombo.setVisible(false);
				useCustomActivityCheckBox.setVisible(false);
				appActivityTextField.setVisible(false);

				appPackagesCombo.setVisible(false);
				useCustomAppPackageCheckBox.setVisible(false);
				appPackageTextField.setVisible(false);

				if (emulatorCheckBox.isSelected()) {
					iOSEmulatorDeviceNamesCombo.setVisible(true);
					androidEmulatorDeviceNamesCombo.setVisible(false);
					iOSRealDeviceNamesCombo.setVisible(false);
					androidRealDeviceNamesCombo.setVisible(false);
					useCustomDeviceNameCheckBox.setVisible(true);
					deviceNameTextField.setVisible(false);

					// iOS
					emulatorUdidsCombo.setVisible(true);
					realDeviceUdidsCombo.setVisible(false);
					useCustomUdidCheckBox.setVisible(true);
					udidTextField.setVisible(false);

					appLocationsCombo.setVisible(true);
					useCustomAppLocationCheckBox.setVisible(true);
					appLocationTextField.setVisible(false);
				} else {
					iOSEmulatorDeviceNamesCombo.setVisible(false);
					androidEmulatorDeviceNamesCombo.setVisible(false);
					iOSRealDeviceNamesCombo.setVisible(true);
					androidRealDeviceNamesCombo.setVisible(false);
					useCustomDeviceNameCheckBox.setVisible(true);
					deviceNameTextField.setVisible(false);

					// iOS
					emulatorUdidsCombo.setVisible(false);
					realDeviceUdidsCombo.setVisible(true);
					useCustomUdidCheckBox.setVisible(true);
					udidTextField.setVisible(false);

					appLocationsCombo.setVisible(false);
					useCustomAppLocationCheckBox.setVisible(false);
					appLocationTextField.setVisible(false);
				}

				// Optional
				iOSPlatformVersionsCombo.setVisible(true);
				androidPlatformVersionsCombo.setVisible(false);
				useCustomPlatformVersionCheckBox.setVisible(true);
				platformVersionTextField.setVisible(false);
			} else {

				// iOS
				teamIDsCombo.setVisible(false);
				useCustomTeamIDCheckBox.setVisible(false);
				teamIDTextField.setVisible(false);

				signingIDsCombo.setVisible(false);
				useCustomSigningIDCheckBox.setVisible(false);
				signingIDTextField.setVisible(false);

				bundleIDsCombo.setVisible(false);
				useCustomBundleIDCheckBox.setVisible(false);
				bundleIDTextField.setVisible(false);

				emulatorUdidsCombo.setVisible(false);
				realDeviceUdidsCombo.setVisible(false);
				useCustomUdidCheckBox.setVisible(false);
				udidTextField.setVisible(false);

				appLocationsCombo.setVisible(false);
				useCustomAppLocationCheckBox.setVisible(false);
				appLocationTextField.setVisible(false);

				// Android
				appActivitiesCombo.setVisible(true);
				useCustomActivityCheckBox.setVisible(true);
				appActivityTextField.setVisible(false);

				appPackagesCombo.setVisible(true);
				useCustomAppPackageCheckBox.setVisible(true);
				appPackageTextField.setVisible(false);

				if (emulatorCheckBox.isSelected()) {
					iOSEmulatorDeviceNamesCombo.setVisible(false);
					androidEmulatorDeviceNamesCombo.setVisible(true);
					iOSRealDeviceNamesCombo.setVisible(false);
					androidRealDeviceNamesCombo.setVisible(false);
					useCustomDeviceNameCheckBox.setVisible(true);
					deviceNameTextField.setVisible(false);

				} else {
					iOSEmulatorDeviceNamesCombo.setVisible(false);
					androidEmulatorDeviceNamesCombo.setVisible(false);
					iOSRealDeviceNamesCombo.setVisible(false);
					androidRealDeviceNamesCombo.setVisible(true);
					useCustomDeviceNameCheckBox.setVisible(true);
					deviceNameTextField.setVisible(false);
				}

				// Optional
				iOSPlatformVersionsCombo.setVisible(false);
				androidPlatformVersionsCombo.setVisible(true);
				useCustomPlatformVersionCheckBox.setVisible(true);
				platformVersionTextField.setVisible(false);
			}
		}
	}
}