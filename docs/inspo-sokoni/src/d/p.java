package d;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f6166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o0.a<Boolean> f6167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final mc.g<o> f6168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o f6169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OnBackInvokedCallback f6170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OnBackInvokedDispatcher f6171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6172g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6173h;

    public static final class a extends kotlin.jvm.internal.l implements xc.l<d.b, lc.q> {
        public a() {
            super(1);
        }

        public final void a(d.b backEvent) {
            kotlin.jvm.internal.k.e(backEvent, "backEvent");
            p.this.m(backEvent);
        }

        @Override // xc.l
        public /* bridge */ /* synthetic */ lc.q invoke(d.b bVar) {
            a(bVar);
            return lc.q.f12711a;
        }
    }

    public static final class b extends kotlin.jvm.internal.l implements xc.l<d.b, lc.q> {
        public b() {
            super(1);
        }

        public final void a(d.b backEvent) {
            kotlin.jvm.internal.k.e(backEvent, "backEvent");
            p.this.l(backEvent);
        }

        @Override // xc.l
        public /* bridge */ /* synthetic */ lc.q invoke(d.b bVar) {
            a(bVar);
            return lc.q.f12711a;
        }
    }

    public static final class c extends kotlin.jvm.internal.l implements xc.a<lc.q> {
        public c() {
            super(0);
        }

        public final void a() {
            p.this.k();
        }

        @Override // xc.a
        public /* bridge */ /* synthetic */ lc.q invoke() {
            a();
            return lc.q.f12711a;
        }
    }

    public static final class d extends kotlin.jvm.internal.l implements xc.a<lc.q> {
        public d() {
            super(0);
        }

        public final void a() {
            p.this.j();
        }

        @Override // xc.a
        public /* bridge */ /* synthetic */ lc.q invoke() {
            a();
            return lc.q.f12711a;
        }
    }

    public static final class e extends kotlin.jvm.internal.l implements xc.a<lc.q> {
        public e() {
            super(0);
        }

        public final void a() {
            p.this.k();
        }

        @Override // xc.a
        public /* bridge */ /* synthetic */ lc.q invoke() {
            a();
            return lc.q.f12711a;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f6179a = new f();

        public static final void c(xc.a onBackInvoked) {
            kotlin.jvm.internal.k.e(onBackInvoked, "$onBackInvoked");
            onBackInvoked.invoke();
        }

        public final OnBackInvokedCallback b(final xc.a<lc.q> onBackInvoked) {
            kotlin.jvm.internal.k.e(onBackInvoked, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: d.q
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    p.f.c(onBackInvoked);
                }
            };
        }

        public final void d(Object dispatcher, int i10, Object callback) {
            kotlin.jvm.internal.k.e(dispatcher, "dispatcher");
            kotlin.jvm.internal.k.e(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(i10, (OnBackInvokedCallback) callback);
        }

        public final void e(Object dispatcher, Object callback) {
            kotlin.jvm.internal.k.e(dispatcher, "dispatcher");
            kotlin.jvm.internal.k.e(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f6180a = new g();

        public static final class a implements OnBackAnimationCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ xc.l<d.b, lc.q> f6181a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ xc.l<d.b, lc.q> f6182b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ xc.a<lc.q> f6183c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ xc.a<lc.q> f6184d;

            /* JADX WARN: Multi-variable type inference failed */
            public a(xc.l<? super d.b, lc.q> lVar, xc.l<? super d.b, lc.q> lVar2, xc.a<lc.q> aVar, xc.a<lc.q> aVar2) {
                this.f6181a = lVar;
                this.f6182b = lVar2;
                this.f6183c = aVar;
                this.f6184d = aVar2;
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackCancelled() {
                this.f6184d.invoke();
            }

            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                this.f6183c.invoke();
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackProgressed(BackEvent backEvent) {
                kotlin.jvm.internal.k.e(backEvent, "backEvent");
                this.f6182b.invoke(new d.b(backEvent));
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackStarted(BackEvent backEvent) {
                kotlin.jvm.internal.k.e(backEvent, "backEvent");
                this.f6181a.invoke(new d.b(backEvent));
            }
        }

        public final OnBackInvokedCallback a(xc.l<? super d.b, lc.q> onBackStarted, xc.l<? super d.b, lc.q> onBackProgressed, xc.a<lc.q> onBackInvoked, xc.a<lc.q> onBackCancelled) {
            kotlin.jvm.internal.k.e(onBackStarted, "onBackStarted");
            kotlin.jvm.internal.k.e(onBackProgressed, "onBackProgressed");
            kotlin.jvm.internal.k.e(onBackInvoked, "onBackInvoked");
            kotlin.jvm.internal.k.e(onBackCancelled, "onBackCancelled");
            return new a(onBackStarted, onBackProgressed, onBackInvoked, onBackCancelled);
        }
    }

    public final class h implements androidx.lifecycle.i, d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.lifecycle.g f6185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o f6186b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d.c f6187c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p f6188d;

        public h(p pVar, androidx.lifecycle.g lifecycle, o onBackPressedCallback) {
            kotlin.jvm.internal.k.e(lifecycle, "lifecycle");
            kotlin.jvm.internal.k.e(onBackPressedCallback, "onBackPressedCallback");
            this.f6188d = pVar;
            this.f6185a = lifecycle;
            this.f6186b = onBackPressedCallback;
            lifecycle.a(this);
        }

        @Override // androidx.lifecycle.i
        public void c(androidx.lifecycle.k source, androidx.lifecycle.g.a event) {
            kotlin.jvm.internal.k.e(source, "source");
            kotlin.jvm.internal.k.e(event, "event");
            if (event == androidx.lifecycle.g.a.ON_START) {
                this.f6187c = this.f6188d.i(this.f6186b);
                return;
            }
            if (event != androidx.lifecycle.g.a.ON_STOP) {
                if (event == androidx.lifecycle.g.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                d.c cVar = this.f6187c;
                if (cVar != null) {
                    cVar.cancel();
                }
            }
        }

        @Override // d.c
        public void cancel() {
            this.f6185a.c(this);
            this.f6186b.i(this);
            d.c cVar = this.f6187c;
            if (cVar != null) {
                cVar.cancel();
            }
            this.f6187c = null;
        }
    }

    public final class i implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o f6189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f6190b;

        public i(p pVar, o onBackPressedCallback) {
            kotlin.jvm.internal.k.e(onBackPressedCallback, "onBackPressedCallback");
            this.f6190b = pVar;
            this.f6189a = onBackPressedCallback;
        }

        @Override // d.c
        public void cancel() {
            this.f6190b.f6168c.remove(this.f6189a);
            if (kotlin.jvm.internal.k.a(this.f6190b.f6169d, this.f6189a)) {
                this.f6189a.c();
                this.f6190b.f6169d = null;
            }
            this.f6189a.i(this);
            xc.a<lc.q> aVarB = this.f6189a.b();
            if (aVarB != null) {
                aVarB.invoke();
            }
            this.f6189a.k(null);
        }
    }

    public /* synthetic */ class j extends kotlin.jvm.internal.j implements xc.a<lc.q> {
        public j(Object obj) {
            super(0, obj, p.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        public final void d() {
            ((p) this.receiver).p();
        }

        @Override // xc.a
        public /* bridge */ /* synthetic */ lc.q invoke() {
            d();
            return lc.q.f12711a;
        }
    }

    public /* synthetic */ class k extends kotlin.jvm.internal.j implements xc.a<lc.q> {
        public k(Object obj) {
            super(0, obj, p.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        public final void d() {
            ((p) this.receiver).p();
        }

        @Override // xc.a
        public /* bridge */ /* synthetic */ lc.q invoke() {
            d();
            return lc.q.f12711a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public p(Runnable runnable) {
        this(runnable, null);
    }

    public /* synthetic */ p(Runnable runnable, int i10, kotlin.jvm.internal.g gVar) {
        this((i10 & 1) != 0 ? null : runnable);
    }

    public p(Runnable runnable, o0.a<Boolean> aVar) {
        this.f6166a = runnable;
        this.f6167b = aVar;
        this.f6168c = new mc.g<>();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33) {
            this.f6170e = i10 >= 34 ? g.f6180a.a(new a(), new b(), new c(), new d()) : f.f6179a.b(new e());
        }
    }

    public final void h(androidx.lifecycle.k owner, o onBackPressedCallback) {
        kotlin.jvm.internal.k.e(owner, "owner");
        kotlin.jvm.internal.k.e(onBackPressedCallback, "onBackPressedCallback");
        androidx.lifecycle.g gVarA = owner.a();
        if (gVarA.b() == androidx.lifecycle.g.b.DESTROYED) {
            return;
        }
        onBackPressedCallback.a(new h(this, gVarA, onBackPressedCallback));
        p();
        onBackPressedCallback.k(new j(this));
    }

    public final d.c i(o onBackPressedCallback) {
        kotlin.jvm.internal.k.e(onBackPressedCallback, "onBackPressedCallback");
        this.f6168c.add(onBackPressedCallback);
        i iVar = new i(this, onBackPressedCallback);
        onBackPressedCallback.a(iVar);
        p();
        onBackPressedCallback.k(new k(this));
        return iVar;
    }

    public final void j() {
        o oVarPrevious;
        o oVar = this.f6169d;
        if (oVar == null) {
            mc.g<o> gVar = this.f6168c;
            ListIterator<o> listIterator = gVar.listIterator(gVar.size());
            do {
                if (!listIterator.hasPrevious()) {
                    oVarPrevious = null;
                    break;
                }
                oVarPrevious = listIterator.previous();
            } while (!oVarPrevious.g());
            oVar = oVarPrevious;
        }
        this.f6169d = null;
        if (oVar != null) {
            oVar.c();
        }
    }

    public final void k() {
        o oVarPrevious;
        o oVar = this.f6169d;
        if (oVar == null) {
            mc.g<o> gVar = this.f6168c;
            ListIterator<o> listIterator = gVar.listIterator(gVar.size());
            do {
                if (!listIterator.hasPrevious()) {
                    oVarPrevious = null;
                    break;
                }
                oVarPrevious = listIterator.previous();
            } while (!oVarPrevious.g());
            oVar = oVarPrevious;
        }
        this.f6169d = null;
        if (oVar != null) {
            oVar.d();
            return;
        }
        Runnable runnable = this.f6166a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void l(d.b bVar) {
        o oVarPrevious;
        o oVar = this.f6169d;
        if (oVar == null) {
            mc.g<o> gVar = this.f6168c;
            ListIterator<o> listIterator = gVar.listIterator(gVar.size());
            do {
                if (!listIterator.hasPrevious()) {
                    oVarPrevious = null;
                    break;
                }
                oVarPrevious = listIterator.previous();
            } while (!oVarPrevious.g());
            oVar = oVarPrevious;
        }
        if (oVar != null) {
            oVar.e(bVar);
        }
    }

    public final void m(d.b bVar) {
        o oVarPrevious;
        mc.g<o> gVar = this.f6168c;
        ListIterator<o> listIterator = gVar.listIterator(gVar.size());
        do {
            if (!listIterator.hasPrevious()) {
                oVarPrevious = null;
                break;
            }
            oVarPrevious = listIterator.previous();
        } while (!oVarPrevious.g());
        o oVar = oVarPrevious;
        this.f6169d = oVar;
        if (oVar != null) {
            oVar.f(bVar);
        }
    }

    public final void n(OnBackInvokedDispatcher invoker) {
        kotlin.jvm.internal.k.e(invoker, "invoker");
        this.f6171f = invoker;
        o(this.f6173h);
    }

    public final void o(boolean z10) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f6171f;
        OnBackInvokedCallback onBackInvokedCallback = this.f6170e;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (z10 && !this.f6172g) {
            f.f6179a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f6172g = true;
        } else {
            if (z10 || !this.f6172g) {
                return;
            }
            f.f6179a.e(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f6172g = false;
        }
    }

    public final void p() {
        boolean z10 = this.f6173h;
        mc.g<o> gVar = this.f6168c;
        boolean z11 = false;
        if (!(gVar instanceof Collection) || !gVar.isEmpty()) {
            Iterator<o> it = gVar.iterator();
            while (it.hasNext()) {
                if (it.next().g()) {
                    z11 = true;
                    break;
                }
            }
        }
        this.f6173h = z11;
        if (z11 != z10) {
            o0.a<Boolean> aVar = this.f6167b;
            if (aVar != null) {
                aVar.accept(Boolean.valueOf(z11));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                o(z11);
            }
        }
    }
}
