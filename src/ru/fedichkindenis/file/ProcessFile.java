package ru.fedichkindenis.file;

import java.io.File;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import ru.fedichkindenis.main.UpdateInfo;

public class ProcessFile {

	public static ArrayList<String> findNEF(File f, final UpdateInfo ui){
		
		ArrayList<String> listFile = new ArrayList<String>();
		
		File [] list = f.listFiles();
		
		for(int i = 0;(list != null) && i < list.length;i++){
			
			if(list[i].isFile()){
				
				String tmp = list[i].getName();
				
				if(tmp.length() > 3 && tmp.substring(tmp.length()-3).equalsIgnoreCase("sql")){
					
					final String str = list[i].getPath();
					
					listFile.add(str);

					SwingUtilities.invokeLater(new Runnable(){

						@Override
						public void run() {
							
							ui.sendNewData(str);
						}
						
					});	
				}
			}
			else if(list[i].isDirectory()){
				listFile.addAll(findNEF(list[i], ui));
			}
		}
		
		return listFile;
	}
}
