package d8;

import h8.k;
import h8.r;

/* JADX INFO: loaded from: classes.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r f6476a;

    public b(r rVar) {
        this.f6476a = rVar;
    }

    public r a() {
        return this.f6476a;
    }

    public k b() {
        return this.f6476a.getKey();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f6476a.equals(((b) obj).f6476a);
    }

    public int hashCode() {
        return this.f6476a.hashCode();
    }
}
