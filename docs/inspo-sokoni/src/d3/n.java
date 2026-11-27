package d3;

import com.google.auto.value.AutoValue;

/* JADX INFO: loaded from: classes.dex */
@AutoValue
public abstract class n {

    @AutoValue.Builder
    public static abstract class a {
        public abstract n a();

        public abstract a b(a3.c cVar);

        public abstract a c(a3.d<?> dVar);

        public abstract a d(a3.g<?, byte[]> gVar);

        public abstract a e(o oVar);

        public abstract a f(String str);
    }

    public static a a() {
        return new c.b();
    }

    public abstract a3.c b();

    public abstract a3.d<?> c();

    public byte[] d() {
        return e().apply(c().b());
    }

    public abstract a3.g<?, byte[]> e();

    public abstract o f();

    public abstract String g();
}
