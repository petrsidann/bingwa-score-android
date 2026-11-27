package d3;

/* JADX INFO: loaded from: classes.dex */
public final class a implements x7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x7.a f6281a = new a();

    /* JADX INFO: renamed from: d3.a$a, reason: collision with other inner class name */
    public static final class C0110a implements w7.e<g3.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0110a f6282a = new C0110a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final w7.d f6283b = w7.d.a("window").b(z7.a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final w7.d f6284c = w7.d.a("logSourceMetrics").b(z7.a.b().c(2).a()).a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final w7.d f6285d = w7.d.a("globalMetrics").b(z7.a.b().c(3).a()).a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final w7.d f6286e = w7.d.a("appNamespace").b(z7.a.b().c(4).a()).a();

        @Override // w7.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g3.a aVar, w7.f fVar) {
            fVar.c(f6283b, aVar.d());
            fVar.c(f6284c, aVar.c());
            fVar.c(f6285d, aVar.b());
            fVar.c(f6286e, aVar.a());
        }
    }

    public static final class b implements w7.e<g3.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6287a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final w7.d f6288b = w7.d.a("storageMetrics").b(z7.a.b().c(1).a()).a();

        @Override // w7.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g3.b bVar, w7.f fVar) {
            fVar.c(f6288b, bVar.a());
        }
    }

    public static final class c implements w7.e<g3.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f6289a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final w7.d f6290b = w7.d.a("eventsDroppedCount").b(z7.a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final w7.d f6291c = w7.d.a("reason").b(z7.a.b().c(3).a()).a();

        @Override // w7.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g3.c cVar, w7.f fVar) {
            fVar.a(f6290b, cVar.a());
            fVar.c(f6291c, cVar.b());
        }
    }

    public static final class d implements w7.e<g3.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f6292a = new d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final w7.d f6293b = w7.d.a("logSource").b(z7.a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final w7.d f6294c = w7.d.a("logEventDropped").b(z7.a.b().c(2).a()).a();

        @Override // w7.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g3.d dVar, w7.f fVar) {
            fVar.c(f6293b, dVar.b());
            fVar.c(f6294c, dVar.a());
        }
    }

    public static final class e implements w7.e<l> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f6295a = new e();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final w7.d f6296b = w7.d.d("clientMetrics");

        @Override // w7.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(l lVar, w7.f fVar) {
            fVar.c(f6296b, lVar.b());
        }
    }

    public static final class f implements w7.e<g3.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f6297a = new f();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final w7.d f6298b = w7.d.a("currentCacheSizeBytes").b(z7.a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final w7.d f6299c = w7.d.a("maxCacheSizeBytes").b(z7.a.b().c(2).a()).a();

        @Override // w7.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g3.e eVar, w7.f fVar) {
            fVar.a(f6298b, eVar.a());
            fVar.a(f6299c, eVar.b());
        }
    }

    public static final class g implements w7.e<g3.f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f6300a = new g();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final w7.d f6301b = w7.d.a("startMs").b(z7.a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final w7.d f6302c = w7.d.a("endMs").b(z7.a.b().c(2).a()).a();

        @Override // w7.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g3.f fVar, w7.f fVar2) {
            fVar2.a(f6301b, fVar.b());
            fVar2.a(f6302c, fVar.a());
        }
    }

    @Override // x7.a
    public void a(x7.b<?> bVar) {
        bVar.a(l.class, e.f6295a);
        bVar.a(g3.a.class, C0110a.f6282a);
        bVar.a(g3.f.class, g.f6300a);
        bVar.a(g3.d.class, d.f6292a);
        bVar.a(g3.c.class, c.f6289a);
        bVar.a(g3.b.class, b.f6287a);
        bVar.a(g3.e.class, f.f6297a);
    }
}
