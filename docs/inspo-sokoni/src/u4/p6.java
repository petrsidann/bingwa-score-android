package u4;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public final class p6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i6 f16697d;

    public p6(i6 i6Var, String str, String str2) {
        this.f16697d = i6Var;
        com.google.android.gms.common.internal.r.f(str);
        this.f16694a = str;
    }

    public final String a() {
        if (!this.f16695b) {
            this.f16695b = true;
            this.f16696c = this.f16697d.F().getString(this.f16694a, null);
        }
        return this.f16696c;
    }

    public final void b(String str) {
        SharedPreferences.Editor editorEdit = this.f16697d.F().edit();
        editorEdit.putString(this.f16694a, str);
        editorEdit.apply();
        this.f16696c = str;
    }
}
