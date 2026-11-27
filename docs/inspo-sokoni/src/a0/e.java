package a0;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import y.l;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends androidx.constraintlayout.widget.c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f198n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f199o;

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.constraintlayout.widget.c
    public void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.f18a1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == d.f67h1) {
                    this.f198n = true;
                } else if (index == d.f116o1) {
                    this.f199o = true;
                }
            }
        }
    }

    public void n(l lVar, int i10, int i11) {
    }

    @Override // androidx.constraintlayout.widget.c, android.view.View
    public void onAttachedToWindow() {
        ViewParent parent;
        super.onAttachedToWindow();
        if ((this.f198n || this.f199o) && (parent = getParent()) != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i10 = 0; i10 < this.f1523b; i10++) {
                View viewH = constraintLayout.h(this.f1522a[i10]);
                if (viewH != null) {
                    if (this.f198n) {
                        viewH.setVisibility(visibility);
                    }
                    if (this.f199o && elevation > 0.0f) {
                        viewH.setTranslationZ(viewH.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        c();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        c();
    }
}
