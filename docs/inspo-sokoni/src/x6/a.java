package x6;

import com.google.crypto.tink.shaded.protobuf.i;
import e7.p;
import e7.q;
import e7.y;
import f7.r;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import r6.w;
import z6.d;
import z6.k;

/* JADX INFO: loaded from: classes.dex */
public final class a extends d<p> {

    /* JADX INFO: renamed from: x6.a$a, reason: collision with other inner class name */
    public class C0320a extends k<r6.d, p> {
        public C0320a(Class cls) {
            super(cls);
        }

        @Override // z6.k
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public r6.d a(p pVar) {
            return new f7.d(pVar.P().z());
        }
    }

    public class b extends d.a<q, p> {
        public b(Class cls) {
            super(cls);
        }

        @Override // z6.d.a
        public Map<String, d.a.C0343a<q>> c() {
            HashMap map = new HashMap();
            map.put("AES256_SIV", new d.a.C0343a(q.P().x(64).build(), r6.k.b.TINK));
            map.put("AES256_SIV_RAW", new d.a.C0343a(q.P().x(64).build(), r6.k.b.RAW));
            return Collections.unmodifiableMap(map);
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public p a(q qVar) {
            return p.R().x(i.k(f7.p.c(qVar.O()))).y(a.this.k()).build();
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public q d(i iVar) {
            return q.Q(iVar, com.google.crypto.tink.shaded.protobuf.q.b());
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void e(q qVar) throws InvalidAlgorithmParameterException {
            if (qVar.O() == 64) {
                return;
            }
            throw new InvalidAlgorithmParameterException("invalid key size: " + qVar.O() + ". Valid keys must have 64 bytes.");
        }
    }

    public a() {
        super(p.class, new C0320a(r6.d.class));
    }

    public static void m(boolean z10) {
        w.k(new a(), z10);
    }

    @Override // z6.d
    public String d() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    @Override // z6.d
    public d.a<q, p> f() {
        return new b(q.class);
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
    public p h(i iVar) {
        return p.S(iVar, com.google.crypto.tink.shaded.protobuf.q.b());
    }

    @Override // z6.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void j(p pVar) throws GeneralSecurityException {
        r.c(pVar.Q(), k());
        if (pVar.P().size() == 64) {
            return;
        }
        throw new InvalidKeyException("invalid key size: " + pVar.P().size() + ". Valid keys must have 64 bytes.");
    }
}
