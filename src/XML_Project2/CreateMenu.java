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

import junit.framework.Test;




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
        
        //Sous menu projet
        JMenuItem newProjet = new JMenuItem("Nouveau");
        newProjet.setName("newproject");
        newProjet.addActionListener(l);
        JMenuItem loadProjet = new JMenuItem("Charger");
        loadProjet.setName("loadproject");
        loadProjet.addActionListener(l);
        //project.addSeparator();
        //Projet -> element
        JMenu elementProjet = new JMenu("Elements");
        JMenuItem deleteProjet = new JMenuItem("Supprimer");
        deleteProjet.setName("deleteproject");
        deleteProjet.addActionListener(l);
        //Projet->element->ajouter
        JMenu elementProjetAdd = new JMenu("Ajouter");
        JMenuItem source = new JMenuItem("Source");
        source.setName("AddSource");
        source.addActionListener(l);
        JMenuItem adapter = new JMenuItem("Adapteur");
        adapter.setName("AddAdapter");
        adapter.addActionListener(l);
        elementProjetAdd.add(source);
        elementProjetAdd.add(adapter);
        elementProjet.add(elementProjetAdd);
        //Projet->element->supprimer
        JMenu elementProjetDel = new JMenu("Supprimer");
        JMenuItem sourced = new JMenuItem("Source");
        sourced.setName("DelSource");
        sourced.addActionListener(l);
        JMenuItem adapterd = new JMenuItem("Adapteur");
        adapterd.setName("AddAdapter");
        adapterd.addActionListener(l);
        elementProjetDel.add(sourced);
        elementProjetDel.add(adapter);
        elementProjet.add(elementProjetDel);
        //On ajoute les menuitem aux menus
        project.add(newProjet);
        project.add(loadProjet);
        project.add(elementProjet);
        project.add(deleteProjet);
        bmenu.add(project);
        
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
