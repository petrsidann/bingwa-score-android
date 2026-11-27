package u4;

import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzad;
import com.google.android.gms.internal.measurement.zzb;
import com.google.android.gms.internal.measurement.zzc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class o7 extends e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ge f16621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f16622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16623c;

    public o7(ge geVar) {
        this(geVar, null);
    }

    public o7(ge geVar, String str) {
        com.google.android.gms.common.internal.r.l(geVar);
        this.f16621a = geVar;
        this.f16623c = null;
    }

    public static /* synthetic */ void k1(o7 o7Var, Bundle bundle, String str, me meVar) {
        boolean zP = o7Var.f16621a.p0().p(p0.Y0);
        boolean zP2 = o7Var.f16621a.p0().p(p0.f16637a1);
        if (bundle.isEmpty() && zP) {
            s sVarS0 = o7Var.f16621a.s0();
            sVarS0.j();
            sVarS0.q();
            try {
                sVarS0.x().execSQL("delete from default_event_params where app_id=?", new String[]{str});
                return;
            } catch (SQLiteException e10) {
                sVarS0.zzj().C().b("Error clearing default event params", e10);
                return;
            }
        }
        o7Var.f16621a.s0().j0(str, bundle);
        if (o7Var.f16621a.s0().i0(str, meVar.K)) {
            s sVarS1 = o7Var.f16621a.s0();
            if (zP2) {
                sVarS1.V(str, Long.valueOf(meVar.K), null, bundle);
            } else {
                sVarS1.V(str, null, null, bundle);
            }
        }
    }

    public static /* synthetic */ void l1(o7 o7Var, String str, be beVar, m5 m5Var) {
        o7Var.f16621a.I0();
        try {
            m5Var.w(o7Var.f16621a.l(str, beVar));
        } catch (RemoteException e10) {
            o7Var.f16621a.zzj().C().c("[sgtm] Failed to return upload batches for app", str, e10);
        }
    }

    public static /* synthetic */ void m1(o7 o7Var, me meVar) {
        o7Var.f16621a.I0();
        o7Var.f16621a.w0(meVar);
    }

    public static /* synthetic */ void n1(o7 o7Var, me meVar, Bundle bundle, h5 h5Var, String str) {
        o7Var.f16621a.I0();
        try {
            h5Var.zza(o7Var.f16621a.h(meVar, bundle));
        } catch (RemoteException e10) {
            o7Var.f16621a.zzj().C().c("Failed to return trigger URIs for app", str, e10);
        }
    }

    public static /* synthetic */ void o1(o7 o7Var, me meVar, f fVar) {
        o7Var.f16621a.I0();
        o7Var.f16621a.x((String) com.google.android.gms.common.internal.r.l(meVar.f16528a), fVar);
    }

    public static /* synthetic */ void r1(o7 o7Var, me meVar) {
        o7Var.f16621a.I0();
        o7Var.f16621a.t0(meVar);
    }

    @Override // u4.f5
    public final void A(h hVar, me meVar) {
        com.google.android.gms.common.internal.r.l(hVar);
        com.google.android.gms.common.internal.r.l(hVar.f16267c);
        s1(meVar, false);
        h hVar2 = new h(hVar);
        hVar2.f16265a = meVar.f16528a;
        q1(new a8(this, hVar2, meVar));
    }

    @Override // u4.f5
    public final List<ze> B(String str, String str2, String str3, boolean z10) {
        i(str, true);
        try {
            List<bf> list = (List) this.f16621a.zzl().r(new b8(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (bf bfVar : list) {
                if (z10 || !af.C0(bfVar.f16056c)) {
                    arrayList.add(new ze(bfVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e10) {
            this.f16621a.zzj().C().c("Failed to get user properties as. appId", v5.r(str), e10);
            return Collections.emptyList();
        }
    }

    @Override // u4.f5
    public final void C0(me meVar) {
        s1(meVar, false);
        q1(new v7(this, meVar));
    }

    @Override // u4.f5
    public final void F(me meVar) {
        s1(meVar, false);
        q1(new t7(this, meVar));
    }

    @Override // u4.f5
    public final void G0(final me meVar, final Bundle bundle, final h5 h5Var) {
        s1(meVar, false);
        final String str = (String) com.google.android.gms.common.internal.r.l(meVar.f16528a);
        this.f16621a.zzl().y(new Runnable() { // from class: u4.q7
            @Override // java.lang.Runnable
            public final void run() {
                o7.n1(this.f16727a, meVar, bundle, h5Var, str);
            }
        });
    }

    @Override // u4.f5
    public final void O0(me meVar) {
        com.google.android.gms.common.internal.r.f(meVar.f16528a);
        i(meVar.f16528a, false);
        q1(new f8(this, meVar));
    }

    @Override // u4.f5
    public final void P(final me meVar) {
        com.google.android.gms.common.internal.r.f(meVar.f16528a);
        com.google.android.gms.common.internal.r.l(meVar.f16548z);
        f(new Runnable() { // from class: u4.p7
            @Override // java.lang.Runnable
            public final void run() {
                o7.m1(this.f16698a, meVar);
            }
        });
    }

    @Override // u4.f5
    public final List<h> R0(String str, String str2, me meVar) {
        s1(meVar, false);
        String str3 = meVar.f16528a;
        com.google.android.gms.common.internal.r.l(str3);
        try {
            return (List) this.f16621a.zzl().r(new e8(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e10) {
            this.f16621a.zzj().C().b("Failed to get conditional user properties", e10);
            return Collections.emptyList();
        }
    }

    @Override // u4.f5
    public final void S0(me meVar, final be beVar, final m5 m5Var) {
        if (this.f16621a.p0().p(p0.K0)) {
            s1(meVar, false);
            final String str = (String) com.google.android.gms.common.internal.r.l(meVar.f16528a);
            this.f16621a.zzl().y(new Runnable() { // from class: u4.s7
                @Override // java.lang.Runnable
                public final void run() {
                    o7.l1(this.f16789a, str, beVar, m5Var);
                }
            });
        }
    }

    @Override // u4.f5
    public final List<sd> T(me meVar, Bundle bundle) {
        s1(meVar, false);
        com.google.android.gms.common.internal.r.l(meVar.f16528a);
        try {
            if (!this.f16621a.p0().p(p0.f16646d1)) {
                return (List) this.f16621a.zzl().r(new p8(this, meVar, bundle)).get();
            }
            try {
                return (List) this.f16621a.zzl().w(new m8(this, meVar, bundle)).get(10000L, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e10) {
                e = e10;
                this.f16621a.zzj().C().c("Failed to get trigger URIs. appId", v5.r(meVar.f16528a), e);
                return Collections.emptyList();
            }
        } catch (InterruptedException e11) {
            e = e11;
        } catch (ExecutionException e12) {
            e = e12;
        }
    }

    @Override // u4.f5
    public final List<ze> U0(String str, String str2, boolean z10, me meVar) {
        s1(meVar, false);
        String str3 = meVar.f16528a;
        com.google.android.gms.common.internal.r.l(str3);
        try {
            List<bf> list = (List) this.f16621a.zzl().r(new c8(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (bf bfVar : list) {
                if (z10 || !af.C0(bfVar.f16056c)) {
                    arrayList.add(new ze(bfVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e10) {
            this.f16621a.zzj().C().c("Failed to query user properties. appId", v5.r(meVar.f16528a), e10);
            return Collections.emptyList();
        }
    }

    @Override // u4.f5
    public final byte[] W(n0 n0Var, String str) {
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.l(n0Var);
        i(str, true);
        this.f16621a.zzj().B().b("Log and bundle. event", this.f16621a.v0().b(n0Var.f16569a));
        long jC = this.f16621a.zzb().c() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f16621a.zzl().w(new k8(this, n0Var, str)).get();
            if (bArr == null) {
                this.f16621a.zzj().C().b("Log and bundle returned null. appId", v5.r(str));
                bArr = new byte[0];
            }
            this.f16621a.zzj().B().d("Log and bundle processed. event, size, time_ms", this.f16621a.v0().b(n0Var.f16569a), Integer.valueOf(bArr.length), Long.valueOf((this.f16621a.zzb().c() / 1000000) - jC));
            return bArr;
        } catch (InterruptedException | ExecutionException e10) {
            this.f16621a.zzj().C().d("Failed to log and bundle. appId, event, error", v5.r(str), this.f16621a.v0().b(n0Var.f16569a), e10);
            return null;
        }
    }

    @Override // u4.f5
    public final q X(me meVar) {
        s1(meVar, false);
        com.google.android.gms.common.internal.r.f(meVar.f16528a);
        try {
            return (q) this.f16621a.zzl().w(new j8(this, meVar)).get(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            this.f16621a.zzj().C().c("Failed to get consent. appId", v5.r(meVar.f16528a), e10);
            return new q(null);
        }
    }

    @Override // u4.f5
    public final void Y(n0 n0Var, me meVar) {
        com.google.android.gms.common.internal.r.l(n0Var);
        s1(meVar, false);
        q1(new h8(this, n0Var, meVar));
    }

    @Override // u4.f5
    public final void Y0(me meVar) {
        com.google.android.gms.common.internal.r.f(meVar.f16528a);
        com.google.android.gms.common.internal.r.l(meVar.f16548z);
        f(new g8(this, meVar));
    }

    @Override // u4.f5
    public final List<ze> b0(me meVar, boolean z10) {
        s1(meVar, false);
        String str = meVar.f16528a;
        com.google.android.gms.common.internal.r.l(str);
        try {
            List<bf> list = (List) this.f16621a.zzl().r(new w7(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (bf bfVar : list) {
                if (z10 || !af.C0(bfVar.f16056c)) {
                    arrayList.add(new ze(bfVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e10) {
            this.f16621a.zzj().C().c("Failed to get user properties. appId", v5.r(meVar.f16528a), e10);
            return null;
        }
    }

    @Override // u4.f5
    public final void c0(n0 n0Var, String str, String str2) {
        com.google.android.gms.common.internal.r.l(n0Var);
        com.google.android.gms.common.internal.r.f(str);
        i(str, true);
        q1(new l8(this, n0Var, str));
    }

    public final void f(Runnable runnable) {
        com.google.android.gms.common.internal.r.l(runnable);
        if (this.f16621a.zzl().G()) {
            runnable.run();
        } else {
            this.f16621a.zzl().C(runnable);
        }
    }

    @Override // u4.f5
    public final void f0(long j10, String str, String str2, String str3) {
        q1(new x7(this, str2, str3, str, j10));
    }

    @Override // u4.f5
    public final List<h> h0(String str, String str2, String str3) {
        i(str, true);
        try {
            return (List) this.f16621a.zzl().r(new d8(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e10) {
            this.f16621a.zzj().C().b("Failed to get conditional user properties as", e10);
            return Collections.emptyList();
        }
    }

    public final void i(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            this.f16621a.zzj().C().a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z10) {
            try {
                if (this.f16622b == null) {
                    this.f16622b = Boolean.valueOf("com.google.android.gms".equals(this.f16623c) || j4.r.a(this.f16621a.zza(), Binder.getCallingUid()) || c4.k.a(this.f16621a.zza()).c(Binder.getCallingUid()));
                }
                if (this.f16622b.booleanValue()) {
                    return;
                }
            } catch (SecurityException e10) {
                this.f16621a.zzj().C().b("Measurement Service called with invalid calling package. appId", v5.r(str));
                throw e10;
            }
        }
        if (this.f16623c == null && c4.j.k(this.f16621a.zza(), Binder.getCallingUid(), str)) {
            this.f16623c = str;
        }
        if (str.equals(this.f16623c)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    @Override // u4.f5
    public final void i0(ze zeVar, me meVar) {
        com.google.android.gms.common.internal.r.l(zeVar);
        s1(meVar, false);
        q1(new n8(this, zeVar, meVar));
    }

    @Override // u4.f5
    public final void j0(h hVar) {
        com.google.android.gms.common.internal.r.l(hVar);
        com.google.android.gms.common.internal.r.l(hVar.f16267c);
        com.google.android.gms.common.internal.r.f(hVar.f16265a);
        i(hVar.f16265a, true);
        q1(new z7(this, new h(hVar)));
    }

    @Override // u4.f5
    public final String l0(me meVar) {
        s1(meVar, false);
        return this.f16621a.Z(meVar);
    }

    @Override // u4.f5
    public final void m(final me meVar) {
        com.google.android.gms.common.internal.r.f(meVar.f16528a);
        com.google.android.gms.common.internal.r.l(meVar.f16548z);
        f(new Runnable() { // from class: u4.r7
            @Override // java.lang.Runnable
            public final void run() {
                o7.r1(this.f16754a, meVar);
            }
        });
    }

    @Override // u4.f5
    public final void m0(final me meVar, final f fVar) {
        if (this.f16621a.p0().p(p0.K0)) {
            s1(meVar, false);
            q1(new Runnable() { // from class: u4.n7
                @Override // java.lang.Runnable
                public final void run() {
                    o7.o1(this.f16593a, meVar, fVar);
                }
            });
        }
    }

    public final n0 p1(n0 n0Var, me meVar) {
        i0 i0Var;
        boolean z10 = false;
        if ("_cmp".equals(n0Var.f16569a) && (i0Var = n0Var.f16570b) != null && i0Var.S() != 0) {
            String strY = n0Var.f16570b.Y("_cis");
            if ("referrer broadcast".equals(strY) || "referrer API".equals(strY)) {
                z10 = true;
            }
        }
        if (!z10) {
            return n0Var;
        }
        this.f16621a.zzj().F().b("Event has been filtered ", n0Var.toString());
        return new n0("_cmpx", n0Var.f16570b, n0Var.f16571c, n0Var.f16572d);
    }

    public final void q1(Runnable runnable) {
        com.google.android.gms.common.internal.r.l(runnable);
        if (this.f16621a.zzl().G()) {
            runnable.run();
        } else {
            this.f16621a.zzl().y(runnable);
        }
    }

    public final void s1(me meVar, boolean z10) {
        com.google.android.gms.common.internal.r.l(meVar);
        com.google.android.gms.common.internal.r.f(meVar.f16528a);
        i(meVar.f16528a, false);
        this.f16621a.G0().g0(meVar.f16529b, meVar.f16543u);
    }

    @Override // u4.f5
    public final void t0(me meVar) {
        s1(meVar, false);
        q1(new y7(this, meVar));
    }

    public final void t1(n0 n0Var, me meVar) {
        boolean zZza;
        if (!this.f16621a.z0().T(meVar.f16528a)) {
            u1(n0Var, meVar);
            return;
        }
        this.f16621a.zzj().G().b("EES config found for", meVar.f16528a);
        u6 u6VarZ0 = this.f16621a.z0();
        String str = meVar.f16528a;
        zzb zzbVar = TextUtils.isEmpty(str) ? null : u6VarZ0.f16851j.get(str);
        if (zzbVar == null) {
            this.f16621a.zzj().G().b("EES not loaded for", meVar.f16528a);
        } else {
            try {
                Map<String, Object> mapK = this.f16621a.F0().K(n0Var.f16570b.V(), true);
                String strA = y8.a(n0Var.f16569a);
                if (strA == null) {
                    strA = n0Var.f16569a;
                }
                zZza = zzbVar.zza(new zzad(strA, n0Var.f16572d, mapK));
            } catch (zzc unused) {
                this.f16621a.zzj().C().c("EES error. appId, eventName", meVar.f16529b, n0Var.f16569a);
                zZza = false;
            }
            if (zZza) {
                if (zzbVar.zzc()) {
                    this.f16621a.zzj().G().b("EES edited event", n0Var.f16569a);
                    n0Var = this.f16621a.F0().L(zzbVar.zza().zzb());
                }
                u1(n0Var, meVar);
                if (zzbVar.zzb()) {
                    for (zzad zzadVar : zzbVar.zza().zzc()) {
                        this.f16621a.zzj().G().b("EES logging created event", zzadVar.zzb());
                        u1(this.f16621a.F0().L(zzadVar), meVar);
                    }
                    return;
                }
                return;
            }
            this.f16621a.zzj().G().b("EES was not applied to event", n0Var.f16569a);
        }
        u1(n0Var, meVar);
    }

    public final void u1(n0 n0Var, me meVar) {
        this.f16621a.I0();
        this.f16621a.G(n0Var, meVar);
    }

    @Override // u4.f5
    public final void w0(final Bundle bundle, final me meVar) {
        s1(meVar, false);
        final String str = meVar.f16528a;
        com.google.android.gms.common.internal.r.l(str);
        q1(new Runnable() { // from class: u4.u7
            @Override // java.lang.Runnable
            public final void run() {
                o7.k1(this.f16856a, bundle, str, meVar);
            }
        });
    }
}
