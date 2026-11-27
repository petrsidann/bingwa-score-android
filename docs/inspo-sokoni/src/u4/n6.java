package u4;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public final class n6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f16589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f16590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f16591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ i6 f16592e;

    public n6(i6 i6Var, String str, long j10) {
        this.f16592e = i6Var;
        com.google.android.gms.common.internal.r.f(str);
        this.f16588a = str;
        this.f16589b = j10;
    }

    public final long a() {
        if (!this.f16590c) {
            this.f16590c = true;
            this.f16591d = this.f16592e.F().getLong(this.f16588a, this.f16589b);
        }
        return this.f16591d;
    }

    public final void b(long j10) {
        SharedPreferences.Editor editorEdit = this.f16592e.F().edit();
        editorEdit.putLong(this.f16588a, j10);
        editorEdit.apply();
        this.f16591d = j10;
    }
}
