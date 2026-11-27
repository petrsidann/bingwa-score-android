package ed;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements dd.b<bd.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f7910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xc.p<CharSequence, Integer, lc.i<Integer, Integer>> f7913d;

    public static final class a implements Iterator<bd.f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7914a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7916c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public bd.f f7917d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7918e;

        public a() {
            int iE = bd.h.e(d.this.f7911b, 0, d.this.f7910a.length());
            this.f7915b = iE;
            this.f7916c = iE;
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0031 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:19:0x0094  */
        /* JADX WARN: Code duplicated, block: B:9:0x0023  */
        public final void b() {
            lc.i iVar;
            bd.f fVar;
            if (this.f7916c < 0) {
                this.f7914a = 0;
                this.f7917d = null;
                return;
            }
            int i10 = -1;
            if (d.this.f7912c > 0) {
                int i11 = this.f7918e + 1;
                this.f7918e = i11;
                if (i11 >= d.this.f7912c) {
                    fVar = new bd.f(this.f7915b, t.x(d.this.f7910a));
                    this.f7917d = fVar;
                } else if (this.f7916c > d.this.f7910a.length() && (iVar = (lc.i) d.this.f7913d.invoke(d.this.f7910a, Integer.valueOf(this.f7916c))) != null) {
                    int iIntValue = ((Number) iVar.a()).intValue();
                    int iIntValue2 = ((Number) iVar.b()).intValue();
                    this.f7917d = bd.h.h(this.f7915b, iIntValue);
                    int i12 = iIntValue + iIntValue2;
                    this.f7915b = i12;
                    i10 = i12 + (iIntValue2 == 0 ? 1 : 0);
                } else {
                    fVar = new bd.f(this.f7915b, t.x(d.this.f7910a));
                    this.f7917d = fVar;
                }
            } else {
                if (this.f7916c > d.this.f7910a.length()) {
                    fVar = new bd.f(this.f7915b, t.x(d.this.f7910a));
                } else {
                    int iIntValue3 = ((Number) iVar.a()).intValue();
                    int iIntValue4 = ((Number) iVar.b()).intValue();
                    this.f7917d = bd.h.h(this.f7915b, iIntValue3);
                    int i13 = iIntValue3 + iIntValue4;
                    this.f7915b = i13;
                    i10 = i13 + (iIntValue4 == 0 ? 1 : 0);
                }
                this.f7917d = fVar;
            }
            this.f7916c = i10;
            this.f7914a = 1;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public bd.f next() {
            if (this.f7914a == -1) {
                b();
            }
            if (this.f7914a == 0) {
                throw new NoSuchElementException();
            }
            bd.f fVar = this.f7917d;
            kotlin.jvm.internal.k.c(fVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f7917d = null;
            this.f7914a = -1;
            return fVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f7914a == -1) {
                b();
            }
            return this.f7914a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence input, int i10, int i11, xc.p<? super CharSequence, ? super Integer, lc.i<Integer, Integer>> getNextMatch) {
        kotlin.jvm.internal.k.e(input, "input");
        kotlin.jvm.internal.k.e(getNextMatch, "getNextMatch");
        this.f7910a = input;
        this.f7911b = i10;
        this.f7912c = i11;
        this.f7913d = getNextMatch;
    }

    @Override // dd.b
    public Iterator<bd.f> iterator() {
        return new a();
    }
}
