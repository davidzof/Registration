package org.magneato;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Registration Process View Object.
 * (c) 2013 David George
 */
public class AboutPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = -7939830514817673972L;
	private JLabel about;
	private JLabel message;
	JTextField regKey;
	private final String serial = Registration.getSerialNumber();

	public AboutPanel() {
		super();
		setBackground(Color.GRAY);

		int style1 = Font.CENTER_BASELINE;
		Font font = new Font("Arial", style1, 13);

		about = new JLabel();
		about.setFont(font);

		about.setText("<html>Registration Test<br>Serial no: " + serial);
		add(about);

		message = new JLabel();
		message.setFont(font);

		if (Registration.isRegistered()) {
			String key = Registry.INSTANCE.getRegistrationKey();
			try {
				if (Registration.register(key, serial)) {
					message.setText("Your software is registered");
				} else {
					message.setText("Incorrect registration key");
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				message.setText("Error in registration key");
			}

		} else {
			message.setText("Your software is not registered");
		}
		add(message);

		regKey = new JTextField(45);

		add(regKey);

		JButton getKeyButton = new JButton("Get Key");
		getKeyButton.setPreferredSize(new Dimension(120, 30));
		getKeyButton.setActionCommand("getkey");
		getKeyButton.addActionListener(this);
		add(getKeyButton);

		JButton registrationButton = new JButton("Register");
		registrationButton.setPreferredSize(new Dimension(120, 30));
		registrationButton.setActionCommand("register");
		registrationButton.addActionListener(this);
		add(registrationButton);
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if ("getkey".equals(command)) {
			try {
				String key = Registration.getKey(serial);
				regKey.setText(key);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			String key = regKey.getText();
			try {
				if (Registration.register(key, serial)) {

					message.setText("Your software has been registered successfully");
				} else {
					message.setText("Incorrect registration key");

				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				message.setText("Error in registration key, please check");

			}
			Registry.INSTANCE.setRegistrationKey(key); // set key for better or
														// worse
		}

		setVisible(true);
	}

}
