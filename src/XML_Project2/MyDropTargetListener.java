package XML_Project2;

import java.awt.Component;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
                Icon ico = (Icon) tr.getTransferData(DataFlavor.imageFlavor);;
                if (ico != null) {
                	if(ico.toString().contains(test.getComponent().getName().toLowerCase()))
                	{
                		final JLabel replace = new JLabel(ico);
                        replace.addMouseListener(new MouseAdapter() {
                            public void mouseClicked(MouseEvent e) {
                            	int buttonIndex = Integer.parseInt(e.paramString().substring(((e.paramString().indexOf("button=")+7)),((e.paramString().indexOf("button=")+8))));
									if(3 == buttonIndex)//RightClick
										System.out.println("Right click");
                            }
                        });
	                    p.add(replace);
	                    p.revalidate();
	                    p.repaint();
	                    Xml_utils.readConfigFile("xmlfiles/config.xml");
	                    event.dropComplete(true);
                	}else
                	{
                		JOptionPane.showMessageDialog(null, "Can't drop, this is not a "+test.getComponent().getName().toLowerCase()+" biatch");
                	}
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