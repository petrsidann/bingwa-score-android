package h7;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.u;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f9711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f9712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f9713g;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f9715b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f9716c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f9717d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f9718e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f9719f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f9720g;

        public n a() {
            return new n(this.f9715b, this.f9714a, this.f9716c, this.f9717d, this.f9718e, this.f9719f, this.f9720g);
        }

        public b b(String str) {
            this.f9714a = r.g(str, "ApiKey must be set.");
            return this;
        }

        public b c(String str) {
            this.f9715b = r.g(str, "ApplicationId must be set.");
            return this;
        }

        public b d(String str) {
            this.f9716c = str;
            return this;
        }

        public b e(String str) {
            this.f9717d = str;
            return this;
        }

        public b f(String str) {
            this.f9718e = str;
            return this;
        }

        public b g(String str) {
            this.f9720g = str;
            return this;
        }

        public b h(String str) {
            this.f9719f = str;
            return this;
        }
    }

    public n(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        r.p(!j4.q.b(str), "ApplicationId must be set.");
        this.f9708b = str;
        this.f9707a = str2;
        this.f9709c = str3;
        this.f9710d = str4;
        this.f9711e = str5;
        this.f9712f = str6;
        this.f9713g = str7;
    }

    public static n a(Context context) {
        u uVar = new u(context);
        String strA = uVar.a("google_app_id");
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return new n(strA, uVar.a("google_api_key"), uVar.a("firebase_database_url"), uVar.a("ga_trackingId"), uVar.a("gcm_defaultSenderId"), uVar.a("google_storage_bucket"), uVar.a("project_id"));
    }

    public String b() {
        return this.f9707a;
    }

    public String c() {
        return this.f9708b;
    }

    public String d() {
        return this.f9709c;
    }

    public String e() {
        return this.f9710d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return com.google.android.gms.common.internal.p.b(this.f9708b, nVar.f9708b) && com.google.android.gms.common.internal.p.b(this.f9707a, nVar.f9707a) && com.google.android.gms.common.internal.p.b(this.f9709c, nVar.f9709c) && com.google.android.gms.common.internal.p.b(this.f9710d, nVar.f9710d) && com.google.android.gms.common.internal.p.b(this.f9711e, nVar.f9711e) && com.google.android.gms.common.internal.p.b(this.f9712f, nVar.f9712f) && com.google.android.gms.common.internal.p.b(this.f9713g, nVar.f9713g);
    }

    public String f() {
        return this.f9711e;
    }

    public String g() {
        return this.f9713g;
    }

    public String h() {
        return this.f9712f;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f9708b, this.f9707a, this.f9709c, this.f9710d, this.f9711e, this.f9712f, this.f9713g);
    }

    public String toString() {
        return com.google.android.gms.common.internal.p.d(this).a("applicationId", this.f9708b).a("apiKey", this.f9707a).a("databaseUrl", this.f9709c).a("gcmSenderId", this.f9711e).a("storageBucket", this.f9712f).a("projectId", this.f9713g).toString();
    }
}
