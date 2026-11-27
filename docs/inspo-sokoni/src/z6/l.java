package z6;

import e7.i0;
import e7.y;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class l implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g7.a f20332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.crypto.tink.shaded.protobuf.i f20333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y.c f20334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i0 f20335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f20336f;

    public l(String str, com.google.crypto.tink.shaded.protobuf.i iVar, y.c cVar, i0 i0Var, Integer num) {
        this.f20331a = str;
        this.f20332b = q.d(str);
        this.f20333c = iVar;
        this.f20334d = cVar;
        this.f20335e = i0Var;
        this.f20336f = num;
    }

    public static l b(String str, com.google.crypto.tink.shaded.protobuf.i iVar, y.c cVar, i0 i0Var, Integer num) throws GeneralSecurityException {
        if (i0Var == i0.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new l(str, iVar, cVar, i0Var, num);
    }

    @Override // z6.n
    public g7.a a() {
        return this.f20332b;
    }

    public Integer c() {
        return this.f20336f;
    }

    public y.c d() {
        return this.f20334d;
    }

    public i0 e() {
        return this.f20335e;
    }

    public String f() {
        return this.f20331a;
    }

    public com.google.crypto.tink.shaded.protobuf.i g() {
        return this.f20333c;
    }
}
