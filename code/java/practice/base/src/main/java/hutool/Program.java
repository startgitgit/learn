package hutool;

import cn.hutool.core.date.BetweenFormater;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.util.IdUtil;

import java.util.Date;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/6/7 10:01
 */
public class Program {
    public static void main(String[] args) {
        TimeInterval timer = DateUtil.timer();

        System.out.println(IdUtil.randomUUID());
        System.out.println(IdUtil.simpleUUID());


        String dateStr1 = "2017-03-01 22:33:23";
        Date date1 = DateUtil.parse(dateStr1);

        String dateStr2 = "2017-04-01 23:33:23";
        Date date2 = DateUtil.parse(dateStr2);

       //相差一个月，31天
        long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
        System.out.println(betweenDay);
        String formatBetween = DateUtil.formatBetween(date1, date2, BetweenFormater.Level.MINUTE);
        System.out.println(formatBetween);

        System.out.println(timer.interval());//花费毫秒数
        System.out.println(timer.intervalMinute());//花费分钟数
        System.out.println(timer.intervalRestart());//返回花费时间，并重置开始时间

    }
}
