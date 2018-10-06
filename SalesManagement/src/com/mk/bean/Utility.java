package com.mk.bean;

import java.lang.reflect.Field;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class Utility {
	
	private static Date stringDate;

	/**
	 * @author 
	 *	This method is used to convert StringDate into java.util.date
	 */
	
	public static Date stringToDate(String strDate){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");       /*This stringDate is come from UI*/
		
		boolean checkStrDateFormat  =	Validation.isValidDateFormat(strDate);
		if(strDate != null && !strDate.trim().isEmpty() && checkStrDateFormat == true){
			try {
				stringDate = sdf.parse(strDate);
				System.out.println(strDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return stringDate;
	}

	/**
	 * @author 
	 *	This method is used to convert java.util.date to java.sql.date
	 */
	
	public static Date fromUtiltoSql(Date date){
		java.sql.Date sqlDate = null;
		if (date != null) {
			sqlDate = new java.sql.Date(date.getTime());
		}
		 return sqlDate;
	}
	
	/**
	 * @author 
	 *	This method is used to convert stringDate to java.sql.date
	 */
	public static Date toSqlDate(String strDate){	
		stringDate = stringToDate(strDate);
		return fromUtiltoSql(stringDate); 
	}

	/**
	 * @author 
	 *	This method is used to convert StringDate into java.util.date in yyyy-mm-dd format
	 */
	
	public static Date stringToDateyyyyMMdd(String strDate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");       /*This stringDate is come from UI*/
		if(strDate != null && !strDate.trim().isEmpty()){
			try {
				stringDate = sdf.parse(strDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return stringDate;
	}
	
	/**
	 * @author 
	 *	This method is used to convert stringDate to java.sql.date
	 */
	public static Date toSqlDateyyyyMMdd(String strDate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
	    java.sql.Date sqlDate;

	    if(strDate != null && !strDate.trim().isEmpty())
	    {
	        try
	        {
	        	stringDate = (Date) sdf.parse(strDate);
	        }
	        catch(ParseException e)
	        {
	            System.out.println("Please enter a valid date! Format is yyyy-MM-dd");
	        }
	    }
	    sqlDate = new java.sql.Date(stringDate.getTime());
		return sqlDate;
	}
	
	/**
	 * @author 
	 *	This method is used to get the difference between two String days by converting then strDate to java.util.date
	 */
	public static long daysBetween(String start, String end) { 
		Date one = stringToDateyyyyMMdd(start);
		Date two = stringToDateyyyyMMdd(end);
		int difference = (int) ((one.getTime()-two.getTime())/86400000);
		return Math.abs(difference); 
	}


	/**
	 * @author 
	 *	This method is used to add day with given strDate
	 */

    public static Date addDays(String date, int days)
    {
        Calendar cal = Calendar.getInstance();
        Date utilDate = stringToDateyyyyMMdd(date);
        cal.setTime(utilDate);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
		java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
		return sqlDate;
    }
   

	public static List<UUID> toUUID(String[] str){
		List<UUID> uuids = new ArrayList<UUID>();
		if(str != null){
			for(int i = 0;i < str.length; i++){
				if(toUUID(str[i]) != null){
					uuids.add(i,toUUID(str[i]));
				}
			} 
		}
		return uuids;
	}
	
	public static UUID toUUID(String str){
		if(str != null && !str.trim().isEmpty()){
			try {
				return UUID.fromString(str); 
			} catch (Exception e) {
				return null;
			}
		}

		return null;
	}
	
	public static List<Integer> toInteger(String[] str){
		List<Integer> ids = new ArrayList<Integer>();
		if(str != null){
			for(int i = 0; i < str.length; i++){
				if(toInteger(str[i]) != null){
					ids.add(i,toInteger(str[i]));
				}
			} 
		}
		return ids;
	}
	
	public static Integer toInteger(String str){
		if(str != null && !str.trim().isEmpty()){
			try {
				return Integer.parseInt(str); 
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}
	
	public static java.sql.Timestamp getCurrentTimeStamp() {
		// 1) create a java calendar instance
		Calendar calendar = Calendar.getInstance();
	
		// 2) get a java.util.Date from the calendar instance.
		//	 this date will represent the current instant, or "now".
		java.util.Date now = calendar.getTime();
	
		// 3) a java current time (now) instance
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		return currentTimestamp;
	}
	
	public static java.sql.Date getSqlDate(String date) {
		String sDate = date;
		java.util.Date dateUtil = Utility.stringToDate(sDate);
		java.sql.Date dateSql = (java.sql.Date) fromUtiltoSql(dateUtil);
		return dateSql;
	}

/*	public static java.lang.String toText(String text){
		
		String s;
		Text a, b;
		s = "12,23";
		String[] tokens = s.split(",");
		a =  new TextBox(tokens[0]);
		b =  new TextBox(tokens[1]);
		
		Text k = new Text();
		
			
		
		
		return 0;
	}*/
	
	
	/*public static String convertToMoney(double amount, String currency) {
		NumToWords w = new NumToWords();
		String amt = Double.toString(amount);
		String str2 = "";
		String beforeDecimal = " Taka";
		String afterDecimal = " Paisa";
		
		if(currency.equals("BDT")) {
			beforeDecimal = " Taka";
			afterDecimal = " Paisa";
		} else if(currency.equals("USD")) {
			beforeDecimal = " Dollars";
			afterDecimal = " Cents";
		} else if(currency.equals("GBP")) {
			beforeDecimal = " Pounds";
			afterDecimal = " Pence";
		}
		
		int taka = Integer.parseInt(amt.split("\\.")[0]);
		String str1 = w.convert(taka);
		if(!str1.equals("")) {
			str1 += beforeDecimal;
		}
		
		int paisa = Integer.parseInt(amt.split("\\.")[1]);
		if (paisa != 0) {
			str2 += " and";
			str2 = w.convert(paisa);
			str2 += afterDecimal;
		}
		
		String str3 = str1 + str2 + " Only";
		return str3;
	}*/
	
	

	
	/**
	 * @param list
	 * @param keyName
	 * @param valueName
	 * @return
	 */
	public static <K,V> Map<K,V> ListToMap(List list, String keyName, String valueName){
		Map<K,V> result = new HashMap<K,V>();

		for (int i = 0; i < list.size(); i++) {
		Object o = list.get(i);
		Class<?> c = o.getClass();
		Field k;
		Field v;
		try {
			k = c.getDeclaredField(keyName);
			v = c.getDeclaredField(valueName);
			k.setAccessible(true);
			v.setAccessible(true);
			result.put((K)k.get(o),(V)v.get(o));
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}

		
		}
		return result;
		}
	
	public static <T> ArrayList<T> uniquefy(ArrayList<T> myList) {

	    ArrayList <T> uniqueArrayList = new ArrayList<T>();
	    for (int i = 0; i < myList.size(); i++){
	        if (!uniqueArrayList.contains(myList.get(i))){
	            uniqueArrayList.add(myList.get(i));
	        }
	    }

	    return uniqueArrayList;
	}
	
	
	 /*get number of days in a month according to month and year*/
	public static int numberOfDaysInMonth(int month, int year) {
	    Calendar monthStart = new GregorianCalendar(year, month, 0);
	    return monthStart.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
    public static String getRandomUUID(){
    	String uuid = UUID.randomUUID().toString();
    	return uuid;
    }
    
    public static String generateRandomString(){
    	String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
    	SecureRandom rnd = new SecureRandom();
    	StringBuilder str = new StringBuilder( characters.length() );
    	   for( int i = 0; i < characters.length(); i++ ) 
    		   str.append( characters.charAt( rnd.nextInt(characters.length()) ) );
    	return str.toString();
    }
    
    public static String utilDateToStr(Date date){
    	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
    	Date today = Calendar.getInstance().getTime();        
    	String strDate = df.format(today);
    	return strDate;
    }

}
