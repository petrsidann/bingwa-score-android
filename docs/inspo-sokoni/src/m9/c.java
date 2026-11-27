package m9;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class c implements Closeable, Flushable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Pattern f13013o = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String[] f13014p = new String[128];

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String[] f13015q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Writer f13016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f13017b = new int[32];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13018c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f13019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f13020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13021f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f13022l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f13023m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f13024n;

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f13014p[i10] = String.format("\\u%04x", Integer.valueOf(i10));
        }
        String[] strArr = f13014p;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f13015q = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        c0(6);
        this.f13020e = ":";
        this.f13024n = true;
        Objects.requireNonNull(writer, "out == null");
        this.f13016a = writer;
    }

    public static boolean G(Class<? extends Number> cls) {
        return cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    public c B() {
        return v(3, 5, '}');
    }

    public final boolean C() {
        return this.f13024n;
    }

    public final boolean D() {
        return this.f13022l;
    }

    public boolean E() {
        return this.f13021f;
    }

    public c I(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f13023m != null) {
            throw new IllegalStateException();
        }
        if (this.f13018c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f13023m = str;
        return this;
    }

    public final void J() throws IOException {
        if (this.f13019d == null) {
            return;
        }
        this.f13016a.write(10);
        int i10 = this.f13018c;
        for (int i11 = 1; i11 < i10; i11++) {
            this.f13016a.write(this.f13019d);
        }
    }

    public c L() throws IOException {
        if (this.f13023m != null) {
            if (!this.f13024n) {
                this.f13023m = null;
                return this;
            }
            p0();
        }
        e();
        this.f13016a.write("null");
        return this;
    }

    public final c O(int i10, char c10) throws IOException {
        e();
        c0(i10);
        this.f13016a.write(c10);
        return this;
    }

    public final int Q() {
        int i10 = this.f13018c;
        if (i10 != 0) {
            return this.f13017b[i10 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void c0(int i10) {
        int i11 = this.f13018c;
        int[] iArr = this.f13017b;
        if (i11 == iArr.length) {
            this.f13017b = Arrays.copyOf(iArr, i11 * 2);
        }
        int[] iArr2 = this.f13017b;
        int i12 = this.f13018c;
        this.f13018c = i12 + 1;
        iArr2[i12] = i10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f13016a.close();
        int i10 = this.f13018c;
        if (i10 > 1 || (i10 == 1 && this.f13017b[i10 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f13018c = 0;
    }

    public final void d() throws IOException {
        int iQ = Q();
        if (iQ == 5) {
            this.f13016a.write(44);
        } else if (iQ != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        J();
        d0(4);
    }

    public final void d0(int i10) {
        this.f13017b[this.f13018c - 1] = i10;
    }

    public final void e() throws IOException {
        int iQ = Q();
        if (iQ == 1) {
            d0(2);
        } else {
            if (iQ != 2) {
                if (iQ == 4) {
                    this.f13016a.append((CharSequence) this.f13020e);
                    d0(5);
                    return;
                }
                if (iQ != 6) {
                    if (iQ != 7) {
                        throw new IllegalStateException("Nesting problem.");
                    }
                    if (!this.f13021f) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                }
                d0(7);
                return;
            }
            this.f13016a.append(',');
        }
        J();
    }

    public final void e0(boolean z10) {
        this.f13022l = z10;
    }

    public final void f0(String str) {
        String str2;
        if (str.length() == 0) {
            this.f13019d = null;
            str2 = ":";
        } else {
            this.f13019d = str;
            str2 = ": ";
        }
        this.f13020e = str2;
    }

    public void flush() throws IOException {
        if (this.f13018c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f13016a.flush();
    }

    public final void g0(boolean z10) {
        this.f13021f = z10;
    }

    public final void h0(boolean z10) {
        this.f13024n = z10;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0034  */
    public final void i0(String str) throws IOException {
        String str2;
        String[] strArr = this.f13022l ? f13015q : f13014p;
        this.f13016a.write(34);
        int length = str.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i10 < i11) {
                        this.f13016a.write(str, i10, i11 - i10);
                    }
                    this.f13016a.write(str2);
                    i10 = i11 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i10 < i11) {
                    this.f13016a.write(str, i10, i11 - i10);
                }
                this.f13016a.write(str2);
                i10 = i11 + 1;
            }
        }
        if (i10 < length) {
            this.f13016a.write(str, i10, length - i10);
        }
        this.f13016a.write(34);
    }

    public c j0(double d10) throws IOException {
        p0();
        if (this.f13021f || !(Double.isNaN(d10) || Double.isInfinite(d10))) {
            e();
            this.f13016a.append((CharSequence) Double.toString(d10));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d10);
    }

    public c k() throws IOException {
        p0();
        return O(1, '[');
    }

    public c k0(long j10) throws IOException {
        p0();
        e();
        this.f13016a.write(Long.toString(j10));
        return this;
    }

    public c l0(Boolean bool) throws IOException {
        if (bool == null) {
            return L();
        }
        p0();
        e();
        this.f13016a.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public c m0(Number number) throws IOException {
        if (number == null) {
            return L();
        }
        p0();
        String string = number.toString();
        if (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!G(cls) && !f13013o.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        } else if (!this.f13021f) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + string);
        }
        e();
        this.f13016a.append((CharSequence) string);
        return this;
    }

    public c n0(String str) throws IOException {
        if (str == null) {
            return L();
        }
        p0();
        e();
        i0(str);
        return this;
    }

    public c o0(boolean z10) throws IOException {
        p0();
        e();
        this.f13016a.write(z10 ? "true" : "false");
        return this;
    }

    public final void p0() throws IOException {
        if (this.f13023m != null) {
            d();
            i0(this.f13023m);
            this.f13023m = null;
        }
    }

    public c t() throws IOException {
        p0();
        return O(3, '{');
    }

    public final c v(int i10, int i11, char c10) throws IOException {
        int iQ = Q();
        if (iQ != i11 && iQ != i10) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f13023m != null) {
            throw new IllegalStateException("Dangling name: " + this.f13023m);
        }
        this.f13018c--;
        if (iQ == i11) {
            J();
        }
        this.f13016a.write(c10);
        return this;
    }

    public c z() {
        return v(1, 2, ']');
    }
}
