package b8;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f2967b = Pattern.compile("[~*/\\[\\]]");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t f2968c = new t(h8.q.f9757b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h8.q f2969a;

    public t(h8.q qVar) {
        this.f2969a = qVar;
    }

    public t(List<String> list) {
        this.f2969a = h8.q.y(list);
    }

    public static t a() {
        return f2968c;
    }

    public static t b(String str) {
        l8.x.c(str, "Provided field path must not be null.");
        l8.x.a(!f2967b.matcher(str).find(), "Use FieldPath.of() for field names containing '~*/[]'.", new Object[0]);
        try {
            return d(str.split("\\.", -1));
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Invalid field path (" + str + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
        }
    }

    public static t d(String... strArr) {
        l8.x.a(strArr.length > 0, "Invalid field path. Provided path must not be empty.", new Object[0]);
        int i10 = 0;
        while (i10 < strArr.length) {
            String str = strArr[i10];
            boolean z10 = (str == null || str.isEmpty()) ? false : true;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid field name at argument ");
            i10++;
            sb2.append(i10);
            sb2.append(". Field names must not be null or empty.");
            l8.x.a(z10, sb2.toString(), new Object[0]);
        }
        return new t((List<String>) Arrays.asList(strArr));
    }

    public h8.q c() {
        return this.f2969a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t.class != obj.getClass()) {
            return false;
        }
        return this.f2969a.equals(((t) obj).f2969a);
    }

    public int hashCode() {
        return this.f2969a.hashCode();
    }

    public String toString() {
        return this.f2969a.toString();
    }
}
