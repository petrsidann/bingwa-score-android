package m0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import h0.j;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t.e<String, Typeface> f12871a = new t.e<>(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f12872b = h.a("fonts-androidx", 10, 10000);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f12873c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final t.g<String, ArrayList<o0.a<e>>> f12874d = new t.g<>();

    public class a implements Callable<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f12876b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ m0.e f12877c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f12878d;

        public a(String str, Context context, m0.e eVar, int i10) {
            this.f12875a = str;
            this.f12876b = context;
            this.f12877c = eVar;
            this.f12878d = i10;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return f.c(this.f12875a, this.f12876b, this.f12877c, this.f12878d);
        }
    }

    public class b implements o0.a<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m0.a f12879a;

        public b(m0.a aVar) {
            this.f12879a = aVar;
        }

        @Override // o0.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f12879a.b(eVar);
        }
    }

    public class c implements Callable<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f12881b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ m0.e f12882c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f12883d;

        public c(String str, Context context, m0.e eVar, int i10) {
            this.f12880a = str;
            this.f12881b = context;
            this.f12882c = eVar;
            this.f12883d = i10;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return f.c(this.f12880a, this.f12881b, this.f12882c, this.f12883d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    public class d implements o0.a<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12884a;

        public d(String str) {
            this.f12884a = str;
        }

        @Override // o0.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            synchronized (f.f12873c) {
                t.g<String, ArrayList<o0.a<e>>> gVar = f.f12874d;
                ArrayList<o0.a<e>> arrayList = gVar.get(this.f12884a);
                if (arrayList == null) {
                    return;
                }
                gVar.remove(this.f12884a);
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    arrayList.get(i10).accept(eVar);
                }
            }
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Typeface f12885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12886b;

        public e(int i10) {
            this.f12885a = null;
            this.f12886b = i10;
        }

        public e(Typeface typeface) {
            this.f12885a = typeface;
            this.f12886b = 0;
        }

        public boolean a() {
            return this.f12886b == 0;
        }
    }

    public static String a(m0.e eVar, int i10) {
        return eVar.d() + "-" + i10;
    }

    public static int b(g.a aVar) {
        int i10 = 1;
        if (aVar.c() != 0) {
            return aVar.c() != 1 ? -3 : -2;
        }
        g.b[] bVarArrB = aVar.b();
        if (bVarArrB != null && bVarArrB.length != 0) {
            i10 = 0;
            for (g.b bVar : bVarArrB) {
                int iB = bVar.b();
                if (iB != 0) {
                    if (iB < 0) {
                        return -3;
                    }
                    return iB;
                }
            }
        }
        return i10;
    }

    public static e c(String str, Context context, m0.e eVar, int i10) {
        t.e<String, Typeface> eVar2 = f12871a;
        Typeface typeface = eVar2.get(str);
        if (typeface != null) {
            return new e(typeface);
        }
        try {
            g.a aVarE = m0.d.e(context, eVar, null);
            int iB = b(aVarE);
            if (iB != 0) {
                return new e(iB);
            }
            Typeface typefaceB = j.b(context, null, aVarE.b(), i10);
            if (typefaceB == null) {
                return new e(-3);
            }
            eVar2.put(str, typefaceB);
            return new e(typefaceB);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        }
    }

    public static Typeface d(Context context, m0.e eVar, int i10, Executor executor, m0.a aVar) {
        String strA = a(eVar, i10);
        Typeface typeface = f12871a.get(strA);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        b bVar = new b(aVar);
        synchronized (f12873c) {
            t.g<String, ArrayList<o0.a<e>>> gVar = f12874d;
            ArrayList<o0.a<e>> arrayList = gVar.get(strA);
            if (arrayList != null) {
                arrayList.add(bVar);
                return null;
            }
            ArrayList<o0.a<e>> arrayList2 = new ArrayList<>();
            arrayList2.add(bVar);
            gVar.put(strA, arrayList2);
            c cVar = new c(strA, context, eVar, i10);
            if (executor == null) {
                executor = f12872b;
            }
            h.b(executor, cVar, new d(strA));
            return null;
        }
    }

    public static Typeface e(Context context, m0.e eVar, m0.a aVar, int i10, int i11) {
        String strA = a(eVar, i10);
        Typeface typeface = f12871a.get(strA);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        if (i11 == -1) {
            e eVarC = c(strA, context, eVar, i10);
            aVar.b(eVarC);
            return eVarC.f12885a;
        }
        try {
            e eVar2 = (e) h.c(f12872b, new a(strA, context, eVar, i10), i11);
            aVar.b(eVar2);
            return eVar2.f12885a;
        } catch (InterruptedException unused) {
            aVar.b(new e(-3));
            return null;
        }
    }
}
