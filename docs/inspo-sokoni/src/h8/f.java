package h8;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Comparable<f> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f9738c = h("", "");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9740b;

    public f(String str, String str2) {
        this.f9739a = str;
        this.f9740b = str2;
    }

    public static f h(String str, String str2) {
        return new f(str, str2);
    }

    public static f i(String str) {
        t tVarZ = t.z(str);
        l8.b.d(tVarZ.u() > 3 && tVarZ.q(0).equals("projects") && tVarZ.q(2).equals("databases"), "Tried to parse an invalid resource name: %s", tVarZ);
        return new f(tVarZ.q(1), tVarZ.q(3));
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        int iCompareTo = this.f9739a.compareTo(fVar.f9739a);
        return iCompareTo != 0 ? iCompareTo : this.f9740b.compareTo(fVar.f9740b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.f9739a.equals(fVar.f9739a) && this.f9740b.equals(fVar.f9740b);
    }

    public int hashCode() {
        return (this.f9739a.hashCode() * 31) + this.f9740b.hashCode();
    }

    public String k() {
        return this.f9740b;
    }

    public String l() {
        return this.f9739a;
    }

    public String toString() {
        return "DatabaseId(" + this.f9739a + ", " + this.f9740b + ")";
    }
}
