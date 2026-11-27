package f7;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class c implements r6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w6.b.EnumC0311b f8186b = w6.b.EnumC0311b.f17651b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t6.b f8187a;

    public c(byte[] bArr) throws GeneralSecurityException {
        if (!f8186b.d()) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.f8187a = new t6.b(bArr, true);
    }

    @Override // r6.a
    public byte[] a(byte[] bArr, byte[] bArr2) {
        return this.f8187a.b(p.c(12), bArr, bArr2);
    }

    @Override // r6.a
    public byte[] b(byte[] bArr, byte[] bArr2) {
        return this.f8187a.a(Arrays.copyOf(bArr, 12), bArr, bArr2);
    }
}
