package studentinfo;

import java.util.*;

public class CourseSession {
	static final String NEWLINE = System.getProperty("line.separator");
	static final String ROSTER_REPORT_HEADER = 
			"Student" + NEWLINE +
			"-------" + NEWLINE;
	static final String ROSTER_REPORT_FOOTER = 
			NEWLINE + "# studnets = ";
	
	private String department,number;
	private ArrayList<Student> students = new ArrayList<Student>();
	private Date startDate;
	
	public CourseSession(String department, String number, Date startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}
	public String getDepartment() {
		return department;
	}
	public String getNumber() {
		return number;
	}
	public int getNumberofStudents() {
		return students.size();
	}
	public void enroll(Student stu) {
		students.add(stu);
	}
	public Student get(int index){
		return students.get(index);
	}
	Date getEndDate(){
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		final int sessionLength = 16;
		final int daysInWeek = 7;
		final int daysFromFridayToMonday = 3;
		int numberOfDays = sessionLength * daysInWeek - daysFromFridayToMonday;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		return calendar.getTime();
	}
	public Date getStartDate() {
		return startDate;
	}
	public String getRosterReport() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(ROSTER_REPORT_HEADER);
		for(Student student:students){
			sb.append(student.getName());
			sb.append(NEWLINE);
		}
		sb.append(ROSTER_REPORT_FOOTER + students.size() + NEWLINE);
		return sb.toString();
	}
	public ArrayList<Student> getAllStudents() {
		return students;
	}
}
