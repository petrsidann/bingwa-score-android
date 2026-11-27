package u4;

/* JADX INFO: loaded from: classes.dex */
public final class x7 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f16948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o7 f16949e;

    public x7(o7 o7Var, String str, String str2, String str3, long j10) {
        this.f16945a = str;
        this.f16946b = str2;
        this.f16947c = str3;
        this.f16948d = j10;
        this.f16949e = o7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.f16945a;
        if (str == null) {
            this.f16949e.f16621a.z(this.f16946b, null);
        } else {
            this.f16949e.f16621a.z(this.f16946b, new hb(this.f16947c, str, this.f16948d));
        }
    }
}
