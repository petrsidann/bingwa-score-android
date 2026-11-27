package d8;

import h8.v;

/* JADX INFO: loaded from: classes.dex */
public class j implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f6505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f6506c;

    public j(String str, i iVar, v vVar) {
        this.f6504a = str;
        this.f6505b = iVar;
        this.f6506c = vVar;
    }

    public i a() {
        return this.f6505b;
    }

    public String b() {
        return this.f6504a;
    }

    public v c() {
        return this.f6506c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f6504a.equals(jVar.f6504a) && this.f6505b.equals(jVar.f6505b)) {
            return this.f6506c.equals(jVar.f6506c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f6504a.hashCode() * 31) + this.f6505b.hashCode()) * 31) + this.f6506c.hashCode();
    }
}
