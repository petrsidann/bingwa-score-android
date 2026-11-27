package d1;

import java.util.Arrays;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final d a() {
        return new a(null, true, 1, null);
    }

    public static final a b(d.b<?>... pairs) {
        k.e(pairs, "pairs");
        a aVar = new a(null, false, 1, null);
        aVar.e((d.b[]) Arrays.copyOf(pairs, pairs.length));
        return aVar;
    }
}
