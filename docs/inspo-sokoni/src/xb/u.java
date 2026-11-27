package xb;

import java.io.Closeable;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public interface u extends Closeable {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f18968a = "unknown-authority";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public vb.a f18969b = vb.a.f17234c;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f18970c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public vb.e0 f18971d;

        public String a() {
            return this.f18968a;
        }

        public vb.a b() {
            return this.f18969b;
        }

        public vb.e0 c() {
            return this.f18971d;
        }

        public String d() {
            return this.f18970c;
        }

        public a e(String str) {
            this.f18968a = (String) j6.m.p(str, "authority");
            return this;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f18968a.equals(aVar.f18968a) && this.f18969b.equals(aVar.f18969b) && j6.i.a(this.f18970c, aVar.f18970c) && j6.i.a(this.f18971d, aVar.f18971d);
        }

        public a f(vb.a aVar) {
            j6.m.p(aVar, "eagAttributes");
            this.f18969b = aVar;
            return this;
        }

        public a g(vb.e0 e0Var) {
            this.f18971d = e0Var;
            return this;
        }

        public a h(String str) {
            this.f18970c = str;
            return this;
        }

        public int hashCode() {
            return j6.i.b(this.f18968a, this.f18969b, this.f18970c, this.f18971d);
        }
    }

    w F(SocketAddress socketAddress, a aVar, vb.f fVar);

    ScheduledExecutorService P();

    Collection<Class<? extends SocketAddress>> a0();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
