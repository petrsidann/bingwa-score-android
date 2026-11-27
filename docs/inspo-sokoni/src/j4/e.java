package j4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    @Deprecated
    public static <T> List<T> a(T t10) {
        return Collections.singletonList(t10);
    }

    @Deprecated
    public static <T> List<T> b(T... tArr) {
        int length = tArr.length;
        if (length != 0) {
            return length != 1 ? Collections.unmodifiableList(Arrays.asList(tArr)) : Collections.singletonList(tArr[0]);
        }
        return Collections.emptyList();
    }
}
