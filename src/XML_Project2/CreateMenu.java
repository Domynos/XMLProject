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
        JMenu fichier = new JMenu("Fichier");
        JMenu editer = new JMenu("Editer");
        JMenu project = new JMenu("Projet");
        //SOus menu File
        JMenuItem newfile = new JMenuItem("Nouveau");
        newfile.setName("newfile");
        newfile.addActionListener(l);
        JMenuItem saveFile = new JMenuItem("Sauvegarder");
        saveFile.setName("savefile");
        saveFile.addActionListener(l);
        JMenuItem quitFile = new JMenuItem("Quitter");
        quitFile.setName("quitfile");
        quitFile.addActionListener(l);
        //Sous menu editer
        JMenuItem newEdit = new JMenuItem("Nouveau");
        newEdit.setName("newedit");
        newEdit.addActionListener(l);
        JMenuItem undoEdit = new JMenuItem("undo");
        undoEdit.setName("undoedit");
        undoEdit.addActionListener(l);
        
        //Sous menu projet
        JMenuItem newProjet = new JMenuItem("Nouveau");
        newProjet.setName("newproject");
        newProjet.addActionListener(l);
        JMenuItem loadProjet = new JMenuItem("Charger");
        loadProjet.setName("loadproject");
        loadProjet.addActionListener(l);
        project.addSeparator();
        JMenu elementProjet = new JMenu("Elements");
        JMenuItem elementAdd = new JMenuItem("Ajouter");
        elementAdd.setName("newelement");
        elementAdd.addActionListener(l);
        JMenuItem elementModif = new JMenuItem("Modifier");
        elementModif.setName("editelement");
        elementModif.addActionListener(l);
        JMenuItem elementDelete = new JMenuItem("Supprimer");
        elementDelete.setName("deleteelement");
        elementDelete.addActionListener(l);
        elementProjet.add(elementAdd);
        elementProjet.add(elementModif);
        elementProjet.add(elementDelete);
        JMenuItem deleteProjet = new JMenuItem("Supprimer");
        deleteProjet.setName("deleteproject");
        deleteProjet.addActionListener(l);
       
        //On ajoute les menuitem aux menus
        fichier.add(newfile);
        fichier.add(saveFile);
        fichier.add(quitFile);
        editer.add(newEdit);
        editer.add(undoEdit);
        project.add(newProjet);
        project.add(loadProjet);
        project.add(elementProjet);
        project.add(deleteProjet);
        bmenu.add(fichier);
        bmenu.add(editer);
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
