package q0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f14574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14575c;

    public a(int i10, p pVar, int i11) {
        this.f14573a = i10;
        this.f14574b = pVar;
        this.f14575c = i11;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f14573a);
        this.f14574b.V(this.f14575c, bundle);
    }
}
