package com.klfront.klblog.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonUtil {
    private static String DATE_FORMAT_TYPE = "yyyy-MM-dd HH:mm:ss";

    /**
     * 10位13位时间戳转String 格式（2018-10-15 16:03:27） 日期
     *
     * @param timestamp
     * @return
     */
    public static String timestampToString(String timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_TYPE);//要转换的时间格式
        String date = null;
        if (timestamp.length() == 13) {
            date = sdf.format(Long.parseLong(timestamp));
        } else {
            date = sdf.format(Long.parseLong(timestamp) * 1000);
        }
        return date;
    }

    /**
     * 10位13位时间戳转Date
     *
     * @param timestamp 参数时间戳
     * @return
     */
    public static Date timestampToDate(String timestamp) {
        if (timestamp == null) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_TYPE);//要转换的时间格式
        Date date = null;
        try {
            if (timestamp != null && timestamp.length() == 13) {
                date = sdf.parse(sdf.format(Long.parseLong(timestamp)));
            } else if (timestamp != null && timestamp.length() == 10) {
                date = sdf.parse(sdf.format(Long.parseLong(timestamp) * 1000));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Date转10位13位时间戳
     *
     * @param date 参数date
     * @param n    需要转换成几位时间戳
     * @return
     */
    public static String dateToTimestamp(Date date, int n) {
        String result = null;
        if (n == 13) {
            result = String.valueOf(date.getTime());
        } else {
            result = String.valueOf(date.getTime() / 1000);
        }
        return result;
    }

    /*
     * @description:分页结果及总记录数以map返回的统一方法
     * @author: Lu Jinlong
     * @date: 2021/3/19 14:25
     * @param: list 查询到的分页记录
     * @param: total 查询到的总记录数
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    public static Map<String, Object> getResult(List<?> list, Integer total) {
        //将查询数据放入result
        Map<String, Object> result = new HashMap<>();
        result.put("list", list);
        result.put("total", total);

        return result;
    }

}
