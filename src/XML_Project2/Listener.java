package XML_Project2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Listener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	String ClickedButton = ((JMenuItem)o).getName();
	int result;
	switch(ClickedButton)
	{
		case "startSimulation" : 
			JOptionPane.showMessageDialog(null, "start");
			break;
		case "checkSimulation" : 
			Xml_utils.checkXmlDocumentIntegrity();
			break;
		case "newSimulation":
			JOptionPane.showMessageDialog(null, "nouveau");
			break;
		case "loadSimulation":
			JFileChooser loadFileChooser = new JFileChooser();
			loadFileChooser.setDialogTitle("Charger une simulation");
			FileNameExtensionFilter xmlFilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
			loadFileChooser.addChoosableFileFilter(xmlFilter);
			loadFileChooser.setFileFilter(xmlFilter);
			loadFileChooser.removeChoosableFileFilter(loadFileChooser.getAcceptAllFileFilter());
			int status = loadFileChooser.showOpenDialog(loadFileChooser);
			if(JFileChooser.APPROVE_OPTION == status)
			{
				MainWindow.cleanWindow();
				File file = loadFileChooser.getSelectedFile();
				String fileLocation = file.getAbsolutePath();
				try {
					Xml_utils.loadXmlConfigFile(fileLocation);
				} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SAXException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			break;
		case "saveSimulation":
			JFileChooser saveFileChooser = new JFileChooser();
			saveFileChooser.setDialogTitle("Sauvegarder une simulation");
			FileNameExtensionFilter xmlFilter1 = new FileNameExtensionFilter("xml files (*.xml)", "xml");
			saveFileChooser.addChoosableFileFilter(xmlFilter1);
			saveFileChooser.setFileFilter(xmlFilter1);
			saveFileChooser.removeChoosableFileFilter(saveFileChooser.getAcceptAllFileFilter());
			status = saveFileChooser.showSaveDialog(saveFileChooser);
			if(JFileChooser.APPROVE_OPTION == status)
			{
				File file = saveFileChooser.getSelectedFile();
				String fileLocation = file.getAbsolutePath();
				try {
					Xml_utils.writeXmlFile(Xml_utils.createXmlConfigDoc(), fileLocation);
				} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			break;
		case "deleteSimulation":
			result = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer la simulation en cours ?", "Supprimer la simulation ?", JOptionPane.YES_NO_OPTION);
			if(0 == result)
			{
				//delete la simulation
				MainWindow.cleanWindow();
			}
			break;
		case "quitSimulation":
			result = JOptionPane.showConfirmDialog(null, "Tout ce qui n'est pas sauvegardé sera perdu. Continuer ?", "Quitter archimed ?", JOptionPane.YES_NO_OPTION);
			if(0 == result)
			{
				MainWindow.close();
			}
			break;
		default : 
			break;
	}
	}
}
