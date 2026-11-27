package bd;

import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends bd.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f3069e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f3070f = new c(1, 0);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public c(char c10, char c11) {
        super(c10, c11, 1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (e() != cVar.e() || h() != cVar.h()) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (e() * 31) + h();
    }

    public boolean isEmpty() {
        return k.f(e(), h()) > 0;
    }

    public String toString() {
        return e() + ".." + h();
    }
}
