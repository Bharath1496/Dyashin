package First;


import java.util.*;

public class ListPracticeTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   
		      System.out.println("Hello, World!");
		      
		      System.out.println("-------------------");
		      
		      ArrayList <String> al2 = new ArrayList<String>();
		      al2.add("hello");
		      al2.add("hi");
		      
		      ArrayList<String> al3 = new ArrayList<String>();
		      al3.addAll(al2);
		      
		      System.out.println(al3.containsAll(al2));
		      
		      System.out.println(al3.remove("hi"));
		      
		      Iterator<String> it1 = al3.iterator();
		      
		      while(it1.hasNext())
		      {
		        System.out.println(it1.next());
		        
		      }
		      
		       al2.add("rambo");
		       
		       al2.clear();
		       
		       Iterator<String> it3= al3.iterator();
		      
		      while(it3.hasNext())
		      {
		        System.out.println(it3.next());
		        
		      }
		      
		      
		      System.out.println("-------------------");
		      
		      String[] s1 = al2.toArray(new String[0]);
		      
		      for(int i =0;i<s1.length;i++)
		      {
		        System.out.println(s1[i]);
		      }
		      
		      System.out.println("-------------------");
		      ArrayList <Integer> al = new ArrayList<Integer>();
		      
		      al.add(1);
		      
		      Iterator<Integer> it = al.iterator();
		      
		      while(it.hasNext())
		      {
		        System.out.println(it.next());
		        it.remove();
		      }
		      
		      System.out.println("-------------------");
		      
		      Iterator <String> it2 = al2.iterator();
		      
		      while(it2.hasNext())
		      {
		        System.out.println(it2.next());
		        
		      }
		      
		      System.out.println("-------------------");
		      
		      List<Integer> li = new ArrayList<Integer>();
		      li.add(1);
		      li.add(2);
		      li.add(3);
		      
		      li.add(3,45);
		      
		      // li.add(7,45); // IOOB
		      
		      System.out.println(li);
		      
		      Set<Integer> s = new HashSet<Integer>();
		      s.add(1);
		      s.add(2);
		      s.add(2);
		      s.add(55);
		      s.add(55);
		      
		      System.out.println(s);
		      
		      
		      
		      
		  }
		
	}


