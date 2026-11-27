package o7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.internal.p002firebaseauthapi.zzaed;
import com.google.android.gms.internal.p002firebaseauthapi.zzafm;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.GenericIdpActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class n0 extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f13756a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FirebaseAuth f13757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bundle f13758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Bundle f13759c;

        public a(String str, FirebaseAuth firebaseAuth) {
            Bundle bundle = new Bundle();
            this.f13758b = bundle;
            Bundle bundle2 = new Bundle();
            this.f13759c = bundle2;
            this.f13757a = firebaseAuth;
            bundle.putString("com.google.firebase.auth.KEY_API_KEY", firebaseAuth.l().r().b());
            bundle.putString("com.google.firebase.auth.KEY_PROVIDER_ID", str);
            bundle.putBundle("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS", bundle2);
            bundle.putString("com.google.firebase.auth.internal.CLIENT_VERSION", zzaed.zza().zzb());
            bundle.putString("com.google.firebase.auth.KEY_TENANT_ID", firebaseAuth.q());
            bundle.putString("com.google.firebase.auth.KEY_FIREBASE_APP_NAME", firebaseAuth.l().q());
            bundle.putString("com.google.firebase.auth.KEY_CUSTOM_AUTH_DOMAIN", firebaseAuth.n());
        }

        public a a(Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f13759c.putString(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public n0 b() {
            return new n0(this.f13758b);
        }

        public a c(List<String> list) {
            this.f13758b.putStringArrayList("com.google.firebase.auth.KEY_PROVIDER_SCOPES", new ArrayList<>(list));
            return this;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f13760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f13762c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f13763d;

        public b(String str) {
            this.f13760a = str;
        }

        public h a() {
            return x1.a0(this.f13760a, this.f13761b, this.f13762c, this.f13763d);
        }

        public b b(String str) {
            this.f13762c = str;
            return this;
        }

        public b c(String str) {
            this.f13761b = str;
            return this;
        }

        public b d(String str, String str2) {
            this.f13761b = str;
            this.f13763d = str2;
            return this;
        }
    }

    public n0(Bundle bundle) {
        this.f13756a = bundle;
    }

    public static a d(String str) {
        return e(str, FirebaseAuth.getInstance());
    }

    public static a e(String str, FirebaseAuth firebaseAuth) {
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.l(firebaseAuth);
        if (!"facebook.com".equals(str) || zzafm.zza(firebaseAuth.l())) {
            return new a(str, firebaseAuth);
        }
        throw new IllegalArgumentException("Sign in with Facebook is not supported via this method; the Facebook TOS dictate that you must use the Facebook Android SDK for Facebook login.");
    }

    public static b f(String str) {
        return new b(com.google.android.gms.common.internal.r.f(str));
    }

    @Override // o7.n
    public final void a(Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_LINK");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.f13756a);
        activity.startActivity(intent);
    }

    @Override // o7.n
    public final void b(Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.f13756a);
        activity.startActivity(intent);
    }

    @Override // o7.n
    public final void c(Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.f13756a);
        activity.startActivity(intent);
    }
}
