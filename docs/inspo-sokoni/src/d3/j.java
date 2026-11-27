package d3;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    public static Executor a() {
        return new m(Executors.newSingleThreadExecutor());
    }
}
