package day20;

import java.util.*;
/*
 * 2016_11_30
 */
public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int a = Calendar.YEAR;
		//System.out.println(a);
		Calendar now = Calendar.getInstance();
		
		//int year = now.get(now.YEAR);
		//int month = now.get(now.MONTH) + 1;
		
		//System.out.println(year+"��");
		//System.out.println(month+"��");
		
		int pm = now.get(Calendar.HOUR_OF_DAY);
		//int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		
		System.out.println(pm + " ��" + minute + " ��" + second + " ��");
		
	}

}
