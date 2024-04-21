package com.dm.springbootjpapostgresql.example.timePkg;

/*java.time.format.DateTimeFormatter class

java.time.LocalDate class
java.time.LocalTime class
java.time.LocalDateTime class
java.time.Clock class

java.text.SimpleDateFormat class

java.util.Date class
java.sql.Date class
java.util.Calendar class*/

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate; 
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;

import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.text.SimpleDateFormat;

public class time1 {

	public static void main(String[] args) {
		
		System.out.println("-------LocalDate--------");
		
		System.out.println(java.time.LocalDate.now());  
		
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		LocalDate.of(2015, 02, 20);
		LocalDate.parse("2015-02-20");
		System.out.println(LocalDate.parse("2015-12-20"));
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		System.out.println(tomorrow);
		LocalDate minusDays10 = LocalDate.now().minusDays(10);
		System.out.println("minusDays10:"+minusDays10);		
		System.out.println("minusMonths2:"+LocalDate.now().minusMonths(2));
		System.out.println("plusMonths2:"+LocalDate.now().plusMonths(2));
		System.out.println("plusWeeks5:"+LocalDate.now().plusWeeks(5));
		System.out.println("plusYears1:"+LocalDate.now().plusYears(1));
		LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);
		System.out.println(previousMonthSameDay);
		
		DayOfWeek dayOfWeek = LocalDate.parse("2020-09-12").getDayOfWeek();
		System.out.println(dayOfWeek);
		int twelve = LocalDate.parse("2020-09-12").getDayOfMonth();
		System.out.println(twelve);
		
		boolean leapYear = LocalDate.now().isLeapYear();
		System.out.println(leapYear);
		
		boolean notBefore = LocalDate.parse("2016-06-12")
				  .isBefore(LocalDate.parse("2016-06-11"));
		System.out.println(notBefore);
		
		boolean isAfter = LocalDate.parse("2016-06-12")
				  .isAfter(LocalDate.parse("2016-06-11"));		
		System.out.println(isAfter);
		
		
		LocalDateTime beginningOfDay = LocalDate.parse("2016-06-12").atStartOfDay();
		System.out.println("beginningOfDay:"+beginningOfDay);
		
		LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12").with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("firstDayOfMonth:"+firstDayOfMonth);
		

	    LocalDate localDate2017 = LocalDate.of(2017, 1, 13);  
	    LocalDateTime localDateTime20171509 = localDate2017.atTime(1,50,9);      
	    System.out.println("localDateTime20171509:"+localDateTime20171509);
	    
