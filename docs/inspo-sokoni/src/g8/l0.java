package g8;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f8858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s7.e<h8.k> f8859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s7.e<h8.k> f8860d;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8861a;

        static {
            int[] iArr = new int[e8.m.a.values().length];
            f8861a = iArr;
            try {
                iArr[e8.m.a.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8861a[e8.m.a.REMOVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public l0(int i10, boolean z10, s7.e<h8.k> eVar, s7.e<h8.k> eVar2) {
        this.f8857a = i10;
        this.f8858b = z10;
        this.f8859c = eVar;
        this.f8860d = eVar2;
    }

    public static l0 a(int i10, e8.y1 y1Var) {
        s7.e eVar = new s7.e(new ArrayList(), h8.k.d());
        s7.e eVar2 = new s7.e(new ArrayList(), h8.k.d());
        for (e8.m mVar : y1Var.d()) {
            int i11 = a.f8861a[mVar.c().ordinal()];
            if (i11 == 1) {
                eVar = eVar.i(mVar.b().getKey());
            } else if (i11 == 2) {
                eVar2 = eVar2.i(mVar.b().getKey());
            }
        }
        return new l0(i10, y1Var.k(), eVar, eVar2);
    }

    public s7.e<h8.k> b() {
        return this.f8859c;
    }

    public s7.e<h8.k> c() {
        return this.f8860d;
    }

    public int d() {
        return this.f8857a;
    }

    public boolean e() {
        return this.f8858b;
    }
}
