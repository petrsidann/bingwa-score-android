package j1;

import android.view.ViewGroup;
import i1.p;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class d extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f11154b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(p fragment, ViewGroup viewGroup) {
        super(fragment, "Attempting to use <fragment> tag to add fragment " + fragment + " to container " + viewGroup);
        k.e(fragment, "fragment");
        this.f11154b = viewGroup;
    }
}
