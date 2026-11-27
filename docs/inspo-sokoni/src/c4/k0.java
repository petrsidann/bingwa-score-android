package c4;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class k0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k0 f3384e = new k0(true, 3, 1, null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f3387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3388d;

    public k0(boolean z10, int i10, int i11, String str, Throwable th) {
        this.f3385a = z10;
        this.f3388d = i10;
        this.f3386b = str;
        this.f3387c = th;
    }

    @Deprecated
    public static k0 b() {
        return f3384e;
    }

    public static k0 c(String str) {
        return new k0(false, 1, 5, str, null);
    }

    public static k0 d(String str, Throwable th) {
        return new k0(false, 1, 5, str, th);
    }

    public static k0 f(int i10) {
        return new k0(true, i10, 1, null, null);
    }

    public static k0 g(int i10, int i11, String str, Throwable th) {
        return new k0(false, i10, i11, str, th);
    }

    public String a() {
        return this.f3386b;
    }

    public final void e() {
        if (this.f3385a || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.f3387c != null) {
            Log.d("GoogleCertificatesRslt", a(), this.f3387c);
        } else {
            Log.d("GoogleCertificatesRslt", a());
        }
    }
}
