package kd;

import java.util.Arrays;
import kd.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<S extends d<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public S[] f12319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12321c;

    public final S d() {
        S s10;
        synchronized (this) {
            S[] sArr = this.f12319a;
            if (sArr == null) {
                sArr = (S[]) f(2);
                this.f12319a = sArr;
            } else if (this.f12320b >= sArr.length) {
                Object[] objArrCopyOf = Arrays.copyOf(sArr, sArr.length * 2);
                kotlin.jvm.internal.k.d(objArrCopyOf, "copyOf(this, newSize)");
                this.f12319a = (S[]) ((d[]) objArrCopyOf);
                sArr = (S[]) ((d[]) objArrCopyOf);
            }
            int i10 = this.f12321c;
            do {
                s10 = sArr[i10];
                if (s10 == null) {
                    s10 = (S) e();
                    sArr[i10] = s10;
                }
                i10++;
                if (i10 >= sArr.length) {
                    i10 = 0;
                }
                kotlin.jvm.internal.k.c(s10, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            } while (!s10.a(this));
            this.f12321c = i10;
            this.f12320b++;
        }
        return s10;
    }

    public abstract S e();

    public abstract S[] f(int i10);

    public final void g(S s10) {
        int i10;
        oc.e<lc.q>[] eVarArrB;
        synchronized (this) {
            int i11 = this.f12320b - 1;
            this.f12320b = i11;
            if (i11 == 0) {
                this.f12321c = 0;
            }
            kotlin.jvm.internal.k.c(s10, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            eVarArrB = s10.b(this);
        }
        for (oc.e<lc.q> eVar : eVarArrB) {
            if (eVar != null) {
                lc.j.a aVar = lc.j.f12703b;
                eVar.resumeWith(lc.j.b(lc.q.f12711a));
            }
        }
    }

    public final S[] h() {
        return this.f12319a;
    }
}
