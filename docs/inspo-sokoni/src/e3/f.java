package e3;

import com.google.auto.value.AutoValue;

/* JADX INFO: loaded from: classes.dex */
@AutoValue
public abstract class f {

    @AutoValue.Builder
    public static abstract class a {
        public abstract f a();

        public abstract a b(Iterable<d3.i> iterable);

        public abstract a c(byte[] bArr);
    }

    public static a a() {
        return new e3.a.b();
    }

    public abstract Iterable<d3.i> b();

    public abstract byte[] c();
}
