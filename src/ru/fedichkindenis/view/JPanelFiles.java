/**
 * Creating a panel with a list of files
 * @author Fedichkin Denis
 * @version 1.0
 */

package ru.fedichkindenis.view;

import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JPanelFiles extends JPanel{
	
	/** Component contains a list of files found */
	private JList jListFiles = null;
	
	/** initialization of graphical components */
	public JPanelFiles(){
		
		/** Set layout */
		BoxLayout bl_PanelFiles = new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(bl_PanelFiles);
		
		jListFiles = new JList();
		jListFiles.setListData(new String [] {"12345", "67890"});
		add(jListFiles);
	}
}
