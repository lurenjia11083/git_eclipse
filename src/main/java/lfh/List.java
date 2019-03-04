package lfh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class List {
public static void main(String[] args) {
	LinkedList<Integer> list = new LinkedList<Integer>();
	list.add(1);
	list.add(2);
	list.add(3);
	list.add(2, 9);
	Iterator<Integer> it = list.iterator();
	while(it.hasNext()){
		System.out.println(it.next());
	}
	ArrayList<Integer> list2 = new ArrayList<Integer>();
	list2.add(1);
	list2.add(2);
	list2.add(3);
	list2.add(2, 9);
	Iterator<Integer> it2 = list2.iterator();
	while(it2.hasNext()){
		System.out.println(it2.next());
	}
}
	
	
}
