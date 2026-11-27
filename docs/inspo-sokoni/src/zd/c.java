package zd;

import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public enum c implements p {
    none("none"),
    manifest("manifest"),
    dataSync("dataSync"),
    mediaPlayback("mediaPlayback"),
    redeliveryIntent("redeliveryIntent"),
    phoneCall("phoneCall"),
    connectedDevice("connectedDevice"),
    mediaProjection("mediaProjection"),
    location("location"),
    camera("camera"),
    microphone("microphone");


    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static c[] f20544r = (c[]) c.class.getEnumConstants();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20546a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20547a;

        static {
            int[] iArr = new int[c.values().length];
            f20547a = iArr;
            try {
                iArr[c.camera.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20547a[c.connectedDevice.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20547a[c.dataSync.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20547a[c.location.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20547a[c.manifest.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f20547a[c.mediaPlayback.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f20547a[c.mediaProjection.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f20547a[c.microphone.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f20547a[c.phoneCall.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f20547a[c.none.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    c(String str) {
        this.f20546a = str.toLowerCase(Locale.ENGLISH);
    }

    public static c i(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return null;
        }
        if (p.d(str, length, 0, 'p')) {
            return phoneCall;
        }
        if (p.d(str, length, 0, 'n')) {
            return none;
        }
        if (p.d(str, length, 0, 'c')) {
            return p.d(str, length, 1, 'a') ? camera : connectedDevice;
        }
        if (p.d(str, length, 0, 'm')) {
            if (p.d(str, length, 1, 'i')) {
                return microphone;
            }
            if (p.d(str, length, 5, 'l')) {
                return mediaPlayback;
            }
            return p.d(str, length, 5, 'r') ? mediaProjection : manifest;
        }
        if (p.d(str, length, 0, 'd')) {
            return dataSync;
        }
        if (p.d(str, length, 0, 'l')) {
            return location;
        }
        return null;
    }

    @Override // zd.p
    public String h() {
        return this.f20546a;
    }

    public int k() {
        switch (a.f20547a[ordinal()]) {
            case 1:
                return 64;
            case 2:
                return 16;
            case 3:
                return 1;
            case 4:
                return 8;
            case 5:
                return -1;
            case 6:
                return 2;
            case 7:
                return 32;
            case 8:
                return 128;
            case 9:
                return 4;
            default:
                return 0;
        }
    }
}
