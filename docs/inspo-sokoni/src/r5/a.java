package r5;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.Property;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import y5.b;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.google.android.material.floatingactionbutton.a {
    public StateListAnimator N;

    public a(FloatingActionButton floatingActionButton, b bVar) {
        super(floatingActionButton, bVar);
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void B() {
        d0();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void D(int[] iArr) {
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void E(float f10, float f11, float f12) {
        if (this.f4551v.getStateListAnimator() == this.N) {
            StateListAnimator stateListAnimatorG0 = g0(f10, f11, f12);
            this.N = stateListAnimatorG0;
            this.f4551v.setStateListAnimator(stateListAnimatorG0);
        }
        if (X()) {
            d0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public boolean J() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void T(ColorStateList colorStateList) {
        Drawable drawable = this.f4532c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(x5.b.a(colorStateList));
        } else {
            super.T(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public boolean X() {
        return this.f4552w.b() || !Z();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void b0() {
    }

    public final StateListAnimator g0(float f10, float f11, float f12) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.H, h0(f10, f12));
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.I, h0(f10, f11));
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.J, h0(f10, f11));
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.K, h0(f10, f11));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.f4551v, "elevation", f10).setDuration(0L));
        arrayList.add(ObjectAnimator.ofFloat(this.f4551v, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(com.google.android.material.floatingactionbutton.a.C);
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.L, animatorSet);
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.M, h0(0.0f, 0.0f));
        return stateListAnimator;
    }

    public final Animator h0(float f10, float f11) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f4551v, "elevation", f10).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f4551v, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f11).setDuration(100L));
        animatorSet.setInterpolator(com.google.android.material.floatingactionbutton.a.C);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public float m() {
        return this.f4551v.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void r(Rect rect) {
        if (this.f4552w.b()) {
            super.r(rect);
        } else {
            int sizeDimension = !Z() ? (this.f4539j - this.f4551v.getSizeDimension()) / 2 : 0;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void z() {
    }
}
