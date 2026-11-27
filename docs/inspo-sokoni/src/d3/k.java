package d3;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class k implements f3.b<Executor> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f6347a = new k();
    }

    public static k a() {
        return a.f6347a;
    }

    public static Executor b() {
        return (Executor) f3.d.c(j.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // kc.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Executor get() {
        return b();
    }
}
