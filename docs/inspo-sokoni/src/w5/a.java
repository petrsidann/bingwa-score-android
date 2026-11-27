package w5;

import android.graphics.Typeface;

/* JADX INFO: loaded from: classes.dex */
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Typeface f17621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0310a f17622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17623c;

    /* JADX INFO: renamed from: w5.a$a, reason: collision with other inner class name */
    public interface InterfaceC0310a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0310a interfaceC0310a, Typeface typeface) {
        this.f17621a = typeface;
        this.f17622b = interfaceC0310a;
    }

    @Override // w5.f
    public void a(int i10) {
        d(this.f17621a);
    }

    @Override // w5.f
    public void b(Typeface typeface, boolean z10) {
        d(typeface);
    }

    public void c() {
        this.f17623c = true;
    }

    public final void d(Typeface typeface) {
        if (this.f17623c) {
            return;
        }
        this.f17622b.a(typeface);
    }
}
