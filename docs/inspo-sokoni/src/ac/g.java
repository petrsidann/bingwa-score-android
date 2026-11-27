package ac;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import oe.t;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f481a = Logger.getLogger(b.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final oe.g f482b = oe.g.i("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    public static final class a implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final oe.f f483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f484b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public byte f485c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f486d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f487e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public short f488f;

        public a(oe.f fVar) {
            this.f483a = fVar;
        }

        @Override // oe.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public final void d() throws IOException {
            int i10 = this.f486d;
            int iM = g.m(this.f483a);
            this.f487e = iM;
            this.f484b = iM;
            byte b10 = (byte) (this.f483a.readByte() & 255);
            this.f485c = (byte) (this.f483a.readByte() & 255);
            if (g.f481a.isLoggable(Level.FINE)) {
                g.f481a.fine(b.b(true, this.f486d, this.f484b, b10, this.f485c));
            }
            int i11 = this.f483a.readInt() & com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER;
            this.f486d = i11;
            if (b10 != 9) {
                throw g.k("%s != TYPE_CONTINUATION", Byte.valueOf(b10));
            }
            if (i11 != i10) {
                throw g.k("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // oe.t
        public long s(oe.d dVar, long j10) throws IOException {
            while (true) {
                int i10 = this.f487e;
                if (i10 != 0) {
                    long jS = this.f483a.s(dVar, Math.min(j10, i10));
                    if (jS == -1) {
                        return -1L;
                    }
                    this.f487e -= (int) jS;
                    return jS;
                }
                this.f483a.skip(this.f488f);
                this.f488f = (short) 0;
                if ((this.f485c & 4) != 0) {
                    return -1L;
                }
                d();
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[] f489a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String[] f490b = new String[64];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String[] f491c = new String[256];

        static {
            int i10 = 0;
            int i11 = 0;
            while (true) {
                String[] strArr = f491c;
                if (i11 >= strArr.length) {
                    break;
                }
                strArr[i11] = String.format("%8s", Integer.toBinaryString(i11)).replace(' ', '0');
                i11++;
            }
            String[] strArr2 = f490b;
            strArr2[0] = "";
            strArr2[1] = "END_STREAM";
            int[] iArr = {1};
            strArr2[8] = "PADDED";
            strArr2[1 | 8] = strArr2[1] + "|PADDED";
            strArr2[4] = "END_HEADERS";
            strArr2[32] = "PRIORITY";
            strArr2[36] = "END_HEADERS|PRIORITY";
            int[] iArr2 = {4, 32, 36};
            for (int i12 = 0; i12 < 3; i12++) {
                int i13 = iArr2[i12];
                int i14 = iArr[0];
                String[] strArr3 = f490b;
                int i15 = i14 | i13;
                strArr3[i15] = strArr3[i14] + '|' + strArr3[i13];
                strArr3[i15 | 8] = strArr3[i14] + '|' + strArr3[i13] + "|PADDED";
            }
            while (true) {
                String[] strArr4 = f490b;
                if (i10 >= strArr4.length) {
                    return;
                }
                if (strArr4[i10] == null) {
                    strArr4[i10] = f491c[i10];
                }
                i10++;
            }
        }

        public static String a(byte b10, byte b11) {
            if (b11 == 0) {
                return "";
            }
            if (b10 != 2 && b10 != 3) {
                if (b10 == 4 || b10 == 6) {
                    return b11 == 1 ? "ACK" : f491c[b11];
                }
                if (b10 != 7 && b10 != 8) {
                    String[] strArr = f490b;
                    String str = b11 < strArr.length ? strArr[b11] : f491c[b11];
                    if (b10 != 5 || (b11 & 4) == 0) {
                        return (b10 != 0 || (b11 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                    }
                    return str.replace("HEADERS", "PUSH_PROMISE");
                }
            }
            return f491c[b11];
        }

        public static String b(boolean z10, int i10, int i11, byte b10, byte b11) {
            String[] strArr = f489a;
            String str = b10 < strArr.length ? strArr[b10] : String.format("0x%02x", Byte.valueOf(b10));
            String strA = a(b10, b11);
            Locale locale = Locale.US;
            Object[] objArr = new Object[5];
            objArr[0] = z10 ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i10);
            objArr[2] = Integer.valueOf(i11);
            objArr[3] = str;
            objArr[4] = strA;
            return String.format(locale, "%s 0x%08x %5d %-13s %s", objArr);
        }
    }

    public static final class c implements ac.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final oe.f f492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f493b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f494c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f.a f495d;

        public c(oe.f fVar, int i10, boolean z10) {
            this.f492a = fVar;
            this.f494c = z10;
            a aVar = new a(fVar);
            this.f493b = aVar;
            this.f495d = new f.a(i10, aVar);
        }

        public final void B(ac.b.a aVar, int i10, byte b10, int i11) throws IOException {
            if (i10 != 5) {
                throw g.k("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i10));
            }
            if (i11 == 0) {
                throw g.k("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
            z(aVar, i11);
        }

        public final void C(ac.b.a aVar, int i10, byte b10, int i11) throws IOException {
            if (i11 == 0) {
                throw g.k("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            }
            short s10 = (b10 & 8) != 0 ? (short) (this.f492a.readByte() & 255) : (short) 0;
            aVar.m(i11, this.f492a.readInt() & com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER, k(g.l(i10 - 4, b10, s10), s10, b10, i11));
        }

        public final void D(ac.b.a aVar, int i10, byte b10, int i11) throws IOException {
            if (i10 != 4) {
                throw g.k("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i10));
            }
            if (i11 == 0) {
                throw g.k("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            int i12 = this.f492a.readInt();
            ac.a aVarD = ac.a.d(i12);
            if (aVarD == null) {
                throw g.k("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i12));
            }
            aVar.b(i11, aVarD);
        }

        public final void E(ac.b.a aVar, int i10, byte b10, int i11) throws IOException {
            if (i11 != 0) {
                throw g.k("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            if ((b10 & 1) != 0) {
                if (i10 != 0) {
                    throw g.k("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                }
                aVar.g();
                return;
            }
            if (i10 % 6 != 0) {
                throw g.k("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i10));
            }
            i iVar = new i();
            for (int i12 = 0; i12 < i10; i12 += 6) {
                short s10 = this.f492a.readShort();
                int i13 = this.f492a.readInt();
                switch (s10) {
                    case 1:
                    case 6:
                        break;
                    case 2:
                        if (i13 != 0 && i13 != 1) {
                            throw g.k("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                        break;
                    case 3:
                        s10 = 4;
                        break;
                    case 4:
                        if (i13 < 0) {
                            throw g.k("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                        s10 = 7;
                        break;
                        break;
                    case 5:
                        if (i13 < 16384 || i13 > 16777215) {
                            throw g.k("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i13));
                        }
                        break;
                    default:
                        continue;
                        break;
                }
                iVar.e(s10, 0, i13);
            }
            aVar.i(false, iVar);
            if (iVar.b() >= 0) {
                this.f495d.g(iVar.b());
            }
        }

        public final void G(ac.b.a aVar, int i10, byte b10, int i11) throws IOException {
            if (i10 != 4) {
                throw g.k("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i10));
            }
            long j10 = ((long) this.f492a.readInt()) & 2147483647L;
            if (j10 == 0) {
                throw g.k("windowSizeIncrement was 0", new Object[0]);
            }
            aVar.c(i11, j10);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f492a.close();
        }

        public final void d(ac.b.a aVar, int i10, byte b10, int i11) throws IOException {
            boolean z10 = (b10 & 1) != 0;
            if ((b10 & 32) != 0) {
                throw g.k("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            }
            short s10 = (b10 & 8) != 0 ? (short) (this.f492a.readByte() & 255) : (short) 0;
            aVar.l(z10, i11, this.f492a, g.l(i10, b10, s10), i10);
            this.f492a.skip(s10);
        }

        public final void e(ac.b.a aVar, int i10, byte b10, int i11) throws IOException {
            if (i10 < 8) {
                throw g.k("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i10));
            }
            if (i11 != 0) {
                throw g.k("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
            int i12 = this.f492a.readInt();
            int i13 = this.f492a.readInt();
            int i14 = i10 - 8;
            ac.a aVarD = ac.a.d(i13);
            if (aVarD == null) {
                throw g.k("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i13));
            }
            oe.g gVarI = oe.g.f13872e;
            if (i14 > 0) {
                gVarI = this.f492a.i(i14);
            }
            aVar.k(i12, aVarD, gVarI);
        }

        public final List<ac.d> k(int i10, short s10, byte b10, int i11) throws IOException {
            a aVar = this.f493b;
            aVar.f487e = i10;
            aVar.f484b = i10;
            aVar.f488f = s10;
            aVar.f485c = b10;
            aVar.f486d = i11;
            this.f495d.l();
            return this.f495d.e();
        }

        public final void t(ac.b.a aVar, int i10, byte b10, int i11) throws IOException {
            if (i11 == 0) {
                throw g.k("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            }
            boolean z10 = (b10 & 1) != 0;
            short s10 = (b10 & 8) != 0 ? (short) (this.f492a.readByte() & 255) : (short) 0;
            if ((b10 & 32) != 0) {
                z(aVar, i11);
                i10 -= 5;
            }
            aVar.h(false, z10, i11, -1, k(g.l(i10, b10, s10), s10, b10, i11), e.HTTP_20_HEADERS);
        }

        public final void v(ac.b.a aVar, int i10, byte b10, int i11) throws IOException {
            if (i10 != 8) {
                throw g.k("TYPE_PING length != 8: %s", Integer.valueOf(i10));
            }
            if (i11 != 0) {
                throw g.k("TYPE_PING streamId != 0", new Object[0]);
            }
            aVar.f((b10 & 1) != 0, this.f492a.readInt(), this.f492a.readInt());
        }

        @Override // ac.b
        public boolean y(ac.b.a aVar) throws IOException {
            try {
                this.f492a.V(9L);
                int iM = g.m(this.f492a);
                if (iM < 0 || iM > 16384) {
                    throw g.k("FRAME_SIZE_ERROR: %s", Integer.valueOf(iM));
                }
                byte b10 = (byte) (this.f492a.readByte() & 255);
                byte b11 = (byte) (this.f492a.readByte() & 255);
                int i10 = this.f492a.readInt() & com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER;
                if (g.f481a.isLoggable(Level.FINE)) {
                    g.f481a.fine(b.b(true, i10, iM, b10, b11));
                }
                switch (b10) {
                    case 0:
                        d(aVar, iM, b11, i10);
                        return true;
                    case 1:
                        t(aVar, iM, b11, i10);
                        return true;
                    case 2:
                        B(aVar, iM, b11, i10);
                        return true;
                    case 3:
                        D(aVar, iM, b11, i10);
                        return true;
                    case 4:
                        E(aVar, iM, b11, i10);
                        return true;
                    case 5:
                        C(aVar, iM, b11, i10);
                        return true;
                    case 6:
                        v(aVar, iM, b11, i10);
                        return true;
                    case 7:
                        e(aVar, iM, b11, i10);
                        return true;
                    case 8:
                        G(aVar, iM, b11, i10);
                        return true;
                    default:
                        this.f492a.skip(iM);
                        return true;
                }
            } catch (IOException unused) {
                return false;
            }
        }

        public final void z(ac.b.a aVar, int i10) {
            int i11 = this.f492a.readInt();
            aVar.j(i10, i11 & com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER, (this.f492a.readByte() & 255) + 1, (Integer.MIN_VALUE & i11) != 0);
        }
    }

    public static final class d implements ac.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final oe.e f496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final oe.d f498c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f.b f499d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f500e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f501f;

        public d(oe.e eVar, boolean z10) {
            this.f496a = eVar;
            this.f497b = z10;
            oe.d dVar = new oe.d();
            this.f498c = dVar;
            this.f499d = new f.b(dVar);
            this.f500e = 16384;
        }

        @Override // ac.c
        public synchronized void M(boolean z10, int i10, oe.d dVar, int i11) {
            if (this.f501f) {
                throw new IOException("closed");
            }
            d(i10, z10 ? (byte) 1 : (byte) 0, dVar, i11);
        }

        @Override // ac.c
        public int T() {
            return this.f500e;
        }

        @Override // ac.c
        public synchronized void U(boolean z10, boolean z11, int i10, int i11, List<ac.d> list) {
            try {
                if (z11) {
                    throw new UnsupportedOperationException();
                }
                if (this.f501f) {
                    throw new IOException("closed");
                }
                k(z10, i10, list);
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // ac.c
        public synchronized void b(int i10, ac.a aVar) {
            if (this.f501f) {
                throw new IOException("closed");
            }
            if (aVar.f442a == -1) {
                throw new IllegalArgumentException();
            }
            e(i10, 4, (byte) 3, (byte) 0);
            this.f496a.writeInt(aVar.f442a);
            this.f496a.flush();
        }

        @Override // ac.c
        public synchronized void b0(i iVar) {
            int i10;
            if (this.f501f) {
                throw new IOException("closed");
            }
            int i11 = 0;
            e(0, iVar.f() * 6, (byte) 4, (byte) 0);
            while (i11 < 10) {
                if (iVar.d(i11)) {
                    if (i11 == 4) {
                        i10 = 3;
                    } else {
                        i10 = i11 == 7 ? 4 : i11;
                    }
                    this.f496a.writeShort(i10);
                    this.f496a.writeInt(iVar.a(i11));
                }
                i11++;
            }
            this.f496a.flush();
        }

        @Override // ac.c
        public synchronized void c(int i10, long j10) {
            if (this.f501f) {
                throw new IOException("closed");
            }
            if (j10 == 0 || j10 > 2147483647L) {
                throw g.j("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j10));
            }
            e(i10, 4, (byte) 8, (byte) 0);
            this.f496a.writeInt((int) j10);
            this.f496a.flush();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            this.f501f = true;
            this.f496a.close();
        }

        public void d(int i10, byte b10, oe.d dVar, int i11) {
            e(i10, i11, (byte) 0, b10);
            if (i11 > 0) {
                this.f496a.X(dVar, i11);
            }
        }

        public void e(int i10, int i11, byte b10, byte b11) {
            if (g.f481a.isLoggable(Level.FINE)) {
                g.f481a.fine(b.b(false, i10, i11, b10, b11));
            }
            int i12 = this.f500e;
            if (i11 > i12) {
                throw g.j("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i12), Integer.valueOf(i11));
            }
            if ((Integer.MIN_VALUE & i10) != 0) {
                throw g.j("reserved bit set: %s", Integer.valueOf(i10));
            }
            g.n(this.f496a, i11);
            this.f496a.writeByte(b10 & 255);
            this.f496a.writeByte(b11 & 255);
            this.f496a.writeInt(i10 & com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER);
        }

        @Override // ac.c
        public synchronized void f(boolean z10, int i10, int i11) {
            if (this.f501f) {
                throw new IOException("closed");
            }
            e(0, 8, (byte) 6, z10 ? (byte) 1 : (byte) 0);
            this.f496a.writeInt(i10);
            this.f496a.writeInt(i11);
            this.f496a.flush();
        }

        @Override // ac.c
        public synchronized void flush() {
            if (this.f501f) {
                throw new IOException("closed");
            }
            this.f496a.flush();
        }

        public void k(boolean z10, int i10, List<ac.d> list) throws IOException {
            if (this.f501f) {
                throw new IOException("closed");
            }
            this.f499d.e(list);
            long size = this.f498c.size();
            int iMin = (int) Math.min(this.f500e, size);
            long j10 = iMin;
            byte b10 = size == j10 ? (byte) 4 : (byte) 0;
            if (z10) {
                b10 = (byte) (b10 | 1);
            }
            e(i10, iMin, (byte) 1, b10);
            this.f496a.X(this.f498c, j10);
            if (size > j10) {
                t(i10, size - j10);
            }
        }

        @Override // ac.c
        public synchronized void m(int i10, ac.a aVar, byte[] bArr) {
            if (this.f501f) {
                throw new IOException("closed");
            }
            if (aVar.f442a == -1) {
                throw g.j("errorCode.httpCode == -1", new Object[0]);
            }
            e(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f496a.writeInt(i10);
            this.f496a.writeInt(aVar.f442a);
            if (bArr.length > 0) {
                this.f496a.write(bArr);
            }
            this.f496a.flush();
        }

        @Override // ac.c
        public synchronized void q() {
            if (this.f501f) {
                throw new IOException("closed");
            }
            if (this.f497b) {
                if (g.f481a.isLoggable(Level.FINE)) {
                    g.f481a.fine(String.format(">> CONNECTION %s", g.f482b.q()));
                }
                this.f496a.write(g.f482b.B());
                this.f496a.flush();
            }
        }

        public final void t(int i10, long j10) {
            while (j10 > 0) {
                int iMin = (int) Math.min(this.f500e, j10);
                long j11 = iMin;
                j10 -= j11;
                e(i10, iMin, (byte) 9, j10 == 0 ? (byte) 4 : (byte) 0);
                this.f496a.X(this.f498c, j11);
            }
        }

        @Override // ac.c
        public synchronized void x(i iVar) {
            if (this.f501f) {
                throw new IOException("closed");
            }
            this.f500e = iVar.c(this.f500e);
            e(0, 0, (byte) 4, (byte) 1);
            this.f496a.flush();
        }
    }

    public static IllegalArgumentException j(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(Locale.US, str, objArr));
    }

    public static IOException k(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(Locale.US, str, objArr));
    }

    public static int l(int i10, byte b10, short s10) throws IOException {
        if ((b10 & 8) != 0) {
            i10--;
        }
        if (s10 <= i10) {
            return (short) (i10 - s10);
        }
        throw k("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s10), Integer.valueOf(i10));
    }

    public static int m(oe.f fVar) {
        return (fVar.readByte() & 255) | ((fVar.readByte() & 255) << 16) | ((fVar.readByte() & 255) << 8);
    }

    public static void n(oe.e eVar, int i10) {
        eVar.writeByte((i10 >>> 16) & 255);
        eVar.writeByte((i10 >>> 8) & 255);
        eVar.writeByte(i10 & 255);
    }

    @Override // ac.j
    public ac.b a(oe.f fVar, boolean z10) {
        return new c(fVar, 4096, z10);
    }

    @Override // ac.j
    public ac.c b(oe.e eVar, boolean z10) {
        return new d(eVar, z10);
    }
}
