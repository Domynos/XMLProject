package XML_Project2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ContextuelListener implements ActionListener{

	private JLabel source;
	ContextuelListener(JLabel l){
		source = l;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	String ClickedButton = ((JMenuItem)o).getName();
	
	switch(ClickedButton)
	{
		case "deleteItem":
				source.setVisible(false);
			break;
		case "requetteItem":
			JOptionPane.showInputDialog("Requetteur xpath pour "+source.getName());
			break;
		default : 
			break;
	}
	}

}
