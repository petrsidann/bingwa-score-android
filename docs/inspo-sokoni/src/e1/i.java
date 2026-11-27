package e1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;

/* JADX INFO: loaded from: classes.dex */
public final class i extends e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Paint f6956f;

    public i(d dVar) {
        super(dVar);
    }

    public static Paint c() {
        if (f6956f == null) {
            TextPaint textPaint = new TextPaint();
            f6956f = textPaint;
            textPaint.setColor(androidx.emoji2.text.c.b().c());
            f6956f.setStyle(Paint.Style.FILL);
        }
        return f6956f;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
        if (androidx.emoji2.text.c.b().i()) {
            canvas.drawRect(f10, i12, f10 + b(), i14, c());
        }
        a().a(canvas, f10, i13, paint);
    }
}
