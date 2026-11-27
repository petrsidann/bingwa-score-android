package f2;

import android.view.View;
import android.view.WindowId;

/* JADX INFO: loaded from: classes.dex */
public class o0 implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowId f8146a;

    public o0(View view) {
        this.f8146a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof o0) && ((o0) obj).f8146a.equals(this.f8146a);
    }

    public int hashCode() {
        return this.f8146a.hashCode();
    }
}
