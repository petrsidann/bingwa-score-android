package u4;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class ya implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f16979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f16980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f16982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ va f16983e;

    public ya(va vaVar, boolean z10, Uri uri, String str, String str2) {
        this.f16979a = z10;
        this.f16980b = uri;
        this.f16981c = str;
        this.f16982d = str2;
        this.f16983e = vaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        va.f(this.f16983e, this.f16979a, this.f16980b, this.f16981c, this.f16982d);
    }
}
