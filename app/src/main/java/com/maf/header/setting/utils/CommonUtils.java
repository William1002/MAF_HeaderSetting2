package com.maf.header.setting.utils;

import android.content.Context;

import java.util.Locale;

/**
 * Created by CLH on 2016/7/12.
 * 常用工具类
 */
public class CommonUtils {
    public static String getSysLanguage(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        StringBuilder sb = new StringBuilder();
        sb.append(locale.getLanguage());
        sb.append("-");
        sb.append(locale.getCountry());
        sb.append(",");
        sb.append(locale.getLanguage());
        return sb.toString();
    }
}
