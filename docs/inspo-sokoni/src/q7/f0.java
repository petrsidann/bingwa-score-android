package q7;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class f0 implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<e0<?>> f14848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<e0<?>> f14849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<e0<?>> f14850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<e0<?>> f14851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<e0<?>> f14852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<Class<?>> f14853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f14854g;

    public static class a implements a8.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<Class<?>> f14855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a8.c f14856b;

        public a(Set<Class<?>> set, a8.c cVar) {
            this.f14855a = set;
            this.f14856b = cVar;
        }

        @Override // a8.c
        public void b(a8.a<?> aVar) {
            if (!this.f14855a.contains(aVar.b())) {
                throw new s(String.format("Attempting to publish an undeclared event %s.", aVar));
            }
            this.f14856b.b(aVar);
        }
    }

    public f0(c<?> cVar, d dVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (q qVar : cVar.g()) {
            if (qVar.e()) {
                boolean zG = qVar.g();
                e0<?> e0VarC = qVar.c();
                if (zG) {
                    hashSet4.add(e0VarC);
                } else {
                    hashSet.add(e0VarC);
                }
            } else if (qVar.d()) {
                hashSet3.add(qVar.c());
            } else {
                boolean zG2 = qVar.g();
                e0<?> e0VarC2 = qVar.c();
                if (zG2) {
                    hashSet5.add(e0VarC2);
                } else {
                    hashSet2.add(e0VarC2);
                }
            }
        }
        if (!cVar.k().isEmpty()) {
            hashSet.add(e0.b(a8.c.class));
        }
        this.f14848a = Collections.unmodifiableSet(hashSet);
        this.f14849b = Collections.unmodifiableSet(hashSet2);
        this.f14850c = Collections.unmodifiableSet(hashSet3);
        this.f14851d = Collections.unmodifiableSet(hashSet4);
        this.f14852e = Collections.unmodifiableSet(hashSet5);
        this.f14853f = cVar.k();
        this.f14854g = dVar;
    }

    @Override // q7.d
    public <T> T a(Class<T> cls) {
        if (!this.f14848a.contains(e0.b(cls))) {
            throw new s(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        T t10 = (T) this.f14854g.a(cls);
        return !cls.equals(a8.c.class) ? t10 : (T) new a(this.f14853f, (a8.c) t10);
    }

    @Override // q7.d
    public <T> o8.b<T> b(e0<T> e0Var) {
        if (this.f14849b.contains(e0Var)) {
            return this.f14854g.b(e0Var);
        }
        throw new s(String.format("Attempting to request an undeclared dependency Provider<%s>.", e0Var));
    }

    @Override // q7.d
    public <T> o8.b<T> c(Class<T> cls) {
        return b(e0.b(cls));
    }

    @Override // q7.d
    public <T> o8.a<T> d(e0<T> e0Var) {
        if (this.f14850c.contains(e0Var)) {
            return this.f14854g.d(e0Var);
        }
        throw new s(String.format("Attempting to request an undeclared dependency Deferred<%s>.", e0Var));
    }

    @Override // q7.d
    public <T> o8.b<Set<T>> f(e0<T> e0Var) {
        if (this.f14852e.contains(e0Var)) {
            return this.f14854g.f(e0Var);
        }
        throw new s(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", e0Var));
    }

    @Override // q7.d
    public <T> Set<T> g(e0<T> e0Var) {
        if (this.f14851d.contains(e0Var)) {
            return this.f14854g.g(e0Var);
        }
        throw new s(String.format("Attempting to request an undeclared dependency Set<%s>.", e0Var));
    }

    @Override // q7.d
    public <T> T h(e0<T> e0Var) {
        if (this.f14848a.contains(e0Var)) {
            return (T) this.f14854g.h(e0Var);
        }
        throw new s(String.format("Attempting to request an undeclared dependency %s.", e0Var));
    }

    @Override // q7.d
    public <T> o8.a<T> i(Class<T> cls) {
        return d(e0.b(cls));
    }
}
