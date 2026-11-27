package d;

import android.window.BackEvent;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f6104e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f6105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f6106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f6107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6108d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public b(float f10, float f11, float f12, int i10) {
        this.f6105a = f10;
        this.f6106b = f11;
        this.f6107c = f12;
        this.f6108d = i10;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(BackEvent backEvent) {
        kotlin.jvm.internal.k.e(backEvent, "backEvent");
        d.a aVar = d.a.f6103a;
        this(aVar.d(backEvent), aVar.e(backEvent), aVar.b(backEvent), aVar.c(backEvent));
    }

    public final float a() {
        return this.f6107c;
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.f6105a + ", touchY=" + this.f6106b + ", progress=" + this.f6107c + ", swipeEdge=" + this.f6108d + '}';
    }
}
