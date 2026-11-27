package e8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class p extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f7274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d9.d0 f7275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h8.q f7276c;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7277a;

        static {
            int[] iArr = new int[b.values().length];
            f7277a = iArr;
            try {
                iArr[b.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7277a[b.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7277a[b.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7277a[b.NOT_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7277a[b.GREATER_THAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7277a[b.GREATER_THAN_OR_EQUAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum b {
        LESS_THAN("<"),
        LESS_THAN_OR_EQUAL("<="),
        EQUAL("=="),
        NOT_EQUAL("!="),
        GREATER_THAN(">"),
        GREATER_THAN_OR_EQUAL(">="),
        ARRAY_CONTAINS("array_contains"),
        ARRAY_CONTAINS_ANY("array_contains_any"),
        IN("in"),
        NOT_IN("not_in");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7289a;

        b(String str) {
            this.f7289a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f7289a;
        }
    }

    public p(h8.q qVar, b bVar, d9.d0 d0Var) {
        this.f7276c = qVar;
        this.f7274a = bVar;
        this.f7275b = d0Var;
    }

    public static p e(h8.q qVar, b bVar, d9.d0 d0Var) {
        if (!qVar.B()) {
            if (bVar == b.ARRAY_CONTAINS) {
                return new f(qVar, d0Var);
            }
            if (bVar == b.IN) {
                return new r0(qVar, d0Var);
            }
            if (bVar == b.ARRAY_CONTAINS_ANY) {
                return new e(qVar, d0Var);
            }
            return bVar == b.NOT_IN ? new y0(qVar, d0Var) : new p(qVar, bVar, d0Var);
        }
        if (bVar == b.IN) {
            return new t0(qVar, d0Var);
        }
        if (bVar == b.NOT_IN) {
            return new u0(qVar, d0Var);
        }
        l8.b.d((bVar == b.ARRAY_CONTAINS || bVar == b.ARRAY_CONTAINS_ANY) ? false : true, bVar.toString() + "queries don't make sense on document keys", new Object[0]);
        return new s0(qVar, bVar, d0Var);
    }

    @Override // e8.q
    public String a() {
        return f().i() + g().toString() + h8.y.b(h());
    }

    @Override // e8.q
    public List<q> b() {
        return Collections.singletonList(this);
    }

    @Override // e8.q
    public List<p> c() {
        return Collections.singletonList(this);
    }

    @Override // e8.q
    public boolean d(h8.h hVar) {
        d9.d0 d0VarL = hVar.l(this.f7276c);
        if (this.f7274a == b.NOT_EQUAL) {
            return d0VarL != null && j(h8.y.i(d0VarL, this.f7275b));
        }
        return d0VarL != null && h8.y.I(d0VarL) == h8.y.I(this.f7275b) && j(h8.y.i(d0VarL, this.f7275b));
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f7274a == pVar.f7274a && this.f7276c.equals(pVar.f7276c) && this.f7275b.equals(pVar.f7275b);
    }

    public h8.q f() {
        return this.f7276c;
    }

    public b g() {
        return this.f7274a;
    }

    public d9.d0 h() {
        return this.f7275b;
    }

    public int hashCode() {
        return ((((1147 + this.f7274a.hashCode()) * 31) + this.f7276c.hashCode()) * 31) + this.f7275b.hashCode();
    }

    public boolean i() {
        return Arrays.asList(b.LESS_THAN, b.LESS_THAN_OR_EQUAL, b.GREATER_THAN, b.GREATER_THAN_OR_EQUAL, b.NOT_EQUAL, b.NOT_IN).contains(this.f7274a);
    }

    public boolean j(int i10) {
        switch (a.f7277a[this.f7274a.ordinal()]) {
            case 1:
                return i10 < 0;
            case 2:
                return i10 <= 0;
            case 3:
                return i10 == 0;
            case 4:
                return i10 != 0;
            case 5:
                return i10 > 0;
            case 6:
                return i10 >= 0;
            default:
                throw l8.b.a("Unknown FieldFilter operator: %s", this.f7274a);
        }
    }

    public String toString() {
        return a();
    }
}
