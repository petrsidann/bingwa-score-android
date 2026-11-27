package k8;

import java.util.Locale;
import vb.l1;

/* JADX INFO: loaded from: classes.dex */
public class l0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l8.g.b f11733c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l8.g f11735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f11736f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e8.z0 f11731a = e8.z0.UNKNOWN;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11734d = true;

    public interface a {
        void a(e8.z0 z0Var);
    }

    public l0(l8.g gVar, a aVar) {
        this.f11735e = gVar;
        this.f11736f = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        this.f11733c = null;
        l8.b.d(this.f11731a == e8.z0.UNKNOWN, "Timer should be canceled if we transitioned to a different state.", new Object[0]);
        g(String.format(Locale.ENGLISH, "Backend didn't respond within %d seconds\n", 10));
        h(e8.z0.OFFLINE);
    }

    public final void b() {
        l8.g.b bVar = this.f11733c;
        if (bVar != null) {
            bVar.c();
            this.f11733c = null;
        }
    }

    public e8.z0 c() {
        return this.f11731a;
    }

    public void d(l1 l1Var) {
        if (this.f11731a == e8.z0.ONLINE) {
            h(e8.z0.UNKNOWN);
            l8.b.d(this.f11732b == 0, "watchStreamFailures must be 0", new Object[0]);
            l8.b.d(this.f11733c == null, "onlineStateTimer must be null", new Object[0]);
            return;
        }
        int i10 = this.f11732b + 1;
        this.f11732b = i10;
        if (i10 >= 1) {
            b();
            g(String.format(Locale.ENGLISH, "Connection failed %d times. Most recent error: %s", 1, l1Var));
            h(e8.z0.OFFLINE);
        }
    }

    public void e() {
        if (this.f11732b == 0) {
            h(e8.z0.UNKNOWN);
            l8.b.d(this.f11733c == null, "onlineStateTimer shouldn't be started yet", new Object[0]);
            this.f11733c = this.f11735e.k(l8.g.d.ONLINE_STATE_TIMEOUT, 10000L, new Runnable() { // from class: k8.k0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11725a.f();
                }
            });
        }
    }

    public final void g(String str) {
        String str2 = String.format("Could not reach Cloud Firestore backend. %s\nThis typically indicates that your device does not have a healthy Internet connection at the moment. The client will operate in offline mode until it is able to successfully connect to the backend.", str);
        Object[] objArr = new Object[1];
        if (!this.f11734d) {
            objArr[0] = str2;
            l8.v.a("OnlineStateTracker", "%s", objArr);
        } else {
            objArr[0] = str2;
            l8.v.e("OnlineStateTracker", "%s", objArr);
            this.f11734d = false;
        }
    }

    public final void h(e8.z0 z0Var) {
        if (z0Var != this.f11731a) {
            this.f11731a = z0Var;
            this.f11736f.a(z0Var);
        }
    }

    public void i(e8.z0 z0Var) {
        b();
        this.f11732b = 0;
        if (z0Var == e8.z0.ONLINE) {
            this.f11734d = false;
        }
        h(z0Var);
    }
}
