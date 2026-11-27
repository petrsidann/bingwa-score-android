package z;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class i extends m {
    public i(y.e eVar) {
        super(eVar);
    }

    @Override // z.m, z.d
    public void a(d dVar) {
        y.a aVar = (y.a) this.f19717b;
        int iL0 = aVar.L0();
        Iterator<f> it = this.f19723h.f19692l.iterator();
        int i10 = 0;
        int i11 = -1;
        while (it.hasNext()) {
            int i12 = it.next().f19687g;
            if (i11 == -1 || i12 < i11) {
                i11 = i12;
            }
            if (i10 < i12) {
                i10 = i12;
            }
        }
        if (iL0 == 0 || iL0 == 2) {
            this.f19723h.d(i11 + aVar.M0());
        } else {
            this.f19723h.d(i10 + aVar.M0());
        }
    }

    @Override // z.m
    public void d() {
        m mVar;
        y.e eVar = this.f19717b;
        if (eVar instanceof y.a) {
            this.f19723h.f19682b = true;
            y.a aVar = (y.a) eVar;
            int iL0 = aVar.L0();
            boolean zK0 = aVar.K0();
            int i10 = 0;
            if (iL0 != 0) {
                if (iL0 != 1) {
                    if (iL0 == 2) {
                        this.f19723h.f19685e = f.a.TOP;
                        while (i10 < aVar.f19248x0) {
                            y.e eVar2 = aVar.f19247w0[i10];
                            if (zK0 || eVar2.O() != 8) {
                                f fVar = eVar2.f19167f.f19723h;
                                fVar.f19691k.add(this.f19723h);
                                this.f19723h.f19692l.add(fVar);
                            }
                            i10++;
                        }
                    } else {
                        if (iL0 != 3) {
                            return;
                        }
                        this.f19723h.f19685e = f.a.BOTTOM;
                        while (i10 < aVar.f19248x0) {
                            y.e eVar3 = aVar.f19247w0[i10];
                            if (zK0 || eVar3.O() != 8) {
                                f fVar2 = eVar3.f19167f.f19724i;
                                fVar2.f19691k.add(this.f19723h);
                                this.f19723h.f19692l.add(fVar2);
                            }
                            i10++;
                        }
                    }
                    q(this.f19717b.f19167f.f19723h);
                    mVar = this.f19717b.f19167f;
                } else {
                    this.f19723h.f19685e = f.a.RIGHT;
                    while (i10 < aVar.f19248x0) {
                        y.e eVar4 = aVar.f19247w0[i10];
                        if (zK0 || eVar4.O() != 8) {
                            f fVar3 = eVar4.f19165e.f19724i;
                            fVar3.f19691k.add(this.f19723h);
                            this.f19723h.f19692l.add(fVar3);
                        }
                        i10++;
                    }
                }
                q(mVar.f19724i);
            }
            this.f19723h.f19685e = f.a.LEFT;
            while (i10 < aVar.f19248x0) {
                y.e eVar5 = aVar.f19247w0[i10];
                if (zK0 || eVar5.O() != 8) {
                    f fVar4 = eVar5.f19165e.f19723h;
                    fVar4.f19691k.add(this.f19723h);
                    this.f19723h.f19692l.add(fVar4);
                }
                i10++;
            }
            q(this.f19717b.f19165e.f19723h);
            mVar = this.f19717b.f19165e;
            q(mVar.f19724i);
        }
    }

    @Override // z.m
    public void e() {
        y.e eVar = this.f19717b;
        if (eVar instanceof y.a) {
            int iL0 = ((y.a) eVar).L0();
            if (iL0 == 0 || iL0 == 1) {
                this.f19717b.F0(this.f19723h.f19687g);
            } else {
                this.f19717b.G0(this.f19723h.f19687g);
            }
        }
    }

    @Override // z.m
    public void f() {
        this.f19718c = null;
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
