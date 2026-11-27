package vb;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d1 extends c1.d {
    public Collection<Class<? extends SocketAddress>> c() {
        return Collections.singleton(InetSocketAddress.class);
    }

    public String d() {
        return a();
    }

    public abstract boolean e();

    public abstract int f();
}
