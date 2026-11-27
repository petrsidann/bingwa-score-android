package d3;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a3.c f6345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f6346b;

    public h(a3.c cVar, byte[] bArr) {
        if (cVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f6345a = cVar;
        this.f6346b = bArr;
    }

    public byte[] a() {
        return this.f6346b;
    }

    public a3.c b() {
        return this.f6345a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f6345a.equals(hVar.f6345a)) {
            return Arrays.equals(this.f6346b, hVar.f6346b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f6345a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f6346b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f6345a + ", bytes=[...]}";
    }
}
