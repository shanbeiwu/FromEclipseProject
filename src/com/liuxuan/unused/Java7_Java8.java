package com.liuxuan.unused;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Java7_Java8 {
	
	public static void test() {
		
	}
	
	public static void main(String[] args) {
		String[] atp = {"Rafael Nadal", "Novak Djokovic",  
			       "Stanislas Wawrinka",  
			       "David Ferrer","Roger Federer",  
			       "Andy Murray","Tomas Berdych",  
			       "Juan Martin Del Potro"};  
			List<String> players =  Arrays.asList(atp); 
			
			Iterator<String> it = players.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
			  
			// ��ǰ��ѭ����ʽ  
			for (String player : players) {  
			     System.out.print(player + "; ");  
			}  
			  
			// ʹ�� lambda ���ʽ�Լ���������(functional operation)  
			players.forEach((player) -> System.out.print(player + "; "));  
			   
			// �� Java 8 ��ʹ��˫ð�Ų�����(double colon operator)  
			players.forEach(System.out::println);  
	}
}
