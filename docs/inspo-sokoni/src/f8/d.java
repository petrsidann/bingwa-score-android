package f8;

import com.google.protobuf.i;
import h8.p;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f8248a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f8249b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f8250c = new b();

    public class a extends f8.b {
        public a() {
        }

        @Override // f8.b
        public void a(i iVar) {
            d.this.f8248a.h(iVar);
        }

        @Override // f8.b
        public void b(double d10) {
            d.this.f8248a.j(d10);
        }

        @Override // f8.b
        public void c() {
            d.this.f8248a.n();
        }

        @Override // f8.b
        public void d(long j10) {
            d.this.f8248a.r(j10);
        }

        @Override // f8.b
        public void e(String str) {
            d.this.f8248a.v(str);
        }
    }

    public class b extends f8.b {
        public b() {
        }

        @Override // f8.b
        public void a(i iVar) {
            d.this.f8248a.i(iVar);
        }

        @Override // f8.b
        public void b(double d10) {
            d.this.f8248a.k(d10);
        }

        @Override // f8.b
        public void c() {
            d.this.f8248a.o();
        }

        @Override // f8.b
        public void d(long j10) {
            d.this.f8248a.s(j10);
        }

        @Override // f8.b
        public void e(String str) {
            d.this.f8248a.w(str);
        }
    }

    public f8.b b(p.c.a aVar) {
        return aVar.equals(p.c.a.DESCENDING) ? this.f8250c : this.f8249b;
    }

    public byte[] c() {
        return this.f8248a.a();
    }

    public void d(byte[] bArr) {
        this.f8248a.c(bArr);
    }
}
