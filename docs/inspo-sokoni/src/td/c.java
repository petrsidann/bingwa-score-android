package td;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import je.o;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f15927c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f15928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ce.c> f15929b = new ArrayList();

    public c(o oVar) {
        this.f15928a = oVar;
    }

    public static c a() {
        if (f15927c == null) {
            f15927c = new c(o.c());
        }
        return f15927c;
    }

    public void b(String str, Exception exc) {
        de.a.b(str, exc.getLocalizedMessage());
        if (this.f15929b.isEmpty()) {
            exc.printStackTrace();
            return;
        }
        Iterator<ce.c> it = this.f15929b.iterator();
        while (it.hasNext()) {
            it.next().a(exc);
        }
    }
}
