package s5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<b> f15518a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f15519b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f15520c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Animator.AnimatorListener f15521d = new a();

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            k kVar = k.this;
            if (kVar.f15520c == animator) {
                kVar.f15520c = null;
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f15523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ValueAnimator f15524b;

        public b(int[] iArr, ValueAnimator valueAnimator) {
            this.f15523a = iArr;
            this.f15524b = valueAnimator;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f15521d);
        this.f15518a.add(bVar);
    }
}
