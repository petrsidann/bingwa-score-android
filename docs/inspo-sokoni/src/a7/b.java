package a7;

import com.google.crypto.tink.shaded.protobuf.q;
import e7.y;
import f7.o;
import f7.p;
import f7.r;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import r6.s;
import r6.w;

/* JADX INFO: loaded from: classes.dex */
public final class b extends z6.d<e7.a> {

    public class a extends z6.k<s, e7.a> {
        public a(Class cls) {
            super(cls);
        }

        @Override // z6.k
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public s a(e7.a aVar) {
            return new o(new f7.m(aVar.Q().z()), aVar.R().P());
        }
    }

    /* JADX INFO: renamed from: a7.b$b, reason: collision with other inner class name */
    public class C0008b extends z6.d.a<e7.b, e7.a> {
        public C0008b(Class cls) {
            super(cls);
        }

        @Override // z6.d.a
        public Map<String, z6.d.a.C0343a<e7.b>> c() {
            HashMap map = new HashMap();
            e7.b bVarBuild = e7.b.R().x(32).y(e7.c.Q().x(16).build()).build();
            r6.k.b bVar = r6.k.b.TINK;
            map.put("AES_CMAC", new z6.d.a.C0343a(bVarBuild, bVar));
            map.put("AES256_CMAC", new z6.d.a.C0343a(e7.b.R().x(32).y(e7.c.Q().x(16).build()).build(), bVar));
            map.put("AES256_CMAC_RAW", new z6.d.a.C0343a(e7.b.R().x(32).y(e7.c.Q().x(16).build()).build(), r6.k.b.RAW));
            return Collections.unmodifiableMap(map);
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public e7.a a(e7.b bVar) {
            return e7.a.T().z(0).x(com.google.crypto.tink.shaded.protobuf.i.k(p.c(bVar.P()))).y(bVar.Q()).build();
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public e7.b d(com.google.crypto.tink.shaded.protobuf.i iVar) {
            return e7.b.S(iVar, q.b());
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void e(e7.b bVar) throws GeneralSecurityException {
            b.q(bVar.Q());
            b.r(bVar.P());
        }
    }

    public b() {
        super(e7.a.class, new a(s.class));
    }

    public static void o(boolean z10) {
        w.k(new b(), z10);
        h.d();
    }

    public static void q(e7.c cVar) throws GeneralSecurityException {
        if (cVar.P() < 10) {
            throw new GeneralSecurityException("tag size too short");
        }
        if (cVar.P() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    public static void r(int i10) throws GeneralSecurityException {
        if (i10 != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    @Override // z6.d
    public String d() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    @Override // z6.d
    public z6.d.a<e7.b, e7.a> f() {
        return new C0008b(e7.b.class);
    }

    @Override // z6.d
    public y.c g() {
        return y.c.SYMMETRIC;
    }

    public int m() {
        return 0;
    }

    @Override // z6.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public e7.a h(com.google.crypto.tink.shaded.protobuf.i iVar) {
        return e7.a.U(iVar, q.b());
    }

    @Override // z6.d
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void j(e7.a aVar) throws GeneralSecurityException {
        r.c(aVar.S(), m());
        r(aVar.Q().size());
        q(aVar.R());
    }
}
