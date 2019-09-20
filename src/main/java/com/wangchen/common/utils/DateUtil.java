package com.wangchen.common.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DateUtil {
	
	/**
	* 获取两个日期相差的年数
	* @param d1  较大的日期
	* @param d2  较小的日期
	* @return 如果d1>d2返回 月数差 否则返回0
	*/
	public static int getYearDiff(Date d1, Date d2) {
	    Calendar c1 = Calendar.getInstance();
	    Calendar c2 = Calendar.getInstance();
	    c1.setTime(d1);
	    c2.setTime(d2);
	    if(c1.getTimeInMillis() < c2.getTimeInMillis()) return 0;
	    int year1 = c1.get(Calendar.YEAR);
	    int year2 = c2.get(Calendar.YEAR);
	    int month1 = c1.get(Calendar.MONTH);
	    int month2 = c2.get(Calendar.MONTH);
	    if(month2>month1)return year1-year2-1;
	    return year1-year2;
	}
	
	
	
	/**
	* 获取两个日期相差的月数
	* @param d1  较大的日期
	* @param d2  较小的日期
	* @return 如果d1>d2返回 月数差 否则返回0
	*/
	public static int getMonthDiff(Date d1, Date d2) {
	    Calendar c1 = Calendar.getInstance();
	    Calendar c2 = Calendar.getInstance();
	    c1.setTime(d1);
	    c2.setTime(d2);
	    if(c1.getTimeInMillis() < c2.getTimeInMillis()) return 0;
	    int year1 = c1.get(Calendar.YEAR);
	    int year2 = c2.get(Calendar.YEAR);
	    int month1 = c1.get(Calendar.MONTH);
	    int month2 = c2.get(Calendar.MONTH);
	    int day1 = c1.get(Calendar.DAY_OF_MONTH);
	    int day2 = c2.get(Calendar.DAY_OF_MONTH);
	    // 获取年的差值 假设 d1 = 2015-8-16 d2 = 2011-9-30
	    int yearInterval = year1 - year2;
	    // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
	    if(month1 < month2 || month1 == month2 && day1 < day2) yearInterval --;
	    // 获取月数差值
	    int monthInterval = (month1 + 12) - month2 ;
	    if(day1 < day2) monthInterval --;
	    monthInterval %= 12;
	    return yearInterval * 12 + monthInterval;
	}
	
	
	/** 
	 * @Title: getAge 
	 * @Description:获取指定日期的生日
	 * @param birthDay
	 * @return
	 * @throws Exception
	 * @return: int
	 */
	public static int getAge(Date birthDay) throws Exception {
		Calendar cal = Calendar.getInstance();
		if (cal.before(birthDay)) { // 出生日期晚于当前时间，无法计算
			throw new IllegalArgumentException("日期必须小于当前日期");
		}
		int yearNow = cal.get(Calendar.YEAR); // 当前年份
		int monthNow = cal.get(Calendar.MONTH); // 当前月份
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); // 当前日期
		cal.setTime(birthDay);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH);
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
		int age = yearNow - yearBirth; // 计算整岁数
		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				if (dayOfMonthNow < dayOfMonthBirth)
					age--;// 当前日期在生日之前，年龄减一
			} else {
				age--;// 当前月份在生日之前，年龄减一

			}
		}
		return age;
	}
	
	/*
	 * 返回月末 方法2：(5分) 给一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
	 * 例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59
	 * 例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
	 */
	public static Date getDateByFullMonth(Date src) {
		// 用传入的日期,初始化日历类. 然后让当前日期设置为下个月的月初,最后在
		// 月初减去 1秒. 就能变成传入日期的月末了
		
		Calendar c = Calendar.getInstance();
		c.setTime(src);
		// 让当前月份加1
		c.add(Calendar.MONTH, 1);
		// 获取月初
		Date monthStart = getDateByInitMonth(c.getTime());
		// 用月初初始化日历类
		c.setTime(monthStart);
		// 用月初时间 -1 秒
		c.add(Calendar.SECOND, -1);
		
		return c.getTime();

	}

	/*
	 * 返回月初 方法1：(5分) 给一个时间对象，返回该时间所在月的1日0时0分0秒。例如一个Date对象的值是2019-05-18 11:37:22
	 * 则返回的结果为2019-05-01 00:00:00
	 * 
	 */
	public static Date getDateByInitMonth(Date src) {
		
		// 获取Calendar对象
		Calendar c = Calendar.getInstance();
		// 用传入的时间初始化日历对象
		c.setTime(src);
		
		// 改变日期的 日,时,分.秒
		
		c.set(Calendar.DATE, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		return c.getTime();
		
	}

	/**
	 * 
	 * @Title: randomDate
	 * @Description: 返回在某个日期区间的随机日期
	 * @param startDate
	 * @return
	 * @return: Date
	 */
	public static Date randomDate(Date startDate) {
		// 用当前时间获取日历类
		Calendar c = Calendar.getInstance();
		// 当前时间的毫秒值.. 即从1970到现在的毫米数
		long endMillis = c.getTimeInMillis();
		// System.out.println("endMillis="+endMillis);
		
		// 用传入的日期初始化日历类Calendar
		
		c.setTime(startDate);
		// 获取开始时间的毫米数
		long startMillis = c.getTimeInMillis();
		// System.out.println("startMillis="+startMillis);
		
		long x = (long) (Math.random() * (endMillis - startMillis + 1)) + startMillis;
		// System.out.println("x="+x);
		
		// 用时间差创建日历类
		c.setTimeInMillis(x);
		
		return c.getTime();
	}

	/**
	 * 
	 * @Title: Sequence 
	 * @Description: 有顺序的时间增长
	 * @param date
	 * @param ms
	 * @return
	 * @return: Date
	 */
	public static Date Sequence(Date date,Long ms)
	{
		long time = date.getTime();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time+ms);
		return calendar.getTime();
	}
	
}
