package b8;

/* JADX INFO: loaded from: classes.dex */
public class e implements Comparable<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.protobuf.i f2896a;

    public e(com.google.protobuf.i iVar) {
        this.f2896a = iVar;
    }

    public static e h(com.google.protobuf.i iVar) {
        l8.x.c(iVar, "Provided ByteString must not be null.");
        return new e(iVar);
    }

    public static e i(byte[] bArr) {
        l8.x.c(bArr, "Provided bytes array must not be null.");
        return new e(com.google.protobuf.i.q(bArr));
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(e eVar) {
        return l8.g0.j(this.f2896a, eVar.f2896a);
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && this.f2896a.equals(((e) obj).f2896a);
    }

    public int hashCode() {
        return this.f2896a.hashCode();
    }

    public com.google.protobuf.i k() {
        return this.f2896a;
    }

    public byte[] l() {
        return this.f2896a.I();
    }

    public String toString() {
        return "Blob { bytes=" + l8.g0.B(this.f2896a) + " }";
    }
}
