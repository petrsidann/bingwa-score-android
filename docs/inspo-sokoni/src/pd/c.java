package pd;

import ld.h0;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f14550a = new h0("NO_OWNER");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h0 f14551b = new h0("ALREADY_LOCKED_BY_OWNER");

    public static final a a(boolean z10) {
        return new b(z10);
    }

    public static /* synthetic */ a b(boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return a(z10);
    }
}
