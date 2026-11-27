package l0;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class l implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocaleList f12402a;

    public l(Object obj) {
        this.f12402a = (LocaleList) obj;
    }

    @Override // l0.k
    public String a() {
        return this.f12402a.toLanguageTags();
    }

    @Override // l0.k
    public Object b() {
        return this.f12402a;
    }

    public boolean equals(Object obj) {
        return this.f12402a.equals(((k) obj).b());
    }

    @Override // l0.k
    public Locale get(int i10) {
        return this.f12402a.get(i10);
    }

    public int hashCode() {
        return this.f12402a.hashCode();
    }

    @Override // l0.k
    public boolean isEmpty() {
        return this.f12402a.isEmpty();
    }

    @Override // l0.k
    public int size() {
        return this.f12402a.size();
    }

    public String toString() {
        return this.f12402a.toString();
    }
}
