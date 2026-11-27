package c3;

import com.google.auto.value.AutoValue;

/* JADX INFO: loaded from: classes.dex */
@AutoValue
public abstract class k {

    @AutoValue.Builder
    public static abstract class a {
        public abstract k a();

        public abstract a b(c3.a aVar);

        public abstract a c(b bVar);
    }

    public enum b {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3279a;

        b(int i10) {
            this.f3279a = i10;
        }
    }

    public static a a() {
        return new e.b();
    }

    public abstract c3.a b();

    public abstract b c();
}
