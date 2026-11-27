package s6;

import com.google.crypto.tink.shaded.protobuf.q;
import e7.e0;
import e7.f0;
import e7.y;
import java.security.GeneralSecurityException;
import r6.r;
import r6.w;

/* JADX INFO: loaded from: classes.dex */
public class i extends z6.d<e0> {

    public class a extends z6.k<r6.a, e0> {
        public a(Class cls) {
            super(cls);
        }

        @Override // z6.k
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public r6.a a(e0 e0Var) {
            String strO = e0Var.P().O();
            return r.a(strO).b(strO);
        }
    }

    public class b extends z6.d.a<f0, e0> {
        public b(Class cls) {
            super(cls);
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public e0 a(f0 f0Var) {
            return e0.R().x(f0Var).y(i.this.k()).build();
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public f0 d(com.google.crypto.tink.shaded.protobuf.i iVar) {
            return f0.P(iVar, q.b());
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void e(f0 f0Var) {
        }
    }

    public i() {
        super(e0.class, new a(r6.a.class));
    }

    public static void m(boolean z10) {
        w.k(new i(), z10);
    }

    @Override // z6.d
    public String d() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    @Override // z6.d
    public z6.d.a<f0, e0> f() {
        return new b(f0.class);
    }

    @Override // z6.d
    public y.c g() {
        return y.c.REMOTE;
    }

    public int k() {
        return 0;
    }

    @Override // z6.d
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public e0 h(com.google.crypto.tink.shaded.protobuf.i iVar) {
        return e0.S(iVar, q.b());
    }

    @Override // z6.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void j(e0 e0Var) throws GeneralSecurityException {
        f7.r.c(e0Var.Q(), k());
    }
}
