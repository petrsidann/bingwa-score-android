package q9;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public enum l {
    AES_CBC_PKCS7Padding(new n() { // from class: q9.j
        @Override // q9.n
        public final i a(Context context, a aVar) {
            return new h(context, aVar);
        }
    }, 1),
    AES_GCM_NoPadding(new n() { // from class: q9.k
        @Override // q9.n
        public final i a(Context context, a aVar) {
            return new o(context, aVar);
        }
    }, 23);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f14910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14911b;

    l(n nVar, int i10) {
        this.f14910a = nVar;
        this.f14911b = i10;
    }
}
