package j2;

import ed.t;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Comparable<k> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f11190f = new a(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final k f11191l = new k(0, 0, 0, "");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final k f11192m = new k(0, 1, 0, "");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final k f11193n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final k f11194o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final lc.f f11199e;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final k a() {
            return k.f11192m;
        }

        public final k b(String str) {
            String strGroup;
            if (str != null && !t.F(str)) {
                Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
                if (matcher.matches() && (strGroup = matcher.group(1)) != null) {
                    int i10 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    if (strGroup2 != null) {
                        int i11 = Integer.parseInt(strGroup2);
                        String strGroup3 = matcher.group(3);
                        if (strGroup3 != null) {
                            int i12 = Integer.parseInt(strGroup3);
                            String description = matcher.group(4) != null ? matcher.group(4) : "";
                            kotlin.jvm.internal.k.d(description, "description");
                            return new k(i10, i11, i12, description, null);
                        }
                    }
                }
            }
            return null;
        }
    }

    public static final class b extends kotlin.jvm.internal.l implements xc.a<BigInteger> {
        public b() {
            super(0);
        }

        @Override // xc.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BigInteger invoke() {
            return BigInteger.valueOf(k.this.k()).shiftLeft(32).or(BigInteger.valueOf(k.this.l())).shiftLeft(32).or(BigInteger.valueOf(k.this.n()));
        }
    }

    static {
        k kVar = new k(1, 0, 0, "");
        f11193n = kVar;
        f11194o = kVar;
    }

    public k(int i10, int i11, int i12, String str) {
        this.f11195a = i10;
        this.f11196b = i11;
        this.f11197c = i12;
        this.f11198d = str;
        this.f11199e = lc.g.a(new b());
    }

    public /* synthetic */ k(int i10, int i11, int i12, String str, kotlin.jvm.internal.g gVar) {
        this(i10, i11, i12, str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f11195a == kVar.f11195a && this.f11196b == kVar.f11196b && this.f11197c == kVar.f11197c;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public int compareTo(k other) {
        kotlin.jvm.internal.k.e(other, "other");
        return i().compareTo(other.i());
    }

    public int hashCode() {
        return ((((527 + this.f11195a) * 31) + this.f11196b) * 31) + this.f11197c;
    }

    public final BigInteger i() {
        Object value = this.f11199e.getValue();
        kotlin.jvm.internal.k.d(value, "<get-bigInteger>(...)");
        return (BigInteger) value;
    }

    public final int k() {
        return this.f11195a;
    }

    public final int l() {
        return this.f11196b;
    }

    public final int n() {
        return this.f11197c;
    }

    public String toString() {
        String str;
        if (!t.F(this.f11198d)) {
            str = '-' + this.f11198d;
        } else {
            str = "";
        }
        return this.f11195a + '.' + this.f11196b + '.' + this.f11197c + str;
    }
}
