package h0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f9561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t.e<String, Typeface> f9562b;

    public static class a extends m0.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g0.h.e f9563a;

        public a(g0.h.e eVar) {
            this.f9563a = eVar;
        }

        @Override // m0.g.c
        public void a(int i10) {
            g0.h.e eVar = this.f9563a;
            if (eVar != null) {
                eVar.f(i10);
            }
        }

        @Override // m0.g.c
        public void b(Typeface typeface) {
            g0.h.e eVar = this.f9563a;
            if (eVar != null) {
                eVar.g(typeface);
            }
        }
    }

    static {
        c0 mVar;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            mVar = new b0();
        } else {
            mVar = i10 >= 28 ? new m() : new l();
        }
        f9561a = mVar;
        f9562b = new t.e<>(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i10) {
        if (context != null) {
            return Typeface.create(typeface, i10);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, m0.g.b[] bVarArr, int i10) {
        return f9561a.b(context, cancellationSignal, bVarArr, i10);
    }

    public static Typeface c(Context context, g0.e.b bVar, Resources resources, int i10, String str, int i11, int i12, g0.h.e eVar, Handler handler, boolean z10) {
        Typeface typefaceA;
        if (bVar instanceof g0.e.C0147e) {
            g0.e.C0147e c0147e = (g0.e.C0147e) bVar;
            Typeface typefaceG = g(c0147e.c());
            if (typefaceG != null) {
                if (eVar != null) {
                    eVar.d(typefaceG, handler);
                }
                return typefaceG;
            }
            boolean z11 = !z10 ? eVar != null : c0147e.a() != 0;
            int iD = z10 ? c0147e.d() : -1;
            typefaceA = m0.g.c(context, c0147e.b(), i12, z11, iD, g0.h.e.e(handler), new a(eVar));
        } else {
            typefaceA = f9561a.a(context, (g0.e.c) bVar, resources, i12);
            if (eVar != null) {
                if (typefaceA != null) {
                    eVar.d(typefaceA, handler);
                } else {
                    eVar.c(-3, handler);
                }
            }
        }
        if (typefaceA != null) {
            f9562b.put(e(resources, i10, str, i11, i12), typefaceA);
        }
        return typefaceA;
    }

    public static Typeface d(Context context, Resources resources, int i10, String str, int i11, int i12) {
        Typeface typefaceC = f9561a.c(context, resources, i10, str, i12);
        if (typefaceC != null) {
            f9562b.put(e(resources, i10, str, i11, i12), typefaceC);
        }
        return typefaceC;
    }

    public static String e(Resources resources, int i10, String str, int i11, int i12) {
        return resources.getResourcePackageName(i10) + '-' + str + '-' + i11 + '-' + i10 + '-' + i12;
    }

    public static Typeface f(Resources resources, int i10, String str, int i11, int i12) {
        return f9562b.get(e(resources, i10, str, i11, i12));
    }

    public static Typeface g(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface typefaceCreate = Typeface.create(str, 0);
        Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
        if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
            return null;
        }
        return typefaceCreate;
    }
}
