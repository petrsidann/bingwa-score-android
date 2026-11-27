package e1;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends ReplacementSpan {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f6944b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint.FontMetricsInt f6943a = new Paint.FontMetricsInt();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public short f6945c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public short f6946d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f6947e = 1.0f;

    public e(d dVar) {
        o0.h.h(dVar, "metadata cannot be null");
        this.f6944b = dVar;
    }

    public final d a() {
        return this.f6944b;
    }

    public final int b() {
        return this.f6945c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f6943a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f6943a;
        this.f6947e = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f6944b.e();
        this.f6946d = (short) (this.f6944b.e() * this.f6947e);
        short sI = (short) (this.f6944b.i() * this.f6947e);
        this.f6945c = sI;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f6943a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return sI;
    }
}
