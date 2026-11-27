package e9;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class n extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g9.h<String, k> f7446a = new g9.h<>(false);

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof n) && ((n) obj).f7446a.equals(this.f7446a));
    }

    public int hashCode() {
        return this.f7446a.hashCode();
    }

    public void r(String str, k kVar) {
        g9.h<String, k> hVar = this.f7446a;
        if (kVar == null) {
            kVar = m.f7445a;
        }
        hVar.put(str, kVar);
    }

    public Set<Map.Entry<String, k>> s() {
        return this.f7446a.entrySet();
    }

    public boolean t(String str) {
        return this.f7446a.containsKey(str);
    }

    public k v(String str) {
        return this.f7446a.remove(str);
    }
}
