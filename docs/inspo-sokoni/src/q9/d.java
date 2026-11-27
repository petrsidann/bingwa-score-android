package q9;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public enum d {
    RSA_ECB_PKCS1Padding(new e() { // from class: q9.b
        @Override // q9.e
        public final a a(Context context) {
            return new f(context);
        }
    }, 1),
    RSA_ECB_OAEPwithSHA_256andMGF1Padding(new e() { // from class: q9.c
        @Override // q9.e
        public final a a(Context context) {
            return new g(context);
        }
    }, 23);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f14900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14901b;

    d(e eVar, int i10) {
        this.f14900a = eVar;
        this.f14901b = i10;
    }
}
