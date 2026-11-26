package com.example.bingwahybrid.domain.qr.model;

import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QrCodePayload.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/example/bingwahybrid/domain/qr/model/QrCodePayload;", "", ImagesContract.URL, "", "deviceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getDeviceId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class QrCodePayload {
    public static final int $stable = 0;
    private final String deviceId;
    private final String url;

    public static /* synthetic */ QrCodePayload copy$default(QrCodePayload qrCodePayload, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = qrCodePayload.url;
        }
        if ((i & 2) != 0) {
            str2 = qrCodePayload.deviceId;
        }
        return qrCodePayload.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    public final QrCodePayload copy(String url, String deviceId) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        return new QrCodePayload(url, deviceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QrCodePayload)) {
            return false;
        }
        QrCodePayload qrCodePayload = (QrCodePayload) other;
        return Intrinsics.areEqual(this.url, qrCodePayload.url) && Intrinsics.areEqual(this.deviceId, qrCodePayload.deviceId);
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + this.deviceId.hashCode();
    }

    public String toString() {
        return "QrCodePayload(url=" + this.url + ", deviceId=" + this.deviceId + ")";
    }

    public QrCodePayload(String url, String deviceId) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        this.url = url;
        this.deviceId = deviceId;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }
}
