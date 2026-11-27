package r1;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class g implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f14991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14993c;

    public g(String str, int i10, int i11) {
        this.f14991a = str;
        this.f14992b = i10;
        this.f14993c = i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f14992b < 0 || gVar.f14992b < 0) {
            return TextUtils.equals(this.f14991a, gVar.f14991a) && this.f14993c == gVar.f14993c;
        }
        return TextUtils.equals(this.f14991a, gVar.f14991a) && this.f14992b == gVar.f14992b && this.f14993c == gVar.f14993c;
    }

    public int hashCode() {
        return o0.c.b(this.f14991a, Integer.valueOf(this.f14993c));
    }
}
