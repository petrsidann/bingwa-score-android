package s6;

import com.google.crypto.tink.shaded.protobuf.q;
import e7.m;
import e7.y;
import f7.p;
import f7.r;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import r6.w;

/* JADX INFO: loaded from: classes.dex */
public final class f extends z6.d<e7.l> {

    public class a extends z6.k<r6.a, e7.l> {
        public a(Class cls) {
            super(cls);
        }

        @Override // z6.k
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public r6.a a(e7.l lVar) {
            return new f7.c(lVar.P().z());
        }
    }

    public class b extends z6.d.a<m, e7.l> {
        public b(Class cls) {
            super(cls);
        }

        @Override // z6.d.a
        public Map<String, z6.d.a.C0343a<m>> c() {
            HashMap map = new HashMap();
            r6.k.b bVar = r6.k.b.TINK;
            map.put("AES128_GCM", f.l(16, bVar));
            r6.k.b bVar2 = r6.k.b.RAW;
            map.put("AES128_GCM_RAW", f.l(16, bVar2));
            map.put("AES256_GCM", f.l(32, bVar));
            map.put("AES256_GCM_RAW", f.l(32, bVar2));
            return Collections.unmodifiableMap(map);
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public e7.l a(m mVar) {
            return e7.l.R().x(com.google.crypto.tink.shaded.protobuf.i.k(p.c(mVar.O()))).y(f.this.m()).build();
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public m d(com.google.crypto.tink.shaded.protobuf.i iVar) {
            return m.Q(iVar, q.b());
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void e(m mVar) throws InvalidAlgorithmParameterException {
            r.a(mVar.O());
        }
    }

    public f() {
        super(e7.l.class, new a(r6.a.class));
    }

    public static z6.d.a.C0343a<m> l(int i10, r6.k.b bVar) {
        return new z6.d.a.C0343a<>(m.P().x(i10).build(), bVar);
    }

    public static void o(boolean z10) {
        w.k(new f(), z10);
    }

    @Override // z6.d
    public w6.b.EnumC0311b a() {
        return w6.b.EnumC0311b.f17651b;
    }

    @Override // z6.d
    public String d() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    @Override // z6.d
    public z6.d.a<m, e7.l> f() {
        return new b(m.class);
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
    public e7.l h(com.google.crypto.tink.shaded.protobuf.i iVar) {
        return e7.l.S(iVar, q.b());
    }

    @Override // z6.d
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void j(e7.l lVar) throws GeneralSecurityException {
        r.c(lVar.Q(), m());
        r.a(lVar.P().size());
    }
}
