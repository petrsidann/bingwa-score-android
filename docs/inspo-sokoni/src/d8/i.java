package d8;

import e8.b1;
import e8.g1;

/* JADX INFO: loaded from: classes.dex */
public class i implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g1 f6502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b1.a f6503b;

    public i(g1 g1Var, b1.a aVar) {
        this.f6502a = g1Var;
        this.f6503b = aVar;
    }

    public b1.a a() {
        return this.f6503b;
    }

    public g1 b() {
        return this.f6502a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f6502a.equals(iVar.f6502a) && this.f6503b == iVar.f6503b;
    }

    public int hashCode() {
        return (this.f6502a.hashCode() * 31) + this.f6503b.hashCode();
    }
}
