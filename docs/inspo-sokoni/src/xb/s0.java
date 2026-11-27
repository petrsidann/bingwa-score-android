package xb;

import java.io.Closeable;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes2.dex */
public class s0 implements Closeable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f18910e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f18911f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Inflater f18912l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f18915o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f18916p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f18917q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f18906a = new v();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CRC32 f18907b = new CRC32();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f18908c = new b(this, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f18909d = new byte[512];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f18913m = c.HEADER;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f18914n = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f18918r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f18919s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f18920t = true;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18921a;

        static {
            int[] iArr = new int[c.values().length];
            f18921a = iArr;
            try {
                iArr[c.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18921a[c.HEADER_EXTRA_LEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18921a[c.HEADER_EXTRA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18921a[c.HEADER_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18921a[c.HEADER_COMMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18921a[c.HEADER_CRC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18921a[c.INITIALIZE_INFLATER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f18921a[c.INFLATING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f18921a[c.INFLATER_NEEDS_INPUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f18921a[c.TRAILER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public class b {
        public b() {
        }

        public /* synthetic */ b(s0 s0Var, a aVar) {
            this();
        }

        public final boolean g() {
            while (k() > 0) {
                if (h() == 0) {
                    return true;
                }
            }
            return false;
        }

        public final int h() {
            int unsignedByte;
            if (s0.this.f18911f - s0.this.f18910e > 0) {
                unsignedByte = s0.this.f18909d[s0.this.f18910e] & 255;
                s0.k(s0.this, 1);
            } else {
                unsignedByte = s0.this.f18906a.readUnsignedByte();
            }
            s0.this.f18907b.update(unsignedByte);
            s0.B(s0.this, 1);
            return unsignedByte;
        }

        public final long i() {
            return ((long) j()) | (((long) j()) << 16);
        }

        public final int j() {
            return h() | (h() << 8);
        }

        public final int k() {
            return (s0.this.f18911f - s0.this.f18910e) + s0.this.f18906a.a();
        }

        public final void l(int i10) {
            int i11;
            int i12 = s0.this.f18911f - s0.this.f18910e;
            if (i12 > 0) {
                int iMin = Math.min(i12, i10);
                s0.this.f18907b.update(s0.this.f18909d, s0.this.f18910e, iMin);
                s0.k(s0.this, iMin);
                i11 = i10 - iMin;
            } else {
                i11 = i10;
            }
            if (i11 > 0) {
                byte[] bArr = new byte[512];
                int i13 = 0;
                while (i13 < i11) {
                    int iMin2 = Math.min(i11 - i13, 512);
                    s0.this.f18906a.w(bArr, 0, iMin2);
                    s0.this.f18907b.update(bArr, 0, iMin2);
                    i13 += iMin2;
                }
            }
            s0.B(s0.this, i10);
        }
    }

    public enum c {
        HEADER,
        HEADER_EXTRA_LEN,
        HEADER_EXTRA,
        HEADER_NAME,
        HEADER_COMMENT,
        HEADER_CRC,
        INITIALIZE_INFLATER,
        INFLATING,
        INFLATER_NEEDS_INPUT,
        TRAILER
    }

    public static /* synthetic */ int B(s0 s0Var, int i10) {
        int i11 = s0Var.f18918r + i10;
        s0Var.f18918r = i11;
        return i11;
    }

    public static /* synthetic */ int k(s0 s0Var, int i10) {
        int i11 = s0Var.f18910e + i10;
        s0Var.f18910e = i11;
        return i11;
    }

    public void C(y1 y1Var) {
        j6.m.v(!this.f18914n, "GzipInflatingBuffer is closed");
        this.f18906a.e(y1Var);
        this.f18920t = false;
    }

    public final boolean D() {
        j6.m.v(this.f18912l != null, "inflater is null");
        j6.m.v(this.f18910e == this.f18911f, "inflaterInput has unconsumed bytes");
        int iMin = Math.min(this.f18906a.a(), 512);
        if (iMin == 0) {
            return false;
        }
        this.f18910e = 0;
        this.f18911f = iMin;
        this.f18906a.w(this.f18909d, 0, iMin);
        this.f18912l.setInput(this.f18909d, this.f18910e, iMin);
        this.f18913m = c.INFLATING;
        return true;
    }

    public int E() {
        int i10 = this.f18918r;
        this.f18918r = 0;
        return i10;
    }

    public int G() {
        int i10 = this.f18919s;
        this.f18919s = 0;
        return i10;
    }

    public boolean I() {
        j6.m.v(!this.f18914n, "GzipInflatingBuffer is closed");
        return (this.f18908c.k() == 0 && this.f18913m == c.HEADER) ? false : true;
    }

    public final int J(byte[] bArr, int i10, int i11) throws DataFormatException {
        c cVar;
        j6.m.v(this.f18912l != null, "inflater is null");
        try {
            int totalIn = this.f18912l.getTotalIn();
            int iInflate = this.f18912l.inflate(bArr, i10, i11);
            int totalIn2 = this.f18912l.getTotalIn() - totalIn;
            this.f18918r += totalIn2;
            this.f18919s += totalIn2;
            this.f18910e += totalIn2;
            this.f18907b.update(bArr, i10, iInflate);
            if (!this.f18912l.finished()) {
                if (this.f18912l.needsInput()) {
                    cVar = c.INFLATER_NEEDS_INPUT;
                }
                return iInflate;
            }
            this.f18917q = this.f18912l.getBytesWritten() & 4294967295L;
            cVar = c.TRAILER;
            this.f18913m = cVar;
            return iInflate;
        } catch (DataFormatException e10) {
            throw new DataFormatException("Inflater data format exception: " + e10.getMessage());
        }
    }

    public int L(byte[] bArr, int i10, int i11) throws ZipException {
        boolean zI0;
        boolean z10 = true;
        j6.m.v(!this.f18914n, "GzipInflatingBuffer is closed");
        int iJ = 0;
        while (true) {
            zI0 = true;
            while (true) {
                if (zI0) {
                    int i12 = i11 - iJ;
                    if (i12 > 0) {
                        switch (a.f18921a[this.f18913m.ordinal()]) {
                            case 1:
                                zI0 = c0();
                                break;
                            case 2:
                                zI0 = g0();
                                break;
                            case 3:
                                zI0 = f0();
                                break;
                            case 4:
                                zI0 = h0();
                                break;
                            case 5:
                                zI0 = d0();
                                break;
                            case 6:
                                zI0 = e0();
                                break;
                            case 7:
                                zI0 = O();
                                break;
                            case 8:
                                iJ += J(bArr, i10 + iJ, i12);
                                if (this.f18913m != c.TRAILER) {
                                }
                                zI0 = i0();
                                break;
                            case 9:
                                zI0 = D();
                                break;
                            case 10:
                                zI0 = i0();
                                break;
                            default:
                                throw new AssertionError("Invalid state: " + this.f18913m);
                        }
                    }
                }
            }
        }
        if (zI0 && (this.f18913m != c.HEADER || this.f18908c.k() >= 10)) {
            z10 = false;
        }
        this.f18920t = z10;
        return iJ;
    }

    public final boolean O() {
        c cVar;
        Inflater inflater = this.f18912l;
        if (inflater == null) {
            this.f18912l = new Inflater(true);
        } else {
            inflater.reset();
        }
        this.f18907b.reset();
        int i10 = this.f18911f;
        int i11 = this.f18910e;
        int i12 = i10 - i11;
        if (i12 > 0) {
            this.f18912l.setInput(this.f18909d, i11, i12);
            cVar = c.INFLATING;
        } else {
            cVar = c.INFLATER_NEEDS_INPUT;
        }
        this.f18913m = cVar;
        return true;
    }

    public boolean Q() {
        j6.m.v(!this.f18914n, "GzipInflatingBuffer is closed");
        return this.f18920t;
    }

    public final boolean c0() throws ZipException {
        if (this.f18908c.k() < 10) {
            return false;
        }
        if (this.f18908c.j() != 35615) {
            throw new ZipException("Not in GZIP format");
        }
        if (this.f18908c.h() != 8) {
            throw new ZipException("Unsupported compression method");
        }
        this.f18915o = this.f18908c.h();
        this.f18908c.l(6);
        this.f18913m = c.HEADER_EXTRA_LEN;
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f18914n) {
            return;
        }
        this.f18914n = true;
        this.f18906a.close();
        Inflater inflater = this.f18912l;
        if (inflater != null) {
            inflater.end();
            this.f18912l = null;
        }
    }

    public final boolean d0() {
        if ((this.f18915o & 16) == 16 && !this.f18908c.g()) {
            return false;
        }
        this.f18913m = c.HEADER_CRC;
        return true;
    }

    public final boolean e0() throws ZipException {
        if ((this.f18915o & 2) == 2) {
            if (this.f18908c.k() < 2) {
                return false;
            }
            if ((((int) this.f18907b.getValue()) & 65535) != this.f18908c.j()) {
                throw new ZipException("Corrupt GZIP header");
            }
        }
        this.f18913m = c.INITIALIZE_INFLATER;
        return true;
    }

    public final boolean f0() {
        int iK = this.f18908c.k();
        int i10 = this.f18916p;
        if (iK < i10) {
            return false;
        }
        this.f18908c.l(i10);
        this.f18913m = c.HEADER_NAME;
        return true;
    }

    public final boolean g0() {
        c cVar;
        if ((this.f18915o & 4) != 4) {
            cVar = c.HEADER_NAME;
        } else {
            if (this.f18908c.k() < 2) {
                return false;
            }
            this.f18916p = this.f18908c.j();
            cVar = c.HEADER_EXTRA;
        }
        this.f18913m = cVar;
        return true;
    }

    public final boolean h0() {
        if ((this.f18915o & 8) == 8 && !this.f18908c.g()) {
            return false;
        }
        this.f18913m = c.HEADER_COMMENT;
        return true;
    }

    public final boolean i0() throws ZipException {
        if (this.f18912l != null && this.f18908c.k() <= 18) {
            this.f18912l.end();
            this.f18912l = null;
        }
        if (this.f18908c.k() < 8) {
            return false;
        }
        if (this.f18907b.getValue() != this.f18908c.i() || this.f18917q != this.f18908c.i()) {
            throw new ZipException("Corrupt GZIP trailer");
        }
        this.f18907b.reset();
        this.f18913m = c.HEADER;
        return true;
    }
}
