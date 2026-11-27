package q7;

import android.util.Log;
import com.google.android.gms.common.api.internal.v1;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class n implements d, u7.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final o8.b<Set<Object>> f14864i = new o8.b() { // from class: q7.k
        @Override // o8.b
        public final Object get() {
            return Collections.emptySet();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<c<?>, o8.b<?>> f14865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<e0<?>, o8.b<?>> f14866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<e0<?>, x<?>> f14867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<o8.b<ComponentRegistrar>> f14868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Set<String> f14869e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u f14870f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference<Boolean> f14871g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i f14872h;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Executor f14873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<o8.b<ComponentRegistrar>> f14874b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<c<?>> f14875c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public i f14876d = i.f14857a;

        public b(Executor executor) {
            this.f14873a = executor;
        }

        public static /* synthetic */ ComponentRegistrar f(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }

        public b b(c<?> cVar) {
            this.f14875c.add(cVar);
            return this;
        }

        public b c(final ComponentRegistrar componentRegistrar) {
            this.f14874b.add(new o8.b() { // from class: q7.o
                @Override // o8.b
                public final Object get() {
                    return n.b.f(componentRegistrar);
                }
            });
            return this;
        }

        public b d(Collection<o8.b<ComponentRegistrar>> collection) {
            this.f14874b.addAll(collection);
            return this;
        }

        public n e() {
            return new n(this.f14873a, this.f14874b, this.f14875c, this.f14876d);
        }

        public b g(i iVar) {
            this.f14876d = iVar;
            return this;
        }
    }

    public n(Executor executor, Iterable<o8.b<ComponentRegistrar>> iterable, Collection<c<?>> collection, i iVar) {
        this.f14865a = new HashMap();
        this.f14866b = new HashMap();
        this.f14867c = new HashMap();
        this.f14869e = new HashSet();
        this.f14871g = new AtomicReference<>();
        u uVar = new u(executor);
        this.f14870f = uVar;
        this.f14872h = iVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(c.s(uVar, u.class, a8.d.class, a8.c.class));
        arrayList.add(c.s(this, u7.a.class, new Class[0]));
        for (c<?> cVar : collection) {
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        this.f14868d = q(iterable);
        n(arrayList);
    }

    public static b m(Executor executor) {
        return new b(executor);
    }

    public static <T> List<T> q(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object r(c cVar) {
        return cVar.h().a(new f0(cVar, this));
    }

    @Override // q7.d
    public synchronized <T> o8.b<T> b(e0<T> e0Var) {
        d0.c(e0Var, "Null interface requested.");
        return (o8.b) this.f14866b.get(e0Var);
    }

    @Override // q7.d
    public <T> o8.a<T> d(e0<T> e0Var) {
        o8.b<T> bVarB = b(e0Var);
        if (bVarB == null) {
            return c0.e();
        }
        return bVarB instanceof c0 ? (c0) bVarB : c0.i(bVarB);
    }

    @Override // q7.d
    public synchronized <T> o8.b<Set<T>> f(e0<T> e0Var) {
        x<?> xVar = this.f14867c.get(e0Var);
        if (xVar != null) {
            return xVar;
        }
        return (o8.b<Set<T>>) f14864i;
    }

    public final void n(List<c<?>> list) {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<o8.b<ComponentRegistrar>> it = this.f14868d.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = it.next().get();
                    if (componentRegistrar != null) {
                        list.addAll(this.f14872h.a(componentRegistrar));
                        it.remove();
                    }
                } catch (v e10) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e10);
                }
            }
            Iterator<c<?>> it2 = list.iterator();
            while (it2.hasNext()) {
                for (Object obj : it2.next().j().toArray()) {
                    if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                        if (this.f14869e.contains(obj.toString())) {
                            it2.remove();
                            break;
                        }
                        this.f14869e.add(obj.toString());
                    }
                }
            }
            if (this.f14865a.isEmpty()) {
                p.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f14865a.keySet());
                arrayList2.addAll(list);
                p.a(arrayList2);
            }
            for (final c<?> cVar : list) {
                this.f14865a.put(cVar, new w(new o8.b() { // from class: q7.j
                    @Override // o8.b
                    public final Object get() {
                        return this.f14858a.r(cVar);
                    }
                }));
            }
            arrayList.addAll(w(list));
            arrayList.addAll(x());
            v();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            ((Runnable) it3.next()).run();
        }
        u();
    }

    public final void o(Map<c<?>, o8.b<?>> map, boolean z10) {
        for (Map.Entry<c<?>, o8.b<?>> entry : map.entrySet()) {
            c<?> key = entry.getKey();
            o8.b<?> value = entry.getValue();
            if (key.n() || (key.o() && z10)) {
                value.get();
            }
        }
        this.f14870f.f();
    }

    public void p(boolean z10) {
        HashMap map;
        if (v1.a(this.f14871g, null, Boolean.valueOf(z10))) {
            synchronized (this) {
                map = new HashMap(this.f14865a);
            }
            o(map, z10);
        }
    }

    public final void u() {
        Boolean bool = this.f14871g.get();
        if (bool != null) {
            o(this.f14865a, bool.booleanValue());
        }
    }

    public final void v() {
        Map map;
        e0<?> e0VarC;
        Object objE;
        for (c<?> cVar : this.f14865a.keySet()) {
            for (q qVar : cVar.g()) {
                if (qVar.g() && !this.f14867c.containsKey(qVar.c())) {
                    map = this.f14867c;
                    e0VarC = qVar.c();
                    objE = x.b(Collections.emptySet());
                } else if (this.f14866b.containsKey(qVar.c())) {
                    continue;
                } else {
                    if (qVar.f()) {
                        throw new y(String.format("Unsatisfied dependency for component %s: %s", cVar, qVar.c()));
                    }
                    if (!qVar.g()) {
                        map = this.f14866b;
                        e0VarC = qVar.c();
                        objE = c0.e();
                    }
                }
                map.put(e0VarC, objE);
            }
        }
    }

    public final List<Runnable> w(List<c<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (c<?> cVar : list) {
            if (cVar.p()) {
                final o8.b<?> bVar = this.f14865a.get(cVar);
                for (e0<? super Object> e0Var : cVar.j()) {
                    if (this.f14866b.containsKey(e0Var)) {
                        final c0 c0Var = (c0) this.f14866b.get(e0Var);
                        arrayList.add(new Runnable() { // from class: q7.l
                            @Override // java.lang.Runnable
                            public final void run() {
                                c0Var.j(bVar);
                            }
                        });
                    } else {
                        this.f14866b.put(e0Var, bVar);
                    }
                }
            }
        }
        return arrayList;
    }

    public final List<Runnable> x() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry<c<?>, o8.b<?>> entry : this.f14865a.entrySet()) {
            c<?> key = entry.getKey();
            if (!key.p()) {
                o8.b<?> value = entry.getValue();
                for (e0<? super Object> e0Var : key.j()) {
                    if (!map.containsKey(e0Var)) {
                        map.put(e0Var, new HashSet());
                    }
                    ((Set) map.get(e0Var)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            if (this.f14867c.containsKey(entry2.getKey())) {
                final x<?> xVar = this.f14867c.get(entry2.getKey());
                for (final o8.b bVar : (Set) entry2.getValue()) {
                    arrayList.add(new Runnable() { // from class: q7.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            xVar.a(bVar);
                        }
                    });
                }
            } else {
                this.f14867c.put((e0) entry2.getKey(), x.b((Collection) entry2.getValue()));
            }
        }
        return arrayList;
    }
}
