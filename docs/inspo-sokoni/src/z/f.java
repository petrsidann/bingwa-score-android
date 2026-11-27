package z;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m f19684d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f19686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f19687g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f19681a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f19682b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f19683c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f19685e = a.UNKNOWN;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f19688h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g f19689i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f19690j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<d> f19691k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<f> f19692l = new ArrayList();

    public enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public f(m mVar) {
        this.f19684d = mVar;
    }

    @Override // z.d
    public void a(d dVar) {
        Iterator<f> it = this.f19692l.iterator();
        while (it.hasNext()) {
            if (!it.next().f19690j) {
                return;
            }
        }
        this.f19683c = true;
        d dVar2 = this.f19681a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.f19682b) {
            this.f19684d.a(this);
            return;
        }
        f fVar = null;
        int i10 = 0;
        for (f fVar2 : this.f19692l) {
            if (!(fVar2 instanceof g)) {
                i10++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i10 == 1 && fVar.f19690j) {
            g gVar = this.f19689i;
            if (gVar != null) {
                if (!gVar.f19690j) {
                    return;
                } else {
                    this.f19686f = this.f19688h * gVar.f19687g;
                }
            }
            d(fVar.f19687g + this.f19686f);
        }
        d dVar3 = this.f19681a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b(d dVar) {
        this.f19691k.add(dVar);
        if (this.f19690j) {
            dVar.a(dVar);
        }
    }

    public void c() {
        this.f19692l.clear();
        this.f19691k.clear();
        this.f19690j = false;
        this.f19687g = 0;
        this.f19683c = false;
        this.f19682b = false;
    }

    public void d(int i10) {
        if (this.f19690j) {
            return;
        }
        this.f19690j = true;
        this.f19687g = i10;
        for (d dVar : this.f19691k) {
            dVar.a(dVar);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f19684d.f19717b.r());
        sb2.append(":");
        sb2.append(this.f19685e);
        sb2.append("(");
        sb2.append(this.f19690j ? Integer.valueOf(this.f19687g) : "unresolved");
        sb2.append(") <t=");
        sb2.append(this.f19692l.size());
        sb2.append(":d=");
        sb2.append(this.f19691k.size());
        sb2.append(">");
        return sb2.toString();
    }
}
