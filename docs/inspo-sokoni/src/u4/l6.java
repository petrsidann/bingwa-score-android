package u4;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public final class l6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f16477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f16478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ i6 f16480e;

    public l6(i6 i6Var, String str, boolean z10) {
        this.f16480e = i6Var;
        com.google.android.gms.common.internal.r.f(str);
        this.f16476a = str;
        this.f16477b = z10;
    }

    public final void a(boolean z10) {
        SharedPreferences.Editor editorEdit = this.f16480e.F().edit();
        editorEdit.putBoolean(this.f16476a, z10);
        editorEdit.apply();
        this.f16479d = z10;
    }

    public final boolean b() {
        if (!this.f16478c) {
            this.f16478c = true;
            this.f16479d = this.f16480e.F().getBoolean(this.f16476a, this.f16477b);
        }
        return this.f16479d;
    }
}
