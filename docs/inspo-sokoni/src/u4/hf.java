package u4;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public final class hf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k7 f16325a;

    public hf(k7 k7Var) {
        this.f16325a = k7Var;
    }

    public final void a() {
        this.f16325a.zzl().j();
        if (d()) {
            if (e()) {
                this.f16325a.C().f16349y.b(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1L);
                this.f16325a.E().a1("auto", "_cmpx", bundle);
            } else {
                String strA = this.f16325a.C().f16349y.a();
                if (TextUtils.isEmpty(strA)) {
                    this.f16325a.zzj().E().a("Cache still valid but referrer not found");
                } else {
                    long jA = ((this.f16325a.C().f16350z.a() / 3600000) - 1) * 3600000;
                    Uri uri = Uri.parse(strA);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(uri.getPath(), bundle2);
                    for (String str : uri.getQueryParameterNames()) {
                        bundle2.putString(str, uri.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", jA);
                    Object obj = pair.first;
                    this.f16325a.E().a1(obj == null ? "app" : (String) obj, "_cmp", (Bundle) pair.second);
                }
                this.f16325a.C().f16349y.b(null);
            }
            this.f16325a.C().f16350z.b(0L);
        }
    }

    public final void b(String str, Bundle bundle) {
        String string;
        this.f16325a.zzl().j();
        if (this.f16325a.n()) {
            return;
        }
        if (bundle == null || bundle.isEmpty()) {
            string = null;
        } else {
            if (str == null || str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            string = builder.build().toString();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.f16325a.C().f16349y.b(string);
        this.f16325a.C().f16350z.b(this.f16325a.zzb().a());
    }

    public final void c() {
        if (d() && e()) {
            this.f16325a.C().f16349y.b(null);
        }
    }

    public final boolean d() {
        return this.f16325a.C().f16350z.a() > 0;
    }

    public final boolean e() {
        return d() && this.f16325a.zzb().a() - this.f16325a.C().f16350z.a() > this.f16325a.w().y(null, p0.f16648e0);
    }
}
