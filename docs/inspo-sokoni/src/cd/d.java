package cd;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T a(c<T> cVar, Object obj) {
        kotlin.jvm.internal.k.e(cVar, "<this>");
        if (cVar.c(obj)) {
            kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
            return obj;
        }
        throw new ClassCastException("Value cannot be cast to " + cVar.a());
    }
}
