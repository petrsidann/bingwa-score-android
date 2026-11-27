package e8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class o implements f1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f1 f7241a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<b8.r<Void>> f7243c = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public z0 f7244d = z0.UNKNOWN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<b1, e> f7242b = new HashMap();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f7246b;

        static {
            int[] iArr = new int[c.values().length];
            f7246b = iArr;
            try {
                iArr[c.TERMINATE_LOCAL_LISTEN_AND_REQUIRE_WATCH_DISCONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7246b[c.TERMINATE_LOCAL_LISTEN_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7246b[c.REQUIRE_WATCH_DISCONNECTION_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[d.values().length];
            f7245a = iArr2;
            try {
                iArr2[d.INITIALIZE_LOCAL_LISTEN_AND_REQUIRE_WATCH_CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7245a[d.INITIALIZE_LOCAL_LISTEN_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7245a[d.REQUIRE_WATCH_CONNECTION_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7248b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f7249c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public b8.s0 f7250d = b8.s0.DEFAULT;
    }

    public enum c {
        TERMINATE_LOCAL_LISTEN_AND_REQUIRE_WATCH_DISCONNECTION,
        TERMINATE_LOCAL_LISTEN_ONLY,
        REQUIRE_WATCH_DISCONNECTION_ONLY,
        NO_ACTION_REQUIRED
    }

    public enum d {
        INITIALIZE_LOCAL_LISTEN_AND_REQUIRE_WATCH_CONNECTION,
        INITIALIZE_LOCAL_LISTEN_ONLY,
        REQUIRE_WATCH_CONNECTION_ONLY,
        NO_ACTION_REQUIRED
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<c1> f7261a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public y1 f7262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7263c;

        public boolean f() {
            Iterator<c1> it = this.f7261a.iterator();
            while (it.hasNext()) {
                if (it.next().b()) {
                    return true;
                }
            }
            return false;
        }
    }

    public o(f1 f1Var) {
        this.f7241a = f1Var;
        f1Var.y(this);
    }

    @Override // e8.f1.c
    public void a(z0 z0Var) {
        this.f7244d = z0Var;
        Iterator<e> it = this.f7242b.values().iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            Iterator it2 = it.next().f7261a.iterator();
            while (it2.hasNext()) {
                if (((c1) it2.next()).d(z0Var)) {
                    z10 = true;
                }
            }
        }
        if (z10) {
            f();
        }
    }

    @Override // e8.f1.c
    public void b(b1 b1Var, vb.l1 l1Var) {
        e eVar = this.f7242b.get(b1Var);
        if (eVar != null) {
            Iterator it = eVar.f7261a.iterator();
            while (it.hasNext()) {
                ((c1) it.next()).c(l8.g0.u(l1Var));
            }
        }
        this.f7242b.remove(b1Var);
    }

    @Override // e8.f1.c
    public void c(List<y1> list) {
        boolean z10 = false;
        for (y1 y1Var : list) {
            e eVar = this.f7242b.get(y1Var.h());
            if (eVar != null) {
                Iterator it = eVar.f7261a.iterator();
                while (it.hasNext()) {
                    if (((c1) it.next()).e(y1Var)) {
                        z10 = true;
                    }
                }
                eVar.f7262b = y1Var;
            }
        }
        if (z10) {
            f();
        }
    }

    public int d(c1 c1Var) {
        int iN;
        b1 b1VarA = c1Var.a();
        d dVar = d.NO_ACTION_REQUIRED;
        e eVar = this.f7242b.get(b1VarA);
        if (eVar == null) {
            eVar = new e();
            this.f7242b.put(b1VarA, eVar);
            dVar = c1Var.b() ? d.INITIALIZE_LOCAL_LISTEN_AND_REQUIRE_WATCH_CONNECTION : d.INITIALIZE_LOCAL_LISTEN_ONLY;
        } else if (!eVar.f() && c1Var.b()) {
            dVar = d.REQUIRE_WATCH_CONNECTION_ONLY;
        }
        eVar.f7261a.add(c1Var);
        l8.b.d(!c1Var.d(this.f7244d), "onOnlineStateChanged() shouldn't raise an event for brand-new listeners.", new Object[0]);
        if (eVar.f7262b != null && c1Var.e(eVar.f7262b)) {
            f();
        }
        int i10 = a.f7245a[dVar.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                iN = this.f7241a.n(b1VarA, false);
            } else if (i10 == 3) {
                this.f7241a.o(b1VarA);
            }
            return eVar.f7263c;
        }
        iN = this.f7241a.n(b1VarA, true);
        eVar.f7263c = iN;
        return eVar.f7263c;
    }

    public void e(b8.r<Void> rVar) {
        this.f7243c.add(rVar);
        rVar.a(null, null);
    }

    public final void f() {
        Iterator<b8.r<Void>> it = this.f7243c.iterator();
        while (it.hasNext()) {
            it.next().a(null, null);
        }
    }

    public void g(c1 c1Var) {
        f1 f1Var;
        b1 b1VarA = c1Var.a();
        e eVar = this.f7242b.get(b1VarA);
        c cVar = c.NO_ACTION_REQUIRED;
        if (eVar == null) {
            return;
        }
        eVar.f7261a.remove(c1Var);
        if (eVar.f7261a.isEmpty()) {
            cVar = c1Var.b() ? c.TERMINATE_LOCAL_LISTEN_AND_REQUIRE_WATCH_DISCONNECTION : c.TERMINATE_LOCAL_LISTEN_ONLY;
        } else if (!eVar.f() && c1Var.b()) {
            cVar = c.REQUIRE_WATCH_DISCONNECTION_ONLY;
        }
        int i10 = a.f7246b[cVar.ordinal()];
        boolean z10 = true;
        if (i10 == 1) {
            this.f7242b.remove(b1VarA);
            f1Var = this.f7241a;
        } else if (i10 != 2) {
            if (i10 != 3) {
                return;
            }
            this.f7241a.A(b1VarA);
            return;
        } else {
            this.f7242b.remove(b1VarA);
            f1Var = this.f7241a;
            z10 = false;
        }
        f1Var.z(b1VarA, z10);
    }

    public void h(b8.r<Void> rVar) {
        this.f7243c.remove(rVar);
    }
}
