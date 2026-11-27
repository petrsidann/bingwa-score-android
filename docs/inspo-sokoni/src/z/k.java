package z;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f19705h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f19708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m f19709d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f19711f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f19712g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19706a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f19707b = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<m> f19710e = new ArrayList<>();

    public k(m mVar, int i10) {
        this.f19708c = null;
        this.f19709d = null;
        int i11 = f19705h;
        this.f19711f = i11;
        f19705h = i11 + 1;
        this.f19708c = mVar;
        this.f19709d = mVar;
        this.f19712g = i10;
    }

    public void a(m mVar) {
        this.f19710e.add(mVar);
        this.f19709d = mVar;
    }

    public long b(y.f fVar, int i10) {
        long j10;
        m mVar;
        long j11;
        long jD;
        m mVar2 = this.f19708c;
        if (mVar2 instanceof c) {
            if (((c) mVar2).f19721f != i10) {
                return 0L;
            }
        } else if (i10 == 0) {
            if (!(mVar2 instanceof j)) {
                return 0L;
            }
        } else if (!(mVar2 instanceof l)) {
            return 0L;
        }
        f fVar2 = (i10 == 0 ? fVar.f19165e : fVar.f19167f).f19723h;
        f fVar3 = (i10 == 0 ? fVar.f19165e : fVar.f19167f).f19724i;
        boolean zContains = mVar2.f19723h.f19692l.contains(fVar2);
        boolean zContains2 = this.f19708c.f19724i.f19692l.contains(fVar3);
        long j12 = this.f19708c.j();
        if (!zContains || !zContains2) {
            if (zContains) {
                f fVar4 = this.f19708c.f19723h;
                jD = d(fVar4, fVar4.f19686f);
                j11 = ((long) this.f19708c.f19723h.f19686f) + j12;
            } else if (zContains2) {
                f fVar5 = this.f19708c.f19724i;
                long jC = c(fVar5, fVar5.f19686f);
                j11 = ((long) (-this.f19708c.f19724i.f19686f)) + j12;
                jD = -jC;
            } else {
                m mVar3 = this.f19708c;
                j10 = ((long) mVar3.f19723h.f19686f) + mVar3.j();
                mVar = this.f19708c;
            }
            return Math.max(jD, j11);
        }
        long jD2 = d(this.f19708c.f19723h, 0L);
        long jC2 = c(this.f19708c.f19724i, 0L);
        long j13 = jD2 - j12;
        m mVar4 = this.f19708c;
        int i11 = mVar4.f19724i.f19686f;
        if (j13 >= (-i11)) {
            j13 += (long) i11;
        }
        int i12 = mVar4.f19723h.f19686f;
        long j14 = ((-jC2) - j12) - ((long) i12);
        if (j14 >= i12) {
            j14 -= (long) i12;
        }
        float fO = mVar4.f19717b.o(i10);
        float f10 = fO > 0.0f ? (long) ((j14 / fO) + (j13 / (1.0f - fO))) : 0L;
        long j15 = ((long) ((f10 * fO) + 0.5f)) + j12 + ((long) ((f10 * (1.0f - fO)) + 0.5f));
        mVar = this.f19708c;
        j10 = ((long) mVar.f19723h.f19686f) + j15;
        return j10 - ((long) mVar.f19724i.f19686f);
    }

    public final long c(f fVar, long j10) {
        m mVar = fVar.f19684d;
        if (mVar instanceof i) {
            return j10;
        }
        int size = fVar.f19691k.size();
        long jMin = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = fVar.f19691k.get(i10);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f19684d != mVar) {
                    jMin = Math.min(jMin, c(fVar2, ((long) fVar2.f19686f) + j10));
                }
            }
        }
        if (fVar != mVar.f19724i) {
            return jMin;
        }
        long j11 = j10 - mVar.j();
        return Math.min(Math.min(jMin, c(mVar.f19723h, j11)), j11 - ((long) mVar.f19723h.f19686f));
    }

    public final long d(f fVar, long j10) {
        m mVar = fVar.f19684d;
        if (mVar instanceof i) {
            return j10;
        }
        int size = fVar.f19691k.size();
        long jMax = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = fVar.f19691k.get(i10);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f19684d != mVar) {
                    jMax = Math.max(jMax, d(fVar2, ((long) fVar2.f19686f) + j10));
                }
            }
        }
        if (fVar != mVar.f19723h) {
            return jMax;
        }
        long j11 = j10 + mVar.j();
        return Math.max(Math.max(jMax, d(mVar.f19724i, j11)), j11 - ((long) mVar.f19724i.f19686f));
    }
}
