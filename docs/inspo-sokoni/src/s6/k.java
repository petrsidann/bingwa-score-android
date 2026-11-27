package s6;

import com.google.crypto.tink.shaded.protobuf.q;
import e7.g0;
import e7.h0;
import e7.y;
import java.security.GeneralSecurityException;
import r6.r;
import r6.w;

/* JADX INFO: loaded from: classes.dex */
public class k extends z6.d<g0> {

    public class a extends z6.k<r6.a, g0> {
        public a(Class cls) {
            super(cls);
        }

        @Override // z6.k
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public r6.a a(g0 g0Var) {
            String strP = g0Var.P().P();
            return new j(g0Var.P().O(), r.a(strP).b(strP));
        }
    }

    public class b extends z6.d.a<h0, g0> {
        public b(Class cls) {
            super(cls);
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public g0 a(h0 h0Var) {
            return g0.R().x(h0Var).y(k.this.k()).build();
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public h0 d(com.google.crypto.tink.shaded.protobuf.i iVar) {
            return h0.R(iVar, q.b());
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void e(h0 h0Var) throws GeneralSecurityException {
            if (h0Var.P().isEmpty() || !h0Var.Q()) {
                throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
            }
        }
    }

    public k() {
        super(g0.class, new a(r6.a.class));
    }

    public static void m(boolean z10) {
        w.k(new k(), z10);
    }

    @Override // z6.d
    public String d() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    @Override // z6.d
    public z6.d.a<h0, g0> f() {
        return new b(h0.class);
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
    public g0 h(com.google.crypto.tink.shaded.protobuf.i iVar) {
        return g0.S(iVar, q.b());
    }

    @Override // z6.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void j(g0 g0Var) throws GeneralSecurityException {
        f7.r.c(g0Var.Q(), k());
    }
}
