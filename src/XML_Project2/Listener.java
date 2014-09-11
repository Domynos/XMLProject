package XML_Project2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Listener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	String ClickedButton = ((JMenuItem)o).getName();
	
	switch(ClickedButton)
	{
		case "loadproject" : 
			JFileChooser fc = new JFileChooser();
			fc.showDialog(fc, ClickedButton);
		break;
		case "deleteproject" :
			JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer votre projet ?");
			break;
		case "aha":
			break;
		default : 
			break;
	}
	JOptionPane.showMessageDialog(null, "Element cliqué : "+ClickedButton);
	}

}
