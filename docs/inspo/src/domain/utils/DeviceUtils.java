package com.example.bingwahybrid.domain.utils;

import android.os.Build;
import io.ktor.sse.ServerSentEventKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: DeviceUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/example/bingwahybrid/domain/utils/DeviceUtils;", "", "<init>", "()V", "getDeviceModel", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeviceUtils {
    public static final int $stable = 0;
    public static final DeviceUtils INSTANCE = new DeviceUtils();

    private DeviceUtils() {
    }

    public final String getDeviceModel() {
        return Build.MANUFACTURER + ServerSentEventKt.SPACE + Build.MODEL;
    }
}
