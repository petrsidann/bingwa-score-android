package u4;

/* JADX INFO: loaded from: classes.dex */
public final class ea implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f16164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f16165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ e9 f16166e;

    public ea(e9 e9Var, String str, String str2, Object obj, long j10) {
        this.f16162a = str;
        this.f16163b = str2;
        this.f16164c = obj;
        this.f16165d = j10;
        this.f16166e = e9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16166e.V(this.f16162a, this.f16163b, this.f16164c, this.f16165d);
    }
}
