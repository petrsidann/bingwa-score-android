package j1;

import i1.p;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class i extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f11157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11158c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(p fragment, p expectedParentFragment, int i10) {
        super(fragment, "Attempting to nest fragment " + fragment + " within the view of parent fragment " + expectedParentFragment + " via container with ID " + i10 + " without using parent's childFragmentManager");
        k.e(fragment, "fragment");
        k.e(expectedParentFragment, "expectedParentFragment");
        this.f11157b = expectedParentFragment;
        this.f11158c = i10;
    }
}
