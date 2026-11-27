package e8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b1 f7366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h8.m f7367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h8.m f7368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<m> f7369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f7370e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s7.e<h8.k> f7371f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f7372g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7373h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7374i;

    public enum a {
        NONE,
        LOCAL,
        SYNCED
    }

    public y1(b1 b1Var, h8.m mVar, h8.m mVar2, List<m> list, boolean z10, s7.e<h8.k> eVar, boolean z11, boolean z12, boolean z13) {
        this.f7366a = b1Var;
        this.f7367b = mVar;
        this.f7368c = mVar2;
        this.f7369d = list;
        this.f7370e = z10;
        this.f7371f = eVar;
        this.f7372g = z11;
        this.f7373h = z12;
        this.f7374i = z13;
    }

    public static y1 c(b1 b1Var, h8.m mVar, s7.e<h8.k> eVar, boolean z10, boolean z11, boolean z12) {
        ArrayList arrayList = new ArrayList();
        Iterator<h8.h> it = mVar.iterator();
        while (it.hasNext()) {
            arrayList.add(m.a(m.a.ADDED, it.next()));
        }
        return new y1(b1Var, mVar, h8.m.i(b1Var.c()), arrayList, z10, eVar, true, z11, z12);
    }

    public boolean a() {
        return this.f7372g;
    }

    public boolean b() {
        return this.f7373h;
    }

    public List<m> d() {
        return this.f7369d;
    }

    public h8.m e() {
        return this.f7367b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y1)) {
            return false;
        }
        y1 y1Var = (y1) obj;
        if (this.f7370e == y1Var.f7370e && this.f7372g == y1Var.f7372g && this.f7373h == y1Var.f7373h && this.f7366a.equals(y1Var.f7366a) && this.f7371f.equals(y1Var.f7371f) && this.f7367b.equals(y1Var.f7367b) && this.f7368c.equals(y1Var.f7368c) && this.f7374i == y1Var.f7374i) {
            return this.f7369d.equals(y1Var.f7369d);
        }
        return false;
    }

    public s7.e<h8.k> f() {
        return this.f7371f;
    }

    public h8.m g() {
        return this.f7368c;
    }

    public b1 h() {
        return this.f7366a;
    }

    public int hashCode() {
        return (((((((((((((((this.f7366a.hashCode() * 31) + this.f7367b.hashCode()) * 31) + this.f7368c.hashCode()) * 31) + this.f7369d.hashCode()) * 31) + this.f7371f.hashCode()) * 31) + (this.f7370e ? 1 : 0)) * 31) + (this.f7372g ? 1 : 0)) * 31) + (this.f7373h ? 1 : 0)) * 31) + (this.f7374i ? 1 : 0);
    }

    public boolean i() {
        return this.f7374i;
    }

    public boolean j() {
        return !this.f7371f.isEmpty();
    }

    public boolean k() {
        return this.f7370e;
    }

    public String toString() {
        return "ViewSnapshot(" + this.f7366a + ", " + this.f7367b + ", " + this.f7368c + ", " + this.f7369d + ", isFromCache=" + this.f7370e + ", mutatedKeys=" + this.f7371f.size() + ", didSyncStateChange=" + this.f7372g + ", excludesMetadataChanges=" + this.f7373h + ", hasCachedResults=" + this.f7374i + ")";
    }
}
