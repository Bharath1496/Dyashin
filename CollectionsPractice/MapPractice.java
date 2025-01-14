package First;

import java.util.*;

public class MapPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer , String> hs = new HashMap<Integer , String>();
		
		hs.put(1,"one");
		hs.put(2, "two");
		hs.put(3, "three");
		hs.put(4, "four");
		
		System.out.println(hs);
		
		System.out.println( hs.size() );
			
		HashMap<Integer , String> hs1 = new HashMap<Integer , String>();
		
		hs1.putAll(hs);
		
		System.out.println(hs1);
		
		hs1.clear();
		
		System.out.println(hs1);
		
		System.out.println(hs1.containsKey(1));
		
		hs1.put(5, "five");
		hs1.put(6, "six");
		
		System.out.println(hs1.containsValue("six"));
		
		Set<Integer> hs5 = hs1.keySet();
		
		System.out.println(hs5);
		
		Collection<String> col = hs1.values();
		
		System.out.println(col);
		
		System.out.println("--------------TreeMap-----------");
		
		TreeMap<Integer , String> tm = new TreeMap<Integer,String>();
		
		tm.put(1,"one");
		tm.put(2,"two");
		tm.put(3,"three");
		tm.put(4,"four");
		tm.put(5,"five");
		tm.put(5,"five");
		
		
		TreeMap<Integer , String> tm2 = new TreeMap<Integer , String>();
		tm2.putAll(tm);
		
		System.out.println(tm2);
		
		System.out.println(tm2.containsKey(6));
		
		System.out.println(tm2.containsValue("five"));
		
		Set<Integer> k = tm2.keySet();
		
		System.out.println(k);
		
		Collection<String> col1 = tm2.values();
		
		System.out.println(col1);
		
		tm2.clear();
		
		
	}

}
