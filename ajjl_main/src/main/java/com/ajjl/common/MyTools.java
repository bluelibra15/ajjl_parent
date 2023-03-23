package com.ajjl.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class MyTools {

    public static String getUUID(){
        // 2.中间四位整数，标识日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String dayTime = sdf.format(new Date());
        // 3.生成uuid的hashCode值
        int hashCode = UUID.randomUUID().toString().hashCode();
        // 4.可能为负数
        if(hashCode < 0){
            hashCode = -hashCode;
        }
        // 5.算法处理: 0-代表前面补充0; 10-代表长度为10; d-代表参数为正数型
        String value = dayTime + String.format("%010d", hashCode);
        return value;
    }

    public static String getRegCode(){
        //生成唯一编码并按 "-" 分割
        String uuid = UUID.randomUUID().toString();
        String[] uuidSplit = uuid.split("-");

        //使用日期格式化 将 当前时间(年月日时分秒) 格式化为一串数字
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        String format = dateFormat.format(new Date());

        //取UUID的部分与 格式化日期得到的数字 拼接成一串新的 字符串
        //作为生成的卡密
        String regCode = uuidSplit[1]+uuidSplit[3]+format+uuidSplit[2];
        return regCode;
    }

    public static void logInfo(Object log){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String formatDate = format.format(date);
        System.out.println("["+formatDate+"] -------------------------------\n "+log.toString()+"\n");
    }

    public static Date getDate(Integer hour){
        Calendar c1 = Calendar.getInstance();
        c1.setTime(new Date());
        c1.add(Calendar.HOUR,hour);
        Date time = c1.getTime();
        return time;
    }
}
