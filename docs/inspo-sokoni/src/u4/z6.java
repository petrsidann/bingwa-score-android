package u4;

import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.internal.measurement.zzv;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class z6 implements zzv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u6 f16995a;

    public z6(u6 u6Var) {
        this.f16995a = u6Var;
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void zza(zzs zzsVar, String str, List<String> list, boolean z10, boolean z11) {
        x5 x5VarB;
        int i10 = b7.f16016a[zzsVar.ordinal()];
        if (i10 == 1) {
            x5VarB = this.f16995a.zzj().B();
        } else if (i10 == 2) {
            v5 v5VarZzj = this.f16995a.zzj();
            if (z10) {
                x5VarB = v5VarZzj.E();
            } else {
                x5VarB = !z11 ? v5VarZzj.D() : v5VarZzj.C();
            }
        } else if (i10 != 3) {
            x5VarB = i10 != 4 ? this.f16995a.zzj().F() : this.f16995a.zzj().G();
        } else {
            v5 v5VarZzj2 = this.f16995a.zzj();
            if (z10) {
                x5VarB = v5VarZzj2.J();
            } else {
                x5VarB = !z11 ? v5VarZzj2.I() : v5VarZzj2.H();
            }
        }
        int size = list.size();
        if (size == 1) {
            x5VarB.b(str, list.get(0));
            return;
        }
        if (size == 2) {
            x5VarB.c(str, list.get(0), list.get(1));
        } else if (size != 3) {
            x5VarB.a(str);
        } else {
            x5VarB.d(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
