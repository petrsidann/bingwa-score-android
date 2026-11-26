package com.example.bingwahybrid.domain.devices.model;

import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LinkedDevice.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/example/bingwahybrid/domain/devices/model/LinkedDevice;", "", "deviceId", "", "fcmToken", "deviceName", ImagesContract.URL, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getFcmToken", "getDeviceName", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class LinkedDevice {
    public static final int $stable = 0;
    private final String deviceId;
    private final String deviceName;
    private final String fcmToken;
    private final String url;

    public static /* synthetic */ LinkedDevice copy$default(LinkedDevice linkedDevice, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = linkedDevice.deviceId;
        }
        if ((i & 2) != 0) {
            str2 = linkedDevice.fcmToken;
        }
        if ((i & 4) != 0) {
            str3 = linkedDevice.deviceName;
        }
        if ((i & 8) != 0) {
            str4 = linkedDevice.url;
        }
        return linkedDevice.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFcmToken() {
        return this.fcmToken;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final LinkedDevice copy(String deviceId, String fcmToken, String deviceName, String url) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(url, "url");
        return new LinkedDevice(deviceId, fcmToken, deviceName, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LinkedDevice)) {
            return false;
        }
        LinkedDevice linkedDevice = (LinkedDevice) other;
        return Intrinsics.areEqual(this.deviceId, linkedDevice.deviceId) && Intrinsics.areEqual(this.fcmToken, linkedDevice.fcmToken) && Intrinsics.areEqual(this.deviceName, linkedDevice.deviceName) && Intrinsics.areEqual(this.url, linkedDevice.url);
    }

    public int hashCode() {
        int iHashCode = this.deviceId.hashCode() * 31;
        String str = this.fcmToken;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.deviceName.hashCode()) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "LinkedDevice(deviceId=" + this.deviceId + ", fcmToken=" + this.fcmToken + ", deviceName=" + this.deviceName + ", url=" + this.url + ")";
    }

    public LinkedDevice(String deviceId, String str, String deviceName, String url) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(url, "url");
        this.deviceId = deviceId;
        this.fcmToken = str;
        this.deviceName = deviceName;
        this.url = url;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getFcmToken() {
        return this.fcmToken;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getUrl() {
        return this.url;
    }
}
