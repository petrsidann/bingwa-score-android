package a5;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t.g<String, i> f373a = new t.g<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t.g<String, PropertyValuesHolder[]> f374b = new t.g<>();

    public static void a(h hVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            hVar.h(objectAnimator.getPropertyName(), objectAnimator.getValues());
            hVar.i(objectAnimator.getPropertyName(), i.b(objectAnimator));
        } else {
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }

    public static h b(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        if (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return c(context, resourceId);
    }

    public static h c(Context context, int i10) {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i10);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return d(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return d(arrayList);
        } catch (Exception e10) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i10), e10);
            return null;
        }
    }

    public static h d(List<Animator> list) {
        h hVar = new h();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            a(hVar, list.get(i10));
        }
        return hVar;
    }

    public i e(String str) {
        if (g(str)) {
            return this.f373a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            return this.f373a.equals(((h) obj).f373a);
        }
        return false;
    }

    public long f() {
        int size = this.f373a.size();
        long jMax = 0;
        for (int i10 = 0; i10 < size; i10++) {
            i iVarM = this.f373a.m(i10);
            jMax = Math.max(jMax, iVarM.c() + iVarM.d());
        }
        return jMax;
    }

    public boolean g(String str) {
        return this.f373a.get(str) != null;
    }

    public void h(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f374b.put(str, propertyValuesHolderArr);
    }

    public int hashCode() {
        return this.f373a.hashCode();
    }

    public void i(String str, i iVar) {
        this.f373a.put(str, iVar);
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f373a + "}\n";
    }
}
