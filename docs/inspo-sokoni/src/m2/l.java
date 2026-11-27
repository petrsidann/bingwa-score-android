package m2;

import android.app.Activity;

/* JADX INFO: loaded from: classes.dex */
public interface l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12947a = a.f12948a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f12948a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static xc.l<? super l, ? extends l> f12949b = C0216a.f12950a;

        /* JADX INFO: renamed from: m2.l$a$a, reason: collision with other inner class name */
        public static final class C0216a extends kotlin.jvm.internal.l implements xc.l<l, l> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0216a f12950a = new C0216a();

            public C0216a() {
                super(1);
            }

            @Override // xc.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final l invoke(l it) {
                kotlin.jvm.internal.k.e(it, "it");
                return it;
            }
        }

        public final l a() {
            return f12949b.invoke(m.f12951b);
        }
    }

    static l b() {
        return f12947a.a();
    }

    k a(Activity activity);
}
