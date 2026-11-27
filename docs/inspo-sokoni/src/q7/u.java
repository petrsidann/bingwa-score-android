package q7;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class u implements a8.d, a8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, ConcurrentHashMap<a8.b<Object>, Executor>> f14889a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Queue<a8.a<?>> f14890b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f14891c;

    public u(Executor executor) {
        this.f14891c = executor;
    }

    public static /* synthetic */ void h(Map.Entry entry, a8.a aVar) {
        ((a8.b) entry.getKey()).a(aVar);
    }

    @Override // a8.d
    public synchronized <T> void a(Class<T> cls, Executor executor, a8.b<? super T> bVar) {
        d0.b(cls);
        d0.b(bVar);
        d0.b(executor);
        if (!this.f14889a.containsKey(cls)) {
            this.f14889a.put(cls, new ConcurrentHashMap<>());
        }
        this.f14889a.get(cls).put(bVar, executor);
    }

    @Override // a8.c
    public void b(final a8.a<?> aVar) {
        d0.b(aVar);
        synchronized (this) {
            Queue<a8.a<?>> queue = this.f14890b;
            if (queue != null) {
                queue.add(aVar);
                return;
            }
            for (final Map.Entry<a8.b<Object>, Executor> entry : g(aVar)) {
                entry.getValue().execute(new Runnable() { // from class: q7.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.h(entry, aVar);
                    }
                });
            }
        }
    }

    @Override // a8.d
    public <T> void c(Class<T> cls, a8.b<? super T> bVar) {
        a(cls, this.f14891c, bVar);
    }

    @Override // a8.d
    public synchronized <T> void d(Class<T> cls, a8.b<? super T> bVar) {
        d0.b(cls);
        d0.b(bVar);
        if (this.f14889a.containsKey(cls)) {
            ConcurrentHashMap<a8.b<Object>, Executor> concurrentHashMap = this.f14889a.get(cls);
            concurrentHashMap.remove(bVar);
            if (concurrentHashMap.isEmpty()) {
                this.f14889a.remove(cls);
            }
        }
    }

    public void f() {
        Queue<a8.a<?>> queue;
        synchronized (this) {
            queue = this.f14890b;
            if (queue != null) {
                this.f14890b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            Iterator<a8.a<?>> it = queue.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
        }
    }

    public final synchronized Set<Map.Entry<a8.b<Object>, Executor>> g(a8.a<?> aVar) {
        ConcurrentHashMap<a8.b<Object>, Executor> concurrentHashMap;
        concurrentHashMap = this.f14889a.get(aVar.b());
        return concurrentHashMap == null ? Collections.emptySet() : concurrentHashMap.entrySet();
    }
}
