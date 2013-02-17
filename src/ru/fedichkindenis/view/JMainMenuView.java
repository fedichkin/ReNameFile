/**
 * Create the main menu
 * @author Fedichkin Denis
 * @version 1.0
 */

package ru.fedichkindenis.view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class JMainMenuView extends JTabbedPane{

	/** initialization of graphical components */
	public JMainMenuView(){
		
		addTab("Поиск файла", new JPanel());
		addTab("Шаблоны переименования", new JPanel());
	}
}
