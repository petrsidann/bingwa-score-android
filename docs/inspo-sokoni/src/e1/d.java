package e1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal<f1.a> f6939d = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.emoji2.text.f f6941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f6942c = 0;

    public d(androidx.emoji2.text.f fVar, int i10) {
        this.f6941b = fVar;
        this.f6940a = i10;
    }

    public void a(Canvas canvas, float f10, float f11, Paint paint) {
        Typeface typefaceG = this.f6941b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(typefaceG);
        canvas.drawText(this.f6941b.c(), this.f6940a * 2, 2, f10, f11, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i10) {
        return g().h(i10);
    }

    public int c() {
        return g().i();
    }

    public int d() {
        return this.f6942c;
    }

    public short e() {
        return g().k();
    }

    public int f() {
        return g().l();
    }

    public final f1.a g() {
        ThreadLocal<f1.a> threadLocal = f6939d;
        f1.a aVar = threadLocal.get();
        if (aVar == null) {
            aVar = new f1.a();
            threadLocal.set(aVar);
        }
        this.f6941b.d().j(aVar, this.f6940a);
        return aVar;
    }

    public short h() {
        return g().m();
    }

    public short i() {
        return g().n();
    }

    public boolean j() {
        return g().j();
    }

    public void k(boolean z10) {
        this.f6942c = z10 ? 2 : 1;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(", id:");
        sb2.append(Integer.toHexString(f()));
        sb2.append(", codepoints:");
        int iC = c();
        for (int i10 = 0; i10 < iC; i10++) {
            sb2.append(Integer.toHexString(b(i10)));
            sb2.append(" ");
        }
        return sb2.toString();
    }
}
