/**
 * CourseDBElement class used to create a course
 * @author Paul Dacey
 *
 */





public class CourseDBElement implements Comparable<CourseDBElement>
{
	private String id, roomNum, instructor;//String variables id, roomNum, instructor
	private int crn, credits;//int variables crn, credits
	
	/**
	 * Default constructor to intialize variables
	 */
	CourseDBElement()
	{
		id=null;
		roomNum=null;
		instructor=null;
		crn=-1;
		credits=-1;
				
	}
	
	/**
	 * Parameterized constructor to set variables
	 * @param id Course name  
	 * @param crn Course CRN number
	 * @param credits Course credits
	 * @param roomnum Course room number
	 * @param instructor Instructor of course
	 */
	CourseDBElement(String id, int crn, int credits, String roomnum, String instructor)
	{
		this.id = id;
		this.crn = crn;
		this.credits = credits;
		this.roomNum = roomnum;
		this.instructor = instructor;
	}

	/**
	 * Compares two CourseDBElement objects
	 * @param element CourseDBElement object to compare
	 * @return int 1 if greater than, -1 if less than, 0 if equal to
	 */
	@Override
	public int compareTo(CourseDBElement element) 
	{
		if(this.crn > element.crn)
		{
			return 1;
		}
		if(this.crn < element.crn)
		{
			return -1;
		}
				
		return 0;
	}

	/**
	 * Converts crn into string format
	 * @return String of crn
	 */
	public String stringCRN()
	{
		String str = Integer.toString(getCRN());
		return str;
	}
	
	/**
	 * Generates the hashcode from the string form of crn
	 * @return hashcode of the crn in string form
	 */
	@Override
	public int hashCode()
	{
		String temp = stringCRN();
		int code = temp.hashCode();
		return code;
	}
	
	/**
	 * Retrieves the value of id
	 * @return id Courses name
	 */
	public String getID() {
		return id;
	}

	/**
	 * Sets the id variable
	 * @param id Courses name
	 */
	public void setID(String id) {
		this.id = id;
	}

	/**
	 * Retrieves the room number
	 * @return roomNum Room number of course
	 */
	public String getRoomNum() {
		return roomNum;
	}

	/**
	 * Sets the roomNum variable
	 * @param roomnum Courses room number
	 */
	public void setRoomNum(String roomnum) {
		this.roomNum = roomnum;
	}

	/**
	 * Retrieves the instructors name
	 * @return instructor Name of instructor
	 */
	public String getInstructor() {
		return instructor;
	}

	/**
	 * Sets the name of the instructor
	 * @param instructor Name of the instructor
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	/**
	 * Retrieves the crn of the course
	 * @return crn Courses crn number
	 */
	public int getCRN() {
		return crn;
	}

	/**
	 * Sets the crn for the course
	 * @param crn Courses crn number
	 */
	public void setCRN(int crn) {
		this.crn = crn;
	}

	/**
	 * Retrieves the credits of the course
	 * @return credits Courses credits
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * Sets the courses credits
	 * @param credits Courses credits
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	/**
	 * Converts and returns a string of the course
	 * @return String representation of the course
	 */
	public String toString()
	{
		return "Course:" + id + " CRN:" + crn + " Credits:" + credits + " Instructor:" + instructor + " Room:" + roomNum;
	}
	
	
}
