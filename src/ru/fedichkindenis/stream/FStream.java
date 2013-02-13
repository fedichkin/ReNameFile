package ru.fedichkindenis.stream;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class FStream extends Thread {

	private List<Object> obj = new ArrayList<Object>();
	private List<Object> res = new ArrayList<Object>();
	private List<Method> met = new ArrayList<Method>();
	private List<Object[]> args = new ArrayList<Object[]>();
	
	public void addMethod(Method met, Object obj, Object...args){
		
		this.met.add(met);
		this.obj.add(obj);
		this.args.add(args.clone());
	}
	
	public Object getRes(Method met){
		
		return res.get(this.met.indexOf(met));
	}
	
	@Override
	public void run(){
		
		try {
			for(int i = 0;i < met.size();i++){
				res.add(met.get(i).invoke(obj.get(i), args.get(i)));
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
