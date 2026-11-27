package j2;

/* JADX INFO: loaded from: classes.dex */
public abstract class h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11181a = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public static /* synthetic */ h b(a aVar, Object obj, String str, j jVar, g gVar, int i10, Object obj2) {
            if ((i10 & 2) != 0) {
                jVar = c.f11164a.a();
            }
            if ((i10 & 4) != 0) {
                gVar = j2.a.f11159a;
            }
            return aVar.a(obj, str, jVar, gVar);
        }

        public final <T> h<T> a(T t10, String tag, j verificationMode, g logger) {
            kotlin.jvm.internal.k.e(t10, "<this>");
            kotlin.jvm.internal.k.e(tag, "tag");
            kotlin.jvm.internal.k.e(verificationMode, "verificationMode");
            kotlin.jvm.internal.k.e(logger, "logger");
            return new i(t10, tag, verificationMode, logger);
        }
    }

    public abstract T a();

    public final String b(Object value, String message) {
        kotlin.jvm.internal.k.e(value, "value");
        kotlin.jvm.internal.k.e(message, "message");
        return message + " value: " + value;
    }

    public abstract h<T> c(String str, xc.l<? super T, Boolean> lVar);
}
