package u4;

import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzoh;

/* JADX INFO: loaded from: classes.dex */
public final class e extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public zzfw.zze f16124g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ kf f16125h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(kf kfVar, String str, int i10, zzfw.zze zzeVar) {
        super(str, i10);
        this.f16125h = kfVar;
        this.f16124g = zzeVar;
    }

    @Override // u4.b
    public final int a() {
        return this.f16124g.zza();
    }

    @Override // u4.b
    public final boolean i() {
        return false;
    }

    @Override // u4.b
    public final boolean j() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean k(Long l10, Long l11, zzgf.zzp zzpVar, boolean z10) {
        x5 x5VarH;
        String strG;
        String str;
        Boolean boolG;
        Object[] objArr = zzoh.zza() && this.f16125h.a().F(this.f16007a, p0.f16690y0);
        boolean zZzf = this.f16124g.zzf();
        boolean zZzg = this.f16124g.zzg();
        boolean zZzh = this.f16124g.zzh();
        Object[] objArr2 = zZzf || zZzg || zZzh;
        Boolean boolD = null;
        boolD = null;
        if (z10 && objArr2 != true) {
            this.f16125h.zzj().G().c("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f16008b), this.f16124g.zzi() ? Integer.valueOf(this.f16124g.zza()) : null);
            return true;
        }
        zzfw.zzc zzcVarZzb = this.f16124g.zzb();
        boolean zZzf2 = zzcVarZzb.zzf();
        if (zzpVar.zzk()) {
            if (zzcVarZzb.zzh()) {
                boolG = b.c(zzpVar.zzc(), zzcVarZzb.zzc());
                boolD = b.d(boolG, zZzf2);
            } else {
                x5VarH = this.f16125h.zzj().H();
                strG = this.f16125h.d().g(zzpVar.zzg());
                str = "No number filter for long property. property";
                x5VarH.b(str, strG);
            }
        } else if (!zzpVar.zzi()) {
            if (zzpVar.zzm()) {
                if (zzcVarZzb.zzj()) {
                    boolG = b.g(zzpVar.zzh(), zzcVarZzb.zzd(), this.f16125h.zzj());
                } else if (!zzcVarZzb.zzh()) {
                    x5VarH = this.f16125h.zzj().H();
                    strG = this.f16125h.d().g(zzpVar.zzg());
                    str = "No string or number filter defined. property";
                } else if (we.c0(zzpVar.zzh())) {
                    boolG = b.e(zzpVar.zzh(), zzcVarZzb.zzc());
                } else {
                    this.f16125h.zzj().H().c("Invalid user property value for Numeric number filter. property, value", this.f16125h.d().g(zzpVar.zzg()), zzpVar.zzh());
                }
                boolD = b.d(boolG, zZzf2);
            } else {
                x5VarH = this.f16125h.zzj().H();
                strG = this.f16125h.d().g(zzpVar.zzg());
                str = "User property has no value, property";
            }
            x5VarH.b(str, strG);
        } else if (zzcVarZzb.zzh()) {
            boolG = b.b(zzpVar.zza(), zzcVarZzb.zzc());
            boolD = b.d(boolG, zZzf2);
        } else {
            x5VarH = this.f16125h.zzj().H();
            strG = this.f16125h.d().g(zzpVar.zzg());
            str = "No number filter for double property. property";
            x5VarH.b(str, strG);
        }
        this.f16125h.zzj().G().b("Property filter result", boolD == null ? "null" : boolD);
        if (boolD == null) {
            return false;
        }
        this.f16009c = Boolean.TRUE;
        if (zZzh && !boolD.booleanValue()) {
            return true;
        }
        if (!z10 || this.f16124g.zzf()) {
            this.f16010d = boolD;
        }
        if (boolD.booleanValue() && objArr2 != false && zzpVar.zzl()) {
            long jZzd = zzpVar.zzd();
            if (l10 != null) {
                jZzd = l10.longValue();
            }
            if (objArr != false && this.f16124g.zzf() && !this.f16124g.zzg() && l11 != null) {
                jZzd = l11.longValue();
            }
            if (this.f16124g.zzg()) {
                this.f16012f = Long.valueOf(jZzd);
            } else {
                this.f16011e = Long.valueOf(jZzd);
            }
        }
        return true;
    }
}
