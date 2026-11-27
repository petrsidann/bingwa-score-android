package o2;

import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.u;
import lc.q;
import m2.j;
import mc.o;
import xc.l;

/* JADX INFO: loaded from: classes.dex */
public final class d implements n2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f13632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j2.d f13633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantLock f13634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Context, g> f13635d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<o0.a<j>, Context> f13636e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<g, j2.d.b> f13637f;

    public /* synthetic */ class a extends kotlin.jvm.internal.j implements l<WindowLayoutInfo, q> {
        public a(Object obj) {
            super(1, obj, g.class, "accept", "accept(Landroidx/window/extensions/layout/WindowLayoutInfo;)V", 0);
        }

        public final void d(WindowLayoutInfo p10) {
            k.e(p10, "p0");
            ((g) this.receiver).accept(p10);
        }

        @Override // xc.l
        public /* bridge */ /* synthetic */ q invoke(WindowLayoutInfo windowLayoutInfo) {
            d(windowLayoutInfo);
            return q.f12711a;
        }
    }

    public d(WindowLayoutComponent component, j2.d consumerAdapter) {
        k.e(component, "component");
        k.e(consumerAdapter, "consumerAdapter");
        this.f13632a = component;
        this.f13633b = consumerAdapter;
        this.f13634c = new ReentrantLock();
        this.f13635d = new LinkedHashMap();
        this.f13636e = new LinkedHashMap();
        this.f13637f = new LinkedHashMap();
    }

    @Override // n2.a
    public void a(Context context, Executor executor, o0.a<j> callback) {
        q qVar;
        k.e(context, "context");
        k.e(executor, "executor");
        k.e(callback, "callback");
        ReentrantLock reentrantLock = this.f13634c;
        reentrantLock.lock();
        try {
            g gVar = this.f13635d.get(context);
            if (gVar != null) {
                gVar.b(callback);
                this.f13636e.put(callback, context);
                qVar = q.f12711a;
            } else {
                qVar = null;
            }
            if (qVar == null) {
                g gVar2 = new g(context);
                this.f13635d.put(context, gVar2);
                this.f13636e.put(callback, context);
                gVar2.b(callback);
                if (!(context instanceof Activity)) {
                    gVar2.accept(new WindowLayoutInfo(o.g()));
                    return;
                } else {
                    this.f13637f.put(gVar2, this.f13633b.c(this.f13632a, u.b(WindowLayoutInfo.class), "addWindowLayoutInfoListener", "removeWindowLayoutInfoListener", (Activity) context, new a(gVar2)));
                }
            }
            q qVar2 = q.f12711a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // n2.a
    public void b(o0.a<j> callback) {
        k.e(callback, "callback");
        ReentrantLock reentrantLock = this.f13634c;
        reentrantLock.lock();
        try {
            Context context = this.f13636e.get(callback);
            if (context == null) {
                return;
            }
            g gVar = this.f13635d.get(context);
            if (gVar == null) {
                return;
            }
            gVar.d(callback);
            this.f13636e.remove(callback);
            if (gVar.c()) {
                this.f13635d.remove(context);
                j2.d.b bVarRemove = this.f13637f.remove(gVar);
                if (bVarRemove != null) {
                    bVarRemove.d();
                }
            }
            q qVar = q.f12711a;
        } finally {
            reentrantLock.unlock();
        }
    }
}
