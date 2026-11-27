package je;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f11404a;

    public static c a() {
        if (f11404a == null) {
            f11404a = new c();
        }
        return f11404a;
    }

    public boolean b(Boolean bool) {
        return bool != null && bool.booleanValue();
    }

    public boolean c(Boolean bool, Boolean bool2) {
        return bool == null ? b(bool2) : b(bool);
    }
}
