package f7;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
public final class n implements d7.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final w6.b.EnumC0311b f8230e = w6.b.EnumC0311b.f17651b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadLocal<Mac> f8231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Key f8233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8234d;

    public class a extends ThreadLocal<Mac> {
        public a() {
        }

        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Mac initialValue() {
            try {
                Mac macA = i.f8219f.a(n.this.f8232b);
                macA.init(n.this.f8233c);
                return macA;
            } catch (GeneralSecurityException e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    public n(String str, Key key) throws GeneralSecurityException {
        int i10;
        a aVar = new a();
        this.f8231a = aVar;
        if (!f8230e.d()) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.f8232b = str;
        this.f8233c = key;
        if (key.getEncoded().length < 16) {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        str.hashCode();
        switch (str) {
            case "HMACSHA1":
                i10 = 20;
                break;
            case "HMACSHA224":
                i10 = 28;
                break;
            case "HMACSHA256":
                i10 = 32;
                break;
            case "HMACSHA384":
                i10 = 48;
                break;
            case "HMACSHA512":
                i10 = 64;
                break;
            default:
                throw new NoSuchAlgorithmException("unknown Hmac algorithm: " + str);
        }
        this.f8234d = i10;
        aVar.get();
    }

    @Override // d7.a
    public byte[] a(byte[] bArr, int i10) throws InvalidAlgorithmParameterException {
        if (i10 > this.f8234d) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        this.f8231a.get().update(bArr);
        return Arrays.copyOf(this.f8231a.get().doFinal(), i10);
    }
}
