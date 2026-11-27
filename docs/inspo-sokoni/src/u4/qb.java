package u4;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzdq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class qb extends f4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final uc f16737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f5 f16738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Boolean f16739e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d0 f16740f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final td f16741g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Runnable> f16742h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d0 f16743i;

    public qb(k7 k7Var) {
        super(k7Var);
        this.f16742h = new ArrayList();
        this.f16741g = new td(k7Var.zzb());
        this.f16737c = new uc(this);
        this.f16740f = new wb(this, k7Var);
        this.f16743i = new ic(this, k7Var);
    }

    public static /* synthetic */ void Q(qb qbVar, ComponentName componentName) {
        qbVar.j();
        if (qbVar.f16738d != null) {
            qbVar.f16738d = null;
            qbVar.zzj().G().b("Disconnected from device MeasurementService", componentName);
            qbVar.j();
            qbVar.b0();
        }
    }

    public static /* synthetic */ void R(qb qbVar, AtomicReference atomicReference, me meVar, Bundle bundle) {
        synchronized (atomicReference) {
            try {
                f5 f5Var = qbVar.f16738d;
                if (f5Var == null) {
                    qbVar.zzj().C().a("Failed to request trigger URIs; not connected to service");
                    return;
                }
                com.google.android.gms.common.internal.r.l(meVar);
                f5Var.G0(meVar, bundle, new ac(qbVar, atomicReference));
                qbVar.m0();
            } catch (RemoteException e10) {
                qbVar.zzj().C().b("Failed to request trigger URIs; remote exception", e10);
                atomicReference.notifyAll();
            }
        }
    }

    public static /* synthetic */ void S(qb qbVar, AtomicReference atomicReference, me meVar, be beVar) {
        synchronized (atomicReference) {
            try {
                f5 f5Var = qbVar.f16738d;
                if (f5Var == null) {
                    qbVar.zzj().C().a("[sgtm] Failed to get upload batches; not connected to service");
                    return;
                }
                com.google.android.gms.common.internal.r.l(meVar);
                f5Var.S0(meVar, beVar, new cc(qbVar, atomicReference));
                qbVar.m0();
            } catch (RemoteException e10) {
                qbVar.zzj().C().b("[sgtm] Failed to get upload batches; remote exception", e10);
                atomicReference.notifyAll();
            }
        }
    }

    public static /* synthetic */ void U(qb qbVar, me meVar, f fVar) {
        f5 f5Var = qbVar.f16738d;
        if (f5Var == null) {
            qbVar.zzj().C().a("[sgtm] Discarding data. Failed to update batch upload status.");
            return;
        }
        try {
            f5Var.m0(meVar, fVar);
            qbVar.m0();
        } catch (RemoteException e10) {
            qbVar.zzj().C().c("[sgtm] Failed to update batch upload status, rowId, exception", Long.valueOf(fVar.f16173a), e10);
        }
    }

    public static /* synthetic */ void q0(qb qbVar) {
        f5 f5Var = qbVar.f16738d;
        if (f5Var == null) {
            qbVar.zzj().C().a("Failed to send storage consent settings to service");
            return;
        }
        try {
            me meVarP0 = qbVar.p0(false);
            com.google.android.gms.common.internal.r.l(meVarP0);
            f5Var.P(meVarP0);
            qbVar.m0();
        } catch (RemoteException e10) {
            qbVar.zzj().C().b("Failed to send storage consent settings to the service", e10);
        }
    }

    public static /* synthetic */ void r0(qb qbVar) {
        f5 f5Var = qbVar.f16738d;
        if (f5Var == null) {
            qbVar.zzj().C().a("Failed to send Dma consent settings to service");
            return;
        }
        try {
            me meVarP0 = qbVar.p0(false);
            com.google.android.gms.common.internal.r.l(meVarP0);
            f5Var.m(meVarP0);
            qbVar.m0();
        } catch (RemoteException e10) {
            qbVar.zzj().C().b("Failed to send Dma consent settings to the service", e10);
        }
    }

    public static /* synthetic */ void t0(qb qbVar) {
        qbVar.j();
        if (qbVar.g0()) {
            qbVar.zzj().G().a("Inactivity, disconnecting from the service");
            qbVar.c0();
        }
    }

    public final void A(zzdq zzdqVar) {
        j();
        u();
        E(new gc(this, p0(false), zzdqVar));
    }

    public final void B(zzdq zzdqVar, String str, String str2) {
        j();
        u();
        E(new sc(this, str, str2, p0(false), zzdqVar));
    }

    public final void C(zzdq zzdqVar, String str, String str2, boolean z10) {
        j();
        u();
        E(new yb(this, str, str2, p0(false), z10, zzdqVar));
    }

    public final void D(zzdq zzdqVar, n0 n0Var, String str) {
        j();
        u();
        if (g().q(12451000) == 0) {
            E(new mc(this, n0Var, str, zzdqVar));
        } else {
            zzj().H().a("Not bundling data. Service unavailable or out of date");
            g().R(zzdqVar, new byte[0]);
        }
    }

    public final void E(Runnable runnable) {
        j();
        if (g0()) {
            runnable.run();
        } else {
            if (this.f16742h.size() >= 1000) {
                zzj().C().a("Discarding data. Max runnable queue size reached");
                return;
            }
            this.f16742h.add(runnable);
            this.f16743i.b(60000L);
            b0();
        }
    }

    public final void F(AtomicReference<String> atomicReference) {
        j();
        u();
        E(new dc(this, atomicReference, p0(false)));
    }

    public final void G(final AtomicReference<List<sd>> atomicReference, final Bundle bundle) {
        j();
        u();
        final me meVarP0 = p0(false);
        E(a().p(p0.f16649e1) ? new Runnable() { // from class: u4.ub
            @Override // java.lang.Runnable
            public final void run() {
                qb.R(this.f16869a, atomicReference, meVarP0, bundle);
            }
        } : new zb(this, atomicReference, meVarP0, bundle));
    }

    public final void H(AtomicReference<List<h>> atomicReference, String str, String str2, String str3) {
        j();
        u();
        E(new pc(this, atomicReference, str, str2, str3, p0(false)));
    }

    public final void I(AtomicReference<List<ze>> atomicReference, String str, String str2, String str3, boolean z10) {
        j();
        u();
        E(new rc(this, atomicReference, str, str2, str3, p0(false), z10));
    }

    public final void J(final AtomicReference<de> atomicReference, final be beVar) {
        j();
        u();
        final me meVarP0 = p0(false);
        E(new Runnable() { // from class: u4.xb
            @Override // java.lang.Runnable
            public final void run() {
                qb.S(this.f16956a, atomicReference, meVarP0, beVar);
            }
        });
    }

    public final void K(final f fVar) {
        j();
        u();
        final me meVarP0 = p0(true);
        com.google.android.gms.common.internal.r.l(meVarP0);
        E(new Runnable() { // from class: u4.vb
            @Override // java.lang.Runnable
            public final void run() {
                qb.U(this.f16911a, meVarP0, fVar);
            }
        });
    }

    public final void L(h hVar) {
        com.google.android.gms.common.internal.r.l(hVar);
        j();
        u();
        E(new qc(this, true, p0(true), m().B(hVar), new h(hVar), hVar));
    }

    public final void M(n0 n0Var, String str) {
        com.google.android.gms.common.internal.r.l(n0Var);
        j();
        u();
        E(new nc(this, true, p0(true), m().C(n0Var), n0Var, str));
    }

    public final void N(f5 f5Var) {
        j();
        com.google.android.gms.common.internal.r.l(f5Var);
        this.f16738d = f5Var;
        m0();
        l0();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:70:0x0135 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    public final void O(f5 f5Var, d4.a aVar, me meVar) throws Throwable {
        int size;
        x5 x5VarC;
        String str;
        long jB;
        long j10;
        long jA;
        j();
        u();
        int i10 = 100;
        int i11 = 0;
        for (int i12 = 100; i11 < 1001 && i10 == i12; i12 = 100) {
            ArrayList arrayList = new ArrayList();
            List<d4.a> listZ = m().z(i12);
            if (listZ != null) {
                arrayList.addAll(listZ);
                size = listZ.size();
            } else {
                size = 0;
            }
            if (aVar != null && size < i12) {
                arrayList.add(aVar);
            }
            boolean zP = a().p(p0.P0);
            int size2 = arrayList.size();
            int i13 = 0;
            while (i13 < size2) {
                int i14 = i13 + 1;
                d4.a aVar2 = (d4.a) arrayList.get(i13);
                if (aVar2 instanceof n0) {
                    if (zP) {
                        try {
                            jA = this.f16624a.zzb().a();
                            try {
                                jB = this.f16624a.zzb().b();
                            } catch (RemoteException e10) {
                                e = e10;
                                jB = 0;
                                j10 = jA;
                                zzj().C().b("Failed to send event to the service", e);
                                if (!zP) {
                                }
                                i13 = i14;
                            }
                        } catch (RemoteException e11) {
                            e = e11;
                            jB = 0;
                            j10 = 0;
                            zzj().C().b("Failed to send event to the service", e);
                            if (!zP && j10 != 0) {
                                t5.a(this.f16624a).b(36301, 13, j10, this.f16624a.zzb().a(), (int) (this.f16624a.zzb().b() - jB));
                            }
                        }
                    } else {
                        jA = 0;
                        jB = 0;
                    }
                    try {
                        f5Var.Y((n0) aVar2, meVar);
                        if (zP) {
                            zzj().G().a("Logging telemetry for logEvent from database");
                            t5.a(this.f16624a).b(36301, 0, jA, this.f16624a.zzb().a(), (int) (this.f16624a.zzb().b() - jB));
                        }
                    } catch (RemoteException e12) {
                        e = e12;
                        j10 = jA;
                        zzj().C().b("Failed to send event to the service", e);
                        if (!zP) {
                        }
                    }
                } else if (aVar2 instanceof ze) {
                    try {
                        f5Var.i0((ze) aVar2, meVar);
                    } catch (RemoteException e13) {
                        e = e13;
                        x5VarC = zzj().C();
                        str = "Failed to send user property to the service";
                        x5VarC.b(str, e);
                    }
                } else if (aVar2 instanceof h) {
                    try {
                        f5Var.A((h) aVar2, meVar);
                    } catch (RemoteException e14) {
                        e = e14;
                        x5VarC = zzj().C();
                        str = "Failed to send conditional user property to the service";
                        x5VarC.b(str, e);
                    }
                } else {
                    zzj().C().a("Discarding data. Unrecognized parcel type.");
                }
                i13 = i14;
            }
            i11++;
            i10 = size;
        }
    }

    public final void P(hb hbVar) {
        j();
        u();
        E(new kc(this, hbVar));
    }

    public final void V(ze zeVar) {
        j();
        u();
        E(new bc(this, p0(true), m().D(zeVar), zeVar));
    }

    public final void W(boolean z10) {
        j();
        u();
        if (i0()) {
            E(new oc(this, p0(false)));
        }
    }

    public final q X() {
        j();
        u();
        f5 f5Var = this.f16738d;
        if (f5Var == null) {
            b0();
            zzj().B().a("Failed to get consents; not connected to service yet.");
            return null;
        }
        me meVarP0 = p0(false);
        com.google.android.gms.common.internal.r.l(meVarP0);
        try {
            q qVarX = f5Var.X(meVarP0);
            m0();
            return qVarX;
        } catch (RemoteException e10) {
            zzj().C().b("Failed to get consents; remote exception", e10);
            return null;
        }
    }

    public final Boolean Y() {
        return this.f16739e;
    }

    public final void Z() {
        j();
        u();
        E(new hc(this, p0(true)));
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ j a() {
        return super.a();
    }

    public final void a0() {
        j();
        u();
        me meVarP0 = p0(true);
        m().F();
        E(new fc(this, meVarP0));
    }

    public final void b0() {
        j();
        u();
        if (g0()) {
            return;
        }
        if (k0()) {
            this.f16737c.a();
            return;
        }
        if (a().V()) {
            return;
        }
        List<ResolveInfo> listQueryIntentServices = zza().getPackageManager().queryIntentServices(new Intent().setClassName(zza(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (!((listQueryIntentServices == null || listQueryIntentServices.isEmpty()) ? false : true)) {
            zzj().C().a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName(zza(), "com.google.android.gms.measurement.AppMeasurementService"));
        this.f16737c.c(intent);
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ h0 c() {
        return super.c();
    }

    public final void c0() {
        j();
        u();
        this.f16737c.e();
        try {
            i4.b.b().c(zza(), this.f16737c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f16738d = null;
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ s5 d() {
        return super.d();
    }

    public final void d0() {
        j();
        u();
        me meVarP0 = p0(false);
        m().E();
        E(new ec(this, meVarP0));
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ i6 e() {
        return super.e();
    }

    public final void e0() {
        j();
        u();
        E(new Runnable() { // from class: u4.sb
            @Override // java.lang.Runnable
            public final void run() {
                qb.r0(this.f16805a);
            }
        });
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ ab f() {
        return super.f();
    }

    public final void f0() {
        j();
        u();
        E(new lc(this, p0(true)));
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ af g() {
        return super.g();
    }

    public final boolean g0() {
        j();
        u();
        return this.f16738d != null;
    }

    @Override // u4.g5, u4.o8
    public final /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    public final boolean h0() {
        j();
        u();
        return !k0() || g().D0() >= 200900;
    }

    @Override // u4.g5, u4.o8
    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    public final boolean i0() {
        j();
        u();
        return !k0() || g().D0() >= p0.E0.a(null).intValue();
    }

    @Override // u4.g5, u4.o8
    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public final boolean j0() {
        j();
        u();
        return !k0() || g().D0() >= 241200;
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ a k() {
        return super.k();
    }

    public final boolean k0() {
        x5 x5VarG;
        String str;
        boolean z10;
        x5 x5VarH;
        String str2;
        j();
        u();
        if (this.f16739e == null) {
            j();
            u();
            Boolean boolJ = e().J();
            boolean z11 = true;
            if (boolJ == null || !boolJ.booleanValue()) {
                boolean z12 = false;
                if (l().z() == 1) {
                    z10 = true;
                } else {
                    zzj().G().a("Checking service availability");
                    int iQ = g().q(12451000);
                    if (iQ != 0) {
                        if (iQ == 1) {
                            zzj().G().a("Service missing");
                        } else if (iQ != 2) {
                            if (iQ != 3) {
                                if (iQ == 9) {
                                    x5VarH = zzj().H();
                                    str2 = "Service invalid";
                                } else if (iQ != 18) {
                                    zzj().H().b("Unexpected service status", Integer.valueOf(iQ));
                                } else {
                                    x5VarG = zzj().H();
                                    str = "Service updating";
                                }
                                z10 = false;
                                z11 = false;
                            } else {
                                x5VarH = zzj().H();
                                str2 = "Service disabled";
                            }
                            x5VarH.a(str2);
                            z10 = false;
                            z11 = false;
                        } else {
                            zzj().B().a("Service container out of date");
                            if (g().D0() >= 17443) {
                                z11 = boolJ == null;
                                z10 = false;
                            }
                        }
                        z10 = true;
                        z11 = false;
                    } else {
                        x5VarG = zzj().G();
                        str = "Service available";
                    }
                    x5VarG.a(str);
                    z10 = true;
                }
                if (z11 || !a().V()) {
                    z12 = z10;
                } else {
                    zzj().C().a("No way to upload. Consider using the full version of Analytics");
                }
                if (z12) {
                    e().s(z11);
                }
            }
            this.f16739e = Boolean.valueOf(z11);
        }
        return this.f16739e.booleanValue();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ n5 l() {
        return super.l();
    }

    public final void l0() {
        j();
        zzj().G().b("Processing queued up service tasks", Integer.valueOf(this.f16742h.size()));
        Iterator<Runnable> it = this.f16742h.iterator();
        while (it.hasNext()) {
            try {
                it.next().run();
            } catch (RuntimeException e10) {
                zzj().C().b("Task exception while flushing queue", e10);
            }
        }
        this.f16742h.clear();
        this.f16743i.a();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ q5 m() {
        return super.m();
    }

    public final void m0() {
        j();
        this.f16741g.c();
        this.f16740f.b(p0.U.a(null).longValue());
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ e9 n() {
        return super.n();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ db o() {
        return super.o();
    }

    public final void o0(boolean z10) {
        j();
        u();
        E(new Runnable() { // from class: u4.tb
            @Override // java.lang.Runnable
            public final void run() {
                qb.q0(this.f16837a);
            }
        });
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ kb p() {
        return super.p();
    }

    public final me p0(boolean z10) {
        return l().y(z10 ? zzj().K() : null);
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ qb q() {
        return super.q();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ id r() {
        return super.r();
    }

    @Override // u4.f4
    public final boolean t() {
        return false;
    }

    public final void z(Bundle bundle) {
        j();
        u();
        E(new jc(this, p0(false), bundle));
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ j4.d zzb() {
        return super.zzb();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ g zzd() {
        return super.zzd();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ v5 zzj() {
        return super.zzj();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ d7 zzl() {
        return super.zzl();
    }
}
