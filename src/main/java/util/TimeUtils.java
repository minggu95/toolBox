package util;


import dto.TimeInfo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

    /**
     * 当前时间向推几小时
     * @param timeInfo 入参
     * @return String
     */
    public static String dateRollHour(TimeInfo timeInfo) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //（1）获取当前时间
        LocalDateTime time = LocalDateTime.parse(timeInfo.getDate(), dateTimeFormatter);
        //（2）获取当前时间的前几小时时间
        LocalDateTime localDateTime = time.minusHours(timeInfo.getPeriod());

        return dateTimeFormatter.format(localDateTime);
    }

    /**
     * 当前时间向推几分钟
     * @param timeInfo 入参
     * @return String
     */
    public static String dateRollMinute(TimeInfo timeInfo) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //（1）获取当前时间
        LocalDateTime time = LocalDateTime.parse(timeInfo.getDate(), dateTimeFormatter);
        //（2）获取当前时间的前几分钟
        LocalDateTime localDateTime = time.minusMinutes(timeInfo.getPeriod());

        return dateTimeFormatter.format(localDateTime);
    }

    /**
     * 当前时间向推几天
     * @param timeInfo 入参
     * @return String
     */
    public static String dateRollDay(TimeInfo timeInfo) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //（1）获取当前时间
        LocalDateTime time = LocalDateTime.parse(timeInfo.getDate(), dateTimeFormatter);
        //（2）获取当前时间的前几天
        LocalDateTime localDateTime = time.minusDays(timeInfo.getPeriod());

        return dateTimeFormatter.format(localDateTime);
    }
}
