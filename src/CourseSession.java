
public class CourseSession {
	private String department,number;
	private int numberOfStudents = 0;
	public CourseSession(String department, String number) {
		this.department = department;
		this.number = number;
	}
	public String getDepartment() {
		return department;
	}
	public String getNumber() {
		return number;
	}
	public int getNumberofStudents() {
		return numberOfStudents;
	}
	public void enroll(Student stu) {
		numberOfStudents++;
	}
}
