package zb;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f20512a = new String[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f20513b = Charset.forName("UTF-8");

    public static <T> List<T> a(T[] tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static <T> List<T> b(T[] tArr, T[] tArr2) {
        ArrayList arrayList = new ArrayList();
        for (T t10 : tArr) {
            for (T t11 : tArr2) {
                if (t10.equals(t11)) {
                    arrayList.add(t11);
                    break;
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T[] c(Class<T> cls, T[] tArr, T[] tArr2) {
        List listB = b(tArr, tArr2);
        return (T[]) listB.toArray((Object[]) Array.newInstance((Class<?>) cls, listB.size()));
    }
}
