package od;

import xc.l;
import xc.q;

/* JADX INFO: loaded from: classes2.dex */
public final class d<Q> implements c<Q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f13817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q<Object, f<?>, Object, lc.q> f13818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q<Object, Object, Object, Object> f13819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q<f<?>, Object, Object, l<Throwable, lc.q>> f13820d;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Object obj, q<Object, ? super f<?>, Object, lc.q> qVar, q<Object, Object, Object, ? extends Object> qVar2, q<? super f<?>, Object, Object, ? extends l<? super Throwable, lc.q>> qVar3) {
        this.f13817a = obj;
        this.f13818b = qVar;
        this.f13819c = qVar2;
        this.f13820d = qVar3;
    }

    public /* synthetic */ d(Object obj, q qVar, q qVar2, q qVar3, int i10, kotlin.jvm.internal.g gVar) {
        this(obj, qVar, qVar2, (i10 & 8) != 0 ? null : qVar3);
    }
}
