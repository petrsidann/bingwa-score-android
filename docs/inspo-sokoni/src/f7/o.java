package f7;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: loaded from: classes.dex */
public class o implements r6.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d7.a f8236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8237b;

    public o(d7.a aVar, int i10) throws InvalidAlgorithmParameterException {
        this.f8236a = aVar;
        this.f8237b = i10;
        if (i10 < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        aVar.a(new byte[0], i10);
    }

    @Override // r6.s
    public void a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!f.b(b(bArr2), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    @Override // r6.s
    public byte[] b(byte[] bArr) {
        return this.f8236a.a(bArr, this.f8237b);
    }
}
