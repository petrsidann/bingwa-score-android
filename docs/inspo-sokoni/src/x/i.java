package x;

import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f17913o = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f17915b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f17919f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f17923j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17916c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17917d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f17918e = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f17920g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float[] f17921h = new float[9];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float[] f17922i = new float[9];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b[] f17924k = new b[16];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f17925l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f17926m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public HashSet<b> f17927n = null;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.f17923j = aVar;
    }

    public static void b() {
        f17913o++;
    }

    public final void a(b bVar) {
        int i10 = 0;
        while (true) {
            int i11 = this.f17925l;
            if (i10 >= i11) {
                b[] bVarArr = this.f17924k;
                if (i11 >= bVarArr.length) {
                    this.f17924k = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f17924k;
                int i12 = this.f17925l;
                bVarArr2[i12] = bVar;
                this.f17925l = i12 + 1;
                return;
            }
            if (this.f17924k[i10] == bVar) {
                return;
            } else {
                i10++;
            }
        }
    }

    public final void c(b bVar) {
        int i10 = this.f17925l;
        int i11 = 0;
        while (i11 < i10) {
            if (this.f17924k[i11] == bVar) {
                while (i11 < i10 - 1) {
                    b[] bVarArr = this.f17924k;
                    int i12 = i11 + 1;
                    bVarArr[i11] = bVarArr[i12];
                    i11 = i12;
                }
                this.f17925l--;
                return;
            }
            i11++;
        }
    }

    public void d() {
        this.f17915b = null;
        this.f17923j = a.UNKNOWN;
        this.f17918e = 0;
        this.f17916c = -1;
        this.f17917d = -1;
        this.f17919f = 0.0f;
        this.f17920g = false;
        int i10 = this.f17925l;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f17924k[i11] = null;
        }
        this.f17925l = 0;
        this.f17926m = 0;
        this.f17914a = false;
        Arrays.fill(this.f17922i, 0.0f);
    }

    public void e(d dVar, float f10) {
        this.f17919f = f10;
        this.f17920g = true;
        int i10 = this.f17925l;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f17924k[i11].B(dVar, this, false);
        }
        this.f17925l = 0;
    }

    public void f(a aVar, String str) {
        this.f17923j = aVar;
    }

    public final void g(b bVar) {
        int i10 = this.f17925l;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f17924k[i11].C(bVar, false);
        }
        this.f17925l = 0;
    }

    public String toString() {
        StringBuilder sb2;
        if (this.f17915b != null) {
            sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(this.f17915b);
        } else {
            sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(this.f17916c);
        }
        return sb2.toString();
    }
}
