package s3;

import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p000authapi.zbl;
import z3.h;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final com.google.android.gms.common.api.a<c> f15432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a<C0271a> f15433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a<GoogleSignInOptions> f15434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final x3.a f15435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final u3.a f15436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final y3.a f15437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a.g f15438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a.g f15439h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a.AbstractC0072a f15440i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a.AbstractC0072a f15441j;

    /* JADX INFO: renamed from: s3.a$a, reason: collision with other inner class name */
    @Deprecated
    public static class C0271a implements com.google.android.gms.common.api.a.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final C0271a f15442d = new C0271a(new C0272a());

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f15443a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f15444b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f15445c;

        /* JADX INFO: renamed from: s3.a$a$a, reason: collision with other inner class name */
        @Deprecated
        public static class C0272a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Boolean f15446a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f15447b;

            public C0272a() {
                this.f15446a = Boolean.FALSE;
            }

            public C0272a(C0271a c0271a) {
                this.f15446a = Boolean.FALSE;
                C0271a.b(c0271a);
                this.f15446a = Boolean.valueOf(c0271a.f15444b);
                this.f15447b = c0271a.f15445c;
            }

            public final C0272a a(String str) {
                this.f15447b = str;
                return this;
            }
        }

        public C0271a(C0272a c0272a) {
            this.f15444b = c0272a.f15446a.booleanValue();
            this.f15445c = c0272a.f15447b;
        }

        public static /* bridge */ /* synthetic */ String b(C0271a c0271a) {
            String str = c0271a.f15443a;
            return null;
        }

        public final Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", null);
            bundle.putBoolean("force_save_dialog", this.f15444b);
            bundle.putString("log_session_id", this.f15445c);
            return bundle;
        }

        public final String d() {
            return this.f15445c;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0271a)) {
                return false;
            }
            C0271a c0271a = (C0271a) obj;
            String str = c0271a.f15443a;
            return p.b(null, null) && this.f15444b == c0271a.f15444b && p.b(this.f15445c, c0271a.f15445c);
        }

        public int hashCode() {
            return p.c(null, Boolean.valueOf(this.f15444b), this.f15445c);
        }
    }

    static {
        com.google.android.gms.common.api.a.g gVar = new com.google.android.gms.common.api.a.g();
        f15438g = gVar;
        com.google.android.gms.common.api.a.g gVar2 = new com.google.android.gms.common.api.a.g();
        f15439h = gVar2;
        d dVar = new d();
        f15440i = dVar;
        e eVar = new e();
        f15441j = eVar;
        f15432a = b.f15448a;
        f15433b = new com.google.android.gms.common.api.a<>("Auth.CREDENTIALS_API", dVar, gVar);
        f15434c = new com.google.android.gms.common.api.a<>("Auth.GOOGLE_SIGN_IN_API", eVar, gVar2);
        f15435d = b.f15449b;
        f15436e = new zbl();
        f15437f = new h();
    }
}
