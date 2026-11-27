package p0;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13983b;

    public e0(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f13982a | this.f13983b;
    }

    public void b(View view, View view2, int i10) {
        c(view, view2, i10, 0);
    }

    public void c(View view, View view2, int i10, int i11) {
        if (i11 == 1) {
            this.f13983b = i10;
        } else {
            this.f13982a = i10;
        }
    }

    public void d(View view, int i10) {
        if (i10 == 1) {
            this.f13983b = 0;
        } else {
            this.f13982a = 0;
        }
    }
}
