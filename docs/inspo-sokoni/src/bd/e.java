package bd;

import java.util.NoSuchElementException;
import mc.b0;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3078d;

    public e(int i10, int i11, int i12) {
        this.f3075a = i12;
        this.f3076b = i11;
        boolean z10 = true;
        if (i12 <= 0 ? i10 < i11 : i10 > i11) {
            z10 = false;
        }
        this.f3077c = z10;
        this.f3078d = z10 ? i10 : i11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3077c;
    }

    @Override // mc.b0
    public int nextInt() {
        int i10 = this.f3078d;
        if (i10 != this.f3076b) {
            this.f3078d = this.f3075a + i10;
        } else {
            if (!this.f3077c) {
                throw new NoSuchElementException();
            }
            this.f3077c = false;
        }
        return i10;
    }
}
