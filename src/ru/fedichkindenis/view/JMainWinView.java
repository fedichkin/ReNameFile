/**
 * Create the main window 
 * @author Fedichkin Denis
 * @version 1.0
 */

package ru.fedichkindenis.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JMainWinView extends JFrame{

	/** main panel */
	private JPanel jContentPanel = null;
	
	/** main menu */
	private JMainMenuView jMainMenu = null;
	
	/** panel with a list of files */
	private JPanelFiles jPanelFiles = null;
	
	/** initialization of graphical components */
	public JMainWinView(){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 200, 800, 600);
		
		/** initialization jContentPanel */
		jContentPanel = new JPanel();
		jContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_jContentPanel = new GridBagLayout();
		gbl_jContentPanel.columnWeights = new double [] {1.0, 0.0};
		gbl_jContentPanel.rowWeights = new double [] {0.0, 1.0};
		jContentPanel.setLayout(gbl_jContentPanel);
		setContentPane(jContentPanel);
		
		/** initialization jMainMenu */
		jMainMenu = new JMainMenuView();
		GridBagConstraints gbc_jMainMenu = new GridBagConstraints();
		gbc_jMainMenu.anchor = GridBagConstraints.NORTH;
		gbc_jMainMenu.insets = new Insets(0, 0, 0, 0);
		gbc_jMainMenu.fill = GridBagConstraints.HORIZONTAL;
		gbc_jMainMenu.gridx = 0;
		gbc_jMainMenu.gridy = 0;
		gbc_jMainMenu.gridwidth = 2;
		jContentPanel.add(jMainMenu, gbc_jMainMenu);
		
		/** initialization jPanelFiles */
		jPanelFiles = new JPanelFiles();
		GridBagConstraints gbc_jPanelFiles = new GridBagConstraints();
		gbc_jPanelFiles.anchor = GridBagConstraints.NORTH;
		gbc_jPanelFiles.insets = new Insets(0, 0, 0, 0);
		gbc_jPanelFiles.fill = GridBagConstraints.HORIZONTAL;
		gbc_jPanelFiles.gridx = 0;
		gbc_jPanelFiles.gridy = 1;
		jContentPanel.add(jPanelFiles, gbc_jPanelFiles);
	}
}
