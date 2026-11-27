package u4;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f16207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f16208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i0 f16209f;

    public g0(k7 k7Var, String str, String str2, String str3, long j10, long j11, Bundle bundle) {
        i0 i0Var;
        com.google.android.gms.common.internal.r.f(str2);
        com.google.android.gms.common.internal.r.f(str3);
        this.f16204a = str2;
        this.f16205b = str3;
        this.f16206c = TextUtils.isEmpty(str) ? null : str;
        this.f16207d = j10;
        this.f16208e = j11;
        if (j11 != 0 && j11 > j10) {
            k7Var.zzj().H().b("Event created with reverse previous/current timestamps. appId", v5.r(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            i0Var = new i0(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    k7Var.zzj().C().a("Param name can't be null");
                } else {
                    Object objO0 = k7Var.K().o0(next, bundle2.get(next));
                    if (objO0 == null) {
                        k7Var.zzj().H().b("Param value can't be null", k7Var.A().f(next));
                    } else {
                        k7Var.K().K(bundle2, next, objO0);
                    }
                }
                it.remove();
            }
            i0Var = new i0(bundle2);
        }
        this.f16209f = i0Var;
    }

    public g0(k7 k7Var, String str, String str2, String str3, long j10, long j11, i0 i0Var) {
        com.google.android.gms.common.internal.r.f(str2);
        com.google.android.gms.common.internal.r.f(str3);
        com.google.android.gms.common.internal.r.l(i0Var);
        this.f16204a = str2;
        this.f16205b = str3;
        this.f16206c = TextUtils.isEmpty(str) ? null : str;
        this.f16207d = j10;
        this.f16208e = j11;
        if (j11 != 0 && j11 > j10) {
            k7Var.zzj().H().c("Event created with reverse previous/current timestamps. appId, name", v5.r(str2), v5.r(str3));
        }
        this.f16209f = i0Var;
    }

    public final g0 a(k7 k7Var, long j10) {
        return new g0(k7Var, this.f16206c, this.f16204a, this.f16205b, this.f16207d, j10, this.f16209f);
    }

    public final String toString() {
        return "Event{appId='" + this.f16204a + "', name='" + this.f16205b + "', params=" + String.valueOf(this.f16209f) + "}";
    }
}
