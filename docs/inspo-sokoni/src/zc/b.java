package zc;

import java.util.Random;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends zc.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f20514c = new a();

    public static final class a extends ThreadLocal<Random> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // zc.a
    public Random d() {
        Random random = this.f20514c.get();
        k.d(random, "get(...)");
        return random;
    }
}
