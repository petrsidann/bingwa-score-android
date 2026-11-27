package u4;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class z5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f16993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bundle f16994d;

    public z5(String str, String str2, Bundle bundle, long j10) {
        this.f16991a = str;
        this.f16992b = str2;
        this.f16994d = bundle == null ? new Bundle() : bundle;
        this.f16993c = j10;
    }

    public static z5 b(n0 n0Var) {
        return new z5(n0Var.f16569a, n0Var.f16571c, n0Var.f16570b.V(), n0Var.f16572d);
    }

    public final n0 a() {
        return new n0(this.f16991a, new i0(new Bundle(this.f16994d)), this.f16992b, this.f16993c);
    }

    public final String toString() {
        return "origin=" + this.f16992b + ",name=" + this.f16991a + ",params=" + String.valueOf(this.f16994d);
    }
}
