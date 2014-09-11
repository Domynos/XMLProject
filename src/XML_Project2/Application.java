package XML_Project2;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

public class Application {

	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {
				 MainWindow.createAndShowJFrame();
				 new CreateMenu(MainWindow.frame);
			}
		};
		EventQueue.invokeLater(r);
	}

}
