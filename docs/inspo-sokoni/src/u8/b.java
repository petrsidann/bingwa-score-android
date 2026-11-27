package u8;

import com.google.android.gms.common.internal.p;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17037a;

    public b(String str) {
        this.f17037a = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return p.b(this.f17037a, ((b) obj).f17037a);
        }
        return false;
    }

    public int hashCode() {
        return p.c(this.f17037a);
    }

    public String toString() {
        return p.d(this).a("token", this.f17037a).toString();
    }
}
