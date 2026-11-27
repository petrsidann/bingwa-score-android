package m9;

import d9.a0;
import d9.d0;
import g9.f;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class a implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Reader f12987a;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f12995n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f12996o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f12997p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int[] f12998q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String[] f13000s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int[] f13001t;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12988b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final char[] f12989c = new char[1024];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12990d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12991e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12992f = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12993l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12994m = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f12999r = 0 + 1;

    /* JADX INFO: renamed from: m9.a$a, reason: collision with other inner class name */
    public class C0219a extends f {
        @Override // g9.f
        public void a(a aVar) throws IOException {
            int i10;
            if (aVar instanceof h9.f) {
                ((h9.f) aVar).C0();
                return;
            }
            int iV = aVar.f12994m;
            if (iV == 0) {
                iV = aVar.v();
            }
            if (iV == 13) {
                i10 = 9;
            } else if (iV == 12) {
                i10 = 8;
            } else {
                if (iV != 14) {
                    throw new IllegalStateException("Expected a name but was " + aVar.l0() + aVar.O());
                }
                i10 = 10;
            }
            aVar.f12994m = i10;
        }
    }

    static {
        f.f9073a = new C0219a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f12998q = iArr;
        iArr[0] = 6;
        this.f13000s = new String[32];
        this.f13001t = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f12987a = reader;
    }

    public void B() throws IOException {
        int iV = this.f12994m;
        if (iV == 0) {
            iV = v();
        }
        if (iV != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + l0() + O());
        }
        int i10 = this.f12999r - 1;
        this.f12999r = i10;
        this.f13000s[i10] = null;
        int[] iArr = this.f13001t;
        int i11 = i10 - 1;
        iArr[i11] = iArr[i11] + 1;
        this.f12994m = 0;
    }

    public final boolean C(int i10) throws IOException {
        int i11;
        int i12;
        char[] cArr = this.f12989c;
        int i13 = this.f12993l;
        int i14 = this.f12990d;
        this.f12993l = i13 - i14;
        int i15 = this.f12991e;
        if (i15 != i14) {
            int i16 = i15 - i14;
            this.f12991e = i16;
            System.arraycopy(cArr, i14, cArr, 0, i16);
        } else {
            this.f12991e = 0;
        }
        this.f12990d = 0;
        do {
            Reader reader = this.f12987a;
            int i17 = this.f12991e;
            int i18 = reader.read(cArr, i17, cArr.length - i17);
            if (i18 == -1) {
                return false;
            }
            i11 = this.f12991e + i18;
            this.f12991e = i11;
            if (this.f12992f == 0 && (i12 = this.f12993l) == 0 && i11 > 0 && cArr[0] == 65279) {
                this.f12990d++;
                this.f12993l = i12 + 1;
                i10++;
            }
        } while (i11 < i10);
        return true;
    }

    public String D() {
        return E(false);
    }

    public final String E(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('$');
        int i10 = 0;
        while (true) {
            int i11 = this.f12999r;
            if (i10 >= i11) {
                return sb2.toString();
            }
            int i12 = this.f12998q[i10];
            if (i12 == 1 || i12 == 2) {
                int i13 = this.f13001t[i10];
                if (z10 && i13 > 0 && i10 == i11 - 1) {
                    i13--;
                }
                sb2.append('[');
                sb2.append(i13);
                sb2.append(']');
            } else if (i12 == 3 || i12 == 4 || i12 == 5) {
                sb2.append('.');
                String str = this.f13000s[i10];
                if (str != null) {
                    sb2.append(str);
                }
            }
            i10++;
        }
    }

    public String G() {
        return E(true);
    }

    public boolean I() throws IOException {
        int iV = this.f12994m;
        if (iV == 0) {
            iV = v();
        }
        return (iV == 2 || iV == 4 || iV == 17) ? false : true;
    }

    public final boolean J() {
        return this.f12988b;
    }

    public final boolean L(char c10) throws IOException {
        if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
            return false;
        }
        if (c10 != '#') {
            if (c10 == ',') {
                return false;
            }
            if (c10 != '/' && c10 != '=') {
                if (c10 == '{' || c10 == '}' || c10 == ':') {
                    return false;
                }
                if (c10 != ';') {
                    switch (c10) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        k();
        return false;
    }

    public String O() {
        return " at line " + (this.f12992f + 1) + " column " + ((this.f12990d - this.f12993l) + 1) + " path " + D();
    }

    public boolean Q() throws IOException {
        int iV = this.f12994m;
        if (iV == 0) {
            iV = v();
        }
        if (iV == 5) {
            this.f12994m = 0;
            int[] iArr = this.f13001t;
            int i10 = this.f12999r - 1;
            iArr[i10] = iArr[i10] + 1;
            return true;
        }
        if (iV == 6) {
            this.f12994m = 0;
            int[] iArr2 = this.f13001t;
            int i11 = this.f12999r - 1;
            iArr2[i11] = iArr2[i11] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + l0() + O());
    }

    public double c0() throws IOException {
        String strI0;
        int iV = this.f12994m;
        if (iV == 0) {
            iV = v();
        }
        if (iV == 15) {
            this.f12994m = 0;
            int[] iArr = this.f13001t;
            int i10 = this.f12999r - 1;
            iArr[i10] = iArr[i10] + 1;
            return this.f12995n;
        }
        if (iV == 16) {
            this.f12997p = new String(this.f12989c, this.f12990d, this.f12996o);
            this.f12990d += this.f12996o;
        } else {
            if (iV == 8 || iV == 9) {
                strI0 = i0(iV == 8 ? '\'' : '\"');
            } else if (iV == 10) {
                strI0 = k0();
            } else if (iV != 11) {
                throw new IllegalStateException("Expected a double but was " + l0() + O());
            }
            this.f12997p = strI0;
        }
        this.f12994m = 11;
        double d10 = Double.parseDouble(this.f12997p);
        if (!this.f12988b && (Double.isNaN(d10) || Double.isInfinite(d10))) {
            throw new d("JSON forbids NaN and infinities: " + d10 + O());
        }
        this.f12997p = null;
        this.f12994m = 0;
        int[] iArr2 = this.f13001t;
        int i11 = this.f12999r - 1;
        iArr2[i11] = iArr2[i11] + 1;
        return d10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f12994m = 0;
        this.f12998q[0] = 8;
        this.f12999r = 1;
        this.f12987a.close();
    }

    public void d() throws IOException {
        int iV = this.f12994m;
        if (iV == 0) {
            iV = v();
        }
        if (iV == 3) {
            o0(1);
            this.f13001t[this.f12999r - 1] = 0;
            this.f12994m = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + l0() + O());
        }
    }

    public int d0() throws IOException {
        String strI0;
        int iV = this.f12994m;
        if (iV == 0) {
            iV = v();
        }
        if (iV == 15) {
            long j10 = this.f12995n;
            int i10 = (int) j10;
            if (j10 == i10) {
                this.f12994m = 0;
                int[] iArr = this.f13001t;
                int i11 = this.f12999r - 1;
                iArr[i11] = iArr[i11] + 1;
                return i10;
            }
            throw new NumberFormatException("Expected an int but was " + this.f12995n + O());
        }
        if (iV == 16) {
            this.f12997p = new String(this.f12989c, this.f12990d, this.f12996o);
            this.f12990d += this.f12996o;
        } else {
            if (iV != 8 && iV != 9 && iV != 10) {
                throw new IllegalStateException("Expected an int but was " + l0() + O());
            }
            if (iV == 10) {
                strI0 = k0();
            } else {
                strI0 = i0(iV == 8 ? '\'' : '\"');
            }
            this.f12997p = strI0;
            try {
                int i12 = Integer.parseInt(this.f12997p);
                this.f12994m = 0;
                int[] iArr2 = this.f13001t;
                int i13 = this.f12999r - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return i12;
            } catch (NumberFormatException unused) {
            }
        }
        this.f12994m = 11;
        double d10 = Double.parseDouble(this.f12997p);
        int i14 = (int) d10;
        if (i14 != d10) {
            throw new NumberFormatException("Expected an int but was " + this.f12997p + O());
        }
        this.f12997p = null;
        this.f12994m = 0;
        int[] iArr3 = this.f13001t;
        int i15 = this.f12999r - 1;
        iArr3[i15] = iArr3[i15] + 1;
        return i14;
    }

    public void e() throws IOException {
        int iV = this.f12994m;
        if (iV == 0) {
            iV = v();
        }
        if (iV == 1) {
            o0(3);
            this.f12994m = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + l0() + O());
        }
    }

    public long e0() throws IOException {
        String strI0;
        int iV = this.f12994m;
        if (iV == 0) {
            iV = v();
        }
        if (iV == 15) {
            this.f12994m = 0;
            int[] iArr = this.f13001t;
            int i10 = this.f12999r - 1;
            iArr[i10] = iArr[i10] + 1;
            return this.f12995n;
        }
        if (iV == 16) {
            this.f12997p = new String(this.f12989c, this.f12990d, this.f12996o);
            this.f12990d += this.f12996o;
        } else {
            if (iV != 8 && iV != 9 && iV != 10) {
                throw new IllegalStateException("Expected a long but was " + l0() + O());
            }
            if (iV == 10) {
                strI0 = k0();
            } else {
                strI0 = i0(iV == 8 ? '\'' : '\"');
            }
            this.f12997p = strI0;
            try {
                long j10 = Long.parseLong(this.f12997p);
                this.f12994m = 0;
                int[] iArr2 = this.f13001t;
                int i11 = this.f12999r - 1;
                iArr2[i11] = iArr2[i11] + 1;
                return j10;
            } catch (NumberFormatException unused) {
            }
        }
        this.f12994m = 11;
        double d10 = Double.parseDouble(this.f12997p);
        long j11 = (long) d10;
        if (j11 != d10) {
            throw new NumberFormatException("Expected a long but was " + this.f12997p + O());
        }
        this.f12997p = null;
        this.f12994m = 0;
        int[] iArr3 = this.f13001t;
        int i12 = this.f12999r - 1;
        iArr3[i12] = iArr3[i12] + 1;
        return j11;
    }

    public String f0() throws IOException {
        char c10;
        String strI0;
        int iV = this.f12994m;
        if (iV == 0) {
            iV = v();
        }
        if (iV == 14) {
            strI0 = k0();
        } else {
            if (iV == 12) {
                c10 = '\'';
            } else {
                if (iV != 13) {
                    throw new IllegalStateException("Expected a name but was " + l0() + O());
                }
                c10 = '\"';
            }
            strI0 = i0(c10);
        }
        this.f12994m = 0;
        this.f13000s[this.f12999r - 1] = strI0;
        return strI0;
    }

    public final int g0(boolean z10) throws IOException {
        int i10;
        char c10;
        char[] cArr = this.f12989c;
        while (true) {
            int i11 = this.f12990d;
            while (true) {
                int i12 = this.f12991e;
                while (true) {
                    if (i11 == i12) {
                        this.f12990d = i11;
                        if (!C(1)) {
                            if (!z10) {
                                return -1;
                            }
                            throw new EOFException("End of input" + O());
                        }
                        i11 = this.f12990d;
                        i12 = this.f12991e;
                    }
                    i10 = i11 + 1;
                    c10 = cArr[i11];
                    if (c10 == '\n') {
                        this.f12992f++;
                        this.f12993l = i10;
                    } else if (c10 == ' ' || c10 == '\r' || c10 == '\t') {
                    }
                    i11 = i10;
                }
                if (c10 != '/') {
                    this.f12990d = i10;
                    if (c10 != '#') {
                        return c10;
                    }
                    k();
                    break;
                }
                this.f12990d = i10;
                if (i10 == i12) {
                    this.f12990d = i10 - 1;
                    boolean zC = C(2);
                    this.f12990d++;
                    if (!zC) {
                        return c10;
                    }
                }
                k();
                int i13 = this.f12990d;
                char c11 = cArr[i13];
                if (c11 != '*') {
                    if (c11 == '/') {
                        this.f12990d = i13 + 1;
                        break;
                    }
                    return c10;
                }
                this.f12990d = i13 + 1;
                if (!s0("*/")) {
                    throw w0("Unterminated comment");
                }
                i11 = this.f12990d + 2;
            }
            t0();
        }
    }

    public void h0() throws IOException {
        int iV = this.f12994m;
        if (iV == 0) {
            iV = v();
        }
        if (iV == 7) {
            this.f12994m = 0;
            int[] iArr = this.f13001t;
            int i10 = this.f12999r - 1;
            iArr[i10] = iArr[i10] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + l0() + O());
    }

    public final String i0(char c10) throws IOException {
        char[] cArr = this.f12989c;
        StringBuilder sb2 = null;
        while (true) {
            int i10 = this.f12990d;
            int i11 = this.f12991e;
            while (true) {
                if (i10 >= i11) {
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max((i10 - i10) * 2, 16));
                    }
                    sb2.append(cArr, i10, i10 - i10);
                    this.f12990d = i10;
                    if (C(1)) {
                        break;
                    }
                    throw w0("Unterminated string");
                }
                int i12 = i10 + 1;
                char c11 = cArr[i10];
                if (c11 == c10) {
                    this.f12990d = i12;
                    int i13 = (i12 - i10) - 1;
                    if (sb2 == null) {
                        return new String(cArr, i10, i13);
                    }
                    sb2.append(cArr, i10, i13);
                    return sb2.toString();
                }
                if (c11 == '\\') {
                    this.f12990d = i12;
                    int i14 = (i12 - i10) - 1;
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max((i14 + 1) * 2, 16));
                    }
                    sb2.append(cArr, i10, i14);
                    sb2.append(p0());
                    break;
                }
                if (c11 == '\n') {
                    this.f12992f++;
                    this.f12993l = i12;
                }
                i10 = i12;
            }
        }
    }

    public String j0() throws IOException {
        String str;
        char c10;
        int iV = this.f12994m;
        if (iV == 0) {
            iV = v();
        }
        if (iV == 10) {
            str = k0();
        } else {
            if (iV == 8) {
                c10 = '\'';
            } else if (iV == 9) {
                c10 = '\"';
            } else if (iV == 11) {
                str = this.f12997p;
                this.f12997p = null;
            } else if (iV == 15) {
                str = Long.toString(this.f12995n);
            } else {
                if (iV != 16) {
                    throw new IllegalStateException("Expected a string but was " + l0() + O());
                }
                str = new String(this.f12989c, this.f12990d, this.f12996o);
                this.f12990d += this.f12996o;
            }
            str = i0(c10);
        }
        this.f12994m = 0;
        int[] iArr = this.f13001t;
        int i10 = this.f12999r - 1;
        iArr[i10] = iArr[i10] + 1;
        return str;
    }

    public final void k() throws IOException {
        if (!this.f12988b) {
            throw w0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    public final String k0() throws IOException {
        String string;
        StringBuilder sb2 = null;
        int i10 = 0;
        while (true) {
            int i11 = 0;
            while (true) {
                int i12 = this.f12990d;
                if (i12 + i11 < this.f12991e) {
                    char c10 = this.f12989c[i12 + i11];
                    if (c10 != '\t' && c10 != '\n' && c10 != '\f' && c10 != '\r' && c10 != ' ') {
                        if (c10 != '#') {
                            if (c10 != ',') {
                                if (c10 != '/' && c10 != '=') {
                                    if (c10 != '{' && c10 != '}' && c10 != ':') {
                                        if (c10 != ';') {
                                            switch (c10) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i11++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        k();
                    }
                    i10 = i11;
                } else if (i11 >= this.f12989c.length) {
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max(i11, 16));
                    }
                    sb2.append(this.f12989c, this.f12990d, i11);
                    this.f12990d += i11;
                    if (!C(1)) {
                    }
                } else if (!C(i11 + 1)) {
                    i10 = i11;
                }
                if (sb2 == null) {
                    string = new String(this.f12989c, this.f12990d, i10);
                } else {
                    sb2.append(this.f12989c, this.f12990d, i10);
                    string = sb2.toString();
                }
                this.f12990d += i10;
                return string;
            }
        }
    }

    public b l0() throws IOException {
        int iV = this.f12994m;
        if (iV == 0) {
            iV = v();
        }
        switch (iV) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final int m0() {
        String str;
        String str2;
        int i10;
        char c10 = this.f12989c[this.f12990d];
        if (c10 == 't' || c10 == 'T') {
            str = "true";
            str2 = "TRUE";
            i10 = 5;
        } else if (c10 == 'f' || c10 == 'F') {
            str = "false";
            str2 = "FALSE";
            i10 = 6;
        } else {
            if (c10 != 'n' && c10 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i10 = 7;
        }
        int length = str.length();
        for (int i11 = 1; i11 < length; i11++) {
            if (this.f12990d + i11 >= this.f12991e && !C(i11 + 1)) {
                return 0;
            }
            char c11 = this.f12989c[this.f12990d + i11];
            if (c11 != str.charAt(i11) && c11 != str2.charAt(i11)) {
                return 0;
            }
        }
        if ((this.f12990d + length < this.f12991e || C(length + 1)) && L(this.f12989c[this.f12990d + length])) {
            return 0;
        }
        this.f12990d += length;
        this.f12994m = i10;
        return i10;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x00f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0030  */
    /* JADX WARN: Code duplicated, block: B:90:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:92:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:97:0x00e9  */
    public final int n0() {
        char c10;
        char c11;
        int i10;
        char[] cArr = this.f12989c;
        int i11 = this.f12990d;
        int i12 = this.f12991e;
        int i13 = 0;
        int i14 = 0;
        char c12 = 0;
        boolean z10 = false;
        boolean z11 = true;
        long j10 = 0;
        while (true) {
            if (i11 + i14 != i12) {
                c10 = cArr[i11 + i14];
                if (c10 != '+') {
                    if (c10 != 'E' || c10 == 'e') {
                        i13 = 0;
                        if (c12 == 2 && c12 != 4) {
                            return 0;
                        }
                        c12 = 5;
                    } else if (c10 != '-') {
                        c11 = 3;
                        if (c10 == '.') {
                            i13 = 0;
                            if (c12 != 2) {
                                return 0;
                            }
                        } else {
                            if (c10 < '0' || c10 > '9') {
                                if (!L(c10)) {
                                    break;
                                }
                                return 0;
                            }
                            if (c12 == 1 || c12 == 0) {
                                j10 = -(c10 - '0');
                                c12 = 2;
                            } else if (c12 == 2) {
                                if (j10 == 0) {
                                    return 0;
                                }
                                long j11 = (10 * j10) - ((long) (c10 - '0'));
                                z11 &= j10 > -922337203685477580L || (j10 == -922337203685477580L && j11 < j10);
                                j10 = j11;
                            } else if (c12 == 3) {
                                i13 = 0;
                                c12 = 4;
                            } else if (c12 == 5 || c12 == 6) {
                                i13 = 0;
                                c12 = 7;
                            }
                            i13 = 0;
                        }
                    } else {
                        c11 = 6;
                        i13 = 0;
                        if (c12 == 0) {
                            c12 = 1;
                            z10 = true;
                        } else if (c12 != 5) {
                            return 0;
                        }
                    }
                    i14++;
                } else {
                    c11 = 6;
                    i13 = 0;
                    if (c12 != 5) {
                        return 0;
                    }
                }
                c12 = c11;
                i14++;
            } else {
                if (i14 == cArr.length) {
                    return i13;
                }
                if (!C(i14 + 1)) {
                    break;
                }
                i11 = this.f12990d;
                i12 = this.f12991e;
                c10 = cArr[i11 + i14];
                if (c10 != '+') {
                    if (c10 != 'E') {
                        i13 = 0;
                        if (c12 == 2) {
                        }
                        c12 = 5;
                    } else {
                        i13 = 0;
                        if (c12 == 2) {
                        }
                        c12 = 5;
                    }
                    i14++;
                } else {
                    c11 = 6;
                    i13 = 0;
                    if (c12 != 5) {
                        return 0;
                    }
                }
                c12 = c11;
                i14++;
            }
        }
        if (c12 == 2 && z11 && ((j10 != Long.MIN_VALUE || z10) && (j10 != 0 || !z10))) {
            if (!z10) {
                j10 = -j10;
            }
            this.f12995n = j10;
            this.f12990d += i14;
            i10 = 15;
        } else {
            if (c12 != 2 && c12 != 4 && c12 != 7) {
                return 0;
            }
            this.f12996o = i14;
            i10 = 16;
        }
        this.f12994m = i10;
        return i10;
    }

    public final void o0(int i10) {
        int i11 = this.f12999r;
        int[] iArr = this.f12998q;
        if (i11 == iArr.length) {
            int i12 = i11 * 2;
            this.f12998q = Arrays.copyOf(iArr, i12);
            this.f13001t = Arrays.copyOf(this.f13001t, i12);
            this.f13000s = (String[]) Arrays.copyOf(this.f13000s, i12);
        }
        int[] iArr2 = this.f12998q;
        int i13 = this.f12999r;
        this.f12999r = i13 + 1;
        iArr2[i13] = i10;
    }

    public final char p0() throws IOException {
        int i10;
        int i11;
        if (this.f12990d == this.f12991e && !C(1)) {
            throw w0("Unterminated escape sequence");
        }
        char[] cArr = this.f12989c;
        int i12 = this.f12990d;
        int i13 = i12 + 1;
        this.f12990d = i13;
        char c10 = cArr[i12];
        if (c10 == '\n') {
            this.f12992f++;
            this.f12993l = i13;
        } else if (c10 != '\"' && c10 != '\'' && c10 != '/' && c10 != '\\') {
            if (c10 == 'b') {
                return '\b';
            }
            if (c10 == 'f') {
                return '\f';
            }
            if (c10 == 'n') {
                return '\n';
            }
            if (c10 == 'r') {
                return '\r';
            }
            if (c10 == 't') {
                return '\t';
            }
            if (c10 != 'u') {
                throw w0("Invalid escape sequence");
            }
            if (i13 + 4 > this.f12991e && !C(4)) {
                throw w0("Unterminated escape sequence");
            }
            int i14 = this.f12990d;
            int i15 = i14 + 4;
            char c11 = 0;
            while (i14 < i15) {
                char c12 = this.f12989c[i14];
                char c13 = (char) (c11 << 4);
                if (c12 < '0' || c12 > '9') {
                    if (c12 >= 'a' && c12 <= 'f') {
                        i10 = c12 - 'a';
                    } else {
                        if (c12 < 'A' || c12 > 'F') {
                            throw new NumberFormatException("\\u" + new String(this.f12989c, this.f12990d, 4));
                        }
                        i10 = c12 - 'A';
                    }
                    i11 = i10 + 10;
                } else {
                    i11 = c12 - '0';
                }
                c11 = (char) (c13 + i11);
                i14++;
            }
            this.f12990d += 4;
            return c11;
        }
        return c10;
    }

    public final void q0(boolean z10) {
        this.f12988b = z10;
    }

    public final void r0(char c10) throws IOException {
        char[] cArr = this.f12989c;
        while (true) {
            int i10 = this.f12990d;
            int i11 = this.f12991e;
            while (true) {
                if (i10 >= i11) {
                    this.f12990d = i10;
                    if (!C(1)) {
                        throw w0("Unterminated string");
                    }
                    break;
                }
                int i12 = i10 + 1;
                char c11 = cArr[i10];
                if (c11 == c10) {
                    this.f12990d = i12;
                    return;
                }
                if (c11 == '\\') {
                    this.f12990d = i12;
                    p0();
                    break;
                } else {
                    if (c11 == '\n') {
                        this.f12992f++;
                        this.f12993l = i12;
                    }
                    i10 = i12;
                }
            }
        }
    }

    public final boolean s0(String str) {
        int length = str.length();
        while (true) {
            if (this.f12990d + length > this.f12991e && !C(length)) {
                return false;
            }
            char[] cArr = this.f12989c;
            int i10 = this.f12990d;
            if (cArr[i10] != '\n') {
                for (int i11 = 0; i11 < length; i11++) {
                    if (this.f12989c[this.f12990d + i11] == str.charAt(i11)) {
                    }
                }
                return true;
            }
            this.f12992f++;
            this.f12993l = i10 + 1;
            this.f12990d++;
        }
    }

    public final void t() throws IOException {
        g0(true);
        int i10 = this.f12990d - 1;
        this.f12990d = i10;
        if (i10 + 5 <= this.f12991e || C(5)) {
            int i11 = this.f12990d;
            char[] cArr = this.f12989c;
            if (cArr[i11] == ')' && cArr[i11 + 1] == ']' && cArr[i11 + 2] == '}' && cArr[i11 + 3] == '\'' && cArr[i11 + 4] == '\n') {
                this.f12990d = i11 + 5;
            }
        }
    }

    public final void t0() {
        char c10;
        do {
            if (this.f12990d >= this.f12991e && !C(1)) {
                return;
            }
            char[] cArr = this.f12989c;
            int i10 = this.f12990d;
            int i11 = i10 + 1;
            this.f12990d = i11;
            c10 = cArr[i10];
            if (c10 == '\n') {
                this.f12992f++;
                this.f12993l = i11;
                return;
            }
        } while (c10 != '\r');
    }

    public String toString() {
        return getClass().getSimpleName() + O();
    }

    public final void u0() throws IOException {
        do {
            int i10 = 0;
            while (true) {
                int i11 = this.f12990d;
                if (i11 + i10 < this.f12991e) {
                    char c10 = this.f12989c[i11 + i10];
                    if (c10 != '\t' && c10 != '\n' && c10 != '\f' && c10 != '\r' && c10 != ' ') {
                        if (c10 != '#') {
                            if (c10 != ',') {
                                if (c10 != '/' && c10 != '=') {
                                    if (c10 != '{' && c10 != '}' && c10 != ':') {
                                        if (c10 != ';') {
                                            switch (c10) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i10++;
                                                    break;
                                            }
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                        k();
                    }
                    this.f12990d += i10;
                    return;
                }
                this.f12990d = i11 + i10;
            }
        } while (C(1));
    }

    public int v() throws IOException {
        int i10;
        int iG0;
        int[] iArr = this.f12998q;
        int i11 = this.f12999r;
        int i12 = iArr[i11 - 1];
        if (i12 == 1) {
            iArr[i11 - 1] = 2;
        } else {
            if (i12 != 2) {
                if (i12 == 3 || i12 == 5) {
                    iArr[i11 - 1] = 4;
                    if (i12 == 5 && (iG0 = g0(true)) != 44) {
                        if (iG0 != 59) {
                            if (iG0 != 125) {
                                throw w0("Unterminated object");
                            }
                            this.f12994m = 2;
                            return 2;
                        }
                        k();
                    }
                    int iG1 = g0(true);
                    if (iG1 == 34) {
                        i10 = 13;
                    } else if (iG1 == 39) {
                        k();
                        i10 = 12;
                    } else {
                        if (iG1 == 125) {
                            if (i12 == 5) {
                                throw w0("Expected name");
                            }
                            this.f12994m = 2;
                            return 2;
                        }
                        k();
                        this.f12990d--;
                        if (!L((char) iG1)) {
                            throw w0("Expected name");
                        }
                        i10 = 14;
                    }
                } else if (i12 == 4) {
                    iArr[i11 - 1] = 5;
                    int iG2 = g0(true);
                    if (iG2 != 58) {
                        if (iG2 != 61) {
                            throw w0("Expected ':'");
                        }
                        k();
                        if (this.f12990d < this.f12991e || C(1)) {
                            char[] cArr = this.f12989c;
                            int i13 = this.f12990d;
                            if (cArr[i13] == '>') {
                                this.f12990d = i13 + 1;
                            }
                        }
                    }
                } else if (i12 == 6) {
                    if (this.f12988b) {
                        t();
                    }
                    this.f12998q[this.f12999r - 1] = 7;
                } else if (i12 == 7) {
                    if (g0(false) == -1) {
                        i10 = 17;
                    } else {
                        k();
                        this.f12990d--;
                    }
                } else if (i12 == 8) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                this.f12994m = i10;
                return i10;
            }
            int iG3 = g0(true);
            if (iG3 != 44) {
                if (iG3 != 59) {
                    if (iG3 != 93) {
                        throw w0("Unterminated array");
                    }
                    this.f12994m = 4;
                    return 4;
                }
                k();
            }
        }
        int iG4 = g0(true);
        if (iG4 != 34) {
            if (iG4 == 39) {
                k();
                this.f12994m = 8;
                return 8;
            }
            if (iG4 != 44 && iG4 != 59) {
                if (iG4 == 91) {
                    this.f12994m = 3;
                    return 3;
                }
                if (iG4 != 93) {
                    if (iG4 == 123) {
                        this.f12994m = 1;
                        return 1;
                    }
                    this.f12990d--;
                    int iM0 = m0();
                    if (iM0 != 0) {
                        return iM0;
                    }
                    int iN0 = n0();
                    if (iN0 != 0) {
                        return iN0;
                    }
                    if (!L(this.f12989c[this.f12990d])) {
                        throw w0("Expected value");
                    }
                    k();
                    i10 = 10;
                } else if (i12 == 1) {
                    this.f12994m = 4;
                    return 4;
                }
            }
            if (i12 != 1 && i12 != 2) {
                throw w0("Unexpected value");
            }
            k();
            this.f12990d--;
            this.f12994m = 7;
            return 7;
        }
        i10 = 9;
        this.f12994m = i10;
        return i10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void v0() throws IOException {
        int i10 = 0;
        do {
            int iV = this.f12994m;
            if (iV == 0) {
                iV = v();
            }
            switch (iV) {
                case 1:
                    o0(3);
                    i10++;
                    this.f12994m = 0;
                    break;
                case 2:
                    if (i10 == 0) {
                        this.f13000s[this.f12999r - 1] = null;
                    }
                    this.f12999r--;
                    i10--;
                    this.f12994m = 0;
                    break;
                case 3:
                    o0(1);
                    i10++;
                    this.f12994m = 0;
                    break;
                case 4:
                    this.f12999r--;
                    i10--;
                    this.f12994m = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.f12994m = 0;
                    break;
                case 8:
                    r0('\'');
                    this.f12994m = 0;
                    break;
                case 9:
                    r0('\"');
                    this.f12994m = 0;
                    break;
                case 10:
                    u0();
                    this.f12994m = 0;
                    break;
                case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                    r0('\'');
                    if (i10 == 0) {
                        this.f13000s[this.f12999r - 1] = "<skipped>";
                    }
                    this.f12994m = 0;
                    break;
                case 13:
                    r0('\"');
                    if (i10 == 0) {
                        this.f13000s[this.f12999r - 1] = "<skipped>";
                    }
                    this.f12994m = 0;
                    break;
                case 14:
                    u0();
                    if (i10 == 0) {
                        this.f13000s[this.f12999r - 1] = "<skipped>";
                    }
                    this.f12994m = 0;
                    break;
                case 16:
                    this.f12990d += this.f12996o;
                    this.f12994m = 0;
                    break;
                case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    break;
            }
            return;
        } while (i10 > 0);
        int[] iArr = this.f13001t;
        int i11 = this.f12999r - 1;
        iArr[i11] = iArr[i11] + 1;
    }

    public final IOException w0(String str) throws d {
        throw new d(str + O());
    }

    public void z() throws IOException {
        int iV = this.f12994m;
        if (iV == 0) {
            iV = v();
        }
        if (iV != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + l0() + O());
        }
        int i10 = this.f12999r - 1;
        this.f12999r = i10;
        int[] iArr = this.f13001t;
        int i11 = i10 - 1;
        iArr[i11] = iArr[i11] + 1;
        this.f12994m = 0;
    }
}