		System.out.println("-------LocalTime--------");
		
		
		System.out.println(java.time.LocalTime.now());  
		LocalTime localTime = LocalTime.now();
		System.out.println("localTime:"+localTime);
		LocalTime sixThirty = LocalTime.parse("06:30");
		System.out.println("sixThirty:"+sixThirty);
		LocalTime sixThirty2 = LocalTime.of(6, 30);
		System.out.println("sixThirty2:"+sixThirty2);
		System.out.println(LocalTime.of(1, 10, 10, 100));
		
		
		LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);
		System.out.println("sevenThirty:"+sevenThirty);
		System.out.println("nowPlus1:"+LocalTime.now().plus(1,ChronoUnit.HOURS));
		System.out.println("plusMinutes10:"+LocalTime.now().plusMinutes(10));
		System.out.println("plusHours10:"+LocalTime.now().plusHours(10));
		System.out.println("minusMinutes10:"+LocalTime.now().minusMinutes(10));
		System.out.println("minusHours2:"+LocalTime.now().minusHours(2));
		
		
		int six = LocalTime.parse("06:30").getHour();
		System.out.println("six:"+six);
		boolean isbefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));
		System.out.println("isbefore:"+isbefore);
		LocalTime maxTime = LocalTime.MAX;
		System.out.println("maxTime:"+maxTime);

	    ZoneId zone1 = ZoneId.of("Asia/Kolkata");  
	    ZoneId zone2 = ZoneId.of("Asia/Tokyo");  
	    LocalTime time1 = LocalTime.now(zone1);  
	    System.out.println("India Time Zone: "+time1);  
	    LocalTime time2 = LocalTime.now(zone2);  
	    System.out.println("Japan Time Zone: "+time2);  
	    long hours = ChronoUnit.HOURS.between(time1, time2);  
	    System.out.println("Hours between two Time Zone: "+hours);  
	    long minutes = ChronoUnit.MINUTES.between(time1, time2);  
	    System.out.println("Minutes between two time zone: "+minutes); 
	    
		System.out.println("-------ZoneId--------");
	    
	    Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
	    System.out.println("allZoneIds:"+allZoneIds);
		
	    ZoneId zoneId = ZoneId.of("Asia/Dubai");
	    LocalDateTime localDateTime2=LocalDateTime.now();
	    ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime2, zoneId);
	    System.out.println("zonedDateTime:"+zonedDateTime);
	    
	    ZonedDateTime zonedDateTimeParis = ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris]");
	    System.out.println("zonedDateTimeParis:"+zonedDateTimeParis);

	    ZoneId zone3 = ZoneId.of("Europe/Paris");
	    LocalTime localTimeParis = LocalTime.now(zone3);
	    System.out.println("localTimeParis:"+localTimeParis);
	    
	    ZoneId zone = ZoneId.systemDefault();     
	    System.out.println("zone:"+zone);  
	    System.out.println(zone.getId()); 
	    System.out.println(zone.getDisplayName(TextStyle.FULL, Locale.ROOT));  
	    
		System.out.println("-------ZoneOffset--------");
	    
		System.out.println(ZoneOffset.UTC);
		System.out.println(ZoneOffset.MAX);
		System.out.println(ZoneOffset.MIN);
		
	    ZoneOffset zone4 = ZoneOffset.UTC;  
	    System.out.println(zone4);
	    Temporal temp = zone4.adjustInto(ZonedDateTime.now());  
	    System.out.println(temp);  
	    
	    ZoneOffset zone5 = ZoneOffset.ofHours(5);  
	    System.out.println(zone5); 
	    ZoneOffset zone6 = ZoneOffset.ofHoursMinutes(5,30);  
	    System.out.println(zone6);
	    ZoneOffset offset = ZoneOffset.of("+02:00");
	    System.out.println(offset);
	    
	    LocalDateTime localDateTime3 = LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);
	    System.out.println("localDateTime3:"+localDateTime3);
	    
	    ZoneOffset zone7 = ZoneOffset.UTC;  
	    boolean b1 = zone7.isSupported(ChronoField.OFFSET_SECONDS);  
	    System.out.println(b1);  
	    boolean b2 = zone7.isSupported(ChronoField.SECOND_OF_MINUTE);  
	    System.out.println(b2);
	    
		System.out.println("-------OffsetDateTime--------");
	    
	    OffsetDateTime offSetByTwo = OffsetDateTime
	      .of(localDateTime3, offset);
	    System.out.println("offSetByTwo:"+offSetByTwo);
	    
		System.out.println("-------LocalDateTime--------");

		System.out.println(java.time.LocalDateTime.now());  
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		System.out.println(now);
		System.out.println(dtf.format(now));
		
		System.out.println(LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30));
		System.out.println(LocalDateTime.parse("2015-02-20T06:30:00"));
		System.out.println(LocalDateTime.now().plusDays(1));
		System.out.println(LocalDateTime.now().minusHours(1));
		System.out.println(LocalDateTime.now().getMonth());
		
		LocalDateTime localDateTime = LocalDateTime.now();
		localDateTime.plusDays(1);
		System.out.println(localDateTime);
		System.out.println(localDateTime.plusDays(10));
		System.out.println(localDateTime.plusDays(10).minusHours(1));
		System.out.println(localDateTime.plusDays(100).minusHours(1).getMonth());

		System.out.println("--------month-------");
		
        Month month = Month.valueOf("January".toUpperCase());  
        System.out.printf("For the month of %s all Sunday are:%n", month);  
        LocalDate localdate = Year.now().atMonth(month).atDay(1).  
        with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));  
        Month mi = localdate.getMonth();  
        while (mi == month) {  
            System.out.printf("%s%n", localdate);  
            localdate = localdate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));  
            mi = localdate.getMonth();  
        } 
        
        Month month2 = Month.from(LocalDate.now());  
        System.out.println(month2.getValue());  
        System.out.println(month2.name()); 
        System.out.println(month2.minus(2));  
        System.out.println(month2.plus(2));  
        System.out.println("Total Number of days: "+month2.length(true));  
        System.out.println(month2.maxLength());
        System.out.println(month2.minLength());
        
        System.out.println(Month.valueOf("February".toUpperCase()).maxLength());
        System.out.println(Month.valueOf("February".toUpperCase()).minLength());
        
		System.out.println("--------DayOfWeek-------");
        
        LocalDate localDate2 = LocalDate.of(1987, Month.JANUARY, 26); 
        System.out.println("localDate2: "+localDate2); 
        DayOfWeek dayOfWeek2 = DayOfWeek.from(localDate2);  
        System.out.println(dayOfWeek2.get(ChronoField.DAY_OF_WEEK));  
        System.out.println(dayOfWeek2.name()); 
        System.out.println(dayOfWeek2.ordinal());  
        System.out.println(dayOfWeek2.getValue()); 
        
        DayOfWeek day = DayOfWeek.of(5);  
        System.out.println(day.name());  
        System.out.println(day.ordinal());  
        System.out.println(day.getValue());          
        
        LocalDate localDate3 = LocalDate.now();
        DayOfWeek dayOfWeek3 = DayOfWeek.from(localDate3);
        System.out.println(dayOfWeek3.plus(3));
        System.out.println(dayOfWeek3.minus(3));
        
		System.out.println("--------Clock-------");

		System.out.println(java.time.Clock.systemUTC().instant());  
		
		System.out.println("--------Duration-------");
		
		LocalTime initialTime = LocalTime.of(6, 30, 0);
		System.out.println("initialTime:"+initialTime);
		LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));
		System.out.println("finalTime:"+finalTime);
		long duration = Duration.between(initialTime, finalTime).getSeconds();
		System.out.println("duration:"+duration);
		long duration2 = ChronoUnit.SECONDS.between(initialTime, finalTime);
		System.out.println("duration2:"+duration2);
		
	    Duration d = Duration.between(LocalTime.NOON,LocalTime.MAX);  
	    System.out.println(d.get(ChronoUnit.SECONDS));   
	    //System.out.println(d.get(ChronoUnit.MINUTES)); 
	    //System.out.println(d.get(ChronoUnit.HOURS));  
	    System.out.println(d.getSeconds());
	    System.out.println(d.plus(d));
	    System.out.println(d.minus(d));
	    
	    
	      Duration d1 = Duration.between(LocalTime.MAX,LocalTime.NOON);  
	      System.out.println(d1.isNegative());  
	      Duration d2 = Duration.between(LocalTime.NOON,LocalTime.MAX);  
	      System.out.println(d2.isNegative()); 	    
	    
		System.out.println("--------legacy-------");
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(sdf.format(date));
		
		java.util.Date date2=new java.util.Date();  
		System.out.println(date2);  
		
		long millis=System.currentTimeMillis();  
		java.util.Date date3=new java.util.Date(millis);  
		System.out.println(date3);  
		
		Date date4=java.util.Calendar.getInstance().getTime();  
		System.out.println(date4);  
		
	}

}
