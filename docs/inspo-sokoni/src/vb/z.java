package vb;

import vb.x0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z<T extends x0<T>> extends x0<T> {
    @Override // vb.x0
    public w0 a() {
        return e().a();
    }

    public abstract x0<?> e();

    public String toString() {
        return j6.g.b(this).d("delegate", e()).toString();
    }
}
