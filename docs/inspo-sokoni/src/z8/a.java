package z8;

/* JADX INFO: loaded from: classes.dex */
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20381b;

    public a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.f20380a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f20381b = str2;
    }

    @Override // z8.f
    public String b() {
        return this.f20380a;
    }

    @Override // z8.f
    public String c() {
        return this.f20381b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f20380a.equals(fVar.b()) && this.f20381b.equals(fVar.c());
    }

    public int hashCode() {
        return ((this.f20380a.hashCode() ^ 1000003) * 1000003) ^ this.f20381b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f20380a + ", version=" + this.f20381b + "}";
    }
}
