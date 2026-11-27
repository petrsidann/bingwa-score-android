package h8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class t extends e<t> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f9776b = new t(Collections.emptyList());

    public t(List<String> list) {
        super(list);
    }

    public static t y(List<String> list) {
        return list.isEmpty() ? f9776b : new t(list);
    }

    public static t z(String str) {
        if (str.contains("//")) {
            throw new IllegalArgumentException("Invalid path (" + str + "). Paths must not contain // in them.");
        }
        String[] strArrSplit = str.split("/");
        ArrayList arrayList = new ArrayList(strArrSplit.length);
        for (String str2 : strArrSplit) {
            if (!str2.isEmpty()) {
                arrayList.add(str2);
            }
        }
        return new t(arrayList);
    }

    @Override // h8.e
    public String i() {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < this.f9737a.size(); i10++) {
            if (i10 > 0) {
                sb2.append("/");
            }
            sb2.append(this.f9737a.get(i10));
        }
        return sb2.toString();
    }

    @Override // h8.e
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public t n(List<String> list) {
        return new t(list);
    }
}
