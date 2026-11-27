package j1;

import i1.p;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class a extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11135b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(p fragment, String previousFragmentId) {
        super(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + previousFragmentId);
        k.e(fragment, "fragment");
        k.e(previousFragmentId, "previousFragmentId");
        this.f11135b = previousFragmentId;
    }
}
