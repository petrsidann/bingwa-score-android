package s6;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;
import r6.u;
import r6.v;
import r6.w;

/* JADX INFO: loaded from: classes.dex */
public class b implements v<r6.a, r6.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f15570a = Logger.getLogger(b.class.getName());

    /* JADX INFO: renamed from: s6.b$b, reason: collision with other inner class name */
    public static class C0274b implements r6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u<r6.a> f15571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c7.b.a f15572b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c7.b.a f15573c;

        public C0274b(u<r6.a> uVar) {
            c7.b.a aVarA;
            this.f15571a = uVar;
            if (uVar.i()) {
                c7.b bVarA = z6.g.b().a();
                c7.c cVarA = z6.f.a(uVar);
                this.f15572b = bVarA.a(cVarA, "aead", "encrypt");
                aVarA = bVarA.a(cVarA, "aead", "decrypt");
            } else {
                aVarA = z6.f.f20317a;
                this.f15572b = aVarA;
            }
            this.f15573c = aVarA;
        }

        @Override // r6.a
        public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            try {
                byte[] bArrA = f7.f.a(this.f15571a.e().a(), this.f15571a.e().f().a(bArr, bArr2));
                this.f15572b.b(this.f15571a.e().c(), bArr.length);
                return bArrA;
            } catch (GeneralSecurityException e10) {
                this.f15572b.a();
                throw e10;
            }
        }

        @Override // r6.a
        public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (u.c<r6.a> cVar : this.f15571a.f(bArrCopyOf)) {
                    try {
                        byte[] bArrB = cVar.f().b(bArrCopyOfRange, bArr2);
                        this.f15573c.b(cVar.c(), bArrCopyOfRange.length);
                        return bArrB;
                    } catch (GeneralSecurityException e10) {
                        b.f15570a.info("ciphertext prefix matches a key, but cannot decrypt: " + e10);
                    }
                }
            }
            for (u.c<r6.a> cVar2 : this.f15571a.h()) {
                try {
                    byte[] bArrB2 = cVar2.f().b(bArr, bArr2);
                    this.f15573c.b(cVar2.c(), bArr.length);
                    return bArrB2;
                } catch (GeneralSecurityException unused) {
                }
            }
            this.f15573c.a();
            throw new GeneralSecurityException("decryption failed");
        }
    }

    public static void e() {
        w.m(new b());
    }

    @Override // r6.v
    public Class<r6.a> a() {
        return r6.a.class;
    }

    @Override // r6.v
    public Class<r6.a> b() {
        return r6.a.class;
    }

    @Override // r6.v
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public r6.a c(u<r6.a> uVar) {
        return new C0274b(uVar);
    }
}
