package y9;

import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19445c;

    public c(String id2, String text, String str) {
        k.e(id2, "id");
        k.e(text, "text");
        this.f19443a = id2;
        this.f19444b = text;
        this.f19445c = str;
    }

    public final String a() {
        return this.f19443a;
    }

    public final String b() {
        return this.f19444b;
    }

    public final String c() {
        return this.f19445c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return k.a(this.f19443a, cVar.f19443a) && k.a(this.f19444b, cVar.f19444b) && k.a(this.f19445c, cVar.f19445c);
    }

    public int hashCode() {
        int iHashCode = ((this.f19443a.hashCode() * 31) + this.f19444b.hashCode()) * 31;
        String str = this.f19445c;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "NotificationButton(id=" + this.f19443a + ", text=" + this.f19444b + ", textColorRgb=" + this.f19445c + ')';
    }
}
