package o7;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public final class f2 extends p7.s0<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f13729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f13730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f13731c;

    public f2(FirebaseAuth firebaseAuth, String str, e eVar) {
        this.f13729a = str;
        this.f13730b = eVar;
        this.f13731c = firebaseAuth;
    }

    @Override // p7.s0
    public final Task<Void> c(String str) {
        String str2;
        StringBuilder sb2;
        if (TextUtils.isEmpty(str)) {
            String str3 = this.f13729a;
            sb2 = new StringBuilder("Email link sign in for ");
            sb2.append(str3);
            str2 = " with empty reCAPTCHA token";
        } else {
            str2 = this.f13729a;
            sb2 = new StringBuilder("Got reCAPTCHA token for email link sign in for ");
        }
        sb2.append(str2);
        Log.i("FirebaseAuth", sb2.toString());
        return this.f13731c.f5383e.zzb(this.f13731c.f5379a, this.f13729a, this.f13730b, this.f13731c.f5389k, str);
    }
}
