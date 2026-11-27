package n1;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a {
    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public b(a initialExtras) {
        k.e(initialExtras, "initialExtras");
        a().putAll(initialExtras.a());
    }

    public /* synthetic */ b(a aVar, int i10, g gVar) {
        this((i10 & 1) != 0 ? a.C0227a.f13418b : aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void b(a.b<T> key, T t10) {
        k.e(key, "key");
        a().put(key, t10);
    }
}
