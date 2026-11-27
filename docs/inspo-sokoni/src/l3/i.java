package l3;

/* JADX INFO: loaded from: classes.dex */
public final class i implements f3.b<Integer> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f12434a = new i();
    }

    public static i a() {
        return a.f12434a;
    }

    public static int c() {
        return f.c();
    }

    @Override // kc.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer get() {
        return Integer.valueOf(c());
    }
}
