package p8;

/* JADX INFO: loaded from: classes.dex */
public class i extends h7.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f14381a;

    public enum a {
        BAD_CONFIG,
        UNAVAILABLE,
        TOO_MANY_REQUESTS
    }

    public i(String str, a aVar) {
        super(str);
        this.f14381a = aVar;
    }

    public i(a aVar) {
        this.f14381a = aVar;
    }
}
