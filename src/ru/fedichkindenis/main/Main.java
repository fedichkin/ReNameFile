package ru.fedichkindenis.main;

import java.awt.EventQueue;
import java.util.Locale;

import ru.fedichkindenis.view.JMainWinView;


public class Main {
	
	public static void main(String [] args){
		
		Locale.setDefault(new Locale("ru","RU"));
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMainWinView frame = new JMainWinView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
