package z;

/* JADX INFO: loaded from: classes.dex */
public class h extends m {
    public h(y.e eVar) {
        super(eVar);
        eVar.f19165e.f();
        eVar.f19167f.f();
        this.f19721f = ((y.h) eVar).K0();
    }

    @Override // z.m, z.d
    public void a(d dVar) {
        f fVar = this.f19723h;
        if (fVar.f19683c && !fVar.f19690j) {
            this.f19723h.d((int) ((fVar.f19692l.get(0).f19687g * ((y.h) this.f19717b).N0()) + 0.5f));
        }
    }

    @Override // z.m
    public void d() {
        f fVar;
        m mVar;
        f fVar2;
        y.h hVar = (y.h) this.f19717b;
        int iL0 = hVar.L0();
        int iM0 = hVar.M0();
        hVar.N0();
        if (hVar.K0() == 1) {
            f fVar3 = this.f19723h;
            if (iL0 != -1) {
                fVar3.f19692l.add(this.f19717b.N.f19165e.f19723h);
                this.f19717b.N.f19165e.f19723h.f19691k.add(this.f19723h);
                fVar2 = this.f19723h;
            } else {
                if (iM0 != -1) {
                    fVar3.f19692l.add(this.f19717b.N.f19165e.f19724i);
                    this.f19717b.N.f19165e.f19724i.f19691k.add(this.f19723h);
                    fVar2 = this.f19723h;
                    iL0 = -iM0;
                } else {
                    fVar3.f19682b = true;
                    fVar3.f19692l.add(this.f19717b.N.f19165e.f19724i);
                    this.f19717b.N.f19165e.f19724i.f19691k.add(this.f19723h);
                }
                q(this.f19717b.f19165e.f19723h);
                mVar = this.f19717b.f19165e;
            }
            fVar2.f19686f = iL0;
            q(this.f19717b.f19165e.f19723h);
            mVar = this.f19717b.f19165e;
        } else {
            f fVar4 = this.f19723h;
            if (iL0 != -1) {
                fVar4.f19692l.add(this.f19717b.N.f19167f.f19723h);
                this.f19717b.N.f19167f.f19723h.f19691k.add(this.f19723h);
                fVar = this.f19723h;
            } else {
                if (iM0 != -1) {
                    fVar4.f19692l.add(this.f19717b.N.f19167f.f19724i);
                    this.f19717b.N.f19167f.f19724i.f19691k.add(this.f19723h);
                    fVar = this.f19723h;
                    iL0 = -iM0;
                } else {
                    fVar4.f19682b = true;
                    fVar4.f19692l.add(this.f19717b.N.f19167f.f19724i);
                    this.f19717b.N.f19167f.f19724i.f19691k.add(this.f19723h);
                }
                q(this.f19717b.f19167f.f19723h);
                mVar = this.f19717b.f19167f;
            }
            fVar.f19686f = iL0;
            q(this.f19717b.f19167f.f19723h);
            mVar = this.f19717b.f19167f;
        }
        q(mVar.f19724i);
    }

    @Override // z.m
    public void e() {
        if (((y.h) this.f19717b).K0() == 1) {
            this.f19717b.F0(this.f19723h.f19687g);
        } else {
            this.f19717b.G0(this.f19723h.f19687g);
        }
    }

    @Override // z.m
    public void f() {
        this.f19723h.c();
    }

    @Override // z.m
    public boolean m() {
        return false;
    }

    public final void q(f fVar) {
        this.f19723h.f19691k.add(fVar);
        fVar.f19692l.add(this.f19723h);
    }
}
