package sa;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f15667b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, io.flutter.embedding.engine.a> f15668a = new HashMap();

    public static a b() {
        if (f15667b == null) {
            f15667b = new a();
        }
        return f15667b;
    }

    public io.flutter.embedding.engine.a a(String str) {
        return this.f15668a.get(str);
    }

    public void c(String str, io.flutter.embedding.engine.a aVar) {
        if (aVar != null) {
            this.f15668a.put(str, aVar);
        } else {
            this.f15668a.remove(str);
        }
    }

    public void d(String str) {
        c(str, null);
    }
}
