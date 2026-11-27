package v1;

import gd.t0;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import lc.q;
import p6.e;
import u.c;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    public static final class a extends l implements xc.l<Throwable, q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.a<T> f17099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t0<T> f17100b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(c.a<T> aVar, t0<? extends T> t0Var) {
            super(1);
            this.f17099a = aVar;
            this.f17100b = t0Var;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final void a(Throwable th) {
            if (th == null) {
                this.f17099a.b((T) this.f17100b.getCompleted());
            } else if (th instanceof CancellationException) {
                this.f17099a.c();
            } else {
                this.f17099a.e(th);
            }
        }

        @Override // xc.l
        public /* bridge */ /* synthetic */ q invoke(Throwable th) {
            a(th);
            return q.f12711a;
        }
    }

    public static final <T> e<T> b(final t0<? extends T> t0Var, final Object obj) {
        k.e(t0Var, "<this>");
        e<T> eVarA = c.a(new c.InterfaceC0292c() { // from class: v1.a
            @Override // u.c.InterfaceC0292c
            public final Object a(c.a aVar) {
                return b.d(t0Var, obj, aVar);
            }
        });
        k.d(eVarA, "getFuture { completer ->…        }\n    }\n    tag\n}");
        return eVarA;
    }

    public static /* synthetic */ e c(t0 t0Var, Object obj, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return b(t0Var, obj);
    }

    public static final Object d(t0 this_asListenableFuture, Object obj, c.a completer) {
        k.e(this_asListenableFuture, "$this_asListenableFuture");
        k.e(completer, "completer");
        this_asListenableFuture.invokeOnCompletion(new a(completer, this_asListenableFuture));
        return obj;
    }
}
