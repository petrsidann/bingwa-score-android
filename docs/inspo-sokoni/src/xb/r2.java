package xb;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public interface r2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r2 f18900a = new a();

    public class a implements r2 {
        @Override // xb.r2
        public long a() {
            return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        }
    }

    long a();
}
