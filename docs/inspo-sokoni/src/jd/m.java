package jd;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class m {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.t f11373a;

        public a(kotlin.jvm.internal.t tVar) {
            this.f11373a = tVar;
        }

        @Override // jd.e
        public Object b(T t10, oc.e<? super lc.q> eVar) {
            this.f11373a.f12381a = t10;
            throw new kd.a(this);
        }
    }

    @qc.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {183}, m = "first")
    public static final class b<T> extends qc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f11374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f11375b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f11376c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11377d;

        public b(oc.e<? super b> eVar) {
            super(eVar);
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) {
            this.f11376c = obj;
            this.f11377d |= Integer.MIN_VALUE;
            return f.f(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object a(d<? extends T> dVar, oc.e<? super T> eVar) throws Throwable {
        b bVar;
        kotlin.jvm.internal.t tVar;
        kd.a e10;
        e<? super Object> eVar2;
        if (eVar instanceof b) {
            bVar = (b) eVar;
            int i10 = bVar.f11377d;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                bVar.f11377d = i10 - Integer.MIN_VALUE;
            } else {
                bVar = new b(eVar);
            }
        } else {
            bVar = new b(eVar);
        }
        Object obj = bVar.f11376c;
        Object objC = pc.c.c();
        int i11 = bVar.f11377d;
        if (i11 == 0) {
            lc.k.b(obj);
            kotlin.jvm.internal.t tVar2 = new kotlin.jvm.internal.t();
            tVar2.f12381a = (T) kd.m.f12341a;
            e<? super Object> aVar = new a<>(tVar2);
            try {
                bVar.f11374a = tVar2;
                bVar.f11375b = aVar;
                bVar.f11377d = 1;
                if (dVar.a(aVar, bVar) == objC) {
                    return objC;
                }
                tVar = tVar2;
            } catch (kd.a e11) {
                tVar = tVar2;
                e10 = e11;
                eVar2 = aVar;
                kd.j.a(e10, eVar2);
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            eVar2 = (a) bVar.f11375b;
            tVar = (kotlin.jvm.internal.t) bVar.f11374a;
            try {
                lc.k.b(obj);
            } catch (kd.a e12) {
                e10 = e12;
                kd.j.a(e10, eVar2);
            }
        }
        T t10 = tVar.f12381a;
        if (t10 != kd.m.f12341a) {
            return t10;
        }
        throw new NoSuchElementException("Expected at least one element");
    }
}
