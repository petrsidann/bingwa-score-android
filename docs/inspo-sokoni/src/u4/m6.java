package u4;

import android.content.SharedPreferences;
import android.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public final class m6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f16508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ i6 f16509e;

    public m6(i6 i6Var, String str, long j10) {
        this.f16509e = i6Var;
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.a(j10 > 0);
        this.f16505a = str + ":start";
        this.f16506b = str + ":count";
        this.f16507c = str + ":value";
        this.f16508d = j10;
    }

    public final Pair<String, Long> a() {
        long jAbs;
        this.f16509e.j();
        this.f16509e.j();
        long jC = c();
        if (jC == 0) {
            d();
            jAbs = 0;
        } else {
            jAbs = Math.abs(jC - this.f16509e.zzb().a());
        }
        long j10 = this.f16508d;
        if (jAbs < j10) {
            return null;
        }
        if (jAbs > (j10 << 1)) {
            d();
            return null;
        }
        String string = this.f16509e.F().getString(this.f16507c, null);
        long j11 = this.f16509e.F().getLong(this.f16506b, 0L);
        d();
        return (string == null || j11 <= 0) ? i6.B : new Pair<>(string, Long.valueOf(j11));
    }

    public final void b(String str, long j10) {
        this.f16509e.j();
        if (c() == 0) {
            d();
        }
        if (str == null) {
            str = "";
        }
        long j11 = this.f16509e.F().getLong(this.f16506b, 0L);
        if (j11 <= 0) {
            SharedPreferences.Editor editorEdit = this.f16509e.F().edit();
            editorEdit.putString(this.f16507c, str);
            editorEdit.putLong(this.f16506b, 1L);
            editorEdit.apply();
            return;
        }
        long j12 = j11 + 1;
        boolean z10 = (this.f16509e.g().P0().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j12;
        SharedPreferences.Editor editorEdit2 = this.f16509e.F().edit();
        if (z10) {
            editorEdit2.putString(this.f16507c, str);
        }
        editorEdit2.putLong(this.f16506b, j12);
        editorEdit2.apply();
    }

    public final long c() {
        return this.f16509e.F().getLong(this.f16505a, 0L);
    }

    public final void d() {
        this.f16509e.j();
        long jA = this.f16509e.zzb().a();
        SharedPreferences.Editor editorEdit = this.f16509e.F().edit();
        editorEdit.remove(this.f16506b);
        editorEdit.remove(this.f16507c);
        editorEdit.putLong(this.f16505a, jA);
        editorEdit.apply();
    }
}
