package b5;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes.dex */
public class c<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f2861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2863c;

    public c() {
        this.f2862b = 0;
        this.f2863c = 0;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2862b = 0;
        this.f2863c = 0;
    }

    public int E() {
        d dVar = this.f2861a;
        if (dVar != null) {
            return dVar.b();
        }
        return 0;
    }

    public void F(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        coordinatorLayout.I(v10, i10);
    }

    public boolean G(int i10) {
        d dVar = this.f2861a;
        if (dVar != null) {
            return dVar.e(i10);
        }
        this.f2862b = i10;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        F(coordinatorLayout, v10, i10);
        if (this.f2861a == null) {
            this.f2861a = new d(v10);
        }
        this.f2861a.c();
        this.f2861a.a();
        int i11 = this.f2862b;
        if (i11 != 0) {
            this.f2861a.e(i11);
            this.f2862b = 0;
        }
        int i12 = this.f2863c;
        if (i12 == 0) {
            return true;
        }
        this.f2861a.d(i12);
        this.f2863c = 0;
        return true;
    }
}
