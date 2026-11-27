package a5;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* JADX INFO: loaded from: classes.dex */
public class g implements TypeEvaluator<Matrix> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f370a = new float[9];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f371b = new float[9];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f372c = new Matrix();

    public Matrix a(float f10, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f370a);
        matrix2.getValues(this.f371b);
        for (int i10 = 0; i10 < 9; i10++) {
            float[] fArr = this.f371b;
            float f11 = fArr[i10];
            float f12 = this.f370a[i10];
            fArr[i10] = f12 + ((f11 - f12) * f10);
        }
        this.f372c.setValues(this.f371b);
        return this.f372c;
    }
}
