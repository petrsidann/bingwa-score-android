package pc;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.x;
import lc.q;
import oc.e;
import oc.i;
import qc.d;
import qc.h;
import qc.j;
import xc.p;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f14533b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f14534c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, p pVar, Object obj) {
            super(eVar);
            this.f14533b = pVar;
            this.f14534c = obj;
            k.c(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // qc.a
        public Object invokeSuspend(Object obj) throws Throwable {
            int i10 = this.f14532a;
            if (i10 == 0) {
                this.f14532a = 1;
                lc.k.b(obj);
                k.c(this.f14533b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                return ((p) x.a(this.f14533b, 2)).invoke(this.f14534c, this);
            }
            if (i10 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f14532a = 2;
            lc.k.b(obj);
            return obj;
        }
    }

    /* JADX INFO: renamed from: pc.b$b, reason: collision with other inner class name */
    public static final class C0252b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f14536b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f14537c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0252b(e eVar, i iVar, p pVar, Object obj) {
            super(eVar, iVar);
            this.f14536b = pVar;
            this.f14537c = obj;
            k.c(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // qc.a
        public Object invokeSuspend(Object obj) throws Throwable {
            int i10 = this.f14535a;
            if (i10 == 0) {
                this.f14535a = 1;
                lc.k.b(obj);
                k.c(this.f14536b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                return ((p) x.a(this.f14536b, 2)).invoke(this.f14537c, this);
            }
            if (i10 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f14535a = 2;
            lc.k.b(obj);
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> e<q> a(p<? super R, ? super e<? super T>, ? extends Object> pVar, R r10, e<? super T> completion) {
        k.e(pVar, "<this>");
        k.e(completion, "completion");
        e<?> eVarA = h.a(completion);
        if (pVar instanceof qc.a) {
            return ((qc.a) pVar).create(r10, eVarA);
        }
        i context = eVarA.getContext();
        return context == oc.j.f13812a ? new a(eVarA, pVar, r10) : new C0252b(eVarA, context, pVar, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> e<T> b(e<? super T> eVar) {
        e<T> eVar2;
        k.e(eVar, "<this>");
        d dVar = eVar instanceof d ? (d) eVar : null;
        return (dVar == null || (eVar2 = (e<T>) dVar.intercepted()) == null) ? eVar : eVar2;
    }
}
