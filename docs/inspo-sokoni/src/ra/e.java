package ra;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.window.BackEvent;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e implements ra.b<Activity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f15213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public io.flutter.embedding.engine.a f15214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q f15215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public io.flutter.plugin.platform.g f15216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewTreeObserver.OnPreDrawListener f15217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f15219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f15220h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f15221i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f15222j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public io.flutter.embedding.engine.b f15223k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final io.flutter.embedding.engine.renderer.d f15224l;

    public class a implements io.flutter.embedding.engine.renderer.d {
        public a() {
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void c() {
            e.this.f15213a.c();
            e.this.f15219g = false;
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void e() {
            e.this.f15213a.e();
            e.this.f15219g = true;
            e.this.f15220h = true;
        }
    }

    public class b implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f15226a;

        public b(q qVar) {
            this.f15226a = qVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (e.this.f15219g && e.this.f15217e != null) {
                this.f15226a.getViewTreeObserver().removeOnPreDrawListener(this);
                e.this.f15217e = null;
            }
            return e.this.f15219g;
        }
    }

    public interface c extends io.flutter.plugin.platform.g.d {
        String A();

        String B();

        sa.j C();

        c0 D();

        d0 E();

        androidx.lifecycle.g a();

        void c();

        void d();

        void e();

        Activity g();

        Context getContext();

        List<String> i();

        String j();

        boolean k();

        String l();

        io.flutter.plugin.platform.g m(Activity activity, io.flutter.embedding.engine.a aVar);

        boolean n();

        boolean o();

        void p(k kVar);

        io.flutter.embedding.engine.a q(Context context);

        void r(io.flutter.embedding.engine.a aVar);

        void s(l lVar);

        String t();

        String u();

        boolean w();

        boolean x();

        boolean y();

        void z(io.flutter.embedding.engine.a aVar);
    }

    public e(c cVar) {
        this(cVar, null);
    }

    public e(c cVar, io.flutter.embedding.engine.b bVar) {
        this.f15224l = new a();
        this.f15213a = cVar;
        this.f15220h = false;
        this.f15223k = bVar;
    }

    public void A(int i10, String[] strArr, int[] iArr) {
        l();
        if (this.f15214b == null) {
            qa.b.g("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        qa.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i10 + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
        this.f15214b.i().onRequestPermissionsResult(i10, strArr, iArr);
    }

    public void B(Bundle bundle) {
        Bundle bundle2;
        byte[] byteArray;
        qa.b.f("FlutterActivityAndFragmentDelegate", "onRestoreInstanceState. Giving framework and plugins an opportunity to restore state.");
        l();
        if (bundle != null) {
            bundle2 = bundle.getBundle("plugins");
            byteArray = bundle.getByteArray("framework");
        } else {
            bundle2 = null;
            byteArray = null;
        }
        if (this.f15213a.k()) {
            this.f15214b.u().j(byteArray);
        }
        if (this.f15213a.w()) {
            this.f15214b.i().b(bundle2);
        }
    }

    public void C() {
        io.flutter.embedding.engine.a aVar;
        qa.b.f("FlutterActivityAndFragmentDelegate", "onResume()");
        l();
        if (!this.f15213a.y() || (aVar = this.f15214b) == null) {
            return;
        }
        aVar.l().e();
    }

    public void D(Bundle bundle) {
        qa.b.f("FlutterActivityAndFragmentDelegate", "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
        l();
        if (this.f15213a.k()) {
            bundle.putByteArray("framework", this.f15214b.u().h());
        }
        if (this.f15213a.w()) {
            Bundle bundle2 = new Bundle();
            this.f15214b.i().c(bundle2);
            bundle.putBundle("plugins", bundle2);
        }
    }

    public void E() {
        qa.b.f("FlutterActivityAndFragmentDelegate", "onStart()");
        l();
        k();
        Integer num = this.f15222j;
        if (num != null) {
            this.f15215c.setVisibility(num.intValue());
        }
    }

    public void F() {
        io.flutter.embedding.engine.a aVar;
        qa.b.f("FlutterActivityAndFragmentDelegate", "onStop()");
        l();
        if (this.f15213a.y() && (aVar = this.f15214b) != null) {
            aVar.l().d();
        }
        this.f15222j = Integer.valueOf(this.f15215c.getVisibility());
        this.f15215c.setVisibility(8);
        io.flutter.embedding.engine.a aVar2 = this.f15214b;
        if (aVar2 != null) {
            aVar2.t().p(40);
        }
    }

    public void G(int i10) {
        l();
        io.flutter.embedding.engine.a aVar = this.f15214b;
        if (aVar != null) {
            if (this.f15220h && i10 >= 10) {
                aVar.k().n();
                this.f15214b.y().a();
            }
            this.f15214b.t().p(i10);
            this.f15214b.q().o0(i10);
        }
    }

    public void H() {
        l();
        if (this.f15214b == null) {
            qa.b.g("FlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
        } else {
            qa.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.");
            this.f15214b.i().d();
        }
    }

    public void I(boolean z10) {
        io.flutter.embedding.engine.a aVar;
        l();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Received onWindowFocusChanged: ");
        sb2.append(z10 ? "true" : "false");
        qa.b.f("FlutterActivityAndFragmentDelegate", sb2.toString());
        if (!this.f15213a.y() || (aVar = this.f15214b) == null) {
            return;
        }
        if (z10) {
            aVar.l().a();
        } else {
            aVar.l().f();
        }
    }

    public void J() {
        this.f15213a = null;
        this.f15214b = null;
        this.f15215c = null;
        this.f15216d = null;
    }

    public void K() {
        io.flutter.embedding.engine.a aVarA;
        qa.b.f("FlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.");
        String strJ = this.f15213a.j();
        if (strJ != null) {
            io.flutter.embedding.engine.a aVarA2 = sa.a.b().a(strJ);
            this.f15214b = aVarA2;
            this.f15218f = true;
            if (aVarA2 != null) {
                return;
            }
            throw new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + strJ + "'");
        }
        c cVar = this.f15213a;
        io.flutter.embedding.engine.a aVarQ = cVar.q(cVar.getContext());
        this.f15214b = aVarQ;
        if (aVarQ != null) {
            this.f15218f = true;
            return;
        }
        String strT = this.f15213a.t();
        if (strT != null) {
            io.flutter.embedding.engine.b bVarA = sa.c.b().a(strT);
            if (bVarA == null) {
                throw new IllegalStateException("The requested cached FlutterEngineGroup did not exist in the FlutterEngineGroupCache: '" + strT + "'");
            }
            aVarA = bVarA.a(g(new io.flutter.embedding.engine.b.C0180b(this.f15213a.getContext())));
        } else {
            qa.b.f("FlutterActivityAndFragmentDelegate", "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
            io.flutter.embedding.engine.b bVar = this.f15223k;
            if (bVar == null) {
                bVar = new io.flutter.embedding.engine.b(this.f15213a.getContext(), this.f15213a.C().b());
            }
            aVarA = bVar.a(g(new io.flutter.embedding.engine.b.C0180b(this.f15213a.getContext()).h(false).l(this.f15213a.k())));
        }
        this.f15214b = aVarA;
        this.f15218f = false;
    }

    public void L(BackEvent backEvent) {
        l();
        if (this.f15214b == null) {
            qa.b.g("FlutterActivityAndFragmentDelegate", "Invoked startBackGesture() before FlutterFragment was attached to an Activity.");
        } else {
            qa.b.f("FlutterActivityAndFragmentDelegate", "Forwarding startBackGesture() to FlutterEngine.");
            this.f15214b.j().d(backEvent);
        }
    }

    public void M(BackEvent backEvent) {
        l();
        if (this.f15214b == null) {
            qa.b.g("FlutterActivityAndFragmentDelegate", "Invoked updateBackGestureProgress() before FlutterFragment was attached to an Activity.");
        } else {
            qa.b.f("FlutterActivityAndFragmentDelegate", "Forwarding updateBackGestureProgress() to FlutterEngine.");
            this.f15214b.j().e(backEvent);
        }
    }

    public void N() {
        io.flutter.plugin.platform.g gVar = this.f15216d;
        if (gVar != null) {
            gVar.E();
        }
    }

    @Override // ra.b
    public void d() {
        if (!this.f15213a.x()) {
            this.f15213a.d();
            return;
        }
        throw new AssertionError("The internal FlutterEngine created by " + this.f15213a + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
    }

    public final io.flutter.embedding.engine.b.C0180b g(io.flutter.embedding.engine.b.C0180b c0180b) {
        String strB = this.f15213a.B();
        if (strB == null || strB.isEmpty()) {
            strB = qa.a.e().c().j();
        }
        ta.a.c cVar = new ta.a.c(strB, this.f15213a.l());
        String strU = this.f15213a.u();
        if (strU == null && (strU = q(this.f15213a.g().getIntent())) == null) {
            strU = "/";
        }
        return c0180b.i(cVar).k(strU).j(this.f15213a.i());
    }

    public void h() {
        l();
        if (this.f15214b == null) {
            qa.b.g("FlutterActivityAndFragmentDelegate", "Invoked cancelBackGesture() before FlutterFragment was attached to an Activity.");
        } else {
            qa.b.f("FlutterActivityAndFragmentDelegate", "Forwarding cancelBackGesture() to FlutterEngine.");
            this.f15214b.j().b();
        }
    }

    public void i() {
        l();
        if (this.f15214b == null) {
            qa.b.g("FlutterActivityAndFragmentDelegate", "Invoked commitBackGesture() before FlutterFragment was attached to an Activity.");
        } else {
            qa.b.f("FlutterActivityAndFragmentDelegate", "Forwarding commitBackGesture() to FlutterEngine.");
            this.f15214b.j().c();
        }
    }

    public final void j(q qVar) {
        if (this.f15213a.D() != c0.surface) {
            throw new IllegalArgumentException("Cannot delay the first Android view draw when the render mode is not set to `RenderMode.surface`.");
        }
        if (this.f15217e != null) {
            qVar.getViewTreeObserver().removeOnPreDrawListener(this.f15217e);
        }
        this.f15217e = new b(qVar);
        qVar.getViewTreeObserver().addOnPreDrawListener(this.f15217e);
    }

    public final void k() {
        String str;
        if (this.f15213a.j() == null && !this.f15214b.k().m()) {
            String strU = this.f15213a.u();
            if (strU == null && (strU = q(this.f15213a.g().getIntent())) == null) {
                strU = "/";
            }
            String strA = this.f15213a.A();
            if (("Executing Dart entrypoint: " + this.f15213a.l() + ", library uri: " + strA) == null) {
                str = "\"\"";
            } else {
                str = strA + ", and sending initial route: " + strU;
            }
            qa.b.f("FlutterActivityAndFragmentDelegate", str);
            this.f15214b.o().c(strU);
            String strB = this.f15213a.B();
            if (strB == null || strB.isEmpty()) {
                strB = qa.a.e().c().j();
            }
            this.f15214b.k().k(strA == null ? new ta.a.c(strB, this.f15213a.l()) : new ta.a.c(strB, strA, this.f15213a.l()), this.f15213a.i());
        }
    }

    public final void l() {
        if (this.f15213a == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }

    @Override // ra.b
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public Activity e() {
        Activity activityG = this.f15213a.g();
        if (activityG != null) {
            return activityG;
        }
        throw new AssertionError("FlutterActivityAndFragmentDelegate's getAppComponent should only be queried after onAttach, when the host's activity should always be non-null");
    }

    public io.flutter.embedding.engine.a n() {
        return this.f15214b;
    }

    public boolean o() {
        return this.f15221i;
    }

    public boolean p() {
        return this.f15218f;
    }

    public final String q(Intent intent) {
        Uri data;
        if (!this.f15213a.n() || (data = intent.getData()) == null) {
            return null;
        }
        return data.toString();
    }

    public void r(int i10, int i11, Intent intent) {
        l();
        if (this.f15214b == null) {
            qa.b.g("FlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        qa.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i10 + "\nresultCode: " + i11 + "\ndata: " + intent);
        this.f15214b.i().onActivityResult(i10, i11, intent);
    }

    public void s(Context context) {
        l();
        if (this.f15214b == null) {
            K();
        }
        if (this.f15213a.w()) {
            qa.b.f("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to the Activity that owns this delegate.");
            this.f15214b.i().l(this, this.f15213a.a());
        }
        c cVar = this.f15213a;
        this.f15216d = cVar.m(cVar.g(), this.f15214b);
        this.f15213a.r(this.f15214b);
        this.f15221i = true;
    }

    public void t() {
        l();
        if (this.f15214b == null) {
            qa.b.g("FlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
        } else {
            qa.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onBackPressed() to FlutterEngine.");
            this.f15214b.o().a();
        }
    }

    public View u(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, int i10, boolean z10) {
        q qVar;
        qa.b.f("FlutterActivityAndFragmentDelegate", "Creating FlutterView.");
        l();
        if (this.f15213a.D() == c0.surface) {
            k kVar = new k(this.f15213a.getContext(), this.f15213a.E() == d0.transparent);
            this.f15213a.p(kVar);
            qVar = new q(this.f15213a.getContext(), kVar);
        } else {
            l lVar = new l(this.f15213a.getContext());
            lVar.setOpaque(this.f15213a.E() == d0.opaque);
            this.f15213a.s(lVar);
            qVar = new q(this.f15213a.getContext(), lVar);
        }
        this.f15215c = qVar;
        this.f15215c.l(this.f15224l);
        if (this.f15213a.o()) {
            qa.b.f("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.");
            this.f15215c.n(this.f15214b);
        }
        this.f15215c.setId(i10);
        if (z10) {
            j(this.f15215c);
        }
        return this.f15215c;
    }

    public void v() {
        qa.b.f("FlutterActivityAndFragmentDelegate", "onDestroyView()");
        l();
        if (this.f15217e != null) {
            this.f15215c.getViewTreeObserver().removeOnPreDrawListener(this.f15217e);
            this.f15217e = null;
        }
        q qVar = this.f15215c;
        if (qVar != null) {
            qVar.s();
            this.f15215c.y(this.f15224l);
        }
    }

    public void w() {
        io.flutter.embedding.engine.a aVar;
        if (this.f15221i) {
            qa.b.f("FlutterActivityAndFragmentDelegate", "onDetach()");
            l();
            this.f15213a.z(this.f15214b);
            if (this.f15213a.w()) {
                qa.b.f("FlutterActivityAndFragmentDelegate", "Detaching FlutterEngine from the Activity that owns this Fragment.");
                if (this.f15213a.g().isChangingConfigurations()) {
                    this.f15214b.i().j();
                } else {
                    this.f15214b.i().h();
                }
            }
            io.flutter.plugin.platform.g gVar = this.f15216d;
            if (gVar != null) {
                gVar.q();
                this.f15216d = null;
            }
            if (this.f15213a.y() && (aVar = this.f15214b) != null) {
                aVar.l().b();
            }
            if (this.f15213a.x()) {
                this.f15214b.g();
                if (this.f15213a.j() != null) {
                    sa.a.b().d(this.f15213a.j());
                }
                this.f15214b = null;
            }
            this.f15221i = false;
        }
    }

    public void x(Intent intent) {
        l();
        if (this.f15214b == null) {
            qa.b.g("FlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        qa.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine and sending pushRouteInformation message.");
        this.f15214b.i().onNewIntent(intent);
        String strQ = q(intent);
        if (strQ == null || strQ.isEmpty()) {
            return;
        }
        this.f15214b.o().b(strQ);
    }

    public void y() {
        io.flutter.embedding.engine.a aVar;
        qa.b.f("FlutterActivityAndFragmentDelegate", "onPause()");
        l();
        if (!this.f15213a.y() || (aVar = this.f15214b) == null) {
            return;
        }
        aVar.l().c();
    }

    public void z() {
        qa.b.f("FlutterActivityAndFragmentDelegate", "onPostResume()");
        l();
        if (this.f15214b == null) {
            qa.b.g("FlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.");
        } else {
            N();
            this.f15214b.q().n0();
        }
    }
}
