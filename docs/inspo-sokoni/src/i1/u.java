package i1;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import e0.g1;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class u extends d.h implements e0.b.e {
    public boolean B;
    public boolean C;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final x f10438z = x.b(new a());
    public final androidx.lifecycle.l A = new androidx.lifecycle.l(this);
    public boolean D = true;

    public class a extends z<u> implements f0.f, f0.g, e0.p0, e0.q0, androidx.lifecycle.j0, d.r, f.e, b2.f, l0, p0.v {
        public a() {
            super(u.this);
        }

        @Override // i1.z
        public void B() {
            C();
        }

        public void C() {
            u.this.I();
        }

        @Override // i1.z
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public u y() {
            return u.this;
        }

        @Override // androidx.lifecycle.k
        public androidx.lifecycle.g a() {
            return u.this.A;
        }

        @Override // i1.l0
        public void b(h0 h0Var, p pVar) {
            u.this.b0(pVar);
        }

        @Override // e0.q0
        public void c(o0.a<g1> aVar) {
            u.this.c(aVar);
        }

        @Override // f0.f
        public void d(o0.a<Configuration> aVar) {
            u.this.d(aVar);
        }

        @Override // e0.p0
        public void e(o0.a<e0.n> aVar) {
            u.this.e(aVar);
        }

        @Override // e0.p0
        public void g(o0.a<e0.n> aVar) {
            u.this.g(aVar);
        }

        @Override // d.r
        public d.p h() {
            return u.this.h();
        }

        @Override // f0.f
        public void i(o0.a<Configuration> aVar) {
            u.this.i(aVar);
        }

        @Override // i1.z, i1.w
        public View j(int i10) {
            return u.this.findViewById(i10);
        }

        @Override // f.e
        public f.d k() {
            return u.this.k();
        }

        @Override // i1.z, i1.w
        public boolean l() {
            Window window = u.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.lifecycle.j0
        public androidx.lifecycle.i0 m() {
            return u.this.m();
        }

        @Override // p0.v
        public void p(p0.y yVar) {
            u.this.p(yVar);
        }

        @Override // p0.v
        public void r(p0.y yVar) {
            u.this.r(yVar);
        }

        @Override // f0.g
        public void s(o0.a<Integer> aVar) {
            u.this.s(aVar);
        }

        @Override // f0.g
        public void t(o0.a<Integer> aVar) {
            u.this.t(aVar);
        }

        @Override // e0.q0
        public void u(o0.a<g1> aVar) {
            u.this.u(aVar);
        }

        @Override // b2.f
        public b2.d v() {
            return u.this.v();
        }

        @Override // i1.z
        public void x(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            u.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // i1.z
        public LayoutInflater z() {
            return u.this.getLayoutInflater().cloneInContext(u.this);
        }
    }

    public u() {
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle V() {
        Z();
        this.A.h(androidx.lifecycle.g.a.ON_STOP);
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(Configuration configuration) {
        this.f10438z.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(Intent intent) {
        this.f10438z.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(Context context) {
        this.f10438z.a(null);
    }

    public static boolean a0(h0 h0Var, androidx.lifecycle.g.b bVar) {
        boolean zA0 = false;
        for (p pVar : h0Var.u0()) {
            if (pVar != null) {
                if (pVar.C() != null) {
                    zA0 |= a0(pVar.s(), bVar);
                }
                t0 t0Var = pVar.f10319a0;
                if (t0Var != null && t0Var.a().b().h(androidx.lifecycle.g.b.STARTED)) {
                    pVar.f10319a0.g(bVar);
                    zA0 = true;
                }
                if (pVar.Z.b().h(androidx.lifecycle.g.b.STARTED)) {
                    pVar.Z.n(bVar);
                    zA0 = true;
                }
            }
        }
        return zA0;
    }

    public final View R(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f10438z.n(view, str, context, attributeSet);
    }

    public h0 S() {
        return this.f10438z.l();
    }

    @Deprecated
    public o1.a T() {
        return o1.a.b(this);
    }

    public final void U() {
        v().h("android:support:lifecycle", new b2.d.c() { // from class: i1.q
            @Override // b2.d.c
            public final Bundle a() {
                return this.f10404a.V();
            }
        });
        d(new o0.a() { // from class: i1.r
            @Override // o0.a
            public final void accept(Object obj) {
                this.f10408a.W((Configuration) obj);
            }
        });
        E(new o0.a() { // from class: i1.s
            @Override // o0.a
            public final void accept(Object obj) {
                this.f10425a.X((Intent) obj);
            }
        });
        D(new e.b() { // from class: i1.t
            @Override // e.b
            public final void a(Context context) {
                this.f10432a.Y(context);
            }
        });
    }

    public void Z() {
        while (a0(S(), androidx.lifecycle.g.b.CREATED)) {
        }
    }

    @Override // e0.b.e
    @Deprecated
    public final void b(int i10) {
    }

    @Deprecated
    public void b0(p pVar) {
    }

    public void c0() {
        this.A.h(androidx.lifecycle.g.a.ON_RESUME);
        this.f10438z.h();
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (w(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.B);
            printWriter.print(" mResumed=");
            printWriter.print(this.C);
            printWriter.print(" mStopped=");
            printWriter.print(this.D);
            if (getApplication() != null) {
                o1.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
            }
            this.f10438z.l().W(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // d.h, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        this.f10438z.m();
        super.onActivityResult(i10, i11, intent);
    }

    @Override // d.h, e0.k, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.A.h(androidx.lifecycle.g.a.ON_CREATE);
        this.f10438z.e();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewR = R(view, str, context, attributeSet);
        return viewR == null ? super.onCreateView(view, str, context, attributeSet) : viewR;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewR = R(null, str, context, attributeSet);
        return viewR == null ? super.onCreateView(str, context, attributeSet) : viewR;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f10438z.f();
        this.A.h(androidx.lifecycle.g.a.ON_DESTROY);
    }

    @Override // d.h, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 6) {
            return this.f10438z.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.C = false;
        this.f10438z.g();
        this.A.h(androidx.lifecycle.g.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        c0();
    }

    @Override // d.h, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        this.f10438z.m();
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.f10438z.m();
        super.onResume();
        this.C = true;
        this.f10438z.k();
    }

    @Override // android.app.Activity
    public void onStart() {
        this.f10438z.m();
        super.onStart();
        this.D = false;
        if (!this.B) {
            this.B = true;
            this.f10438z.c();
        }
        this.f10438z.k();
        this.A.h(androidx.lifecycle.g.a.ON_START);
        this.f10438z.i();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f10438z.m();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.D = true;
        Z();
        this.f10438z.j();
        this.A.h(androidx.lifecycle.g.a.ON_STOP);
    }
}
