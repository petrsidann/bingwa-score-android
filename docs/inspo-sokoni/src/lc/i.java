package lc;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class i<A, B> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f12701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f12702b;

    public i(A a10, B b10) {
        this.f12701a = a10;
        this.f12702b = b10;
    }

    public final A a() {
        return this.f12701a;
    }

    public final B b() {
        return this.f12702b;
    }

    public final A c() {
        return this.f12701a;
    }

    public final B d() {
        return this.f12702b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return kotlin.jvm.internal.k.a(this.f12701a, iVar.f12701a) && kotlin.jvm.internal.k.a(this.f12702b, iVar.f12702b);
    }

    public int hashCode() {
        A a10 = this.f12701a;
        int iHashCode = (a10 == null ? 0 : a10.hashCode()) * 31;
        B b10 = this.f12702b;
        return iHashCode + (b10 != null ? b10.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f12701a + ", " + this.f12702b + ')';
    }
}
