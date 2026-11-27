package j1;

import android.view.ViewGroup;
import i1.p;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class h extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f11156b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(p fragment, ViewGroup container) {
        super(fragment, "Attempting to add fragment " + fragment + " to container " + container + " which is not a FragmentContainerView");
        k.e(fragment, "fragment");
        k.e(container, "container");
        this.f11156b = container;
    }
}
