package y;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class j extends e implements i {

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public e[] f19247w0 = new e[4];

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f19248x0 = 0;

    @Override // y.i
    public void a(f fVar) {
    }

    @Override // y.i
    public void b() {
        this.f19248x0 = 0;
        Arrays.fill(this.f19247w0, (Object) null);
    }

    @Override // y.i
    public void c(e eVar) {
        if (eVar == this || eVar == null) {
            return;
        }
        int i10 = this.f19248x0 + 1;
        e[] eVarArr = this.f19247w0;
        if (i10 > eVarArr.length) {
            this.f19247w0 = (e[]) Arrays.copyOf(eVarArr, eVarArr.length * 2);
        }
        e[] eVarArr2 = this.f19247w0;
        int i11 = this.f19248x0;
        eVarArr2[i11] = eVar;
        this.f19248x0 = i11 + 1;
    }
}
