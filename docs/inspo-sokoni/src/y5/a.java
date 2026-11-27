package y5;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f19377i = new int[3];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float[] f19378j = {0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f19379k = new int[4];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float[] f19380l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f19381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f19382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f19383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f19385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f19386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f19387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f19388h;

    public a() {
        this(-16777216);
    }

    public a(int i10) {
        this.f19387g = new Path();
        Paint paint = new Paint();
        this.f19388h = paint;
        this.f19381a = new Paint();
        d(i10);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f19382b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f19383c = new Paint(paint2);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i10, float f10, float f11) {
        boolean z10 = f11 < 0.0f;
        Path path = this.f19387g;
        if (z10) {
            int[] iArr = f19379k;
            iArr[0] = 0;
            iArr[1] = this.f19386f;
            iArr[2] = this.f19385e;
            iArr[3] = this.f19384d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f10, f11);
            path.close();
            float f12 = -i10;
            rectF.inset(f12, f12);
            int[] iArr2 = f19379k;
            iArr2[0] = 0;
            iArr2[1] = this.f19384d;
            iArr2[2] = this.f19385e;
            iArr2[3] = this.f19386f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f13 = 1.0f - (i10 / fWidth);
        float[] fArr = f19380l;
        fArr[1] = f13;
        fArr[2] = ((1.0f - f13) / 2.0f) + f13;
        this.f19382b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, f19379k, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z10) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f19388h);
        }
        canvas.drawArc(rectF, f10, f11, true, this.f19382b);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i10) {
        rectF.bottom += i10;
        rectF.offset(0.0f, -i10);
        int[] iArr = f19377i;
        iArr[0] = this.f19386f;
        iArr[1] = this.f19385e;
        iArr[2] = this.f19384d;
        Paint paint = this.f19383c;
        float f10 = rectF.left;
        paint.setShader(new LinearGradient(f10, rectF.top, f10, rectF.bottom, iArr, f19378j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f19383c);
        canvas.restore();
    }

    public Paint c() {
        return this.f19381a;
    }

    public void d(int i10) {
        this.f19384d = h0.a.k(i10, 68);
        this.f19385e = h0.a.k(i10, 20);
        this.f19386f = h0.a.k(i10, 0);
        this.f19381a.setColor(this.f19384d);
    }
}
