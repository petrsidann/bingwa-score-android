package y6;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import e7.c0;
import e7.t;
import f7.k;
import java.io.IOException;
import r6.p;

/* JADX INFO: loaded from: classes.dex */
public final class e implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences.Editor f19410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19411b;

    public e(Context context, String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        this.f19411b = str;
        Context applicationContext = context.getApplicationContext();
        this.f19410a = (str2 == null ? PreferenceManager.getDefaultSharedPreferences(applicationContext) : applicationContext.getSharedPreferences(str2, 0)).edit();
    }

    @Override // r6.p
    public void a(t tVar) throws IOException {
        if (!this.f19410a.putString(this.f19411b, k.b(tVar.i())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }

    @Override // r6.p
    public void b(c0 c0Var) throws IOException {
        if (!this.f19410a.putString(this.f19411b, k.b(c0Var.i())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }
}
