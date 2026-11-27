package h6;

import android.os.IBinder;
import android.os.IInterface;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class b extends h0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ IBinder f9648l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ e f9649m;

    public b(e eVar, IBinder iBinder) {
        this.f9649m = eVar;
        this.f9648l = iBinder;
    }

    @Override // h6.h0
    public final void b() {
        this.f9649m.f9651a.f9666n = (IInterface) this.f9649m.f9651a.f9661i.a(this.f9648l);
        f.r(this.f9649m.f9651a);
        this.f9649m.f9651a.f9659g = false;
        Iterator it = this.f9649m.f9651a.f9656d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f9649m.f9651a.f9656d.clear();
    }
}
