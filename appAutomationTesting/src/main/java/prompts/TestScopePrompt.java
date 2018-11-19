package prompts;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import globalVariables.*;

public class TestScopePrompt {

	/*
	 * This prompt asks the Tester for the basic Testing Scope
	 */
	
	APIPrompt apiPrompt = new APIPrompt();
	AppiumPrompt appiumPrompt = new AppiumPrompt();
	JMeterPrompt jMeterPrompt = new JMeterPrompt();
	SeleniumPrompt seleniumPrompt = new SeleniumPrompt();
	
	String[] testSuiteOptions = { "Google Sheets", "Excel", "JUnit" };

	JPanel panel = new JPanel(new GridLayout(0, 1));
	JCheckBox carryOutTestingCheckBox = new JCheckBox("Run Tests", true);
	
	JLabel chooseTestSuiteTypeLabel = new JLabel("Choose Test Suite Type");
	
	JCheckBox carryOutApiTestingCheckBox = new JCheckBox("Run Api tests", true);
	JComboBox<String> APITestSuiteOptionsComboBox = new JComboBox<String>(TestSuiteVariables.testSuiteTypes);
	JTextField APIEnterTestSuitePath = new JTextField("Default Test Suite Path"); 
	
	JCheckBox carryOutAppiumTestingCheckBox = new JCheckBox("Run Appium tests", true);
	JComboBox<String> appiumTestSuiteOptionsComboBox = new JComboBox<String>(TestSuiteVariables.testSuiteTypes);
	JTextField appiumEnterTestSuitePath = new JTextField("Default Test Suite Path"); 
	
	JCheckBox carryOutJMeterTestingCheckBox = new JCheckBox("Run Load tests", true);
	JComboBox<String> JMeterTestSuiteOptionsComboBox = new JComboBox<String>(TestSuiteVariables.testSuiteTypes);
	JTextField JMeterEnterTestSuitePath = new JTextField("Default Test Suite Path"); 
	
	JCheckBox carryOutSeleniumTestingCheckBox = new JCheckBox("Run Selenium tests", true);
	JComboBox<String> seleniumTestSuiteOptionsComboBox = new JComboBox<String>(TestSuiteVariables.testSuiteTypes);
	JTextField seleniumEnterTestSuitePath = new JTextField("Default Test Suite Path"); 

	JButton resetDefaults = new JButton("Reset Defaults");

