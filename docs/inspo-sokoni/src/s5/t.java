package s5;

import android.widget.ImageButton;

/* JADX INFO: loaded from: classes.dex */
public class t extends ImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15558a;

    public final void b(int i10, boolean z10) {
        super.setVisibility(i10);
        if (z10) {
            this.f15558a = i10;
        }
    }

    public final int getUserSetVisibility() {
        return this.f15558a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i10) {
        b(i10, true);
    }
}
