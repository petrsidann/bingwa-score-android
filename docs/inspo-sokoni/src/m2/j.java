package m2;

import java.util.List;
import mc.w;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f12944a;

    /* JADX WARN: Multi-variable type inference failed */
    public j(List<? extends a> displayFeatures) {
        kotlin.jvm.internal.k.e(displayFeatures, "displayFeatures");
        this.f12944a = displayFeatures;
    }

    public final List<a> a() {
        return this.f12944a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !kotlin.jvm.internal.k.a(j.class, obj.getClass())) {
            return false;
        }
        return kotlin.jvm.internal.k.a(this.f12944a, ((j) obj).f12944a);
    }

    public int hashCode() {
        return this.f12944a.hashCode();
    }

    public String toString() {
        return w.A(this.f12944a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, null, null, 56, null);
    }
}
