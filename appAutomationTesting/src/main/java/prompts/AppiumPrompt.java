package prompts;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import globalVariables.StandardVariables;

public class AppiumPrompt {

	/*
	 * This prompt asks the Tester for Variables needed to perform API testing
	 */

	StandardVariables standardVariables = new StandardVariables();

	JPanel panel = new JPanel(new GridLayout(0, 1));

	JCheckBox carryOutTestingCheckBox = new JCheckBox("Run Tests", true);

	JCheckBox carryOutApiTestingCheckBox = new JCheckBox("Run Api tests", true);
	JCheckBox carryOutAppiumTestingCheckBox = new JCheckBox("Run Appium tests", true);
	JCheckBox carryOutJMeterTestingCheckBox = new JCheckBox("Run Load tests", true);
	JCheckBox carryOutSeleniumTestingCheckBox = new JCheckBox("Run Selenium tests", true);

	JButton resetDefaults = new JButton("Reset Defaults");

	public boolean prompt() {
		createPrompt();

		int result = JOptionPane.showConfirmDialog(null, panel, "Appium Variables", JOptionPane.OK_CANCEL_OPTION,
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
		resetDefaults.addActionListener(resetDefaultsButtonActionHandler);

		// automationNamesTypeCombo.setSelectedItem("XCUITest");
		panel.add(carryOutTestingCheckBox);
		panel.add(carryOutApiTestingCheckBox);
		panel.add(carryOutAppiumTestingCheckBox);
		panel.add(carryOutJMeterTestingCheckBox);
		panel.add(carryOutSeleniumTestingCheckBox);

		panel.add(resetDefaults);

		setDefaults();
		enableDisableOptions();
	}

	public void updateGlobalVariables() {

		standardVariables.carryOutTesting = carryOutTestingCheckBox.isSelected();
		standardVariables.carryOutApiTesting = carryOutApiTestingCheckBox.isSelected();
		standardVariables.carryOutAppiumTesting = carryOutAppiumTestingCheckBox.isSelected();
		standardVariables.carryOutJMeterTesting = carryOutJMeterTestingCheckBox.isSelected();
		standardVariables.carryOutSeleniumTesting = carryOutSeleniumTestingCheckBox.isSelected();

		System.out.println("Finished Appium Testing Setup");
	}

	class EnableDisableOtherOptions implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// JCheckBox checkbox = (JCheckBox) event.getSource();
			enableDisableOptions();
		}
	}

	class ResetDefaultsButtonActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// JButton button = (JButton) event.getSource();
			setDefaults();
		}
	}

	public void setDefaults() {
		carryOutApiTestingCheckBox.setSelected(true);
		carryOutAppiumTestingCheckBox.setSelected(true);
		carryOutJMeterTestingCheckBox.setSelected(true);
		carryOutSeleniumTestingCheckBox.setSelected(true);
	}

	public void enableDisableOptions() {
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
	}
}
