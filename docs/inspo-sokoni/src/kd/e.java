package kd;

import gd.m0;
import gd.n0;
import gd.o0;
import gd.q0;
import id.t;
import java.util.ArrayList;
import mc.w;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e<T> implements k<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oc.i f12323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final id.a f12325c;

    @qc.f(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", l = {123}, m = "invokeSuspend")
    public static final class a extends qc.l implements xc.p<m0, oc.e<? super lc.q>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f12327b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ jd.e<T> f12328c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e<T> f12329d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(jd.e<? super T> eVar, e<T> eVar2, oc.e<? super a> eVar3) {
            super(2, eVar3);
            this.f12328c = eVar;
            this.f12329d = eVar2;
        }

        @Override // xc.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(m0 m0Var, oc.e<? super lc.q> eVar) {
            return ((a) create(m0Var, eVar)).invokeSuspend(lc.q.f12711a);
        }

        @Override // qc.a
        public final oc.e<lc.q> create(Object obj, oc.e<?> eVar) {
            a aVar = new a(this.f12328c, this.f12329d, eVar);
            aVar.f12327b = obj;
            return aVar;
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = pc.c.c();
            int i10 = this.f12326a;
            if (i10 == 0) {
                lc.k.b(obj);
                m0 m0Var = (m0) this.f12327b;
                jd.e<T> eVar = this.f12328c;
                t<T> tVarI = this.f12329d.i(m0Var);
                this.f12326a = 1;
                if (jd.f.c(eVar, tVarI, this) == objC) {
                    return objC;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lc.k.b(obj);
            }
            return lc.q.f12711a;
        }
    }

    @qc.f(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", l = {60}, m = "invokeSuspend")
    public static final class b extends qc.l implements xc.p<id.r<? super T>, oc.e<? super lc.q>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f12331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e<T> f12332c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e<T> eVar, oc.e<? super b> eVar2) {
            super(2, eVar2);
            this.f12332c = eVar;
        }

        @Override // xc.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(id.r<? super T> rVar, oc.e<? super lc.q> eVar) {
            return ((b) create(rVar, eVar)).invokeSuspend(lc.q.f12711a);
        }

        @Override // qc.a
        public final oc.e<lc.q> create(Object obj, oc.e<?> eVar) {
            b bVar = new b(this.f12332c, eVar);
            bVar.f12331b = obj;
            return bVar;
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = pc.c.c();
            int i10 = this.f12330a;
            if (i10 == 0) {
                lc.k.b(obj);
                id.r<? super T> rVar = (id.r) this.f12331b;
                e<T> eVar = this.f12332c;
                this.f12330a = 1;
                if (eVar.e(rVar, this) == objC) {
                    return objC;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lc.k.b(obj);
            }
            return lc.q.f12711a;
        }
    }

    public e(oc.i iVar, int i10, id.a aVar) {
        this.f12323a = iVar;
        this.f12324b = i10;
        this.f12325c = aVar;
    }

    public static /* synthetic */ <T> Object d(e<T> eVar, jd.e<? super T> eVar2, oc.e<? super lc.q> eVar3) {
        Object objC = n0.c(new a(eVar2, eVar, null), eVar3);
        return objC == pc.c.c() ? objC : lc.q.f12711a;
    }

    @Override // jd.d
    public Object a(jd.e<? super T> eVar, oc.e<? super lc.q> eVar2) {
        return d(this, eVar, eVar2);
    }

    public String b() {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0013 A[PHI: r4
  0x0013: PHI (r4v5 int) = (r4v2 int), (r4v2 int), (r4v4 int) binds: [B:8:0x0011, B:13:0x0019, B:16:0x001d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // kd.k
    public jd.d<T> c(oc.i iVar, int i10, id.a aVar) {
        oc.i iVarPlus = iVar.plus(this.f12323a);
        if (aVar == id.a.SUSPEND) {
            int i11 = this.f12324b;
            if (i11 != -3) {
                if (i10 == -3) {
                    i10 = i11;
                } else if (i11 != -2) {
                    if (i10 != -2 && (i11 = i11 + i10) < 0) {
                        i10 = com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER;
                    } else {
                        i10 = i11;
                    }
                }
            }
            aVar = this.f12325c;
        }
        return (kotlin.jvm.internal.k.a(iVarPlus, this.f12323a) && i10 == this.f12324b && aVar == this.f12325c) ? this : f(iVarPlus, i10, aVar);
    }

    public abstract Object e(id.r<? super T> rVar, oc.e<? super lc.q> eVar);

    public abstract e<T> f(oc.i iVar, int i10, id.a aVar);

    public final xc.p<id.r<? super T>, oc.e<? super lc.q>, Object> g() {
        return new b(this, null);
    }

    public final int h() {
        int i10 = this.f12324b;
        if (i10 == -3) {
            return -2;
        }
        return i10;
    }

    public t<T> i(m0 m0Var) {
        return id.p.c(m0Var, this.f12323a, h(), this.f12325c, o0.ATOMIC, null, g(), 16, null);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strB = b();
        if (strB != null) {
            arrayList.add(strB);
        }
        if (this.f12323a != oc.j.f13812a) {
            arrayList.add("context=" + this.f12323a);
        }
        if (this.f12324b != -3) {
            arrayList.add("capacity=" + this.f12324b);
        }
        if (this.f12325c != id.a.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f12325c);
        }
        return q0.a(this) + '[' + w.A(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
