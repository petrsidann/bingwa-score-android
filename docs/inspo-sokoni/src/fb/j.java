package fb;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb.b f8286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f8288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fb.b.c f8289d;

    public final class a implements fb.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f8290a;

        /* JADX INFO: renamed from: fb.j$a$a, reason: collision with other inner class name */
        public class C0143a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ fb.b.InterfaceC0141b f8292a;

            public C0143a(fb.b.InterfaceC0141b interfaceC0141b) {
                this.f8292a = interfaceC0141b;
            }

            @Override // fb.j.d
            public void a(Object obj) {
                this.f8292a.a(j.this.f8288c.c(obj));
            }

            @Override // fb.j.d
            public void b(String str, String str2, Object obj) {
                this.f8292a.a(j.this.f8288c.e(str, str2, obj));
            }

            @Override // fb.j.d
            public void c() {
                this.f8292a.a(null);
            }
        }

        public a(c cVar) {
            this.f8290a = cVar;
        }

        @Override // fb.b.a
        public void a(ByteBuffer byteBuffer, fb.b.InterfaceC0141b interfaceC0141b) {
            try {
                this.f8290a.onMethodCall(j.this.f8288c.b(byteBuffer), new C0143a(interfaceC0141b));
            } catch (RuntimeException e10) {
                qa.b.c("MethodChannel#" + j.this.f8287b, "Failed to handle method call", e10);
                interfaceC0141b.a(j.this.f8288c.d("error", e10.getMessage(), null, qa.b.d(e10)));
            }
        }
    }

    public final class b implements fb.b.InterfaceC0141b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f8294a;

        public b(d dVar) {
            this.f8294a = dVar;
        }

        @Override // fb.b.InterfaceC0141b
        public void a(ByteBuffer byteBuffer) {
            try {
                if (byteBuffer == null) {
                    this.f8294a.c();
                } else {
                    try {
                        this.f8294a.a(j.this.f8288c.f(byteBuffer));
                    } catch (fb.d e10) {
                        this.f8294a.b(e10.f8280a, e10.getMessage(), e10.f8281b);
                    }
                }
            } catch (RuntimeException e11) {
                qa.b.c("MethodChannel#" + j.this.f8287b, "Failed to handle method call result", e11);
            }
        }
    }

    public interface c {
        void onMethodCall(i iVar, d dVar);
    }

    public interface d {
        void a(Object obj);

        void b(String str, String str2, Object obj);

        void c();
    }

    public j(fb.b bVar, String str) {
        this(bVar, str, q.f8299b);
    }

    public j(fb.b bVar, String str, k kVar) {
        this(bVar, str, kVar, null);
    }

    public j(fb.b bVar, String str, k kVar, fb.b.c cVar) {
        this.f8286a = bVar;
        this.f8287b = str;
        this.f8288c = kVar;
        this.f8289d = cVar;
    }

    public void c(String str, Object obj) {
        d(str, obj, null);
    }

    public void d(String str, Object obj, d dVar) {
        this.f8286a.f(this.f8287b, this.f8288c.a(new i(str, obj)), dVar == null ? null : new b(dVar));
    }

    public void e(c cVar) {
        if (this.f8289d != null) {
            this.f8286a.c(this.f8287b, cVar != null ? new a(cVar) : null, this.f8289d);
        } else {
            this.f8286a.d(this.f8287b, cVar != null ? new a(cVar) : null);
        }
    }
}
