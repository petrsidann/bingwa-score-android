package vb;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a.c<String> f17549d = a.c.a("io.grpc.EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SocketAddress> f17550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f17551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17552c;

    public y(SocketAddress socketAddress) {
        this(socketAddress, a.f17234c);
    }

    public y(SocketAddress socketAddress, a aVar) {
        this((List<SocketAddress>) Collections.singletonList(socketAddress), aVar);
    }

    public y(List<SocketAddress> list, a aVar) {
        j6.m.e(!list.isEmpty(), "addrs is empty");
        List<SocketAddress> listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f17550a = listUnmodifiableList;
        this.f17551b = (a) j6.m.p(aVar, "attrs");
        this.f17552c = listUnmodifiableList.hashCode();
    }

    public List<SocketAddress> a() {
        return this.f17550a;
    }

    public a b() {
        return this.f17551b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        if (this.f17550a.size() != yVar.f17550a.size()) {
            return false;
        }
        for (int i10 = 0; i10 < this.f17550a.size(); i10++) {
            if (!this.f17550a.get(i10).equals(yVar.f17550a.get(i10))) {
                return false;
            }
        }
        return this.f17551b.equals(yVar.f17551b);
    }

    public int hashCode() {
        return this.f17552c;
    }

    public String toString() {
        return "[" + this.f17550a + "/" + this.f17551b + "]";
    }
}
