package i8;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d f10523b = b(new HashSet());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<h8.q> f10524a;

    public d(Set<h8.q> set) {
        this.f10524a = set;
    }

    public static d b(Set<h8.q> set) {
        return new d(set);
    }

    public boolean a(h8.q qVar) {
        Iterator<h8.q> it = this.f10524a.iterator();
        while (it.hasNext()) {
            if (it.next().t(qVar)) {
                return true;
            }
        }
        return false;
    }

    public Set<h8.q> c() {
        return this.f10524a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        return this.f10524a.equals(((d) obj).f10524a);
    }

    public int hashCode() {
        return this.f10524a.hashCode();
    }

    public String toString() {
        return "FieldMask{mask=" + this.f10524a.toString() + "}";
    }
}
