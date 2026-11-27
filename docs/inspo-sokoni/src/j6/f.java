package j6;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11267a;

    public class a extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f11268b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, String str) {
            super(fVar, null);
            this.f11268b = str;
        }

        @Override // j6.f
        public CharSequence g(Object obj) {
            return obj == null ? this.f11268b : f.this.g(obj);
        }

        @Override // j6.f
        public f h(String str) {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    public f(f fVar) {
        this.f11267a = fVar.f11267a;
    }

    public /* synthetic */ f(f fVar, a aVar) {
        this(fVar);
    }

    public f(String str) {
        this.f11267a = (String) m.o(str);
    }

    public static f e(char c10) {
        return new f(String.valueOf(c10));
    }

    public static f f(String str) {
        return new f(str);
    }

    public <A extends Appendable> A a(A a10, Iterator<? extends Object> it) throws IOException {
        m.o(a10);
        if (it.hasNext()) {
            while (true) {
                a10.append(g(it.next()));
                if (!it.hasNext()) {
                    break;
                }
                a10.append(this.f11267a);
            }
        }
        return a10;
    }

    public final StringBuilder b(StringBuilder sb2, Iterator<? extends Object> it) {
        try {
            a(sb2, it);
            return sb2;
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    public final String c(Iterable<? extends Object> iterable) {
        return d(iterable.iterator());
    }

    public final String d(Iterator<? extends Object> it) {
        return b(new StringBuilder(), it).toString();
    }

    public CharSequence g(Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public f h(String str) {
        m.o(str);
        return new a(this, str);
    }
}
