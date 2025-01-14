package First;

import java.util.TreeSet;

public class ComparatorPractice {
		
	
	public static void main(String[] args)
	{
		
		Person p1 = new Person("Marko","50");
		Person p2 = new Person("John","30");
		Person p3 = new Person("John","30");
		
		System.out.println(p1);
		
		System.out.println(p1.equals(p2));
		
		System.out.println(p1.equals(p3));
		
		System.out.println("-------------");
		
		System.out.println(p1.hashCode());
		
		System.out.println(p2.hashCode());
		
		System.out.println(p3.hashCode());
		
		System.out.println("-------------");
		
		System.out.println(p1.compareTo(p2));
		
		System.out.println("-------------");
		
		PersonComparator pc = new PersonComparator();
		
		TreeSet<Person> ts = new TreeSet<Person>(pc);
		
		ts.add(p1);
		ts.add(p2);
		ts.add(p3);
		
		System.out.println(ts);
		
		
		System.out.println("-------------");
		
		Person p4 = new Person();

		try
		{
			p4.setAge("25");
		}
		catch(AgeException ae)
		{
			System.out.println(ae.getMessage());
			ae.printStackTrace();
		}
		
		
	}
	
	
}
