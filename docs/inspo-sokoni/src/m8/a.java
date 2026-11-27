package m8;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f12969b;

    public a(String str, List<String> list) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.f12968a = str;
        if (list == null) {
            throw new NullPointerException("Null usedDates");
        }
        this.f12969b = list;
    }

    @Override // m8.l
    public List<String> b() {
        return this.f12969b;
    }

    @Override // m8.l
    public String c() {
        return this.f12968a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f12968a.equals(lVar.c()) && this.f12969b.equals(lVar.b());
    }

    public int hashCode() {
        return ((this.f12968a.hashCode() ^ 1000003) * 1000003) ^ this.f12969b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.f12968a + ", usedDates=" + this.f12969b + "}";
    }
}
