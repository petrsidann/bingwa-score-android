package e9;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class x<T> {

    public class a extends x<T> {
        public a() {
        }

        @Override // e9.x
        public T c(m9.a aVar) throws IOException {
            if (aVar.l0() != m9.b.NULL) {
                return (T) x.this.c(aVar);
            }
            aVar.h0();
            return null;
        }

        @Override // e9.x
        public void e(m9.c cVar, T t10) throws IOException {
            if (t10 == null) {
                cVar.L();
            } else {
                x.this.e(cVar, t10);
            }
        }
    }

    public final T a(k kVar) {
        try {
            return c(new h9.f(kVar));
        } catch (IOException e10) {
            throw new l(e10);
        }
    }

    public final x<T> b() {
        return new a();
    }

    public abstract T c(m9.a aVar);

    public final k d(T t10) {
        try {
            h9.g gVar = new h9.g();
            e(gVar, t10);
            return gVar.q0();
        } catch (IOException e10) {
            throw new l(e10);
        }
    }

    public abstract void e(m9.c cVar, T t10);
}
