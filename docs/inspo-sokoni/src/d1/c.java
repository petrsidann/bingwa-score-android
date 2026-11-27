package d1;

import gd.m0;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f6267a = new c();

    public static final class a extends l implements xc.a<File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ xc.a<File> f6268a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(xc.a<? extends File> aVar) {
            super(0);
            this.f6268a = aVar;
        }

        @Override // xc.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final File invoke() {
            File fileInvoke = this.f6268a.invoke();
            String strC = vc.g.c(fileInvoke);
            g gVar = g.f6272a;
            if (k.a(strC, gVar.f())) {
                return fileInvoke;
            }
            throw new IllegalStateException(("File extension for file: " + fileInvoke + " does not match required extension for Preferences file: " + gVar.f()).toString());
        }
    }

    public final a1.f<d> a(b1.b<d> bVar, List<? extends a1.d<d>> migrations, m0 scope, xc.a<? extends File> produceFile) {
        k.e(migrations, "migrations");
        k.e(scope, "scope");
        k.e(produceFile, "produceFile");
        return new b(a1.g.f220a.a(g.f6272a, bVar, migrations, scope, new a(produceFile)));
    }
}
