package u4;

/* JADX INFO: loaded from: classes.dex */
public final class c1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f16064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f16065c;

    public c1(a aVar, String str, long j10) {
        this.f16063a = str;
        this.f16064b = j10;
        this.f16065c = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.x(this.f16065c, this.f16063a, this.f16064b);
    }
}
