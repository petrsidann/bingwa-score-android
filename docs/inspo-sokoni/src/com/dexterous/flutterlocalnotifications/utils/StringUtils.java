package com.dexterous.flutterlocalnotifications.utils;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class StringUtils {
    public static Boolean isNullOrEmpty(String str) {
        return Boolean.valueOf(str == null || str.isEmpty());
    }
}
