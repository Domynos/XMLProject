package XML_Project2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Console;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.swing.TransferHandler.TransferSupport;
import javax.swing.border.TitledBorder;

public class MainWindow {

	static JFrame frame = createJFrame();
    public static void main(String[] args) {
       
    }

    public static void createAndShowJFrame() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            
            public void run() {

                frame.setVisible(true);
            }
        });
    }

    private static JFrame createJFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("--- Archimed V1.0 Release 1 --- Drag&Drop Mothafucka");
        GridLayout experimentLayout = new GridLayout(4,0);
        frame.setLayout(experimentLayout);
        JPanel panel = createEmptyJPanel("XML");
        new MyDropTargetListener(panel);//this must be done or we wont be able to drop any image onto the empty panel
        frame.add(panel);
        
        JPanel panel2 = createEmptyJPanel("Adapters");
        new MyDropTargetListener(panel2);//this must be done or we wont be able to drop any image onto the empty panel
        frame.add(panel2);
       
        JPanel panel3 = createEmptyJPanel("Sources");
        new MyDropTargetListener(panel3);//this must be done or we wont be able to drop any image onto the empty panel
        frame.add(panel3);
        
        try {

            frame.add(createJLabelPanel());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        frame.pack();

        return frame;
    }

    private static JPanel createEmptyJPanel(String title) {
       JPanel p = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
        		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        		int hauteur = (int)tailleEcran.getHeight();
        		int largeur = (int)tailleEcran.getWidth();
                return new Dimension(largeur-20, hauteur/4);
            }
        };
        p.setBorder(new TitledBorder(title));
        p.setName(title);
        TransferHandler dnd = new TransferHandler() {
            @Override
            public boolean canImport(TransferSupport support) {
                if (!support.isDrop()) {
                    return false;
                }
                //only Strings
                if (!support.isDataFlavorSupported(DataFlavor.imageFlavor)) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean importData(TransferSupport support) {
                if (!canImport(support)) {
                    return false;
                }

                Transferable tansferable = support.getTransferable();
                Icon ico;
                try {
                    ico = (Icon) tansferable.getTransferData(DataFlavor.imageFlavor);
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
                p.add(new JLabel(ico));
                return true;
            }
        };

        p.setTransferHandler(dnd);

        return p;
    }

    private static JPanel createJLabelPanel() throws Exception {
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder("Deposez les éléments au dessus"));
        JPanel adapterPanel = new JPanel();
        adapterPanel.setBorder(new TitledBorder("Adapteurs"));
        JPanel sourcePanel = new JPanel();
        sourcePanel.setBorder(new TitledBorder("Sources"));
        JLabel label1 = new JLabel(new ImageIcon("images/adapters/csv.gif"));
        JLabel label2 = new JLabel(new ImageIcon("images/adapters/json.gif"));
        JLabel label3 = new JLabel(new ImageIcon("images/adapters/sql.gif"));
        JLabel label4 = new JLabel(new ImageIcon("images/adapters/xml.gif"));
        JLabel label5 = new JLabel(new ImageIcon("images/sources/csv.gif"));
        JLabel label6 = new JLabel(new ImageIcon("images/sources/json.gif"));
        JLabel label7 = new JLabel(new ImageIcon("images/sources/sql.gif"));
        JLabel label8 = new JLabel(new ImageIcon("images/sources/xml.gif"));

        
        MyDragGestureListener dlistener = new MyDragGestureListener();
        DragSource ds1 = new DragSource();
        ds1.createDefaultDragGestureRecognizer(label1, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds2 = new DragSource();
        ds2.createDefaultDragGestureRecognizer(label2, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds3 = new DragSource();
        ds3.createDefaultDragGestureRecognizer(label3, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds4 = new DragSource();
        ds4.createDefaultDragGestureRecognizer(label4, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds5 = new DragSource();
        ds5.createDefaultDragGestureRecognizer(label5, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds6 = new DragSource();
        ds6.createDefaultDragGestureRecognizer(label6, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds7 = new DragSource();
        ds7.createDefaultDragGestureRecognizer(label7, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds8 = new DragSource();
        ds8.createDefaultDragGestureRecognizer(label8, DnDConstants.ACTION_COPY, dlistener);
       
        
        adapterPanel.add(label1);
        adapterPanel.add(label2);
        adapterPanel.add(label3);
        adapterPanel.add(label4);
        sourcePanel.add(label5);
        sourcePanel.add(label6);
        sourcePanel.add(label7);
        sourcePanel.add(label8);
        GridLayout experimentLayout = new GridLayout(0,2);
        panel.setLayout(experimentLayout);
        panel.add(adapterPanel);
        panel.add(sourcePanel);
        return panel;
    }
    static void addElementByLoad(String elementName, String type)
    {
    	//On recupere nos deux JPanels source et adapter
    	JPanel source = null;
    	JPanel adapter = null;
    	menuContextuel menu = new menuContextuel();
    	JPanel p = (JPanel) frame.getContentPane();
    	for(Component c : p.getComponents())
    	{
    		JPanel d = (JPanel) c;
    		if("Adapters" == d.getName())
    		{
    			adapter = d;
    		}
    		if("Sources" == d.getName())
    		{
    			source = d;
    		}
    	}
    	//On créé l'élément à ajouter
    	JLabel label = new JLabel(new ImageIcon("images/"+type+"/"+elementName));
    	label.setName(elementName);
    	label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	int buttonIndex = Integer.parseInt(e.paramString().substring(((e.paramString().indexOf("button=")+7)),((e.paramString().indexOf("button=")+8))));
					if(3 == buttonIndex)//RightClick
					{
						//Affichage menu contextuel
						menu.setParent(label);
						menu.show(e.getComponent(), e.getX(), e.getY());
					}
            }
        });
    	if(type.equals("adapters"))
    	{
    		adapter.add(label);
            adapter.revalidate();
            adapter.repaint();
    	}
    	if(type.equals("sources"))
    	{
    		source.add(label);
            source.revalidate();
            source.repaint();
    	}
    }
    static void cleanWindow(){
    	JPanel p = (JPanel) frame.getContentPane();
    	for(Component c : p.getComponents())
    	{
			JPanel d = (JPanel) c;
    		if("Adapters" == c.getName() || "Sources" == c.getName())
    		{
    			for(Component l : d.getComponents())
    			{
    				l.setVisible(false);
    			}
    		}
    	}
    }
    static void close(){
    	frame.setVisible(false);
    }
    static ArrayList<String> getWindowAdpaters(){
    	ArrayList<String> result = new ArrayList();
    	JPanel p = (JPanel) frame.getContentPane();
    	for(Component c : p.getComponents())
    	{
    		JPanel d = (JPanel) c;
    		if("Adapters" == c.getName())
    		{
    			for(Component l : d.getComponents())
    			{
    				result.add(l.getName());
    			}
    		}
    	}
    	return result;
    }
    static ArrayList<String> getWindowSources(){
    	ArrayList<String> result = new ArrayList();
    	JPanel p = (JPanel) frame.getContentPane();
    	for(Component c : p.getComponents())
    	{
    		JPanel d = (JPanel) c;
    		if("Sources" == c.getName())
    		{
    			for(Component l : d.getComponents())
    			{
    				result.add(l.getName());
    			}
    		}
    	}
		return result;
    }
}

