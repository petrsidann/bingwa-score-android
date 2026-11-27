package o7;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public final class d2 extends p7.s0<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f13698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f13699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f13700c;

    public d2(FirebaseAuth firebaseAuth, String str, e eVar) {
        this.f13698a = str;
        this.f13699b = eVar;
        this.f13700c = firebaseAuth;
    }

    @Override // p7.s0
    public final Task<Void> c(String str) {
        String str2;
        StringBuilder sb2;
        if (TextUtils.isEmpty(str)) {
            String str3 = this.f13698a;
            sb2 = new StringBuilder("Password reset request ");
            sb2.append(str3);
            str2 = " with empty reCAPTCHA token";
        } else {
            str2 = this.f13698a;
            sb2 = new StringBuilder("Got reCAPTCHA token for password reset of email ");
        }
        sb2.append(str2);
        Log.i("FirebaseAuth", sb2.toString());
        return this.f13700c.f5383e.zza(this.f13700c.f5379a, this.f13698a, this.f13699b, this.f13700c.f5389k, str);
    }
}
