package s1;

import android.app.PendingIntent;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import e0.p;
import e0.q;

/* JADX INFO: loaded from: classes.dex */
public class c extends q.j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MediaSessionCompat.Token f15405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f15406g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f15407h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PendingIntent f15408i;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f15404e = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f15409j = false;

    @Override // e0.q.j
    public void b(p pVar) {
        a.d(pVar.a(), Build.VERSION.SDK_INT >= 34 ? a.b(b.a(a.a(), this.f15406g, this.f15407h, this.f15408i, Boolean.valueOf(this.f15409j)), this.f15404e, this.f15405f) : a.b(a.a(), this.f15404e, this.f15405f));
    }

    @Override // e0.q.j
    public RemoteViews i(p pVar) {
        return null;
    }

    @Override // e0.q.j
    public RemoteViews j(p pVar) {
        return null;
    }

    public c n(MediaSessionCompat.Token token) {
        this.f15405f = token;
        return this;
    }

    public c o(int... iArr) {
        this.f15404e = iArr;
        return this;
    }

    public c p(boolean z10) {
        return this;
    }
}
