package ae;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f514b;

    public a(String str, String str2, String str3) {
        super(str2);
        this.f513a = str;
        this.f514b = str3;
    }

    public a(String str, String str2, String str3, Exception exc) {
        super(str2);
        this.f513a = str;
        this.f514b = str3;
        setStackTrace(exc.getStackTrace());
    }

    public final String a() {
        return this.f513a;
    }

    public String b() {
        return this.f514b;
    }
}
