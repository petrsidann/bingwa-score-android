package oe;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient byte[][] f13900f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final transient int[] f13901l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(byte[][] segments, int[] directory) {
        super(g.f13872e.l());
        kotlin.jvm.internal.k.e(segments, "segments");
        kotlin.jvm.internal.k.e(directory, "directory");
        this.f13900f = segments;
        this.f13901l = directory;
    }

    @Override // oe.g
    public g A() {
        return G().A();
    }

    @Override // oe.g
    public byte[] B() {
        byte[] bArr = new byte[y()];
        int length = F().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int i13 = E()[length + i10];
            int i14 = E()[i10];
            int i15 = i14 - i11;
            mc.j.d(F()[i10], bArr, i12, i13, i13 + i15);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    @Override // oe.g
    public void D(d buffer, int i10, int i11) {
        kotlin.jvm.internal.k.e(buffer, "buffer");
        int i12 = i10 + i11;
        int iB = pe.c.b(this, i10);
        while (i10 < i12) {
            int i13 = iB == 0 ? 0 : E()[iB - 1];
            int i14 = E()[iB] - i13;
            int i15 = E()[F().length + iB];
            int iMin = Math.min(i12, i14 + i13) - i10;
            int i16 = i15 + (i10 - i13);
            o oVar = new o(F()[iB], i16, i16 + iMin, true, false);
            o oVar2 = buffer.f13862a;
            if (oVar2 == null) {
                oVar.f13894g = oVar;
                oVar.f13893f = oVar;
                buffer.f13862a = oVar;
            } else {
                kotlin.jvm.internal.k.b(oVar2);
                o oVar3 = oVar2.f13894g;
                kotlin.jvm.internal.k.b(oVar3);
                oVar3.c(oVar);
            }
            i10 += iMin;
            iB++;
        }
        buffer.i0(buffer.size() + ((long) i11));
    }

    public final int[] E() {
        return this.f13901l;
    }

    public final byte[][] F() {
        return this.f13900f;
    }

    public final g G() {
        return new g(B());
    }

    @Override // oe.g
    public String d() {
        return G().d();
    }

    @Override // oe.g
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (gVar.y() == y() && u(0, gVar, 0, y())) {
                return true;
            }
        }
        return false;
    }

    @Override // oe.g
    public int hashCode() {
        int iN = n();
        if (iN != 0) {
            return iN;
        }
        int length = F().length;
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        while (i10 < length) {
            int i13 = E()[length + i10];
            int i14 = E()[i10];
            byte[] bArr = F()[i10];
            int i15 = (i14 - i12) + i13;
            while (i13 < i15) {
                i11 = (i11 * 31) + bArr[i13];
                i13++;
            }
            i10++;
            i12 = i14;
        }
        w(i11);
        return i11;
    }

    @Override // oe.g
    public int o() {
        return E()[F().length - 1];
    }

    @Override // oe.g
    public String q() {
        return G().q();
    }

    @Override // oe.g
    public byte[] r() {
        return B();
    }

    @Override // oe.g
    public byte s(int i10) {
        b.b(E()[F().length - 1], i10, 1L);
        int iB = pe.c.b(this, i10);
        return F()[iB][(i10 - (iB == 0 ? 0 : E()[iB - 1])) + E()[F().length + iB]];
    }

    @Override // oe.g
    public String toString() {
        return G().toString();
    }

    @Override // oe.g
    public boolean u(int i10, g other, int i11, int i12) {
        kotlin.jvm.internal.k.e(other, "other");
        if (i10 < 0 || i10 > y() - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int iB = pe.c.b(this, i10);
        while (i10 < i13) {
            int i14 = iB == 0 ? 0 : E()[iB - 1];
            int i15 = E()[iB] - i14;
            int i16 = E()[F().length + iB];
            int iMin = Math.min(i13, i15 + i14) - i10;
            if (!other.v(i11, F()[iB], i16 + (i10 - i14), iMin)) {
                return false;
            }
            i11 += iMin;
            i10 += iMin;
            iB++;
        }
        return true;
    }

    @Override // oe.g
    public boolean v(int i10, byte[] other, int i11, int i12) {
        kotlin.jvm.internal.k.e(other, "other");
        if (i10 < 0 || i10 > y() - i12 || i11 < 0 || i11 > other.length - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int iB = pe.c.b(this, i10);
        while (i10 < i13) {
            int i14 = iB == 0 ? 0 : E()[iB - 1];
            int i15 = E()[iB] - i14;
            int i16 = E()[F().length + iB];
            int iMin = Math.min(i13, i15 + i14) - i10;
            if (!b.a(F()[iB], i16 + (i10 - i14), other, i11, iMin)) {
                return false;
            }
            i11 += iMin;
            i10 += iMin;
            iB++;
        }
        return true;
    }
}
