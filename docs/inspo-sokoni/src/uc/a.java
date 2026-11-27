package uc;

import zc.c;

/* JADX INFO: loaded from: classes2.dex */
public class a extends tc.a {

    /* JADX INFO: renamed from: uc.a$a, reason: collision with other inner class name */
    public static final class C0299a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0299a f17088a = new C0299a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f17089b;

        static {
            Integer num;
            Integer num2 = null;
            try {
                Object obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
                num = obj instanceof Integer ? (Integer) obj : null;
            } catch (Throwable unused) {
            }
            if (num != null) {
                if (num.intValue() > 0) {
                    num2 = num;
                }
            }
            f17089b = num2;
        }
    }

    private final boolean c(int i10) {
        Integer num = C0299a.f17089b;
        return num == null || num.intValue() >= i10;
    }

    @Override // sc.a
    public c b() {
        return c(34) ? new ad.a() : super.b();
    }
}
