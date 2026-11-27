package t8;

/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f15856a;

    public static b b() {
        if (f15856a == null) {
            f15856a = new b();
        }
        return f15856a;
    }

    @Override // t8.a
    public long a() {
        return System.currentTimeMillis();
    }
}
