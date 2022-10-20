package com.jdbc.widgets;


import java.text.SimpleDateFormat;
import java.util.Date;

public class UserIDUtils {

    public static String getUserID(){
        Date oDate = new Date();
        // 配置日期格式
        SimpleDateFormat oSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // 格式化日期
        String oDateFormart = oSimpleDateFormat.format(oDate);
        // 设置日期样式, 清除日期中的 - 符号
        String oDateStr = oDateFormart.replace("-", "");
        // 创建随机数
        int oRandom = (int) (Math.random() * 100);
        String oUserID = "CD-User-" + oDateStr + "-" + (oRandom < 10 ? "0" + oRandom : oRandom);
        return  oUserID;
    }
}
