package r;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import e0.j;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f14978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f14979b;

    public static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList<Bundle> f14982c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Bundle f14983d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ArrayList<Bundle> f14984e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public SparseArray<Bundle> f14985f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Bundle f14986g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f14980a = new Intent("android.intent.action.VIEW");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r.a.C0263a f14981b = new r.a.C0263a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f14987h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f14988i = true;

        public b a() {
            if (!this.f14980a.hasExtra("android.support.customtabs.extra.SESSION")) {
                b(null, null);
            }
            ArrayList<Bundle> arrayList = this.f14982c;
            if (arrayList != null) {
                this.f14980a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f14984e;
            if (arrayList2 != null) {
                this.f14980a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f14980a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f14988i);
            this.f14980a.putExtras(this.f14981b.a().a());
            Bundle bundle = this.f14986g;
            if (bundle != null) {
                this.f14980a.putExtras(bundle);
            }
            if (this.f14985f != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f14985f);
                this.f14980a.putExtras(bundle2);
            }
            this.f14980a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f14987h);
            return new b(this.f14980a, this.f14983d);
        }

        public final void b(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            j.b(bundle, "android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f14980a.putExtras(bundle);
        }
    }

    public b(Intent intent, Bundle bundle) {
        this.f14978a = intent;
        this.f14979b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.f14978a.setData(uri);
        f0.a.startActivity(context, this.f14978a, this.f14979b);
    }
}
