package c8;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f3436b = new j(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3437a;

    public j(String str) {
        this.f3437a = str;
    }

    public String a() {
        return this.f3437a;
    }

    public boolean b() {
        return this.f3437a != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        String str = this.f3437a;
        String str2 = ((j) obj).f3437a;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    public int hashCode() {
        String str = this.f3437a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "User(uid:" + this.f3437a + ")";
    }
}
