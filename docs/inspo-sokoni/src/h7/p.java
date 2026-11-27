package h7;

import android.os.SystemClock;
import com.google.auto.value.AutoValue;

/* JADX INFO: loaded from: classes.dex */
@AutoValue
public abstract class p {
    public static p a(long j10, long j11, long j12) {
        return new a(j10, j11, j12);
    }

    public static p e() {
        return a(System.currentTimeMillis(), SystemClock.elapsedRealtime(), SystemClock.uptimeMillis());
    }

    public abstract long b();

    public abstract long c();

    public abstract long d();
}
