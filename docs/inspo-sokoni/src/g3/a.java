package g3;

import d3.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f8609e = new C0151a().b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f8610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f8611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f8612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8613d;

    /* JADX INFO: renamed from: g3.a$a, reason: collision with other inner class name */
    public static final class C0151a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f f8614a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<d> f8615b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f8616c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f8617d = "";

        public C0151a a(d dVar) {
            this.f8615b.add(dVar);
            return this;
        }

        public a b() {
            return new a(this.f8614a, Collections.unmodifiableList(this.f8615b), this.f8616c, this.f8617d);
        }

        public C0151a c(String str) {
            this.f8617d = str;
            return this;
        }

        public C0151a d(b bVar) {
            this.f8616c = bVar;
            return this;
        }

        public C0151a e(f fVar) {
            this.f8614a = fVar;
            return this;
        }
    }

    public a(f fVar, List<d> list, b bVar, String str) {
        this.f8610a = fVar;
        this.f8611b = list;
        this.f8612c = bVar;
        this.f8613d = str;
    }

    public static C0151a e() {
        return new C0151a();
    }

    @z7.d(tag = 4)
    public String a() {
        return this.f8613d;
    }

    @z7.d(tag = 3)
    public b b() {
        return this.f8612c;
    }

    @z7.d(tag = 2)
    public List<d> c() {
        return this.f8611b;
    }

    @z7.d(tag = 1)
    public f d() {
        return this.f8610a;
    }

    public byte[] f() {
        return l.a(this);
    }
}
