package ad;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends zc.a {
    @Override // zc.a
    public Random d() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        k.d(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }
}
