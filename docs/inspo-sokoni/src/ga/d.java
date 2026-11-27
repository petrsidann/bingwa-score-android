package ga;

import fb.i;
import fb.j;

/* JADX INFO: loaded from: classes.dex */
public class d extends ga.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f9121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f9122b;

    public class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j.d f9123a;

        public a(j.d dVar) {
            this.f9123a = dVar;
        }

        @Override // ga.f
        public void a(Object obj) {
            this.f9123a.a(obj);
        }

        @Override // ga.f
        public void b(String str, String str2, Object obj) {
            this.f9123a.b(str, str2, obj);
        }
    }

    public d(i iVar, j.d dVar) {
        this.f9122b = iVar;
        this.f9121a = new a(dVar);
    }

    @Override // ga.e
    public <T> T c(String str) {
        return (T) this.f9122b.a(str);
    }

    @Override // ga.e
    public String getMethod() {
        return this.f9122b.f8284a;
    }

    @Override // ga.e
    public boolean h(String str) {
        return this.f9122b.c(str);
    }

    @Override // ga.a
    public f n() {
        return this.f9121a;
    }
}
