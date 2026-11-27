package ac;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import oe.t;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final oe.g f460a = oe.g.i(":");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d[] f461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<oe.g, Integer> f462c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<d> f463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final oe.f f464b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f465c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f466d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d[] f467e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f468f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f469g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f470h;

        public a(int i10, int i11, t tVar) {
            this.f463a = new ArrayList();
            d[] dVarArr = new d[8];
            this.f467e = dVarArr;
            this.f468f = dVarArr.length - 1;
            this.f469g = 0;
            this.f470h = 0;
            this.f465c = i10;
            this.f466d = i11;
            this.f464b = oe.i.b(tVar);
        }

        public a(int i10, t tVar) {
            this(i10, i10, tVar);
        }

        public final void a() {
            int i10 = this.f466d;
            int i11 = this.f470h;
            if (i10 < i11) {
                if (i10 == 0) {
                    b();
                } else {
                    d(i11 - i10);
                }
            }
        }

        public final void b() {
            Arrays.fill(this.f467e, (Object) null);
            this.f468f = this.f467e.length - 1;
            this.f469g = 0;
            this.f470h = 0;
        }

        public final int c(int i10) {
            return this.f468f + 1 + i10;
        }

        public final int d(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f467e.length;
                while (true) {
                    length--;
                    i11 = this.f468f;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    int i13 = this.f467e[length].f454c;
                    i10 -= i13;
                    this.f470h -= i13;
                    this.f469g--;
                    i12++;
                }
                d[] dVarArr = this.f467e;
                System.arraycopy(dVarArr, i11 + 1, dVarArr, i11 + 1 + i12, this.f469g);
                this.f468f += i12;
            }
            return i12;
        }

        public List<d> e() {
            ArrayList arrayList = new ArrayList(this.f463a);
            this.f463a.clear();
            return arrayList;
        }

        public final oe.g f(int i10) throws IOException {
            d dVar;
            if (!i(i10)) {
                int iC = c(i10 - f.f461b.length);
                if (iC >= 0) {
                    d[] dVarArr = this.f467e;
                    if (iC < dVarArr.length) {
                        dVar = dVarArr[iC];
                    }
                }
                throw new IOException("Header index too large " + (i10 + 1));
            }
            dVar = f.f461b[i10];
            return dVar.f452a;
        }

        public void g(int i10) {
            this.f465c = i10;
            this.f466d = i10;
            a();
        }

        public final void h(int i10, d dVar) {
            this.f463a.add(dVar);
            int i11 = dVar.f454c;
            if (i10 != -1) {
                i11 -= this.f467e[c(i10)].f454c;
            }
            int i12 = this.f466d;
            if (i11 > i12) {
                b();
                return;
            }
            int iD = d((this.f470h + i11) - i12);
            if (i10 == -1) {
                int i13 = this.f469g + 1;
                d[] dVarArr = this.f467e;
                if (i13 > dVarArr.length) {
                    d[] dVarArr2 = new d[dVarArr.length * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
                    this.f468f = this.f467e.length - 1;
                    this.f467e = dVarArr2;
                }
                int i14 = this.f468f;
                this.f468f = i14 - 1;
                this.f467e[i14] = dVar;
                this.f469g++;
            } else {
                this.f467e[i10 + c(i10) + iD] = dVar;
            }
            this.f470h += i11;
        }

        public final boolean i(int i10) {
            return i10 >= 0 && i10 <= f.f461b.length - 1;
        }

        public final int j() {
            return this.f464b.readByte() & 255;
        }

        public oe.g k() {
            int iJ = j();
            boolean z10 = (iJ & 128) == 128;
            int iN = n(iJ, 127);
            return z10 ? oe.g.t(h.f().c(this.f464b.H(iN))) : this.f464b.i(iN);
        }

        public void l() throws IOException {
            while (!this.f464b.p()) {
                int i10 = this.f464b.readByte() & 255;
                if (i10 == 128) {
                    throw new IOException("index == 0");
                }
                if ((i10 & 128) == 128) {
                    m(n(i10, 127) - 1);
                } else if (i10 == 64) {
                    p();
                } else if ((i10 & 64) == 64) {
                    o(n(i10, 63) - 1);
                } else if ((i10 & 32) == 32) {
                    int iN = n(i10, 31);
                    this.f466d = iN;
                    if (iN < 0 || iN > this.f465c) {
                        throw new IOException("Invalid dynamic table size update " + this.f466d);
                    }
                    a();
                } else if (i10 == 16 || i10 == 0) {
                    r();
                } else {
                    q(n(i10, 15) - 1);
                }
            }
        }

        public final void m(int i10) throws IOException {
            if (i(i10)) {
                this.f463a.add(f.f461b[i10]);
                return;
            }
            int iC = c(i10 - f.f461b.length);
            if (iC >= 0) {
                d[] dVarArr = this.f467e;
                if (iC <= dVarArr.length - 1) {
                    this.f463a.add(dVarArr[iC]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        public int n(int i10, int i11) {
            int i12 = i10 & i11;
            if (i12 < i11) {
                return i12;
            }
            int i13 = 0;
            while (true) {
                int iJ = j();
                if ((iJ & 128) == 0) {
                    return i11 + (iJ << i13);
                }
                i11 += (iJ & 127) << i13;
                i13 += 7;
            }
        }

        public final void o(int i10) {
            h(-1, new d(f(i10), k()));
        }

        public final void p() {
            h(-1, new d(f.e(k()), k()));
        }

        public final void q(int i10) throws IOException {
            this.f463a.add(new d(f(i10), k()));
        }

        public final void r() throws IOException {
            this.f463a.add(new d(f.e(k()), k()));
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final oe.d f471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f472b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f473c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f474d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f475e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f476f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public d[] f477g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f478h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f479i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f480j;

        public b(int i10, boolean z10, oe.d dVar) {
            this.f474d = com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER;
            d[] dVarArr = new d[8];
            this.f477g = dVarArr;
            this.f479i = dVarArr.length - 1;
            this.f473c = i10;
            this.f476f = i10;
            this.f472b = z10;
            this.f471a = dVar;
        }

        public b(oe.d dVar) {
            this(4096, false, dVar);
        }

        public final void a() {
            Arrays.fill(this.f477g, (Object) null);
            this.f479i = this.f477g.length - 1;
            this.f478h = 0;
            this.f480j = 0;
        }

        public final int b(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f477g.length;
                while (true) {
                    length--;
                    i11 = this.f479i;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    int i13 = this.f477g[length].f454c;
                    i10 -= i13;
                    this.f480j -= i13;
                    this.f478h--;
                    i12++;
                }
                d[] dVarArr = this.f477g;
                System.arraycopy(dVarArr, i11 + 1, dVarArr, i11 + 1 + i12, this.f478h);
                this.f479i += i12;
            }
            return i12;
        }

        public final void c(d dVar) {
            int i10 = dVar.f454c;
            int i11 = this.f476f;
            if (i10 > i11) {
                a();
                return;
            }
            b((this.f480j + i10) - i11);
            int i12 = this.f478h + 1;
            d[] dVarArr = this.f477g;
            if (i12 > dVarArr.length) {
                d[] dVarArr2 = new d[dVarArr.length * 2];
                System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
                this.f479i = this.f477g.length - 1;
                this.f477g = dVarArr2;
            }
            int i13 = this.f479i;
            this.f479i = i13 - 1;
            this.f477g[i13] = dVar;
            this.f478h++;
            this.f480j += i10;
        }

        public void d(oe.g gVar) throws IOException {
            int iY;
            int i10;
            if (!this.f472b || h.f().e(gVar.B()) >= gVar.y()) {
                iY = gVar.y();
                i10 = 0;
            } else {
                oe.d dVar = new oe.d();
                h.f().d(gVar.B(), dVar.L());
                gVar = dVar.Q();
                iY = gVar.y();
                i10 = 128;
            }
            f(iY, 127, i10);
            this.f471a.m0(gVar);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0071  */
        /* JADX WARN: Code duplicated, block: B:26:0x0078  */
        /* JADX WARN: Code duplicated, block: B:29:0x0081  */
        /* JADX WARN: Code duplicated, block: B:34:0x00a1 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:38:0x00b0  */
        /* JADX WARN: Code duplicated, block: B:39:0x00b8  */
        /* JADX WARN: Code duplicated, block: B:41:0x00bc  */
        /* JADX WARN: Code duplicated, block: B:43:0x00cb  */
        /* JADX WARN: Code duplicated, block: B:55:0x00ae A[EDGE_INSN: B:55:0x00ae->B:37:0x00ae BREAK  A[LOOP:1: B:27:0x007a->B:59:0x007a], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:56:0x008b A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:57:0x0097 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:58:0x00a3 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:60:0x007a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:61:0x007a A[SYNTHETIC] */
        public void e(List<d> list) throws IOException {
            int length;
            int length2;
            int i10;
            d[] dVarArr;
            if (this.f475e) {
                int i11 = this.f474d;
                if (i11 < this.f476f) {
                    f(i11, 31, 32);
                }
                this.f475e = false;
                this.f474d = com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER;
                f(this.f476f, 31, 32);
            }
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                d dVar = list.get(i12);
                oe.g gVarA = dVar.f452a.A();
                oe.g gVar = dVar.f453b;
                Integer num = (Integer) f.f462c.get(gVarA);
                if (num != null) {
                    length = num.intValue() + 1;
                    if (length < 2 || length > 7) {
                        length2 = length;
                        length = -1;
                    } else if (!f.f461b[length - 1].f453b.equals(gVar)) {
                        if (f.f461b[length].f453b.equals(gVar)) {
                            length2 = length;
                            length++;
                        } else {
                            length2 = length;
                            length = -1;
                        }
                    }
                    if (length == -1) {
                        i10 = this.f479i;
                        while (true) {
                            i10++;
                            dVarArr = this.f477g;
                            if (i10 >= dVarArr.length) {
                                break;
                            }
                            if (!dVarArr[i10].f452a.equals(gVarA)) {
                                if (this.f477g[i10].f453b.equals(gVar)) {
                                    length = f.f461b.length + (i10 - this.f479i);
                                    break;
                                } else if (length2 == -1) {
                                    length2 = (i10 - this.f479i) + f.f461b.length;
                                }
                            }
                        }
                    }
                    if (length != -1) {
                        f(length, 127, 128);
                    } else {
                        if (length2 == -1) {
                            this.f471a.writeByte(64);
                            d(gVarA);
                        } else if (gVarA.z(f.f460a) || d.f449h.equals(gVarA)) {
                            f(length2, 63, 64);
                        } else {
                            f(length2, 15, 0);
                            d(gVar);
                        }
                        d(gVar);
                        c(dVar);
                    }
                } else {
                    length = -1;
                }
                length2 = length;
                if (length == -1) {
                    i10 = this.f479i;
                    while (true) {
                        i10++;
                        dVarArr = this.f477g;
                        if (i10 >= dVarArr.length) {
                            break;
                            break;
                        } else if (!dVarArr[i10].f452a.equals(gVarA)) {
                            if (this.f477g[i10].f453b.equals(gVar)) {
                                length = f.f461b.length + (i10 - this.f479i);
                                break;
                            } else if (length2 == -1) {
                                length2 = (i10 - this.f479i) + f.f461b.length;
                            }
                        }
                    }
                }
                if (length != -1) {
                    f(length, 127, 128);
                } else {
                    if (length2 == -1) {
                        this.f471a.writeByte(64);
                        d(gVarA);
                    } else {
                        if (gVarA.z(f.f460a)) {
                        }
                        f(length2, 63, 64);
                    }
                    d(gVar);
                    c(dVar);
                }
            }
        }

        public void f(int i10, int i11, int i12) {
            int i13;
            oe.d dVar;
            if (i10 < i11) {
                dVar = this.f471a;
                i13 = i10 | i12;
            } else {
                this.f471a.writeByte(i12 | i11);
                i13 = i10 - i11;
                while (i13 >= 128) {
                    this.f471a.writeByte(128 | (i13 & 127));
                    i13 >>>= 7;
                }
                dVar = this.f471a;
            }
            dVar.writeByte(i13);
        }
    }

    static {
        oe.g gVar = d.f446e;
        oe.g gVar2 = d.f447f;
        oe.g gVar3 = d.f448g;
        oe.g gVar4 = d.f445d;
        f461b = new d[]{new d(d.f449h, ""), new d(gVar, "GET"), new d(gVar, "POST"), new d(gVar2, "/"), new d(gVar2, "/index.html"), new d(gVar3, "http"), new d(gVar3, "https"), new d(gVar4, "200"), new d(gVar4, "204"), new d(gVar4, "206"), new d(gVar4, "304"), new d(gVar4, "400"), new d(gVar4, "404"), new d(gVar4, "500"), new d("accept-charset", ""), new d("accept-encoding", "gzip, deflate"), new d("accept-language", ""), new d("accept-ranges", ""), new d("accept", ""), new d("access-control-allow-origin", ""), new d("age", ""), new d("allow", ""), new d("authorization", ""), new d("cache-control", ""), new d("content-disposition", ""), new d("content-encoding", ""), new d("content-language", ""), new d("content-length", ""), new d("content-location", ""), new d("content-range", ""), new d("content-type", ""), new d("cookie", ""), new d("date", ""), new d("etag", ""), new d("expect", ""), new d("expires", ""), new d("from", ""), new d("host", ""), new d("if-match", ""), new d("if-modified-since", ""), new d("if-none-match", ""), new d("if-range", ""), new d("if-unmodified-since", ""), new d("last-modified", ""), new d("link", ""), new d("location", ""), new d("max-forwards", ""), new d("proxy-authenticate", ""), new d("proxy-authorization", ""), new d("range", ""), new d("referer", ""), new d("refresh", ""), new d("retry-after", ""), new d("server", ""), new d("set-cookie", ""), new d("strict-transport-security", ""), new d("transfer-encoding", ""), new d("user-agent", ""), new d("vary", ""), new d("via", ""), new d("www-authenticate", "")};
        f462c = f();
    }

    public static oe.g e(oe.g gVar) throws IOException {
        int iY = gVar.y();
        for (int i10 = 0; i10 < iY; i10++) {
            byte bK = gVar.k(i10);
            if (bK >= 65 && bK <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + gVar.C());
            }
        }
        return gVar;
    }

    public static Map<oe.g, Integer> f() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f461b.length);
        int i10 = 0;
        while (true) {
            d[] dVarArr = f461b;
            if (i10 >= dVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(dVarArr[i10].f452a)) {
                linkedHashMap.put(dVarArr[i10].f452a, Integer.valueOf(i10));
            }
            i10++;
        }
    }
}
