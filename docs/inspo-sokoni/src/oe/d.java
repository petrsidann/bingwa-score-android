package oe;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements f, e, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f13862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f13863b;

    public static final class a implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f13864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public o f13865b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f13867d;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f13866c = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f13868e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f13869f = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!(this.f13864a != null)) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.f13864a = null;
            d(null);
            this.f13866c = -1L;
            this.f13867d = null;
            this.f13868e = -1;
            this.f13869f = -1;
        }

        public final void d(o oVar) {
            this.f13865b = oVar;
        }
    }

    public static final class b extends OutputStream {
        public b() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return d.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
            d.this.writeByte(i10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] data, int i10, int i11) {
            kotlin.jvm.internal.k.e(data, "data");
            d.this.o0(data, i10, i11);
        }
    }

    public final d C() {
        d dVar = new d();
        if (size() != 0) {
            o oVar = this.f13862a;
            kotlin.jvm.internal.k.b(oVar);
            o oVarD = oVar.d();
            dVar.f13862a = oVarD;
            oVarD.f13894g = oVarD;
            oVarD.f13893f = oVarD;
            for (o oVar2 = oVar.f13893f; oVar2 != oVar; oVar2 = oVar2.f13893f) {
                o oVar3 = oVarD.f13894g;
                kotlin.jvm.internal.k.b(oVar3);
                kotlin.jvm.internal.k.b(oVar2);
                oVar3.c(oVar2.d());
            }
            dVar.i0(size());
        }
        return dVar;
    }

    public final d D(d out, long j10, long j11) {
        kotlin.jvm.internal.k.e(out, "out");
        oe.b.b(size(), j10, j11);
        if (j11 != 0) {
            out.i0(out.size() + j11);
            o oVar = this.f13862a;
            while (true) {
                kotlin.jvm.internal.k.b(oVar);
                int i10 = oVar.f13890c;
                int i11 = oVar.f13889b;
                if (j10 < i10 - i11) {
                    break;
                }
                j10 -= (long) (i10 - i11);
                oVar = oVar.f13893f;
            }
            while (j11 > 0) {
                kotlin.jvm.internal.k.b(oVar);
                o oVarD = oVar.d();
                int i12 = oVarD.f13889b + ((int) j10);
                oVarD.f13889b = i12;
                oVarD.f13890c = Math.min(i12 + ((int) j11), oVarD.f13890c);
                o oVar2 = out.f13862a;
                if (oVar2 == null) {
                    oVarD.f13894g = oVarD;
                    oVarD.f13893f = oVarD;
                    out.f13862a = oVarD;
                } else {
                    kotlin.jvm.internal.k.b(oVar2);
                    o oVar3 = oVar2.f13894g;
                    kotlin.jvm.internal.k.b(oVar3);
                    oVar3.c(oVarD);
                }
                j11 -= (long) (oVarD.f13890c - oVarD.f13889b);
                oVar = oVar.f13893f;
                j10 = 0;
            }
        }
        return this;
    }

    public final byte E(long j10) {
        oe.b.b(size(), j10, 1L);
        o oVar = this.f13862a;
        if (oVar == null) {
            kotlin.jvm.internal.k.b(null);
            throw null;
        }
        if (size() - j10 < j10) {
            long size = size();
            while (size > j10) {
                oVar = oVar.f13894g;
                kotlin.jvm.internal.k.b(oVar);
                size -= (long) (oVar.f13890c - oVar.f13889b);
            }
            kotlin.jvm.internal.k.b(oVar);
            return oVar.f13888a[(int) ((((long) oVar.f13889b) + j10) - size)];
        }
        long j11 = 0;
        while (true) {
            long j12 = ((long) (oVar.f13890c - oVar.f13889b)) + j11;
            if (j12 > j10) {
                kotlin.jvm.internal.k.b(oVar);
                return oVar.f13888a[(int) ((((long) oVar.f13889b) + j10) - j11)];
            }
            oVar = oVar.f13893f;
            kotlin.jvm.internal.k.b(oVar);
            j11 = j12;
        }
    }

    @Override // oe.f
    public byte[] H(long j10) throws EOFException {
        if (!(j10 >= 0 && j10 <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        }
        if (size() < j10) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j10];
        c0(bArr);
        return bArr;
    }

    public long I(byte b10, long j10, long j11) {
        o oVar;
        int i10;
        long size = 0;
        boolean z10 = false;
        if (0 <= j10 && j10 <= j11) {
            z10 = true;
        }
        if (!z10) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j10 + " toIndex=" + j11).toString());
        }
        if (j11 > size()) {
            j11 = size();
        }
        if (j10 == j11 || (oVar = this.f13862a) == null) {
            return -1L;
        }
        if (size() - j10 < j10) {
            size = size();
            while (size > j10) {
                oVar = oVar.f13894g;
                kotlin.jvm.internal.k.b(oVar);
                size -= (long) (oVar.f13890c - oVar.f13889b);
            }
            while (size < j11) {
                byte[] bArr = oVar.f13888a;
                int iMin = (int) Math.min(oVar.f13890c, (((long) oVar.f13889b) + j11) - size);
                i10 = (int) ((((long) oVar.f13889b) + j10) - size);
                while (i10 < iMin) {
                    if (bArr[i10] != b10) {
                        i10++;
                    }
                }
                size += (long) (oVar.f13890c - oVar.f13889b);
                oVar = oVar.f13893f;
                kotlin.jvm.internal.k.b(oVar);
                j10 = size;
            }
            return -1L;
        }
        while (true) {
            long j12 = ((long) (oVar.f13890c - oVar.f13889b)) + size;
            if (j12 > j10) {
                break;
            }
            oVar = oVar.f13893f;
            kotlin.jvm.internal.k.b(oVar);
            size = j12;
        }
        while (size < j11) {
            byte[] bArr2 = oVar.f13888a;
            int iMin2 = (int) Math.min(oVar.f13890c, (((long) oVar.f13889b) + j11) - size);
            i10 = (int) ((((long) oVar.f13889b) + j10) - size);
            while (i10 < iMin2) {
                if (bArr2[i10] != b10) {
                    i10++;
                }
            }
            size += (long) (oVar.f13890c - oVar.f13889b);
            oVar = oVar.f13893f;
            kotlin.jvm.internal.k.b(oVar);
            j10 = size;
        }
        return -1L;
        return ((long) (i10 - oVar.f13889b)) + size;
    }

    public OutputStream L() {
        return new b();
    }

    public byte[] O() {
        return H(size());
    }

    public g Q() {
        return i(size());
    }

    @Override // oe.f
    public void V(long j10) throws EOFException {
        if (this.f13863b < j10) {
            throw new EOFException();
        }
    }

    @Override // oe.r
    public void X(d source, long j10) {
        o oVar;
        kotlin.jvm.internal.k.e(source, "source");
        if (!(source != this)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        oe.b.b(source.size(), 0L, j10);
        while (j10 > 0) {
            o oVar2 = source.f13862a;
            kotlin.jvm.internal.k.b(oVar2);
            int i10 = oVar2.f13890c;
            o oVar3 = source.f13862a;
            kotlin.jvm.internal.k.b(oVar3);
            if (j10 < i10 - oVar3.f13889b) {
                o oVar4 = this.f13862a;
                if (oVar4 != null) {
                    kotlin.jvm.internal.k.b(oVar4);
                    oVar = oVar4.f13894g;
                } else {
                    oVar = null;
                }
                if (oVar != null && oVar.f13892e) {
                    if ((((long) oVar.f13890c) + j10) - ((long) (oVar.f13891d ? 0 : oVar.f13889b)) <= 8192) {
                        o oVar5 = source.f13862a;
                        kotlin.jvm.internal.k.b(oVar5);
                        oVar5.f(oVar, (int) j10);
                        source.i0(source.size() - j10);
                        i0(size() + j10);
                        return;
                    }
                }
                o oVar6 = source.f13862a;
                kotlin.jvm.internal.k.b(oVar6);
                source.f13862a = oVar6.e((int) j10);
            }
            o oVar7 = source.f13862a;
            kotlin.jvm.internal.k.b(oVar7);
            long j11 = oVar7.f13890c - oVar7.f13889b;
            source.f13862a = oVar7.b();
            o oVar8 = this.f13862a;
            if (oVar8 == null) {
                this.f13862a = oVar7;
                oVar7.f13894g = oVar7;
                oVar7.f13893f = oVar7;
            } else {
                kotlin.jvm.internal.k.b(oVar8);
                o oVar9 = oVar8.f13894g;
                kotlin.jvm.internal.k.b(oVar9);
                oVar9.c(oVar7).a();
            }
            source.i0(source.size() - j11);
            i0(size() + j11);
            j10 -= j11;
        }
    }

    public void c0(byte[] sink) throws EOFException {
        kotlin.jvm.internal.k.e(sink, "sink");
        int i10 = 0;
        while (i10 < sink.length) {
            int i11 = read(sink, i10, sink.length - i10);
            if (i11 == -1) {
                throw new EOFException();
            }
            i10 += i11;
        }
    }

    @Override // oe.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public d d() {
        return this;
    }

    public String d0(long j10, Charset charset) throws EOFException {
        kotlin.jvm.internal.k.e(charset, "charset");
        if (!(j10 >= 0 && j10 <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        }
        if (this.f13863b < j10) {
            throw new EOFException();
        }
        if (j10 == 0) {
            return "";
        }
        o oVar = this.f13862a;
        kotlin.jvm.internal.k.b(oVar);
        int i10 = oVar.f13889b;
        if (((long) i10) + j10 > oVar.f13890c) {
            return new String(H(j10), charset);
        }
        int i11 = (int) j10;
        String str = new String(oVar.f13888a, i10, i11, charset);
        int i12 = oVar.f13889b + i11;
        oVar.f13889b = i12;
        this.f13863b -= j10;
        if (i12 == oVar.f13890c) {
            this.f13862a = oVar.b();
            p.b(oVar);
        }
        return str;
    }

    public String e0() {
        return d0(this.f13863b, ed.c.f7904b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (size() == dVar.size()) {
                if (size() == 0) {
                    return true;
                }
                o oVar = this.f13862a;
                kotlin.jvm.internal.k.b(oVar);
                o oVar2 = dVar.f13862a;
                kotlin.jvm.internal.k.b(oVar2);
                int i10 = oVar.f13889b;
                int i11 = oVar2.f13889b;
                long j10 = 0;
                while (j10 < size()) {
                    long jMin = Math.min(oVar.f13890c - i10, oVar2.f13890c - i11);
                    long j11 = 0;
                    while (j11 < jMin) {
                        int i12 = i10 + 1;
                        int i13 = i11 + 1;
                        if (oVar.f13888a[i10] == oVar2.f13888a[i11]) {
                            j11++;
                            i10 = i12;
                            i11 = i13;
                        }
                    }
                    if (i10 == oVar.f13890c) {
                        oVar = oVar.f13893f;
                        kotlin.jvm.internal.k.b(oVar);
                        i10 = oVar.f13889b;
                    }
                    if (i11 == oVar2.f13890c) {
                        oVar2 = oVar2.f13893f;
                        kotlin.jvm.internal.k.b(oVar2);
                        i11 = oVar2.f13889b;
                    }
                    j10 += jMin;
                }
                return true;
            }
        }
        return false;
    }

    public String f0(long j10) {
        return d0(j10, ed.c.f7904b);
    }

    @Override // oe.e, oe.r, java.io.Flushable
    public void flush() {
    }

    public String g0() {
        return h0(Long.MAX_VALUE);
    }

    public String h0(long j10) throws EOFException {
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j10).toString());
        }
        long j11 = j10 != Long.MAX_VALUE ? j10 + 1 : Long.MAX_VALUE;
        long jI = I((byte) 10, 0L, j11);
        if (jI != -1) {
            return pe.a.b(this, jI);
        }
        if (j11 < size() && E(j11 - 1) == 13 && E(j11) == 10) {
            return pe.a.b(this, j11);
        }
        d dVar = new d();
        D(dVar, 0L, Math.min(32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j10) + " content=" + dVar.Q().q() + (char) 8230);
    }

    public int hashCode() {
        o oVar = this.f13862a;
        if (oVar == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = oVar.f13890c;
            for (int i12 = oVar.f13889b; i12 < i11; i12++) {
                i10 = (i10 * 31) + oVar.f13888a[i12];
            }
            oVar = oVar.f13893f;
            kotlin.jvm.internal.k.b(oVar);
        } while (oVar != this.f13862a);
        return i10;
    }

    @Override // oe.f
    public g i(long j10) throws EOFException {
        if (!(j10 >= 0 && j10 <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        }
        if (size() < j10) {
            throw new EOFException();
        }
        if (j10 < 4096) {
            return new g(H(j10));
        }
        g gVarK0 = k0((int) j10);
        skip(j10);
        return gVarK0;
    }

    public final void i0(long j10) {
        this.f13863b = j10;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final g j0() {
        if (size() <= 2147483647L) {
            return k0((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    public final g k0(int i10) {
        if (i10 == 0) {
            return g.f13872e;
        }
        oe.b.b(size(), 0L, i10);
        o oVar = this.f13862a;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            kotlin.jvm.internal.k.b(oVar);
            int i14 = oVar.f13890c;
            int i15 = oVar.f13889b;
            if (i14 == i15) {
                throw new AssertionError("s.limit == s.pos");
            }
            i12 += i14 - i15;
            i13++;
            oVar = oVar.f13893f;
        }
        byte[][] bArr = new byte[i13][];
        int[] iArr = new int[i13 * 2];
        o oVar2 = this.f13862a;
        int i16 = 0;
        while (i11 < i10) {
            kotlin.jvm.internal.k.b(oVar2);
            bArr[i16] = oVar2.f13888a;
            i11 += oVar2.f13890c - oVar2.f13889b;
            iArr[i16] = Math.min(i11, i10);
            iArr[i16 + i13] = oVar2.f13889b;
            oVar2.f13891d = true;
            i16++;
            oVar2 = oVar2.f13893f;
        }
        return new q(bArr, iArr);
    }

    public final o l0(int i10) {
        if (!(i10 >= 1 && i10 <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        o oVar = this.f13862a;
        if (oVar != null) {
            kotlin.jvm.internal.k.b(oVar);
            o oVar2 = oVar.f13894g;
            kotlin.jvm.internal.k.b(oVar2);
            return (oVar2.f13890c + i10 > 8192 || !oVar2.f13892e) ? oVar2.c(p.c()) : oVar2;
        }
        o oVarC = p.c();
        this.f13862a = oVarC;
        oVarC.f13894g = oVarC;
        oVarC.f13893f = oVarC;
        return oVarC;
    }

    public d m0(g byteString) {
        kotlin.jvm.internal.k.e(byteString, "byteString");
        byteString.D(this, 0, byteString.y());
        return this;
    }

    @Override // oe.e
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public d write(byte[] source) {
        kotlin.jvm.internal.k.e(source, "source");
        return o0(source, 0, source.length);
    }

    @Override // oe.f
    public d o() {
        return this;
    }

    public d o0(byte[] source, int i10, int i11) {
        kotlin.jvm.internal.k.e(source, "source");
        long j10 = i11;
        oe.b.b(source.length, i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            o oVarL0 = l0(1);
            int iMin = Math.min(i12 - i10, 8192 - oVarL0.f13890c);
            int i13 = i10 + iMin;
            mc.j.d(source, oVarL0.f13888a, oVarL0.f13890c, i10, i13);
            oVarL0.f13890c += iMin;
            i10 = i13;
        }
        i0(size() + j10);
        return this;
    }

    @Override // oe.f
    public boolean p() {
        return this.f13863b == 0;
    }

    @Override // oe.e
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public d writeByte(int i10) {
        o oVarL0 = l0(1);
        byte[] bArr = oVarL0.f13888a;
        int i11 = oVarL0.f13890c;
        oVarL0.f13890c = i11 + 1;
        bArr[i11] = (byte) i10;
        i0(size() + 1);
        return this;
    }

    public d q0(long j10) {
        if (j10 == 0) {
            return writeByte(48);
        }
        long j11 = (j10 >>> 1) | j10;
        long j12 = j11 | (j11 >>> 2);
        long j13 = j12 | (j12 >>> 4);
        long j14 = j13 | (j13 >>> 8);
        long j15 = j14 | (j14 >>> 16);
        long j16 = j15 | (j15 >>> 32);
        long j17 = j16 - ((j16 >>> 1) & 6148914691236517205L);
        long j18 = ((j17 >>> 2) & 3689348814741910323L) + (j17 & 3689348814741910323L);
        long j19 = ((j18 >>> 4) + j18) & 1085102592571150095L;
        long j20 = j19 + (j19 >>> 8);
        long j21 = j20 + (j20 >>> 16);
        int i10 = (int) ((((j21 & 63) + ((j21 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        o oVarL0 = l0(i10);
        byte[] bArr = oVarL0.f13888a;
        int i11 = oVarL0.f13890c;
        for (int i12 = (i11 + i10) - 1; i12 >= i11; i12--) {
            bArr[i12] = pe.a.a()[(int) (15 & j10)];
            j10 >>>= 4;
        }
        oVarL0.f13890c += i10;
        i0(size() + ((long) i10));
        return this;
    }

    @Override // oe.e
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public d writeInt(int i10) {
        o oVarL0 = l0(4);
        byte[] bArr = oVarL0.f13888a;
        int i11 = oVarL0.f13890c;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i10 >>> 16) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i10 >>> 8) & 255);
        bArr[i14] = (byte) (i10 & 255);
        oVarL0.f13890c = i14 + 1;
        i0(size() + 4);
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        kotlin.jvm.internal.k.e(sink, "sink");
        o oVar = this.f13862a;
        if (oVar == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), oVar.f13890c - oVar.f13889b);
        sink.put(oVar.f13888a, oVar.f13889b, iMin);
        int i10 = oVar.f13889b + iMin;
        oVar.f13889b = i10;
        this.f13863b -= (long) iMin;
        if (i10 == oVar.f13890c) {
            this.f13862a = oVar.b();
            p.b(oVar);
        }
        return iMin;
    }

    public int read(byte[] sink, int i10, int i11) {
        kotlin.jvm.internal.k.e(sink, "sink");
        oe.b.b(sink.length, i10, i11);
        o oVar = this.f13862a;
        if (oVar == null) {
            return -1;
        }
        int iMin = Math.min(i11, oVar.f13890c - oVar.f13889b);
        byte[] bArr = oVar.f13888a;
        int i12 = oVar.f13889b;
        mc.j.d(bArr, sink, i10, i12, i12 + iMin);
        oVar.f13889b += iMin;
        i0(size() - ((long) iMin));
        if (oVar.f13889b == oVar.f13890c) {
            this.f13862a = oVar.b();
            p.b(oVar);
        }
        return iMin;
    }

    @Override // oe.f
    public byte readByte() throws EOFException {
        if (size() == 0) {
            throw new EOFException();
        }
        o oVar = this.f13862a;
        kotlin.jvm.internal.k.b(oVar);
        int i10 = oVar.f13889b;
        int i11 = oVar.f13890c;
        int i12 = i10 + 1;
        byte b10 = oVar.f13888a[i10];
        i0(size() - 1);
        if (i12 == i11) {
            this.f13862a = oVar.b();
            p.b(oVar);
        } else {
            oVar.f13889b = i12;
        }
        return b10;
    }

    @Override // oe.f
    public int readInt() throws EOFException {
        if (size() < 4) {
            throw new EOFException();
        }
        o oVar = this.f13862a;
        kotlin.jvm.internal.k.b(oVar);
        int i10 = oVar.f13889b;
        int i11 = oVar.f13890c;
        if (i11 - i10 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = oVar.f13888a;
        int i12 = i10 + 1;
        int i13 = i12 + 1;
        int i14 = ((bArr[i10] & 255) << 24) | ((bArr[i12] & 255) << 16);
        int i15 = i13 + 1;
        int i16 = i14 | ((bArr[i13] & 255) << 8);
        int i17 = i15 + 1;
        int i18 = i16 | (bArr[i15] & 255);
        i0(size() - 4);
        if (i17 == i11) {
            this.f13862a = oVar.b();
            p.b(oVar);
        } else {
            oVar.f13889b = i17;
        }
        return i18;
    }

    @Override // oe.f
    public short readShort() throws EOFException {
        if (size() < 2) {
            throw new EOFException();
        }
        o oVar = this.f13862a;
        kotlin.jvm.internal.k.b(oVar);
        int i10 = oVar.f13889b;
        int i11 = oVar.f13890c;
        if (i11 - i10 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = oVar.f13888a;
        int i12 = i10 + 1;
        int i13 = i12 + 1;
        int i14 = ((bArr[i10] & 255) << 8) | (bArr[i12] & 255);
        i0(size() - 2);
        if (i13 == i11) {
            this.f13862a = oVar.b();
            p.b(oVar);
        } else {
            oVar.f13889b = i13;
        }
        return (short) i14;
    }

    @Override // oe.t
    public long s(d sink, long j10) {
        kotlin.jvm.internal.k.e(sink, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        if (size() == 0) {
            return -1L;
        }
        if (j10 > size()) {
            j10 = size();
        }
        sink.X(this, j10);
        return j10;
    }

    @Override // oe.e
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public d writeShort(int i10) {
        o oVarL0 = l0(2);
        byte[] bArr = oVarL0.f13888a;
        int i11 = oVarL0.f13890c;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i12] = (byte) (i10 & 255);
        oVarL0.f13890c = i12 + 1;
        i0(size() + 2);
        return this;
    }

    public final long size() {
        return this.f13863b;
    }

    @Override // oe.f
    public void skip(long j10) throws EOFException {
        while (j10 > 0) {
            o oVar = this.f13862a;
            if (oVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j10, oVar.f13890c - oVar.f13889b);
            long j11 = iMin;
            i0(size() - j11);
            j10 -= j11;
            int i10 = oVar.f13889b + iMin;
            oVar.f13889b = i10;
            if (i10 == oVar.f13890c) {
                this.f13862a = oVar.b();
                p.b(oVar);
            }
        }
    }

    public final void t() throws EOFException {
        skip(size());
    }

    public final d t0(OutputStream out, long j10) throws IOException {
        kotlin.jvm.internal.k.e(out, "out");
        oe.b.b(this.f13863b, 0L, j10);
        o oVar = this.f13862a;
        while (j10 > 0) {
            kotlin.jvm.internal.k.b(oVar);
            int iMin = (int) Math.min(j10, oVar.f13890c - oVar.f13889b);
            out.write(oVar.f13888a, oVar.f13889b, iMin);
            int i10 = oVar.f13889b + iMin;
            oVar.f13889b = i10;
            long j11 = iMin;
            this.f13863b -= j11;
            j10 -= j11;
            if (i10 == oVar.f13890c) {
                o oVarB = oVar.b();
                this.f13862a = oVarB;
                p.b(oVar);
                oVar = oVarB;
            }
        }
        return this;
    }

    public String toString() {
        return j0().toString();
    }

    @Override // oe.e
    /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
    public d u(String string) {
        kotlin.jvm.internal.k.e(string, "string");
        return v0(string, 0, string.length());
    }

    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public d clone() {
        return C();
    }

    public d v0(String string, int i10, int i11) {
        char cCharAt;
        long size;
        long j10;
        kotlin.jvm.internal.k.e(string, "string");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i10).toString());
        }
        if (!(i11 >= i10)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
        }
        if (!(i11 <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + string.length()).toString());
        }
        while (i10 < i11) {
            char cCharAt2 = string.charAt(i10);
            if (cCharAt2 < 128) {
                o oVarL0 = l0(1);
                byte[] bArr = oVarL0.f13888a;
                int i12 = oVarL0.f13890c - i10;
                int iMin = Math.min(i11, 8192 - i12);
                int i13 = i10 + 1;
                bArr[i10 + i12] = (byte) cCharAt2;
                while (true) {
                    i10 = i13;
                    if (i10 >= iMin || (cCharAt = string.charAt(i10)) >= 128) {
                        break;
                    }
                    i13 = i10 + 1;
                    bArr[i10 + i12] = (byte) cCharAt;
                }
                int i14 = oVarL0.f13890c;
                int i15 = (i12 + i10) - i14;
                oVarL0.f13890c = i14 + i15;
                i0(size() + ((long) i15));
            } else {
                if (cCharAt2 < 2048) {
                    o oVarL1 = l0(2);
                    byte[] bArr2 = oVarL1.f13888a;
                    int i16 = oVarL1.f13890c;
                    bArr2[i16] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i16 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    oVarL1.f13890c = i16 + 2;
                    size = size();
                    j10 = 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    o oVarL2 = l0(3);
                    byte[] bArr3 = oVarL2.f13888a;
                    int i17 = oVarL2.f13890c;
                    bArr3[i17] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i17 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i17 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    oVarL2.f13890c = i17 + 3;
                    size = size();
                    j10 = 3;
                } else {
                    int i18 = i10 + 1;
                    char cCharAt3 = i18 < i11 ? string.charAt(i18) : (char) 0;
                    if (cCharAt2 <= 56319) {
                        if (56320 <= cCharAt3 && cCharAt3 < 57344) {
                            int i19 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                            o oVarL3 = l0(4);
                            byte[] bArr4 = oVarL3.f13888a;
                            int i20 = oVarL3.f13890c;
                            bArr4[i20] = (byte) ((i19 >> 18) | 240);
                            bArr4[i20 + 1] = (byte) (((i19 >> 12) & 63) | 128);
                            bArr4[i20 + 2] = (byte) (((i19 >> 6) & 63) | 128);
                            bArr4[i20 + 3] = (byte) ((i19 & 63) | 128);
                            oVarL3.f13890c = i20 + 4;
                            i0(size() + 4);
                            i10 += 2;
                        }
                    }
                    writeByte(63);
                    i10 = i18;
                }
                i0(size + j10);
                i10++;
            }
        }
        return this;
    }

    public d w0(int i10) {
        long size;
        long j10;
        if (i10 < 128) {
            writeByte(i10);
        } else {
            if (i10 < 2048) {
                o oVarL0 = l0(2);
                byte[] bArr = oVarL0.f13888a;
                int i11 = oVarL0.f13890c;
                bArr[i11] = (byte) ((i10 >> 6) | 192);
                bArr[i11 + 1] = (byte) ((i10 & 63) | 128);
                oVarL0.f13890c = i11 + 2;
                size = size();
                j10 = 2;
            } else {
                boolean z10 = false;
                if (55296 <= i10 && i10 < 57344) {
                    z10 = true;
                }
                if (z10) {
                    writeByte(63);
                } else if (i10 < 65536) {
                    o oVarL1 = l0(3);
                    byte[] bArr2 = oVarL1.f13888a;
                    int i12 = oVarL1.f13890c;
                    bArr2[i12] = (byte) ((i10 >> 12) | 224);
                    bArr2[i12 + 1] = (byte) (((i10 >> 6) & 63) | 128);
                    bArr2[i12 + 2] = (byte) ((i10 & 63) | 128);
                    oVarL1.f13890c = i12 + 3;
                    size = size();
                    j10 = 3;
                } else {
                    if (i10 > 1114111) {
                        throw new IllegalArgumentException("Unexpected code point: 0x" + oe.b.d(i10));
                    }
                    o oVarL2 = l0(4);
                    byte[] bArr3 = oVarL2.f13888a;
                    int i13 = oVarL2.f13890c;
                    bArr3[i13] = (byte) ((i10 >> 18) | 240);
                    bArr3[i13 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                    bArr3[i13 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                    bArr3[i13 + 3] = (byte) ((i10 & 63) | 128);
                    oVarL2.f13890c = i13 + 4;
                    size = size();
                    j10 = 4;
                }
            }
            i0(size + j10);
        }
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        kotlin.jvm.internal.k.e(source, "source");
        int iRemaining = source.remaining();
        int i10 = iRemaining;
        while (i10 > 0) {
            o oVarL0 = l0(1);
            int iMin = Math.min(i10, 8192 - oVarL0.f13890c);
            source.get(oVarL0.f13888a, oVarL0.f13890c, iMin);
            i10 -= iMin;
            oVarL0.f13890c += iMin;
        }
        this.f13863b += (long) iRemaining;
        return iRemaining;
    }

    public final long z() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        o oVar = this.f13862a;
        kotlin.jvm.internal.k.b(oVar);
        o oVar2 = oVar.f13894g;
        kotlin.jvm.internal.k.b(oVar2);
        int i10 = oVar2.f13890c;
        if (i10 < 8192 && oVar2.f13892e) {
            size -= (long) (i10 - oVar2.f13889b);
        }
        return size;
    }
}
