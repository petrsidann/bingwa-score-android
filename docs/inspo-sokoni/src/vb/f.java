package vb;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    public enum a {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    public abstract void a(a aVar, String str);

    public abstract void b(a aVar, String str, Object... objArr);
}
