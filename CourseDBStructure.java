/**
 * CourseDBStructure class to store CourseDBElement objects by utilizing a hash table 
 * @author Paul Dacey
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface
{
	private double load = 1.5;//Load factor 
	private int tableLen;//Holds size of hash table
	private String test;//Used for testing
	//Hashtable<Integer, CourseDBElement> hashTable = new Hashtable<Integer, CourseDBElement>();
	LinkedList<CourseDBElement>[] hashTable;//LinkedList of type CourseDBElement to be used as a hash table
	
	/**
	 * Constructor to set size of hash table by using the given numbers second next prime number
	 * @param n Size to set the hash table to
	 */
	public CourseDBStructure(int n)
	{
		int temp = (int) (n/load);
		int temp2 = prime(temp);
		int temp3 = prime(temp2);
		tableLen = temp3;
		hashTable = new LinkedList[tableLen];
	}
	
	/**
	 * Constructor for testing purposes
	 * @param test 
	 * @param num Used to set size of table
	 */
	public CourseDBStructure(String test, int num)
	{
		tableLen = num;
		this.test = test;
		hashTable = new LinkedList[tableLen];
	}
	
	/**
	 * Method to find next prime number
	 * @param num Number to find next prime number of
	 * @return int representing next prime number
	 */
	public int prime(int num){
		  int count;
		  int temp;
		  num++;
		  
		  while(true)
		  {
			count = 0;
		    temp = (int) Math.sqrt(num);
		    
		    
		    for(int i = 2; i <= temp; i ++)
		    {
		      if(num % i == 0)
		    	  {
		    	  	count++;
		    	  }
		    }
		    
		    if(count == 0)
		    {
		      return num;
		    }
		    else
		    {
		      num++;
		      continue;
		    }
		  }
		}

	
	
	/**
	 * Adds a CourseDBElement object to the hash table
	 * @param element CourseDBElement object to add to the hash table
	 */
	@Override
	public void add(CourseDBElement element) 
	{
		
		
		int index = element.hashCode() % tableLen;
		int hash = element.hashCode();
		int count = 0;
		
		
		if(hashTable[index] == null)
		{
			hashTable[index] = new LinkedList<CourseDBElement>();
		}
		LinkedList<CourseDBElement> test = hashTable[index];
		CourseDBElement updated = null;
		
		
		for(int i = 0; i < tableLen; i++)
		{
			if(hashTable[i] != null)
			{
				LinkedList<CourseDBElement> row = hashTable[i];
				for(int k = 0; k < row.size(); k++)
				{
					if(row.get(k).getCRN() == element.getCRN() && row.get(k).getID() != element.getID())
					{
						test.get(k).setID(element.getID());
						
					}
					if(row.get(k).getCRN() == element.getCRN())
					{
						
						count++;
					}
					
				}
			}
			
			
			
		}
		
		
		
		if(test.contains(element.getCRN()) == false && count == 0)
		{
			test.add(element);
		}
		
	}

	/**
	 * Retrieves the CourseDBElement object from the hash table containing the given crn
	 * @param crn CRN number to find
	 * @return CourseDBElement object containing the crn
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException 
	{
		String temp = crn + "";
		
		int index = temp.hashCode() % tableLen;
		
		if(hashTable[index] == null)
		{
			throw new IOException("This CRN does not exist in the database!");
		}
		else
		{
			for(int i = 0; i < hashTable[index].size(); i++)
			{
				CourseDBElement CDE = hashTable[index].get(i);
				if(CDE.getCRN() == crn)
				{
					return CDE;
				}
				
			}
		}
		
		throw new IOException("This CRN does not exist in the database!");
	}

	/**
	 * Converts all elements in the hash table to an ArrayList<String> object
	 * @return ArrayList<String> object containing all elements in hash table
	 */
	@Override
	public ArrayList<String> showAll() 
	{
		ArrayList<String> temp = new ArrayList<String>(tableLen);
		
		for(int i = 0; i < tableLen; i++)
		{
			if(hashTable[i] != null)
			{
				LinkedList<CourseDBElement> row = hashTable[i];
				for(int k = 0; k < row.size(); k++)
				{
					
					temp.add("\n" + row.get(k).toString());
				}
			}
			
			
			
		}
		return temp;
	}

	/**
	 * Retrieves the size of the hash table
	 * @return tableLen containing the size of the table
	 */
	@Override
	public int getTableSize() 
	{
		
		return tableLen;
	}
	
	
	
	
	
	
	
	
	
	
}
