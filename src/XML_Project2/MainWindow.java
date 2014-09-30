package XML_Project2;

import java.awt.BorderLayout;
import java.awt.Component;
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
        final JPanel p = new JPanel() {
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
        JLabel label1 = new JLabel(new ImageIcon("images/adapters/alcazar.gif"));
        JLabel label2 = new JLabel(new ImageIcon("images/adapters/alvarez.gif"));
        JLabel label3 = new JLabel(new ImageIcon("images/adapters/bacter.gif"));
        JLabel label4 = new JLabel(new ImageIcon("images/adapters/capone.gif"));
        JLabel label5 = new JLabel(new ImageIcon("images/adapters/dupond.gif"));
        JLabel label6 = new JLabel(new ImageIcon("images/adapters/dupont.gif"));
        JLabel label7 = new JLabel(new ImageIcon("images/adapters/haddock.gif"));
        JLabel label8 = new JLabel(new ImageIcon("images/adapters/koko.gif"));
        JLabel label9 = new JLabel(new ImageIcon("images/adapters/lampion.gif"));
        JLabel label10 = new JLabel(new ImageIcon("images/sources/mateo.gif"));
        JLabel label11 = new JLabel(new ImageIcon("images/sources/milou.gif"));
        JLabel label12 = new JLabel(new ImageIcon("images/sources/muller.gif"));
        JLabel label13 = new JLabel(new ImageIcon("images/sources/nestor.gif"));
        JLabel label14 = new JLabel(new ImageIcon("images/sources/bacter.gif"));
        JLabel label15 = new JLabel(new ImageIcon("images/sources/pablo.gif"));
        JLabel label16 = new JLabel(new ImageIcon("images/sources/prof.gif"));
        JLabel label17 = new JLabel(new ImageIcon("images/sources/prof2.gif"));
        JLabel label18 = new JLabel(new ImageIcon("images/sources/skharine.gif"));
        JLabel label19 = new JLabel(new ImageIcon("images/sources/sponz.gif"));
        JLabel label20 = new JLabel(new ImageIcon("images/sources/tchang.gif"));
        JLabel label21 = new JLabel(new ImageIcon("images/sources/tintin.gif"));
        JLabel label22 = new JLabel(new ImageIcon("images/sources/tournesol.gif"));
        JLabel label23 = new JLabel(new ImageIcon("images/sources/wagner.gif"));
        JLabel label24 = new JLabel(new ImageIcon("images/sources/wolf.gif"));
        
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
        DragSource ds9 = new DragSource();
        ds9.createDefaultDragGestureRecognizer(label9, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds10 = new DragSource();
        ds10.createDefaultDragGestureRecognizer(label10, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds11 = new DragSource();
        ds11.createDefaultDragGestureRecognizer(label11, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds12 = new DragSource();
        ds12.createDefaultDragGestureRecognizer(label12, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds13 = new DragSource();
        ds13.createDefaultDragGestureRecognizer(label13, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds14 = new DragSource();
        ds14.createDefaultDragGestureRecognizer(label14, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds15 = new DragSource();
        ds15.createDefaultDragGestureRecognizer(label15, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds16 = new DragSource();
        ds16.createDefaultDragGestureRecognizer(label16, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds17 = new DragSource();
        ds17.createDefaultDragGestureRecognizer(label17, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds18 = new DragSource();
        ds18.createDefaultDragGestureRecognizer(label18, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds19 = new DragSource();
        ds19.createDefaultDragGestureRecognizer(label19, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds20 = new DragSource();
        ds20.createDefaultDragGestureRecognizer(label20, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds21 = new DragSource();
        ds21.createDefaultDragGestureRecognizer(label21, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds22 = new DragSource();
        ds22.createDefaultDragGestureRecognizer(label22, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds23 = new DragSource();
        ds23.createDefaultDragGestureRecognizer(label23, DnDConstants.ACTION_COPY, dlistener);
        DragSource ds24 = new DragSource();
        ds24.createDefaultDragGestureRecognizer(label24, DnDConstants.ACTION_COPY, dlistener);

        
        adapterPanel.add(label1);
        adapterPanel.add(label2);
        adapterPanel.add(label3);
        adapterPanel.add(label4);
        adapterPanel.add(label5);
        adapterPanel.add(label6);
        adapterPanel.add(label7);
        adapterPanel.add(label8);
        adapterPanel.add(label9);
        sourcePanel.add(label10);
        sourcePanel.add(label11);
        sourcePanel.add(label12);
        sourcePanel.add(label13);
        sourcePanel.add(label14);
        sourcePanel.add(label15);
        sourcePanel.add(label16);
        sourcePanel.add(label17);
        sourcePanel.add(label18);
        sourcePanel.add(label19);
        sourcePanel.add(label20);
        sourcePanel.add(label21);
        sourcePanel.add(label22);
        sourcePanel.add(label23);
        sourcePanel.add(label24);
        GridLayout experimentLayout = new GridLayout(0,2);
        panel.setLayout(experimentLayout);
        panel.add(adapterPanel);
        panel.add(sourcePanel);
        return panel;
    }
}

