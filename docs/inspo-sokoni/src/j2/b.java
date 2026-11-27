package j2;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11163d;

    public b(int i10, int i11, int i12, int i13) {
        this.f11160a = i10;
        this.f11161b = i11;
        this.f11162c = i12;
        this.f11163d = i13;
        if (!(i10 <= i12)) {
            throw new IllegalArgumentException(("Left must be less than or equal to right, left: " + i10 + ", right: " + i12).toString());
        }
        if (i11 <= i13) {
            return;
        }
        throw new IllegalArgumentException(("top must be less than or equal to bottom, top: " + i11 + ", bottom: " + i13).toString());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        kotlin.jvm.internal.k.e(rect, "rect");
    }

    public final int a() {
        return this.f11163d - this.f11161b;
    }

    public final int b() {
        return this.f11160a;
    }

    public final int c() {
        return this.f11161b;
    }

    public final int d() {
        return this.f11162c - this.f11160a;
    }

    public final boolean e() {
        return a() == 0 && d() == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!kotlin.jvm.internal.k.a(b.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type androidx.window.core.Bounds");
        b bVar = (b) obj;
        return this.f11160a == bVar.f11160a && this.f11161b == bVar.f11161b && this.f11162c == bVar.f11162c && this.f11163d == bVar.f11163d;
    }

    public final Rect f() {
        return new Rect(this.f11160a, this.f11161b, this.f11162c, this.f11163d);
    }

    public int hashCode() {
        return (((((this.f11160a * 31) + this.f11161b) * 31) + this.f11162c) * 31) + this.f11163d;
    }

    public String toString() {
        return b.class.getSimpleName() + " { [" + this.f11160a + ',' + this.f11161b + ',' + this.f11162c + ',' + this.f11163d + "] }";
    }
}
