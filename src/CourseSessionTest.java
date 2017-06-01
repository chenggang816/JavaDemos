import junit.framework.TestCase;


public class CourseSessionTest extends TestCase{
	public void testCreate(){
		CourseSession session = new CourseSession("ENGL", "101");
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberofStudents());
	}
	
	public void testEnrollStudents(){
		CourseSession session = new CourseSession("ENGL", "101");
		
		Student stu1 = new Student("Jane");
		session.enroll(stu1);
		assertEquals(1, session.getNumberofStudents());
		
		Student stu2 = new Student("Cain Divoe");
		session.enroll(stu2);
		assertEquals(2, session.getNumberofStudents());
	}
}
