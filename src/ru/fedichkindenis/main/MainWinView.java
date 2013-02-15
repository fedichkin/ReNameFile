package ru.fedichkindenis.main;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MainWinView extends JFrame{

	private JPanel jContentPanel = null;
	
	public MainWinView(){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 200, 800, 600);
		
		jContentPanel = new JPanel();
		jContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		GridBagLayout gbl_jContentPanel = new GridBagLayout();
	}
}
