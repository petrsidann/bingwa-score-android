package oe;

/* JADX INFO: loaded from: classes2.dex */
public final class v {
    public static final byte[] a(String str) {
        kotlin.jvm.internal.k.e(str, "<this>");
        byte[] bytes = str.getBytes(ed.c.f7904b);
        kotlin.jvm.internal.k.d(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final String b(byte[] bArr) {
        kotlin.jvm.internal.k.e(bArr, "<this>");
        return new String(bArr, ed.c.f7904b);
    }
}
