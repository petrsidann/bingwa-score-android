package z6;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes.dex */
public final class q {
    public static Integer a() {
        return a.a();
    }

    public static int b() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        int i10 = 0;
        while (i10 == 0) {
            secureRandom.nextBytes(bArr);
            i10 = ((bArr[0] & 127) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return i10;
    }

    public static final byte c(char c10) {
        if (c10 >= '!' && c10 <= '~') {
            return (byte) c10;
        }
        throw new p("Not a printable ASCII character: " + c10);
    }

    public static final g7.a d(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i10 = 0; i10 < str.length(); i10++) {
            bArr[i10] = c(str.charAt(i10));
        }
        return g7.a.a(bArr);
    }
}
