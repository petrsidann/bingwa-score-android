package eb;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f7706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public fb.j f7707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public fb.j.d f7708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f7709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final fb.j.c f7711g;

    public class a implements fb.j.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f7712a;

        public a(byte[] bArr) {
            this.f7712a = bArr;
        }

        @Override // fb.j.d
        public void a(Object obj) {
            o.this.f7706b = this.f7712a;
        }

        @Override // fb.j.d
        public void b(String str, String str2, Object obj) {
            qa.b.b("RestorationChannel", "Error " + str + " while sending restoration data to framework: " + str2);
        }

        @Override // fb.j.d
        public void c() {
        }
    }

    public class b implements fb.j.c {
        public b() {
        }

        @Override // fb.j.c
        public void onMethodCall(fb.i iVar, fb.j.d dVar) {
            Map mapI;
            String str = iVar.f8284a;
            Object obj = iVar.f8285b;
            str.hashCode();
            if (str.equals("get")) {
                o.this.f7710f = true;
                if (!o.this.f7709e) {
                    o oVar = o.this;
                    if (oVar.f7705a) {
                        oVar.f7708d = dVar;
                        return;
                    }
                }
                o oVar2 = o.this;
                mapI = oVar2.i(oVar2.f7706b);
            } else if (!str.equals("put")) {
                dVar.c();
                return;
            } else {
                o.this.f7706b = (byte[]) obj;
                mapI = null;
            }
            dVar.a(mapI);
        }
    }

    public o(fb.j jVar, boolean z10) {
        this.f7709e = false;
        this.f7710f = false;
        b bVar = new b();
        this.f7711g = bVar;
        this.f7707c = jVar;
        this.f7705a = z10;
        jVar.e(bVar);
    }

    public o(ta.a aVar, boolean z10) {
        this(new fb.j(aVar, "flutter/restoration", fb.q.f8299b), z10);
    }

    public void g() {
        this.f7706b = null;
    }

    public byte[] h() {
        return this.f7706b;
    }

    public final Map<String, Object> i(byte[] bArr) {
        HashMap map = new HashMap();
        map.put("enabled", Boolean.TRUE);
        map.put("data", bArr);
        return map;
    }

    public void j(byte[] bArr) {
        this.f7709e = true;
        fb.j.d dVar = this.f7708d;
        if (dVar != null) {
            dVar.a(i(bArr));
            this.f7708d = null;
        } else if (this.f7710f) {
            this.f7707c.d("push", i(bArr), new a(bArr));
            return;
        }
        this.f7706b = bArr;
    }
}
