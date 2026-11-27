package u9;

import android.net.Uri;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f17040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f17041d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f17042e;

    /* JADX INFO: renamed from: u9.a$a, reason: collision with other inner class name */
    public static class C0295a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f17044b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Uri f17045c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f17046d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f17047e;

        public a a() {
            return new a(this.f17043a, this.f17044b, this.f17045c, this.f17046d, this.f17047e);
        }

        public C0295a b(byte[] bArr) {
            this.f17047e = bArr;
            return this;
        }

        public C0295a c(String str) {
            this.f17044b = str;
            return this;
        }

        public C0295a d(String str) {
            this.f17043a = str;
            return this;
        }

        public C0295a e(long j10) {
            this.f17046d = j10;
            return this;
        }

        public C0295a f(Uri uri) {
            this.f17045c = uri;
            return this;
        }
    }

    public a(String str, String str2, Uri uri, long j10, byte[] bArr) {
        this.f17038a = str;
        this.f17039b = str2;
        this.f17041d = j10;
        this.f17042e = bArr;
        this.f17040c = uri;
    }

    public HashMap<String, Object> a() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("path", this.f17038a);
        map.put("name", this.f17039b);
        map.put("size", Long.valueOf(this.f17041d));
        map.put("bytes", this.f17042e);
        map.put("identifier", this.f17040c.toString());
        return map;
    }
}
