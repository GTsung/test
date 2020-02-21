package com.gradle.demo.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author guxc
 * @date 2020/2/21
 */
public class DateUtil {

    private static final DateTimeFormatter FULL_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter HYPHEN_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final String COMMON_PATTEN = "yyyy-MM-dd HH:mm:ss";

    private DateUtil(){}

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime); // 2020-02-21T21:38:27.336
        System.out.println(localDateTime.toString()); // 2020-02-21T21:38:27.336

        LocalDateTime localDateTime1 = LocalDateTime.of(LocalDate.now(),LocalTime.now());
        localDateTime1 = LocalDateTime.of(2020,1,31,10,21,11);
        localDateTime1 = LocalDateTime.of(2020, Month.FEBRUARY,21,10,21,11);
        System.out.println(localDateTime1);
        System.out.println(localDateTime1.format(FULL_FORMATTER)); // format()返回指定格式的String
        System.out.println(localDateTime1.getDayOfMonth()); // 获取这个月的第几天
        System.out.println(localDateTime1.getDayOfWeek().getValue()); // 获取这周第几天天
        LocalDateTime localDateTime2 = LocalDateTime.from(localDateTime1); // 从某个日期获取
        System.out.println(localDateTime2);
        System.out.println(localDateTime.getDayOfYear()); // 获取当天为这年的第几天
        System.out.println(localDateTime.getHour()); // 获取时辰
        System.out.println("---------------");
        LocalDateTime localDateTime3 = LocalDateTime.of(2018,1,1,8,0,0);
        System.out.println(localDateTime3.getLong(ChronoField.CLOCK_HOUR_OF_DAY)); // 获取指定字段
        System.out.println(localDateTime3.getMinute()); // 0分钟
        System.out.println(localDateTime3.getSecond()); // 0秒钟
        System.out.println(localDateTime3.getMonth() + "--" + localDateTime3.getMonthValue()); // 0秒钟
        System.out.println(localDateTime3.getYear()); // 2018
        System.out.println(localDateTime3.isAfter(localDateTime2) + "-----" + localDateTime3.isBefore(localDateTime));

        System.out.println(localDateTime3.minus(Period.ofDays(2))); // 2017-12-30T08:00
        System.out.println(localDateTime3.minus(2, ChronoUnit.DAYS)); // 2017-12-30T08:00

        System.out.println(LocalDateTime.parse("2017-02-03T10:15:30"));

        System.out.println(localDateTime3.with(ChronoField.DAY_OF_MONTH,12)); // 根据属性将其置换为新值

        System.out.println("++++++++++++++++++++++++++++");
        LocalDateTime localDateTime4 = LocalDateTime.of(2020,2,21,11,41,40);
        LocalDateTime localDateTime5 = LocalDateTime.of(2020,2,21,15,40,40);
        System.out.println(Duration.between(localDateTime4,localDateTime5).toHours());
        System.out.println(Duration.between(localDateTime4,localDateTime5).toMinutes());
        System.out.println(calSumTime(localTime2Date(localDateTime4),localTime2Date(localDateTime5)));
        System.out.println("+++++++++++++++++++++++++");

        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);
        System.out.println(localDate.toString());
        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println(localTime);
        System.out.println(localTime.toString());


    }

    private static String calSumTime(Date start, Date end) {
        return String.format("%d H %d m",
                calcHourOffSet(start, end)
                ,
                calcMinuteOffSet(start, end) % 60);
    }

    public static int calcHourOffSet(Date start, Date end){
        return (int) Duration.between(date2LocalDateTime(start),date2LocalDateTime(end)).toHours();
    }

    public static int calcMinuteOffSet(Date start, Date end){
        return (int) Duration.between(date2LocalDateTime(start),date2LocalDateTime(end)).toMinutes();
    }

    public static Date localTime2Date(LocalDateTime localTime) {
        if (localTime == null) {
            localTime = LocalDateTime.parse("1970-01-01 00:00:00", DateTimeFormatter.ofPattern(COMMON_PATTEN));
        }
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    public static LocalDate date2LocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }

    private static LocalDateTime localDate2Time(LocalDate date) {
        return date2LocalDateTime(local2Date(date));
    }

    public static LocalDateTime date2LocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    public static Date local2Date(LocalDate localDate) {
        if (localDate == null) {
            localDate = LocalDate.parse("1970-01-01", HYPHEN_FORMATTER);
        }
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        return Date.from(zdt.toInstant());
    }
}
