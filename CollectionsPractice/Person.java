package First;

public class Person implements Comparable {
	
	private String name ;
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) throws AgeException {
		
		int parsedAge = Integer.parseInt(age);  // Try parsing the age to an integer

        if (parsedAge < 30) {
            throw new AgeException("Age must be 30 or above. Provided age: " + parsedAge);
        } else {
            this.age = age;  // Set the age if it is valid
        }
		
	}
	
	public Person()
	{
		
	}
	
	public Person(String name, String age) {
		super();
		this.name = name;
		this.age=age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Person)
		{
			Person p = (Person)o;
			
			if(p.name==this.name && this.age==p.age)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public int hashCode()
	{
		return (name+age).hashCode();
	}
	
	@Override
	public int compareTo(Object o)
	{
		if(o instanceof Person)
		{
			Person p = (Person)o;
			
			 int thisAge = Integer.parseInt(this.age);
		     int otherAge = Integer.parseInt(p.age);
			
			if(thisAge<otherAge)
			{
				return -1;
			}
			else if (thisAge>otherAge)
			{
				return 1;
			}
			
		}
		return 0;
	}
	

}
