package vb;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class a1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f17239c = Logger.getLogger(a1.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e<byte[]> f17240d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d<String> f17241e = new b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final l6.a f17242f = l6.a.a().k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f17243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f17244b;

    public class a implements e<byte[]> {
    }

    public class b implements d<String> {
        @Override // vb.a1.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String b(String str) {
            return str;
        }

        @Override // vb.a1.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a(String str) {
            return str;
        }
    }

    public static class c<T> extends g<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final d<T> f17245f;

        public c(String str, boolean z10, d<T> dVar) {
            super(str, z10, dVar, null);
            j6.m.l(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
            this.f17245f = (d) j6.m.p(dVar, "marshaller");
        }

        public /* synthetic */ c(String str, boolean z10, d dVar, a aVar) {
            this(str, z10, dVar);
        }

        @Override // vb.a1.g
        public T h(byte[] bArr) {
            return this.f17245f.b(new String(bArr, j6.c.f11261a));
        }

        @Override // vb.a1.g
        public byte[] j(T t10) {
            return ((String) j6.m.p(this.f17245f.a(t10), "null marshaller.toAsciiString()")).getBytes(j6.c.f11261a);
        }
    }

    public interface d<T> {
        String a(T t10);

        T b(String str);
    }

    public interface e<T> {
    }

    public interface f<T> {
        InputStream a(T t10);

        T b(InputStream inputStream);
    }

    public static abstract class g<T> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final BitSet f17246e = b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f17248b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f17249c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f17250d;

        public g(String str, boolean z10, Object obj) {
            String str2 = (String) j6.m.p(str, "name");
            this.f17247a = str2;
            String strK = k(str2.toLowerCase(Locale.ROOT), z10);
            this.f17248b = strK;
            this.f17249c = strK.getBytes(j6.c.f11261a);
            this.f17250d = obj;
        }

        public /* synthetic */ g(String str, boolean z10, Object obj, a aVar) {
            this(str, z10, obj);
        }

        public static BitSet b() {
            BitSet bitSet = new BitSet(127);
            bitSet.set(45);
            bitSet.set(95);
            bitSet.set(46);
            for (char c10 = '0'; c10 <= '9'; c10 = (char) (c10 + 1)) {
                bitSet.set(c10);
            }
            for (char c11 = 'a'; c11 <= 'z'; c11 = (char) (c11 + 1)) {
                bitSet.set(c11);
            }
            return bitSet;
        }

        public static <T> g<T> e(String str, d<T> dVar) {
            return f(str, false, dVar);
        }

        public static <T> g<T> f(String str, boolean z10, d<T> dVar) {
            return new c(str, z10, dVar, null);
        }

        public static <T> g<T> g(String str, boolean z10, j<T> jVar) {
            return new i(str, z10, jVar, null);
        }

        public static String k(String str, boolean z10) {
            j6.m.p(str, "name");
            j6.m.e(!str.isEmpty(), "token must have at least 1 tchar");
            if (str.equals("connection")) {
                a1.f17239c.log(Level.WARNING, "Metadata key is 'Connection', which should not be used. That is used by HTTP/1 for connection-specific headers which are not to be forwarded. There is probably an HTTP/1 conversion bug. Simply removing the Connection header is not enough; you should remove all headers it references as well. See RFC 7230 section 6.1", (Throwable) new RuntimeException("exception to show backtrace"));
            }
            for (int i10 = 0; i10 < str.length(); i10++) {
                char cCharAt = str.charAt(i10);
                if (!z10 || cCharAt != ':' || i10 != 0) {
                    j6.m.g(f17246e.get(cCharAt), "Invalid character '%s' in key name '%s'", cCharAt, str);
                }
            }
            return str;
        }

        public byte[] a() {
            return this.f17249c;
        }

        public final <M> M c(Class<M> cls) {
            if (cls.isInstance(this.f17250d)) {
                return cls.cast(this.f17250d);
            }
            return null;
        }

        public final String d() {
            return this.f17248b;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f17248b.equals(((g) obj).f17248b);
        }

        public abstract T h(byte[] bArr);

        public final int hashCode() {
            return this.f17248b.hashCode();
        }

        public boolean i() {
            return false;
        }

        public abstract byte[] j(T t10);

        public String toString() {
            return "Key{name='" + this.f17248b + "'}";
        }
    }

    public static final class h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f<T> f17251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f17252b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile byte[] f17253c;

        public h(f<T> fVar, T t10) {
            this.f17251a = fVar;
            this.f17252b = t10;
        }

        public static <T> h<T> a(g<T> gVar, T t10) {
            return new h<>((f) j6.m.o(b(gVar)), t10);
        }

        public static <T> f<T> b(g<T> gVar) {
            return (f) gVar.c(f.class);
        }

        public byte[] c() {
            if (this.f17253c == null) {
                synchronized (this) {
                    if (this.f17253c == null) {
                        this.f17253c = a1.r(e());
                    }
                }
            }
            return this.f17253c;
        }

        public <T2> T2 d(g<T2> gVar) {
            f fVarB;
            return (!gVar.i() || (fVarB = b(gVar)) == null) ? gVar.h(c()) : (T2) fVarB.b(e());
        }

        public InputStream e() {
            return (InputStream) j6.m.p(this.f17251a.a(this.f17252b), "null marshaller.toStream()");
        }
    }

    public static final class i<T> extends g<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final j<T> f17254f;

        public i(String str, boolean z10, j<T> jVar) {
            super(str, z10, jVar, null);
            j6.m.l(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
            this.f17254f = (j) j6.m.p(jVar, "marshaller");
        }

        public /* synthetic */ i(String str, boolean z10, j jVar, a aVar) {
            this(str, z10, jVar);
        }

        @Override // vb.a1.g
        public T h(byte[] bArr) {
            return this.f17254f.b(bArr);
        }

        @Override // vb.a1.g
        public byte[] j(T t10) {
            return (byte[]) j6.m.p(this.f17254f.a(t10), "null marshaller.toAsciiString()");
        }
    }

    public interface j<T> {
        byte[] a(T t10);

        T b(byte[] bArr);
    }

    public a1() {
    }

    public a1(int i10, Object[] objArr) {
        this.f17244b = i10;
        this.f17243a = objArr;
    }

    public a1(int i10, byte[]... bArr) {
        this(i10, (Object[]) bArr);
    }

    public a1(byte[]... bArr) {
        this(bArr.length / 2, bArr);
    }

    public static byte[] r(InputStream inputStream) {
        try {
            return l6.b.d(inputStream);
        } catch (IOException e10) {
            throw new RuntimeException("failure reading serialized stream", e10);
        }
    }

    public final boolean c(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    public final int d() {
        Object[] objArr = this.f17243a;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    public <T> void e(g<T> gVar) {
        if (i()) {
            return;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f17244b; i11++) {
            if (!c(gVar.a(), o(i11))) {
                n(i10, o(i11));
                t(i10, s(i11));
                i10++;
            }
        }
        Arrays.fill(this.f17243a, i10 * 2, k(), (Object) null);
        this.f17244b = i10;
    }

    public final void f(int i10) {
        Object[] objArr = new Object[i10];
        if (!i()) {
            System.arraycopy(this.f17243a, 0, objArr, 0, k());
        }
        this.f17243a = objArr;
    }

    public <T> T g(g<T> gVar) {
        for (int i10 = this.f17244b - 1; i10 >= 0; i10--) {
            if (c(gVar.a(), o(i10))) {
                return (T) w(i10, gVar);
            }
        }
        return null;
    }

    public int h() {
        return this.f17244b;
    }

    public final boolean i() {
        return this.f17244b == 0;
    }

    public Set<String> j() {
        if (i()) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.f17244b);
        for (int i10 = 0; i10 < this.f17244b; i10++) {
            hashSet.add(new String(o(i10), 0));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public final int k() {
        return this.f17244b * 2;
    }

    public final void l() {
        if (k() == 0 || k() == d()) {
            f(Math.max(k() * 2, 8));
        }
    }

    public void m(a1 a1Var) {
        if (a1Var.i()) {
            return;
        }
        int iD = d() - k();
        if (i() || iD < a1Var.k()) {
            f(k() + a1Var.k());
        }
        System.arraycopy(a1Var.f17243a, 0, this.f17243a, k(), a1Var.k());
        this.f17244b += a1Var.f17244b;
    }

    public final void n(int i10, byte[] bArr) {
        this.f17243a[i10 * 2] = bArr;
    }

    public final byte[] o(int i10) {
        return (byte[]) this.f17243a[i10 * 2];
    }

    public <T> void p(g<T> gVar, T t10) {
        j6.m.p(gVar, "key");
        j6.m.p(t10, "value");
        l();
        n(this.f17244b, gVar.a());
        if (gVar.i()) {
            t(this.f17244b, h.a(gVar, t10));
        } else {
            u(this.f17244b, gVar.j(t10));
        }
        this.f17244b++;
    }

    public byte[][] q() {
        byte[][] bArr = new byte[k()][];
        Object[] objArr = this.f17243a;
        if (objArr instanceof byte[][]) {
            System.arraycopy(objArr, 0, bArr, 0, k());
        } else {
            for (int i10 = 0; i10 < this.f17244b; i10++) {
                int i11 = i10 * 2;
                bArr[i11] = o(i10);
                bArr[i11 + 1] = v(i10);
            }
        }
        return bArr;
    }

    public final Object s(int i10) {
        return this.f17243a[(i10 * 2) + 1];
    }

    public final void t(int i10, Object obj) {
        if (this.f17243a instanceof byte[][]) {
            f(d());
        }
        this.f17243a[(i10 * 2) + 1] = obj;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Metadata(");
        for (int i10 = 0; i10 < this.f17244b; i10++) {
            if (i10 != 0) {
                sb2.append(',');
            }
            byte[] bArrO = o(i10);
            Charset charset = j6.c.f11261a;
            String str = new String(bArrO, charset);
            sb2.append(str);
            sb2.append('=');
            sb2.append(str.endsWith("-bin") ? f17242f.e(v(i10)) : new String(v(i10), charset));
        }
        sb2.append(')');
        return sb2.toString();
    }

    public final void u(int i10, byte[] bArr) {
        this.f17243a[(i10 * 2) + 1] = bArr;
    }

    public final byte[] v(int i10) {
        Object objS = s(i10);
        return objS instanceof byte[] ? (byte[]) objS : ((h) objS).c();
    }

    public final <T> T w(int i10, g<T> gVar) {
        Object objS = s(i10);
        return objS instanceof byte[] ? gVar.h((byte[]) objS) : (T) ((h) objS).d(gVar);
    }
}
