package w8;

/* JADX INFO: loaded from: classes.dex */
public final class a implements x7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x7.a f17657a = new a();

    /* JADX INFO: renamed from: w8.a$a, reason: collision with other inner class name */
    public static final class C0313a implements w7.e<x8.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0313a f17658a = new C0313a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final w7.d f17659b = w7.d.a("projectNumber").b(z7.a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final w7.d f17660c = w7.d.a("messageId").b(z7.a.b().c(2).a()).a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final w7.d f17661d = w7.d.a("instanceId").b(z7.a.b().c(3).a()).a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final w7.d f17662e = w7.d.a("messageType").b(z7.a.b().c(4).a()).a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final w7.d f17663f = w7.d.a("sdkPlatform").b(z7.a.b().c(5).a()).a();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final w7.d f17664g = w7.d.a("packageName").b(z7.a.b().c(6).a()).a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final w7.d f17665h = w7.d.a("collapseKey").b(z7.a.b().c(7).a()).a();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final w7.d f17666i = w7.d.a("priority").b(z7.a.b().c(8).a()).a();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final w7.d f17667j = w7.d.a("ttl").b(z7.a.b().c(9).a()).a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final w7.d f17668k = w7.d.a("topic").b(z7.a.b().c(10).a()).a();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final w7.d f17669l = w7.d.a("bulkId").b(z7.a.b().c(11).a()).a();

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final w7.d f17670m = w7.d.a("event").b(z7.a.b().c(12).a()).a();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final w7.d f17671n = w7.d.a("analyticsLabel").b(z7.a.b().c(13).a()).a();

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final w7.d f17672o = w7.d.a("campaignId").b(z7.a.b().c(14).a()).a();

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final w7.d f17673p = w7.d.a("composerLabel").b(z7.a.b().c(15).a()).a();

        @Override // w7.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(x8.a aVar, w7.f fVar) {
            fVar.a(f17659b, aVar.l());
            fVar.c(f17660c, aVar.h());
            fVar.c(f17661d, aVar.g());
            fVar.c(f17662e, aVar.i());
            fVar.c(f17663f, aVar.m());
            fVar.c(f17664g, aVar.j());
            fVar.c(f17665h, aVar.d());
            fVar.b(f17666i, aVar.k());
            fVar.b(f17667j, aVar.o());
            fVar.c(f17668k, aVar.n());
            fVar.a(f17669l, aVar.b());
            fVar.c(f17670m, aVar.f());
            fVar.c(f17671n, aVar.a());
            fVar.a(f17672o, aVar.c());
            fVar.c(f17673p, aVar.e());
        }
    }

    public static final class b implements w7.e<x8.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f17674a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final w7.d f17675b = w7.d.a("messagingClientEvent").b(z7.a.b().c(1).a()).a();

        @Override // w7.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(x8.b bVar, w7.f fVar) {
            fVar.c(f17675b, bVar.a());
        }
    }

    public static final class c implements w7.e<j0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f17676a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final w7.d f17677b = w7.d.d("messagingClientEventExtension");

        @Override // w7.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(j0 j0Var, w7.f fVar) {
            fVar.c(f17677b, j0Var.b());
        }
    }

    @Override // x7.a
    public void a(x7.b<?> bVar) {
        bVar.a(j0.class, c.f17676a);
        bVar.a(x8.b.class, b.f17674a);
        bVar.a(x8.a.class, C0313a.f17658a);
    }
}
