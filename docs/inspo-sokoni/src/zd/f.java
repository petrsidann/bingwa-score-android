package zd;

import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public enum f implements p {
    Asc("Asc"),
    Desc("Desc");


    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static f[] f20564d = (f[]) f.class.getEnumConstants();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20566a;

    f(String str) {
        this.f20566a = str.toLowerCase(Locale.ENGLISH);
    }

    public static f i(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return null;
        }
        if (p.d(str, length, 0, 'a')) {
            return Asc;
        }
        if (p.d(str, length, 0, 'd')) {
            return Desc;
        }
        return null;
    }

    @Override // zd.p
    public String h() {
        return this.f20566a;
    }
}
