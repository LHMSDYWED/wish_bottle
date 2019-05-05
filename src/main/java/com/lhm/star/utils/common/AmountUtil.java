package com.lhm.star.utils.common;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.FieldPosition;

/**
 * <p>
 * Title: AmountUtil
 * </p>
 * <p>
 * Description: 金额工具类
 * </p>
 *
 * @author LIYANG yangzi818@msn.com
 * @date 2018年5月22日
 */
public class AmountUtil {


    /**
     * 将字符串"元"转换成"分"
     *
     * @param str
     * @return
     */
    public static String dollar2Cent(String str) {
        DecimalFormat df = new DecimalFormat("0.00");
        StringBuffer sb = df.format(Double.parseDouble(str), new StringBuffer(), new FieldPosition(0));
        int idx = sb.toString().indexOf(".");
        sb.deleteCharAt(idx);
        for (; sb.length() != 1; ) {
            if (sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            } else {
                break;
            }
        }
        return sb.toString();
    }

    /**
     * 将字符串"元"转换成"分"
     *
     * @param str
     * @return
     */
    public static Integer convertY2F(Object str) {
        if(str == null){
            return null;
        }
        if (str instanceof Integer) {
            return (Integer)str;
        }
        if (str instanceof String) {
            if("".equals(str)){
                return null;
            }
            return Integer.valueOf(dollar2Cent((String) str));
        }
        return null;
    }


    /**
     * 将字符串"分"转换成"元"（长格式），如：100分被转换为1.00元。
     *
     * @param s
     * @return
     */
    public static String convertCent2Dollar(String s) {
        if ("".equals(s) || s == null) {
            return "";
        }
        long l;
        if (s.length() != 0) {
            if (s.charAt(0) == '+') {
                s = s.substring(1);
            }
            l = Long.parseLong(s);
        } else {
            return "";
        }
        boolean negative = false;
        if (l < 0) {
            negative = true;
            l = Math.abs(l);
        }
        s = Long.toString(l);
        if (s.length() == 1) {
            return (negative ? ("-0.0" + s) : ("0.0" + s));
        }
        if (s.length() == 2) {
            return (negative ? ("-0." + s) : ("0." + s));
        } else {
            String s1 = s.substring(0, s.length() - 2) + "." + s.substring(s.length() - 2);
            return (negative ? ("-" + s1) : (s1));
        }
    }


    /**
     * 金额换算
     * 将字符串"分"转换成"元"（长格式），如：100分被转换为1.00元。
     *
     * @param p
     * @return
     */
    public static String convertF2Y(Object p) {
        if(p == null){
            return null;
        }
        if (p instanceof Integer) {
            Double du =(Integer)p / 100D;
            return String.format("%.2f", du);
        }
        if (p instanceof Long) {
            Double du =(Long)p / 100D;
            return String.format("%.2f", du);
        }
        if (p instanceof String) {
            return p.toString();
        }
        return null;
    }

    /**
     * 将字符串"分"转换成"元"（短格式），如：100分被转换为1元。
     *
     * @param price
     * @return
     */
    public static String convertCent2DollarShort(Integer price) {
        return BigDecimal.valueOf(Long.valueOf(price)).divide(new BigDecimal(100)).toString();
    }

    /**
     * <p>
     * Title: isNumber
     * </p>
     * <p>
     * Description: 金额验证
     * </p>
     *
     * @param money
     * @return
     */
    public static boolean isMoney(String money) {
        java.util.regex.Pattern pattern = java.util.regex.Pattern
                .compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // 判断小数点后2位的数字的正则表达式
        java.util.regex.Matcher match = pattern.matcher(money);
        if (match.matches() == false) {
            return false;
        } else {
            return true;
        }
    }

}
