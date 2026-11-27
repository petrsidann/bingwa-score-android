package i8;

import h8.r;
import h8.v;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f10544c = new m(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f10545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f10546b;

    public m(v vVar, Boolean bool) {
        l8.b.d(vVar == null || bool == null, "Precondition can specify \"exists\" or \"updateTime\" but not both", new Object[0]);
        this.f10545a = vVar;
        this.f10546b = bool;
    }

    public static m a(boolean z10) {
        return new m(null, Boolean.valueOf(z10));
    }

    public static m f(v vVar) {
        return new m(vVar, null);
    }

    public Boolean b() {
        return this.f10546b;
    }

    public v c() {
        return this.f10545a;
    }

    public boolean d() {
        return this.f10545a == null && this.f10546b == null;
    }

    public boolean e(r rVar) {
        if (this.f10545a != null) {
            return rVar.c() && rVar.m().equals(this.f10545a);
        }
        Boolean bool = this.f10546b;
        if (bool != null) {
            return bool.booleanValue() == rVar.c();
        }
        l8.b.d(d(), "Precondition should be empty", new Object[0]);
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        v vVar = this.f10545a;
        if (vVar == null ? mVar.f10545a != null : !vVar.equals(mVar.f10545a)) {
            return false;
        }
        Boolean bool = this.f10546b;
        Boolean bool2 = mVar.f10546b;
        if (bool != null) {
            return bool.equals(bool2);
        }
        return bool2 == null;
    }

    public int hashCode() {
        v vVar = this.f10545a;
        int iHashCode = (vVar != null ? vVar.hashCode() : 0) * 31;
        Boolean bool = this.f10546b;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb2;
        Object obj;
        if (d()) {
            return "Precondition{<none>}";
        }
        if (this.f10545a != null) {
            sb2 = new StringBuilder();
            sb2.append("Precondition{updateTime=");
            obj = this.f10545a;
        } else {
            if (this.f10546b == null) {
                throw l8.b.a("Invalid Precondition", new Object[0]);
            }
            sb2 = new StringBuilder();
            sb2.append("Precondition{exists=");
            obj = this.f10546b;
        }
        sb2.append(obj);
        sb2.append("}");
        return sb2.toString();
    }
}
