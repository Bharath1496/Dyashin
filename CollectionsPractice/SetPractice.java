package First;

import java.util.*;

public class SetPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		System.out.println("---------");
		
		HashSet<Integer> hs = new HashSet<Integer>();
		
		hs.add(1);
		hs.add(2);
		hs.add(3);
		
		System.out.println(hs);
		
		System.out.println("---------");
		
		Iterator<Integer> it = hs.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		System.out.println("-----------");
		
		System.out.println(hs.size());
		
		System.out.println("-------");
		
		hs.clear();
		
		System.out.println(hs);
		
		System.out.println("---------");
		
		System.out.println(hs.isEmpty());
		
		System.out.println("------------");
		
		HashSet<Integer> hs1 = new HashSet<Integer>();
		
		hs1.add(1);
		hs1.add(2);
		hs1.add(3);
		hs1.add(4);
		
		hs.addAll(hs1);
		
		System.out.println(hs);
		
		System.out.println("------------");
		
		Integer[] arr = new Integer[hs.size()];
		
		arr = hs.toArray(arr);
		
		for(int i =0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		
		System.out.println("-------------");
		
		
		TreeSet<Integer> ts = new TreeSet();
		
		ts.addAll(hs);
		
		System.out.println(ts);
		
		System.out.println("---------");
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		al.addAll(hs);
		
		System.out.println(al);

		System.out.println("--------");
		
		System.out.println(hs.equals(hs1));
		
		System.out.println("----------");
		
		hs.add(7);
		hs.add(8);
		
		System.out.println("Before reataininig : ");
		
		System.out.println("First set : " + hs);
		
		System.out.println("Second set : " + hs1);
		
		hs.retainAll(hs1);
		
		System.out.println("First set : " + hs);
		
		System.out.println("Second set : " + hs1);
		
		System.out.println("----------");
		
		hs1.clear();
		
		System.out.println(hs1);
		
		System.out.println("---------");
		
		
		System.out.println("Treeset exercises");
		
		System.out.println("------");
		
		TreeSet<String> ts1 = new TreeSet<String>();
		
		ts1.add("red");
		ts1.add("blue");
		ts1.add("green");
		
		System.out.println(ts1);
		
		System.out.println("------");
		
		Iterator<String> it1 = ts1.iterator();
		
		while(it1.hasNext())
		{
			System.out.println( it1.next());
		}
		
		System.out.println("--------");
		
		TreeSet<String> ts2 = new TreeSet<String>();
		
		ts2.addAll(ts1);
		
		System.out.println(ts2);
		
		System.out.println("---------");
		
		System.out.println(ts1.descendingSet());
		
		System.out.println("---------");
		
		System.out.println(ts1.first());
		
		System.out.println(ts1.last());
		
		System.out.println("----------");
		
		TreeSet<String> ts3 = new TreeSet<String>();
		
		ts3.addAll(ts2);
		
		System.out.println(ts3);
		
		System.out.println("------------");
		
		System.out.println(ts3.size());
		
		System.out.println("----------");
		
		System.out.println(ts3.equals(ts2));
		
		System.out.println("-----------");
		
		TreeSet<Integer> ts4 = new TreeSet<Integer>();
		
		ts4.add(1);
		ts4.add(2);
		ts4.add(3);
		
		TreeSet<Integer> ts5 = (TreeSet<Integer>) ts4.headSet(7);
				
		System.out.println(ts5);
		
		System.out.println("---------");
		
		
		
		
	}

}
