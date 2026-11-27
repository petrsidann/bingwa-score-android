package u4;

import android.os.Bundle;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public final class v9 implements p6.b<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ sd f16908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e9 f16909b;

    public v9(e9 e9Var, sd sdVar) {
        this.f16908a = sdVar;
        this.f16909b = e9Var;
    }

    @Override // p6.b
    public final void a(Throwable th) {
        this.f16909b.j();
        this.f16909b.f16147i = false;
        int iB = (this.f16909b.a().p(p0.U0) ? e9.B(this.f16909b, th) : 2) - 1;
        if (iB == 0) {
            this.f16909b.zzj().H().c("registerTriggerAsync failed with retriable error. Will try later. App ID, throwable", v5.r(this.f16909b.l().C()), v5.r(th.toString()));
            this.f16909b.f16148j = 1;
            this.f16909b.A0().add(this.f16908a);
            return;
        }
        if (iB != 1) {
            if (iB != 2) {
                return;
            }
            this.f16909b.zzj().C().c("registerTriggerAsync failed. Dropping URI. App ID, Throwable", v5.r(this.f16909b.l().C()), th);
            b();
            this.f16909b.f16148j = 1;
            this.f16909b.I0();
            return;
        }
        this.f16909b.A0().add(this.f16908a);
        if (this.f16909b.f16148j > p0.f16676r0.a(null).intValue()) {
            this.f16909b.f16148j = 1;
            this.f16909b.zzj().H().c("registerTriggerAsync failed. May try later. App ID, throwable", v5.r(this.f16909b.l().C()), v5.r(th.toString()));
            return;
        }
        this.f16909b.zzj().H().d("registerTriggerAsync failed. App ID, delay in seconds, throwable", v5.r(this.f16909b.l().C()), v5.r(String.valueOf(this.f16909b.f16148j)), v5.r(th.toString()));
        e9 e9Var = this.f16909b;
        e9.U0(e9Var, e9Var.f16148j);
        this.f16909b.f16148j <<= 1;
    }

    public final void b() {
        SparseArray<Long> sparseArrayG = this.f16909b.e().G();
        sd sdVar = this.f16908a;
        sparseArrayG.put(sdVar.f16813c, Long.valueOf(sdVar.f16812b));
        i6 i6VarE = this.f16909b.e();
        int[] iArr = new int[sparseArrayG.size()];
        long[] jArr = new long[sparseArrayG.size()];
        for (int i10 = 0; i10 < sparseArrayG.size(); i10++) {
            iArr[i10] = sparseArrayG.keyAt(i10);
            jArr[i10] = sparseArrayG.valueAt(i10).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        i6VarE.f16340p.b(bundle);
    }

    @Override // p6.b
    public final void onSuccess(Object obj) {
        this.f16909b.j();
        b();
        this.f16909b.f16147i = false;
        this.f16909b.f16148j = 1;
        this.f16909b.zzj().B().b("Successfully registered trigger URI", this.f16908a.f16811a);
        this.f16909b.I0();
    }
}
