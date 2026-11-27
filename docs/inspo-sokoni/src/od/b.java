package od;

import xc.l;
import xc.q;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f13813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q<Object, f<?>, Object, lc.q> f13814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q<f<?>, Object, Object, l<Throwable, lc.q>> f13815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q<Object, Object, Object, Object> f13816d;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Object obj, q<Object, ? super f<?>, Object, lc.q> qVar, q<? super f<?>, Object, Object, ? extends l<? super Throwable, lc.q>> qVar2) {
        this.f13813a = obj;
        this.f13814b = qVar;
        this.f13815c = qVar2;
        this.f13816d = g.f13833a;
    }

    public /* synthetic */ b(Object obj, q qVar, q qVar2, int i10, kotlin.jvm.internal.g gVar) {
        this(obj, qVar, (i10 & 4) != 0 ? null : qVar2);
    }
}
