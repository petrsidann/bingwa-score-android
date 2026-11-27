package s2;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class m implements xa.a, ya.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f15423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public fb.j f15424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ya.c f15425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f15426d;

    public final void a() {
        ya.c cVar = this.f15425c;
        if (cVar != null) {
            cVar.d(this.f15423a);
            this.f15425c.f(this.f15423a);
        }
    }

    public final void b() {
        ya.c cVar = this.f15425c;
        if (cVar != null) {
            cVar.b(this.f15423a);
            this.f15425c.h(this.f15423a);
        }
    }

    public final void c(Context context, fb.b bVar) {
        this.f15424b = new fb.j(bVar, "flutter.baseflow.com/permissions/methods");
        l lVar = new l(context, new a(), this.f15423a, new t());
        this.f15426d = lVar;
        this.f15424b.e(lVar);
    }

    public final void d(Activity activity) {
        p pVar = this.f15423a;
        if (pVar != null) {
            pVar.h(activity);
        }
    }

    public final void e() {
        this.f15424b.e(null);
        this.f15424b = null;
        this.f15426d = null;
    }

    public final void f() {
        p pVar = this.f15423a;
        if (pVar != null) {
            pVar.h(null);
        }
    }

    @Override // ya.a
    public void onAttachedToActivity(ya.c cVar) {
        d(cVar.g());
        this.f15425c = cVar;
        b();
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
        this.f15423a = new p(bVar.a());
        c(bVar.a(), bVar.b());
    }

    @Override // ya.a
    public void onDetachedFromActivity() {
        f();
        a();
        this.f15425c = null;
    }

    @Override // ya.a
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
        e();
    }

    @Override // ya.a
    public void onReattachedToActivityForConfigChanges(ya.c cVar) {
        onAttachedToActivity(cVar);
    }
}
