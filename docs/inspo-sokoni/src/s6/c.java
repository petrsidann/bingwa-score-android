package s6;

import com.google.crypto.tink.shaded.protobuf.q;
import e7.u;
import e7.v;
import e7.w;
import e7.x;
import e7.y;
import f7.r;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import r6.s;

/* JADX INFO: loaded from: classes.dex */
public final class c extends z6.d<e7.d> {

    public class a extends z6.k<r6.a, e7.d> {
        public a(Class cls) {
            super(cls);
        }

        @Override // z6.k
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public r6.a a(e7.d dVar) {
            return new f7.h((f7.l) new d().e(dVar.Q(), f7.l.class), (s) new a7.i().e(dVar.R(), s.class), dVar.R().S().R());
        }
    }

    public class b extends z6.d.a<e7.e, e7.d> {
        public b(Class cls) {
            super(cls);
        }

        @Override // z6.d.a
        public Map<String, z6.d.a.C0343a<e7.e>> c() {
            HashMap map = new HashMap();
            u uVar = u.SHA256;
            r6.k.b bVar = r6.k.b.TINK;
            map.put("AES128_CTR_HMAC_SHA256", c.m(16, 16, 32, 16, uVar, bVar));
            r6.k.b bVar2 = r6.k.b.RAW;
            map.put("AES128_CTR_HMAC_SHA256_RAW", c.m(16, 16, 32, 16, uVar, bVar2));
            map.put("AES256_CTR_HMAC_SHA256", c.m(32, 16, 32, 32, uVar, bVar));
            map.put("AES256_CTR_HMAC_SHA256_RAW", c.m(32, 16, 32, 32, uVar, bVar2));
            return Collections.unmodifiableMap(map);
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public e7.d a(e7.e eVar) {
            e7.f fVar = (e7.f) new d().f().a(eVar.P());
            return e7.d.T().x(fVar).y((v) new a7.i().f().a(eVar.Q())).z(c.this.n()).build();
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public e7.e d(com.google.crypto.tink.shaded.protobuf.i iVar) {
            return e7.e.S(iVar, q.b());
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void e(e7.e eVar) throws InvalidAlgorithmParameterException {
            new d().f().e(eVar.P());
            new a7.i().f().e(eVar.Q());
            r.a(eVar.P().Q());
        }
    }

    public c() {
        super(e7.d.class, new a(r6.a.class));
    }

    public static e7.e l(int i10, int i11, int i12, int i13, u uVar) {
        e7.g gVarBuild = e7.g.S().y(e7.h.Q().x(i11).build()).x(i10).build();
        return e7.e.R().x(gVarBuild).y(w.S().y(x.S().x(uVar).y(i13).build()).x(i12).build()).build();
    }

    public static z6.d.a.C0343a<e7.e> m(int i10, int i11, int i12, int i13, u uVar, r6.k.b bVar) {
        return new z6.d.a.C0343a<>(l(i10, i11, i12, i13, uVar), bVar);
    }

    public static void p(boolean z10) {
        r6.w.k(new c(), z10);
    }

    @Override // z6.d
    public w6.b.EnumC0311b a() {
        return w6.b.EnumC0311b.f17651b;
    }

    @Override // z6.d
    public String d() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // z6.d
    public z6.d.a<e7.e, e7.d> f() {
        return new b(e7.e.class);
    }

    @Override // z6.d
    public y.c g() {
        return y.c.SYMMETRIC;
    }

    public int n() {
        return 0;
    }

    @Override // z6.d
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public e7.d h(com.google.crypto.tink.shaded.protobuf.i iVar) {
        return e7.d.U(iVar, q.b());
    }

    @Override // z6.d
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void j(e7.d dVar) throws GeneralSecurityException {
        r.c(dVar.S(), n());
        new d().j(dVar.Q());
        new a7.i().j(dVar.R());
    }
}
