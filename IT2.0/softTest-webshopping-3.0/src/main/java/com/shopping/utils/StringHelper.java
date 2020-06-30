package com.shopping.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper {
    private StringHelper() {

    }


    private static final String REG_CHINESE = "^[\u4e00-\u9fa5]+$";


    private static final String REG_EMAIL = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";


    protected static boolean isMatch(String str, String regPattern) {


        if (str == null || str.length() == 0)
            return false;


        Pattern p = Pattern.compile(regPattern);
        Matcher m = p.matcher(str);


        return m.matches();
    }

    public static boolean isNum(String str){
        for(int i=0;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * 是否是合格的手机号码格式
     *
     * @param phoneNum 非空字符串电话号码
     * @return true 合法的手机号
     */
    public static boolean isPhoneNum(String phoneNum) {

        String regex = "(\\+\\d+)?1[3458]\\d{9}$";
        return Pattern.matches(regex, phoneNum);

    }


    //

    /**
     * 判断email格式是否正确
     *
     * @param email 非空字符串
     * @return
     */
    public static boolean isEmail(String email) {


        return isMatch(email, REG_EMAIL);
    }


    /**
     * 匹配中国邮政编码
     *
     * @param str 非空字符串
     * @return
     */
    public static boolean isPostCode(String str) {
        return isMatch(str, "^[1-9]\\d{5}$");
    }


    /**
     * 非空字符串是否是中文
     *
     * @param str 非空字符串
     * @return 全是中文字符为true
     */
    public static boolean isChinese(String str) {
        if (str == null) {
            return false;
        }
        if (str.length() == 0) {
            return false;
        }
        Pattern pt = Pattern.compile(REG_CHINESE);
        Matcher mt = pt.matcher(str);
        return mt.matches();
    }
}
