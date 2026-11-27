package ld;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f12760a = new h0("CONDITION_FALSE");

    public static final Object a() {
        return f12760a;
    }

    public static final s b(Object obj) {
        s sVar;
        b0 b0Var = obj instanceof b0 ? (b0) obj : null;
        if (b0Var != null && (sVar = b0Var.f12714a) != null) {
            return sVar;
        }
        kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (s) obj;
    }
}
