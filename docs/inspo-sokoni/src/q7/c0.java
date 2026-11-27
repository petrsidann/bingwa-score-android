package q7;

/* JADX INFO: loaded from: classes.dex */
public class c0<T> implements o8.b<T>, o8.a<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o8.a.InterfaceC0236a<Object> f14838c = new o8.a.InterfaceC0236a() { // from class: q7.z
        @Override // o8.a.InterfaceC0236a
        public final void a(o8.b bVar) {
            c0.f(bVar);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o8.b<Object> f14839d = new o8.b() { // from class: q7.a0
        @Override // o8.b
        public final Object get() {
            return c0.g();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o8.a.InterfaceC0236a<T> f14840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile o8.b<T> f14841b;

    public c0(o8.a.InterfaceC0236a<T> interfaceC0236a, o8.b<T> bVar) {
        this.f14840a = interfaceC0236a;
        this.f14841b = bVar;
    }

    public static <T> c0<T> e() {
        return new c0<>(f14838c, f14839d);
    }

    public static /* synthetic */ void f(o8.b bVar) {
    }

    public static /* synthetic */ Object g() {
        return null;
    }

    public static /* synthetic */ void h(o8.a.InterfaceC0236a interfaceC0236a, o8.a.InterfaceC0236a interfaceC0236a2, o8.b bVar) {
        interfaceC0236a.a(bVar);
        interfaceC0236a2.a(bVar);
    }

    public static <T> c0<T> i(o8.b<T> bVar) {
        return new c0<>(null, bVar);
    }

    @Override // o8.a
    public void a(final o8.a.InterfaceC0236a<T> interfaceC0236a) {
        o8.b<T> bVar;
        o8.b<T> bVar2;
        o8.b<T> bVar3 = this.f14841b;
        o8.b<Object> bVar4 = f14839d;
        if (bVar3 != bVar4) {
            interfaceC0236a.a(bVar3);
            return;
        }
        synchronized (this) {
            bVar = this.f14841b;
            if (bVar != bVar4) {
                bVar2 = bVar;
            } else {
                final o8.a.InterfaceC0236a<T> interfaceC0236a2 = this.f14840a;
                this.f14840a = new o8.a.InterfaceC0236a() { // from class: q7.b0
                    @Override // o8.a.InterfaceC0236a
                    public final void a(o8.b bVar5) {
                        c0.h(interfaceC0236a2, interfaceC0236a, bVar5);
                    }
                };
                bVar2 = null;
            }
        }
        if (bVar2 != null) {
            interfaceC0236a.a(bVar);
        }
    }

    @Override // o8.b
    public T get() {
        return this.f14841b.get();
    }

    public void j(o8.b<T> bVar) {
        o8.a.InterfaceC0236a<T> interfaceC0236a;
        if (this.f14841b != f14839d) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (this) {
            interfaceC0236a = this.f14840a;
            this.f14840a = null;
            this.f14841b = bVar;
        }
        interfaceC0236a.a(bVar);
    }
}
