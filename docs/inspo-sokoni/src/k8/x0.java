package k8;

import com.google.auto.value.AutoValue;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class x0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x0 f11842b = new x0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<AtomicReference<c>> f11843a = new CopyOnWriteArrayList<>();

    @AutoValue
    public static abstract class a {
        public static a d(m mVar, boolean z10, int i10, int i11, int i12) {
            return new k(mVar, z10, i10, i11, i12);
        }

        public static a e(m mVar, z0.b bVar, r rVar) {
            d9.g gVarB = rVar.b();
            if (gVarB == null) {
                return null;
            }
            return d(mVar, bVar == z0.b.SUCCESS, gVarB.g0(), gVarB.e0().e0().size(), gVarB.e0().g0());
        }

        public abstract boolean a();

        public abstract int b();

        public abstract m c();

        public abstract int f();

        public abstract int g();
    }

    @AutoValue
    public static abstract class b {
        public static b b(int i10, int i11, String str, String str2, a aVar) {
            return new l(i10, i11, str, str2, aVar);
        }

        public static b e(int i10, r rVar, h8.f fVar, m mVar, z0.b bVar) {
            return b(i10, rVar.a(), fVar.l(), fVar.k(), a.e(mVar, bVar, rVar));
        }

        public abstract a a();

        public abstract String c();

        public abstract int d();

        public abstract int f();

        public abstract String g();
    }

    public interface c {
        void a(b bVar);
    }

    public static x0 a() {
        return f11842b;
    }

    public void b(b bVar) {
        Iterator<AtomicReference<c>> it = this.f11843a.iterator();
        while (it.hasNext()) {
            c cVar = it.next().get();
            if (cVar != null) {
                cVar.a(bVar);
            }
        }
    }
}
