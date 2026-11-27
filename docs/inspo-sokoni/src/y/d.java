package y;

import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f19139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f19140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f19141d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public x.i f19144g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet<d> f19138a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f19142e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f19143f = -1;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19145a;

        static {
            int[] iArr = new int[b.values().length];
            f19145a = iArr;
            try {
                iArr[b.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19145a[b.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19145a[b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19145a[b.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19145a[b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f19145a[b.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f19145a[b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f19145a[b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f19145a[b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public enum b {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public d(e eVar, b bVar) {
        this.f19139b = eVar;
        this.f19140c = bVar;
    }

    public boolean a(d dVar, int i10) {
        return b(dVar, i10, -1, false);
    }

    public boolean b(d dVar, int i10, int i11, boolean z10) {
        if (dVar == null) {
            l();
            return true;
        }
        if (!z10 && !k(dVar)) {
            return false;
        }
        this.f19141d = dVar;
        if (dVar.f19138a == null) {
            dVar.f19138a = new HashSet<>();
        }
        this.f19141d.f19138a.add(this);
        if (i10 > 0) {
            this.f19142e = i10;
        } else {
            this.f19142e = 0;
        }
        this.f19143f = i11;
        return true;
    }

    public int c() {
        d dVar;
        if (this.f19139b.O() == 8) {
            return 0;
        }
        return (this.f19143f <= -1 || (dVar = this.f19141d) == null || dVar.f19139b.O() != 8) ? this.f19142e : this.f19143f;
    }

    public final d d() {
        switch (a.f19145a[this.f19140c.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f19139b.D;
            case 3:
                return this.f19139b.B;
            case 4:
                return this.f19139b.E;
            case 5:
                return this.f19139b.C;
            default:
                throw new AssertionError(this.f19140c.name());
        }
    }

    public e e() {
        return this.f19139b;
    }

    public x.i f() {
        return this.f19144g;
    }

    public d g() {
        return this.f19141d;
    }

    public b h() {
        return this.f19140c;
    }

    public boolean i() {
        HashSet<d> hashSet = this.f19138a;
        if (hashSet == null) {
            return false;
        }
        Iterator<d> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().d().j()) {
                return true;
            }
        }
        return false;
    }

    public boolean j() {
        return this.f19141d != null;
    }

    public boolean k(d dVar) {
        if (dVar == null) {
            return false;
        }
        b bVarH = dVar.h();
        b bVar = this.f19140c;
        if (bVarH == bVar) {
            return bVar != b.BASELINE || (dVar.e().S() && e().S());
        }
        switch (a.f19145a[bVar.ordinal()]) {
            case 1:
                return (bVarH == b.BASELINE || bVarH == b.CENTER_X || bVarH == b.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z10 = bVarH == b.LEFT || bVarH == b.RIGHT;
                if (dVar.e() instanceof h) {
                    return z10 || bVarH == b.CENTER_X;
                }
                return z10;
            case 4:
            case 5:
                boolean z11 = bVarH == b.TOP || bVarH == b.BOTTOM;
                if (dVar.e() instanceof h) {
                    return z11 || bVarH == b.CENTER_Y;
                }
                return z11;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f19140c.name());
        }
    }

    public void l() {
        HashSet<d> hashSet;
        d dVar = this.f19141d;
        if (dVar != null && (hashSet = dVar.f19138a) != null) {
            hashSet.remove(this);
        }
        this.f19141d = null;
        this.f19142e = 0;
        this.f19143f = -1;
    }

    public void m(x.c cVar) {
        x.i iVar = this.f19144g;
        if (iVar == null) {
            this.f19144g = new x.i(x.i.a.UNRESTRICTED, null);
        } else {
            iVar.d();
        }
    }

    public void n(int i10) {
        if (j()) {
            this.f19143f = i10;
        }
    }

    public String toString() {
        return this.f19139b.r() + ":" + this.f19140c.toString();
    }
}
