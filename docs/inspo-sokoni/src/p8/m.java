package p8;

import com.google.auto.value.AutoValue;

/* JADX INFO: loaded from: classes.dex */
@AutoValue
public abstract class m {

    @AutoValue.Builder
    public static abstract class a {
        public abstract m a();

        public abstract a b(String str);

        public abstract a c(long j10);

        public abstract a d(long j10);
    }

    public static a a() {
        return new p8.a.b();
    }

    public abstract String b();

    public abstract long c();

    public abstract long d();
}
