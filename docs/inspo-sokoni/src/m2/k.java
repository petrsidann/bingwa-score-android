package m2;

import android.graphics.Rect;
import p0.k2;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j2.b f12945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k2 f12946b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(Rect bounds, k2 insets) {
        this(new j2.b(bounds), insets);
        kotlin.jvm.internal.k.e(bounds, "bounds");
        kotlin.jvm.internal.k.e(insets, "insets");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ k(Rect rect, k2 k2Var, int i10, kotlin.jvm.internal.g gVar) {
        if ((i10 & 2) != 0) {
            k2Var = new k2.b().a();
            kotlin.jvm.internal.k.d(k2Var, "Builder().build()");
        }
        this(rect, k2Var);
    }

    public k(j2.b _bounds, k2 _windowInsetsCompat) {
        kotlin.jvm.internal.k.e(_bounds, "_bounds");
        kotlin.jvm.internal.k.e(_windowInsetsCompat, "_windowInsetsCompat");
        this.f12945a = _bounds;
        this.f12946b = _windowInsetsCompat;
    }

    public final Rect a() {
        return this.f12945a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!kotlin.jvm.internal.k.a(k.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type androidx.window.layout.WindowMetrics");
        k kVar = (k) obj;
        return kotlin.jvm.internal.k.a(this.f12945a, kVar.f12945a) && kotlin.jvm.internal.k.a(this.f12946b, kVar.f12946b);
    }

    public int hashCode() {
        return (this.f12945a.hashCode() * 31) + this.f12946b.hashCode();
    }

    public String toString() {
        return "WindowMetrics( bounds=" + this.f12945a + ", windowInsetsCompat=" + this.f12946b + ')';
    }
}
