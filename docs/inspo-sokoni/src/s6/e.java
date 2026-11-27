package s6;

import com.google.crypto.tink.shaded.protobuf.q;
import e7.y;
import f7.p;
import f7.r;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import r6.w;

/* JADX INFO: loaded from: classes.dex */
public final class e extends z6.d<e7.i> {

    public class a extends z6.k<r6.a, e7.i> {
        public a(Class cls) {
            super(cls);
        }

        @Override // z6.k
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public r6.a a(e7.i iVar) {
            return new f7.b(iVar.Q().z(), iVar.R().P());
        }
    }

    public class b extends z6.d.a<e7.j, e7.i> {
        public b(Class cls) {
            super(cls);
        }

        @Override // z6.d.a
        public Map<String, z6.d.a.C0343a<e7.j>> c() {
            HashMap map = new HashMap();
            r6.k.b bVar = r6.k.b.TINK;
            map.put("AES128_EAX", e.l(16, 16, bVar));
            r6.k.b bVar2 = r6.k.b.RAW;
            map.put("AES128_EAX_RAW", e.l(16, 16, bVar2));
            map.put("AES256_EAX", e.l(32, 16, bVar));
            map.put("AES256_EAX_RAW", e.l(32, 16, bVar2));
            return Collections.unmodifiableMap(map);
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public e7.i a(e7.j jVar) {
            return e7.i.T().x(com.google.crypto.tink.shaded.protobuf.i.k(p.c(jVar.P()))).y(jVar.Q()).z(e.this.m()).build();
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public e7.j d(com.google.crypto.tink.shaded.protobuf.i iVar) {
            return e7.j.S(iVar, q.b());
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void e(e7.j jVar) throws GeneralSecurityException {
            r.a(jVar.P());
            if (jVar.Q().P() != 12 && jVar.Q().P() != 16) {
                throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
            }
        }
    }

    public e() {
        super(e7.i.class, new a(r6.a.class));
    }

    public static z6.d.a.C0343a<e7.j> l(int i10, int i11, r6.k.b bVar) {
        return new z6.d.a.C0343a<>(e7.j.R().x(i10).y(e7.k.Q().x(i11).build()).build(), bVar);
    }

    public static void o(boolean z10) {
        w.k(new e(), z10);
    }

    @Override // z6.d
    public String d() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    @Override // z6.d
    public z6.d.a<e7.j, e7.i> f() {
        return new b(e7.j.class);
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
    public e7.i h(com.google.crypto.tink.shaded.protobuf.i iVar) {
        return e7.i.U(iVar, q.b());
    }

    @Override // z6.d
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void j(e7.i iVar) throws GeneralSecurityException {
        r.c(iVar.S(), m());
        r.a(iVar.Q().size());
        if (iVar.R().P() != 12 && iVar.R().P() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
