package ru.fedichkindenis.stream;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FStream extends Thread {

	private Object obj = null;
	private Object res = null;
	private Method met = null;
	private Object [] args = null;
	
	public void setObject(Object obj){
		
		this.obj = obj;
	}
	
	public void setArgs(Object...args){
		
		this.args = args.clone();
	}
	
	public void setMethod(Method met){
		
		this.met = met;
	}
	
	public Object getRes(){
		
		return res;
	}
	
	@Override
	public void run(){
		
		try {
			res = met.invoke(obj, args);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
