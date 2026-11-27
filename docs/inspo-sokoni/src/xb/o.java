package xb;

import java.text.MessageFormat;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends vb.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f18780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r2 f18781b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18782a;

        static {
            int[] iArr = new int[vb.f.a.values().length];
            f18782a = iArr;
            try {
                iArr[vb.f.a.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18782a[vb.f.a.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18782a[vb.f.a.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public o(p pVar, r2 r2Var) {
        this.f18780a = (p) j6.m.p(pVar, "tracer");
        this.f18781b = (r2) j6.m.p(r2Var, "time");
    }

    public static void d(vb.l0 l0Var, vb.f.a aVar, String str) {
        Level levelF = f(aVar);
        if (p.f18788f.isLoggable(levelF)) {
            p.d(l0Var, levelF, str);
        }
    }

    public static void e(vb.l0 l0Var, vb.f.a aVar, String str, Object... objArr) {
        Level levelF = f(aVar);
        if (p.f18788f.isLoggable(levelF)) {
            p.d(l0Var, levelF, MessageFormat.format(str, objArr));
        }
    }

    public static Level f(vb.f.a aVar) {
        int i10 = a.f18782a[aVar.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return Level.FINE;
        }
        return i10 != 3 ? Level.FINEST : Level.FINER;
    }

    public static vb.g0.b g(vb.f.a aVar) {
        int i10 = a.f18782a[aVar.ordinal()];
        if (i10 != 1) {
            return i10 != 2 ? vb.g0.b.CT_INFO : vb.g0.b.CT_WARNING;
        }
        return vb.g0.b.CT_ERROR;
    }

    @Override // vb.f
    public void a(vb.f.a aVar, String str) {
        d(this.f18780a.b(), aVar, str);
        if (c(aVar)) {
            h(aVar, str);
        }
    }

    @Override // vb.f
    public void b(vb.f.a aVar, String str, Object... objArr) {
        a(aVar, (c(aVar) || p.f18788f.isLoggable(f(aVar))) ? MessageFormat.format(str, objArr) : null);
    }

    public final boolean c(vb.f.a aVar) {
        return aVar != vb.f.a.DEBUG && this.f18780a.c();
    }

    public final void h(vb.f.a aVar, String str) {
        if (aVar == vb.f.a.DEBUG) {
            return;
        }
        this.f18780a.f(new vb.g0.a().b(str).c(g(aVar)).e(this.f18781b.a()).a());
    }
}
