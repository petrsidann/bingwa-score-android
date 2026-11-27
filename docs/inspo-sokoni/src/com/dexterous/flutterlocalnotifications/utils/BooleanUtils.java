package com.dexterous.flutterlocalnotifications.utils;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class BooleanUtils {
    public static boolean getValue(Boolean bool) {
        return bool != null && bool.booleanValue();
    }
}
