package h9;

import e9.p;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class f extends m9.a {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Reader f9813y = new a();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Object f9814z = new Object();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Object[] f9815u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f9816v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String[] f9817w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int[] f9818x;

    public class a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i10, int i11) {
            throw new AssertionError();
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9819a;

        static {
            int[] iArr = new int[m9.b.values().length];
            f9819a = iArr;
            try {
                iArr[m9.b.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9819a[m9.b.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9819a[m9.b.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9819a[m9.b.END_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public f(e9.k kVar) {
        super(f9813y);
        this.f9815u = new Object[32];
        this.f9816v = 0;
        this.f9817w = new String[32];
        this.f9818x = new int[32];
        D0(kVar);
    }

    private String E(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('$');
        int i10 = 0;
        while (true) {
            int i11 = this.f9816v;
            if (i10 >= i11) {
                return sb2.toString();
            }
            Object[] objArr = this.f9815u;
            Object obj = objArr[i10];
            if (obj instanceof e9.h) {
                i10++;
                if (i10 < i11 && (objArr[i10] instanceof Iterator)) {
                    int i12 = this.f9818x[i10];
                    if (z10 && i12 > 0 && (i10 == i11 - 1 || i10 == i11 - 2)) {
                        i12--;
                    }
                    sb2.append('[');
                    sb2.append(i12);
                    sb2.append(']');
                }
            } else if ((obj instanceof e9.n) && (i10 = i10 + 1) < i11 && (objArr[i10] instanceof Iterator)) {
                sb2.append('.');
                String str = this.f9817w[i10];
                if (str != null) {
                    sb2.append(str);
                }
            }
            i10++;
        }
    }

    private String O() {
        return " at path " + D();
    }

    public final Object A0() {
        return this.f9815u[this.f9816v - 1];
    }

    @Override // m9.a
    public void B() {
        x0(m9.b.END_OBJECT);
        this.f9817w[this.f9816v - 1] = null;
        B0();
        B0();
        int i10 = this.f9816v;
        if (i10 > 0) {
            int[] iArr = this.f9818x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    public final Object B0() {
        Object[] objArr = this.f9815u;
        int i10 = this.f9816v - 1;
        this.f9816v = i10;
        Object obj = objArr[i10];
        objArr[i10] = null;
        return obj;
    }

    public void C0() {
        x0(m9.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) A0()).next();
        D0(entry.getValue());
        D0(new p((String) entry.getKey()));
    }

    @Override // m9.a
    public String D() {
        return E(false);
    }

    public final void D0(Object obj) {
        int i10 = this.f9816v;
        Object[] objArr = this.f9815u;
        if (i10 == objArr.length) {
            int i11 = i10 * 2;
            this.f9815u = Arrays.copyOf(objArr, i11);
            this.f9818x = Arrays.copyOf(this.f9818x, i11);
            this.f9817w = (String[]) Arrays.copyOf(this.f9817w, i11);
        }
        Object[] objArr2 = this.f9815u;
        int i12 = this.f9816v;
        this.f9816v = i12 + 1;
        objArr2[i12] = obj;
    }

    @Override // m9.a
    public String G() {
        return E(true);
    }

    @Override // m9.a
    public boolean I() throws m9.d {
        m9.b bVarL0 = l0();
        return (bVarL0 == m9.b.END_OBJECT || bVarL0 == m9.b.END_ARRAY || bVarL0 == m9.b.END_DOCUMENT) ? false : true;
    }

    @Override // m9.a
    public boolean Q() {
        x0(m9.b.BOOLEAN);
        boolean zE = ((p) B0()).e();
        int i10 = this.f9816v;
        if (i10 > 0) {
            int[] iArr = this.f9818x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return zE;
    }

    @Override // m9.a
    public double c0() throws m9.d {
        m9.b bVarL0 = l0();
        m9.b bVar = m9.b.NUMBER;
        if (bVarL0 != bVar && bVarL0 != m9.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarL0 + O());
        }
        double dR = ((p) A0()).r();
        if (!J() && (Double.isNaN(dR) || Double.isInfinite(dR))) {
            throw new m9.d("JSON forbids NaN and infinities: " + dR);
        }
        B0();
        int i10 = this.f9816v;
        if (i10 > 0) {
            int[] iArr = this.f9818x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return dR;
    }

    @Override // m9.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f9815u = new Object[]{f9814z};
        this.f9816v = 1;
    }

    @Override // m9.a
    public void d() {
        x0(m9.b.BEGIN_ARRAY);
        D0(((e9.h) A0()).iterator());
        this.f9818x[this.f9816v - 1] = 0;
    }

    @Override // m9.a
    public int d0() throws m9.d {
        m9.b bVarL0 = l0();
        m9.b bVar = m9.b.NUMBER;
        if (bVarL0 != bVar && bVarL0 != m9.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarL0 + O());
        }
        int iS = ((p) A0()).s();
        B0();
        int i10 = this.f9816v;
        if (i10 > 0) {
            int[] iArr = this.f9818x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return iS;
    }

    @Override // m9.a
    public void e() {
        x0(m9.b.BEGIN_OBJECT);
        D0(((e9.n) A0()).s().iterator());
    }

    @Override // m9.a
    public long e0() throws m9.d {
        m9.b bVarL0 = l0();
        m9.b bVar = m9.b.NUMBER;
        if (bVarL0 != bVar && bVarL0 != m9.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarL0 + O());
        }
        long jT = ((p) A0()).t();
        B0();
        int i10 = this.f9816v;
        if (i10 > 0) {
            int[] iArr = this.f9818x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return jT;
    }

    @Override // m9.a
    public String f0() {
        return z0(false);
    }

    @Override // m9.a
    public void h0() {
        x0(m9.b.NULL);
        B0();
        int i10 = this.f9816v;
        if (i10 > 0) {
            int[] iArr = this.f9818x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // m9.a
    public String j0() throws m9.d {
        m9.b bVarL0 = l0();
        m9.b bVar = m9.b.STRING;
        if (bVarL0 == bVar || bVarL0 == m9.b.NUMBER) {
            String strK = ((p) B0()).k();
            int i10 = this.f9816v;
            if (i10 > 0) {
                int[] iArr = this.f9818x;
                int i11 = i10 - 1;
                iArr[i11] = iArr[i11] + 1;
            }
            return strK;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + bVarL0 + O());
    }

    @Override // m9.a
    public m9.b l0() throws m9.d {
        if (this.f9816v == 0) {
            return m9.b.END_DOCUMENT;
        }
        Object objA0 = A0();
        if (objA0 instanceof Iterator) {
            boolean z10 = this.f9815u[this.f9816v - 2] instanceof e9.n;
            Iterator it = (Iterator) objA0;
            if (!it.hasNext()) {
                return z10 ? m9.b.END_OBJECT : m9.b.END_ARRAY;
            }
            if (z10) {
                return m9.b.NAME;
            }
            D0(it.next());
            return l0();
        }
        if (objA0 instanceof e9.n) {
            return m9.b.BEGIN_OBJECT;
        }
        if (objA0 instanceof e9.h) {
            return m9.b.BEGIN_ARRAY;
        }
        if (objA0 instanceof p) {
            p pVar = (p) objA0;
            if (pVar.z()) {
                return m9.b.STRING;
            }
            if (pVar.w()) {
                return m9.b.BOOLEAN;
            }
            if (pVar.y()) {
                return m9.b.NUMBER;
            }
            throw new AssertionError();
        }
        if (objA0 instanceof e9.m) {
            return m9.b.NULL;
        }
        if (objA0 == f9814z) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new m9.d("Custom JsonElement subclass " + objA0.getClass().getName() + " is not supported");
    }

    @Override // m9.a
    public String toString() {
        return f.class.getSimpleName() + O();
    }

    @Override // m9.a
    public void v0() throws m9.d {
        int i10 = b.f9819a[l0().ordinal()];
        if (i10 == 1) {
            z0(true);
            return;
        }
        if (i10 == 2) {
            z();
            return;
        }
        if (i10 == 3) {
            B();
            return;
        }
        if (i10 != 4) {
            B0();
            int i11 = this.f9816v;
            if (i11 > 0) {
                int[] iArr = this.f9818x;
                int i12 = i11 - 1;
                iArr[i12] = iArr[i12] + 1;
            }
        }
    }

    public final void x0(m9.b bVar) {
        if (l0() == bVar) {
            return;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + l0() + O());
    }

    public e9.k y0() throws m9.d {
        m9.b bVarL0 = l0();
        if (bVarL0 != m9.b.NAME && bVarL0 != m9.b.END_ARRAY && bVarL0 != m9.b.END_OBJECT && bVarL0 != m9.b.END_DOCUMENT) {
            e9.k kVar = (e9.k) A0();
            v0();
            return kVar;
        }
        throw new IllegalStateException("Unexpected " + bVarL0 + " when reading a JsonElement.");
    }

    @Override // m9.a
    public void z() {
        x0(m9.b.END_ARRAY);
        B0();
        B0();
        int i10 = this.f9816v;
        if (i10 > 0) {
            int[] iArr = this.f9818x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    public final String z0(boolean z10) {
        x0(m9.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) A0()).next();
        String str = (String) entry.getKey();
        this.f9817w[this.f9816v - 1] = z10 ? "<skipped>" : str;
        D0(entry.getValue());
        return str;
    }
}
