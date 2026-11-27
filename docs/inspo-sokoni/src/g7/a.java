package g7;

import f7.k;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f8665a;

    public a(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        this.f8665a = bArr2;
        System.arraycopy(bArr, i10, bArr2, 0, i11);
    }

    public static a a(byte[] bArr) {
        if (bArr != null) {
            return b(bArr, 0, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public static a b(byte[] bArr, int i10, int i11) {
        if (bArr != null) {
            return new a(bArr, i10, i11);
        }
        throw new NullPointerException("data must be non-null");
    }

    public int c() {
        return this.f8665a.length;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return Arrays.equals(((a) obj).f8665a, this.f8665a);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f8665a);
    }

    public String toString() {
        return "Bytes(" + k.b(this.f8665a) + ")";
    }
}
