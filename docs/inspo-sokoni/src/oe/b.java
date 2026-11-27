package oe;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d.a f13847a = new d.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f13848b = -1234567890;

    public static final boolean a(byte[] a10, int i10, byte[] b10, int i11, int i12) {
        kotlin.jvm.internal.k.e(a10, "a");
        kotlin.jvm.internal.k.e(b10, "b");
        for (int i13 = 0; i13 < i12; i13++) {
            if (a10[i13 + i10] != b10[i13 + i11]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException("size=" + j10 + " offset=" + j11 + " byteCount=" + j12);
        }
    }

    public static final int c(g gVar, int i10) {
        kotlin.jvm.internal.k.e(gVar, "<this>");
        return i10 == f13848b ? gVar.y() : i10;
    }

    public static final String d(int i10) {
        if (i10 == 0) {
            return "0";
        }
        int i11 = 0;
        char[] cArr = {pe.b.d()[(i10 >> 28) & 15], pe.b.d()[(i10 >> 24) & 15], pe.b.d()[(i10 >> 20) & 15], pe.b.d()[(i10 >> 16) & 15], pe.b.d()[(i10 >> 12) & 15], pe.b.d()[(i10 >> 8) & 15], pe.b.d()[(i10 >> 4) & 15], pe.b.d()[i10 & 15]};
        while (i11 < 8 && cArr[i11] == '0') {
            i11++;
        }
        return ed.q.m(cArr, i11, 8);
    }
}
