package vb;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 extends g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SocketAddress f17333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InetSocketAddress f17334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17336d;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SocketAddress f17337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InetSocketAddress f17338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f17339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f17340d;

        public b() {
        }

        public e0 a() {
            return new e0(this.f17337a, this.f17338b, this.f17339c, this.f17340d);
        }

        public b b(String str) {
            this.f17340d = str;
            return this;
        }

        public b c(SocketAddress socketAddress) {
            this.f17337a = (SocketAddress) j6.m.p(socketAddress, "proxyAddress");
            return this;
        }

        public b d(InetSocketAddress inetSocketAddress) {
            this.f17338b = (InetSocketAddress) j6.m.p(inetSocketAddress, "targetAddress");
            return this;
        }

        public b e(String str) {
            this.f17339c = str;
            return this;
        }
    }

    public e0(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2) {
        j6.m.p(socketAddress, "proxyAddress");
        j6.m.p(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            j6.m.x(!((InetSocketAddress) socketAddress).isUnresolved(), "The proxy address %s is not resolved", socketAddress);
        }
        this.f17333a = socketAddress;
        this.f17334b = inetSocketAddress;
        this.f17335c = str;
        this.f17336d = str2;
    }

    public static b e() {
        return new b();
    }

    public String a() {
        return this.f17336d;
    }

    public SocketAddress b() {
        return this.f17333a;
    }

    public InetSocketAddress c() {
        return this.f17334b;
    }

    public String d() {
        return this.f17335c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return j6.i.a(this.f17333a, e0Var.f17333a) && j6.i.a(this.f17334b, e0Var.f17334b) && j6.i.a(this.f17335c, e0Var.f17335c) && j6.i.a(this.f17336d, e0Var.f17336d);
    }

    public int hashCode() {
        return j6.i.b(this.f17333a, this.f17334b, this.f17335c, this.f17336d);
    }

    public String toString() {
        return j6.g.b(this).d("proxyAddr", this.f17333a).d("targetAddr", this.f17334b).d("username", this.f17335c).e("hasPassword", this.f17336d != null).toString();
    }
}
