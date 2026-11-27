package zb;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f20464a;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f20465a = new ArrayList(20);

        public b b(String str, String str2) {
            this.f20465a.add(str);
            this.f20465a.add(str2.trim());
            return this;
        }

        public e c() {
            return new e(this);
        }

        public final void d(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i10 = 0; i10 < length; i10++) {
                char cCharAt = str.charAt(i10);
                if (cCharAt <= 31 || cCharAt >= 127) {
                    throw new IllegalArgumentException(String.format(Locale.US, "Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i10), str));
                }
            }
            if (str2 == null) {
                throw new IllegalArgumentException("value == null");
            }
            int length2 = str2.length();
            for (int i11 = 0; i11 < length2; i11++) {
                char cCharAt2 = str2.charAt(i11);
                if (cCharAt2 <= 31 || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(String.format(Locale.US, "Unexpected char %#04x at %d in header value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i11), str2));
                }
            }
        }

        public b e(String str) {
            int i10 = 0;
            while (i10 < this.f20465a.size()) {
                if (str.equalsIgnoreCase(this.f20465a.get(i10))) {
                    this.f20465a.remove(i10);
                    this.f20465a.remove(i10);
                    i10 -= 2;
                }
                i10 += 2;
            }
            return this;
        }

        public b f(String str, String str2) {
            d(str, str2);
            e(str);
            b(str, str2);
            return this;
        }
    }

    public e(b bVar) {
        this.f20464a = (String[]) bVar.f20465a.toArray(new String[bVar.f20465a.size()]);
    }

    public String a(int i10) {
        int i11 = i10 * 2;
        if (i11 < 0) {
            return null;
        }
        String[] strArr = this.f20464a;
        if (i11 >= strArr.length) {
            return null;
        }
        return strArr[i11];
    }

    public int b() {
        return this.f20464a.length / 2;
    }

    public String c(int i10) {
        int i11 = (i10 * 2) + 1;
        if (i11 < 0) {
            return null;
        }
        String[] strArr = this.f20464a;
        if (i11 >= strArr.length) {
            return null;
        }
        return strArr[i11];
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int iB = b();
        for (int i10 = 0; i10 < iB; i10++) {
            sb2.append(a(i10));
            sb2.append(": ");
            sb2.append(c(i10));
            sb2.append("\n");
        }
        return sb2.toString();
    }
}
