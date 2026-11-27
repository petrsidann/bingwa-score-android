package ee;

import androidx.lifecycle.s;
import androidx.lifecycle.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class k implements androidx.lifecycle.j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static zd.k f7955e = zd.k.Terminated;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static k f7956f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<ce.d> f7957a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7958b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7959c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7960d = true;

    public static zd.k h() {
        return f7955e;
    }

    public static k i() {
        if (f7956f == null) {
            f7956f = new k();
        }
        return f7956f;
    }

    public void j(zd.k kVar) {
        Iterator<ce.d> it = this.f7957a.iterator();
        while (it.hasNext()) {
            it.next().c(kVar);
        }
    }

    public void k() {
        if (this.f7958b) {
            return;
        }
        this.f7958b = true;
        v.n().a().a(this);
        if (rd.a.f15359i.booleanValue()) {
            de.a.a("LifeCycleManager", "LiceCycleManager listener successfully attached to Android");
        }
    }

    public k l(ce.d dVar) {
        this.f7957a.add(dVar);
        return this;
    }

    public k m(ce.d dVar) {
        this.f7957a.remove(dVar);
        return this;
    }

    public void n(zd.k kVar) {
        zd.k kVar2 = f7955e;
        if (kVar2 == kVar) {
            return;
        }
        this.f7959c = this.f7959c || kVar2 == zd.k.Foreground;
        f7955e = kVar;
        j(kVar);
        if (rd.a.f15359i.booleanValue()) {
            de.a.a("LifeCycleManager", "App is now " + kVar);
        }
    }

    @s(androidx.lifecycle.g.a.ON_CREATE)
    public void onCreated() {
        n(this.f7959c ? zd.k.Background : zd.k.Terminated);
    }

    @s(androidx.lifecycle.g.a.ON_DESTROY)
    public void onDestroyed() {
        n(zd.k.Terminated);
    }

    @s(androidx.lifecycle.g.a.ON_PAUSE)
    public void onPaused() {
        n(zd.k.Foreground);
    }

    @s(androidx.lifecycle.g.a.ON_RESUME)
    public void onResumed() {
        n(zd.k.Foreground);
    }

    @s(androidx.lifecycle.g.a.ON_START)
    public void onStarted() {
        n(this.f7959c ? zd.k.Background : zd.k.Terminated);
    }

    @s(androidx.lifecycle.g.a.ON_STOP)
    public void onStopped() {
        n(zd.k.Background);
    }
}
