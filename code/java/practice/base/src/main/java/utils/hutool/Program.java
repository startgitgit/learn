package utils.hutool;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.BetweenFormater;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.PageUtil;
import cn.hutool.crypto.SecureUtil;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


        int a = 1;
       //aStr为"1"
        String aStr = Convert.toStr(a);

        long[] b = {1, 2, 3, 4, 5};
        //bStr为："[1, 2, 3, 4, 5]"
        String bStr = Convert.toStr(b);

        String[] c = { "1", "2", "3", "4" };
        //结果为Integer数组
        Integer[] intArray = Convert.toIntArray(c);

        long[] d = {1,2,3,4,5};
        //结果为Integer数组
        Integer[] intArray2 = Convert.toIntArray(d);

        String e = "2017-05-06";
        Date value = Convert.toDate(e);

        String zhouyq = SecureUtil.md5("zhouyq");
        System.out.println(zhouyq);

        // PageUtil
        int[] startEnd1 = PageUtil.transToStartEnd(0, 10);//[0, 10]
        int[] startEnd2 = PageUtil.transToStartEnd(1, 10);//[10, 20]
        int totalPage = PageUtil.totalPage(20, 3);//7

        //分页彩虹算法
        //上一页 3 4 [5] 6 7 8 下一页.
        //参数意义分别为：当前页、总页数、每屏展示的页数
        int[] rainbow = PageUtil.rainbow(5, 20, 6);
        //结果：[3, 4, 5, 6, 7, 8]



    }
}
