package g;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<I, O> {

    /* JADX INFO: renamed from: g.a$a, reason: collision with other inner class name */
    public static final class C0146a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f8422a;

        public C0146a(T t10) {
            this.f8422a = t10;
        }

        public final T a() {
            return this.f8422a;
        }
    }

    public abstract Intent a(Context context, I i10);

    public C0146a<O> b(Context context, I i10) {
        k.e(context, "context");
        return null;
    }

    public abstract O c(int i10, Intent intent);
}
