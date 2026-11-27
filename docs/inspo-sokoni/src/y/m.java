package y;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class m extends e {

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public ArrayList<e> f19252w0 = new ArrayList<>();

    public void K0() {
        ArrayList<e> arrayList = this.f19252w0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            e eVar = this.f19252w0.get(i10);
            if (eVar instanceof m) {
                ((m) eVar).K0();
            }
        }
    }

    public void L0(e eVar) {
        this.f19252w0.remove(eVar);
        eVar.w0(null);
    }

    public void M0() {
        this.f19252w0.clear();
    }

    @Override // y.e
    public void Y() {
        this.f19252w0.clear();
        super.Y();
    }

    @Override // y.e
    public void a0(x.c cVar) {
        super.a0(cVar);
        int size = this.f19252w0.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f19252w0.get(i10).a0(cVar);
        }
    }

    public void c(e eVar) {
        this.f19252w0.add(eVar);
        if (eVar.G() != null) {
            ((m) eVar.G()).L0(eVar);
        }
        eVar.w0(this);
    }
}
