package concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class IterateListTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
	    list.add(1);
	    list.add(2);
	    list.add(2);
	    list.add(3);
	    list.add(4);
	    for (int i = 0; i < list.size(); i++) {
	    	if (2 == list.get(i)) {
	    		list.remove(i);
	    	}
	    }
	    System.out.println("最后结果=" + list.toString());
	    
	    list = new ArrayList<Integer>();
	    list.add(1);
	    list.add(2);
	    list.add(2);
	    list.add(3);
	    list.add(4);
	    try {
			for (Integer value : list) {
				if (2 == value) {
					list.remove(value);
				}
			}
			System.out.println("最后结果=" + list.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    list = new ArrayList<Integer>();
	    list.add(1);
	    list.add(2);
	    list.add(2);
	    list.add(3);
	    list.add(4);
	    Iterator<Integer> it = list.iterator();
	    while (it.hasNext()) {
	    	if (2 == it.next()) {
	    		it.remove();
	    	}
	    }
	    System.out.println("最后结果=" + list.toString());
	    
	    list = new LinkedList<Integer>();
	    list.add(1);
	    list.add(2);
	    list.add(2);
	    list.add(3);
	    list.add(4);
	    for (int i = 0; i < list.size(); i++) {
	    	if (2 == list.get(i)) {
	    		list.remove(i);
	    	}
	    }
	    System.out.println("最后结果=" + list.toString());
	    
	    list = new LinkedList<Integer>();
	    list.add(1);
	    list.add(2);
	    list.add(2);
	    list.add(3);
	    list.add(4);
	    try {
			for (Integer value : list) {
				if (2 == value) {
					list.remove(value);
				}
			}
			System.out.println("最后结果=" + list.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    list = new LinkedList<Integer>();
	    list.add(1);
	    list.add(2);
	    list.add(2);
	    list.add(3);
	    list.add(4);
	    it = list.iterator();
	    while (it.hasNext()) {
	    	if (2 == it.next()) {
	    		it.remove();
	    	}
	    }
	    System.out.println("最后结果=" + list.toString());
	    
	    CopyOnWriteArrayList<Integer> list2 = new CopyOnWriteArrayList<Integer>();
	    list2.add(1);
	    list2.add(2);
	    list2.add(2);
	    list2.add(3);
	    list2.add(4);
	    for (int i = 0; i < list2.size(); i++) {
	    	if (2 == list2.get(i)) {
	    		list2.remove(i);
	    	}
	    }
	    System.out.println("最后结果=" + list2.toString());
	    
	    list2 = new CopyOnWriteArrayList<Integer>();
	    list2.add(1);
	    list2.add(2);
	    list2.add(2);
	    list2.add(3);
	    list2.add(4);
		for (Integer value : list2) {
			if (2 == value) {
				list2.remove(value);
			}
		}
		System.out.println("最后结果=" + list2.toString());
	    
	    list2 = new CopyOnWriteArrayList<Integer>();
	    list2.add(1);
	    list2.add(2);
	    list2.add(2);
	    list2.add(3);
	    list2.add(4);
	    try {
			it = list2.iterator();
			while (it.hasNext()) {
				if (2 == it.next()) {
					it.remove();
				}
			}
			System.out.println("最后结果=" + list2.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    List<Integer> list3 = Collections.synchronizedList(new ArrayList<Integer>());
	    list3.add(1);
	    list3.add(2);
	    list3.add(2);
	    list3.add(3);
	    list3.add(4);
	    for (int i = 0; i < list3.size(); i++) {
	    	if (2 == list3.get(i)) {
	    		list3.remove(i);
	    	}
	    }
	    System.out.println("最后结果=" + list3.toString());
	    
	    list3 = Collections.synchronizedList(new ArrayList<Integer>());
	    list3.add(1);
	    list3.add(2);
	    list3.add(2);
	    list3.add(3);
	    list3.add(4);
		try {
			for (Integer value : list3) {
				if (2 == value) {
					list3.remove(value);
				}
			}
			System.out.println("最后结果=" + list3.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
		list3 = Collections.synchronizedList(new ArrayList<Integer>());
	    list3.add(1);
	    list3.add(2);
	    list3.add(2);
	    list3.add(3);
	    list3.add(4);
		it = list3.iterator();
		while (it.hasNext()) {
			if (2 == it.next()) {
				it.remove();
			}
		}
		System.out.println("最后结果=" + list3.toString());
	}

}
