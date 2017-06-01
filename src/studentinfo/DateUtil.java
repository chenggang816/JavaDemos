package studentinfo;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	Date createDate(int year, int month, int date){
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, date);
		return calendar.getTime();
	}
}
