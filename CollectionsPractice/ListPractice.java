package First;
import java.util.*;

public class ListPractice {
	
	public static void main(String[] args)
	{
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("Red");
		al.add("Green");
		al.add("Orange");
		al.add("White");
		al.add("Black");
		
		Iterator<String> it = al.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		al1.add(1);
		al1.add(2);
		al1.add(3);
		al1.add(4);
		al1.add(5);
		
		al1.add(0,20);
		
		Iterator<Integer> it1 = al1.iterator();
		
		while(it1.hasNext())
		{
			System.out.println(it1.next()*2);
			
		}
		
		al1.remove(2);
		
		System.out.println(al1);
		
		System.out.println(al1.get(0));
		
		al1.set(0, 30);
		
		System.out.println(al1);
		
		System.out.println(al1.contains(5));
		
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		
		al2.add(20);
		al2.add(30);
		al2.add(40);
		
		al2.addAll(al1);
		
		System.out.println(al2);
		
		System.out.println(al2.subList(0, 5));
		
		System.out.println(al1.equals(al2));
		
		ArrayList<Integer> al4 = new ArrayList<Integer>();
		
		al4.addAll(al2);
		
		System.out.println(al4.equals(al2));
		
		
		al4.clear();
		System.out.println(al4);
		
		System.out.println(al4.isEmpty());
		
		System.out.println("Before trimming : "+al2);
		
		al2.trimToSize();
		
		System.out.println("After trimming : " + al2);
		
		al2.get(0);
		
		ArrayList<Integer> al5 = new ArrayList<Integer>();
		
		al5.add(1);
		al5.add(3);
		al5.add(4);
		al5.add(5);
		al5.add(7);
		
		System.out.println(al2.retainAll(al5));
		
		System.out.println(al2);
		
		
		
		
	}

}
