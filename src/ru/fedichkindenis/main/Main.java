package ru.fedichkindenis.main;

import java.awt.EventQueue;
import java.util.Locale;


public class Main {
	
	public static void main(String [] args){
		
		Locale.setDefault(new Locale("ru","RU"));
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWin frame = new MainWin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
