public class StudentTest extends junit.framework.TestCase {
	public void testCreate(){
		Student stu = new Student("Jane");
		assertEquals("Jane",stu.getName());
		
		assertEquals("Joe Blow",new Student("Joe Blow").getName());
	}
}
