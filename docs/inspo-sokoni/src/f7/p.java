package f7;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<SecureRandom> f8238a = new a();

    public class a extends ThreadLocal<SecureRandom> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SecureRandom initialValue() {
            return p.b();
        }
    }

    public static SecureRandom b() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public static byte[] c(int i10) {
        byte[] bArr = new byte[i10];
        f8238a.get().nextBytes(bArr);
        return bArr;
    }
}
