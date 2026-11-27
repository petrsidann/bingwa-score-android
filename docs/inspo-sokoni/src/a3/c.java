package a3;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f339a;

    public c(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f339a = str;
    }

    public static c b(String str) {
        return new c(str);
    }

    public String a() {
        return this.f339a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            return this.f339a.equals(((c) obj).f339a);
        }
        return false;
    }

    public int hashCode() {
        return this.f339a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.f339a + "\"}";
    }
}
