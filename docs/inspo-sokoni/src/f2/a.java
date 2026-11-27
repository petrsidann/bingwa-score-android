package f2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    public static void b(Animator animator) {
        animator.pause();
    }

    public static void c(Animator animator) {
        animator.resume();
    }
}
