package com.jkl.Utils;

/**
 * @author zhongxin
 * @date 2020/10/8/008 15:01
 */
public class DataCheckUtil {

    public static boolean isEmptyString(String str){
        if(str == null) return true;
        return str.replace(" ","").equals("");
    }
}
