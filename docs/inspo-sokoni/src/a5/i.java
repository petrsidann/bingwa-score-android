package a5;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TimeInterpolator f377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f379e;

    public i(long j10, long j11) {
        this.f377c = null;
        this.f378d = 0;
        this.f379e = 1;
        this.f375a = j10;
        this.f376b = j11;
    }

    public i(long j10, long j11, TimeInterpolator timeInterpolator) {
        this.f378d = 0;
        this.f379e = 1;
        this.f375a = j10;
        this.f376b = j11;
        this.f377c = timeInterpolator;
    }

    public static i b(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        iVar.f378d = valueAnimator.getRepeatCount();
        iVar.f379e = valueAnimator.getRepeatMode();
        return iVar;
    }

    public static TimeInterpolator f(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
            return a.f361b;
        }
        if (interpolator instanceof AccelerateInterpolator) {
            return a.f362c;
        }
        return interpolator instanceof DecelerateInterpolator ? a.f363d : interpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.f375a;
    }

    public long d() {
        return this.f376b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f377c;
        return timeInterpolator != null ? timeInterpolator : a.f361b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (c() == iVar.c() && d() == iVar.d() && g() == iVar.g() && h() == iVar.h()) {
            return e().getClass().equals(iVar.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.f378d;
    }

    public int h() {
        return this.f379e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }
}
