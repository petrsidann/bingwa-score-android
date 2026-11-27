package u4;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e6 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b6 f16129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f16131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f16132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f16133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, List<String>> f16134f;

    public e6(String str, b6 b6Var, int i10, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        com.google.android.gms.common.internal.r.l(b6Var);
        this.f16129a = b6Var;
        this.f16130b = i10;
        this.f16131c = th;
        this.f16132d = bArr;
        this.f16133e = str;
        this.f16134f = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16129a.a(this.f16133e, this.f16130b, this.f16131c, this.f16132d, this.f16134f);
    }
}
