package l2;

import android.app.Activity;
import java.util.concurrent.Executor;
import jd.d;
import kotlin.jvm.internal.k;
import m2.f;
import m2.j;

/* JADX INFO: loaded from: classes.dex */
public final class a implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f12410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k2.a f12411c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(f tracker) {
        this(tracker, new k2.a());
        k.e(tracker, "tracker");
    }

    public a(f fVar, k2.a aVar) {
        this.f12410b = fVar;
        this.f12411c = aVar;
    }

    @Override // m2.f
    public d<j> a(Activity activity) {
        k.e(activity, "activity");
        return this.f12410b.a(activity);
    }

    public final void b(Activity activity, Executor executor, o0.a<j> consumer) {
        k.e(activity, "activity");
        k.e(executor, "executor");
        k.e(consumer, "consumer");
        this.f12411c.a(executor, consumer, this.f12410b.a(activity));
    }

    public final void c(o0.a<j> consumer) {
        k.e(consumer, "consumer");
        this.f12411c.b(consumer);
    }
}
