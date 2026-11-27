package h5;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class h extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f9643b = {1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f9644c = {1, 0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9645a = 0;

    @Override // h5.f
    public com.google.android.material.carousel.b d(b bVar, View view) {
        float fB = bVar.b();
        if (bVar.f()) {
            fB = bVar.a();
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        float f10 = ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (bVar.f()) {
            f10 = ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float f11 = f10;
        float fH = com.google.android.material.carousel.a.h(view.getContext()) + f11;
        float fG = com.google.android.material.carousel.a.g(view.getContext()) + f11;
        float fMin = Math.min(measuredHeight + f11, fB);
        float fA = k0.a.a((measuredHeight / 3.0f) + f11, com.google.android.material.carousel.a.h(view.getContext()) + f11, com.google.android.material.carousel.a.g(view.getContext()) + f11);
        float f12 = (fMin + fA) / 2.0f;
        int[] iArrA = f9643b;
        if (fB < 2.0f * fH) {
            iArrA = new int[]{0};
        }
        int[] iArrA2 = f9644c;
        if (bVar.d() == 1) {
            iArrA = f.a(iArrA);
            iArrA2 = f.a(iArrA2);
        }
        int[] iArr = iArrA;
        int[] iArr2 = iArrA2;
        int iMax = (int) Math.max(1.0d, Math.floor(((fB - (com.google.android.material.carousel.a.i(iArr2) * f12)) - (com.google.android.material.carousel.a.i(iArr) * fG)) / fMin));
        int iCeil = (int) Math.ceil(fB / fMin);
        int i10 = (iCeil - iMax) + 1;
        int[] iArr3 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr3[i11] = iCeil - i11;
        }
        a aVarC = a.c(fB, fA, fH, fG, iArr, f12, iArr2, fMin, iArr3);
        this.f9645a = aVarC.e();
        if (f(aVarC, bVar.e())) {
            aVarC = a.c(fB, fA, fH, fG, new int[]{aVarC.f9632c}, f12, new int[]{aVarC.f9633d}, fMin, new int[]{aVarC.f9636g});
        }
        return com.google.android.material.carousel.a.d(view.getContext(), f11, fB, aVarC, bVar.d());
    }

    @Override // h5.f
    public boolean e(b bVar, int i10) {
        return (i10 < this.f9645a && bVar.e() >= this.f9645a) || (i10 >= this.f9645a && bVar.e() < this.f9645a);
    }

    public boolean f(a aVar, int i10) {
        int iE = aVar.e() - i10;
        boolean z10 = iE > 0 && (aVar.f9632c > 0 || aVar.f9633d > 1);
        while (iE > 0) {
            int i11 = aVar.f9632c;
            if (i11 > 0) {
                aVar.f9632c = i11 - 1;
            } else {
                int i12 = aVar.f9633d;
                if (i12 > 1) {
                    aVar.f9633d = i12 - 1;
                }
            }
            iE--;
        }
        return z10;
    }
}
