package b5;

import android.view.View;
import p0.p0;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f2864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2868e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2869f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2870g = true;

    public d(View view) {
        this.f2864a = view;
    }

    public void a() {
        View view = this.f2864a;
        p0.a0(view, this.f2867d - (view.getTop() - this.f2865b));
        View view2 = this.f2864a;
        p0.Z(view2, this.f2868e - (view2.getLeft() - this.f2866c));
    }

    public int b() {
        return this.f2867d;
    }

    public void c() {
        this.f2865b = this.f2864a.getTop();
        this.f2866c = this.f2864a.getLeft();
    }

    public boolean d(int i10) {
        if (!this.f2870g || this.f2868e == i10) {
            return false;
        }
        this.f2868e = i10;
        a();
        return true;
    }

    public boolean e(int i10) {
        if (!this.f2869f || this.f2867d == i10) {
            return false;
        }
        this.f2867d = i10;
        a();
        return true;
    }
}
