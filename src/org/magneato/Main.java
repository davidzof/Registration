package org.magneato;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * Main code
 * 
 * @author David George
 * (c) 2013
 */
public class Main implements Runnable {

	public void run() {
		JFrame frame = new JFrame();
		frame.setTitle("Registration Test");
		frame.add(new AboutPanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension d = new Dimension(500, 300);
		frame.setSize(d);

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Main());
	}

}
