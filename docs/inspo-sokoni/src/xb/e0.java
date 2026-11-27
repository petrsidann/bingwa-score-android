package xb;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 extends vb.d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f18434a = vb.p0.a(e0.class.getClassLoader());

    @Override // vb.c1.d
    public String a() {
        return "dns";
    }

    @Override // vb.c1.d
    public vb.c1 b(URI uri, vb.c1.b bVar) {
        if (!"dns".equals(uri.getScheme())) {
            return null;
        }
        String str = (String) j6.m.p(uri.getPath(), "targetPath");
        j6.m.l(str.startsWith("/"), "the path component (%s) of the target (%s) must start with '/'", str, uri);
        return new d0(uri.getAuthority(), str.substring(1), bVar, r0.f18875u, j6.p.c(), f18434a);
    }

    @Override // vb.d1
    public Collection<Class<? extends SocketAddress>> c() {
        return Collections.singleton(InetSocketAddress.class);
    }

    @Override // vb.d1
    public boolean e() {
        return true;
    }

    @Override // vb.d1
    public int f() {
        return 5;
    }
}
