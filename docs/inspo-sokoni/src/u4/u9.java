package u4;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class u9 extends d0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ e9 f16864e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u9(e9 e9Var, q8 q8Var) {
        super(q8Var);
        this.f16864e = e9Var;
    }

    @Override // u4.d0
    public final void d() {
        final e9 e9VarN = this.f16864e.n();
        Objects.requireNonNull(e9VarN);
        new Thread(new Runnable() { // from class: u4.t9
            @Override // java.lang.Runnable
            public final void run() {
                e9VarN.F0();
            }
        }).start();
    }
}
