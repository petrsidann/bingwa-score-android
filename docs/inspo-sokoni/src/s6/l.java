package s6;

import com.google.crypto.tink.shaded.protobuf.q;
import e7.k0;
import e7.l0;
import e7.y;
import f7.p;
import f7.r;
import f7.s;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import r6.w;

/* JADX INFO: loaded from: classes.dex */
public class l extends z6.d<k0> {

    public class a extends z6.k<r6.a, k0> {
        public a(Class cls) {
            super(cls);
        }

        @Override // z6.k
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public r6.a a(k0 k0Var) {
            return new s(k0Var.P().z());
        }
    }

    public class b extends z6.d.a<l0, k0> {
        public b(Class cls) {
            super(cls);
        }

        @Override // z6.d.a
        public Map<String, z6.d.a.C0343a<l0>> c() {
            HashMap map = new HashMap();
            map.put("XCHACHA20_POLY1305", new z6.d.a.C0343a(l0.N(), r6.k.b.TINK));
            map.put("XCHACHA20_POLY1305_RAW", new z6.d.a.C0343a(l0.N(), r6.k.b.RAW));
            return Collections.unmodifiableMap(map);
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public k0 a(l0 l0Var) {
            return k0.R().y(l.this.k()).x(com.google.crypto.tink.shaded.protobuf.i.k(p.c(32))).build();
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public l0 d(com.google.crypto.tink.shaded.protobuf.i iVar) {
            return l0.O(iVar, q.b());
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void e(l0 l0Var) {
        }
    }

    public l() {
        super(k0.class, new a(r6.a.class));
    }

    public static void m(boolean z10) {
        w.k(new l(), z10);
    }

    @Override // z6.d
    public String d() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    @Override // z6.d
    public z6.d.a<l0, k0> f() {
        return new b(l0.class);
    }

    @Override // z6.d
    public y.c g() {
        return y.c.SYMMETRIC;
    }

    public int k() {
        return 0;
    }

    @Override // z6.d
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public k0 h(com.google.crypto.tink.shaded.protobuf.i iVar) {
        return k0.S(iVar, q.b());
    }

    @Override // z6.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void j(k0 k0Var) throws GeneralSecurityException {
        r.c(k0Var.Q(), k());
        if (k0Var.P().size() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }
}
