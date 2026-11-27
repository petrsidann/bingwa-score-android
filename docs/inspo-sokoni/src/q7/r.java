package q7;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class r extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c<?>> f14886a;

    public r(List<c<?>> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.f14886a = list;
    }
}
