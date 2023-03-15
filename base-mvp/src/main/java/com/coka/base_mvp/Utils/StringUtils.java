package com.coka.base_mvp.Utils;

public class StringUtils {
    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0 || cs.equals("");
    }
    public static boolean isNotEmpty(CharSequence cs)
    {
        return !StringUtils.isEmpty(cs);
    }
}
