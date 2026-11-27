package h0;

import android.graphics.Insets;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f9551e = new g(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9555d;

    public static class a {
        public static Insets a(int i10, int i11, int i12, int i13) {
            return Insets.of(i10, i11, i12, i13);
        }
    }

    public g(int i10, int i11, int i12, int i13) {
        this.f9552a = i10;
        this.f9553b = i11;
        this.f9554c = i12;
        this.f9555d = i13;
    }

    public static g a(g gVar, g gVar2) {
        return b(Math.max(gVar.f9552a, gVar2.f9552a), Math.max(gVar.f9553b, gVar2.f9553b), Math.max(gVar.f9554c, gVar2.f9554c), Math.max(gVar.f9555d, gVar2.f9555d));
    }

    public static g b(int i10, int i11, int i12, int i13) {
        return (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) ? f9551e : new g(i10, i11, i12, i13);
    }

    public static g c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static g d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return a.a(this.f9552a, this.f9553b, this.f9554c, this.f9555d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f9555d == gVar.f9555d && this.f9552a == gVar.f9552a && this.f9554c == gVar.f9554c && this.f9553b == gVar.f9553b;
    }

    public int hashCode() {
        return (((((this.f9552a * 31) + this.f9553b) * 31) + this.f9554c) * 31) + this.f9555d;
    }

    public String toString() {
        return "Insets{left=" + this.f9552a + ", top=" + this.f9553b + ", right=" + this.f9554c + ", bottom=" + this.f9555d + '}';
    }
}
