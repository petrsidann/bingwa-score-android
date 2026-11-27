package s6;

import com.google.crypto.tink.shaded.protobuf.q;
import e7.n;
import e7.o;
import e7.y;
import f7.p;
import f7.r;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import r6.w;

/* JADX INFO: loaded from: classes.dex */
public final class g extends z6.d<n> {

    public class a extends z6.k<r6.a, n> {
        public a(Class cls) {
            super(cls);
        }

        @Override // z6.k
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public r6.a a(n nVar) {
            return new u6.a(nVar.P().z());
        }
    }

    public class b extends z6.d.a<o, n> {
        public b(Class cls) {
            super(cls);
        }

        @Override // z6.d.a
        public Map<String, z6.d.a.C0343a<o>> c() {
            HashMap map = new HashMap();
            r6.k.b bVar = r6.k.b.TINK;
            map.put("AES128_GCM_SIV", g.m(16, bVar));
            r6.k.b bVar2 = r6.k.b.RAW;
            map.put("AES128_GCM_SIV_RAW", g.m(16, bVar2));
            map.put("AES256_GCM_SIV", g.m(32, bVar));
            map.put("AES256_GCM_SIV_RAW", g.m(32, bVar2));
            return Collections.unmodifiableMap(map);
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public n a(o oVar) {
            return n.R().x(com.google.crypto.tink.shaded.protobuf.i.k(p.c(oVar.O()))).y(g.this.n()).build();
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public o d(com.google.crypto.tink.shaded.protobuf.i iVar) {
            return o.Q(iVar, q.b());
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void e(o oVar) throws InvalidAlgorithmParameterException {
            r.a(oVar.O());
        }
    }

    public g() {
        super(n.class, new a(r6.a.class));
    }

    public static boolean l() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    public static z6.d.a.C0343a<o> m(int i10, r6.k.b bVar) {
        return new z6.d.a.C0343a<>(o.P().x(i10).build(), bVar);
    }

    public static void p(boolean z10) {
        if (l()) {
            w.k(new g(), z10);
        }
    }

    @Override // z6.d
    public String d() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    @Override // z6.d
    public z6.d.a<o, n> f() {
        return new b(o.class);
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
    public n h(com.google.crypto.tink.shaded.protobuf.i iVar) {
        return n.S(iVar, q.b());
    }

    @Override // z6.d
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void j(n nVar) throws GeneralSecurityException {
        r.c(nVar.Q(), n());
        r.a(nVar.P().size());
    }
}
