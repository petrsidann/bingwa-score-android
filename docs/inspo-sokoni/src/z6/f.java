package z6;

import e7.z;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;
import r6.u;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c7.b.a f20317a = new b(null);

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20318a;

        static {
            int[] iArr = new int[z.values().length];
            f20318a = iArr;
            try {
                iArr[z.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20318a[z.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20318a[z.DESTROYED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class b implements c7.b.a {
        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // c7.b.a
        public void a() {
        }

        @Override // c7.b.a
        public void b(int i10, long j10) {
        }
    }

    public static <P> c7.c a(u<P> uVar) {
        c7.c.b bVarA = c7.c.a();
        bVarA.d(uVar.d());
        Iterator<List<u.c<P>>> it = uVar.c().iterator();
        while (it.hasNext()) {
            for (u.c<P> cVar : it.next()) {
                bVarA.a(b(cVar.g()), cVar.c(), cVar.e());
            }
        }
        if (uVar.e() != null) {
            bVarA.e(uVar.e().c());
        }
        try {
            return bVarA.b();
        } catch (GeneralSecurityException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static r6.j b(z zVar) {
        int i10 = a.f20318a[zVar.ordinal()];
        if (i10 == 1) {
            return r6.j.f15034b;
        }
        if (i10 == 2) {
            return r6.j.f15035c;
        }
        if (i10 == 3) {
            return r6.j.f15036d;
        }
        throw new IllegalStateException("Unknown key status");
    }
}
