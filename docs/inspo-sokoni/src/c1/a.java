package c1;

import android.content.Context;
import gd.c1;
import gd.m0;
import gd.n0;
import gd.u2;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import mc.o;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: c1.a$a, reason: collision with other inner class name */
    public static final class C0059a extends l implements xc.l<Context, List<? extends a1.d<d1.d>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0059a f3118a = new C0059a();

        public C0059a() {
            super(1);
        }

        @Override // xc.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<a1.d<d1.d>> invoke(Context it) {
            k.e(it, "it");
            return o.g();
        }
    }

    public static final yc.a<Context, a1.f<d1.d>> a(String name, b1.b<d1.d> bVar, xc.l<? super Context, ? extends List<? extends a1.d<d1.d>>> produceMigrations, m0 scope) {
        k.e(name, "name");
        k.e(produceMigrations, "produceMigrations");
        k.e(scope, "scope");
        return new c(name, bVar, produceMigrations, scope);
    }

    public static /* synthetic */ yc.a b(String str, b1.b bVar, xc.l lVar, m0 m0Var, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bVar = null;
        }
        if ((i10 & 4) != 0) {
            lVar = C0059a.f3118a;
        }
        if ((i10 & 8) != 0) {
            m0Var = n0.a(c1.b().plus(u2.b(null, 1, null)));
        }
        return a(str, bVar, lVar, m0Var);
    }
}
