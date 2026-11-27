package vb;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class l1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<l1> f17404d = f();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l1 f17405e = b.OK.h();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final l1 f17406f = b.CANCELLED.h();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final l1 f17407g = b.UNKNOWN.h();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final l1 f17408h = b.INVALID_ARGUMENT.h();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final l1 f17409i = b.DEADLINE_EXCEEDED.h();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final l1 f17410j = b.NOT_FOUND.h();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final l1 f17411k = b.ALREADY_EXISTS.h();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final l1 f17412l = b.PERMISSION_DENIED.h();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final l1 f17413m = b.UNAUTHENTICATED.h();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final l1 f17414n = b.RESOURCE_EXHAUSTED.h();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final l1 f17415o = b.FAILED_PRECONDITION.h();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final l1 f17416p = b.ABORTED.h();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final l1 f17417q = b.OUT_OF_RANGE.h();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final l1 f17418r = b.UNIMPLEMENTED.h();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final l1 f17419s = b.INTERNAL.h();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final l1 f17420t = b.UNAVAILABLE.h();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final l1 f17421u = b.DATA_LOSS.h();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a1.g<l1> f17422v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a1.j<String> f17423w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a1.g<String> f17424x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f17425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f17427c;

    public enum b {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f17447b;

        b(int i10) {
            this.f17446a = i10;
            this.f17447b = Integer.toString(i10).getBytes(j6.c.f11261a);
        }

        public l1 h() {
            return (l1) l1.f17404d.get(this.f17446a);
        }

        public int i() {
            return this.f17446a;
        }

        public final byte[] k() {
            return this.f17447b;
        }
    }

    public static final class c implements a1.j<l1> {
        public c() {
        }

        @Override // vb.a1.j
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public l1 b(byte[] bArr) {
            return l1.i(bArr);
        }

        @Override // vb.a1.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public byte[] a(l1 l1Var) {
            return l1Var.m().k();
        }
    }

    public static final class d implements a1.j<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final byte[] f17448a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

        public d() {
        }

        public static boolean c(byte b10) {
            return b10 < 32 || b10 >= 126 || b10 == 37;
        }

        public static String e(byte[] bArr) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length);
            int i10 = 0;
            while (i10 < bArr.length) {
                if (bArr[i10] == 37 && i10 + 2 < bArr.length) {
                    try {
                        byteBufferAllocate.put((byte) Integer.parseInt(new String(bArr, i10 + 1, 2, j6.c.f11261a), 16));
                        i10 += 3;
                    } catch (NumberFormatException unused) {
                        byteBufferAllocate.put(bArr[i10]);
                        i10++;
                    }
                }
                byteBufferAllocate.put(bArr[i10]);
                i10++;
            }
            return new String(byteBufferAllocate.array(), 0, byteBufferAllocate.position(), j6.c.f11263c);
        }

        public static byte[] g(byte[] bArr, int i10) {
            byte[] bArr2 = new byte[((bArr.length - i10) * 3) + i10];
            if (i10 != 0) {
                System.arraycopy(bArr, 0, bArr2, 0, i10);
            }
            int i11 = i10;
            while (i10 < bArr.length) {
                byte b10 = bArr[i10];
                if (c(b10)) {
                    bArr2[i11] = 37;
                    byte[] bArr3 = f17448a;
                    bArr2[i11 + 1] = bArr3[(b10 >> 4) & 15];
                    bArr2[i11 + 2] = bArr3[b10 & 15];
                    i11 += 3;
                } else {
                    bArr2[i11] = b10;
                    i11++;
                }
                i10++;
            }
            return Arrays.copyOf(bArr2, i11);
        }

        @Override // vb.a1.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String b(byte[] bArr) {
            for (int i10 = 0; i10 < bArr.length; i10++) {
                byte b10 = bArr[i10];
                if (b10 < 32 || b10 >= 126 || (b10 == 37 && i10 + 2 < bArr.length)) {
                    return e(bArr);
                }
            }
            return new String(bArr, 0);
        }

        @Override // vb.a1.j
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public byte[] a(String str) {
            byte[] bytes = str.getBytes(j6.c.f11263c);
            for (int i10 = 0; i10 < bytes.length; i10++) {
                if (c(bytes[i10])) {
                    return g(bytes, i10);
                }
            }
            return bytes;
        }
    }

    static {
        f17422v = a1.g.g("grpc-status", false, new c());
        d dVar = new d();
        f17423w = dVar;
        f17424x = a1.g.g("grpc-message", false, dVar);
    }

    public l1(b bVar) {
        this(bVar, null, null);
    }

    public l1(b bVar, String str, Throwable th) {
        this.f17425a = (b) j6.m.p(bVar, "code");
        this.f17426b = str;
        this.f17427c = th;
    }

    public static List<l1> f() {
        TreeMap treeMap = new TreeMap();
        for (b bVar : b.values()) {
            l1 l1Var = (l1) treeMap.put(Integer.valueOf(bVar.i()), new l1(bVar));
            if (l1Var != null) {
                throw new IllegalStateException("Code value duplication between " + l1Var.m().name() + " & " + bVar.name());
            }
        }
        return Collections.unmodifiableList(new ArrayList(treeMap.values()));
    }

    public static String g(l1 l1Var) {
        if (l1Var.f17426b == null) {
            return l1Var.f17425a.toString();
        }
        return l1Var.f17425a + ": " + l1Var.f17426b;
    }

    public static l1 h(int i10) {
        if (i10 >= 0) {
            List<l1> list = f17404d;
            if (i10 < list.size()) {
                return list.get(i10);
            }
        }
        return f17407g.q("Unknown code " + i10);
    }

    public static l1 i(byte[] bArr) {
        return (bArr.length == 1 && bArr[0] == 48) ? f17405e : j(bArr);
    }

    public static l1 j(byte[] bArr) {
        int i10;
        byte b10;
        int length = bArr.length;
        char c10 = 1;
        if (length != 1) {
            i10 = (length == 2 && (b10 = bArr[0]) >= 48 && b10 <= 57) ? 0 + ((b10 - 48) * 10) : 0;
            return f17407g.q("Unknown code " + new String(bArr, j6.c.f11261a));
        }
        c10 = 0;
        byte b11 = bArr[c10];
        if (b11 >= 48 && b11 <= 57) {
            int i11 = i10 + (b11 - 48);
            List<l1> list = f17404d;
            if (i11 < list.size()) {
                return list.get(i11);
            }
        }
        return f17407g.q("Unknown code " + new String(bArr, j6.c.f11261a));
    }

    public static l1 k(Throwable th) {
        for (Throwable cause = (Throwable) j6.m.p(th, "t"); cause != null; cause = cause.getCause()) {
            if (cause instanceof m1) {
                return ((m1) cause).a();
            }
            if (cause instanceof n1) {
                return ((n1) cause).a();
            }
        }
        return f17407g.p(th);
    }

    public m1 c() {
        return new m1(this);
    }

    public n1 d() {
        return new n1(this);
    }

    public l1 e(String str) {
        if (str == null) {
            return this;
        }
        if (this.f17426b == null) {
            return new l1(this.f17425a, str, this.f17427c);
        }
        return new l1(this.f17425a, this.f17426b + "\n" + str, this.f17427c);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public Throwable l() {
        return this.f17427c;
    }

    public b m() {
        return this.f17425a;
    }

    public String n() {
        return this.f17426b;
    }

    public boolean o() {
        return b.OK == this.f17425a;
    }

    public l1 p(Throwable th) {
        return j6.i.a(this.f17427c, th) ? this : new l1(this.f17425a, this.f17426b, th);
    }

    public l1 q(String str) {
        return j6.i.a(this.f17426b, str) ? this : new l1(this.f17425a, str, this.f17427c);
    }

    public String toString() {
        j6.g.b bVarD = j6.g.b(this).d("code", this.f17425a.name()).d("description", this.f17426b);
        Throwable th = this.f17427c;
        Object objE = th;
        if (th != null) {
            objE = j6.u.e(th);
        }
        return bVarD.d("cause", objE).toString();
    }
}
