package h8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class q extends e<q> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f9757b = A("__name__");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f9758c = new q(Collections.emptyList());

    public q(List<String> list) {
        super(list);
    }

    public static q A(String str) {
        return new q(Collections.singletonList(str));
    }

    public static boolean C(String str) {
        if (str.isEmpty()) {
            return false;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt != '_' && ((cCharAt < 'a' || cCharAt > 'z') && (cCharAt < 'A' || cCharAt > 'Z'))) {
            return false;
        }
        for (int i10 = 1; i10 < str.length(); i10++) {
            char cCharAt2 = str.charAt(i10);
            if (cCharAt2 != '_' && ((cCharAt2 < 'a' || cCharAt2 > 'z') && ((cCharAt2 < 'A' || cCharAt2 > 'Z') && (cCharAt2 < '0' || cCharAt2 > '9')))) {
                return false;
            }
        }
        return true;
    }

    public static q y(List<String> list) {
        return list.isEmpty() ? f9758c : new q(list);
    }

    public static q z(String str) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        boolean z10 = false;
        while (i10 < str.length()) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\\') {
                i10++;
                if (i10 == str.length()) {
                    throw new IllegalArgumentException("Trailing escape character is not allowed");
                }
                cCharAt = str.charAt(i10);
            } else {
                if (cCharAt == '.') {
                    if (!z10) {
                        String string = sb2.toString();
                        if (string.isEmpty()) {
                            throw new IllegalArgumentException("Invalid field path (" + str + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
                        }
                        StringBuilder sb3 = new StringBuilder();
                        arrayList.add(string);
                        sb2 = sb3;
                    }
                } else if (cCharAt == '`') {
                    z10 = !z10;
                }
                i10++;
            }
            sb2.append(cCharAt);
            i10++;
        }
        String string2 = sb2.toString();
        if (!string2.isEmpty()) {
            arrayList.add(string2);
            return new q(arrayList);
        }
        throw new IllegalArgumentException("Invalid field path (" + str + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
    }

    public boolean B() {
        return equals(f9757b);
    }

    @Override // h8.e
    public String i() {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < this.f9737a.size(); i10++) {
            if (i10 > 0) {
                sb2.append(".");
            }
            String strReplace = this.f9737a.get(i10).replace("\\", "\\\\").replace("`", "\\`");
            if (!C(strReplace)) {
                strReplace = '`' + strReplace + '`';
            }
            sb2.append(strReplace);
        }
        return sb2.toString();
    }

    @Override // h8.e
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public q n(List<String> list) {
        return new q(list);
    }
}
