package XML_Project2;


import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class menuContextuel extends JPopupMenu{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuItem deleteItem = new JMenuItem("Supprimer");
	private JMenuItem requetteItem = new JMenuItem("Requeteur XPath");
	menuContextuel()
	{

	}
	
	public void setParent(JLabel source)
	{
		ContextuelListener l = new ContextuelListener(source);
		deleteItem.setName("deleteItem");
		deleteItem.addActionListener(l);
		requetteItem.setName("requetteItem");
		requetteItem.addActionListener(l);
		add(requetteItem);
		add(deleteItem);
	}
}
