package z8;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile d f20384b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<f> f20385a = new HashSet();

    public static d a() {
        d dVar = f20384b;
        if (dVar == null) {
            synchronized (d.class) {
                dVar = f20384b;
                if (dVar == null) {
                    dVar = new d();
                    f20384b = dVar;
                }
            }
        }
        return dVar;
    }

    public Set<f> b() {
        Set<f> setUnmodifiableSet;
        synchronized (this.f20385a) {
            setUnmodifiableSet = Collections.unmodifiableSet(this.f20385a);
        }
        return setUnmodifiableSet;
    }
}
