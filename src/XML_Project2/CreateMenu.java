package XML_Project2;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RepaintManager;
import javax.swing.TransferHandler;
import javax.swing.border.Border;





public class CreateMenu extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public CreateMenu(JFrame f){
		//On recupere la taille de l'écran
		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur = (int)tailleEcran.getHeight();
		int largeur = (int)tailleEcran.getWidth();
		
		Container conteneur = this.getContentPane();//creation conteneur
        GridBagLayout disposition = new GridBagLayout();//creation grille
        conteneur.setLayout(disposition);
        
        
        //Ecouteur 
        Listener l = new Listener();
        
        //Barre de menu 
        JMenuBar bmenu = new JMenuBar();
        //Menus 
        JMenu project = new JMenu("Projet");
        JMenu simulation = new JMenu("Simulation");
        
        //Sous menu simulation
        JMenuItem startSimulation = new JMenuItem("Démarrer");
        JMenuItem checkSimulation = new JMenuItem("Vérifier");
        JMenuItem newSimulation = new JMenuItem("Nouveau");
        JMenuItem loadSimulation = new JMenuItem("Charger");
        JMenuItem saveSimulation = new JMenuItem("Sauvegarder");
        JMenuItem deleteSimulation = new JMenuItem("Supprimer");
        JMenuItem quitSimulation = new JMenuItem("Quitter");
        	//On set les noms
        	startSimulation.setName("startSimulation");
        	checkSimulation.setName("checkSimulation");
	        newSimulation.setName("newSimulation");
	        loadSimulation.setName("loadSimulation");
	        saveSimulation.setName("saveSimulation");
	        deleteSimulation.setName("deleteSimulation");
	        quitSimulation.setName("quitSimulation");
	        //Ajout des listeners
	        startSimulation.addActionListener(l);
	        checkSimulation.addActionListener(l);
	        newSimulation.addActionListener(l);
	        loadSimulation.addActionListener(l);
	        saveSimulation.addActionListener(l);
	        deleteSimulation.addActionListener(l);
	        quitSimulation.addActionListener(l);
	    simulation.add(startSimulation);
	    simulation.add(checkSimulation);
	    simulation.add(newSimulation);
	    simulation.add(loadSimulation);
	    simulation.add(saveSimulation);
	    simulation.add(deleteSimulation);
	    simulation.add(quitSimulation);
	    
	    bmenu.add(simulation);
        //Ajout de la barre sur le container
	    f.setJMenuBar(bmenu);

	}
	//Ecouteur d'evenements
	public void actionPerformed(ActionEvent e)
	{
		Object o=e.getSource();
		JOptionPane.showMessageDialog(null, "Tu t'es fait cliquer batard");
	}
}
