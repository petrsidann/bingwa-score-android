package j6;

/* JADX INFO: loaded from: classes.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f11301a = new a();

    public class a extends v {
        @Override // j6.v
        public long a() {
            return System.nanoTime();
        }
    }

    public static v b() {
        return f11301a;
    }

    public abstract long a();
}
