package a7;

import e7.i0;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import r6.s;
import r6.u;
import r6.v;
import r6.w;

/* JADX INFO: loaded from: classes.dex */
public class m implements v<s, s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f413a = Logger.getLogger(m.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f414b = {0};

    public static class b implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u<s> f415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c7.b.a f416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c7.b.a f417c;

        public b(u<s> uVar) {
            c7.b.a aVarA;
            this.f415a = uVar;
            if (uVar.i()) {
                c7.b bVarA = z6.g.b().a();
                c7.c cVarA = z6.f.a(uVar);
                this.f416b = bVarA.a(cVarA, "mac", "compute");
                aVarA = bVarA.a(cVarA, "mac", "verify");
            } else {
                aVarA = z6.f.f20317a;
                this.f416b = aVarA;
            }
            this.f417c = aVarA;
        }

        @Override // r6.s
        public void a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length <= 5) {
                this.f417c.a();
                throw new GeneralSecurityException("tag too short");
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
            for (u.c<s> cVar : this.f415a.f(bArrCopyOf)) {
                byte[] bArrA = cVar.d().equals(i0.LEGACY) ? f7.f.a(bArr2, m.f414b) : bArr2;
                try {
                    cVar.f().a(bArrCopyOfRange, bArrA);
                    this.f417c.b(cVar.c(), bArrA.length);
                    return;
                } catch (GeneralSecurityException e10) {
                    m.f413a.info("tag prefix matches a key, but cannot verify: " + e10);
                }
            }
            for (u.c<s> cVar2 : this.f415a.h()) {
                try {
                    cVar2.f().a(bArr, bArr2);
                    this.f417c.b(cVar2.c(), bArr2.length);
                    return;
                } catch (GeneralSecurityException unused) {
                }
            }
            this.f417c.a();
            throw new GeneralSecurityException("invalid MAC");
        }

        @Override // r6.s
        public byte[] b(byte[] bArr) throws GeneralSecurityException {
            if (this.f415a.e().d().equals(i0.LEGACY)) {
                bArr = f7.f.a(bArr, m.f414b);
            }
            try {
                byte[] bArrA = f7.f.a(this.f415a.e().a(), this.f415a.e().f().b(bArr));
                this.f416b.b(this.f415a.e().c(), bArr.length);
                return bArrA;
            } catch (GeneralSecurityException e10) {
                this.f416b.a();
                throw e10;
            }
        }
    }

    public static void f() {
        w.m(new m());
    }

    @Override // r6.v
    public Class<s> a() {
        return s.class;
    }

    @Override // r6.v
    public Class<s> b() {
        return s.class;
    }

    public final void g(u<s> uVar) throws GeneralSecurityException {
        Iterator<List<u.c<s>>> it = uVar.c().iterator();
        while (it.hasNext()) {
            for (u.c<s> cVar : it.next()) {
                if (cVar.b() instanceof k) {
                    k kVar = (k) cVar.b();
                    g7.a aVarA = g7.a.a(cVar.a());
                    if (!aVarA.equals(kVar.b())) {
                        throw new GeneralSecurityException("Mac Key with parameters " + kVar.a() + " has wrong output prefix (" + kVar.b() + ") instead of (" + aVarA + ")");
                    }
                }
            }
        }
    }

    @Override // r6.v
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public s c(u<s> uVar) throws GeneralSecurityException {
        g(uVar);
        return new b(uVar);
    }
}
