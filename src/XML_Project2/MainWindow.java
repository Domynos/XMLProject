package XML_Project2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
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
import java.io.IOException;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

        frame.setTitle("--- Archimed V1.0 Release 2.3 --- Drag&Drop Mothafucka");

        JPanel panel = createEmptyJPanel();
        new MyDropTargetListener(panel);//this must be done or we wont be able to drop any image onto the empty panel

        frame.add(panel, BorderLayout.NORTH);
        JPanel panel2 = createEmptyJPanel();
        new MyDropTargetListener(panel2);//this must be done or we wont be able to drop any image onto the empty panel

        frame.add(panel2, BorderLayout.CENTER);
        try {
            frame.add(createJLabelPanel(), BorderLayout.SOUTH);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        frame.pack();

        return frame;
    }

    private static JPanel createEmptyJPanel() {
        final JPanel p = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
        		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        		int hauteur = (int)tailleEcran.getHeight();
        		int largeur = (int)tailleEcran.getWidth();
                return new Dimension(largeur-20, hauteur/3);
            }
        };
        p.setBorder(new TitledBorder("Déposez vos éléments ici"));

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

        JLabel label1 = new JLabel(new ImageIcon("images/alcazar.gif"));
        JLabel label2 = new JLabel(new ImageIcon("images/alvarez.gif"));
        JLabel label3 = new JLabel(new ImageIcon("images/bacter.gif"));
        JLabel label4 = new JLabel(new ImageIcon("images/capone.gif"));
        JLabel label5 = new JLabel(new ImageIcon("images/dupond.gif"));
        JLabel label6 = new JLabel(new ImageIcon("images/dupont.gif"));
        JLabel label7 = new JLabel(new ImageIcon("images/haddock.gif"));
        JLabel label8 = new JLabel(new ImageIcon("images/koko.gif"));
        JLabel label9 = new JLabel(new ImageIcon("images/lampion.gif"));
        JLabel label10 = new JLabel(new ImageIcon("images/mateo.gif"));
        JLabel label11 = new JLabel(new ImageIcon("images/milou.gif"));
        JLabel label12 = new JLabel(new ImageIcon("images/muller.gif"));
        JLabel label13 = new JLabel(new ImageIcon("images/nestor.gif"));
        JLabel label14 = new JLabel(new ImageIcon("images/bacter.gif"));
        JLabel label15 = new JLabel(new ImageIcon("images/pablo.gif"));
        JLabel label16 = new JLabel(new ImageIcon("images/prof.gif"));
        JLabel label17 = new JLabel(new ImageIcon("images/prof2.gif"));
        JLabel label18 = new JLabel(new ImageIcon("images/skharine.gif"));
        JLabel label19 = new JLabel(new ImageIcon("images/sponz.gif"));
        JLabel label20 = new JLabel(new ImageIcon("images/tchang.gif"));
        JLabel label21 = new JLabel(new ImageIcon("images/tintin.gif"));
        JLabel label22 = new JLabel(new ImageIcon("images/tournesol.gif"));
        JLabel label23 = new JLabel(new ImageIcon("images/wagner.gif"));
        JLabel label24 = new JLabel(new ImageIcon("images/wolf.gif"));
        
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
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        panel.add(label9);
        panel.add(label10);
        panel.add(label11);
        panel.add(label12);
        panel.add(label13);
        panel.add(label14);
        panel.add(label15);
        panel.add(label16);
        panel.add(label17);
        panel.add(label18);
        panel.add(label19);
        panel.add(label20);
        panel.add(label21);
        panel.add(label22);
        panel.add(label23);
        panel.add(label24);
        return panel;
    }
}

class MyDropTargetListener extends DropTargetAdapter {

    private DropTarget dropTarget;
    private JPanel p;

    public MyDropTargetListener(JPanel panel) {
        p = panel;
        dropTarget = new DropTarget(panel, DnDConstants.ACTION_COPY, this, true, null);

    }

    @Override
    public void drop(DropTargetDropEvent event) {
        try {
            DropTarget test = (DropTarget) event.getSource();
            Component ca = (Component) test.getComponent();
            Point dropPoint = ca.getMousePosition();
            Transferable tr = event.getTransferable();

            if (event.isDataFlavorSupported(DataFlavor.imageFlavor)) {
                Icon ico = (Icon) tr.getTransferData(DataFlavor.imageFlavor);

                if (ico != null) {

                    p.add(new JLabel(ico));
                    p.revalidate();
                    p.repaint();
                    event.dropComplete(true);
                }
            } else {
                event.rejectDrop();
            }
        } catch (Exception e) {
            e.printStackTrace();
            event.rejectDrop();
        }
    }
}

class MyDragGestureListener implements DragGestureListener {

    @Override
    public void dragGestureRecognized(DragGestureEvent event) {
        JLabel label = (JLabel) event.getComponent();
        final Icon ico = label.getIcon();


        Transferable transferable = new Transferable() {
            @Override
            public DataFlavor[] getTransferDataFlavors() {
                return new DataFlavor[]{DataFlavor.imageFlavor};
            }

            @Override
            public boolean isDataFlavorSupported(DataFlavor flavor) {
                if (!isDataFlavorSupported(flavor)) {
                    return false;
                }
                return true;
            }

            @Override
            public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
                return ico;
            }
        };
        event.startDrag(null, transferable);
    }
}
