package u4;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzkg;
import com.google.android.gms.internal.measurement.zzpf;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class eb extends fe {
    public eb(ge geVar) {
        super(geVar);
    }

    public static String b(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }

    @Override // u4.fe
    public final boolean t() {
        return false;
    }

    public final byte[] u(n0 n0Var, String str) {
        byte[] bArr;
        bf next;
        long j10;
        j0 j0VarA;
        j();
        this.f16624a.j();
        com.google.android.gms.common.internal.r.l(n0Var);
        com.google.android.gms.common.internal.r.f(str);
        if (!"_iap".equals(n0Var.f16569a) && !"_iapx".equals(n0Var.f16569a)) {
            zzj().B().c("Generating a payload for this event is not available. package_name, event_name", str, n0Var.f16569a);
            return null;
        }
        zzgf.zzj.zzb zzbVarZzb = zzgf.zzj.zzb();
        m().j1();
        try {
            h6 h6VarQ0 = m().Q0(str);
            if (h6VarQ0 == null) {
                zzj().B().b("Log and bundle not available. package_name", str);
            } else if (h6VarQ0.A()) {
                zzgf.zzk.zza zzaVarZzp = zzgf.zzk.zzx().zzh(1).zzp("android");
                if (!TextUtils.isEmpty(h6VarQ0.l())) {
                    zzaVarZzp.zzb(h6VarQ0.l());
                }
                if (!TextUtils.isEmpty(h6VarQ0.n())) {
                    zzaVarZzp.zzd((String) com.google.android.gms.common.internal.r.l(h6VarQ0.n()));
                }
                if (!TextUtils.isEmpty(h6VarQ0.o())) {
                    zzaVarZzp.zze((String) com.google.android.gms.common.internal.r.l(h6VarQ0.o()));
                }
                if (h6VarQ0.V() != -2147483648L) {
                    zzaVarZzp.zze((int) h6VarQ0.V());
                }
                zzaVarZzp.zzg(h6VarQ0.A0()).zze(h6VarQ0.w0());
                String strQ = h6VarQ0.q();
                String strJ = h6VarQ0.j();
                if (!TextUtils.isEmpty(strQ)) {
                    zzaVarZzp.zzm(strQ);
                } else if (!TextUtils.isEmpty(strJ)) {
                    zzaVarZzp.zza(strJ);
                }
                zzaVarZzp.zzk(h6VarQ0.K0());
                s8 s8VarB0 = this.f16938b.b0(str);
                zzaVarZzp.zzd(h6VarQ0.u0());
                if (this.f16624a.n() && a().L(zzaVarZzp.zzu()) && s8VarB0.w() && !TextUtils.isEmpty(null)) {
                    zzaVarZzp.zzj((String) null);
                }
                zzaVarZzp.zzg(s8VarB0.u());
                if (s8VarB0.w() && h6VarQ0.z()) {
                    Pair<String, Boolean> pairV = o().v(h6VarQ0.l(), s8VarB0);
                    if (h6VarQ0.z() && pairV != null && !TextUtils.isEmpty((CharSequence) pairV.first)) {
                        try {
                            zzaVarZzp.zzq(b((String) pairV.first, Long.toString(n0Var.f16572d)));
                            Object obj = pairV.second;
                            if (obj != null) {
                                zzaVarZzp.zzc(((Boolean) obj).booleanValue());
                            }
                        } catch (SecurityException e10) {
                            zzj().B().b("Resettable device id encryption failed", e10.getMessage());
                            bArr = new byte[0];
                        }
                    }
                }
                c().l();
                zzgf.zzk.zza zzaVarZzi = zzaVarZzp.zzi(Build.MODEL);
                c().l();
                zzaVarZzi.zzo(Build.VERSION.RELEASE).zzj((int) c().q()).zzs(c().r());
                try {
                    if (s8VarB0.x() && h6VarQ0.m() != null) {
                        zzaVarZzp.zzc(b((String) com.google.android.gms.common.internal.r.l(h6VarQ0.m()), Long.toString(n0Var.f16572d)));
                    }
                    if (!TextUtils.isEmpty(h6VarQ0.p())) {
                        zzaVarZzp.zzl((String) com.google.android.gms.common.internal.r.l(h6VarQ0.p()));
                    }
                    String strL = h6VarQ0.l();
                    List<bf> listD1 = m().d1(strL);
                    Iterator<bf> it = listD1.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!"_lte".equals(next.f16056c));
                    if (next == null || next.f16058e == null) {
                        bf bfVar = new bf(strL, "auto", "_lte", zzb().a(), 0L);
                        listD1.add(bfVar);
                        m().o0(bfVar);
                    }
                    zzgf.zzp[] zzpVarArr = new zzgf.zzp[listD1.size()];
                    for (int i10 = 0; i10 < listD1.size(); i10++) {
                        zzgf.zzp.zza zzaVarZzb = zzgf.zzp.zze().zza(listD1.get(i10).f16056c).zzb(listD1.get(i10).f16057d);
                        k().R(zzaVarZzb, listD1.get(i10).f16058e);
                        zzpVarArr[i10] = (zzgf.zzp) ((zzkg) zzaVarZzb.zzaj());
                    }
                    zzaVarZzp.zze(Arrays.asList(zzpVarArr));
                    this.f16938b.H(h6VarQ0, zzaVarZzp);
                    this.f16938b.g0(h6VarQ0, zzaVarZzp);
                    z5 z5VarB = z5.b(n0Var);
                    g().J(z5VarB.f16994d, m().M0(str));
                    g().T(z5VarB, a().t(str));
                    Bundle bundle = z5VarB.f16994d;
                    bundle.putLong("_c", 1L);
                    zzj().B().a("Marking in-app purchase as real-time");
                    bundle.putLong("_r", 1L);
                    bundle.putString("_o", n0Var.f16571c);
                    if (g().A0(zzaVarZzp.zzu(), h6VarQ0.v())) {
                        g().K(bundle, "_dbg", 1L);
                        g().K(bundle, "_r", 1L);
                    }
                    j0 j0VarP0 = m().P0(str, n0Var.f16569a);
                    if (j0VarP0 == null) {
                        j0VarA = new j0(str, n0Var.f16569a, 0L, 0L, n0Var.f16572d, 0L, null, null, null, null);
                        j10 = 0;
                    } else {
                        j10 = j0VarP0.f16382f;
                        j0VarA = j0VarP0.a(n0Var.f16572d);
                    }
                    m().c0(j0VarA);
                    g0 g0Var = new g0(this.f16624a, n0Var.f16571c, str, n0Var.f16569a, n0Var.f16572d, j10, bundle);
                    zzgf.zzf.zza zzaVarZza = zzgf.zzf.zze().zzb(g0Var.f16207d).zza(g0Var.f16205b).zza(g0Var.f16208e);
                    for (String str2 : g0Var.f16209f) {
                        zzgf.zzh.zza zzaVarZza2 = zzgf.zzh.zze().zza(str2);
                        Object objX = g0Var.f16209f.X(str2);
                        if (objX != null) {
                            k().Q(zzaVarZza2, objX);
                            zzaVarZza.zza(zzaVarZza2);
                        }
                    }
                    zzaVarZzp.zza(zzaVarZza).zza(zzgf.zzl.zza().zza(zzgf.zzg.zza().zza(j0VarA.f16379c).zza(n0Var.f16569a)));
                    zzaVarZzp.zza(l().u(h6VarQ0.l(), Collections.emptyList(), zzaVarZzp.zzac(), Long.valueOf(zzaVarZza.zzc()), Long.valueOf(zzaVarZza.zzc()), false));
                    if (zzaVarZza.zzg()) {
                        zzaVarZzp.zzj(zzaVarZza.zzc()).zzf(zzaVarZza.zzc());
                    }
                    long jE0 = h6VarQ0.E0();
                    if (jE0 != 0) {
                        zzaVarZzp.zzh(jE0);
                    }
                    long jI0 = h6VarQ0.I0();
                    if (jI0 != 0) {
                        zzaVarZzp.zzi(jI0);
                    } else if (jE0 != 0) {
                        zzaVarZzp.zzi(jE0);
                    }
                    String strU = h6VarQ0.u();
                    if (zzpf.zza() && a().D(str, p0.H0) && strU != null) {
                        zzaVarZzp.zzr(strU);
                    }
                    h6VarQ0.y();
                    zzaVarZzp.zzf((int) h6VarQ0.G0()).zzm(114010L).zzl(zzb().a()).zzd(true);
                    this.f16938b.w(zzaVarZzp.zzu(), zzaVarZzp);
                    zzbVarZzb.zza(zzaVarZzp);
                    h6VarQ0.D0(zzaVarZzp.zzf());
                    h6VarQ0.z0(zzaVarZzp.zze());
                    m().d0(h6VarQ0, false, false);
                    m().o1();
                    m().m1();
                    try {
                        return k().d0(((zzgf.zzj) ((zzkg) zzbVarZzb.zzaj())).zzce());
                    } catch (IOException e11) {
                        zzj().C().c("Data loss. Failed to bundle and serialize. appId", v5.r(str), e11);
                        return 0;
                    }
                } catch (SecurityException e12) {
                    zzj().B().b("app instance id encryption failed", e12.getMessage());
                    bArr = new byte[0];
                }
            } else {
                zzj().B().b("Log and bundle disabled. package_name", str);
            }
            bArr = new byte[0];
            m().m1();
            return bArr;
        } catch (Throwable th) {
            m().m1();
            throw th;
        }
    }
}