	public boolean prompt(boolean usePrompts) {
		if(usePrompts) {
			createPrompt();
		}
		else {
			
		}

		int result = JOptionPane.showConfirmDialog(null, panel, "Test Scope", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (result == JOptionPane.OK_OPTION) {
			updateGlobalVariables();
		} else if (result == JOptionPane.OK_CANCEL_OPTION) {
			carryOutApiTestingCheckBox.setSelected(false);
		}
		return carryOutTestingCheckBox.isSelected();
	}

	public void createPrompt() {
		EnableDisableOtherOptions enableDisableOtherOptions = new EnableDisableOtherOptions();
		ResetDefaultsButtonActionHandler resetDefaultsButtonActionHandler = new ResetDefaultsButtonActionHandler();

		carryOutTestingCheckBox.addActionListener(enableDisableOtherOptions);
		carryOutApiTestingCheckBox.addActionListener(enableDisableOtherOptions);
		carryOutAppiumTestingCheckBox.addActionListener(enableDisableOtherOptions);
		carryOutJMeterTestingCheckBox.addActionListener(enableDisableOtherOptions);
		carryOutSeleniumTestingCheckBox.addActionListener(enableDisableOtherOptions);
		
		resetDefaults.addActionListener(resetDefaultsButtonActionHandler);

		panel.add(carryOutTestingCheckBox);
		panel.add(Box.createVerticalStrut(20));
		
		panel.add(carryOutApiTestingCheckBox);
		panel.add(chooseTestSuiteTypeLabel);
		panel.add(APITestSuiteOptionsComboBox);
		panel.add(APIEnterTestSuitePath);
		panel.add(Box.createVerticalStrut(20));
		
		panel.add(carryOutAppiumTestingCheckBox);
		panel.add(chooseTestSuiteTypeLabel);
		panel.add(appiumTestSuiteOptionsComboBox);
		panel.add(appiumEnterTestSuitePath);
		panel.add(Box.createVerticalStrut(20));
		
		panel.add(carryOutJMeterTestingCheckBox);
		panel.add(chooseTestSuiteTypeLabel);
		panel.add(JMeterTestSuiteOptionsComboBox);
		panel.add(JMeterEnterTestSuitePath);
		panel.add(Box.createVerticalStrut(20));
		
		panel.add(carryOutSeleniumTestingCheckBox);
		panel.add(chooseTestSuiteTypeLabel);
		panel.add(seleniumTestSuiteOptionsComboBox);
		panel.add(seleniumEnterTestSuitePath);
		panel.add(Box.createVerticalStrut(20));

		panel.add(resetDefaults);

		setDefaults();
		enableDisableOptions();
	}

	public void updateGlobalVariables() {

		StandardVariables.carryOutTesting = carryOutTestingCheckBox.isSelected();

		if(StandardVariables.carryOutTesting) {
			StandardVariables.carryOutApiTesting = carryOutApiTestingCheckBox.isSelected();
			StandardVariables.carryOutAppiumTesting = carryOutAppiumTestingCheckBox.isSelected();
			StandardVariables.carryOutJMeterTesting = carryOutJMeterTestingCheckBox.isSelected();
			StandardVariables.carryOutSeleniumTesting = carryOutSeleniumTestingCheckBox.isSelected();
			
			if(StandardVariables.carryOutApiTesting) {
				if(APITestSuiteOptionsComboBox.getSelectedItem() == "Google Sheets") {
					TestSuiteVariables.useAPIGoogleSheet = true;
					if(APIEnterTestSuitePath.getText() == "Default Test Suite ID") {
						
					}
					else {
						TestSuiteVariables.apiTestSuiteGoogleSheetsID = appiumEnterTestSuitePath.getText();
					}
				}
				else if(APITestSuiteOptionsComboBox.getSelectedItem() == "Excel") {
					TestSuiteVariables.useAPIExcel = true;
					if(APIEnterTestSuitePath.getText() == "Default Test Suite File Path") {
						
					}
					else {
						TestSuiteVariables.apiExcelFilePath = appiumEnterTestSuitePath.getText();
					}
				}
				else if(APITestSuiteOptionsComboBox.getSelectedItem() == "JUnit") {
					TestSuiteVariables.useAPIJUnit = true;
					if(APIEnterTestSuitePath.getText() == "Default JUnit Test Suite") {
						
					}
					else {
						TestSuiteVariables.apiJUnit = appiumEnterTestSuitePath.getText();
					}
				}
				else {
					
				}
				
				if(appiumTestSuiteOptionsComboBox.getSelectedItem() == "Google Sheets") {
					TestSuiteVariables.useAppiumGoogleSheet = true;
					if(appiumEnterTestSuitePath.getText() == "Default Test Suite ID") {
						
					}
					else {
						TestSuiteVariables.appiumTestSuiteGoogleSheetsID = appiumEnterTestSuitePath.getText();
					}
				}
				else if(appiumTestSuiteOptionsComboBox.getSelectedItem() == "Excel") {
					TestSuiteVariables.useAppiumExcel = true;
					if(appiumEnterTestSuitePath.getText() == "Default Test Suite File Path") {
						
					}
					else {
						TestSuiteVariables.appiumExcelFilePath = appiumEnterTestSuitePath.getText();
					}
				}
				else if(appiumTestSuiteOptionsComboBox.getSelectedItem() == "JUnit") {
					TestSuiteVariables.useAppiumJUnit = true;
					if(appiumEnterTestSuitePath.getText() == "Default JUnit Test Suite") {
						
					}
					else {
						TestSuiteVariables.appiumJUnit = appiumEnterTestSuitePath.getText();
					}
				}
				else {
					
				}
				
				if(JMeterTestSuiteOptionsComboBox.getSelectedItem() == "Google Sheets") {
					TestSuiteVariables.useJMeterGoogleSheet = true;
					if(JMeterEnterTestSuitePath.getText() == "Default Test Suite ID") {
						
					}
					else {
						TestSuiteVariables.jMeterTestSuiteGoogleSheetsID = JMeterEnterTestSuitePath.getText();
					}
				}
				else if(JMeterTestSuiteOptionsComboBox.getSelectedItem() == "Excel") {
					TestSuiteVariables.useJMeterExcel = true;
					if(JMeterEnterTestSuitePath.getText() == "Default Test Suite File Path") {
						
					}
					else {
						TestSuiteVariables.jMeterExcelFilePath = JMeterEnterTestSuitePath.getText();
					}
				}
				else if(JMeterTestSuiteOptionsComboBox.getSelectedItem() == "JUnit") {
					TestSuiteVariables.useJMeterJUnit = true;
					if(JMeterEnterTestSuitePath.getText() == "Default JUnit Test Suite") {
						
					}
					else {
						TestSuiteVariables.jMeterJUnit = JMeterEnterTestSuitePath.getText();
					}
				}
				else {
					
				}

				if(seleniumTestSuiteOptionsComboBox.getSelectedItem() == "Google Sheets") {
					TestSuiteVariables.useSeleniumGoogleSheet = true;
					if(seleniumEnterTestSuitePath.getText() == "Default Test Suite ID") {
						
					}
					else {
						TestSuiteVariables.seleniumTestSuiteGoogleSheetsID = seleniumEnterTestSuitePath.getText();
					}
				}
				else if(seleniumTestSuiteOptionsComboBox.getSelectedItem() == "Excel") {
					TestSuiteVariables.useSeleniumExcel = true;
					if(seleniumEnterTestSuitePath.getText() == "Default Test Suite File Path") {
						
					}
					else {
						TestSuiteVariables.seleniumExcelFilePath = seleniumEnterTestSuitePath.getText();
					}
				}
				else if(seleniumTestSuiteOptionsComboBox.getSelectedItem() == "JUnit") {
					TestSuiteVariables.useSeleniumJUnit = true;
					if(seleniumEnterTestSuitePath.getText() == "Default JUnit Test Suite") {
						
					}
					else {
						TestSuiteVariables.seleniumJUnit = seleniumEnterTestSuitePath.getText();
					}
				}
				else {
					
				}
			}
		}
		
		if(carryOutTestingCheckBox.isSelected()){
			if(carryOutApiTestingCheckBox.isSelected()) {
				apiPrompt.prompt();
			}
			if(carryOutAppiumTestingCheckBox.isSelected()) {
				appiumPrompt.prompt();
			}
			if(carryOutJMeterTestingCheckBox.isSelected()) {
				jMeterPrompt.prompt();
			}
			if(carryOutSeleniumTestingCheckBox.isSelected()) {
				seleniumPrompt.prompt();
			}
		}
		System.out.println("Finished Setup");
	}

	class EnableDisableOtherOptions implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			enableDisableOptions();
		}
	}

	class ResetDefaultsButtonActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			setDefaults();
		}
	}

	void setDefaults() {
		carryOutApiTestingCheckBox.setSelected(true);
		APITestSuiteOptionsComboBox.setSelectedItem(TestSuiteVariables.testSuiteTypes[0]);
		
		carryOutAppiumTestingCheckBox.setSelected(true);
		appiumTestSuiteOptionsComboBox.setSelectedItem(TestSuiteVariables.testSuiteTypes[0]);
		
		carryOutJMeterTestingCheckBox.setSelected(true);
		JMeterTestSuiteOptionsComboBox.setSelectedItem(TestSuiteVariables.testSuiteTypes[0]);
		
		carryOutSeleniumTestingCheckBox.setSelected(true);
		seleniumTestSuiteOptionsComboBox.setSelectedItem(TestSuiteVariables.testSuiteTypes[0]);
		
		setTextFieldPlaceHolders();
		enableDisableOptions();
	}

	void enableDisableOptions() {
		if (carryOutTestingCheckBox.isSelected()) {
			carryOutApiTestingCheckBox.setEnabled(true);
			carryOutAppiumTestingCheckBox.setEnabled(true);
			carryOutJMeterTestingCheckBox.setEnabled(true);
			carryOutSeleniumTestingCheckBox.setEnabled(true);
		} else {
			carryOutApiTestingCheckBox.setSelected(false);
			carryOutAppiumTestingCheckBox.setSelected(false);
			carryOutJMeterTestingCheckBox.setSelected(false);
			carryOutSeleniumTestingCheckBox.setSelected(false);
			
			carryOutApiTestingCheckBox.setEnabled(false);
			carryOutAppiumTestingCheckBox.setEnabled(false);
			carryOutJMeterTestingCheckBox.setEnabled(false);
			carryOutSeleniumTestingCheckBox.setEnabled(false);
		}
		
		if(carryOutApiTestingCheckBox.isSelected()) {
			APITestSuiteOptionsComboBox.setEnabled(true);
			APIEnterTestSuitePath.setEnabled(true);
		}
		else {
			APITestSuiteOptionsComboBox.setEnabled(false);
			APIEnterTestSuitePath.setEnabled(false);
		}
		
		if(carryOutAppiumTestingCheckBox.isSelected()) {
			appiumTestSuiteOptionsComboBox.setEnabled(true);
			appiumEnterTestSuitePath.setEnabled(true);
		}
		else {
			appiumTestSuiteOptionsComboBox.setEnabled(false);
			appiumEnterTestSuitePath.setEnabled(false);
		}
		
		if(carryOutJMeterTestingCheckBox.isSelected()) {
			JMeterTestSuiteOptionsComboBox.setEnabled(true);
			JMeterEnterTestSuitePath.setEnabled(true);
		}
		else {
			JMeterTestSuiteOptionsComboBox.setEnabled(false);
			JMeterEnterTestSuitePath.setEnabled(false);
		}
		
		if(carryOutSeleniumTestingCheckBox.isSelected()) {
			seleniumTestSuiteOptionsComboBox.setEnabled(true);
			seleniumEnterTestSuitePath.setEnabled(true);
		}
		else {
			seleniumTestSuiteOptionsComboBox.setEnabled(false);
			seleniumEnterTestSuitePath.setEnabled(false);
		}
	}
	
	void setTextFieldPlaceHolders() { //Sets the default values for the text fields
		APIEnterTestSuitePath.setText(findDefaultTextFieldValue((String)APITestSuiteOptionsComboBox.getSelectedItem()));
		appiumEnterTestSuitePath.setText(findDefaultTextFieldValue((String)appiumTestSuiteOptionsComboBox.getSelectedItem()));
		JMeterEnterTestSuitePath.setText(findDefaultTextFieldValue((String)JMeterTestSuiteOptionsComboBox.getSelectedItem()));
		seleniumEnterTestSuitePath.setText(findDefaultTextFieldValue((String)seleniumTestSuiteOptionsComboBox.getSelectedItem()));
	}
	
	String findDefaultTextFieldValue(String comboBoxValue) {
		String defaultTextFieldValue = "";
		
		if(comboBoxValue == "Google Sheets") {
			defaultTextFieldValue = "Default Test Suite ID";
		}
		else if(comboBoxValue == "Excel") {
			defaultTextFieldValue = "Default Test Suite File Path";
		}
		else if(comboBoxValue == "JUnit") {
			defaultTextFieldValue = "Default JUnit Test Suite";
		}
		else {
			defaultTextFieldValue = "Default Test Suite Path";
		}
		
		return defaultTextFieldValue;
	}
}