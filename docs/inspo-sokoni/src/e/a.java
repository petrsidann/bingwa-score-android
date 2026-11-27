package e;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<b> f6741a = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Context f6742b;

    public final void a(b listener) {
        k.e(listener, "listener");
        Context context = this.f6742b;
        if (context != null) {
            listener.a(context);
        }
        this.f6741a.add(listener);
    }

    public final void b() {
        this.f6742b = null;
    }

    public final void c(Context context) {
        k.e(context, "context");
        this.f6742b = context;
        Iterator<b> it = this.f6741a.iterator();
        while (it.hasNext()) {
            it.next().a(context);
        }
    }
}
