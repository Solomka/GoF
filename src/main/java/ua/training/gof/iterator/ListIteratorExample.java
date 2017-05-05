package ua.training.gof.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIteratorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//FIFO -> QUEUE
		List<String> list = new ArrayList<>();
		list.add("bla");
		list.add("foo");
		list.add("mee");
		
		Iterator<String> iterator = list.iterator();
		System.out.println(iterator.toString());
		
		//while(iterator.hasNext()){			
			String next = iterator.next();
			System.out.println(next);
			iterator.remove();
			System.out.println(list.size());			
		//}

			for(String str: list){
				System.out.println(str);
			}
	}

}
