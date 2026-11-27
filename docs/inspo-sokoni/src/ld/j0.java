package ld;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12734a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f12734a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
