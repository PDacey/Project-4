/**
 * Test class to test the methods of CourseDBManager
 * @author Paul Dacey
 *
 */
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManager_STUDENT_Test 
{
	private CourseDBManager test;//CourseDBManager object used for testing
	private ArrayList<String> show = new ArrayList<String>();//ArrayList object used to verify contents and test showAll() method
	
	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		test = new CourseDBManager();
	}

	/**
	 * Set test to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception 
	{
		test = null;
	}

	/**
	 * Tests the add method
	 */
	@Test
	public void testAdd()
	{
		try 
		{
			test.add("CMSC204", 1234, 4, "DL", "Gary Thai");
			test.add("Art101", 1111, 2, "ART201", "Ms.Art");
			show = test.showAll();
			assertEquals("\nCourse:CMSC204 CRN:1234 Credits:4 Instructor:Gary Thai Room:DL", show.get(1));
			assertEquals("\nCourse:Art101 CRN:1111 Credits:2 Instructor:Ms.Art Room:ART201", show.get(0));
			
		}
		catch(Exception e)
		{
			fail("Should not have thrown exception");
		}
		
	}
	
	/**
	 * Tests the read method
	 */
	@Test
	public void testRead()
	{
		try
		{
			File file = new File("Test.txt");
			PrintWriter pwriter = new PrintWriter(file);
			pwriter.println("CMSC204 1234 4 DistanceLearning Gary Thai");
			pwriter.println("Art101 1111 2 ART201 Ms.Art");
			pwriter.close();
			
			test.readFile(file);
			assertEquals("CMSC204", test.get(1234).getID());
			assertEquals("Gary Thai", test.get(1234).getInstructor());
			assertEquals("ART201", test.get(1111).getRoomNum());
			assertEquals(2, test.get(1111).getCredits());
			
		}
		catch(Exception e)
		{
			fail("Should not have thrown exception");
		}
	}
	
	/**
	 * Tests the showAll method
	 */
	@Test
	public void testShowAll()
	{
		try
		{
			test.add("CMSC204", 1234, 4, "DL", "Gary Thai");
			test.add("ART101", 1111, 2, "ART201", "Ms.Art");
			test.add("CMSC203", 1235, 3, "DL", "John Doe");
			test.add("CMSC290", 2222, 1, "HUM303", "M.Shah");
			show = test.showAll();
			
			assertEquals("\nCourse:CMSC204 CRN:1234 Credits:4 Instructor:Gary Thai Room:DL", show.get(3));
			assertEquals("\nCourse:ART101 CRN:1111 Credits:2 Instructor:Ms.Art Room:ART201", show.get(0));
			assertEquals("\nCourse:CMSC203 CRN:1235 Credits:3 Instructor:John Doe Room:DL", show.get(1));
			assertEquals("\nCourse:CMSC290 CRN:2222 Credits:1 Instructor:M.Shah Room:HUM303", show.get(2));
		}
		catch(Exception e)
		{
			fail("Should not have thrown exception");
		}
	}
	
	/**
	 * Tests the get method
	 */
	@Test
	public void testGet()
	{
		try
		{
			test.add("CMSC204", 1234, 4, "DL", "Gary Thai");
			test.add("Art101", 1111, 2, "ART201", "Ms.Art");
			test.add("CMSC203", 1235, 3, "DL", "John Doe");
			test.add("CMSC290", 2222, 1, "HUM303", "M.Shah");
			CourseDBElement temp = new CourseDBElement();
			temp = test.get(1235);
			assertEquals(temp.getID(), "CMSC203");
			assertEquals(temp.getInstructor(), "John Doe");
			assertEquals(temp.getRoomNum(), "DL");
			assertEquals(temp.getCredits(), 3);
		}
		catch(Exception e)
		{
			fail("Should not have thrown exception");
		}
	}
	
}
