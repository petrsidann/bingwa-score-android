package d8;

import h8.k;
import h8.v;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f6498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f6499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f6501d;

    public h(k kVar, v vVar, boolean z10, List<String> list) {
        this.f6498a = kVar;
        this.f6499b = vVar;
        this.f6500c = z10;
        this.f6501d = list;
    }

    public boolean a() {
        return this.f6500c;
    }

    public k b() {
        return this.f6498a;
    }

    public List<String> c() {
        return this.f6501d;
    }

    public v d() {
        return this.f6499b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f6500c == hVar.f6500c && this.f6498a.equals(hVar.f6498a) && this.f6499b.equals(hVar.f6499b)) {
            return this.f6501d.equals(hVar.f6501d);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f6498a.hashCode() * 31) + this.f6499b.hashCode()) * 31) + (this.f6500c ? 1 : 0)) * 31) + this.f6501d.hashCode();
    }
}
