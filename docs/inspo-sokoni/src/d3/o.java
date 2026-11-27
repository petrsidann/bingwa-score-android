package d3;

import android.util.Base64;
import com.google.auto.value.AutoValue;

/* JADX INFO: loaded from: classes.dex */
@AutoValue
public abstract class o {

    @AutoValue.Builder
    public static abstract class a {
        public abstract o a();

        public abstract a b(String str);

        public abstract a c(byte[] bArr);

        public abstract a d(a3.e eVar);
    }

    public static a a() {
        return new d.b().d(a3.e.DEFAULT);
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract a3.e d();

    public boolean e() {
        return c() != null;
    }

    public o f(a3.e eVar) {
        return a().b(b()).d(eVar).c(c()).a();
    }

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = b();
        objArr[1] = d();
        objArr[2] = c() == null ? "" : Base64.encodeToString(c(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }
}
