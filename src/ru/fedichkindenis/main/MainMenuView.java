package ru.fedichkindenis.main;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class MainMenuView extends JTabbedPane{

	public MainMenuView(){
		
		addTab("����� �����", new JPanel());
		addTab("������� ��������������", new JPanel());
	}
}
