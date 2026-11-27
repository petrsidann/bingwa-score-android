package ed;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    public static final <T> void a(Appendable appendable, T t10, xc.l<? super T, ? extends CharSequence> lVar) {
        CharSequence string;
        kotlin.jvm.internal.k.e(appendable, "<this>");
        if (lVar == null) {
            if (!(t10 == 0 ? true : t10 instanceof CharSequence)) {
                if (t10 instanceof Character) {
                    appendable.append(((Character) t10).charValue());
                    return;
                }
                string = t10.toString();
            }
            appendable.append(string);
        }
        t10 = (T) lVar.invoke(t10);
        string = (CharSequence) t10;
        appendable.append(string);
    }
}
