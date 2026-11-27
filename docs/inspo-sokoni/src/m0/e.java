package m0;

import android.util.Base64;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<List<byte[]>> f12868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12869e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f12870f;

    public e(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f12865a = (String) o0.h.g(str);
        this.f12866b = (String) o0.h.g(str2);
        this.f12867c = (String) o0.h.g(str3);
        this.f12868d = (List) o0.h.g(list);
        this.f12870f = a(str, str2, str3);
    }

    public final String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List<List<byte[]>> b() {
        return this.f12868d;
    }

    public int c() {
        return this.f12869e;
    }

    public String d() {
        return this.f12870f;
    }

    public String e() {
        return this.f12865a;
    }

    public String f() {
        return this.f12866b;
    }

    public String g() {
        return this.f12867c;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontRequest {mProviderAuthority: " + this.f12865a + ", mProviderPackage: " + this.f12866b + ", mQuery: " + this.f12867c + ", mCertificates:");
        for (int i10 = 0; i10 < this.f12868d.size(); i10++) {
            sb2.append(" [");
            List<byte[]> list = this.f12868d.get(i10);
            for (int i11 = 0; i11 < list.size(); i11++) {
                sb2.append(" \"");
                sb2.append(Base64.encodeToString(list.get(i11), 0));
                sb2.append("\"");
            }
            sb2.append(" ]");
        }
        sb2.append("}");
        sb2.append("mCertificatesArray: " + this.f12869e);
        return sb2.toString();
    }
}
