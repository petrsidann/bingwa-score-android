package x6;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;
import r6.d;
import r6.u;
import r6.v;
import r6.w;
import z6.f;
import z6.g;

/* JADX INFO: loaded from: classes.dex */
public class c implements v<d, d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f18010a = Logger.getLogger(c.class.getName());

    public static class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u<d> f18011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c7.b.a f18012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c7.b.a f18013c;

        public a(u<d> uVar) {
            c7.b.a aVarA;
            this.f18011a = uVar;
            if (uVar.i()) {
                c7.b bVarA = g.b().a();
                c7.c cVarA = f.a(uVar);
                this.f18012b = bVarA.a(cVarA, "daead", "encrypt");
                aVarA = bVarA.a(cVarA, "daead", "decrypt");
            } else {
                aVarA = f.f20317a;
                this.f18012b = aVarA;
            }
            this.f18013c = aVarA;
        }

        @Override // r6.d
        public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            try {
                byte[] bArrA = f7.f.a(this.f18011a.e().a(), this.f18011a.e().f().a(bArr, bArr2));
                this.f18012b.b(this.f18011a.e().c(), bArr.length);
                return bArrA;
            } catch (GeneralSecurityException e10) {
                this.f18012b.a();
                throw e10;
            }
        }

        @Override // r6.d
        public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (u.c<d> cVar : this.f18011a.f(bArrCopyOf)) {
                    try {
                        byte[] bArrB = cVar.f().b(bArrCopyOfRange, bArr2);
                        this.f18013c.b(cVar.c(), bArrCopyOfRange.length);
                        return bArrB;
                    } catch (GeneralSecurityException e10) {
                        c.f18010a.info("ciphertext prefix matches a key, but cannot decrypt: " + e10);
                    }
                }
            }
            for (u.c<d> cVar2 : this.f18011a.h()) {
                try {
                    byte[] bArrB2 = cVar2.f().b(bArr, bArr2);
                    this.f18013c.b(cVar2.c(), bArr.length);
                    return bArrB2;
                } catch (GeneralSecurityException unused) {
                }
            }
            this.f18013c.a();
            throw new GeneralSecurityException("decryption failed");
        }
    }

    public static void e() {
        w.m(new c());
    }

    @Override // r6.v
    public Class<d> a() {
        return d.class;
    }

    @Override // r6.v
    public Class<d> b() {
        return d.class;
    }

    @Override // r6.v
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public d c(u<d> uVar) {
        return new a(uVar);
    }
}
