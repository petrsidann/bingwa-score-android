package g8;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class s0 implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, d8.e> f8944a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, d8.j> f8945b = new HashMap();

    @Override // g8.a
    public d8.e a(String str) {
        return this.f8944a.get(str);
    }

    @Override // g8.a
    public void b(d8.e eVar) {
        this.f8944a.put(eVar.a(), eVar);
    }

    @Override // g8.a
    public d8.j c(String str) {
        return this.f8945b.get(str);
    }

    @Override // g8.a
    public void d(d8.j jVar) {
        this.f8945b.put(jVar.b(), jVar);
    }
}
