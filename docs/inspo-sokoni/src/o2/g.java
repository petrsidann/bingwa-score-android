package o2;

import android.content.Context;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.k;
import lc.q;
import m2.j;

/* JADX INFO: loaded from: classes.dex */
public final class g implements o0.a<WindowLayoutInfo>, Consumer<WindowLayoutInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f13644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f13645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<o0.a<j>> f13646d;

    public g(Context context) {
        k.e(context, "context");
        this.f13643a = context;
        this.f13644b = new ReentrantLock();
        this.f13646d = new LinkedHashSet();
    }

    @Override // o0.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(WindowLayoutInfo value) {
        k.e(value, "value");
        ReentrantLock reentrantLock = this.f13644b;
        reentrantLock.lock();
        try {
            this.f13645c = f.f13642a.b(this.f13643a, value);
            Iterator<T> it = this.f13646d.iterator();
            while (it.hasNext()) {
                ((o0.a) it.next()).accept(this.f13645c);
            }
            q qVar = q.f12711a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void b(o0.a<j> listener) {
        k.e(listener, "listener");
        ReentrantLock reentrantLock = this.f13644b;
        reentrantLock.lock();
        try {
            j jVar = this.f13645c;
            if (jVar != null) {
                listener.accept(jVar);
            }
            this.f13646d.add(listener);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean c() {
        return this.f13646d.isEmpty();
    }

    public final void d(o0.a<j> listener) {
        k.e(listener, "listener");
        ReentrantLock reentrantLock = this.f13644b;
        reentrantLock.lock();
        try {
            this.f13646d.remove(listener);
        } finally {
            reentrantLock.unlock();
        }
    }
}
