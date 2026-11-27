package zd;

import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public enum e implements p {
    All("All"),
    Summary("Summary"),
    Children("Children");


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static e[] f20559e = (e[]) e.class.getEnumConstants();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20561a;

    e(String str) {
        this.f20561a = str.toLowerCase(Locale.ENGLISH);
    }

    public static e i(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return null;
        }
        if (p.d(str, length, 0, 'c')) {
            return Children;
        }
        if (p.d(str, length, 0, 'a')) {
            return All;
        }
        if (p.d(str, length, 0, 's')) {
            return Summary;
        }
        return null;
    }

    @Override // zd.p
    public String h() {
        return this.f20561a;
    }
}
