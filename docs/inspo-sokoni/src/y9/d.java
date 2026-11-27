package y9;

import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f19449d;

    public d(String resType, String resPrefix, String name, String str) {
        k.e(resType, "resType");
        k.e(resPrefix, "resPrefix");
        k.e(name, "name");
        this.f19446a = resType;
        this.f19447b = resPrefix;
        this.f19448c = name;
        this.f19449d = str;
    }

    public final String a() {
        return this.f19449d;
    }

    public final String b() {
        return this.f19448c;
    }

    public final String c() {
        return this.f19447b;
    }

    public final String d() {
        return this.f19446a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return k.a(this.f19446a, dVar.f19446a) && k.a(this.f19447b, dVar.f19447b) && k.a(this.f19448c, dVar.f19448c) && k.a(this.f19449d, dVar.f19449d);
    }

    public int hashCode() {
        int iHashCode = ((((this.f19446a.hashCode() * 31) + this.f19447b.hashCode()) * 31) + this.f19448c.hashCode()) * 31;
        String str = this.f19449d;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "NotificationIconData(resType=" + this.f19446a + ", resPrefix=" + this.f19447b + ", name=" + this.f19448c + ", backgroundColorRgb=" + this.f19449d + ')';
    }
}
