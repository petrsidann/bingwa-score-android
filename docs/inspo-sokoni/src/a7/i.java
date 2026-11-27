package a7;

import com.google.crypto.tink.shaded.protobuf.q;
import e7.u;
import e7.v;
import e7.w;
import e7.x;
import e7.y;
import f7.n;
import f7.o;
import f7.p;
import f7.r;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;
import r6.s;

/* JADX INFO: loaded from: classes.dex */
public final class i extends z6.d<v> {

    public class a extends z6.k<s, v> {
        public a(Class cls) {
            super(cls);
        }

        @Override // z6.k
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public s a(v vVar) throws GeneralSecurityException {
            u uVarQ = vVar.S().Q();
            SecretKeySpec secretKeySpec = new SecretKeySpec(vVar.R().z(), "HMAC");
            int iR = vVar.S().R();
            int i10 = c.f408a[uVarQ.ordinal()];
            if (i10 == 1) {
                return new o(new n("HMACSHA1", secretKeySpec), iR);
            }
            if (i10 == 2) {
                return new o(new n("HMACSHA224", secretKeySpec), iR);
            }
            if (i10 == 3) {
                return new o(new n("HMACSHA256", secretKeySpec), iR);
            }
            if (i10 == 4) {
                return new o(new n("HMACSHA384", secretKeySpec), iR);
            }
            if (i10 == 5) {
                return new o(new n("HMACSHA512", secretKeySpec), iR);
            }
            throw new GeneralSecurityException("unknown hash");
        }
    }

    public class b extends z6.d.a<w, v> {
        public b(Class cls) {
            super(cls);
        }

        @Override // z6.d.a
        public Map<String, z6.d.a.C0343a<w>> c() {
            HashMap map = new HashMap();
            u uVar = u.SHA256;
            r6.k.b bVar = r6.k.b.TINK;
            map.put("HMAC_SHA256_128BITTAG", i.m(32, 16, uVar, bVar));
            r6.k.b bVar2 = r6.k.b.RAW;
            map.put("HMAC_SHA256_128BITTAG_RAW", i.m(32, 16, uVar, bVar2));
            map.put("HMAC_SHA256_256BITTAG", i.m(32, 32, uVar, bVar));
            map.put("HMAC_SHA256_256BITTAG_RAW", i.m(32, 32, uVar, bVar2));
            u uVar2 = u.SHA512;
            map.put("HMAC_SHA512_128BITTAG", i.m(64, 16, uVar2, bVar));
            map.put("HMAC_SHA512_128BITTAG_RAW", i.m(64, 16, uVar2, bVar2));
            map.put("HMAC_SHA512_256BITTAG", i.m(64, 32, uVar2, bVar));
            map.put("HMAC_SHA512_256BITTAG_RAW", i.m(64, 32, uVar2, bVar2));
            map.put("HMAC_SHA512_512BITTAG", i.m(64, 64, uVar2, bVar));
            map.put("HMAC_SHA512_512BITTAG_RAW", i.m(64, 64, uVar2, bVar2));
            return Collections.unmodifiableMap(map);
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public v a(w wVar) {
            return v.U().z(i.this.n()).y(wVar.R()).x(com.google.crypto.tink.shaded.protobuf.i.k(p.c(wVar.Q()))).build();
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public w d(com.google.crypto.tink.shaded.protobuf.i iVar) {
            return w.T(iVar, q.b());
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void e(w wVar) throws GeneralSecurityException {
            if (wVar.Q() < 16) {
                throw new GeneralSecurityException("key too short");
            }
            i.r(wVar.R());
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f408a;

        static {
            int[] iArr = new int[u.values().length];
            f408a = iArr;
            try {
                iArr[u.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f408a[u.SHA224.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f408a[u.SHA256.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f408a[u.SHA384.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f408a[u.SHA512.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public i() {
        super(v.class, new a(s.class));
    }

    public static z6.d.a.C0343a<w> m(int i10, int i11, u uVar, r6.k.b bVar) {
        return new z6.d.a.C0343a<>(w.S().y(x.S().x(uVar).y(i11).build()).x(i10).build(), bVar);
    }

    public static void p(boolean z10) {
        r6.w.k(new i(), z10);
    }

    public static void r(x xVar) throws GeneralSecurityException {
        if (xVar.R() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int i10 = c.f408a[xVar.Q().ordinal()];
        if (i10 == 1) {
            if (xVar.R() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (i10 == 2) {
            if (xVar.R() > 28) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (i10 == 3) {
            if (xVar.R() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (i10 == 4) {
            if (xVar.R() > 48) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            if (i10 != 5) {
                throw new GeneralSecurityException("unknown hash type");
            }
            if (xVar.R() > 64) {
                throw new GeneralSecurityException("tag size too big");
            }
        }
    }

    @Override // z6.d
    public w6.b.EnumC0311b a() {
        return w6.b.EnumC0311b.f17651b;
    }

    @Override // z6.d
    public String d() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // z6.d
    public z6.d.a<w, v> f() {
        return new b(w.class);
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
    public v h(com.google.crypto.tink.shaded.protobuf.i iVar) {
        return v.V(iVar, q.b());
    }

    @Override // z6.d
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void j(v vVar) throws GeneralSecurityException {
        r.c(vVar.T(), n());
        if (vVar.R().size() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        r(vVar.S());
    }
}
