package kd;

import kotlin.jvm.internal.x;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xc.q<jd.e<Object>, Object, oc.e<? super lc.q>, Object> f12350a;

    public /* synthetic */ class a extends kotlin.jvm.internal.j implements xc.q<jd.e<? super Object>, Object, oc.e<? super lc.q>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12351a = new a();

        public a() {
            super(3, jd.e.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // xc.q
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public final Object e(jd.e<Object> eVar, Object obj, oc.e<? super lc.q> eVar2) {
            return eVar.b(obj, eVar2);
        }
    }

    static {
        a aVar = a.f12351a;
        kotlin.jvm.internal.k.c(aVar, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f12350a = (xc.q) x.a(aVar, 3);
    }
}
