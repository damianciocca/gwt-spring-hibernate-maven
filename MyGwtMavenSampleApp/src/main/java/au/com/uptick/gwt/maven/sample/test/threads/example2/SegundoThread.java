package au.com.uptick.gwt.maven.sample.test.threads.example2;

import java.util.ArrayList;
import java.util.List;

public class SegundoThread implements Runnable{
	
	List<String> lista = new ArrayList<String>();

	public void run() {
		
		synchronized(lista){
			if(lista.size() == 0){
				try {
					System.out.println("BEFORE WAITING...");
					lista.wait();
					System.out.println("AFTER WAITING...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void addStringAndNotify(String s){
		
		synchronized(lista){
			System.out.println("BEFORE ADDING...");
			lista.add(s);
			System.out.println("AFTER ADDING...");
			lista.notify();
		}
	}

}
