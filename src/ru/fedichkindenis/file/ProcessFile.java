package ru.fedichkindenis.file;

import java.io.File;
import java.util.ArrayList;

public class ProcessFile {

	public static ArrayList<String> findNEF(File f){
		
		ArrayList<String> listFile = new ArrayList<String>();
		
		File [] list = f.listFiles();
		
		for(int i = 0;(list != null) && i < list.length;i++){
			
			if(list[i].isFile()){
				
				String tmp = list[i].getName();
				
				if(tmp.length() > 3 && tmp.substring(tmp.length()-3).equalsIgnoreCase("nef")){
					
					listFile.add(list[i].getPath());
				}
			}
			else if(list[i].isDirectory()){
				listFile.addAll(findNEF(list[i]));
			}
		}
		
		return listFile;
	}
}
