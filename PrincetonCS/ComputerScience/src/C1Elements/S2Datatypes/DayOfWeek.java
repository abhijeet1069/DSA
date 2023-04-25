package c1elements.s2datatypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DayOfWeek {

	public static void main(String[] args) throws IOException {
		String[] months = new String[] {"", "January", "February","March","April","May","June","July","August","September","October","November","December"};
		String[] days = new String[] {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("DD/MM/YYYY : ");
		String input = br.readLine();
		
		String[] arr = input.strip().split("/");
		int date = Integer.parseInt(arr[0]);
		int month = Integer.parseInt(arr[1]);
		int year = Integer.parseInt(arr[2]);
		
		
		int y0 = year - (14-month)/12;
		int x = y0 + y0/4 - y0/100 + y0/400;
		int m0 = month + 12*((14-month)/12)-2;
		int d0 = (date+x+31*m0/12)%7;
		
		System.out.println(days[d0]);
	}

}
