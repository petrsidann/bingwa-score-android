package sa;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile c f15695b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, io.flutter.embedding.engine.b> f15696a = new HashMap();

    public static c b() {
        if (f15695b == null) {
            synchronized (c.class) {
                if (f15695b == null) {
                    f15695b = new c();
                }
            }
        }
        return f15695b;
    }

    public io.flutter.embedding.engine.b a(String str) {
        return this.f15696a.get(str);
    }
}
