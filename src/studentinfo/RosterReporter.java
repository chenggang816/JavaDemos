package studentinfo;

public class RosterReporter {

	static final String NEWLINE = System.getProperty("line.separator");
	static final String ROSTER_REPORT_HEADER = 
			"Student" + NEWLINE +
			"-------" + NEWLINE;
	static final String ROSTER_REPORT_FOOTER = 
			NEWLINE + "# studnets = ";
	
	private CourseSession session;

	public RosterReporter(CourseSession session) {
		this.session = session;
	}

	public String getReport() {
StringBuilder sb = new StringBuilder();
		
		sb.append(ROSTER_REPORT_HEADER);
		for(Student student:session.getAllStudents()){
			sb.append(student.getName());
			sb.append(NEWLINE);
		}
		sb.append(ROSTER_REPORT_FOOTER + session.getAllStudents().size() + NEWLINE);
		return sb.toString();
	}

}
