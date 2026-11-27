package e3;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class c extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n3.a f6970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n3.a f6971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f6972d;

    public c(Context context, n3.a aVar, n3.a aVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f6969a = context;
        if (aVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f6970b = aVar;
        if (aVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f6971c = aVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f6972d = str;
    }

    @Override // e3.h
    public Context b() {
        return this.f6969a;
    }

    @Override // e3.h
    public String c() {
        return this.f6972d;
    }

    @Override // e3.h
    public n3.a d() {
        return this.f6971c;
    }

    @Override // e3.h
    public n3.a e() {
        return this.f6970b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f6969a.equals(hVar.b()) && this.f6970b.equals(hVar.e()) && this.f6971c.equals(hVar.d()) && this.f6972d.equals(hVar.c());
    }

    public int hashCode() {
        return ((((((this.f6969a.hashCode() ^ 1000003) * 1000003) ^ this.f6970b.hashCode()) * 1000003) ^ this.f6971c.hashCode()) * 1000003) ^ this.f6972d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f6969a + ", wallClock=" + this.f6970b + ", monotonicClock=" + this.f6971c + ", backendName=" + this.f6972d + "}";
    }
}
