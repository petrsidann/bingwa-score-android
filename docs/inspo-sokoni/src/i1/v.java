package i1;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes.dex */
public class v {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animation f10442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AnimatorSet f10443b;

        public a(Animator animator) {
            this.f10442a = null;
            AnimatorSet animatorSet = new AnimatorSet();
            this.f10443b = animatorSet;
            animatorSet.play(animator);
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        public a(Animation animation) {
            this.f10442a = animation;
            this.f10443b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    public static class b extends AnimationSet implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f10444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f10445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f10446c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f10447d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f10448e;

        public b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f10448e = true;
            this.f10444a = viewGroup;
            this.f10445b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j10, Transformation transformation) {
            this.f10448e = true;
            if (this.f10446c) {
                return !this.f10447d;
            }
            if (!super.getTransformation(j10, transformation)) {
                this.f10446c = true;
                p0.i0.a(this.f10444a, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j10, Transformation transformation, float f10) {
            this.f10448e = true;
            if (this.f10446c) {
                return !this.f10447d;
            }
            if (!super.getTransformation(j10, transformation, f10)) {
                this.f10446c = true;
                p0.i0.a(this.f10444a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f10446c || !this.f10448e) {
                this.f10444a.endViewTransition(this.f10445b);
                this.f10447d = true;
            } else {
                this.f10448e = false;
                this.f10444a.post(this);
            }
        }
    }

    public static int a(p pVar, boolean z10, boolean z11) {
        if (z11) {
            return z10 ? pVar.J() : pVar.K();
        }
        return z10 ? pVar.u() : pVar.y();
    }

    public static a b(Context context, p pVar, boolean z10, boolean z11) {
        int iF = pVar.F();
        int iA = a(pVar, z10, z11);
        boolean z12 = false;
        pVar.v1(0, 0, 0, 0);
        ViewGroup viewGroup = pVar.N;
        if (viewGroup != null) {
            int i10 = h1.b.f9584c;
            if (viewGroup.getTag(i10) != null) {
                pVar.N.setTag(i10, null);
            }
        }
        ViewGroup viewGroup2 = pVar.N;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation animationQ0 = pVar.q0(iF, z10, iA);
        if (animationQ0 != null) {
            return new a(animationQ0);
        }
        Animator animatorR0 = pVar.r0(iF, z10, iA);
        if (animatorR0 != null) {
            return new a(animatorR0);
        }
        if (iA == 0 && iF != 0) {
            iA = d(context, iF, z10);
        }
        if (iA != 0) {
            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(iA));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, iA);
                    if (animationLoadAnimation != null) {
                        return new a(animationLoadAnimation);
                    }
                    z12 = true;
                } catch (Resources.NotFoundException e10) {
                    throw e10;
                } catch (RuntimeException unused) {
                }
            }
            if (!z12) {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iA);
                    if (animatorLoadAnimator != null) {
                        return new a(animatorLoadAnimator);
                    }
                } catch (RuntimeException e11) {
                    if (zEquals) {
                        throw e11;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, iA);
                    if (animationLoadAnimation2 != null) {
                        return new a(animationLoadAnimation2);
                    }
                }
            }
        }
        return null;
    }

    public static int c(Context context, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i10});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int d(Context context, int i10, boolean z10) {
        int i11;
        if (i10 == 4097) {
            return z10 ? h1.a.f9580e : h1.a.f9581f;
        }
        if (i10 == 8194) {
            return z10 ? h1.a.f9576a : h1.a.f9577b;
        }
        if (i10 == 8197) {
            i11 = z10 ? R.attr.activityCloseEnterAnimation : R.attr.activityCloseExitAnimation;
        } else {
            if (i10 == 4099) {
                return z10 ? h1.a.f9578c : h1.a.f9579d;
            }
            if (i10 != 4100) {
                return -1;
            }
            i11 = z10 ? R.attr.activityOpenEnterAnimation : R.attr.activityOpenExitAnimation;
        }
        return c(context, i11);
    }
}
