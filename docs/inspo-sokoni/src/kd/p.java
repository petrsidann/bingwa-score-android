package kd;

import gd.y1;
import ld.d0;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    public static final class a extends kotlin.jvm.internal.l implements xc.p<Integer, oc.i.b, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n<?> f12352a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n<?> nVar) {
            super(2);
            this.f12352a = nVar;
        }

        public final Integer a(int i10, oc.i.b bVar) {
            oc.i.c<?> key = bVar.getKey();
            oc.i.b bVar2 = this.f12352a.f12345b.get(key);
            if (key != y1.f9273i) {
                return Integer.valueOf(bVar != bVar2 ? Integer.MIN_VALUE : i10 + 1);
            }
            y1 y1Var = (y1) bVar2;
            kotlin.jvm.internal.k.c(bVar, "null cannot be cast to non-null type kotlinx.coroutines.Job");
            y1 y1VarB = p.b((y1) bVar, y1Var);
            if (y1VarB == y1Var) {
                if (y1Var != null) {
                    i10++;
                }
                return Integer.valueOf(i10);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + y1VarB + ", expected child of " + y1Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        @Override // xc.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, oc.i.b bVar) {
            return a(num.intValue(), bVar);
        }
    }

    public static final void a(n<?> nVar, oc.i iVar) {
        if (((Number) iVar.fold(0, new a(nVar))).intValue() == nVar.f12346c) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + nVar.f12345b + ",\n\t\tbut emission happened in " + iVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final y1 b(y1 y1Var, y1 y1Var2) {
        while (y1Var != null) {
            if (y1Var == y1Var2 || !(y1Var instanceof d0)) {
                return y1Var;
            }
            y1Var = y1Var.getParent();
        }
        return null;
    }
}
