package u4;

/* JADX INFO: loaded from: classes.dex */
public final class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f16014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f16015c;

    public b0(a aVar, String str, long j10) {
        this.f16013a = str;
        this.f16014b = j10;
        this.f16015c = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.A(this.f16015c, this.f16013a, this.f16014b);
    }
}
