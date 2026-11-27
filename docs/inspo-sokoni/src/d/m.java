package d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f6155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xc.a<lc.q> f6156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f6157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6160f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<xc.a<lc.q>> f6161g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f6162h;

    public m(Executor executor, xc.a<lc.q> reportFullyDrawn) {
        kotlin.jvm.internal.k.e(executor, "executor");
        kotlin.jvm.internal.k.e(reportFullyDrawn, "reportFullyDrawn");
        this.f6155a = executor;
        this.f6156b = reportFullyDrawn;
        this.f6157c = new Object();
        this.f6161g = new ArrayList();
        this.f6162h = new Runnable() { // from class: d.l
            @Override // java.lang.Runnable
            public final void run() {
                m.d(this.f6154a);
            }
        };
    }

    public static final void d(m this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        synchronized (this$0.f6157c) {
            this$0.f6159e = false;
            if (this$0.f6158d == 0 && !this$0.f6160f) {
                this$0.f6156b.invoke();
                this$0.b();
            }
            lc.q qVar = lc.q.f12711a;
        }
    }

    public final void b() {
        synchronized (this.f6157c) {
            this.f6160f = true;
            Iterator<T> it = this.f6161g.iterator();
            while (it.hasNext()) {
                ((xc.a) it.next()).invoke();
            }
            this.f6161g.clear();
            lc.q qVar = lc.q.f12711a;
        }
    }

    public final boolean c() {
        boolean z10;
        synchronized (this.f6157c) {
            z10 = this.f6160f;
        }
        return z10;
    }
}
