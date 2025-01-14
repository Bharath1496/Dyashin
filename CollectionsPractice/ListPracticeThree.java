package First;

import java.util.*;

public class ListPracticeThree {
	
	public static void main(String[] args)
	{
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		
		System.out.println(l1);
		
		Iterator<Integer> il = l1.iterator();
		
		while(il.hasNext())
		{
			System.out.println(il.next());
		}
		
		System.out.println("----------");
		
		
		for(int i = 2;i<l1.size();i++)
		{
			System.out.println(l1.get(i));
		}
		
		System.out.println("------------");
		
		for(int i = l1.size()-1;i >= 0;i--)
		{
			System.out.println(l1.get(i));
		}
		
		System.out.println("------------");
		
		l1.add(1,200);
		
		System.out.println(l1);
		
		System.out.println("------------");
		
		l1.set(1, 300);
		
		System.out.println(l1);
		
		System.out.println("----------");
		
		l1.add(1,400);
		
		System.out.println(l1);
		
		System.out.println("-----------");
		
		l1.add(2,800);
		l1.add(3,600);
		l1.add(4,500);
		
		System.out.println(l1);
		
		System.out.println("-----------");
		
		System.out.println(l1.getFirst());
		System.out.println(l1.getLast());
		
		System.out.println("------------");
		
		for(int i =0 ; i < l1.size();i++)
		{
			System.out.println("Element at position : " + i + " is : " + l1.get(i));
		}
		
		System.out.println("--------------");
		
		l1.remove(7);
		
		System.out.println(l1);
		
		System.out.println("---------");
		
		l1.removeFirst();
		l1.removeLast();
		
		System.out.println(l1);
		
		System.out.println("----------");
		
		l1.clear();
		
		System.out.println(l1);
		
		System.out.println("---------");
		
		
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		
		System.out.println("Before swapping : " + l1);
		
		int j = l1.get(1);
		int k = l1.get(2);
		
		l1.set(2, j);
		l1.set(1, k);
		
		System.out.println(l1);
		
		System.out.println("-----------");
		
		LinkedList<Integer> l3 = new LinkedList<Integer>();
		
		l3.add(30);
		l3.add(40);
		l3.add(50);
		
		System.out.println("Adding list : " + l3 + " Into the list : " + l1);
		
		l1.addAll(l3);
		
		System.out.println("After adding :" + l1);
		
		System.out.println("-------");
		
		System.out.println(l1.removeFirst());
		
		System.out.println("----------");
		
		System.out.println(l1.get(0));
		
		System.out.println("----------");
		
		System.out.println(l1.get(l1.size()-1));
		
		System.out.println("----------");
		
		System.out.println(l1.contains(30));
		
		System.out.println("-------");
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		al.addAll(l1);
		
		System.out.println(al);
		
		System.out.println("----------");
		
		System.out.println("Is the linkedlist empty : " + l1.isEmpty());
		
		System.out.println("---------");
		
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		
		l2.add(6);
		l2.add(7);
		l2.add(8);
		l2.add(9);
		
		System.out.println(l1.equals(l2));
		
		System.out.println("---------");
		
		System.out.println("Before replacing : " + l2);
		
		l2.set(0,100);
		
		System.out.println(l2);
		
		System.out.println("---------");
		
		
		
		
		
		
	}
	

}
