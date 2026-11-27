package f2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class d extends n0 {

    public class a extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f8064a;

        public a(View view) {
            this.f8064a = view;
        }

        @Override // f2.l.f
        public void c(l lVar) {
            a0.g(this.f8064a, 1.0f);
            a0.a(this.f8064a);
            lVar.U(this);
        }
    }

    public static class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f8066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f8067b = false;

        public b(View view) {
            this.f8066a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a0.g(this.f8066a, 1.0f);
            if (this.f8067b) {
                this.f8066a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (p0.p0.P(this.f8066a) && this.f8066a.getLayerType() == 0) {
                this.f8067b = true;
                this.f8066a.setLayerType(2, null);
            }
        }
    }

    public d() {
    }

    public d(int i10) {
        n0(i10);
    }

    public static float p0(s sVar, float f10) {
        Float f11;
        return (sVar == null || (f11 = (Float) sVar.f8153a.get("android:fade:transitionAlpha")) == null) ? f10 : f11.floatValue();
    }

    @Override // f2.n0
    public Animator j0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        float fP0 = p0(sVar, 0.0f);
        return o0(view, fP0 != 1.0f ? fP0 : 0.0f, 1.0f);
    }

    @Override // f2.n0, f2.l
    public void l(s sVar) {
        super.l(sVar);
        sVar.f8153a.put("android:fade:transitionAlpha", Float.valueOf(a0.c(sVar.f8154b)));
    }

    @Override // f2.n0
    public Animator l0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        a0.e(view);
        return o0(view, p0(sVar, 1.0f), 0.0f);
    }

    public final Animator o0(View view, float f10, float f11) {
        if (f10 == f11) {
            return null;
        }
        a0.g(view, f10);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, a0.f8036b, f11);
        objectAnimatorOfFloat.addListener(new b(view));
        a(new a(view));
        return objectAnimatorOfFloat;
    }
}
