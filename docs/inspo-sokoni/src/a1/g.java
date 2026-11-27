package a1;

import gd.m0;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f220a = new g();

    public final <T> f<T> a(k<T> serializer, b1.b<T> bVar, List<? extends d<T>> migrations, m0 scope, xc.a<? extends File> produceFile) {
        kotlin.jvm.internal.k.e(serializer, "serializer");
        kotlin.jvm.internal.k.e(migrations, "migrations");
        kotlin.jvm.internal.k.e(scope, "scope");
        kotlin.jvm.internal.k.e(produceFile, "produceFile");
        return new m(produceFile, serializer, mc.n.b(e.f202a.b(migrations)), new b1.a(), scope);
    }
}
