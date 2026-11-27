package eb;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb.a<Object> f7736a;

    public r(ta.a aVar) {
        this.f7736a = new fb.a<>(aVar, "flutter/system", fb.e.f8282a);
    }

    public void a() {
        qa.b.f("SystemChannel", "Sending memory pressure warning to Flutter.");
        HashMap map = new HashMap(1);
        map.put("type", "memoryPressure");
        this.f7736a.c(map);
    }
}
