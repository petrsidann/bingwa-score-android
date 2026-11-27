package x8;

import w8.j0;
import z7.d;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f18062b = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x8.a f18063a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public x8.a f18064a = null;

        public b a() {
            return new b(this.f18064a);
        }

        public a b(x8.a aVar) {
            this.f18064a = aVar;
            return this;
        }
    }

    public b(x8.a aVar) {
        this.f18063a = aVar;
    }

    public static a b() {
        return new a();
    }

    @d(tag = 1)
    public x8.a a() {
        return this.f18063a;
    }

    public byte[] c() {
        return j0.a(this);
    }
}
