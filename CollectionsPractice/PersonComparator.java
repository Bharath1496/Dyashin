package First;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
	   
        
	@Override
	public int compare(Person p1 , Person p2)
	{
//		if(o1 instanceof Person && o2 instanceof Person)
//		{
//			Person p1 = (Person)o1;
//			Person p2 = (Person)o2;
			
			 // Compare by age (manual comparison)
            int age1 = Integer.parseInt(p1.getAge());
            int age2 = Integer.parseInt(p2.getAge());
            
            if(age1 < age2)
            {
            	return -1;
            }
            else  if (age1 > age2)
            {
            	return 1;
            }
            

//		}
		
			
		
        return p1.getName().compareTo(p2.getName());
	}
}
