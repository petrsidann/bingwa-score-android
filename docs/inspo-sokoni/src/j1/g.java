package j1;

import i1.p;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f11155a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(p fragment, String str) {
        super(str);
        k.e(fragment, "fragment");
        this.f11155a = fragment;
    }

    public final p a() {
        return this.f11155a;
    }
}
