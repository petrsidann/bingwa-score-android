package o2;

import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.k;
import lc.q;
import m2.j;

/* JADX INFO: loaded from: classes.dex */
public final class e implements n2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f13638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f13639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Context, g> f13640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<o0.a<j>, Context> f13641d;

    public e(WindowLayoutComponent component) {
        k.e(component, "component");
        this.f13638a = component;
        this.f13639b = new ReentrantLock();
        this.f13640c = new LinkedHashMap();
        this.f13641d = new LinkedHashMap();
    }

    @Override // n2.a
    public void a(Context context, Executor executor, o0.a<j> callback) {
        q qVar;
        k.e(context, "context");
        k.e(executor, "executor");
        k.e(callback, "callback");
        ReentrantLock reentrantLock = this.f13639b;
        reentrantLock.lock();
        try {
            g gVar = this.f13640c.get(context);
            if (gVar != null) {
                gVar.b(callback);
                this.f13641d.put(callback, context);
                qVar = q.f12711a;
            } else {
                qVar = null;
            }
            if (qVar == null) {
                g gVar2 = new g(context);
                this.f13640c.put(context, gVar2);
                this.f13641d.put(callback, context);
                gVar2.b(callback);
                this.f13638a.addWindowLayoutInfoListener(context, gVar2);
            }
            q qVar2 = q.f12711a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // n2.a
    public void b(o0.a<j> callback) {
        k.e(callback, "callback");
        ReentrantLock reentrantLock = this.f13639b;
        reentrantLock.lock();
        try {
            Context context = this.f13641d.get(callback);
            if (context == null) {
                return;
            }
            g gVar = this.f13640c.get(context);
            if (gVar == null) {
                return;
            }
            gVar.d(callback);
            this.f13641d.remove(callback);
            if (gVar.c()) {
                this.f13640c.remove(context);
                this.f13638a.removeWindowLayoutInfoListener(gVar);
            }
            q qVar = q.f12711a;
        } finally {
            reentrantLock.unlock();
        }
    }
}
