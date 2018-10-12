package com.babbelapps.babbleapps_mobileautomation;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CapabilitiesPrompt {

	/*
	* This class's only purpose is to get input from the user to populate 
	* all of the capabilities definitions required to run Appium.
	*/
	
	JCheckBox emulatorCheckBox = new JCheckBox("Emulator", true);
	JCheckBox connectedDeviceCheckBox = new JCheckBox("Connceted Device");
	JCheckBox useDefaultsCheckBox = new JCheckBox("Use Default Values", true);

	GlobalVariables globalVariables = new GlobalVariables();
	String emulatorDeviceName = globalVariables.emulatorDeviceName;
	String connectedDeviceDeviceName = globalVariables.connectedDeviceDeviceName;
	String emulatorUdid = globalVariables.emulatorUdid;
	String connectedDeviceUdid = globalVariables.connectedDeviceUdid;
	String bubndleID = globalVariables.bubndleID;
	String appLocation = globalVariables.appLocation;
	String teamID = globalVariables.teamID;
	String signingID = globalVariables.signingID;

	JComboBox platformNamesCombo = new JComboBox(globalVariables.platformNames);
	JComboBox automationNamesTypeCombo = new JComboBox(globalVariables.automationNames);

	JTextField deviceNameTextField = new JTextField(emulatorDeviceName);
	JTextField udidTextField = new JTextField(emulatorUdid);
	JTextField bundleIDTextField = new JTextField(bubndleID);
	JTextField appLocationTextField = new JTextField("Enter App Location");
	JTextField teamIDTextField = new JTextField(teamID);
	JTextField signingIDTextField = new JTextField(signingID);

	JButton resetDefaults = new JButton("Reset Defaults");

	public boolean capabilitiesPrompt() {

		boolean carryOutTests = true;

		EmulatorCheckBoxActionHandler emulatorCheckBoxActionListener = new EmulatorCheckBoxActionHandler();
		ConnectedDeviceCheckBoxActionHandler connectedDeviceCheckBoxActionListener = new ConnectedDeviceCheckBoxActionHandler();
		UseDefaulesCheckBoxActionHandler useDefaultsCheckBoxActionListener = new UseDefaulesCheckBoxActionHandler();
		ResetDefaultsButtonActionHandler resetDefaultsButtonActionHandler = new ResetDefaultsButtonActionHandler();

		emulatorCheckBox.addActionListener(emulatorCheckBoxActionListener);
		connectedDeviceCheckBox.addActionListener(connectedDeviceCheckBoxActionListener);
		useDefaultsCheckBox.addActionListener(useDefaultsCheckBoxActionListener);
		resetDefaults.addActionListener(resetDefaultsButtonActionHandler);

		automationNamesTypeCombo.setSelectedItem("XCUITest");
		platformNamesCombo.setSelectedItem("iOS");

		platformNamesCombo.setEnabled(false);
		automationNamesTypeCombo.setEnabled(false);
		deviceNameTextField.setEnabled(false);
		udidTextField.setEnabled(false);
		bundleIDTextField.setEnabled(false);
		appLocationTextField.setEnabled(false);
		teamIDTextField.setEnabled(false);
		signingIDTextField.setEnabled(false);

		JPanel panel = new JPanel(new GridLayout(0, 2));

		panel.add(new JLabel("Use Emulator"));
		panel.add(emulatorCheckBox);
		panel.add(new JLabel("Use Connected Device"));
		panel.add(connectedDeviceCheckBox);
		panel.add(new JLabel("Use Default Values"));
		panel.add(useDefaultsCheckBox);

		panel.add(new JLabel("Platform type"));
		panel.add(platformNamesCombo);
		panel.add(new JLabel("Automation Name"));
		panel.add(automationNamesTypeCombo);
		panel.add(new JLabel("Device Name"));
		panel.add(deviceNameTextField);
		panel.add(new JLabel("UDID:"));
		panel.add(udidTextField);
		panel.add(new JLabel("Bundle ID:"));
		panel.add(bundleIDTextField);
		panel.add(new JLabel("App Location:"));
		panel.add(appLocationTextField);
		panel.add(new JLabel("Team ID:"));
		panel.add(teamIDTextField);
		panel.add(new JLabel("Signing ID:"));
		panel.add(signingIDTextField);

		panel.add(resetDefaults);

		int result = JOptionPane.showConfirmDialog(null, panel, "Test", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (result == JOptionPane.OK_OPTION) {
			if (emulatorCheckBox.isSelected()) {
				globalVariables.isEmulator = true;
			} else {
				globalVariables.isEmulator = false;
			}
			
			if(appLocationTextField.getText() == "Enter App Location") {
				appLocationTextField.setText(appLocation);
			}

			globalVariables.platformName = (String) platformNamesCombo.getSelectedItem();
			globalVariables.automationName = (String) automationNamesTypeCombo.getSelectedItem();

			globalVariables.emulatorDeviceName = deviceNameTextField.getText();
			globalVariables.connectedDeviceDeviceName = deviceNameTextField.getText();
			globalVariables.emulatorUdid = udidTextField.getText();
			globalVariables.connectedDeviceUdid = udidTextField.getText();
			globalVariables.bubndleID = bundleIDTextField.getText();
			globalVariables.appLocation = appLocationTextField.getText();
			globalVariables.teamID = teamIDTextField.getText();
			globalVariables.signingID = signingIDTextField.getText();
		} else {
			carryOutTests = false;
			System.out.println("Cancelled");
		}

		return carryOutTests;
	}

	class EmulatorCheckBoxActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JCheckBox checkbox = (JCheckBox) event.getSource();
			if (emulatorCheckBox.isSelected()) {
				if (useDefaultsCheckBox.isSelected()) {
					platformNamesCombo.setEnabled(false);
					automationNamesTypeCombo.setEnabled(false);
					deviceNameTextField.setEnabled(false);
					udidTextField.setEnabled(false);
					bundleIDTextField.setEnabled(false);
					appLocationTextField.setEnabled(false);
					teamIDTextField.setEnabled(false);
					signingIDTextField.setEnabled(false);
				} else {
					platformNamesCombo.setEnabled(true);
					automationNamesTypeCombo.setEnabled(true);
					deviceNameTextField.setEnabled(true);
					udidTextField.setEnabled(true);
					bundleIDTextField.setEnabled(true);
					appLocationTextField.setEnabled(true);
					teamIDTextField.setEnabled(false);
					signingIDTextField.setEnabled(false);
				}
				connectedDeviceCheckBox.setSelected(false);
			}
		}
	}

	class ConnectedDeviceCheckBoxActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JCheckBox checkbox = (JCheckBox) event.getSource();
			if (connectedDeviceCheckBox.isSelected()) {
				if (useDefaultsCheckBox.isSelected()) {
					platformNamesCombo.setEnabled(false);
					automationNamesTypeCombo.setEnabled(false);
					deviceNameTextField.setEnabled(false);
					udidTextField.setEnabled(false);
					bundleIDTextField.setEnabled(false);
					appLocationTextField.setEnabled(false);
					teamIDTextField.setEnabled(false);
					signingIDTextField.setEnabled(false);
				} else {
					platformNamesCombo.setEnabled(true);
					automationNamesTypeCombo.setEnabled(true);
					deviceNameTextField.setEnabled(true);
					udidTextField.setEnabled(true);
					bundleIDTextField.setEnabled(true);
					appLocationTextField.setEnabled(false);
					teamIDTextField.setEnabled(true);
					signingIDTextField.setEnabled(true);
				}
				emulatorCheckBox.setSelected(false);
			}

		}
	}

	class UseDefaulesCheckBoxActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JCheckBox checkbox = (JCheckBox) event.getSource();
			if (useDefaultsCheckBox.isSelected()) {
				platformNamesCombo.setEnabled(false);
				automationNamesTypeCombo.setEnabled(false);
				deviceNameTextField.setEnabled(false);
				udidTextField.setEnabled(false);
				bundleIDTextField.setEnabled(false);
				appLocationTextField.setEnabled(false);
				teamIDTextField.setEnabled(false);
				signingIDTextField.setEnabled(false);
			} else {
				if (emulatorCheckBox.isSelected()) {
					platformNamesCombo.setEnabled(true);
					automationNamesTypeCombo.setEnabled(true);
					deviceNameTextField.setEnabled(true);
					udidTextField.setEnabled(true);
					bundleIDTextField.setEnabled(true);
					appLocationTextField.setEnabled(true);
					teamIDTextField.setEnabled(false);
					signingIDTextField.setEnabled(false);
				} else {
					platformNamesCombo.setEnabled(true);
					automationNamesTypeCombo.setEnabled(true);
					deviceNameTextField.setEnabled(true);
					udidTextField.setEnabled(true);
					bundleIDTextField.setEnabled(true);
					appLocationTextField.setEnabled(false);
					teamIDTextField.setEnabled(true);
					signingIDTextField.setEnabled(true);
				}
			}

		}
	}

	class ResetDefaultsButtonActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton button = (JButton) event.getSource();

			if (emulatorCheckBox.isSelected()) {
				automationNamesTypeCombo.setSelectedItem("XCUITest");
				platformNamesCombo.setSelectedItem("iOS");
				deviceNameTextField.setText(emulatorDeviceName);
				udidTextField.setText(emulatorUdid);
				bundleIDTextField.setText(bubndleID);
				appLocationTextField.setText(appLocation);
				teamIDTextField.setText(teamID);
				signingIDTextField.setText(signingID);
			} else {
				automationNamesTypeCombo.setSelectedItem("XCUITest");
				platformNamesCombo.setSelectedItem("iOS");
				deviceNameTextField.setText(connectedDeviceDeviceName);
				udidTextField.setText(connectedDeviceUdid);
				bundleIDTextField.setText(bubndleID);
				appLocationTextField.setText(appLocation);
				teamIDTextField.setText(teamID);
				signingIDTextField.setText(signingID);
			}
		}
	}
}