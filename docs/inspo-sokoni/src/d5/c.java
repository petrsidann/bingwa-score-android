package d5;

import android.view.View;
import java.util.List;
import p0.b2;
import p0.k2;

/* JADX INFO: loaded from: classes.dex */
public class c extends b2.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f6369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f6372f;

    public c(View view) {
        super(0);
        this.f6372f = new int[2];
        this.f6369c = view;
    }

    @Override // p0.b2.b
    public void b(b2 b2Var) {
        this.f6369c.setTranslationY(0.0f);
    }

    @Override // p0.b2.b
    public void c(b2 b2Var) {
        this.f6369c.getLocationOnScreen(this.f6372f);
        this.f6370d = this.f6372f[1];
    }

    @Override // p0.b2.b
    public k2 d(k2 k2Var, List<b2> list) {
        for (b2 b2Var : list) {
            if ((b2Var.c() & k2.m.c()) != 0) {
                this.f6369c.setTranslationY(a5.a.c(this.f6371e, 0, b2Var.b()));
                break;
            }
        }
        return k2Var;
    }

    @Override // p0.b2.b
    public b2.a e(b2 b2Var, b2.a aVar) {
        this.f6369c.getLocationOnScreen(this.f6372f);
        int i10 = this.f6370d - this.f6372f[1];
        this.f6371e = i10;
        this.f6369c.setTranslationY(i10);
        return aVar;
    }
}
