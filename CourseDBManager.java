/**
 * CourseDBManager class allows data to be added from a file or enter data by hand
 * @author Paul Dacey
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface 
{
	private CourseDBStructure CDS = new CourseDBStructure(15);//Create and initialize CourseDBStructure object with size of 15

	/**
	 * Adds a CourseDBElement object with given values to CourseDBStructure
	 * @param id Course name to add
	 * @param crn Course crn to add
	 * @param credits Number of credits of course
	 * @param room Room number of course
	 * @param instructor Name of instructor for course 
	 */
	@Override
	public void add(String id, int crn, int credits, String room, String instructor) 
	{
		CourseDBElement temp = new CourseDBElement(id, crn, credits, room, instructor);
		CDS.add(temp);
	}

	/**
	 * Retrieves the CourseDBElement with the given crn
	 * @param crn Course CRN number to find
	 * @return CourseDBElement from CourseDBStructure get(crn) method containing the given crn
	 */
	@Override
	public CourseDBElement get(int crn)
	{
		try 
		{
			return CDS.get(crn);
		} 
		catch (IOException e) 
		{
			return null;
		}
		
	}
	
	/**
	 * ReadFile method scans a given file and adds the data using this classes add method
	 * @param input File to retrieve data from
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException 
	{
		try {
			Scanner scanner = new Scanner(input);
			while(scanner.hasNext()) 
			{
				String id = scanner.next();
				int crn = scanner.nextInt();
				int credits = scanner.nextInt();
				String room = scanner.next();
				String instructor =scanner.nextLine();
				instructor = instructor.replaceFirst("\\s", "");
				add(id, crn, credits, room, instructor);
			}
			scanner.close();
		}
		catch(FileNotFoundException e) 
		{
			throw new FileNotFoundException();
		}
	}
	
	/**
	 * showAll method calls showAll method from CourseDBStructure object
	 * @return ArrayList of type String by calling showAll() method from CourseDBStructure
	 */
	@Override
	public ArrayList<String> showAll() 
	{
		return CDS.showAll();
	}

}