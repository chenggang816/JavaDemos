package studentinfo;

import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.TestCase;


public class CourseSessionTest extends TestCase{
	private CourseSession session;
	private Date startDate;
	public void setUp(){
		startDate = createDate(2003, 1, 6);
		session = new CourseSession("ENGL", "101",startDate);
	}
	
	public void testCreate(){
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberofStudents());
		assertEquals(startDate, session.getStartDate());
	}
	
	public void testEnrollStudents(){
		Student stu1 = new Student("Jane");
		session.enroll(stu1);
		assertEquals(1, session.getNumberofStudents());
		
		Student stu2 = new Student("Cain Divoe");
		session.enroll(stu2);
		assertEquals(2, session.getNumberofStudents());
	}
	
	public void testCourseDates(){
		assertEquals(createDate(2003, 4, 25), session.getEndDate());
	}
	
	public void testRosterReport(){
		session.enroll(new Student("A"));
		session.enroll(new Student("B"));
		
		String rosterReport = session.getRosterReport();
		assertEquals(CourseSession.ROSTER_REPORT_HEADER +
				"A" + CourseSession.NEWLINE +
				"B" + CourseSession.NEWLINE + 
				CourseSession.ROSTER_REPORT_FOOTER + "2\r\n", rosterReport);
	}
	
	Date createDate(int year, int month, int date){
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, date);
		return calendar.getTime();
	}
}
