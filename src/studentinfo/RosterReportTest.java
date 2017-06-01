package studentinfo;

import junit.framework.TestCase;

import java.util.*;

public class RosterReportTest extends TestCase{
	public void testRosterReport(){
		CourseSession session = new CourseSession("ENGL", "101",createDate(2003, 1, 6));
		session.enroll(new Student("A"));
		session.enroll(new Student("B"));
		
		String rosterReport = new RosterReporter(session).getReport();
		assertEquals(CourseSession.ROSTER_REPORT_HEADER +
				"A" + RosterReporter.NEWLINE +
				"B" + RosterReporter.NEWLINE + 
				RosterReporter.ROSTER_REPORT_FOOTER + "2\r\n", rosterReport);
	}
	Date createDate(int year, int month, int date){
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, date);
		return calendar.getTime();
	}
}
