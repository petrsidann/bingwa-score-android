package h6;

/* JADX INFO: loaded from: classes.dex */
public final class m implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f9680b = new m(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9681a;

    public m(Object obj) {
        this.f9681a = obj;
    }

    public static l b(Object obj) {
        if (obj != null) {
            return new m(obj);
        }
        throw new NullPointerException("instance cannot be null");
    }

    @Override // h6.o
    public final Object a() {
        return this.f9681a;
    }
}
