package x;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class h extends x.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f17903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i[] f17904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public i[] f17905i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f17906j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f17907k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f17908l;

    public class a implements Comparator<i> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(i iVar, i iVar2) {
            return iVar.f17916c - iVar2.f17916c;
        }
    }

    public class b implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i f17910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h f17911b;

        public b(h hVar) {
            this.f17911b = hVar;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.f17910a.f17916c - ((i) obj).f17916c;
        }

        public boolean d(i iVar, float f10) {
            boolean z10 = true;
            if (!this.f17910a.f17914a) {
                for (int i10 = 0; i10 < 9; i10++) {
                    float f11 = iVar.f17922i[i10];
                    if (f11 != 0.0f) {
                        float f12 = f11 * f10;
                        if (Math.abs(f12) < 1.0E-4f) {
                            f12 = 0.0f;
                        }
                        this.f17910a.f17922i[i10] = f12;
                    } else {
                        this.f17910a.f17922i[i10] = 0.0f;
                    }
                }
                return true;
            }
            for (int i11 = 0; i11 < 9; i11++) {
                float[] fArr = this.f17910a.f17922i;
                float f13 = fArr[i11] + (iVar.f17922i[i11] * f10);
                fArr[i11] = f13;
                if (Math.abs(f13) < 1.0E-4f) {
                    this.f17910a.f17922i[i11] = 0.0f;
                } else {
                    z10 = false;
                }
            }
            if (z10) {
                h.this.G(this.f17910a);
            }
            return false;
        }

        public void h(i iVar) {
            this.f17910a = iVar;
        }

        public final boolean i() {
            for (int i10 = 8; i10 >= 0; i10--) {
                float f10 = this.f17910a.f17922i[i10];
                if (f10 > 0.0f) {
                    return false;
                }
                if (f10 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean k(i iVar) {
            for (int i10 = 8; i10 >= 0; i10--) {
                float f10 = iVar.f17922i[i10];
                float f11 = this.f17910a.f17922i[i10];
                if (f11 != f10) {
                    if (f11 < f10) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void l() {
            Arrays.fill(this.f17910a.f17922i, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f17910a != null) {
                for (int i10 = 0; i10 < 9; i10++) {
                    str = str + this.f17910a.f17922i[i10] + " ";
                }
            }
            return str + "] " + this.f17910a;
        }
    }

    public h(c cVar) {
        super(cVar);
        this.f17903g = 128;
        this.f17904h = new i[128];
        this.f17905i = new i[128];
        this.f17906j = 0;
        this.f17907k = new b(this);
        this.f17908l = cVar;
    }

    @Override // x.b
    public void C(x.b bVar, boolean z10) {
        i iVar = bVar.f17870a;
        if (iVar == null) {
            return;
        }
        x.b.a aVar = bVar.f17874e;
        int iB = aVar.b();
        for (int i10 = 0; i10 < iB; i10++) {
            i iVarD = aVar.d(i10);
            float f10 = aVar.f(i10);
            this.f17907k.h(iVarD);
            if (this.f17907k.d(iVar, f10)) {
                F(iVarD);
            }
            this.f17871b += bVar.f17871b * f10;
        }
        G(iVar);
    }

    public final void F(i iVar) {
        int i10;
        int i11 = this.f17906j + 1;
        i[] iVarArr = this.f17904h;
        if (i11 > iVarArr.length) {
            i[] iVarArr2 = (i[]) Arrays.copyOf(iVarArr, iVarArr.length * 2);
            this.f17904h = iVarArr2;
            this.f17905i = (i[]) Arrays.copyOf(iVarArr2, iVarArr2.length * 2);
        }
        i[] iVarArr3 = this.f17904h;
        int i12 = this.f17906j;
        iVarArr3[i12] = iVar;
        int i13 = i12 + 1;
        this.f17906j = i13;
        if (i13 > 1 && iVarArr3[i13 - 1].f17916c > iVar.f17916c) {
            int i14 = 0;
            while (true) {
                i10 = this.f17906j;
                if (i14 >= i10) {
                    break;
                }
                this.f17905i[i14] = this.f17904h[i14];
                i14++;
            }
            Arrays.sort(this.f17905i, 0, i10, new a());
            for (int i15 = 0; i15 < this.f17906j; i15++) {
                this.f17904h[i15] = this.f17905i[i15];
            }
        }
        iVar.f17914a = true;
        iVar.a(this);
    }

    public final void G(i iVar) {
        int i10 = 0;
        while (i10 < this.f17906j) {
            if (this.f17904h[i10] == iVar) {
                while (true) {
                    int i11 = this.f17906j;
                    if (i10 >= i11 - 1) {
                        this.f17906j = i11 - 1;
                        iVar.f17914a = false;
                        return;
                    } else {
                        i[] iVarArr = this.f17904h;
                        int i12 = i10 + 1;
                        iVarArr[i10] = iVarArr[i12];
                        i10 = i12;
                    }
                }
            } else {
                i10++;
            }
        }
    }

    @Override // x.b, x.d.a
    public void b(i iVar) {
        this.f17907k.h(iVar);
        this.f17907k.l();
        iVar.f17922i[iVar.f17918e] = 1.0f;
        F(iVar);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002c  */
    @Override // x.b, x.d.a
    public i c(d dVar, boolean[] zArr) {
        int i10 = -1;
        for (int i11 = 0; i11 < this.f17906j; i11++) {
            i iVar = this.f17904h[i11];
            if (!zArr[iVar.f17916c]) {
                this.f17907k.h(iVar);
                b bVar = this.f17907k;
                if (i10 == -1) {
                    if (bVar.i()) {
                        i10 = i11;
                    }
                } else if (bVar.k(this.f17904h[i10])) {
                    i10 = i11;
                }
            }
        }
        if (i10 == -1) {
            return null;
        }
        return this.f17904h[i10];
    }

    @Override // x.b, x.d.a
    public void clear() {
        this.f17906j = 0;
        this.f17871b = 0.0f;
    }

    @Override // x.b
    public String toString() {
        String str = " goal -> (" + this.f17871b + ") : ";
        for (int i10 = 0; i10 < this.f17906j; i10++) {
            this.f17907k.h(this.f17904h[i10]);
            str = str + this.f17907k + " ";
        }
        return str;
    }
}
