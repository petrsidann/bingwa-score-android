package i1;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class t0 implements androidx.lifecycle.f, b2.f, androidx.lifecycle.j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f10433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.lifecycle.i0 f10434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f10435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.lifecycle.l f10436d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b2.e f10437e = null;

    public t0(p pVar, androidx.lifecycle.i0 i0Var, Runnable runnable) {
        this.f10433a = pVar;
        this.f10434b = i0Var;
        this.f10435c = runnable;
    }

    @Override // androidx.lifecycle.k
    public androidx.lifecycle.g a() {
        c();
        return this.f10436d;
    }

    public void b(androidx.lifecycle.g.a aVar) {
        this.f10436d.h(aVar);
    }

    public void c() {
        if (this.f10436d == null) {
            this.f10436d = new androidx.lifecycle.l(this);
            b2.e eVarA = b2.e.a(this);
            this.f10437e = eVarA;
            eVarA.c();
            this.f10435c.run();
        }
    }

    public boolean d() {
        return this.f10436d != null;
    }

    public void e(Bundle bundle) {
        this.f10437e.d(bundle);
    }

    public void f(Bundle bundle) {
        this.f10437e.e(bundle);
    }

    public void g(androidx.lifecycle.g.b bVar) {
        this.f10436d.n(bVar);
    }

    @Override // androidx.lifecycle.f
    public n1.a j() {
        Application application;
        Context applicationContext = this.f10433a.q1().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        n1.b bVar = new n1.b();
        if (application != null) {
            bVar.b(androidx.lifecycle.g0.a.f2182e, application);
        }
        bVar.b(androidx.lifecycle.b0.f2153a, this.f10433a);
        bVar.b(androidx.lifecycle.b0.f2154b, this);
        if (this.f10433a.r() != null) {
            bVar.b(androidx.lifecycle.b0.f2155c, this.f10433a.r());
        }
        return bVar;
    }

    @Override // androidx.lifecycle.j0
    public androidx.lifecycle.i0 m() {
        c();
        return this.f10434b;
    }

    @Override // b2.f
    public b2.d v() {
        c();
        return this.f10437e.b();
    }
}
