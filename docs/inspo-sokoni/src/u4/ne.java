package u4;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class ne implements Callable<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ me f16618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ge f16619b;

    public ne(ge geVar, me meVar) {
        this.f16618a = meVar;
        this.f16619b = geVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() {
        x5 x5VarG;
        String str;
        if (this.f16619b.b0((String) com.google.android.gms.common.internal.r.l(this.f16618a.f16528a)).x() && s8.p(this.f16618a.f16548z).x()) {
            h6 h6VarJ = this.f16619b.j(this.f16618a);
            if (h6VarJ != null) {
                return h6VarJ.m();
            }
            x5VarG = this.f16619b.zzj().H();
            str = "App info was null when attempting to get app instance id";
        } else {
            x5VarG = this.f16619b.zzj().G();
            str = "Analytics storage consent denied. Returning null app instance id";
        }
        x5VarG.a(str);
        return null;
    }
}
