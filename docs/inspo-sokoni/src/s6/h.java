package s6;

import com.google.crypto.tink.shaded.protobuf.q;
import e7.r;
import e7.s;
import e7.y;
import f7.p;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import r6.w;

/* JADX INFO: loaded from: classes.dex */
public class h extends z6.d<r> {

    public class a extends z6.k<r6.a, r> {
        public a(Class cls) {
            super(cls);
        }

        @Override // z6.k
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public r6.a a(r rVar) {
            return new f7.g(rVar.P().z());
        }
    }

    public class b extends z6.d.a<s, r> {
        public b(Class cls) {
            super(cls);
        }

        @Override // z6.d.a
        public Map<String, z6.d.a.C0343a<s>> c() {
            HashMap map = new HashMap();
            map.put("CHACHA20_POLY1305", new z6.d.a.C0343a(s.N(), r6.k.b.TINK));
            map.put("CHACHA20_POLY1305_RAW", new z6.d.a.C0343a(s.N(), r6.k.b.RAW));
            return Collections.unmodifiableMap(map);
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public r a(s sVar) {
            return r.R().y(h.this.k()).x(com.google.crypto.tink.shaded.protobuf.i.k(p.c(32))).build();
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public s d(com.google.crypto.tink.shaded.protobuf.i iVar) {
            return s.O(iVar, q.b());
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void e(s sVar) {
        }
    }

    public h() {
        super(r.class, new a(r6.a.class));
    }

    public static void m(boolean z10) {
        w.k(new h(), z10);
    }

    @Override // z6.d
    public String d() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    @Override // z6.d
    public z6.d.a<s, r> f() {
        return new b(s.class);
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
    public r h(com.google.crypto.tink.shaded.protobuf.i iVar) {
        return r.S(iVar, q.b());
    }

    @Override // z6.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void j(r rVar) throws GeneralSecurityException {
        f7.r.c(rVar.Q(), k());
        if (rVar.P().size() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }
}
