package h0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<Long, g0.e.c> f9549a = new ConcurrentHashMap<>();

    public class a implements b<m0.g.b> {
        public a() {
        }

        @Override // h0.c0.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(m0.g.b bVar) {
            return bVar.e();
        }

        @Override // h0.c0.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(m0.g.b bVar) {
            return bVar.f();
        }
    }

    public interface b<T> {
        int a(T t10);

        boolean b(T t10);
    }

    public static <T> T d(T[] tArr, int i10, b<T> bVar) {
        return (T) e(tArr, (i10 & 1) == 0 ? 400 : 700, (i10 & 2) != 0, bVar);
    }

    public static <T> T e(T[] tArr, int i10, boolean z10, b<T> bVar) {
        T t10 = null;
        int i11 = com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER;
        for (T t11 : tArr) {
            int iAbs = (Math.abs(bVar.a(t11) - i10) * 2) + (bVar.b(t11) == z10 ? 0 : 1);
            if (t10 == null || i11 > iAbs) {
                t10 = t11;
                i11 = iAbs;
            }
        }
        return t10;
    }

    public Typeface a(Context context, g0.e.c cVar, Resources resources, int i10) {
        throw null;
    }

    public Typeface b(Context context, CancellationSignal cancellationSignal, m0.g.b[] bVarArr, int i10) {
        throw null;
    }

    public Typeface c(Context context, Resources resources, int i10, String str, int i11) {
        File fileD = d0.d(context);
        if (fileD == null) {
            return null;
        }
        try {
            if (d0.b(fileD, resources, i10)) {
                return Typeface.createFromFile(fileD.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileD.delete();
        }
    }

    public m0.g.b f(m0.g.b[] bVarArr, int i10) {
        return (m0.g.b) d(bVarArr, i10, new a());
    }
}
